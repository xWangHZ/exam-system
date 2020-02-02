package com.exam;

import com.file.GetProblem;
import com.sun.org.apache.bcel.internal.util.ClassSet;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;

public class TopicPanel extends JFrame {

    private final int length = 4;//选项数量
    private final Font font = new Font("宋体",Font.PLAIN,30);//字体
    private final JRadioButton[] option = new JRadioButton[length];//选项数组
    private final ImageIcon title = new ImageIcon("Img/topic.jpg");//背景图片
    private final Backgroundpanel img = new Backgroundpanel(title.getImage());//画出背景图片

    private JLabel problem;//问题

    private ButtonGroup optiongroup;//选项按钮组

    private String user;//用户名

    private JButton last;//上一题
    private JButton next;//下一题
    private JButton ends;//交卷按钮

    private int size;//题目总共数量
    private int now = 1;//现在处在的题目

    private GetProblem getProblem = new GetProblem(now);//获取题目与选项类

    private String problems;//问题

    private String[] options = new String[length];//选项

    public TopicPanel(){}

    public TopicPanel(String user){
        this.user = user;
        this.setTitle(user+"的考试窗口");
        this.setSize(new Dimension(1280,1024));
        this.setLocationRelativeTo(null);//使窗口在中央显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        problemlabeladd();//添加问题
        JRadioButtonadd();//添加单选按钮
        buttonadd();//添加上下题按钮
        imgadd();//添加背景图片
        this.setVisible(true);
    }


    /**
     * 添加问题标签
     */
    public void problemlabeladd(){

        problems = getProblem.getProblems();

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

        options = getProblem.getOptions();

        for(int i = 0;i<length;i++){
            option[i] = new JRadioButton(options[i]);
            option[i].setFont(font);
            option[i].setOpaque(false);//设置透明
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

        ends.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));

        last.setFont(font);
        next.setFont(font);
        ends.setFont(font);

        last.setBounds(200, 800, 200,50);
        next.setBounds(824, 800, 200,50);
        ends.setBounds(1000, 50,  200,50);

        this.add(last);
        this.add(next);
        this.add(ends);
    }

    /**
     * 添加背景图片
     */
    public void imgadd(){
        img.setBounds(0,0,1280,1024);
        this.add(img);
    }
}