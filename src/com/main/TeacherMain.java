package com.main;

import com.exam.teacher.TeacherLogin;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;

public class TeacherMain {
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
        new TeacherLogin();
    }
}
