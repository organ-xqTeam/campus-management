package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.Schoolenterprisecooperation;
import com.ruoyi.system.service.ISchoolenterprisecooperationService;

/**
 * 校企合作Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/schoolenterprisecooperation")
public class SchoolenterprisecooperationController extends BaseController
{
    private String prefix = "system/schoolenterprisecooperation";

    @Autowired
    private ISchoolenterprisecooperationService schoolenterprisecooperationService;

    @RequiresPermissions("system:schoolenterprisecooperation:view")
    @GetMapping()
    public String schoolenterprisecooperation()
    {
        return prefix + "/schoolenterprisecooperation";
    }

    /**
     * 查询校企合作列表
     */
    @RequiresPermissions("system:schoolenterprisecooperation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolenterprisecooperation schoolenterprisecooperation)
    {
        startPage();
        List<Schoolenterprisecooperation> list = schoolenterprisecooperationService.selectSchoolenterprisecooperationList(schoolenterprisecooperation);
        return getDataTable(list);
    }

    /**
     * 导出校企合作列表
     */
    @RequiresPermissions("system:schoolenterprisecooperation:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolenterprisecooperation schoolenterprisecooperation)
    {
        List<Schoolenterprisecooperation> list = schoolenterprisecooperationService.selectSchoolenterprisecooperationList(schoolenterprisecooperation);
        ExcelUtil<Schoolenterprisecooperation> util = new ExcelUtil<Schoolenterprisecooperation>(Schoolenterprisecooperation.class);
        return util.exportExcel(list, "schoolenterprisecooperation");
    }

    /**
     * 新增校企合作
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存校企合作
     */
    @RequiresPermissions("system:schoolenterprisecooperation:add")
    @Log(title = "校企合作", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolenterprisecooperation schoolenterprisecooperation)
    {
        return toAjax(schoolenterprisecooperationService.insertSchoolenterprisecooperation(schoolenterprisecooperation));
    }

    /**
     * 修改校企合作
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolenterprisecooperation schoolenterprisecooperation = schoolenterprisecooperationService.selectSchoolenterprisecooperationById(id);
        mmap.put("schoolenterprisecooperation", schoolenterprisecooperation);
        return prefix + "/edit";
    }

    /**
     * 修改保存校企合作
     */
    @RequiresPermissions("system:schoolenterprisecooperation:edit")
    @Log(title = "校企合作", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolenterprisecooperation schoolenterprisecooperation)
    {
        return toAjax(schoolenterprisecooperationService.updateSchoolenterprisecooperation(schoolenterprisecooperation));
    }

    /**
     * 删除校企合作
     */
    @RequiresPermissions("system:schoolenterprisecooperation:remove")
    @Log(title = "校企合作", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolenterprisecooperationService.deleteSchoolenterprisecooperationByIds(ids));
    }
}
