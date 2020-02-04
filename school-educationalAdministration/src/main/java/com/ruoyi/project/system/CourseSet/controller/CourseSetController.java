package com.ruoyi.project.system.CourseSet.controller;

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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.system.CourseSet.domain.CourseSet;
import com.ruoyi.project.system.CourseSet.service.ICourseSetService;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * 课程设置管理Controller
 * 
 * @author ruoyi
 * @date 2020-02-04
 */

@Controller
@RequestMapping("/system/CourseSet")
public class CourseSetController extends BaseController
{
    private String prefix = "system/CourseSet";

    @Autowired
    private ICourseSetService courseSetService;
    @Autowired
    private ICoursemanagementService coursemanagementService;
    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;

    @RequiresPermissions("system:CourseSet:view")
    @GetMapping()
    public String CourseSet()
    {
        return prefix + "/CourseSet";
    }

    /**
     * 查询课程设置管理列表
     */
    @RequiresPermissions("system:CourseSet:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CourseSet courseSet)
    {
        startPage();
        List<CourseSet> list = courseSetService.selectCourseSetList(courseSet);
        return getDataTable(list);
    }

    /**
     * 导出课程设置管理列表
     */
    @RequiresPermissions("system:CourseSet:export")
    @Log(title = "课程设置管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CourseSet courseSet)
    {
        List<CourseSet> list = courseSetService.selectCourseSetList(courseSet);
        ExcelUtil<CourseSet> util = new ExcelUtil<CourseSet>(CourseSet.class);
        return util.exportExcel(list, "CourseSet");
    }

    /**
     * 新增课程设置管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	Coursemanagement coursemanagement =new Coursemanagement();
    	List<Coursemanagement> coursemanagementList= coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementList", coursemanagementList);
    	SchoolSpecialty schoolSpecialty = new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        return prefix + "/add";
    }

    /**
     * 新增保存课程设置管理
     */
    @RequiresPermissions("system:CourseSet:add")
    @Log(title = "课程设置管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CourseSet courseSet)
    {
    	Long specialtyId=  courseSet.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	courseSet.setSpecialtyName(schoolSpecialty.getName());
    	Long coursemanagementId= courseSet.getCoursemanagementId();
    	Coursemanagement coursemanagement= coursemanagementService.selectCoursemanagementById(coursemanagementId);
    	courseSet.setCoursemanagementName(coursemanagement.getStudentsName());
    	return toAjax(courseSetService.insertCourseSet(courseSet));
    }

    /**
     * 修改课程设置管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Coursemanagement coursemanagement =new Coursemanagement();
    	List<Coursemanagement> coursemanagementList= coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementList", coursemanagementList);
    	SchoolSpecialty schoolSpecialty = new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        CourseSet courseSet = courseSetService.selectCourseSetById(id);
        mmap.put("courseSet", courseSet);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程设置管理
     */
    @RequiresPermissions("system:CourseSet:edit")
    @Log(title = "课程设置管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CourseSet courseSet)
    {
    	Long specialtyId=  courseSet.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	courseSet.setSpecialtyName(schoolSpecialty.getName());
    	Long coursemanagementId= courseSet.getCoursemanagementId();
    	Coursemanagement coursemanagement= coursemanagementService.selectCoursemanagementById(coursemanagementId);
    	courseSet.setCoursemanagementName(coursemanagement.getStudentsName());
        return toAjax(courseSetService.updateCourseSet(courseSet));
    }

    /**
     * 删除课程设置管理
     */
    @RequiresPermissions("system:CourseSet:remove")
    @Log(title = "课程设置管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(courseSetService.deleteCourseSetByIds(ids));
    }
}
