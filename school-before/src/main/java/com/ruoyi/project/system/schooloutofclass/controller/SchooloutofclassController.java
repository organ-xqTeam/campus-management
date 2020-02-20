package com.ruoyi.project.system.schooloutofclass.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schooloutofclass.domain.Schooloutofclass;
import com.ruoyi.project.system.schooloutofclass.service.ISchooloutofclassService;

/**
 * 课外读物Controller
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
@Controller
@RequestMapping("/system/schooloutofclass")
public class SchooloutofclassController extends BaseController
{
    private String prefix = "system/schooloutofclass";

    @Autowired
    private ISchoolClassService schoolClassService;
    
    @Autowired
    private ISchooloutofclassService schooloutofclassService; 

    @RequiresPermissions("system:schooloutofclass:view")
    @GetMapping()
    public String schooloutofclass(@RequestParam("id") Long id, @RequestParam("type") String type, ModelMap map)
    {
    	SchoolClass schoolClass = schoolClassService.selectSchoolClassById(id);
    	map.put("schoolClass", schoolClass);
    	Schooloutofclass schooloutofclass = new Schooloutofclass();
    	schooloutofclass.setType(type);
    	map.put("schooloutofclass", schooloutofclass);
        return prefix + "/schooloutofclass";
    }

    /**
     * 查询课外读物列表
     */
    @RequiresPermissions("system:schooloutofclass:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schooloutofclass schooloutofclass)
    {
        startPage();
        List<Schooloutofclass> list = schooloutofclassService.selectSchooloutofclassList(schooloutofclass);
        return getDataTable(list);
    }

    /**
     * 导出课外读物列表
     */
    @RequiresPermissions("system:schooloutofclass:export")
    @Log(title = "课外读物", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schooloutofclass schooloutofclass)
    {
        List<Schooloutofclass> list = schooloutofclassService.selectSchooloutofclassList(schooloutofclass);
        ExcelUtil<Schooloutofclass> util = new ExcelUtil<Schooloutofclass>(Schooloutofclass.class);
        return util.exportExcel(list, "schooloutofclass");
    }

    /**
     * 新增课外读物
     */
    @GetMapping("/add")
    public String add(Schooloutofclass schooloutofclass, ModelMap map)
    {
    	map.put("schooloutofclass", schooloutofclass);
        return prefix + "/add";
    }

    /**
     * 新增保存课外读物
     */
    @RequiresPermissions("system:schooloutofclass:add")
    @Log(title = "课外读物", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schooloutofclass schooloutofclass)
    {
    	schooloutofclass.setUploadtime(DateUtils.getTime());
        return toAjax(schooloutofclassService.insertSchooloutofclass(schooloutofclass));
    }

    /**
     * 修改课外读物
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schooloutofclass schooloutofclass = schooloutofclassService.selectSchooloutofclassById(id);
        mmap.put("schooloutofclass", schooloutofclass);
        return prefix + "/edit";
    }

    /**
     * 修改保存课外读物
     */
    @RequiresPermissions("system:schooloutofclass:edit")
    @Log(title = "课外读物", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schooloutofclass schooloutofclass)
    {
        return toAjax(schooloutofclassService.updateSchooloutofclass(schooloutofclass));
    }

    /**
     * 删除课外读物
     */
    @RequiresPermissions("system:schooloutofclass:remove")
    @Log(title = "课外读物", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schooloutofclassService.deleteSchooloutofclassByIds(ids));
    }
}
