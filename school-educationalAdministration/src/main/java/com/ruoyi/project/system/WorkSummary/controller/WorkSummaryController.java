package com.ruoyi.project.system.WorkSummary.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
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
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.WorkSummary.domain.WorkSummary;
import com.ruoyi.project.system.WorkSummary.service.IWorkSummaryService;
import com.ruoyi.system.domain.SysUser;

/**
 * 工作总结Controller
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
@Controller
@RequestMapping("/system/WorkSummary")
public class WorkSummaryController extends BaseController
{
    private String prefix = "system/WorkSummary";

    @Autowired
    private IWorkSummaryService workSummaryService;
    @Autowired
    private ITeachingInfoService teachingInfoService;

    @RequiresPermissions("system:WorkSummary:view")
    @GetMapping()
    public String WorkSummary(ModelMap mmap)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	TeachingInfo t = new TeachingInfo();
    	t.setUserId(me.getUserId());
    	List<TeachingInfo> tl = teachingInfoService.selectTeachingInfoList(t);
    	if (tl.size() > 0) {
        	mmap.put("teacher", tl.get(0));
    	}
    	else {
        	mmap.put("teacher", t);
    	}
        return prefix + "/WorkSummary";
    }

    /**
     * 查询工作总结列表
     */
    @RequiresPermissions("system:WorkSummary:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkSummary workSummary)
    {
        startPage();
        List<WorkSummary> list = workSummaryService.selectWorkSummaryList(workSummary);
        return getDataTable(list);
    }

    /**
     * 导出工作总结列表
     */
    @RequiresPermissions("system:WorkSummary:export")
    @Log(title = "工作总结", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkSummary workSummary)
    {
        List<WorkSummary> list = workSummaryService.selectWorkSummaryList(workSummary);
        ExcelUtil<WorkSummary> util = new ExcelUtil<WorkSummary>(WorkSummary.class);
        return util.exportExcel(list, "WorkSummary");
    }

    /**
     * 新增工作总结
     */
    @GetMapping("/add")
    public String add(String tid, ModelMap mmap)
    {
    	mmap.put("tid", tid);
        return prefix + "/add";
    }

    /**
     * 新增保存工作总结
     */
    @RequiresPermissions("system:WorkSummary:add")
    @Log(title = "工作总结", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkSummary workSummary)
    {
        return toAjax(workSummaryService.insertWorkSummary(workSummary));
    }

    /**
     * 修改工作总结
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WorkSummary workSummary = workSummaryService.selectWorkSummaryById(id);
        mmap.put("workSummary", workSummary);
        return prefix + "/edit";
    }

    /**
     * 修改保存工作总结
     */
    @RequiresPermissions("system:WorkSummary:edit")
    @Log(title = "工作总结", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkSummary workSummary)
    {
        return toAjax(workSummaryService.updateWorkSummary(workSummary));
    }

    /**
     * 删除工作总结
     */
    @RequiresPermissions("system:WorkSummary:remove")
    @Log(title = "工作总结", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workSummaryService.deleteWorkSummaryByIds(ids));
    }
}
