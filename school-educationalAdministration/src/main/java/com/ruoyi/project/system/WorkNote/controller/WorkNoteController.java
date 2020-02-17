package com.ruoyi.project.system.WorkNote.controller;

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
import com.ruoyi.project.system.WorkNote.domain.WorkNote;
import com.ruoyi.project.system.WorkNote.service.IWorkNoteService;
import com.ruoyi.system.domain.SysUser;

/**
 * 工作记录Controller
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
@Controller
@RequestMapping("/system/WorkNote")
public class WorkNoteController extends BaseController
{
    private String prefix = "system/WorkNote";

    @Autowired
    private IWorkNoteService workNoteService;
    @Autowired
    private ITeachingInfoService teachingInfoService;

    @RequiresPermissions("system:WorkNote:view")
    @GetMapping()
    public String WorkNote(ModelMap mmap)
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
        return prefix + "/WorkNote";
    }

    /**
     * 查询工作记录列表
     */
    @RequiresPermissions("system:WorkNote:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkNote workNote)
    {
        startPage();
        List<WorkNote> list = workNoteService.selectWorkNoteList(workNote);
        return getDataTable(list);
    }

    /**
     * 导出工作记录列表
     */
    @RequiresPermissions("system:WorkNote:export")
    @Log(title = "工作记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkNote workNote)
    {
        List<WorkNote> list = workNoteService.selectWorkNoteList(workNote);
        ExcelUtil<WorkNote> util = new ExcelUtil<WorkNote>(WorkNote.class);
        return util.exportExcel(list, "WorkNote");
    }

    /**
     * 新增工作记录
     */
    @GetMapping("/add")
    public String add(String tid, ModelMap mmap)
    {
    	mmap.put("tid", tid);
        return prefix + "/add";
    }

    /**
     * 新增保存工作记录
     */
    @RequiresPermissions("system:WorkNote:add")
    @Log(title = "工作记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkNote workNote)
    {
        return toAjax(workNoteService.insertWorkNote(workNote));
    }

    /**
     * 修改工作记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WorkNote workNote = workNoteService.selectWorkNoteById(id);
        mmap.put("workNote", workNote);
        return prefix + "/edit";
    }

    /**
     * 修改保存工作记录
     */
    @RequiresPermissions("system:WorkNote:edit")
    @Log(title = "工作记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkNote workNote)
    {
        return toAjax(workNoteService.updateWorkNote(workNote));
    }

    /**
     * 删除工作记录
     */
    @RequiresPermissions("system:WorkNote:remove")
    @Log(title = "工作记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workNoteService.deleteWorkNoteByIds(ids));
    }
}
