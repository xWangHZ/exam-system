package com.tool;

import java.sql.*;

public class LinkMySQLTool {

    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/exam-system?useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "root";

    private Connection connection = null;
    private Statement  statement  = null;
    private ResultSet  resultSet  = null;

    private String sql = null;

    private String student_name = null;

    public LinkMySQLTool(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            statement  = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据库获取用户名密码姓名并进行判断
     * @param user
     * @param pass
     * @return
     */

    public int Login(String user,String pass){
        String student_user = null;
        String student_pass = null;
        sql = "SELECT * from student where user = "+"\'"+user+"\'";
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                student_user = resultSet.getString("user");
                student_pass = resultSet.getString("pass");
                student_name = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user.equals(student_user)){
            if(pass.equals(student_pass)){
                return 1;//登陆成功
            }
            else{
                return 2;//密码错误
            }
        }
        return 0;//用户名不存在
    }

    /**
     * 返回姓名
     */
    public String getStudent_name() {
        return student_name;
    }
}
