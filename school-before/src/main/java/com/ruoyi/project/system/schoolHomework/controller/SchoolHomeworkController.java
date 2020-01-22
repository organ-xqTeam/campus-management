package com.ruoyi.project.system.schoolHomework.controller;

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
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.schoolHomework.domain.SchoolHomework;
import com.ruoyi.project.system.schoolHomework.service.ISchoolHomeworkService;

/**
 * 学生作业表Controller
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
@Controller
@RequestMapping("/system/schoolHomework")
public class SchoolHomeworkController extends BaseController
{
    private String prefix = "system/schoolHomework";

    @Autowired
    private ISchoolHomeworkService schoolHomeworkService;
    
    @Autowired
    private ICoursemanagementService coursemanagementService;

    @RequiresPermissions("system:schoolHomework:view")
    @GetMapping()
    public String schoolHomework()
    {
        return prefix + "/schoolHomework";
    }
    
    @RequiresPermissions("system:schoolHomework:view")
    @GetMapping("/result")
    public String result(String id,ModelMap mmap)
    {
    	mmap.put("studentid", id);
        return "system/schoolClass/schoolHomework";
    }

    /**
     * 查询学生作业表列表
     */
    @RequiresPermissions("system:schoolHomework:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SchoolHomework schoolHomework)
    {
        startPage();
        List<SchoolHomework> list = schoolHomeworkService.selectSchoolHomeworkList(schoolHomework);
        return getDataTable(list);
    }

    /**
     * 导出学生作业表列表
     */
    @RequiresPermissions("system:schoolHomework:export")
    @Log(title = "学生作业表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolHomework schoolHomework)
    {
        List<SchoolHomework> list = schoolHomeworkService.selectSchoolHomeworkList(schoolHomework);
        ExcelUtil<SchoolHomework> util = new ExcelUtil<SchoolHomework>(SchoolHomework.class);
        return util.exportExcel(list, "schoolHomework");
    }

    /**
     * 新增学生作业表
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	Coursemanagement coursemanagement =new Coursemanagement();
    	List<Coursemanagement> coursemanagementList= coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementList", coursemanagementList);
    	
    	//查找所有课程
        return prefix + "/add";
    }

    /**
     * 新增保存学生作业表
     */
    @RequiresPermissions("system:schoolHomework:add")
    @Log(title = "学生作业表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolHomework schoolHomework)
    {
    	Long curriculumId=  schoolHomework.getCurriculumId();
    	if(curriculumId != null) {
    		Coursemanagement coursemanagement= coursemanagementService.selectCoursemanagementById(curriculumId);
    		schoolHomework.setCurriculumName(coursemanagement.getStudentsName());
    	}
        return toAjax(schoolHomeworkService.insertSchoolHomework(schoolHomework));
    }

    /**
     * 修改学生作业表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolHomework schoolHomework = schoolHomeworkService.selectSchoolHomeworkById(id);
        mmap.put("schoolHomework", schoolHomework);
        Coursemanagement coursemanagement =new Coursemanagement();
        List<Coursemanagement> coursemanagementList= coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementList", coursemanagementList);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生作业表
     */
    @RequiresPermissions("system:schoolHomework:edit")
    @Log(title = "学生作业表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolHomework schoolHomework)
    {
    	Long curriculumId=  schoolHomework.getCurriculumId();
    	if(curriculumId != null) {
    		Coursemanagement coursemanagement= coursemanagementService.selectCoursemanagementById(curriculumId);
    		schoolHomework.setCurriculumName(coursemanagement.getStudentsName());
    	}
        return toAjax(schoolHomeworkService.updateSchoolHomework(schoolHomework));
    }

    /**
     * 删除学生作业表
     */
    @RequiresPermissions("system:schoolHomework:remove")
    @Log(title = "学生作业表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolHomeworkService.deleteSchoolHomeworkByIds(ids));
    }
}
