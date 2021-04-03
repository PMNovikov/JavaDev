package ru.geekbrains;

import ru.geekbrains.chat.client.ClientChatAdapter;
import ru.geekbrains.server.Server;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        //start Server
        System.out.println("Start server....");
        Thread serverTread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Server();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        serverTread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Start client 1
        System.out.println("Start client 1...");
        Thread clientThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                new ClientChatAdapter("localhost", 8989, "Client 1");
            }
        });
        clientThread1.start();

        //Start client 2
        System.out.println("Start client 2...");
        Thread clientThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                new ClientChatAdapter("localhost", 8989, "Client 2");
            }
        });
        clientThread2.start();

        try {
            serverTread.join();
            clientThread1.join();
            clientThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
