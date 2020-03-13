package com.ruoyi.project.system.CourseSystem.controller;

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
import com.ruoyi.project.system.CourseSystem.domain.CourseSystem;
import com.ruoyi.project.system.CourseSystem.service.ICourseSystemService;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;

/**
 * 课程体系Controller
 * 
 * @author ruoyi
 * @date 2020-02-03
 */
@Controller
@RequestMapping("/CourseSystem/CourseSystem")
public class CourseSystemController extends BaseController
{
    private String prefix = "system/CourseSystem";

    @Autowired
    private ICourseSystemService courseSystemService;
    
    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;

    @RequiresPermissions("CourseSystem:CourseSystem:view")
    @GetMapping()
    public String CourseSystem()
    {
        return prefix + "/CourseSystem";
    }

    /**
     * 查询课程体系列表
     */
    @RequiresPermissions("CourseSystem:CourseSystem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CourseSystem courseSystem)
    {
        startPage();
        List<CourseSystem> list = courseSystemService.selectCourseSystemList(courseSystem);
        return getDataTable(list);
    }

    /**
     * 导出课程体系列表
     */
    @RequiresPermissions("CourseSystem:CourseSystem:export")
    @Log(title = "课程体系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CourseSystem courseSystem)
    {
        List<CourseSystem> list = courseSystemService.selectCourseSystemList(courseSystem);
        ExcelUtil<CourseSystem> util = new ExcelUtil<CourseSystem>(CourseSystem.class);
        return util.exportExcel(list, "CourseSystem");
    }

    /**
     * 新增课程体系
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	SchoolSpecialty schoolSpecialty =new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        return prefix + "/add";
    }

    /**
     * 新增保存课程体系
     */
    @RequiresPermissions("CourseSystem:CourseSystem:add")
    @Log(title = "课程体系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CourseSystem courseSystem)
    {
//    	Long specialtyId=  courseSystem.getSpecialtyId();
//    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
//    	courseSystem.setSpecialtyName(schoolSpecialty.getName());
        return toAjax(courseSystemService.insertCourseSystem(courseSystem));
    }

    /**
     * 修改课程体系
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	SchoolSpecialty schoolSpecialty =new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        CourseSystem courseSystem = courseSystemService.selectCourseSystemById(id);
        mmap.put("courseSystem", courseSystem);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程体系
     */
    @RequiresPermissions("CourseSystem:CourseSystem:edit")
    @Log(title = "课程体系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CourseSystem courseSystem)
    {
//    	Long specialtyId=  courseSystem.getSpecialtyId();
//    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
//    	courseSystem.setSpecialtyName(schoolSpecialty.getName());
        return toAjax(courseSystemService.updateCourseSystem(courseSystem));
    }

    /**
     * 删除课程体系
     */
    @RequiresPermissions("CourseSystem:CourseSystem:remove")
    @Log(title = "课程体系", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(courseSystemService.deleteCourseSystemByIds(ids));
    }
}
