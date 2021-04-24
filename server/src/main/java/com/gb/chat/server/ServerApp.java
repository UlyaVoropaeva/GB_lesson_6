package com.gb.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {


    public static void main(String[] args) throws IOException, InterruptedException {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен на порту 8189. Ожидает подключение клиента...");
            Socket socket = serverSocket.accept();

            System.out.println("Клиент подключился");
            MyThreadClient myThreadClient =new MyThreadClient(socket);
            MyThreadServer myThreadServer = new MyThreadServer(socket);

            myThreadClient.start();
            myThreadServer.start();


        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
