# Java考试系统

## 目标

- [ ] 利用Java网络编程实现发送题目和答案到另一台PC端 
- [x] 使用Swing皮肤包
- [ ] 用户名密码保存在数据库中
- [ ] 利用网络编程发送分数到服务端
- [x] 学生端
- [ ] 教室端
- [ ] 题目保存在数据库

## 目录

>|—— src			
>|	|—— com	
>|		|——	tool						//存放工具类的包
>|			|——	Data.java				//题目数量等数据类
>|			|——	Backgroundpanel.java	//添加背景图片类
>|		|——	exam						//存放考试系统类的包
>|			|——	teacher					//存放教师系统类的包
>|			|—— student					//存放学生系统类的包
>|				|——	Login.java			//登陆界面类
>|				|——	TopicReply.java		//答题界面类
>|		|——	file						//存放文件操作类的包
>|			|——	ObtainProblem.java		//从文件中读取选项和问题类
>|			|——	CompareAnswer.java		//从文件中读取答案并返回分数类
>|		|——	main						//存放入口类的包
>|			|——	TeacherMain.java		//教师端主类
>|			|——	studentMain.java		//学生端主类
>|——	img									//存放图片
>|——	fraction							//存放分值
>|——	problem								//存放问题
>|——	answer								//存放答案

