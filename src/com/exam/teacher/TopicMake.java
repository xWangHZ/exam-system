package com.exam.teacher;

import com.tool.Backgroundpanel;

import javax.swing.*;
import java.awt.*;

public class TopicMake extends JFrame {

    private final Font font = new Font("宋体",Font.PLAIN,30);//字体
    private final ImageIcon title = new ImageIcon("img/topicmake.png");//背景图片
    private final Backgroundpanel img = new Backgroundpanel(title.getImage(),this);//画出背景图片

//    private JButton[]

    private String user;//用户名
    private String subjects;//科目名称

    private int size = 0;//题目数量
    private int length  = 4;//题目选项

    public TopicMake(){}

    public TopicMake(String user){
        this.user = user;
        this.setTitle(user+"的出题系统");
        this.setSize(new Dimension(1280,1024));
        this.setLocationRelativeTo(null);//使窗口在中央显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        img.imgadd(0,0,1280,1024);
        this.setVisible(true);
    }

    /**
     * 选择科目
     */
    public void showsubjects(){

    }
}
