package com.ruoyi.project.system.classschedulingmanagement.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.classschedulingmanagement.domain.Classschedulingmanagement;
import com.ruoyi.project.system.classschedulingmanagement.service.IClassschedulingmanagementService;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;

/**
 * 排课管理Controller
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Controller
@RequestMapping("/system/classschedulingmanagement")
public class ClassschedulingmanagementController extends BaseController
{
    private String prefix = "system/classschedulingmanagement";

    @Autowired
    private IClassschedulingmanagementService classschedulingmanagementService;
    
    @Autowired
    private ISchoolClassService schoolclassService;
    @Autowired
    private ISchoolgradelistService  schoolgradelistService;

    @RequiresPermissions("system:classschedulingmanagement:view")
    @GetMapping()
    public String classschedulingmanagement()
    {
        return prefix + "/classschedulingmanagement";
    }

    /**
     * 查询排课管理列表
     */
    @RequiresPermissions("system:classschedulingmanagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Classschedulingmanagement classschedulingmanagement)
    {
        startPage();
        List<Classschedulingmanagement> list = classschedulingmanagementService.selectClassschedulingmanagementList(classschedulingmanagement);
        return getDataTable(list);
    }

    /**
     * 导出排课管理列表
     */
    @RequiresPermissions("system:classschedulingmanagement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Classschedulingmanagement classschedulingmanagement)
    {
        List<Classschedulingmanagement> list = classschedulingmanagementService.selectClassschedulingmanagementList(classschedulingmanagement);
        ExcelUtil<Classschedulingmanagement> util = new ExcelUtil<Classschedulingmanagement>(Classschedulingmanagement.class);
        return util.exportExcel(list, "classschedulingmanagement");
    }

    /**
     * 新增排课管理
     */
    @GetMapping("/add")
    public String add( ModelMap mmap)
    {
    	Schoolgradelist schoolgradelist =new Schoolgradelist();
    	List<Schoolgradelist> schoolgradelistList=  schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("schoolgradelistList", schoolgradelistList);
    	SchoolClass schoolClass =new SchoolClass();
    	List<SchoolClass> schoolClassList=schoolclassService.selectSchoolClassList(schoolClass);
    	mmap.put("schoolClassList", schoolClassList);
    	return prefix + "/add";
    }

    /**
     * 新增保存排课管理
     */
    @RequiresPermissions("system:classschedulingmanagement:add")
    @Log(title = "排课管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Classschedulingmanagement classschedulingmanagement)
    {
    	
    	String  classId= classschedulingmanagement.getClassId();
    	String gradeId= classschedulingmanagement.getGradeId();
    	SchoolClass schoolClass= schoolclassService.selectSchoolClassById(Long.valueOf(classId));
    	Schoolgradelist schoolgradelist= schoolgradelistService.selectSchoolgradelistById(gradeId);
    	
    	classschedulingmanagement.setClassName(schoolClass.getNameclass());
    	classschedulingmanagement.setClassGrade(schoolgradelist.getGrade());
        return toAjax(classschedulingmanagementService.insertClassschedulingmanagement(classschedulingmanagement));
    }

    /**
     * 修改排课管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Classschedulingmanagement classschedulingmanagement = classschedulingmanagementService.selectClassschedulingmanagementById(id);
        mmap.put("classschedulingmanagement", classschedulingmanagement);
        Schoolgradelist schoolgradelist =new Schoolgradelist();
    	List<Schoolgradelist> schoolgradelistList=  schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("schoolgradelistList", schoolgradelistList);
    	SchoolClass schoolClass =new SchoolClass();
    	List<SchoolClass> schoolClassList=schoolclassService.selectSchoolClassList(schoolClass);
    	mmap.put("schoolClassList", schoolClassList);
        return prefix + "/edit";
    }

    /**
     * 修改保存排课管理
     */
    @RequiresPermissions("system:classschedulingmanagement:edit")
    @Log(title = "排课管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Classschedulingmanagement classschedulingmanagement)
    {
        return toAjax(classschedulingmanagementService.updateClassschedulingmanagement(classschedulingmanagement));
    }

    /**
     * 删除排课管理
     */
    @RequiresPermissions("system:classschedulingmanagement:remove")
    @Log(title = "排课管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(classschedulingmanagementService.deleteClassschedulingmanagementByIds(ids));
    }
}
