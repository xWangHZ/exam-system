package com.test;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.Color;
import javax.swing.*;

public class ColorTest {
    public static void main(String[] args) {
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;//普通不透明
        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);//取消设置的显示
        }
        catch(Exception e)
        {
            //TODO exception
        }
        JFrame frame=new JFrame("背景色测试");
        frame.setLocation(150,250);
        frame.setSize(800,600);
        frame.setBackground(Color.blue);
//        frame.getContentPane().setVisible(true);
        frame.setVisible(true);
    }
}