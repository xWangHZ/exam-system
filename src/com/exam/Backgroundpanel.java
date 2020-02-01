package com.exam;

import javax.swing.*;
import java.awt.*;

public class Backgroundpanel extends JPanel {

    private Image img;

    public Backgroundpanel(){}

    public Backgroundpanel(Image img){
        this.img = img;
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
}
