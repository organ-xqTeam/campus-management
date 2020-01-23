package com.ruoyi.project.system.schoolchargemanagement.controller;

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
import com.ruoyi.project.system.schoolchargemanagement.domain.Schoolchargemanagement;
import com.ruoyi.project.system.schoolchargemanagement.service.ISchoolchargemanagementService;

/**
 * 收费管理Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/schoolchargemanagement")
public class SchoolchargemanagementController extends BaseController
{
    private String prefix = "system/schoolchargemanagement";
    
    @Autowired
    private ISchoolchargemanagementService schoolchargemanagementService;

    @RequiresPermissions("system:schoolchargemanagement:view")
    @GetMapping()
    public String schoolchargemanagement()
    {
        return prefix + "/schoolchargemanagement";
    }

    /**
     * 查询收费管理列表
     */
    @RequiresPermissions("system:schoolchargemanagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolchargemanagement schoolchargemanagement)
    {
        startPage();
        List<Schoolchargemanagement> list = schoolchargemanagementService.selectSchoolchargemanagementList(schoolchargemanagement);
        return getDataTable(list);
    }

    /**
     * 导出收费管理列表
     */
    @RequiresPermissions("system:schoolchargemanagement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolchargemanagement schoolchargemanagement)
    {
        List<Schoolchargemanagement> list = schoolchargemanagementService.selectSchoolchargemanagementList(schoolchargemanagement);
        ExcelUtil<Schoolchargemanagement> util = new ExcelUtil<Schoolchargemanagement>(Schoolchargemanagement.class);
        return util.exportExcel(list, "schoolchargemanagement");
    }

    /**
     * 新增收费管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存收费管理
     */
    @RequiresPermissions("system:schoolchargemanagement:add")
    @Log(title = "收费管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolchargemanagement schoolchargemanagement)
    {
        return toAjax(schoolchargemanagementService.insertSchoolchargemanagement(schoolchargemanagement));
    }

    /**
     * 修改收费管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolchargemanagement schoolchargemanagement = schoolchargemanagementService.selectSchoolchargemanagementById(id);
        mmap.put("schoolchargemanagement", schoolchargemanagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存收费管理
     */
    @RequiresPermissions("system:schoolchargemanagement:edit")
    @Log(title = "收费管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolchargemanagement schoolchargemanagement)
    {
        return toAjax(schoolchargemanagementService.updateSchoolchargemanagement(schoolchargemanagement));
    }

    /**
     * 删除收费管理
     */
    @RequiresPermissions("system:schoolchargemanagement:remove")
    @Log(title = "收费管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolchargemanagementService.deleteSchoolchargemanagementByIds(ids));
    }
    
    @Log(title = "收费管理修改状态", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:schoolchargemanagement:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Schoolchargemanagement schoolchargemanagement)
    {
        return toAjax(schoolchargemanagementService.changeStatus(schoolchargemanagement));
    }
    
}
