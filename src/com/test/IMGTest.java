package com.test;


import java.awt.*;

import javax.swing.*;


public class IMGTest extends JFrame {
    //创建背景面板。
    Backgroundpanel bgp;

    //创建一个按钮，用来证明我们的确是创建了背景图片，而不是一张图片。
    JButton jb;

    public static void main(String[] args) {
        new IMGTest();
    }

    public IMGTest() {
        //不采用任何布局方式。
        this.setLayout(null);

        bgp = new Backgroundpanel((new ImageIcon("Img/title.jpg")).getImage());
        bgp.setBounds(0, 0, 800, 600);

        //创建按钮
        jb = new JButton("测试按钮");
        jb.setBounds(100, 100, 260, 30);
        this.add(jb);
        this.add(bgp);

        this.setSize(800, 600);
        this.setLocation(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Backgroundpanel extends JPanel {

    private Image img;

    public Backgroundpanel() {
    }

    public Backgroundpanel(Image img) {
        this.img = img;
        this.setOpaque(true);//设置组件不透明
    }

    /**
     * 画出图片
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}