package com.ruoyi.project.system.schoolcoursewareinfo.controller;

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
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.schoolcoursewareinfo.domain.Schoolcoursewareinfo;
import com.ruoyi.project.system.schoolcoursewareinfo.service.ISchoolcoursewareinfoService;

/**
 * 课件列Controller
 * 
 * @author ruoyi
 * @date 2020-03-10
 */
@Controller
@RequestMapping("/system/schoolcoursewareinfo")
public class SchoolcoursewareinfoController extends BaseController
{
    private String prefix = "system/schoolcoursewareinfo";

    @Autowired
    private ISchoolcoursewareinfoService schoolcoursewareinfoService;
    @Autowired
    private ICoursemanagementService coursemanagementService;
    @Autowired
    private ITeachingInfoService teachingInfoService;

    @RequiresPermissions("system:schoolcoursewareinfo:view")
    @GetMapping()
    public String schoolcoursewareinfo(@RequestParam("id") Long id, ModelMap map)
    {
    	Coursemanagement course = new Coursemanagement();
    	course = coursemanagementService.selectCoursemanagementById(id);
    	map.put("course", course);
        return prefix + "/schoolcoursewareinfo";
    }

    @GetMapping("/viewedit/{id}")
    public String viewedit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolcoursewareinfo courseware = new Schoolcoursewareinfo();
    	courseware = schoolcoursewareinfoService.selectSchoolcoursewareinfoById(id);
    	mmap.put("courseware", courseware);
        return prefix + "/viewedit";
    }

    @GetMapping("/viewedit2/{id}")
    public String viewedit2(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolcoursewareinfo courseware = new Schoolcoursewareinfo();
    	courseware = schoolcoursewareinfoService.selectSchoolcoursewareinfoById(id);
    	mmap.put("courseware", courseware);
    	TeachingInfo teachingInfo =new TeachingInfo();
    	teachingInfo.setDelFlag((long)0);
    	List<TeachingInfo> teachingInfoList=  teachingInfoService.selectTeachingInfoList(teachingInfo);
    	mmap.put("teachingInfoList", teachingInfoList);
        return prefix + "/viewedit2";
    }

    /**
     * 查询课件列列表
     */
    @RequiresPermissions("system:schoolcoursewareinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolcoursewareinfo schoolcoursewareinfo)
    {
        startPage();
        List<Schoolcoursewareinfo> list = schoolcoursewareinfoService.selectSchoolcoursewareinfoList(schoolcoursewareinfo);
        return getDataTable(list);
    }

    /**
     * 导出课件列列表
     */
    @RequiresPermissions("system:schoolcoursewareinfo:export")
    @Log(title = "课件列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolcoursewareinfo schoolcoursewareinfo)
    {
        List<Schoolcoursewareinfo> list = schoolcoursewareinfoService.selectSchoolcoursewareinfoList(schoolcoursewareinfo);
        ExcelUtil<Schoolcoursewareinfo> util = new ExcelUtil<Schoolcoursewareinfo>(Schoolcoursewareinfo.class);
        return util.exportExcel(list, "schoolcoursewareinfo");
    }

    /**
     * 新增课件列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课件列
     */
    @RequiresPermissions("system:schoolcoursewareinfo:add")
    @Log(title = "课件列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolcoursewareinfo schoolcoursewareinfo)
    {
        return toAjax(schoolcoursewareinfoService.insertSchoolcoursewareinfo(schoolcoursewareinfo));
    }

    /**
     * 修改课件列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolcoursewareinfo schoolcoursewareinfo = schoolcoursewareinfoService.selectSchoolcoursewareinfoById(id);
        mmap.put("schoolcoursewareinfo", schoolcoursewareinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存课件列
     */
    @RequiresPermissions("system:schoolcoursewareinfo:edit")
    @Log(title = "课件列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolcoursewareinfo schoolcoursewareinfo)
    {
        return toAjax(schoolcoursewareinfoService.updateSchoolcoursewareinfo(schoolcoursewareinfo));
    }

    /**
     * 删除课件列
     */
    @RequiresPermissions("system:schoolcoursewareinfo:remove")
    @Log(title = "课件列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolcoursewareinfoService.deleteSchoolcoursewareinfoByIds(ids));
    }
}
