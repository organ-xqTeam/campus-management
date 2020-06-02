package com.ruoyi.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPDFDemo1 {
	public static void main(
	// String[] args
	) throws FileNotFoundException, DocumentException {
		// 1.新建document对象
		Document document = new Document();
		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		/// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/lihc/Desktop/test.pdf"));

		// 3.打开文档
		document.open();

		// 4.添加一个内容段落
		document.add(new Paragraph("Hello World!"));

		// 5.关闭文档
		document.close();
	}

	// 利用模板生成pdf
	public static String fillTemplate(Map<String, Object> o, String path, String [] realArr, String moban) {
		// 模板路径
		String templatePath = path+"/"+moban;// 原PDF模板
		// 生成的新文件路径
		String s = UUID.randomUUID().toString();
		String newPdfName = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
		String newPDFPath = path + "/upload/"+realArr[0]+"/"+realArr[1]+"/"+realArr[2]+"/"+newPdfName+".pdf";
		String realPath = path + "/upload/"+realArr[0]+"/"+realArr[1]+"/"+realArr[2];
		String uploadPath = "/profile/upload/"+realArr[0]+"/"+realArr[1]+"/"+realArr[2]+"/"+newPdfName+".pdf";
		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try { // ↓↓↓↓↓这个是字体文件
			BaseFont bf = BaseFont.createFont(path + "/simsun.ttc,1", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);// 用的是系统字体，此路径是系统路径，可网上自行下载字体类型
			Font FontChinese = new Font(bf, 12f, Font.NORMAL);
			String strPath = newPDFPath;			
			File file = new File(realPath);
			if(!file.exists()){
				file.mkdirs();
			}			
			out = new FileOutputStream(newPDFPath);// 输出流			
			reader = new PdfReader(templatePath);// 读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
			Map<String, String> datemap = (Map<String, String>) o.get("datemap");
			form.addSubstitutionFont(bf);
			for (String key : datemap.keySet()) {
				String value = datemap.get(key);
				System.out.println(value + "*(*(*(**---：" + key);
				form.setField(key, value);
			}
			stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
			stamper.close();
			Document doc = new Document(PageSize.A4, 0, 0, 0, 0);
			Font font = new Font(bf, 32);
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			PdfImportedPage importPage = null;
			/// 循环是处理成品只显示一页的问题
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
				copy.addPage(importPage);
			}
			doc.close();
			System.err.println("生成pdf文件完成！");
		} 
		catch (IOException e) {
			System.out.println(e);
		} 
		catch (DocumentException e) {
			System.out.println(e);
		}
		finally {
			return uploadPath;
		}
	}

}
