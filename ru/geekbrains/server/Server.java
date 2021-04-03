package ru.geekbrains.server;

import ru.geekbrains.server.auth.AuthenticationService;
import ru.geekbrains.server.auth.AuthenticationServiceSQL;
import ru.geekbrains.server.auth.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. Multiclient
 * 2. Login to chat (auth)
 * 3. Execute constraints (Unique name, already existing client, etc.)
 * 4. IN\OUT messages + broadcast
 */
public class Server {
    private final ServerSocket serverSocket;
    private final AuthenticationServiceSQL authenticationService;
    private final Set<ClientHandler> handlers;

    public Server() throws SQLException, ClassNotFoundException {
        authenticationService = new AuthenticationServiceSQL();
        handlers = new HashSet<>();
        try {
            serverSocket = new ServerSocket(8989);
            init();
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    private void init() throws IOException {
        while (true) {
            System.out.println("Server is waiting for a connection...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);
            new ClientHandler(this, client);
        }
    }

    public AuthenticationServiceSQL getAuthenticationService() {
        return authenticationService;
    }

    public synchronized boolean isNicknameFree(String nickname) {
        for (ClientHandler handler : handlers) {
            if (handler.getName().equals(nickname)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void broadcast(String message) {
        for (ClientHandler handler : handlers) {
            handler.sendMessage(message);
        }
    }

    public void sendPrivateMessage(String nickname, String message){
        for (ClientHandler handler: handlers){
            if (handler.getName().equals(nickname)){
                handler.sendMessage(message);
            }
        }
    }

    public void unsubscribe(String nickname){
        for (ClientHandler handler: handlers){
            if (handler.getName().equals(nickname)){
                unsubscribe(handler);
                break;
            }
        }
    }

    public void changeNickName(int userID, String newNickName){
       authenticationService.changeNickName(userID, newNickName);

    }

    public synchronized void subscribe(ClientHandler handler) {
        handlers.add(handler);
    }

    public synchronized void unsubscribe(ClientHandler handler) {
        handlers.remove(handler);
    }
}
