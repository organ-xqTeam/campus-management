package com.ruoyi.project.system.schooldorm.controller;

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
import com.ruoyi.project.system.schooldorm.domain.Schooldorm;
import com.ruoyi.project.system.schooldorm.service.ISchooldormService;

/**
 * 宿舍Controller
 * 
 * @author ruoyi
 * @date 2019-11-14
 */
@Controller
@RequestMapping("/system/schooldorm")
public class SchooldormController extends BaseController
{
    private String prefix = "system/schooldorm";

    @Autowired
    private ISchooldormService schooldormService;

    @RequiresPermissions("system:schooldorm:view")
    @GetMapping()
    public String schooldorm()
    {
        return prefix + "/schooldorm";
    }

    /**
     * 查询宿舍列表
     */
    @RequiresPermissions("system:schooldorm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schooldorm schooldorm)
    {
        startPage();
        List<Schooldorm> list = schooldormService.selectSchooldormList(schooldorm);
        return getDataTable(list);
    }

    /**
     * 导出宿舍列表
     */
    @RequiresPermissions("system:schooldorm:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schooldorm schooldorm)
    {
        List<Schooldorm> list = schooldormService.selectSchooldormList(schooldorm);
        ExcelUtil<Schooldorm> util = new ExcelUtil<Schooldorm>(Schooldorm.class);
        return util.exportExcel(list, "schooldorm");
    }

    /**
     * 新增宿舍
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍
     */
    @RequiresPermissions("system:schooldorm:add")
    @Log(title = "宿舍", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schooldorm schooldorm)
    {
        return toAjax(schooldormService.insertSchooldorm(schooldorm));
    }

    /**
     * 修改宿舍
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schooldorm schooldorm = schooldormService.selectSchooldormById(id);
        mmap.put("schooldorm", schooldorm);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍
     */
    @RequiresPermissions("system:schooldorm:edit")
    @Log(title = "宿舍", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schooldorm schooldorm)
    {
        return toAjax(schooldormService.updateSchooldorm(schooldorm));
    }

    /**
     * 删除宿舍
     */
    @RequiresPermissions("system:schooldorm:remove")
    @Log(title = "宿舍", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schooldormService.deleteSchooldormByIds(ids));
    }
}
