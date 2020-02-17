package com.test;

public class SQLTest {
    public static void main(String[] args) {
        String user = "123456";
        String sql = "SELECT * from student where user = "+"\'"+user+"\'";
        System.out.println(sql);
    }
}
