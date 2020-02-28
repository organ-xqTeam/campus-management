package com.ruoyi.project.system.SchoolSpecialty.controller;

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
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;

/**
 * 学校专业Controller
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
@Controller
@RequestMapping("/system/SchoolSpecialty")
public class SchoolSpecialtyController extends BaseController
{
    private String prefix = "system/SchoolSpecialty";

    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;
    @Autowired
    private ISchoolBelongService schoolBelongService;

    @RequiresPermissions("system:SchoolSpecialty:view")
    @GetMapping()
    public String SchoolSpecialty()
    {
    	
        return prefix + "/SchoolSpecialty";
    }

    /**
     * 查询学校专业列表
     */
    @RequiresPermissions("system:SchoolSpecialty:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SchoolSpecialty schoolSpecialty)
    {
        startPage();
        List<SchoolSpecialty> list = schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
        return getDataTable(list);
    }

    /**
     * 导出学校专业列表
     */
    @RequiresPermissions("system:SchoolSpecialty:export")
    @Log(title = "学校专业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolSpecialty schoolSpecialty)
    {
        List<SchoolSpecialty> list = schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
        ExcelUtil<SchoolSpecialty> util = new ExcelUtil<SchoolSpecialty>(SchoolSpecialty.class);
        return util.exportExcel(list, "培训项目列表");
    }

    /**
     * 新增学校专业
     */
    @GetMapping("/add")
    public String add( ModelMap mmap)
    {
    	SchoolBelong schoolBelong =new SchoolBelong();
    	List<SchoolBelong> schoolBelongList= schoolBelongService.selectSchoolBelongList(schoolBelong);
    	mmap.put("schoolBelongList", schoolBelongList);
        return prefix + "/add";
    }

    /**
     * 新增保存学校专业
     */
    @RequiresPermissions("system:SchoolSpecialty:add")
    @Log(title = "学校专业", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolSpecialty schoolSpecialty)
    {
    	Long belongId=  schoolSpecialty.getBelongId();
    	SchoolBelong schoolBelong = schoolBelongService.selectSchoolBelongById(belongId);
    	schoolSpecialty.setBelongName(schoolBelong.getSchoolName());
        return toAjax(schoolSpecialtyService.insertSchoolSpecialty(schoolSpecialty));
    }

    /**
     * 修改学校专业
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolSpecialty schoolSpecialty = schoolSpecialtyService.selectSchoolSpecialtyById(id);
        mmap.put("schoolSpecialty", schoolSpecialty);
        SchoolBelong schoolBelong =new SchoolBelong();
    	List<SchoolBelong> schoolBelongList= schoolBelongService.selectSchoolBelongList(schoolBelong);
    	mmap.put("schoolBelongList", schoolBelongList);
        return prefix + "/edit";
    }

    /**
     * 修改保存学校专业
     */
    @RequiresPermissions("system:SchoolSpecialty:edit")
    @Log(title = "学校专业", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolSpecialty schoolSpecialty)
    {
    	Long belongId=  schoolSpecialty.getBelongId();
    	SchoolBelong schoolBelong = schoolBelongService.selectSchoolBelongById(belongId);
    	schoolSpecialty.setBelongName(schoolBelong.getSchoolName());
        return toAjax(schoolSpecialtyService.updateSchoolSpecialty(schoolSpecialty));
    }

    /**
     * 删除学校专业
     */
    @RequiresPermissions("system:SchoolSpecialty:remove")
    @Log(title = "学校专业", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolSpecialtyService.deleteSchoolSpecialtyByIds(ids));
    }
}
