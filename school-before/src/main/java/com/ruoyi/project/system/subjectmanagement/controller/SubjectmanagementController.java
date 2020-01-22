package com.ruoyi.project.system.subjectmanagement.controller;

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
import com.ruoyi.project.system.subjectmanagement.domain.Subjectmanagement;
import com.ruoyi.project.system.subjectmanagement.service.ISubjectmanagementService;

/**
 * 科目管理Controller
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Controller
@RequestMapping("/system/subjectmanagement")
public class SubjectmanagementController extends BaseController
{
    private String prefix = "system/subjectmanagement";

    @Autowired
    private ISubjectmanagementService subjectmanagementService;

    @RequiresPermissions("system:subjectmanagement:view")
    @GetMapping()
    public String subjectmanagement()
    {
        return prefix + "/subjectmanagement";
    }

    /**
     * 查询科目管理列表
     */
    @RequiresPermissions("system:subjectmanagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Subjectmanagement subjectmanagement)
    {
        startPage();
        List<Subjectmanagement> list = subjectmanagementService.selectSubjectmanagementList(subjectmanagement);
        return getDataTable(list);
    }

    /**
     * 导出科目管理列表
     */
    @RequiresPermissions("system:subjectmanagement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Subjectmanagement subjectmanagement)
    {
        List<Subjectmanagement> list = subjectmanagementService.selectSubjectmanagementList(subjectmanagement);
        ExcelUtil<Subjectmanagement> util = new ExcelUtil<Subjectmanagement>(Subjectmanagement.class);
        return util.exportExcel(list, "subjectmanagement");
    }

    /**
     * 新增科目管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存科目管理
     */
    @RequiresPermissions("system:subjectmanagement:add")
    @Log(title = "科目管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Subjectmanagement subjectmanagement)
    {
        return toAjax(subjectmanagementService.insertSubjectmanagement(subjectmanagement));
    }

    /**
     * 修改科目管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Subjectmanagement subjectmanagement = subjectmanagementService.selectSubjectmanagementById(id);
        mmap.put("subjectmanagement", subjectmanagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存科目管理
     */
    @RequiresPermissions("system:subjectmanagement:edit")
    @Log(title = "科目管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Subjectmanagement subjectmanagement)
    {
        return toAjax(subjectmanagementService.updateSubjectmanagement(subjectmanagement));
    }

    /**
     * 删除科目管理
     */
    @RequiresPermissions("system:subjectmanagement:remove")
    @Log(title = "科目管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(subjectmanagementService.deleteSubjectmanagementByIds(ids));
    }
}
