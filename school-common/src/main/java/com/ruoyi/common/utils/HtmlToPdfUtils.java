package com.ruoyi.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;

public class HtmlToPdfUtils {
	private HtmlToPdfUtils() {}

	   /**
	    * html转换成PDF
	    * @param htmlFile html文件
	    * @param pdfPath  pdf路径
	    * @throws Exception 异常
	    */
	   public static void htmlToPdf(File htmlFile, String pdfPath) throws Exception {

	       OutputStream os = new FileOutputStream(pdfPath);
	       ITextRenderer iTextRenderer = new ITextRenderer();
	       iTextRenderer.setDocument(htmlFile);

	       //解决中文编码
	       ITextFontResolver fontResolver = iTextRenderer.getFontResolver();
	       if ("linux".equals(getCurrentOperationSystem())) {
	           fontResolver.addFont("/usr/share/fonts/chiness/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	       } else {
	           fontResolver.addFont("C:/Users/lihc/Desktop/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	       }

	       iTextRenderer.layout();
	       iTextRenderer.createPDF(os);
	       os.flush();
	       os.close();
	   }

	   private static String getCurrentOperationSystem() {
	       String os = System.getProperty("os.name").toLowerCase();
	       return os;
	   }

	   public static void main(String[] args){
	       File file = new File("C:/Users/lihc/Desktop/test.html");
	       String pdfPath = "C:/Users/lihc/Desktop/testPdf.pdf";
	       try{
	           htmlToPdf(file, pdfPath);
	       }catch (Exception e){
	           e.printStackTrace();
	       }
	   }
	   
	   public static void htmltopdf() {
		   File file = new File("C:/Users/lihc/Desktop/test.html");
		   
	       String pdfPath = "C:/Users/lihc/Desktop/testPdf.pdf";
	       try{
	           htmlToPdf(file, pdfPath);
	       }catch (Exception e){
	           e.printStackTrace();
	       }
	   }
}
