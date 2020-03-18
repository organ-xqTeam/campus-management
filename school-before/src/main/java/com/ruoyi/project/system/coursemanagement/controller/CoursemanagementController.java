package com.ruoyi.project.system.coursemanagement.controller;

import java.util.List;

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
import com.ruoyi.project.system.CourseSystem.domain.CourseSystem;
import com.ruoyi.project.system.CourseSystem.service.ICourseSystemService;
import com.ruoyi.project.system.SchoolBelong.domain.SchoolBelong;
import com.ruoyi.project.system.SchoolBelong.service.ISchoolBelongService;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.project.system.subjectmanagement.domain.Subjectmanagement;
import com.ruoyi.project.system.subjectmanagement.service.ISubjectmanagementService;
import com.ruoyi.system.domain.SysUser;

/**
 * 课程管理Controller
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Controller
@RequestMapping("/system/coursemanagement")
public class CoursemanagementController extends BaseController
{
    private String prefix = "system/coursemanagement";

    @Autowired
    private ISchoolBelongService schoolBelongService;
    @Autowired
    private ICourseSystemService courseSystemService;
    @Autowired
    private ICoursemanagementService coursemanagementService;    
    @Autowired
    private ISubjectmanagementService  subjectmanagementService;
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;
    
    @Autowired
    private ITeachingInfoService teachingInfoService;
    @RequiresPermissions("system:coursemanagement:view")
    @GetMapping()
    public String coursemanagement()
    {
        return prefix + "/coursemanagement";
    }
    /**
     * 学生查看课程证书页
     * */
    @RequiresPermissions("system:coursemanagement:view")
    @GetMapping("/coursemanagement2")
    public String coursemanagement2(ModelMap mmap)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	Schoolstudentslist stu = new Schoolstudentslist();
    	stu.setUserId(me.getUserId());
        List<Schoolstudentslist> schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistList(stu);
        if (schoolstudentslist.size() == 1) {
        	mmap.put("studentid", schoolstudentslist.get(0).getId());
        }    	
        return prefix + "/coursemanagement2";
    }
    
    @GetMapping("/viewedit/{id}")
    public String viewedit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Coursemanagement course = new Coursemanagement();
    	course = coursemanagementService.selectCoursemanagementById(id);
    	mmap.put("course", course);
    	TeachingInfo teachingInfo =new TeachingInfo();
    	teachingInfo.setDelFlag((long)0);
    	List<TeachingInfo> teachingInfoList=  teachingInfoService.selectTeachingInfoList(teachingInfo);
    	mmap.put("teachingInfoList", teachingInfoList);
        return prefix + "/viewedit";
    }

    /**
     * 查询课程管理列表
     */
    @RequiresPermissions("system:coursemanagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Coursemanagement coursemanagement)
    {
        startPage();
        List<Coursemanagement> list = coursemanagementService.selectCoursemanagementList(coursemanagement);
        return getDataTable(list);
    }

    /**
     * 导出课程管理列表
     */
    @RequiresPermissions("system:coursemanagement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Coursemanagement coursemanagement)
    {
        List<Coursemanagement> list = coursemanagementService.selectCoursemanagementList(coursemanagement);
        ExcelUtil<Coursemanagement> util = new ExcelUtil<Coursemanagement>(Coursemanagement.class);
        return util.exportExcel(list, "coursemanagement");
    }

    /**
     * 新增课程管理
     */
    @GetMapping("/add")
    public String add( ModelMap mmap)
    {
    	
    	
    	//查询所有科目
    	Subjectmanagement subjectmanagement =new Subjectmanagement();
    	List<Subjectmanagement> subjectmanagementList= subjectmanagementService.selectSubjectmanagementList(subjectmanagement);
    	mmap.put("subjectmanagementList", subjectmanagementList);
    	//查询所有教师
    	TeachingInfo teachingInfo =new TeachingInfo();
    	List<TeachingInfo> teachingInfoList= teachingInfoService.selectTeachingInfoList(teachingInfo);
    	mmap.put("teachingInfoList", teachingInfoList);
    	SchoolBelong sb = new SchoolBelong();
    	List<SchoolBelong> sblist = schoolBelongService.selectSchoolBelongList(sb);
    	mmap.put("sblist", sblist);
    	CourseSystem cs = new CourseSystem();
    	List<CourseSystem> cslist = courseSystemService.selectCourseSystemList(cs);
    	mmap.put("cslist", cslist);
        return prefix + "/add";
    }

    /**
     * 新增保存课程管理
     */
    @RequiresPermissions("system:coursemanagement:add")
    @Log(title = "课程管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Coursemanagement coursemanagement)
    {
    	
        return toAjax(coursemanagementService.insertCoursemanagement(coursemanagement));
    }

    /**
     * 修改课程管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Coursemanagement coursemanagement = coursemanagementService.selectCoursemanagementById(id);
        mmap.put("coursemanagement", coursemanagement);
        Subjectmanagement subjectmanagement =new Subjectmanagement();
        List<Subjectmanagement> subjectmanagementList= subjectmanagementService.selectSubjectmanagementList(subjectmanagement);
    	mmap.put("subjectmanagementList", subjectmanagementList);
    	//查询所有教师
    	TeachingInfo teachingInfo =new TeachingInfo();
    	List<TeachingInfo> teachingInfoList= teachingInfoService.selectTeachingInfoList(teachingInfo);
    	mmap.put("teachingInfoList", subjectmanagementList);
    	mmap.put("teachingInfoList", teachingInfoList);
    	SchoolBelong sb = new SchoolBelong();
    	List<SchoolBelong> sblist = schoolBelongService.selectSchoolBelongList(sb);
    	mmap.put("sblist", sblist);
    	CourseSystem cs = new CourseSystem();
    	List<CourseSystem> cslist = courseSystemService.selectCourseSystemList(cs);
    	mmap.put("cslist", cslist);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程管理
     */
    @RequiresPermissions("system:coursemanagement:edit")
    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Coursemanagement coursemanagement)
    {
        return toAjax(coursemanagementService.updateCoursemanagement(coursemanagement));
    }
    
    /**
     * 删除课程管理
     */
    @RequiresPermissions("system:coursemanagement:remove")
    @Log(title = "课程管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(coursemanagementService.deleteCoursemanagementByIds(ids));
    }
}
