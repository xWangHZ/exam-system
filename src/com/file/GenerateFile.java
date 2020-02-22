package com.file;


import com.tool.LinkMySQLTool;
import com.tool.Table;
import javafx.scene.control.Tab;

import java.io.*;

public class GenerateFile {

    private final LinkMySQLTool linkMySQLTool = new LinkMySQLTool();

    private final int N = 1000;

    private String subname;//科目名字

    private int len = 0;//题目数量

    private File subfile;//科目文件夹
    private File topicfile;//问题
    private File answerfile;//答案
    private File scorefile;//分值

    private BufferedWriter answer;//答案文件
    private BufferedWriter No;//问题文件
    private BufferedWriter fraction;//分值文件

    private Table[] tables = new Table[N];

    public GenerateFile(){}

    public GenerateFile(String subname){
        this.subname = subname;

        subfile    = new File("Paper/"+subname);
        topicfile  = new File("Paper/"+subname+"/problem");
        answerfile = new File("Paper/"+subname+"/answer");
        scorefile  = new File("Paper/"+subname+"/fraction");

        if(!subfile.exists())       subfile.mkdir();
        if(!topicfile.exists())     topicfile.mkdir();
        if(!answerfile.exists())    answerfile.mkdir();
        if(!scorefile.exists())     scorefile.mkdir();

        tables = linkMySQLTool.getTables(subname);
        len = linkMySQLTool.tablelen(subname);
        answertxt();
        fractiontxt();
        Notxt();
    }

    /**
     * 创建分数文件
     */
    public void answertxt(){
        try {
            answer = new BufferedWriter(new FileWriter("Paper/"+subname+"/answer/answer.txt"));
            for(int i = 0;i<len;i++){
                answer.write(tables[i].getAnswer());
                System.out.println(tables[i].getAnswer());
                answer.newLine();//输入换行符由系统决定
                answer.flush();//将缓冲区中全部输入
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建分值文件
     */
    public void fractiontxt(){
        try {
            fraction = new BufferedWriter(new FileWriter("Paper/"+subname+"/fraction/fraction.txt"));
            for(int i = 0;i<len;i++){
                fraction.write(tables[i].getScore()+"");
                fraction.newLine();
                fraction.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建问题文件
     */
    public void Notxt(){
        for(int i = 0;i<len;i++){
            try {
                No = new BufferedWriter(new FileWriter("Paper/"+subname+"/problem/"+tables[i].getNo()+".txt"));
                No.write(tables[i].getTopic());
                No.newLine();
                No.flush();
                No.write(tables[i].getA());
                No.newLine();
                No.flush();
                No.write(tables[i].getB());
                No.newLine();
                No.flush();
                No.write(tables[i].getC());
                No.newLine();
                No.flush();
                No.write(tables[i].getD());
                No.newLine();
                No.flush();
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
