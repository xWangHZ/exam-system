package com.exam.teacher;

import com.tool.Backgroundpanel;
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

    private JButton newsub;//新建按钮
    private JButton[] jButtons = new JButton[N];//科目按钮

    private int subject_sum = 0;//科目数量


    public SubjectSelect(){}


    /**
     * 构造方法
     * @param name
     */
    public SubjectSelect(String name){
        this.name = name;
        this.setTitle(name+"的出题系统");
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
        newsub = new JButton("添加科目");
        newsub.setFont(new Font("宋体",Font.BOLD,15));
        newsub.setPreferredSize(new Dimension(150,50));
        newsub.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));//设置按钮样式蓝色

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
        newsub.addActionListener(this);
        this.add(newsub);
    }

    /**
     * 进入出题系统
     */
    public void InSystem(String subname){
        this.setVisible(false);
        new TopicMake(name,subname);
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
        if(e.getSource()==newsub){
            int flag = 0;
            newname = JOptionPane.showInputDialog(this,"输入科目", "系统消息", JOptionPane.PLAIN_MESSAGE);
            System.out.println(newname);
            //没有点击取消
            if(newname!=null){
                flag = mySQLTool.setSubject_newname(newname);
                if(flag==1){
                    JOptionPane.showMessageDialog(null,"该科目已存在请重新输入", "系统消息",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"输入成功", "系统消息",JOptionPane.PLAIN_MESSAGE);
                    mySQLTool.createtable(newname);
                    jButtons[subject_sum] = new JButton();
                    jButtons[subject_sum].setText(newname);
                    jButtons[subject_sum].setPreferredSize(new Dimension(150,50));
                    jButtons[subject_sum].setFont(new Font("宋体",Font.BOLD,15));
                    jButtons[subject_sum].addActionListener(this);
                    this.add(jButtons[subject_sum]);
                    subject_sum++;
                    this.revalidate();//刷新界面
                }
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
