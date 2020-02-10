package com.ruoyi.project.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.system.schoolenrollmentmanagement.domain.Schoolenrollmentmanagement;
import com.ruoyi.project.system.schoolenrollmentmanagement.service.ISchoolenrollmentmanagementService;

@CrossOrigin
@Controller
@RequestMapping("/uajax/app/enrollmentmanagement")
public class AppEnrollmentmanagement extends BaseController {

    @Autowired
    private ISchoolenrollmentmanagementService schoolenrollmentmanagementService;

	//获取项目
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(int pageNum, int pageSize)
    {
    	Schoolenrollmentmanagement enrollmentmanagement = new Schoolenrollmentmanagement();
    	PageHelper.startPage(pageNum, pageSize, null);
        List<Schoolenrollmentmanagement> list = schoolenrollmentmanagementService.selectSchoolenrollmentmanagementList(enrollmentmanagement);
        return getDataTable(list);
    }
    
}
