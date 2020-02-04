package com.ruoyi.project.system.schoolassets.controller;

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
import com.ruoyi.project.system.schoolassets.domain.Schoolassets;
import com.ruoyi.project.system.schoolassets.service.ISchoolassetsService;

/**
 * 资产管理Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/system/schoolassets")
public class SchoolassetsController extends BaseController
{
    private String prefix = "system/schoolassets";

    @Autowired
    private ISchoolassetsService schoolassetsService;

    @RequiresPermissions("system:schoolassets:view")
    @GetMapping()
    public String schoolassets()
    {
        return prefix + "/schoolassets";
    }

    /**
     * 查询资产管理列表
     */
    @RequiresPermissions("system:schoolassets:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolassets schoolassets)
    {
        startPage();
        List<Schoolassets> list = schoolassetsService.selectSchoolassetsList(schoolassets);
        return getDataTable(list);
    }

    /**
     * 导出资产管理列表
     */
    @RequiresPermissions("system:schoolassets:export")
    @Log(title = "资产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolassets schoolassets)
    {
        List<Schoolassets> list = schoolassetsService.selectSchoolassetsList(schoolassets);
        ExcelUtil<Schoolassets> util = new ExcelUtil<Schoolassets>(Schoolassets.class);
        return util.exportExcel(list, "schoolassets");
    }

    /**
     * 新增资产管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资产管理
     */
    @RequiresPermissions("system:schoolassets:add")
    @Log(title = "资产", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolassets schoolassets)
    {
        return toAjax(schoolassetsService.insertSchoolassets(schoolassets));
    }

    /**
     * 修改资产管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolassets schoolassets = schoolassetsService.selectSchoolassetsById(id);
        mmap.put("schoolassets", schoolassets);
        return prefix + "/edit";
    }

    /**
     * 修改保存资产管理
     */
    @RequiresPermissions("system:schoolassets:edit")
    @Log(title = "资产", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolassets schoolassets)
    {
        return toAjax(schoolassetsService.updateSchoolassets(schoolassets));
    }

    /**
     * 删除资产管理
     */
    @RequiresPermissions("system:schoolassets:remove")
    @Log(title = "资产", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolassetsService.deleteSchoolassetsByIds(ids));
    }
}
