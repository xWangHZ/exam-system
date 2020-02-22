package com.tool;

import javax.print.DocFlavor;
import java.sql.*;

public class LinkMySQLTool {

    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/exam-system?useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "root";

    private final String oblique = "\'";
    private final String newtable = "(id int not null,no int not null,topic varchar(256) not null,A varchar(256) not null,B varchar(256) not null,C varchar(256) not null,D varchar(256) not null,answer varchar(256) not null,score double not null);";
    private final String primary = " primary key (id);";

    private final int N = 1000;

    private Connection connection = null;
    private Statement  statement  = null;
    private ResultSet  resultSet  = null;

    private String sql = null;

    private String student_name = null;
    private String teacher_name = null;
    private String subject_newname = null;
    private String subject_name = null;

    private int tableid = 1;

    private Table[] tables = new Table[N];

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
     * 从学生数据库获取用户名密码姓名并进行判断
     * @param user
     * @param pass
     * @return
     */

    public int studentlogin(String user,String pass){
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
     *从老师数据库中通过用户名密码进行判断
     */
    public int teacherlogin(String user,String pass){
        String teacher_user = null;
        String teacher_pass = null;
        sql = "SELECT * from teacher where user = "+oblique+user+oblique;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                teacher_user = resultSet.getString("user");
                teacher_pass = resultSet.getString("pass");
                teacher_name = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user.equals(teacher_user)){
            if(pass.equals(teacher_pass)){
                return 1;//登陆成功
            }
            else{
                return 2;//密码错误
            }
        }
        return 0;//用户名不存在
    }

    /**
     * 返回用户姓名
     */
    public String getStudent_name() {
        return student_name;
    }

    /**
     * 返回老师姓名
     */
    public String getTeacher_name() {
        return teacher_name;
    }

    /**
     * 返回科目数量
     * @return
     */
    public int getSubject_sum(){
        sql = "SELECT * from subject";
        int subject_sum = 0;
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                subject_sum++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject_sum;
    }

    /**
     * 返回每个科目的名称
     */
    public String[] getSubject_name(){
        sql = "SELECT name FROM subject";
        String[] subject_name = new String[getSubject_sum()];
        int i = 0;
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                subject_name[i] = resultSet.getString("name");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject_name;
    }

    /**
     * 新建科目
     */
    public int setSubject_newname(String subject_newname){
        this.subject_newname = subject_newname;
        int subjcet_newid = 0;
        sql = "SELECT id from subject";
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                subjcet_newid = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        subjcet_newid++;//编号到下一个
        sql = "INSERT INTO subject (id, name) VALUES ("+subjcet_newid+","+oblique+subject_newname+oblique+")";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            return 1;
        }
        return 0;
    }

    /**
     * 创建科目数据表
     */
    public void createtable(String subject_name){
        this.subject_name = subject_name;
        sql = "create table "+"`"+subject_name+"`"+newtable;
        try {
            statement.executeUpdate(sql);
            sql = "alter table "+"`"+subject_name+"`"+"add constraint "+subject_name+"_primary"+primary;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableid = 0;
    }

    /**
     * 将题目信息写入对应科目的数据表
     */
    public void settopictableadd(int No,String topic,String a,String b,String c,String d,String answer,double score,String tablename){
        sql = "INSERT INTO "+tablename+" (id, no, topic, A, B, C, D, answer, score) VALUES ("+tableid+","+No+","+oblique+topic+oblique+","+oblique+a+oblique+","+oblique+b+oblique+","+oblique+c+oblique+","+oblique+d+oblique+","+oblique+answer+oblique+","+score+")";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断表中是否有数据
     * @param tablename
     * @return
     */
    public boolean judgedata(String tablename){
        sql = "SELECT * FROM "+tablename;
        try {
            resultSet =  statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 返回题目数量
     */
    public int tablelen(String tablename){
        int len = 0;
        sql = "SELECT * FROM "+tablename;
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                len++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return len;
    }

    /**
     * 返回数据表数据
     */
    public Table[] getTables(String tablename){
        sql = "SELECT * FROM "+tablename;
        int i = 0;
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                tables[i] = new Table();
                tables[i].setNo(resultSet.getInt("no"));
                tables[i].setTopic(resultSet.getString("topic"));
                tables[i].setA(resultSet.getString("A"));
                tables[i].setB(resultSet.getString("B"));
                tables[i].setC(resultSet.getString("C"));
                tables[i].setD(resultSet.getString("D"));
                tables[i].setAnswer(resultSet.getString("answer"));
                tables[i].setScore(resultSet.getDouble("score"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    /**
     * 修改数据表数据
     */
    public void setTable(int No,String topic,String a,String b,String c,String d,String answer,double score,String tablename){
        sql = "UPDATE "+tablename+" SET no="+No+",topic="+oblique+topic+oblique+",A="+oblique+a+oblique+",B="+oblique+b+oblique+",C="+oblique+c+oblique+",D="+oblique+d+oblique+",answer="+oblique+answer+oblique+",score="+score+" where id="+tableid+";";
        System.out.println(sql);
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改id号
     * @param tableid
     */
    public void setTableid(int tableid) {
        this.tableid = tableid;
    }


    /**
     * 获取ID号
     * @return
     */
    public int getTableid() {
        return tableid;
    }
}
