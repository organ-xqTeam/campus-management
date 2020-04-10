package com.ruoyi.project.system.schoolHomeworkDetail.controller;

import java.util.List;
import java.util.Map;
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
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolHomeworkDetail.domain.SchoolHomeworkDetail;
import com.ruoyi.project.system.schoolHomeworkDetail.service.ISchoolHomeworkDetailService;
import com.ruoyi.project.system.schoolHomeworkDetailDetail.domain.SchoolHomeworkDetailDetail;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;

/**
 * 学校作业表Controller
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
@Controller
@RequestMapping("/system/schoolHomeworkDetail")
public class SchoolHomeworkDetailController extends BaseController
{
    private String prefix = "system/schoolHomeworkDetail";

    @Autowired
    private ISchoolHomeworkDetailService schoolHomeworkDetailService;
    @Autowired
    private ISchoolgradelistService  schoolgradelistService;
    @Autowired
    private ISchoolClassService schoolClassService;
    
    @RequiresPermissions("system:schoolHomeworkDetail:view")
    @GetMapping()
    public String schoolHomeworkDetail(String id,ModelMap mmap)
    {
    	System.out.println(id);
    	mmap.put("homeworkId", id);
    	//查询所有年级
    	Schoolgradelist schoolgradelist = new Schoolgradelist();
    	List<Schoolgradelist> schoolgradelistList= schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("schoolgradelistList", schoolgradelistList);
    	SchoolClass schoolClass =new SchoolClass();
    	List<SchoolClass> schoolClassList= schoolClassService.selectSchoolClassList(schoolClass);
    	mmap.put("schoolClassList", schoolClassList);
        return prefix + "/schoolHomeworkDetail";
    }

    /**
     * 查询学校作业表列表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam Map<String, Object> parmMap)
    {
    	System.out.println(parmMap);
        startPage();
        //通过HomeworkId 查找HomeworkDetail关联得学生信息
        List<Map<String, Object>> list = schoolHomeworkDetailService.selectSchoolHomeworkDetailStudentsListByHomeworkId(parmMap);
        return getDataTable(list);
    }

    /**
     * 导出学校作业表列表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:export")
    @Log(title = "学校作业表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolHomeworkDetail schoolHomeworkDetail)
    {
        List<SchoolHomeworkDetail> list = schoolHomeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
        ExcelUtil<SchoolHomeworkDetail> util = new ExcelUtil<SchoolHomeworkDetail>(SchoolHomeworkDetail.class);
        return util.exportExcel(list, "schoolHomeworkDetail");
    }

    /**
     * 新增学校作业表
     */
    @GetMapping("/add")
    public String add(String studentid, String detailid, String ontest, ModelMap mmap)
    {
    	if(studentid!=null&&!"undefined".equals(studentid)) {
    		mmap.put("studentid", studentid);
    	}
    	else {
    		mmap.put("studentid", "");
    	}
    	if(detailid!=null&&!"undefined".equals(detailid)) {
    		mmap.put("detailid", detailid);
    	}
    	else {
    		mmap.put("detailid", "");
    	}
    	if(ontest!=null&&!"undefined".equals(ontest)) {
    		mmap.put("ontest", ontest);
    	}
    	else {
    		mmap.put("ontest", "");
    	}
        return prefix + "/add";
    }

    /**
     * 新增保存学校作业表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:add")
    @Log(title = "学校作业表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolHomeworkDetailDetail detail)
    {
        return toAjax(schoolHomeworkDetailService.updateSchoolHomeworkDetail(detail));
    }

    /**
     * 修改学校作业表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolHomeworkDetail schoolHomeworkDetail = schoolHomeworkDetailService.selectSchoolHomeworkDetailById(id);
        mmap.put("schoolHomeworkDetail", schoolHomeworkDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存学校作业表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:edit")
    @Log(title = "学校作业表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolHomeworkDetail schoolHomeworkDetail)
    {
        return toAjax(true);
    }

    /**
     * 删除学校作业表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:remove")
    @Log(title = "学校作业表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolHomeworkDetailService.deleteSchoolHomeworkDetailByIds(ids));
    }
}
