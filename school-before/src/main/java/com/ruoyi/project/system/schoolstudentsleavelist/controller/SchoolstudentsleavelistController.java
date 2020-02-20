package com.ruoyi.project.system.schoolstudentsleavelist.controller;

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
import com.ruoyi.project.system.schoolstudentsleavelist.domain.Schoolstudentsleavelist;
import com.ruoyi.project.system.schoolstudentsleavelist.service.ISchoolstudentsleavelistService;

/**
 * 学生请假Controller
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
@Controller
@RequestMapping("/system/schoolstudentsleavelist")
public class SchoolstudentsleavelistController extends BaseController
{
    private String prefix = "system/schoolstudentsleavelist";

    @Autowired
    private ISchoolstudentsleavelistService schoolstudentsleavelistService;

    @RequiresPermissions("system:schoolstudentsleavelist:view")
    @GetMapping()
    public String schoolstudentsleavelist(Schoolstudentsleavelist leave, ModelMap map)
    {
    	map.put("leave", leave);
        return prefix + "/schoolstudentsleavelist";
    }

    /**
     * 查询学生请假列表
     */
    @RequiresPermissions("system:schoolstudentsleavelist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolstudentsleavelist schoolstudentsleavelist)
    {
        startPage();
        List<Schoolstudentsleavelist> list = schoolstudentsleavelistService.selectSchoolstudentsleavelistList(schoolstudentsleavelist);
        return getDataTable(list);
    }

    /**
     * 导出学生请假列表
     */
    @RequiresPermissions("system:schoolstudentsleavelist:export")
    @Log(title = "学生请假", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolstudentsleavelist schoolstudentsleavelist)
    {
        List<Schoolstudentsleavelist> list = schoolstudentsleavelistService.selectSchoolstudentsleavelistList(schoolstudentsleavelist);
        ExcelUtil<Schoolstudentsleavelist> util = new ExcelUtil<Schoolstudentsleavelist>(Schoolstudentsleavelist.class);
        return util.exportExcel(list, "schoolstudentsleavelist");
    }

    /**
     * 新增学生请假
     */
    @GetMapping("/add")
    public String add(Schoolstudentsleavelist leave, ModelMap map)
    {
    	map.put("leave", leave);
        return prefix + "/add";
    }

    /**
     * 新增保存学生请假
     */
    @RequiresPermissions("system:schoolstudentsleavelist:add")
    @Log(title = "学生请假", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolstudentsleavelist schoolstudentsleavelist)
    {
        return toAjax(schoolstudentsleavelistService.insertSchoolstudentsleavelist(schoolstudentsleavelist));
    }

    /**
     * 修改学生请假
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolstudentsleavelist schoolstudentsleavelist = schoolstudentsleavelistService.selectSchoolstudentsleavelistById(id);
        mmap.put("schoolstudentsleavelist", schoolstudentsleavelist);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生请假
     */
    @RequiresPermissions("system:schoolstudentsleavelist:edit")
    @Log(title = "学生请假", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolstudentsleavelist schoolstudentsleavelist)
    {
        return toAjax(schoolstudentsleavelistService.updateSchoolstudentsleavelist(schoolstudentsleavelist));
    }

    /**
     * 删除学生请假
     */
    @RequiresPermissions("system:schoolstudentsleavelist:remove")
    @Log(title = "学生请假", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolstudentsleavelistService.deleteSchoolstudentsleavelistByIds(ids));
    }
}
