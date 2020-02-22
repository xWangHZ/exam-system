package com.exam.student;

import com.exam.teacher.TopicMake;
import com.tool.LinkMySQLTool;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectSelect extends JFrame implements ActionListener {

    private final int N = 100;

    private final LinkMySQLTool mySQLTool = new LinkMySQLTool();

    private String name;//姓名
    private String newname = null;//新建科目的名称

    private JButton[] jButtons = new JButton[N];//科目按钮

    private int subject_sum = 0;//科目数量


    public SubjectSelect(){}


    /**
     * 构造方法
     * @param name
     */
    public SubjectSelect(String name){
        this.name = name;
        this.setTitle(name+"的考试系统");
        this.setSize(800,600);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//使窗口在中央显示
        SubjectPaneladd();
        this.setVisible(true);
    }


    /**
     * 添加所有的科目按钮
     */
    public void SubjectPaneladd(){
        subject_sum = mySQLTool.getSubject_sum();//科目数量
        String[] subject_name = mySQLTool.getSubject_name();//每个科目的名称
        for(int i = 0;i<subject_sum;i++){
            jButtons[i] = new JButton();
            jButtons[i].setText(subject_name[i]);
            jButtons[i].setPreferredSize(new Dimension(150,50));
            jButtons[i].setFont(new Font("宋体",Font.BOLD,15));
            jButtons[i].addActionListener(this);
        }
        ThreadJbuttonAdd threadJbuttonAdd = new ThreadJbuttonAdd(this);
        Thread thread = new Thread(threadJbuttonAdd);
        thread.start();
    }

    /**
     * 进入考试系统
     */
    public void InSystem(String subname){
        this.setVisible(false);
        System.out.println(subname);
        new TopicReply(name,subname);
    }

    /**
     * 单击事件
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i<subject_sum;i++){
            if(e.getSource()==jButtons[i]){
                InSystem(jButtons[i].getText());
            }
        }
    }

    /**
     * 输出按钮
     */
    public class ThreadJbuttonAdd extends Thread{

        private JFrame jFrame;
        public ThreadJbuttonAdd() {}

        public ThreadJbuttonAdd(JFrame jFrame){
            this.jFrame = jFrame;
        }

        @Override
        public void run() {
            for(int i = 0;i<subject_sum;i++){
                jFrame.revalidate();
                jFrame.add(jButtons[i]);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
