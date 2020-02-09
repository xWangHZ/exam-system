package com.tool;

import javax.swing.*;
import java.awt.*;

public class Backgroundpanel extends JPanel {

    private Image img;//图片
    private JFrame jFrame;//窗口

    public Backgroundpanel(){}

    public Backgroundpanel(Image img,JFrame jFrame){
        this.img = img;
        this.jFrame = jFrame;
        this.setOpaque(true);//设置组件不透明
    }

    /**
     * 画出图片
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }

    /**
     * 添加图片
     */
    public void imgadd(int x,int y,int width,int height){
        this.setBounds(x, y, width,height );
        jFrame.add(this);
    }
}
