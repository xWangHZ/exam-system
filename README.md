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

```
.
├── src
│   ├── com
|		├── data						//存放数据的包
|			├── Data.java				//存放常用数值类
|		├── exam						//存放考试系统界面的包
|			├── Backgroundpanel.java	//绘制背景图片类
|			├── Login.java				//登陆界面类
|			├── TopicPanel.java			//学生答题界面类
|		├── file						//存放对文件操作的包
|			├── ObtainProblem.java		//从文件中得到选项和问题的类
|			├── CompareAnswer.java		//从文件中得到答案并比较的类
|		├── main						//存放主类的包
|			├── Main.java				//主类
├── img									//图片
├── problem								//问题和选项
├── answer								//正确答案
├── fraction							//每道题的分值
```

