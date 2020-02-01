package com.test;

import javax.swing.*;
import java.awt.*;

public class JFrameTest extends JFrame {

    private JButton login;//登录


    private final ImageIcon title = new ImageIcon("Img/title.jpg");
    private final JPanel titlepanel = new JPanel();
    private final JLabel titlelabel = new JLabel(title);

    private JLayeredPane jLayeredPane = new JLayeredPane();//分层

    public JFrameTest(){
        this.setLayeredPane(jLayeredPane);
        this.setSize(new Dimension(800,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginexitadd();
        imageadd();
        this.setVisible(true);
    }

    /**
     * 添加按钮
     */
    public void loginexitadd(){
        login = new JButton("登录");
        login.setBounds(100,100,200,200);
        jLayeredPane.add(login,BorderLayout.CENTER,300);
    }

    /**
     * 添加图片
     */
    public void imageadd(){

        titlepanel.setBounds(0,-10,title.getIconWidth(),title.getIconHeight());
        titlepanel.add(titlelabel);
        jLayeredPane.add(titlepanel,BorderLayout.NORTH,100);
    }

    public static void main(String[] args) {
        new JFrameTest();
    }
}
