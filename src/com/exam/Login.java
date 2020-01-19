package com.exam;

import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame{

    private JTextField user;//用户名框
    private JTextField pass;//密码框

    private JPanel userpanel;//放置用户名
    private JPanel passpanel;//放置密码
    private JPanel userpass;//用户名和密码

    private final Font font = new Font("华文行楷",Font.PLAIN,20);

    public Login(){
        this.setSize(new Dimension(800,600));
        this.setTitle("考试系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//使窗口在中央显示
        this.setLayout(new BorderLayout());
        paneladd();
        this.add(userpass,BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * 添加框到Jpaenl上
     */
    public void paneladd(){
        user = new JTextField("用户名",30);
        pass = new JTextField("密码",30);
        user.setForeground(Color.GRAY);
        pass.setForeground(Color.GRAY);
        passpanel = new JPanel();
        userpanel = new JPanel();
        userpass  = new JPanel();

        user.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(user.getText().trim().equals("用户名")){
                    user.setForeground(Color.BLACK);
                    user.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (user.getText().trim().equals("")) {
                    user.setForeground(Color.GRAY);
                    user.setText("用户名");
                }
            }
        });

        pass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(pass.getText().trim().equals("密码")){
                    pass.setText("");
                    pass.setForeground(Color.BLACK);
                    System.out.println(pass.getClass());
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (pass.getText().trim().equals("")) {
                    pass.setText("密码");
                    pass.setForeground(Color.GRAY);
                    System.out.println(pass.getClass());
                }
            }
        });


        passpanel.add(user);
        userpanel.add(pass);

        user.setFont(font);
        pass.setFont(font);
        userpass.setLayout(new FlowLayout(FlowLayout.CENTER,800,0));
        userpass.add(passpanel);
        userpass.add(userpanel);
    }




}