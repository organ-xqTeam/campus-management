package com.ruoyi.project.system.schoolpractice.controller;

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
import com.ruoyi.project.system.schoolpractice.domain.Schoolpractice;
import com.ruoyi.project.system.schoolpractice.service.ISchoolpracticeService;

/**
 * 综合实践Controller
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
@Controller
@RequestMapping("/system/schoolpractice")
public class SchoolpracticeController extends BaseController
{
    private String prefix = "system/schoolpractice";

    @Autowired
    private ISchoolpracticeService schoolpracticeService;

    @RequiresPermissions("system:schoolpractice:view")
    @GetMapping()
    public String schoolpractice()
    {
        return prefix + "/schoolpractice";
    }

    /**
     * 查询综合实践列表
     */
    @RequiresPermissions("system:schoolpractice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolpractice schoolpractice)
    {
        startPage();
        List<Schoolpractice> list = schoolpracticeService.selectSchoolpracticeList(schoolpractice);
        return getDataTable(list);
    }

    /**
     * 导出综合实践列表
     */
    @RequiresPermissions("system:schoolpractice:export")
    @Log(title = "时间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolpractice schoolpractice)
    {
        List<Schoolpractice> list = schoolpracticeService.selectSchoolpracticeList(schoolpractice);
        ExcelUtil<Schoolpractice> util = new ExcelUtil<Schoolpractice>(Schoolpractice.class);
        return util.exportExcel(list, "schoolpractice");
    }

    /**
     * 新增综合实践
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存综合实践
     */
    @RequiresPermissions("system:schoolpractice:add")
    @Log(title = "时间", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolpractice schoolpractice)
    {
        return toAjax(schoolpracticeService.insertSchoolpractice(schoolpractice));
    }

    /**
     * 修改综合实践
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolpractice schoolpractice = schoolpracticeService.selectSchoolpracticeById(id);
        mmap.put("schoolpractice", schoolpractice);
        return prefix + "/edit";
    }

    /**
     * 修改保存综合实践
     */
    @RequiresPermissions("system:schoolpractice:edit")
    @Log(title = "时间", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolpractice schoolpractice)
    {
        return toAjax(schoolpracticeService.updateSchoolpractice(schoolpractice));
    }

    /**
     * 删除综合实践
     */
    @RequiresPermissions("system:schoolpractice:remove")
    @Log(title = "时间", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolpracticeService.deleteSchoolpracticeByIds(ids));
    }
}
