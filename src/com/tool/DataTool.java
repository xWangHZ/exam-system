package com.tool;

import java.io.File;

public class DataTool {

    private int length = 4;
    private int size = 0;

    private String subname = null;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSize() {
        File file = new File("Paper/"+subname+"/problem/");
        File[] files = file.listFiles();//获取里面的所有文件
        for(File list:files){
            size++;
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DataTool(){};

    public DataTool(String subname){
        this.subname = subname;
    }
}
