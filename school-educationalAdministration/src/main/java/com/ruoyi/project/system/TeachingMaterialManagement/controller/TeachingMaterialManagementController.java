package com.ruoyi.project.system.TeachingMaterialManagement.controller;

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
import com.ruoyi.project.system.TeachingMaterialManagement.domain.TeachingMaterialManagement;
import com.ruoyi.project.system.TeachingMaterialManagement.service.ITeachingMaterialManagementService;

/**
 * 教材管理Controller
 * 
 * @author ruoyi
 * @date 2019-11-21
 */
@Controller
@RequestMapping("/system/TeachingMaterialManagement")
public class TeachingMaterialManagementController extends BaseController
{
    private String prefix = "system/TeachingMaterialManagement";

    @Autowired
    private ITeachingMaterialManagementService teachingMaterialManagementService;

    @RequiresPermissions("system:TeachingMaterialManagement:view")
    @GetMapping()
    public String TeachingMaterialManagement()
    {
        return prefix + "/TeachingMaterialManagement";
    }

    /**
     * 查询教材管理列表
     */
    @RequiresPermissions("system:TeachingMaterialManagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TeachingMaterialManagement teachingMaterialManagement)
    {
        startPage();
        List<TeachingMaterialManagement> list = teachingMaterialManagementService.selectTeachingMaterialManagementList(teachingMaterialManagement);
        return getDataTable(list);
    }

    /**
     * 导出教材管理列表
     */
    @RequiresPermissions("system:TeachingMaterialManagement:export")
    @Log(title = "教材管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachingMaterialManagement teachingMaterialManagement)
    {
        List<TeachingMaterialManagement> list = teachingMaterialManagementService.selectTeachingMaterialManagementList(teachingMaterialManagement);
        ExcelUtil<TeachingMaterialManagement> util = new ExcelUtil<TeachingMaterialManagement>(TeachingMaterialManagement.class);
        return util.exportExcel(list, "TeachingMaterialManagement");
    }

    /**
     * 新增教材管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教材管理
     */
    @RequiresPermissions("system:TeachingMaterialManagement:add")
    @Log(title = "教材管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TeachingMaterialManagement teachingMaterialManagement)
    {
        return toAjax(teachingMaterialManagementService.insertTeachingMaterialManagement(teachingMaterialManagement));
    }

    /**
     * 修改教材管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TeachingMaterialManagement teachingMaterialManagement = teachingMaterialManagementService.selectTeachingMaterialManagementById(id);
        mmap.put("teachingMaterialManagement", teachingMaterialManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存教材管理
     */
    @RequiresPermissions("system:TeachingMaterialManagement:edit")
    @Log(title = "教材管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TeachingMaterialManagement teachingMaterialManagement)
    {
        return toAjax(teachingMaterialManagementService.updateTeachingMaterialManagement(teachingMaterialManagement));
    }

    /**
     * 删除教材管理
     */
    @RequiresPermissions("system:TeachingMaterialManagement:remove")
    @Log(title = "教材管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(teachingMaterialManagementService.deleteTeachingMaterialManagementByIds(ids));
    }
}
