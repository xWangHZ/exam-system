package com.exam.teacher;

import com.tool.Backgroundpanel;
import com.tool.LinkMySQLTool;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopicMake extends JFrame implements FocusListener,ActionListener {

    private final Font font = new Font("宋体",Font.PLAIN,30);//字体
    private final ImageIcon title = new ImageIcon("img/topicmake.png");//背景图片
    private final Backgroundpanel img = new Backgroundpanel(title.getImage(),this);//画出背景图片
    private final LinkMySQLTool linkMySQLTool = new LinkMySQLTool();//连接数据库类

    private String name;//姓名
    private String subname;//科目名称

    private int now = 1;//题号

    private JButton last;//上一题
    private JButton next;//下一题
    private JButton ends;//交卷按钮

    private JTextField No;//题号
    private JTextField score;//分值
    private JTextField answer;//答案

    private JTextArea topic;//问题栏
    private JTextArea a;//选项a栏
    private JTextArea b;//选项b栏
    private JTextArea c;//选项c栏
    private JTextArea d;//选项d栏

    private JScrollPane topicpane;//滚动问题栏
    private JScrollPane apane;//滚动a选项
    private JScrollPane bpane;//滚动b选项
    private JScrollPane cpane;//滚动c选项
    private JScrollPane dpane;//滚动c选项


    public TopicMake(){}

    public TopicMake(String name,String subname){
        this.name = name;
        this.subname = subname;
        this.setTitle(subname+"老师——"+name+"的出题系统");
        this.setSize(new Dimension(1280,1024));
        this.setLocationRelativeTo(null);//使窗口在中央显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        buttonadd();
        textfieldadd();
        textadd();
        img.imgadd(0,0,1280,1024);
        this.setVisible(true);
    }

    /**
     * 添加按钮
     */
    public void buttonadd() {
        last = new JButton("上一题");
        next = new JButton("下一题");
        ends = new JButton("完成");

        next.addActionListener(this);

        ends.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));

        last.setFont(font);
        next.setFont(font);
        ends.setFont(font);

        last.setBounds(200, 800, 200, 50);
        next.setBounds(824, 800, 200, 50);
        ends.setBounds(1000, 50, 200, 50);

        this.add(last);
        this.add(next);
        this.add(ends);
    }

    /**
     * 添加三个文本框
     */
    public void textfieldadd(){

        No = new JTextField("题号:");
        score = new JTextField("分值:");
        answer = new JTextField("答案:");

        No.setFont(font);
        score.setFont(font);
        answer.setFont(font);

        No.setBounds(100,100,100,50);
        score.setBounds(230,100,100,50);
        answer.setBounds(360,100,100,50);

        No.addFocusListener(this);
        score.addFocusListener(this);
        answer.addFocusListener(this);

        this.add(No);
        this.add(score);
        this.add(answer);
    }

    /**
     * 添加五个文本栏
     */
    public void textadd(){
        topic = new JTextArea("题目:");
        a = new JTextArea("选项A:");
        b = new JTextArea("选项B:");
        c = new JTextArea("选项C:");
        d = new JTextArea("选项D:");
        topicpane = new JScrollPane(topic);
        apane = new JScrollPane(a);
        bpane = new JScrollPane(b);
        cpane = new JScrollPane(c);
        dpane = new JScrollPane(d);

        topic.setFont(font);
        a.setFont(font);
        b.setFont(font);
        c.setFont(font);
        d.setFont(font);

        topic.setLineWrap(true);//自动换行
        a.setLineWrap(true);
        b.setLineWrap(true);
        c.setLineWrap(true);
        d.setLineWrap(true);

        topic.addFocusListener(this);
        a.addFocusListener(this);
        b.addFocusListener(this);
        c.addFocusListener(this);
        d.addFocusListener(this);

        topicpane.setBounds(40,350,1140,90);
        apane.setBounds(40, 450,500,90);
        bpane.setBounds(680,450,500,90);
        cpane.setBounds(40, 550,500,90);
        dpane.setBounds(680,550,500,90);

        topicpane.setOpaque(false);
        apane.setOpaque(false);
        bpane.setOpaque(false);
        cpane.setOpaque(false);
        dpane.setOpaque(false);
        topic.setOpaque(false);
        a.setOpaque(false);
        b.setOpaque(false);
        c.setOpaque(false);
        d.setOpaque(false);

        this.add(topicpane);
        this.add(apane);
        this.add(bpane);
        this.add(cpane);
        this.add(dpane);
    }

    /**
     * 获得焦点
     * @param e
     */
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==No){
            if(No.getText().equals("题号:")){
                No.setText("");
            }
        }
        if(e.getSource()==score){
            if(score.getText().equals("分值:")){
                score.setText("");
            }
        }
        if(e.getSource()==answer){
            if(answer.getText().equals("答案:")){
                answer.setText("");
            }
        }
        if(e.getSource()==topic){
            if(topic.getText().equals("题目:")){
                topic.setText("");
            }
        }
        if(e.getSource()==a){
            if(a.getText().equals("选项A:")){
                a.setText("");
            }
        }
        if(e.getSource()==b){
            if(b.getText().equals("选项B:")){
                b.setText("");
            }
        }
        if(e.getSource()==c){
            if(c.getText().equals("选项C:")){
                c.setText("");
            }
        }
        if(e.getSource()==d){
            if(d.getText().equals("选项D:")){
                d.setText("");
            }
        }
    }

    /**
     * 失去焦点
     * @param e
     */
    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource()==No){
            if(No.getText().equals("")){
                No.setText("题号:");
            }
        }
        if(e.getSource()==score){
            if(score.getText().equals("")){
                score.setText("分值:");
            }
        }
        if(e.getSource()==answer){
            if(answer.getText().equals("")){
                answer.setText("答案:");
            }
        }
        if(e.getSource()==topic){
            if(topic.getText().equals("")){
                topic.setText("题目:");
            }
        }
        if(e.getSource()==a){
            if(a.getText().equals("")){
                a.setText("选项A:");
            }
        }
        if(e.getSource()==b){
            if(b.getText().equals("")){
                b.setText("选项B:");
            }
        }if(e.getSource()==c){
            if(c.getText().equals("")){
                c.setText("选项C:");
            }
        }if(e.getSource()==d){
            if(d.getText().equals("")){
                d.setText("选项D:");
            }
        }
    }

    /**
     * 单击事件
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            linkMySQLTool.settopictableadd(Integer.parseInt(No.getText()),topic.getText(),a.getText(),b.getText(),c.getText(),d.getText(),answer.getText(),score.getText(),subname);
            now++;
            No.setText(now+"");
        }
    }
}
