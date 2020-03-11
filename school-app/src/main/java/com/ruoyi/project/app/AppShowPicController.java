package com.ruoyi.project.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.FileInfo.domain.FileInfo;

@CrossOrigin
@Controller
@RequestMapping("/app/showpic")
public class AppShowPicController extends BaseController {

	@Value("${ftp.flag}")
	private static  boolean flag;

	@ResponseBody
    @RequestMapping(value="/getIcon", method = RequestMethod.GET)
    public void getIcon(String icon, HttpServletResponse response)
    {
    	String path = RuoYiConfig.getProfile();
    	File file = null;
    	FileInputStream fis = null;
    	try {
    		file = new File(path + icon);
    		if (!file.exists()) {
    			return;
    		}
    		fis = new FileInputStream(file);
    		final byte[] buf = new byte[1024];
    		while (fis.read(buf) > 0) {
    			response.getOutputStream().write(buf);
    		}
    	}
    	catch(Exception e) {
    		System.err.println(e.getMessage());
    	}
    	finally {
    		if (fis != null) {
    			try {
    				fis.close();
    			}
    			catch (IOException e) {
    				fis = null;
    			}
    		}
    		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    	}
    }
	
	@ResponseBody
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public JSONObject upload(@RequestParam("file") MultipartFile file, FileInfo fileInfo) throws IOException {
		{
			JSONObject result = new JSONObject();
//			 上传文件路径
			String filePath_ = RuoYiConfig.getUploadPath();
//			 上传并返回新文件名称
			System.out.println(filePath_);
			if (flag) {
				if (filePath_.substring(1, 2).equals(":")) {
					filePath_ = filePath_.substring(2, filePath_.length());
				}
				String filePath =	uploadFileToFTP(file, filePath_);
				fileInfo.setFilePath(filePath);
				fileInfo.setFileName(file.getOriginalFilename());
				result.put("file", fileInfo);
				return result;
			}else {
				String filePath = FileUploadUtils.upload(filePath_, file);
				fileInfo.setFilePath(filePath);
				fileInfo.setFileName(file.getOriginalFilename());
				result.put("file", fileInfo);
				return result;
			}
		}
	}    
	 
}
