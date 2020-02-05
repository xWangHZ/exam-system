package com.file;

import com.data.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class CompareAnswer {

    private final Data data = new Data();

    private int size = data.getSize();//题目数量
    private int fraction = 0;//分数
    private int[] answer = new int[size];//存放作答答案

    private BufferedReader outanswer;//获取正确答案
    private BufferedReader outfraction;//获取分值

    {
        try {
            outanswer   = new BufferedReader(new FileReader("answer/answer.txt"));
            outfraction = new BufferedReader(new FileReader("fraction/fraction.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CompareAnswer(){}

    public CompareAnswer(int[] answer){
        System.out.println("123");
        this.answer = answer;
        for(int i = 0;i<size;i++){
            String correctanswer = "";
            String fracitonvalue = "";
            try {
                correctanswer = outanswer.readLine();
                fracitonvalue = outfraction.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(answer[i]==Integer.parseInt(correctanswer)){
                fraction+=Integer.parseInt(fracitonvalue);
            }
        }
    }

    public int getFraction() {
        return fraction;
    }
}
