package com.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class BackstageServer {

    private HashSet<Socket> clients = new HashSet<Socket>();//存放发送来的分数

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public BackstageServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(6666);//建立Socket
            while(true){
                Socket socket = serverSocket.accept();
                clients.add(socket);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
