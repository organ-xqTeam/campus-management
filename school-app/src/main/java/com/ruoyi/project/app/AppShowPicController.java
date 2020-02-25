package com.ruoyi.project.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.framework.config.RuoYiConfig;

@CrossOrigin
@Controller
@RequestMapping("/afasfasdf/showpic")
public class AppShowPicController extends BaseController {

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
	 
}
