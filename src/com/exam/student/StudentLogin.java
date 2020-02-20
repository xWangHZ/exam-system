package com.exam.student;

import com.tool.Backgroundpanel;
import com.tool.LinkMySQLTool;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentLogin extends JFrame{

    private final Font font = new Font("华文行楷",Font.PLAIN,30);//字体
    private final Font passfont = new Font("华文行楷",Font.PLAIN,20);//密码字体
    private final ImageIcon title = new ImageIcon("img/title.jpg");//背景图片
    private final Backgroundpanel img = new Backgroundpanel(title.getImage(),this);//添加图片类
    private final LinkMySQLTool linkMySQLTool = new LinkMySQLTool();//连接数据库

    private JTextField user;//用户名
    private JTextField pass;//密码


    private JButton login;//登录
    private JButton exit;//退出

    public StudentLogin(){

        this.setTitle("登陆系统");
        this.setSize(new Dimension(800,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);//使窗口在中央显示
        textadd();
        buttonadd();
        imgadd();
        /**
         * 登录
         */
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                judge(user.getText(),pass.getText());
            }
        });
        /**
         * 退出
         */
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /**
         * 回车登录
         */
        user.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    judge(user.getText(),pass.getText());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        /**
         * 回车登录
         */
        pass.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    judge(user.getText(),pass.getText());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.setVisible(true);
    }

    /**
     * 添加用户名和密码框
     */
    public void textadd(){
        user = new JTextField(20);
        pass = new JPasswordField(20);

        user.setFont(font);
        pass.setFont(passfont);

        user.setBounds(180, 100, 400,40);
        pass.setBounds(180, 150, 400,40);

        this.add(user);
        this.add(pass);
    }

    /**
     * 添加背景图
     */
    public void imgadd(){
        img.setBounds(0,-10,800,600);
        this.add(img);
    }

    /**
     *登录按钮
     */
     public void buttonadd(){
         login = new JButton("登录");
         exit  = new JButton("退出");

         login.setFont(font);
         exit.setFont(font);

         login.setBounds(190,400,160,70);
         exit.setBounds(420,400,160,70);

         login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));//设置按钮样式绿色
         exit.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));//设置按钮样式红色

         this.add(login);
         this.add(exit);
     }

    /**
     * 登录验证
     */
    public void judge(String user, String pass){

        int flag = linkMySQLTool.studentlogin(user,pass);

        switch(flag){
            case 1:{
                JOptionPane.showMessageDialog(null,"登录成功", "我是一个提示框", JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                new TopicReply(linkMySQLTool.getStudent_name());
                break;
            }
            case 2:{
                JOptionPane.showMessageDialog(null,"密码错误", "我是一个提示框", JOptionPane.ERROR_MESSAGE);
                break;
            }
            case 0:{
                JOptionPane.showMessageDialog(null,"用户不存在", "我是一个提示框", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }
}