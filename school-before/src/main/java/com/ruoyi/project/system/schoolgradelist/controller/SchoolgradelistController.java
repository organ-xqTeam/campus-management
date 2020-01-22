package com.ruoyi.project.system.schoolgradelist.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;

/**
 * 年级管理Controller
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/system/schoolgradelist")
public class SchoolgradelistController extends BaseController
{
    private String prefix = "system/schoolgradelist";

    @Autowired
    private ISchoolClassService schoolClassService;

    @Autowired
    private ITeachingInfoService teachingInfoService;
    
    @Autowired
    private ISchoolgradelistService schoolgradelistService;
    
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;

    @RequiresPermissions("system:schoolgradelist:view")
    @GetMapping()
    public String schoolgradelist()
    {
        return prefix + "/schoolgradelist";
    }
    
    /**
     * 查询年级管理列表
     */
    @RequiresPermissions("system:schoolgradelist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolgradelist schoolgradelist)
    {
        startPage();
        List<Schoolgradelist> list = schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
        return getDataTable(list);
    }

    /**
     * 导出年级管理列表
     */
    @RequiresPermissions("system:schoolgradelist:export")
    @Log(title = "年级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolgradelist schoolgradelist)
    {
        List<Schoolgradelist> list = schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
        ExcelUtil<Schoolgradelist> util = new ExcelUtil<Schoolgradelist>(Schoolgradelist.class);
        return util.exportExcel(list, "schoolgradelist");
    }

    /**
     * 新增年级管理
     */
    @GetMapping("/add")
    public String add(String detailId,String resultId)
    {
    	System.out.println(detailId);
    	System.out.println(resultId);
        return prefix + "/add";
    }
    
    /**
     * 编辑年级主任
     * */
    @GetMapping("/editgradecharge/{id}")
    public String editgradecharge(@PathVariable("id") Long id, ModelMap mmap)
    {
    	TeachingInfo teachingInfo =new TeachingInfo();
    	teachingInfo.setDelFlag((long)0);
    	List<TeachingInfo> teachingInfoList=  teachingInfoService.selectTeachingInfoList(teachingInfo);
    	Schoolgradelist schoolgradelistlist = schoolgradelistService.selectSchoolgradelistById(id+ "");
    	mmap.put("teachingInfoList", teachingInfoList);
    	mmap.put("schoolgradelist", schoolgradelistlist);
    	return prefix + "/editgradecharge";
    }
    
    /**
     * 智能分班
     * */
    @RequiresPermissions("system:schoolgradelist:scheduling")
    @GetMapping("/scheduling/{id}")
    public String scheduling(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolgradelist schoolgradelistlist = schoolgradelistService.selectSchoolgradelistById(id+ "");
    	mmap.put("schoolgradelist", schoolgradelistlist);
    	return prefix + "/scheduling";
    }
    
    @ResponseBody
    @GetMapping("/doScheduling")
    public AjaxResult doScheduling(@RequestParam("id") Long id, @RequestParam("num") int num) {    	
    	schoolClassService.doScheduling(id, num);
    	return toAjax(true);
    }
    
    /**
     * 年级学生列表
     * */
    @RequiresPermissions("system:schoolgradelist:gostudentpage")
    @GetMapping("/gostudentpage")
    public String gostudentpage(Schoolstudentslist student, ModelMap mmap)
    {
    	mmap.put("student", student);
        return prefix + "/schoolstudentlist";
    }
    
    /**
     * 新增保存年级管理
     */
    @RequiresPermissions("system:schoolgradelist:add")
    @Log(title = "年级", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolgradelist schoolgradelist)
    {
        return toAjax(schoolgradelistService.insertSchoolgradelist(schoolgradelist));
    }

    /**
     * 修改年级管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Schoolgradelist schoolgradelist = schoolgradelistService.selectSchoolgradelistById(id);
        mmap.put("schoolgradelist", schoolgradelist);
        return prefix + "/edit";
    }

    /**
     * 修改保存年级管理
     */
    @RequiresPermissions("system:schoolgradelist:edit")
    @Log(title = "年级", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolgradelist schoolgradelist)
    {
        return toAjax(schoolgradelistService.updateSchoolgradelist(schoolgradelist));
    }

    /**
     * 删除年级管理
     */
    @RequiresPermissions("system:schoolgradelist:remove")
    @Log(title = "年级", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolgradelistService.deleteSchoolgradelistByIds(ids));
    }
}
