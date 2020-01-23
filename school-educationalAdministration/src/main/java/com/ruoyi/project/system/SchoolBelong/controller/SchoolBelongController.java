package com.ruoyi.project.system.SchoolBelong.controller;

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
import com.ruoyi.project.system.SchoolBelong.domain.SchoolBelong;
import com.ruoyi.project.system.SchoolBelong.service.ISchoolBelongService;

/**
 * 学院分属Controller
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
@Controller
@RequestMapping("/system/SchoolBelong")
public class SchoolBelongController extends BaseController
{
    private String prefix = "system/SchoolBelong";

    @Autowired
    private ISchoolBelongService schoolBelongService;

    @RequiresPermissions("system:SchoolBelong:view")
    @GetMapping()
    public String SchoolBelong()
    {
        return prefix + "/SchoolBelong";
    }

    /**
     * 查询学院分属列表
     */
    @RequiresPermissions("system:SchoolBelong:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SchoolBelong schoolBelong)
    {
        startPage();
        List<SchoolBelong> list = schoolBelongService.selectSchoolBelongList(schoolBelong);
        return getDataTable(list);
    }

    /**
     * 导出学院分属列表
     */
    @RequiresPermissions("system:SchoolBelong:export")
    @Log(title = "学院分属", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolBelong schoolBelong)
    {
        List<SchoolBelong> list = schoolBelongService.selectSchoolBelongList(schoolBelong);
        ExcelUtil<SchoolBelong> util = new ExcelUtil<SchoolBelong>(SchoolBelong.class);
        return util.exportExcel(list, "SchoolBelong");
    }

    /**
     * 新增学院分属
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学院分属
     */
    @RequiresPermissions("system:SchoolBelong:add")
    @Log(title = "学院分属", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolBelong schoolBelong)
    {
        return toAjax(schoolBelongService.insertSchoolBelong(schoolBelong));
    }

    /**
     * 修改学院分属
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolBelong schoolBelong = schoolBelongService.selectSchoolBelongById(id);
        mmap.put("schoolBelong", schoolBelong);
        return prefix + "/edit";
    }

    /**
     * 修改保存学院分属
     */
    @RequiresPermissions("system:SchoolBelong:edit")
    @Log(title = "学院分属", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolBelong schoolBelong)
    {
        return toAjax(schoolBelongService.updateSchoolBelong(schoolBelong));
    }

    /**
     * 删除学院分属
     */
    @RequiresPermissions("system:SchoolBelong:remove")
    @Log(title = "学院分属", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolBelongService.deleteSchoolBelongByIds(ids));
    }
}
