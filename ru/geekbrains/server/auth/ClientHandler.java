package ru.geekbrains.server.auth;

import ru.geekbrains.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 1. Unique login (accept)
 * 2. Unknown user login (reject)
 * 3. Already logged-in (reject)
 * 4. Receive message to itself
 * 5. Broadcast message upon success login + basic messages
 */
public class ClientHandler {
    private final Server server;
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private String name;
    private int userID;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    listen();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    private void listen() {
        try {
            doAuth();
            readMessage();

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void AuthTimeOut(){
        try {
            Thread.sleep(120000);
            if (this.name == null){
                try {
                    out.writeUTF("SRV: Authorisation time out.");
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAuth() throws IOException {
        Thread authTread = Thread.currentThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                AuthTimeOut();
            }
        }).start();

        while (true) {
            /**
             * Auth Pattern
             * -auth login password
             */
            String input = in.readUTF();
            String[] credentials = input.split("\\s");
            if (credentials[0].equals("-auth") && credentials.length == 3) {

                AuthEntry maybeAuthEntry = server.getAuthenticationService()
                        .findUserByCredentials(credentials[1], credentials[2]);
                if (maybeAuthEntry != null) {
                    if (server.isNicknameFree(maybeAuthEntry.getNickname())) {
                        sendMessage("CMD: auth is ok");
                        name = maybeAuthEntry.getNickname();
                        userID = maybeAuthEntry.getId();
                        server.broadcast(name + " logged in.");
                        server.subscribe(this);
                        return;
                    } else {
                        sendMessage("Current user is already logged-in.");
                    }
                } else {
                    sendMessage("Unknown user. Incorrect login/password");
                }
            } else {
                sendMessage("Invalid authentication request.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();
            if (message.startsWith("\\"))
            {
                if (message.startsWith("\\w")) {
                    sendPrivateMessage(message);
                } else if (message.startsWith("\\exit")){
                    exitFromChat();
                    break;
                } else if (message.startsWith("\\rename")){
                    changeNickName(message);
                }
            } else {
                server.broadcast(name + ": " + message);
            }
        }
    }

    private void changeNickName(String message){
        String[] params = message.split("\\s");
        if (params.length == 2){
            server.changeNickName(userID, params[1]);
            name = params[1];
        } else {
            sendMessage("SRV: For change NickName send \\\\rename {NewNickName}");
        }

    }

    public void exitFromChat(){
        server.unsubscribe(name);
        server.broadcast("SRV: " + name + " left chat.");
    }

    public void sendPrivateMessage(String message){
        String[] params = message.split("\\s");
        if (params.length >= 2) {
            if (server.isNicknameFree(params[1])) {
                sendMessage("SRV: User " + params[1] + " is not connected.");
            } else {
                String privateMessage = "Private Message from " + name + ": ";
                for (int i = 2; i < params.length; i++) {
                    privateMessage += " " + params[i];
                }
                server.sendPrivateMessage(params[1], privateMessage);
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
