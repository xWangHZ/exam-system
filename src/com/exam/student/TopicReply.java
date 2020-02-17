package com.exam.student;

import com.tool.Backgroundpanel;
import com.tool.DataTool;
import com.file.CompareAnswer;
import com.file.ObtainProblem;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopicReply extends JFrame{

    private final DataTool dataTool = new DataTool();

    private final int length = dataTool.getLength();//选项数量
    private final Font font = new Font("宋体",Font.PLAIN,30);//字体
    private final JRadioButton[] option = new JRadioButton[length];//选项数组
    private final ImageIcon title = new ImageIcon("img/topicpanel.jpg");//背景图片
    private final Backgroundpanel img = new Backgroundpanel(title.getImage(),this);//画出背景图片

    private JLabel problem;//问题
    private JLabel fractionlabel;//存放分数

    private ButtonGroup optiongroup;//选项按钮组

    private String name;//姓名

    private JButton last;//上一题
    private JButton next;//下一题
    private JButton ends;//交卷按钮

    private int size = dataTool.getSize();//题目总共数量
    private int now = 1;//现在处在的题目
    private int fraction;//分数

    private ObtainProblem obtainProblem = new ObtainProblem(now);//获取题目与选项类
    private CompareAnswer compareAnswer;//判题类

    private String problems;//问题

    private String[] options = new String[length];//选项

    private int[] answer = new int[length];//存放每道题的答案

    public TopicReply(){}

    public TopicReply(String name){
        this.name = name;
        this.setTitle(name+"的考试窗口");
        this.setSize(new Dimension(1280,1024));
        this.setLocationRelativeTo(null);//使窗口在中央显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        problemlabeladd();//添加问题
        JRadioButtonadd();//添加单选按钮
        buttonadd();//添加上下题按钮
        img.imgadd(0,0,1280,1024);//添加图片
        this.setVisible(true);
    }


    /**
     * 添加问题标签
     */
    public void problemlabeladd(){

        problems = obtainProblem.getProblems();

        problem = new JLabel(problems);

        problem.setFont(font);

        problem.setBounds(100,100,800,100);
        this.add(problem);
    }


    /**
     * 添加单选框
     */
    public void JRadioButtonadd(){
        optiongroup = new ButtonGroup();

        options = obtainProblem.getOptions();

        for(int i= 0;i<length;i++){
            option[i] = new JRadioButton(options[i]);
            option[i].setFont(font);
            option[i].setOpaque(false);//设置透明
            option[i].setName(i+"");//给单选框添加名字
            option[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0;i<length;i++){
                        if(option[i].isSelected()){
                            answer[now-1] = i+1;//将选中的答案放入数组中
                            break;
                        }
                    }
                }
            });
            optiongroup.add(option[i]);
            option[i].setBounds(100,200+i*50,1000,50);
            this.add(option[i]);
        }
    }

    /**
     * 创建按钮
     */
    public void buttonadd(){
        last = new JButton("上一题");
        next = new JButton("下一题");
        ends = new JButton("交卷");
        fractionlabel = new JLabel();

        fractionlabel.setVisible(false);
        fractionlabel.setOpaque(false);


        ends.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));

        last.setFont(font);
        next.setFont(font);
        ends.setFont(font);
        fractionlabel.setFont(font);

        last.setBounds(200, 800, 200,50);
        next.setBounds(824, 800, 200,50);
        ends.setBounds(1000,50,  200,50);
        fractionlabel.setBounds(550,400,300,100);



        //点击上一题
        last.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(now==1){
                    JOptionPane.showMessageDialog(null,
                            "已经没有了呢",
                            "我是系统提醒",
                            JOptionPane.ERROR_MESSAGE,
                            new ImageIcon("img/stop.png"));
                }
                else{
                    now--;
                    obtainProblem.setLen(now);//增加题号
                    obtainProblem.problem();//获取文件
                    problems = obtainProblem.getProblems();//得到题目
                    options  = obtainProblem.getOptions();//得到选项
                    for(int i = 0;i<length;i++){
                        option[i].setText(options[i]);
                    }
                    problem.setText(problems);
                }
            }
        });

        //点击下一题
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(now==size){
                    JOptionPane.showMessageDialog(null,
                            "已经没有了呢",
                            "我是系统提醒",
                            JOptionPane.ERROR_MESSAGE,
                            new ImageIcon("img/stop.png"));
                }
                else{
                    now++;
                    obtainProblem.setLen(now);//增加题号
                    obtainProblem.problem();//获取文件
                    problems = obtainProblem.getProblems();//得到题目
                    options  = obtainProblem.getOptions();//得到选项
                    for(int i = 0;i<length;i++){
                        option[i].setText(options[i]);
                    }
                    problem.setText(problems);
                }
            }
        });


        //点击交卷
        ends.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                //判断是否有为完成题目
                for(int i = 0;i<size;i++){
                    if (answer[i]==0){
                        flag = false;
                    }
                }
                if(flag){
                    JOptionPane.showMessageDialog(null,
                            "你确定交卷嘛？",
                            "我是系统提醒",
                            JOptionPane.ERROR_MESSAGE,
                            new ImageIcon("img/stop.png"));
                    compareAnswer = new CompareAnswer(answer);
                    ends.setVisible(false);
                    next.setVisible(false);
                    last.setVisible(false);
                    problem.setVisible(false);
                    for(int i = 0;i<length;i++){
                        option[i].setVisible(false);
                    }
                    fraction = compareAnswer.getFraction();//获取分数
                    fractionlabel.setText(name+"的分数是"+fraction+"");//写分数
                    fractionlabel.setVisible(true);//显示分数
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "还有题目没有作答",
                            "我是系统提醒",
                            JOptionPane.ERROR_MESSAGE,
                            new ImageIcon("img/noend.jpg"));
                }
            }
        });

        this.add(last);
        this.add(next);
        this.add(ends);
        this.add(fractionlabel);
    }
}
