package com.ruoyi.project.system.TeachingAvtivity.controller;

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
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;
import com.ruoyi.project.system.TeachingAvtivity.domain.TeachingAvtivity;
import com.ruoyi.project.system.TeachingAvtivity.service.ITeachingAvtivityService;

/**
 * 教学活动Controller
 * 
 * @author ruoyi
 * @date 2020-02-03
 */
@Controller
@RequestMapping("/system/TeachingAvtivity")
public class TeachingAvtivityController extends BaseController
{
    private String prefix = "system/TeachingAvtivity";

    @Autowired
    private ITeachingAvtivityService teachingAvtivityService;
    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;

    @RequiresPermissions("TeachingAvtivity:TeachingAvtivity:view")
    @GetMapping()
    public String TeachingAvtivity()
    {
    	return prefix + "/TeachingAvtivity";
    }

    /**
     * 查询教学活动列表
     */
    @RequiresPermissions("TeachingAvtivity:TeachingAvtivity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TeachingAvtivity teachingAvtivity)
    {
        startPage();
        List<TeachingAvtivity> list = teachingAvtivityService.selectTeachingAvtivityList(teachingAvtivity);
        return getDataTable(list);
    }

    /**
     * 导出教学活动列表
     */
    @RequiresPermissions("TeachingAvtivity:TeachingAvtivity:export")
    @Log(title = "教学活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachingAvtivity teachingAvtivity)
    {
        List<TeachingAvtivity> list = teachingAvtivityService.selectTeachingAvtivityList(teachingAvtivity);
        ExcelUtil<TeachingAvtivity> util = new ExcelUtil<TeachingAvtivity>(TeachingAvtivity.class);
        return util.exportExcel(list, "TeachingAvtivity");
    }

    /**
     * 新增教学活动
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	SchoolSpecialty schoolSpecialty =new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        return prefix + "/add";
    }

    /**
     * 新增保存教学活动
     */
    @RequiresPermissions("TeachingAvtivity:TeachingAvtivity:add")
    @Log(title = "教学活动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TeachingAvtivity teachingAvtivity)
    {
    	Long specialtyId=  teachingAvtivity.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	teachingAvtivity.setName(schoolSpecialty.getName());
        return toAjax(teachingAvtivityService.insertTeachingAvtivity(teachingAvtivity));
    }

    /**
     * 修改教学活动
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TeachingAvtivity teachingAvtivity = teachingAvtivityService.selectTeachingAvtivityById(id);
        mmap.put("teachingAvtivity", teachingAvtivity);
        SchoolSpecialty schoolSpecialty =new SchoolSpecialty();
        List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        return prefix + "/edit";
    }

    /**
     * 修改保存教学活动
     */
    @RequiresPermissions("TeachingAvtivity:TeachingAvtivity:edit")
    @Log(title = "教学活动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TeachingAvtivity teachingAvtivity)
    {
    	Long specialtyId=  teachingAvtivity.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	teachingAvtivity.setName(schoolSpecialty.getName());
        return toAjax(teachingAvtivityService.updateTeachingAvtivity(teachingAvtivity));
    }

    /**
     * 删除教学活动
     */
    @RequiresPermissions("TeachingAvtivity:TeachingAvtivity:remove")
    @Log(title = "教学活动", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(teachingAvtivityService.deleteTeachingAvtivityByIds(ids));
    }
}
