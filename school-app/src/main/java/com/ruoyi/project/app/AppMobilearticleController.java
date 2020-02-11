package com.ruoyi.project.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.schoolmobilearticle.domain.Schoolmobilearticle;
import com.ruoyi.project.system.schoolmobilearticle.service.ISchoolmobilearticleService;

@CrossOrigin
@Controller
@RequestMapping("/uajax/app/mobilearticle")
public class AppMobilearticleController extends BaseController {

    @Autowired
    private ISchoolmobilearticleService schoolmobilearticleService;
	
	//获取文章
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestBody JSONObject param)
    {
    	String type = param.get("type").toString();
    	int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	Schoolmobilearticle mobilearticle = new Schoolmobilearticle();
    	mobilearticle.setType(type);
    	PageHelper.startPage(pageNum, pageSize, null);
        List<Schoolmobilearticle> list = schoolmobilearticleService.selectSchoolmobilearticleList(mobilearticle);
        return getDataTable(list);
    }
    
//    /profile/upload/2020/01/15/2a3bce903a935a35b43a528a233d5426.jpg
    //展示图片
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
