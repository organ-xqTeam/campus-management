package com.ruoyi.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;

public class drawImg {

//    public static void main(String[] args) {
//        String filePath = "D:\\Users\\Desktop\\inimg03.jpg";
//        String outPath = "D:\\Users\\Desktop\\2.jpg";
//        drawTextInImg(filePath, outPath, new FontText("张三", 1, "#CC2BAC", 25, "黑体"));
//    }

    public static void drawTextInImg(String filePath,String outPath, FontText text) {
        ImageIcon imgIcon = new ImageIcon(filePath);
        Image img = imgIcon.getImage();
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bimage.createGraphics();
        g.setColor(getColor(text.getWm_text_color()));
        g.setBackground(Color.white);
        g.drawImage(img, 0, 0, null);
        Font font = null;
        if (StringUtils.isNotEmpty(text.getWm_text_font())
                && text.getWm_text_size() != null) {
            font = new Font(text.getWm_text_font(), Font.BOLD,
                    text.getWm_text_size());
        } else {
            font = new Font(null, Font.BOLD, 15);
        }
        g.setFont(font);
        FontMetrics metrics = new FontMetrics(font){};
        Rectangle2D bounds = metrics.getStringBounds(text.getText(), null);
        int textWidth = (int) bounds.getWidth();
        int textHeight = (int) bounds.getHeight();
        int left = 150;
        int top = textHeight+250;
        
        
        //九宫格控制位置
        if(text.getWm_text_pos()==2){
            left = width/2;
        }
        if(text.getWm_text_pos()==3){
            left = width -textWidth;
        }
        if(text.getWm_text_pos()==4){
            top = height/2;
        }
        if(text.getWm_text_pos()==5){
            left = width/2;
            top = height/2;
        }
        if(text.getWm_text_pos()==6){
            left = width -textWidth;
            top = height/2;
        }
        if(text.getWm_text_pos()==7){
            top = height - textHeight;
        }
        if(text.getWm_text_pos()==8){
            left = width/2;
            top = height - textHeight;
        }
        if(text.getWm_text_pos()==9){
            left = width -textWidth;
            top = height - textHeight;
        }
        
        
        try {
			g.drawString(new String((text.getText()+" 同学").getBytes("utf8"),"utf8"), left, top);
			g.drawString(new String(("祝贺您被评为2019年12月三好学生").getBytes("utf8"),"utf8"), left+textWidth+10, top+textHeight);
			g.drawString(new String(("特此发证，以资鼓励").getBytes("utf8"),"utf8"), left, top+textHeight+textHeight);
			g.drawString(new String(("XXXX学校").getBytes("utf8"),"utf8"),height- left-textWidth, width-top-textHeight-20);
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			g.drawString(new String((dateFormat.format(date)).getBytes("utf8"),"utf8"),height- left, width-top-20);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        g.dispose();

        try {
            FileOutputStream out = new FileOutputStream(outPath);
            ImageIO.write(bimage, "JPEG", out);
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    public static BufferedImage drawInImgs(String filePath, FontText text) {
    	ImageIcon imgIcon = new ImageIcon(filePath);
    	Image img = imgIcon.getImage();
    	int width = img.getWidth(null);
    	int height = img.getHeight(null);
    	BufferedImage bimage = new BufferedImage(width, height,
    			BufferedImage.TYPE_INT_RGB);
    	
    	Graphics2D g = bimage.createGraphics();
    	g.setColor(getColor(text.getWm_text_color()));
    	g.setBackground(Color.white);
    	g.drawImage(img, 0, 0, null);
    	Font font = null;
    	if (StringUtils.isNotEmpty(text.getWm_text_font())
    			&& text.getWm_text_size() != null) {
    		font = new Font(text.getWm_text_font(), Font.BOLD,
    				text.getWm_text_size());
    	} else {
    		font = new Font(null, Font.BOLD, 15);
    	}
    	g.setFont(font);
    	FontMetrics metrics = new FontMetrics(font){};
    	Rectangle2D bounds = metrics.getStringBounds(text.getText(), null);
    	int textWidth = (int) bounds.getWidth();
    	int textHeight = (int) bounds.getHeight();
    	int left = 150;
    	int top = textHeight+250;
    	
    	
    	//九宫格控制位置
    	if(text.getWm_text_pos()==2){
    		left = width/2;
    	}
    	if(text.getWm_text_pos()==3){
    		left = width -textWidth;
    	}
    	if(text.getWm_text_pos()==4){
    		top = height/2;
    	}
    	if(text.getWm_text_pos()==5){
    		left = width/2;
    		top = height/2;
    	}
    	if(text.getWm_text_pos()==6){
    		left = width -textWidth;
    		top = height/2;
    	}
    	if(text.getWm_text_pos()==7){
    		top = height - textHeight;
    	}
    	if(text.getWm_text_pos()==8){
    		left = width/2;
    		top = height - textHeight;
    	}
    	if(text.getWm_text_pos()==9){
    		left = width -textWidth;
    		top = height - textHeight;
    	}
    	
    	
    	g.drawString(text.getText()+" 同学", left, top);
    	g.drawString("祝贺您被评为2019年12月三好学生", left+textWidth+10, top+textHeight);
    	g.drawString("特此发证，以资鼓励", left, top+textHeight+textHeight);
    	g.drawString("XXXX学校",height- left-textWidth, width-top-textHeight-20);
    	Date date = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    	g.drawString(dateFormat.format(date),height- left, width-top-20);
    	g.dispose();
    	
    	//    		FileOutputStream out = new FileOutputStream(outPath);
//    		ImageIO.write(bimage, "JPEG", out);
		return bimage;
//    		out.close();
    }

    // color #2395439
    public static Color getColor(String color) {
        if (color.charAt(0) == '#') {
            color = color.substring(1);
        }
        if (color.length() != 6) {
            return null;
        }
        try {
            int r = Integer.parseInt(color.substring(0, 2), 16);
            int g = Integer.parseInt(color.substring(2, 4), 16);
            int b = Integer.parseInt(color.substring(4), 16);
            return new Color(r, g, b);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
}