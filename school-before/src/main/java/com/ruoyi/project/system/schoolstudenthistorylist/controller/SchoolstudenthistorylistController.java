package com.ruoyi.project.system.schoolstudenthistorylist.controller;

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
import com.ruoyi.project.system.schoolstudenthistorylist.domain.Schoolstudenthistorylist;
import com.ruoyi.project.system.schoolstudenthistorylist.service.ISchoolstudenthistorylistService;

/**
 * 调班历史Controller
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
@Controller
@RequestMapping("/system/schoolstudenthistorylist")
public class SchoolstudenthistorylistController extends BaseController
{
    private String prefix = "system/schoolstudenthistorylist";

    @Autowired
    private ISchoolstudenthistorylistService schoolstudenthistorylistService;

    @RequiresPermissions("system:schoolstudenthistorylist:view")
    @GetMapping()
    public String schoolstudenthistorylist()
    {
        return prefix + "/schoolstudenthistorylist";
    }

    /**
     * 查询调班历史列表
     */
    @RequiresPermissions("system:schoolstudenthistorylist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolstudenthistorylist schoolstudenthistorylist)
    {
        startPage();
        List<Schoolstudenthistorylist> list = schoolstudenthistorylistService.selectSchoolstudenthistorylistList(schoolstudenthistorylist);
        return getDataTable(list);
    }

    /**
     * 导出调班历史列表
     */
    @RequiresPermissions("system:schoolstudenthistorylist:export")
    @Log(title = "调班历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolstudenthistorylist schoolstudenthistorylist)
    {
        List<Schoolstudenthistorylist> list = schoolstudenthistorylistService.selectSchoolstudenthistorylistList(schoolstudenthistorylist);
        ExcelUtil<Schoolstudenthistorylist> util = new ExcelUtil<Schoolstudenthistorylist>(Schoolstudenthistorylist.class);
        return util.exportExcel(list, "schoolstudenthistorylist");
    }

    /**
     * 新增调班历史
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存调班历史
     */
    @RequiresPermissions("system:schoolstudenthistorylist:add")
    @Log(title = "调班历史", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolstudenthistorylist schoolstudenthistorylist)
    {
        return toAjax(schoolstudenthistorylistService.insertSchoolstudenthistorylist(schoolstudenthistorylist));
    }

    /**
     * 修改调班历史
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolstudenthistorylist schoolstudenthistorylist = schoolstudenthistorylistService.selectSchoolstudenthistorylistById(id);
        mmap.put("schoolstudenthistorylist", schoolstudenthistorylist);
        return prefix + "/edit";
    }

    /**
     * 修改保存调班历史
     */
    @RequiresPermissions("system:schoolstudenthistorylist:edit")
    @Log(title = "调班历史", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolstudenthistorylist schoolstudenthistorylist)
    {
        return toAjax(schoolstudenthistorylistService.updateSchoolstudenthistorylist(schoolstudenthistorylist));
    }

    /**
     * 删除调班历史
     */
    @RequiresPermissions("system:schoolstudenthistorylist:remove")
    @Log(title = "调班历史", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolstudenthistorylistService.deleteSchoolstudenthistorylistByIds(ids));
    }
}
