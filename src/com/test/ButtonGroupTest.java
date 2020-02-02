package com.test;

import javafx.scene.control.ButtonType;

import javax.swing.*;
import java.awt.*;

public class ButtonGroupTest extends JFrame {

    private JRadioButton Abutton;
    private JRadioButton Bbutton;
    private JRadioButton Cbutton;
    private JRadioButton Dbutton;

    private ButtonGroup ABCD;

    private JPanel ABCDpanel;

    public ButtonGroupTest(){
        this.setSize(new Dimension(800,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        ABCDadd();
        this.setVisible(true);
    }

    public void ABCDadd(){
        Abutton = new JRadioButton("选项A",false);
        Bbutton = new JRadioButton("选项B",false);
        Cbutton = new JRadioButton("选项C",false);
        Dbutton = new JRadioButton("选项D",false);

        ABCD = new ButtonGroup();

        ABCDpanel = new JPanel();

        ABCD.add(Abutton);
        ABCD.add(Bbutton);
        ABCD.add(Cbutton);
        ABCD.add(Dbutton);

        ABCDpanel.add(Abutton);
        ABCDpanel.add(Bbutton);
        ABCDpanel.add(Cbutton);
        ABCDpanel.add(Dbutton);

        this.add(ABCDpanel,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new ButtonGroupTest();
    }

}
