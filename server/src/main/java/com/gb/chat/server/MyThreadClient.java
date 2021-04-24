package com.gb.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyThreadClient extends  Thread{

    private Socket clientSocket;

    public MyThreadClient(Socket clientSocket){
        this.clientSocket = clientSocket;

    }
    public void run(){
        try {
             DataInputStream in = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream out = new DataOutputStream( clientSocket.getOutputStream());

              String msg;
            while (true){
                msg = in.readUTF();
             System.out.println(msg);
                out.writeUTF('\n'+msg + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
