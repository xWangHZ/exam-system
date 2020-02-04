package com.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ObtainProblem {

    private final int length = 4;

    private BufferedReader output;//读文件

    private String url;//文件路径
    private String problems;//问题

    private String[] options = new String[length];//选项

    private int len = 0;

    public ObtainProblem(){}

    public ObtainProblem(int len){
        this.len = len;
        problem();
    }

    public void problem(){
        this.url = "problem/"+len+".txt";
        try {
            output = new BufferedReader(new FileReader(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            problems = output.readLine();//读取问题
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<4;i++){
            try {
                options[i] = output.readLine();//读取四个选项
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLen(int len){
        this.len = len;
    }

    public String getProblems() {
        return problems;
    }

    public String[] getOptions() {
        return options;
    }
}
