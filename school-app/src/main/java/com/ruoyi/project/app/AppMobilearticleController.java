package com.ruoyi.project.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.system.schoolmobilearticle.domain.Schoolmobilearticle;
import com.ruoyi.project.system.schoolmobilearticle.service.ISchoolmobilearticleService;

@CrossOrigin
@Controller
@RequestMapping("/ajax/app/mobilearticle")
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
    
}
