package com.ruoyi.project.system.WorkDraft.controller;

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
import com.ruoyi.project.system.WorkDraft.domain.WorkDraft;
import com.ruoyi.project.system.WorkDraft.service.IWorkDraftService;

/**
 * 工作制定Controller
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
@Controller
@RequestMapping("/system/WorkDraft")
public class WorkDraftController extends BaseController
{
    private String prefix = "system/WorkDraft";

    @Autowired
    private IWorkDraftService workDraftService;

    @RequiresPermissions("system:WorkDraft:view")
    @GetMapping()
    public String WorkDraft()
    {
        return prefix + "/WorkDraft";
    }

    /**
     * 查询工作制定列表
     */
    @RequiresPermissions("system:WorkDraft:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkDraft workDraft)
    {
        startPage();
        List<WorkDraft> list = workDraftService.selectWorkDraftList(workDraft);
        return getDataTable(list);
    }

    /**
     * 导出工作制定列表
     */
    @RequiresPermissions("system:WorkDraft:export")
    @Log(title = "工作制定", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkDraft workDraft)
    {
        List<WorkDraft> list = workDraftService.selectWorkDraftList(workDraft);
        ExcelUtil<WorkDraft> util = new ExcelUtil<WorkDraft>(WorkDraft.class);
        return util.exportExcel(list, "WorkDraft");
    }

    /**
     * 新增工作制定
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工作制定
     */
    @RequiresPermissions("system:WorkDraft:add")
    @Log(title = "工作制定", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkDraft workDraft)
    {
        return toAjax(workDraftService.insertWorkDraft(workDraft));
    }

    /**
     * 修改工作制定
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WorkDraft workDraft = workDraftService.selectWorkDraftById(id);
        mmap.put("workDraft", workDraft);
        return prefix + "/edit";
    }

    /**
     * 修改保存工作制定
     */
    @RequiresPermissions("system:WorkDraft:edit")
    @Log(title = "工作制定", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkDraft workDraft)
    {
        return toAjax(workDraftService.updateWorkDraft(workDraft));
    }

    /**
     * 删除工作制定
     */
    @RequiresPermissions("system:WorkDraft:remove")
    @Log(title = "工作制定", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workDraftService.deleteWorkDraftByIds(ids));
    }
}
