package com.ruoyi.project.system.schoolenrollmentmanagement.controller;

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
import com.ruoyi.project.system.schoolenrollmentmanagement.domain.Schoolenrollmentmanagement;
import com.ruoyi.project.system.schoolenrollmentmanagement.service.ISchoolenrollmentmanagementService;

/**
 * 招生管理Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/schoolenrollmentmanagement")
public class SchoolenrollmentmanagementController extends BaseController
{
    private String prefix = "system/schoolenrollmentmanagement";

    @Autowired
    private ISchoolenrollmentmanagementService schoolenrollmentmanagementService;

    @RequiresPermissions("system:schoolenrollmentmanagement:view")
    @GetMapping()
    public String schoolenrollmentmanagement()
    {
        return prefix + "/schoolenrollmentmanagement";
    }

    /**
     * 查询招生管理列表
     */
    @RequiresPermissions("system:schoolenrollmentmanagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolenrollmentmanagement schoolenrollmentmanagement)
    {
        startPage();
        List<Schoolenrollmentmanagement> list = schoolenrollmentmanagementService.selectSchoolenrollmentmanagementList(schoolenrollmentmanagement);
        return getDataTable(list);
    }

    /**
     * 导出招生管理列表
     */
    @RequiresPermissions("system:schoolenrollmentmanagement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolenrollmentmanagement schoolenrollmentmanagement)
    {
        List<Schoolenrollmentmanagement> list = schoolenrollmentmanagementService.selectSchoolenrollmentmanagementList(schoolenrollmentmanagement);
        ExcelUtil<Schoolenrollmentmanagement> util = new ExcelUtil<Schoolenrollmentmanagement>(Schoolenrollmentmanagement.class);
        return util.exportExcel(list, "schoolenrollmentmanagement");
    }

    /**
     * 新增招生管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存招生管理
     */
    @RequiresPermissions("system:schoolenrollmentmanagement:add")
    @Log(title = "招生管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolenrollmentmanagement schoolenrollmentmanagement)
    {
        return toAjax(schoolenrollmentmanagementService.insertSchoolenrollmentmanagement(schoolenrollmentmanagement));
    }

    /**
     * 修改招生管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolenrollmentmanagement schoolenrollmentmanagement = schoolenrollmentmanagementService.selectSchoolenrollmentmanagementById(id);
        mmap.put("schoolenrollmentmanagement", schoolenrollmentmanagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存招生管理
     */
    @RequiresPermissions("system:schoolenrollmentmanagement:edit")
    @Log(title = "招生管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolenrollmentmanagement schoolenrollmentmanagement)
    {
        return toAjax(schoolenrollmentmanagementService.updateSchoolenrollmentmanagement(schoolenrollmentmanagement));
    }

    /**
     * 删除招生管理
     */
    @RequiresPermissions("system:schoolenrollmentmanagement:remove")
    @Log(title = "招生管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolenrollmentmanagementService.deleteSchoolenrollmentmanagementByIds(ids));
    }
}
