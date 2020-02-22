package com.file;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import com.tool.DataTool;

import javax.lang.model.element.NestingKind;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompareAnswer {

    private  DataTool dataTool;

    private int size;//题目数量
    private double fraction = 0;//分数
    private String[] answer;//存放作答答案

    private String subname;//科目名称

    private BufferedReader outanswer;//获取正确答案
    private BufferedReader outfraction;//获取分值


    public CompareAnswer(){}

    public CompareAnswer(String[] answer,String subname){
        this.answer = answer;
        this.subname = subname;
        dataTool = new DataTool(subname);
        size = dataTool.getSize();
        answer = new String[size];
        {
            try {
                outanswer   = new BufferedReader(new FileReader("Paper/"+this.subname+"/answer/answer.txt"));
                outfraction = new BufferedReader(new FileReader("Paper/"+this.subname+"/fraction/fraction.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0;i<size;i++){
            String correctanswer = "";
            String fracitonvalue = "";
            try {
                correctanswer = outanswer.readLine();
                fracitonvalue = outfraction.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(this.answer[i]);
            if(this.answer[i].equals(correctanswer)){
                fraction+=Double.parseDouble(fracitonvalue);
            }
        }
    }

    public double getFraction() {
        return fraction;
    }
}
