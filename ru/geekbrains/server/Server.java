package ru.geekbrains.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server() {
        try {
            serverSocket = new ServerSocket(8989);
            System.out.println("Server is running on and waiting for a connection...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    try {
                        System.out.println("Please input message...");
                        out.writeUTF("SERVER: " + scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Transmission closed.");
                        break;
                    }
                }
            })
                    .start();


            while (true) {
                try {
                    String message = "ECHO: " + in.readUTF();
                    out.writeUTF(message);
                    System.out.println(message);
                } catch (EOFException e) {
                    System.out.println("Connection closed.");
                    break;
                }
            }
        } catch (SocketException e) {
            System.out.println("Client disconnected.");

        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }
}
