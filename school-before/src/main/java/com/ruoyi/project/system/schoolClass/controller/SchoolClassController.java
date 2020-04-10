package com.ruoyi.project.system.schoolClass.controller;

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
import com.ruoyi.project.system.SchoolBelong.domain.SchoolBelong;
import com.ruoyi.project.system.SchoolBelong.service.ISchoolBelongService;
import com.ruoyi.project.system.classschedulingmanagement.domain.Classschedulingmanagement;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;
import com.ruoyi.project.system.schoolstudenthistorylist.domain.Schoolstudenthistorylist;
import com.ruoyi.project.system.schoolstudenthistorylist.service.ISchoolstudenthistorylistService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;

/**
 * 学校班级表Controller
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
@Controller
@RequestMapping("/system/schoolClass")
public class SchoolClassController extends BaseController
{
    private String prefix = "system/schoolClass";

    @Autowired
    private ISchoolClassService schoolClassService;
    
    @Autowired
    private ISchoolgradelistService schoolgradelistService;
    
    @Autowired
    private ISchoolstudenthistorylistService schoolstudenthistorylistService;
    @Autowired
    private ISchoolBelongService schoolBelongService;

    @RequiresPermissions("system:schoolClass:view")
    @GetMapping()
    public String schoolClass(ModelMap mmap)
    {
    	Schoolgradelist schoolgradelist = new Schoolgradelist();
    	schoolgradelist.setDelFlag((long)0);
    	List<Schoolgradelist> schoolgradelistList = schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("gradelist", schoolgradelistList);
        return prefix + "/schoolClass";
    }
    
    /**
     * 课程表列表
     */
    @GetMapping("/kechengbiao")
    public String kechengbiao(Classschedulingmanagement kechengbiao, ModelMap mmap)
    {
    	
    	mmap.put("kechengbiao", kechengbiao);
        return prefix + "/kechengbiao";
    }
    
    /**
     * 班级学生列表
     */
    @RequiresPermissions("system:schoolClass:classstudentlist")
    @GetMapping("/classstudentlist")
    public String classstudentlist(@RequestParam("ssname") String ssname, @RequestParam("classId") String classId, ModelMap mmap)
    {
    	mmap.put("ssname", ssname);
    	mmap.put("classId", classId);
        return prefix + "/classstudentlist";
    }
    public String classstudentlist(Schoolstudentslist student, ModelMap mmap)
    {
    	mmap.put("student", student);
        return prefix + "/classstudentlist";
    }
    
    /**
     * 调班
     */
    @RequiresPermissions("system:schoolClass:editclass")
    @GetMapping("/editclass")
    public String editclass(Schoolstudentslist student, ModelMap mmap)
    {
    	SchoolClass class_ = new SchoolClass();
    	class_.setDeleteFlag("0");
    	List<SchoolClass> class2 = schoolClassService.selectSchoolClassList(class_);
    	
    	mmap.put("schoolClass", class2);
    	mmap.put("student", student);
    	SchoolBelong sb = new SchoolBelong();
    	List<SchoolBelong> sblist = schoolBelongService.selectSchoolBelongList(sb);
    	mmap.put("sblist", sblist);
        return prefix + "/editclass";
    }
    
    /**
     * 调班历史
     */
    @GetMapping("/history")
    public String history(Schoolstudenthistorylist history, ModelMap mmap)
    {
    	List<Schoolstudenthistorylist> list = schoolstudenthistorylistService.selectSchoolstudenthistorylistList(history);
    	mmap.put("list", list);
        return prefix + "/history";
    }
    
    /**
     * 筛选班级
     * */
    @GetMapping("/selectclass")
    @ResponseBody
    public List<SchoolClass> selectclass(SchoolClass sc)
    {
    	List<SchoolClass> sclist = schoolClassService.selectSchoolClassList(sc);
        return sclist;
    }

    /**
     * 查询学校班级表列表
     */
    @RequiresPermissions("system:schoolClass:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SchoolClass schoolClass)
    {
        startPage();
        List<SchoolClass> list = schoolClassService.selectSchoolClassList(schoolClass);
        return getDataTable(list);
    }

    /**
     * 导出学校班级表列表
     */
    @RequiresPermissions("system:schoolClass:export")
    @Log(title = "学校班级表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolClass schoolClass)
    {
        List<SchoolClass> list = schoolClassService.selectSchoolClassList(schoolClass);
        ExcelUtil<SchoolClass> util = new ExcelUtil<SchoolClass>(SchoolClass.class);
        return util.exportExcel(list, "schoolClass");
    }

    /**
     * 新增学校班级表
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	Schoolgradelist schoolgradelist = new Schoolgradelist();
    	schoolgradelist.setDelFlag((long)0);
    	List<Schoolgradelist> schoolgradelistList = schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("gradelist", schoolgradelistList);
    	SchoolBelong sb = new SchoolBelong();
    	List<SchoolBelong> sblist = schoolBelongService.selectSchoolBelongList(sb);
    	mmap.put("sblist", sblist);
        return prefix + "/add";
    }

    /**
     * 新增保存学校班级表
     */
    @RequiresPermissions("system:schoolClass:add")
    @Log(title = "学校班级表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolClass schoolClass)
    {
        return toAjax(schoolClassService.insertSchoolClass(schoolClass));
    }

    /**
     * 修改学校班级表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolgradelist schoolgradelist = new Schoolgradelist();
    	schoolgradelist.setDelFlag((long)0);
    	List<Schoolgradelist> schoolgradelistList = schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("gradelist", schoolgradelistList);
        SchoolClass schoolClass = schoolClassService.selectSchoolClassById(id);
        mmap.put("schoolClass", schoolClass);
    	SchoolBelong sb = new SchoolBelong();
    	List<SchoolBelong> sblist = schoolBelongService.selectSchoolBelongList(sb);
    	mmap.put("sblist", sblist);
        return prefix + "/edit";
    }

    /**
     * 修改保存学校班级表
     */
    @RequiresPermissions("system:schoolClass:edit")
    @Log(title = "学校班级表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolClass schoolClass)
    {
        return toAjax(schoolClassService.updateSchoolClass(schoolClass));
    }

    /**
     * 删除学校班级表
     */
    @RequiresPermissions("system:schoolClass:remove")
    @Log(title = "学校班级表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolClassService.deleteSchoolClassByIds(ids));
    }
}
