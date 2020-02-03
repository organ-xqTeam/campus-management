package com.ruoyi.project.system.schoolclassroom.controller;

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
import com.ruoyi.project.system.schoolclassroom.domain.Schoolclassroom;
import com.ruoyi.project.system.schoolclassroom.service.ISchoolclassroomService;

/**
 * 教室管理Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/system/schoolclassroom")
public class SchoolclassroomController extends BaseController
{
    private String prefix = "system/schoolclassroom";

    @Autowired
    private ISchoolclassroomService schoolclassroomService;

    @RequiresPermissions("system:schoolclassroom:view")
    @GetMapping()
    public String schoolclassroom()
    {
        return prefix + "/schoolclassroom";
    }

    /**
     * 查询教室管理列表
     */
    @RequiresPermissions("system:schoolclassroom:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolclassroom schoolclassroom)
    {
        startPage();
        List<Schoolclassroom> list = schoolclassroomService.selectSchoolclassroomList(schoolclassroom);
        return getDataTable(list);
    }

    /**
     * 导出教室管理列表
     */
    @RequiresPermissions("system:schoolclassroom:export")
    @Log(title = "教室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolclassroom schoolclassroom)
    {
        List<Schoolclassroom> list = schoolclassroomService.selectSchoolclassroomList(schoolclassroom);
        ExcelUtil<Schoolclassroom> util = new ExcelUtil<Schoolclassroom>(Schoolclassroom.class);
        return util.exportExcel(list, "schoolclassroom");
    }

    /**
     * 新增教室管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教室管理
     */
    @RequiresPermissions("system:schoolclassroom:add")
    @Log(title = "教室", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolclassroom schoolclassroom)
    {
        return toAjax(schoolclassroomService.insertSchoolclassroom(schoolclassroom));
    }

    /**
     * 修改教室管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolclassroom schoolclassroom = schoolclassroomService.selectSchoolclassroomById(id);
        mmap.put("schoolclassroom", schoolclassroom);
        return prefix + "/edit";
    }

    /**
     * 修改保存教室管理
     */
    @RequiresPermissions("system:schoolclassroom:edit")
    @Log(title = "教室", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolclassroom schoolclassroom)
    {
        return toAjax(schoolclassroomService.updateSchoolclassroom(schoolclassroom));
    }

    /**
     * 删除教室管理
     */
    @RequiresPermissions("system:schoolclassroom:remove")
    @Log(title = "教室", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolclassroomService.deleteSchoolclassroomByIds(ids));
    }
}
