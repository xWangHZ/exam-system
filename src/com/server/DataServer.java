package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DataServer {

    private String name;//姓名

    private int fraction;//分数

    private Socket socket;

    private BufferedReader bufferedReader;

    private PrintWriter printWriter;

    public DataServer(){}

    public DataServer(String name,int fraction){
        this.name = name;
        this.fraction = fraction;
        getMessage();
    }

    //建立socket与服务器连接
    public void getMessage(){
        try {
            socket = new Socket("192.168.2.193",6666);//服务端的地址
            System.out.println(socket);
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(name+"的成绩是"+fraction);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
