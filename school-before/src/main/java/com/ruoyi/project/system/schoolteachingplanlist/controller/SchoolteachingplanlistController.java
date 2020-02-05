package com.ruoyi.project.system.schoolteachingplanlist.controller;

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
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.schoolteachingplanlist.domain.Schoolteachingplanlist;
import com.ruoyi.project.system.schoolteachingplanlist.service.ISchoolteachingplanlistService;

/**
 * 教案Controller
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/system/schoolteachingplanlist")
public class SchoolteachingplanlistController extends BaseController
{
    private String prefix = "system/schoolteachingplanlist";
    
    @Autowired
    private ITeachingInfoService teachingInfoService;
    
    @Autowired
    private ICoursemanagementService coursemanagementService;
    
    @Autowired
    private ISchoolteachingplanlistService schoolteachingplanlistService;

    @RequiresPermissions("system:schoolteachingplanlist:view")
    @GetMapping()
    public String schoolteachingplanlist(Schoolteachingplanlist schoolteachingplan, ModelMap mmap)
    {
    	mmap.put("schoolteachingplan", schoolteachingplan);
        return prefix + "/schoolteachingplanlist";
    }

    /**
     * 查询教案列表
     */
    @RequiresPermissions("system:schoolteachingplanlist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolteachingplanlist schoolteachingplanlist)
    {
    	if (schoolteachingplanlist.getGrade() != null) {
        	schoolteachingplanlist.setGrade(schoolteachingplanlist.getGrade().replace(",", ""));
    	}
        startPage();
        List<Schoolteachingplanlist> list = schoolteachingplanlistService.selectSchoolteachingplanlistList(schoolteachingplanlist);
        return getDataTable(list);
    }

    /**
     * 导出教案列表
     */
    @RequiresPermissions("system:schoolteachingplanlist:export")
    @Log(title = "教案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolteachingplanlist schoolteachingplanlist)
    {
        List<Schoolteachingplanlist> list = schoolteachingplanlistService.selectSchoolteachingplanlistList(schoolteachingplanlist);
        ExcelUtil<Schoolteachingplanlist> util = new ExcelUtil<Schoolteachingplanlist>(Schoolteachingplanlist.class);
        return util.exportExcel(list, "schoolteachingplanlist");
    }

    /**
     * 新增教案
     */
    @GetMapping("/add")
    public String add(Schoolteachingplanlist schoolteachingplanlist, ModelMap mmap)
    {
    	TeachingInfo teachingInfo =new TeachingInfo();
    	teachingInfo.setDelFlag((long)0);
    	List<TeachingInfo> teachingInfoList = teachingInfoService.selectTeachingInfoList(teachingInfo);
    	mmap.put("teachingInfoList", teachingInfoList);
    	Coursemanagement coursemanagement =new Coursemanagement();
    	coursemanagement.setDelFlag((long)0);
        List<Coursemanagement> coursemanagementlist = coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementlist", coursemanagementlist);
        return prefix + "/add";
    }

    /**
     * 新增保存教案
     */
    @RequiresPermissions("system:schoolteachingplanlist:add")
    @Log(title = "教案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolteachingplanlist schoolteachingplanlist)
    {
        return toAjax(schoolteachingplanlistService.insertSchoolteachingplanlist(schoolteachingplanlist));
    }

    /**
     * 修改教案
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	TeachingInfo teachingInfo =new TeachingInfo();
    	teachingInfo.setDelFlag((long)0);
    	List<TeachingInfo> teachingInfoList = teachingInfoService.selectTeachingInfoList(teachingInfo);
    	mmap.put("teachingInfoList", teachingInfoList);
    	Coursemanagement coursemanagement =new Coursemanagement();
    	coursemanagement.setDelFlag((long)0);
        List<Coursemanagement> coursemanagementlist = coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementlist", coursemanagementlist);
        Schoolteachingplanlist schoolteachingplanlist = schoolteachingplanlistService.selectSchoolteachingplanlistById(id);
        mmap.put("schoolteachingplanlist", schoolteachingplanlist);
        return prefix + "/edit";
    }

    /**
     * 修改保存教案
     */
    @RequiresPermissions("system:schoolteachingplanlist:edit")
    @Log(title = "教案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolteachingplanlist schoolteachingplanlist)
    {
        return toAjax(schoolteachingplanlistService.updateSchoolteachingplanlist(schoolteachingplanlist));
    }

    /**
     * 删除教案
     */
    @RequiresPermissions("system:schoolteachingplanlist:remove")
    @Log(title = "教案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolteachingplanlistService.deleteSchoolteachingplanlistByIds(ids));
    }
}
