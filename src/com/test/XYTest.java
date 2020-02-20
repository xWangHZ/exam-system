package com.test;

import com.tool.Backgroundpanel;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;

public class XYTest extends JFrame {
    private final ImageIcon title = new ImageIcon("img/topicmake.png");//背景图片
    private final com.tool.Backgroundpanel img = new Backgroundpanel(title.getImage(),this);//画出背景图片

    private XY xy = new XY(this);

    public XYTest(){
        this.setSize(new Dimension(1280,1024));
        this.setLocationRelativeTo(null);//使窗口在中央显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(xy);
        img.imgadd(0,0,1280,1024);
        xy.setBounds(0,0,1280,1024);
        this.setVisible(true);
    }

    public class XY extends JPanel{
        private JFrame jFrame;
        private int X1 = 0;
        private int X2 = 0;
        private int Y1 = 0;
        private int Y2 = 1024;

        public XY(){}

        public XY(JFrame jFrame){
            super();
            this.jFrame = jFrame;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(int i = 0;i<13;i++){
                g.drawLine(X1,Y1,X2,Y2);
                X1+=100;
                X2+=100;
            }
            X1 = 0;
            Y1 = 0;
            X2 = 1280;
            Y2 = 0;
            for(int i = 0;i<12;i++){
                g.drawLine(X1,Y1,X2,Y2);
                Y1+=100;
                Y2+=100;
            }
        }
    }

    public static void main(String[] args) {
        new XYTest();
    }
}
