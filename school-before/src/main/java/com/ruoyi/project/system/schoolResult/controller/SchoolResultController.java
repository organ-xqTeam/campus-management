package com.ruoyi.project.system.schoolResult.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
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
import com.ruoyi.project.system.schoolResult.domain.SchoolResult;
import com.ruoyi.project.system.schoolResult.service.ISchoolResultService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.SysUser;

/**
 * 学校成绩Controller
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
@Controller
@RequestMapping("/system/schoolResult")
public class SchoolResultController extends BaseController
{
    private String prefix = "system/schoolResult";

    @Autowired
    private ISchoolResultService schoolResultService;
    @Autowired
    private ICoursemanagementService  coursemanagementService ;
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;

    @RequiresPermissions("system:schoolResult:view")
    @GetMapping()
    public String schoolResult()
    {
        return prefix + "/schoolResult";
    }
    
    @RequiresPermissions("system:schoolResult:studentresult")
    @GetMapping("/studentresult")
    public String studentResultView()
    {
        return prefix + "/studentResultView";
    }

    /**
     * 查询学校成绩列表
     */
    @RequiresPermissions("system:schoolResult:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SchoolResult schoolResult)
    {
        startPage();
        List<SchoolResult> list = schoolResultService.selectSchoolResultList(schoolResult);
        return getDataTable(list);
    }
    
    @RequiresPermissions("system:schoolResult:studentresultlist")
    @PostMapping("/studentresultlist")
    @ResponseBody
    public TableDataInfo studentresultlist(SchoolResult schoolResult)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	Schoolstudentslist stu = new Schoolstudentslist();
    	stu.setUserId(me.getUserId());
        List<Schoolstudentslist> stulist = schoolstudentslistService.selectSchoolstudentslistList(stu);
        if (stulist.size() == 1) {
        	schoolResult.setStudentid(stulist.get(0).getId()+"");
        }
        startPage();
        List<Map<String, Object>> list = schoolResultService.selectSchoolResultList2(schoolResult);
        return getDataTable(list);
    }

    /**
     * 导出学校成绩列表
     */
    @RequiresPermissions("system:schoolResult:export")
    @Log(title = "学校成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolResult schoolResult)
    {
        List<SchoolResult> list = schoolResultService.selectSchoolResultList(schoolResult);
        ExcelUtil<SchoolResult> util = new ExcelUtil<SchoolResult>(SchoolResult.class);
        return util.exportExcel(list, "schoolResult");
    }

    /**
     * 新增学校成绩
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	Coursemanagement coursemanagement =new Coursemanagement();
    	List<Coursemanagement> coursemanagementList= coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementList", coursemanagementList);
        return prefix + "/add";
    }

    /**
     * 新增保存学校成绩
     */
    @RequiresPermissions("system:schoolResult:add")
    @Log(title = "学校成绩", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolResult schoolResult)
    {
    	Long curriculumId=  schoolResult.getCurriculumId();
    	if(curriculumId != null) {
    		Coursemanagement coursemanagement= coursemanagementService.selectCoursemanagementById(curriculumId);
    		schoolResult.setCurriculumName(coursemanagement.getStudentsName());
    	}
        return toAjax(schoolResultService.insertSchoolResult(schoolResult));
    }

    /**
     * 修改学校成绩
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Coursemanagement coursemanagement =new Coursemanagement();
    	List<Coursemanagement> coursemanagementList= coursemanagementService.selectCoursemanagementList(coursemanagement);
    	mmap.put("coursemanagementList", coursemanagementList);
        SchoolResult schoolResult = schoolResultService.selectSchoolResultById(id);
        mmap.put("schoolResult", schoolResult);
        return prefix + "/edit";
    }

    /**
     * 修改保存学校成绩
     */
    @RequiresPermissions("system:schoolResult:edit")
    @Log(title = "学校成绩", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolResult schoolResult)
    {
    	Long curriculumId=  schoolResult.getCurriculumId();
    	if(curriculumId != null) {
    		Coursemanagement coursemanagement= coursemanagementService.selectCoursemanagementById(curriculumId);
    		schoolResult.setCurriculumName(coursemanagement.getStudentsName());
    	}
        return toAjax(schoolResultService.updateSchoolResult(schoolResult));
    }

    /**
     * 删除学校成绩
     */
    @RequiresPermissions("system:schoolResult:remove")
    @Log(title = "学校成绩", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolResultService.deleteSchoolResultByIds(ids));
    }
}
