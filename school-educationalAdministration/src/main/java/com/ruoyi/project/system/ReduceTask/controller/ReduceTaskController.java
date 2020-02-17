package com.ruoyi.project.system.ReduceTask.controller;

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
import com.ruoyi.project.system.CourseSystem.service.ICourseSystemService;
import com.ruoyi.project.system.ReduceTask.domain.ReduceTask;
import com.ruoyi.project.system.ReduceTask.service.IReduceTaskService;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;

/**
 * 实践任务管理Controller
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
@Controller
@RequestMapping("/system/ReduceTask")
public class ReduceTaskController extends BaseController
{
    private String prefix = "system/ReduceTask";

    @Autowired
    private IReduceTaskService reduceTaskService;
    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;
    @Autowired
    private ICoursemanagementService coursemanagementService;

    @RequiresPermissions("system:ReduceTask:view")
    @GetMapping()
    public String ReduceTask(Long cid, ModelMap mmap)
    {
    	Coursemanagement c = coursemanagementService.selectCoursemanagementById(cid);
    	mmap.put("course", c);
        return prefix + "/ReduceTask";
    }

    /**
     * 查询实践任务管理列表
     */
    @RequiresPermissions("system:ReduceTask:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ReduceTask reduceTask)
    {
        startPage();
        List<ReduceTask> list = reduceTaskService.selectReduceTaskList(reduceTask);
        return getDataTable(list);
    }

    /**
     * 导出实践任务管理列表
     */
    @RequiresPermissions("system:ReduceTask:export")
    @Log(title = "实践任务管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ReduceTask reduceTask)
    {
        List<ReduceTask> list = reduceTaskService.selectReduceTaskList(reduceTask);
        ExcelUtil<ReduceTask> util = new ExcelUtil<ReduceTask>(ReduceTask.class);
        return util.exportExcel(list, "ReduceTask");
    }

    /**
     * 新增实践任务管理
     */
    @GetMapping("/add")
    public String add(Long cid, ModelMap mmap)
    {
    	SchoolSpecialty schoolSpecialty =new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
    	mmap.put("cid", cid);
        return prefix + "/add";
    }

    /**
     * 新增保存实践任务管理
     */
    @RequiresPermissions("system:ReduceTask:add")
    @Log(title = "实践任务管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ReduceTask reduceTask)
    {
    	Long specialtyId=  reduceTask.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	reduceTask.setSpecialtyName(schoolSpecialty.getName());
        return toAjax(reduceTaskService.insertReduceTask(reduceTask));
    }

    /**
     * 修改实践任务管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	SchoolSpecialty schoolSpecialty =new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        ReduceTask reduceTask = reduceTaskService.selectReduceTaskById(id);
        mmap.put("reduceTask", reduceTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存实践任务管理
     */
    @RequiresPermissions("system:ReduceTask:edit")
    @Log(title = "实践任务管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ReduceTask reduceTask)
    {
    	Long specialtyId=  reduceTask.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	reduceTask.setSpecialtyName(schoolSpecialty.getName());
        return toAjax(reduceTaskService.updateReduceTask(reduceTask));
    }

    /**
     * 删除实践任务管理
     */
    @RequiresPermissions("system:ReduceTask:remove")
    @Log(title = "实践任务管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(reduceTaskService.deleteReduceTaskByIds(ids));
    }
}
