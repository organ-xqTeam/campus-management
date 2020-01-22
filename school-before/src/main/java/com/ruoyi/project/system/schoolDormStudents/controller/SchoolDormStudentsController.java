package com.ruoyi.project.system.schoolDormStudents.controller;

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
import com.ruoyi.project.system.schoolDormStudents.domain.SchoolDormStudents;
import com.ruoyi.project.system.schoolDormStudents.service.ISchoolDormStudentsService;

/**
 * 宿舍学生Controller
 * 
 * @author ruoyi
 * @date 2019-11-15
 */
@Controller
@RequestMapping("/system/schoolDormStudents")
public class SchoolDormStudentsController extends BaseController
{
    private String prefix = "system/schoolDormStudents";

    @Autowired
    private ISchoolDormStudentsService schoolDormStudentsService;

    @RequiresPermissions("system:schoolDormStudents:view")
    @GetMapping()
    public String schoolDormStudents()
    {
        return prefix + "/schoolDormStudents";
    }

    /**
     * 查询宿舍学生列表
     */
    @RequiresPermissions("system:schoolDormStudents:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SchoolDormStudents schoolDormStudents)
    {
        startPage();
        List<SchoolDormStudents> list = schoolDormStudentsService.selectSchoolDormStudentsList(schoolDormStudents);
        return getDataTable(list);
    }

    /**
     * 导出宿舍学生列表
     */
    @RequiresPermissions("system:schoolDormStudents:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolDormStudents schoolDormStudents)
    {
        List<SchoolDormStudents> list = schoolDormStudentsService.selectSchoolDormStudentsList(schoolDormStudents);
        ExcelUtil<SchoolDormStudents> util = new ExcelUtil<SchoolDormStudents>(SchoolDormStudents.class);
        return util.exportExcel(list, "schoolDormStudents");
    }

    /**
     * 新增宿舍学生
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
   
    /**
     * 新增保存宿舍学生
     */
    @RequiresPermissions("system:schoolDormStudents:add")
    @Log(title = "宿舍学生", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolDormStudents schoolDormStudents)
    {
        return toAjax(schoolDormStudentsService.insertSchoolDormStudents(schoolDormStudents));
    }

    /**
     * 修改宿舍学生
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolDormStudents schoolDormStudents = schoolDormStudentsService.selectSchoolDormStudentsById(id);
        mmap.put("schoolDormStudents", schoolDormStudents);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍学生
     */
    @RequiresPermissions("system:schoolDormStudents:edit")
    @Log(title = "宿舍学生", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolDormStudents schoolDormStudents)
    {
        return toAjax(schoolDormStudentsService.updateSchoolDormStudents(schoolDormStudents));
    }

    /**
     * 删除宿舍学生
     */
    @RequiresPermissions("system:schoolDormStudents:remove")
    @Log(title = "宿舍学生", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolDormStudentsService.deleteSchoolDormStudentsByIds(ids));
    }
}
