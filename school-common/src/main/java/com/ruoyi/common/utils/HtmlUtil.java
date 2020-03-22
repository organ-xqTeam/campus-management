package com.ruoyi.common.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class HtmlUtil {

	public static void main(String[] args) {
		gethtml();
	}
	public static void gethtml() {
		//用于存储html字符串

		StringBuilder stringHtml = new StringBuilder();

		try{

			//打开文件
	
			PrintStream printStream = new PrintStream(new FileOutputStream("C:/Users/lihc/Desktop/test.html"));
	
	
			//输入HTML文件内容
	
			stringHtml.append("<html><head>");
	
			stringHtml.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></meta>");
	
			stringHtml.append("<title>测试报告文档</title>");
	
			stringHtml.append("</head>");
	
			stringHtml.append("<body>");
	
			stringHtml.append("<div>hello</div>");
	
			stringHtml.append("</body></html>");
	
	
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
