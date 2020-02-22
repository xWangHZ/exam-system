# Java考试系统

![](https://img.shields.io/badge/Java-1.8-red) ![](https://img.shields.io/badge/MySQL-8.0-green )

## 项目简介

由于一些服务器承受能力较小，无法全程对服务器上的数据库操作，所以可以将题目编辑进数据库中，在进行生成本地文件，最后将文件和答题系统导入到学生机，最大程度的减少对服务器的影响。

## 项目目标

- [ ] 利用Java网络编程实现发送题目和答案到另一台PC端 
- [x] 使用Swing皮肤包
- [x] 用户名密码保存在数据库中
- [x] 利用网络编程发送分数到服务端
- [x] 学生端
- [x] 教师端
- [x] 题目保存在数据库

## 项目目录

```java
├── img
├── lib
│   ├── mysql-connector-java-8.0.19.jar  //mysql驱动
│   └── SwingSets3(BeautyEyeLNFDemo).jar  //Swing皮肤包
├── Paper  	//放置题目分数的文件
├── sql  	//第一次使用时sql的文件夹
└── src
    └── com
        ├── exam	//考试系统包
        │   ├── student		//学生端
        │   │   ├── StudentLogin.java	//学生登陆窗口类
        │   │   ├── SubjectSelect.java	//学生选择科目窗口类
        │   │   └── TopicReply.java		//学生答题窗口类
        │   └── teacher	//教师端
        │       ├── SubjectSelect.java	//教师选择科目窗口类
        │       ├── TeacherLogin.java	//教师登录窗口类
        │       └── TopicMake.java		//教师出题窗口类
        ├── file	//文件操作包
        │   ├── CompareAnswer.java		//与本地答案比较类
        │   ├── GenerateFile.java		//创建本地文件类
        │   └── ObtainProblem.java		//获得问题类
        ├── main	//主类包
        │   ├── ServerMain.java			//服务端主类
        │   ├── studentMain.java		//学生端主类
        │   └── TeacherMain.java		//教师端主类
        ├── server	//服务端包
        │   ├── BackstageServer.java	//接收数据类
        │   └── DataServer.java			//发送数据类
        ├── test	//测试包
        └── tool	//工具包
            ├── Backgroundpanel.java	//画出背景图片类
            ├── DataTool.java			//数据类
            ├── LinkMySQLTool.java		//连接数据库类
            └── Table.java				//数据表类
```



## 使用教程

> 将sql文件夹中的exam-sytem.sql导入MySQL，修改server包中的ip和端口
>
> 直接打开教师端即可出题，之后打开学生端进行答题
>
> 里面默认超级管理账户 USER：root	PASS：root



## 有待改进

1. 暂时只能通过直接对数据库操作才可以导入学生信息
2. 无法将成绩导出成Excel表格

## 未修复BUG

1. 答题系统点击上一题时无法定位之前选择的选项
2. 必须在最后一道题点击交卷，否则会显示有题目未作答



## 项目截图

![](img\blog\QQ截图20200222221223.jpg)

![](img\blog\QQ截图20200222221255.jpg)

![](img\blog\QQ截图20200222221411.jpg)

