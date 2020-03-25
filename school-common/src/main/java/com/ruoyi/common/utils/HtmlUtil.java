package com.ruoyi.common.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class HtmlUtil {

	public static void gethtml(List<Map<String, Object>> resultlist, Map<String, Object> stu, String htmlpath) {
		//用于存储html字符串
		StringBuilder stringHtml = new StringBuilder();
		try{
			//打开文件
			PrintStream printStream = new PrintStream(new FileOutputStream(htmlpath));
			//输入HTML文件内容
			stringHtml.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></meta><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"></meta><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"></meta>" + 
					"<title>Document</title>" + 
					"<style>" + 
					"* {" + 
					"		margin: 0;" + 
					"		padding: 0;" + 
					"		list-style: none;" + 
					"	}	" + 
					"	.container h1 {" + 
					"		text-align: center;" + 
					"		padding: 22px 0;" + 
					"		font-family:\"STXingkai\",\"STKaiti\",Georgia,Serif;" + 
					"	}	" + 
					"	.container p {" + 
					"		font-family:\"STSong\",\"STFangsong\",Georgia,Serif;" + 
					"	}	" + 
					"	.container .user_info__header__wrap {" + 
					"		margin: 0 auto;" + 
					"		width: 80%;" + 
					"	}" + 
					"	.container .user_info__header__wrap .row {" + 
					"		display: grid;" + 
					"		grid-template-columns: 1fr 7fr 1fr 6fr 1fr 6fr;" + 
					"		grid-template-rows: 30px;" + 
					"	}" + 
					"	.container .user_info__header__wrap .row p {" + 
					"		border: 1px dotted rgba(0,0,0,.5);" + 
					"		line-height: 30px;" + 
					"	}" + 
					"	.container .user_info__header__wrap .row p {" + 
					"		border-right-color: transparent;" + 
					"	}" + 
					"	.container .user_info__header__wrap .row p:last-child {" + 
					"		border-right-color: rgba(0,0,0,5);" + 
					"	}" + 
					"	.container .user_info__header__wrap .row:nth-child(2) p {" + 
					"		border-top-color: transparent;" + 
					"		border-bottom-color: transparent;" + 
					"	}" + 
					"	.container .user_info__header__wrap .row:nth-child(3) p {" + 
					"		border-bottom-color: transparent;" + 
					"	}" + 
					"	.container .user_info__body__wrap {" + 
					"		width: 80%;" + 
					"		margin: 0 auto;" + 
					"	}" + 
					"	.container .user_info__body__wrap .row {" + 
					"		display: grid;" + 
					"		grid-template-columns: 1fr 3fr 5fr 1fr 1fr 1fr 3fr 5fr 1fr 1fr;" + 
					"		grid-template-rows: 30px;" + 
					"	}" + 
					"	.container .user_info__body__wrap .row p {" + 
					"		border: 1px solid rgba(0,0,0,.5);" + 
					"		border-bottom-color: transparent;" + 
					"		line-height: 30px;" + 
					"		border-right-color: transparent;" + 
					"		text-align: center;" + 
					"	}" + 
					"	.container .user_info__body__wrap .row p:nth-child(3) {" + 
					"		text-align: left;" + 
					"	}" + 
					"	.container .user_info__body__wrap .row p:nth-child(8) {" + 
					"		text-align: left;" + 
					"	}" + 
					"	.container .user_info__body__wrap .row:first-child p {" + 
					"		text-align: center;" + 
					"		font-family:\"SimSun\",\"NSimSun\",Georgia,Serif;" + 
					"	}" + 
					"	.container .user_info__body__wrap .row p:last-child {" + 
					"		border-right-color: rgba(0,0,0,.5);" + 
					"	}" + 
					"	.container .user_info__body__wrap .row:last-child p {" + 
					"		border-bottom-color: rgba(0,0,0,.5);" + 
					"	}" + 
					"	.container .footer_wrap {" + 
					"		margin: 0 auto;" + 
					"		width: 80%;" + 
					"		padding-top: 12px;" + 
					"		font-family:\"SimSun\",\"NSimSun\",Georgia,Serif;" + 
					"	}" + 
					"	.container .footer_wrap p:last-child {" + 
					"		display: flex;" + 
					"		justify-content: space-between;" + 
					"		padding: 22px 40px;" + 
					"	}" + 
					"</style>" + 
					"</head>" + 
					"<body>" + 
					"" + 
					"<div class=\"container\">" + 
					"<h1>北京工商大学学生成绩单</h1>" + 
					"<div class=\"user_info__header__wrap\">" + 
					"<div class=\"row\">" + 
					"<p>学号：</p>" + 
					"<p>190***</p>" + 
					"<p>姓名：</p>" + 
					"<p>张三</p>" + 
					"<p>性别：</p>" + 
					"<p>女</p>" + 
					"</div>" + 
					"<div class=\"row\">" + 
					"<p>院系：</p>" + 
					"<p>*学院</p>" + 
					"<p>专业：</p>" + 
					"<p>**学</p>" + 
					"<p>班级：</p>" + 
					"<p>注会*</p>" + 
					"</div>" + 
					"<div class=\"row\">" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"</div>" + 
					"</div>" + 
					"" + 
					"<div class=\"user_info__body__wrap\">" + 
					"<div class=\"row\">" + 
					"<p>序号</p>" + 
					"<p>学年学期</p>" + 
					"<p>课程名称</p>" + 
					"<p>学分</p>" + 
					"<p>成绩</p>" + 
					"<p>序号</p>" + 
					"<p>学年学期</p>" + 
					"<p>课程名称</p>" + 
					"<p>学分</p>" + 
					"<p>成绩</p>" + 
					"</div>" + 
					"<div class=\"row\">" + 
					"<p>1</p>" + 
					"<p>2019-2020-1</p>" + 
					"<p>思想道德修养与法律基础</p>" + 
					"<p>3.0</p>" + 
					"<p>**</p>" + 
					"<p>1</p>" + 
					"<p>2019-2020-1</p>" + 
					"<p>思想道德修养与法律基础</p>" + 
					"<p>3.0</p>" + 
					"<p>**</p>" + 
					"</div>" + 
					"<div class=\"row\">" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"<p></p>" + 
					"</div>" + 
					"</div>" + 
					"<div class=\"footer_wrap\"><p>自2019年9月至2020年3月修完以上课程(带*号为限选,任选,公选课程,带▲号为补考/重考课程成绩,带◆号的为重修成绩)</p><p>" + 
					"<span>课程总学分：20.5</span>" + 
					"<span>北京工商大学国际教育学院2020年3月19日</span>" + 
					"</p></div></div></body></html>");
			
//			stringHtml.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></meta>");
//			stringHtml.append("<title>测试报告文档</title>");
//	
//			stringHtml.append("</head>");
//	
//			stringHtml.append("<body>");
//	
//			stringHtml.append("<div>hello</div>");
//	
//			stringHtml.append("</body></html>");
	
	
			//将HTML文件内容写入文件中
	
			printStream.println(stringHtml.toString());

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
