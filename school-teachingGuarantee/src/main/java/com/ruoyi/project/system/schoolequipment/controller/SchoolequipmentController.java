package com.ruoyi.project.system.schoolequipment.controller;

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
import com.ruoyi.project.system.schoolequipment.domain.Schoolequipment;
import com.ruoyi.project.system.schoolequipment.service.ISchoolequipmentService;

/**
 * 设备报修Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/system/schoolequipment")
public class SchoolequipmentController extends BaseController
{
    private String prefix = "system/schoolequipment";

    @Autowired
    private ISchoolequipmentService schoolequipmentService;

    @RequiresPermissions("system:schoolequipment:view")
    @GetMapping()
    public String schoolequipment()
    {
        return prefix + "/schoolequipment";
    }
    
    @RequiresPermissions("system:schoolequipment:repair")
    @GetMapping("/repair")
    public String repair(Schoolequipment schoolequipment, ModelMap map)
    {
    	map.put("schoolequipment", schoolequipment);
        return prefix + "/repair";
    }

    /**
     * 查询设备报修列表
     */
    @RequiresPermissions("system:schoolequipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolequipment schoolequipment)
    {
        startPage();
        List<Schoolequipment> list = schoolequipmentService.selectSchoolequipmentList(schoolequipment);
        return getDataTable(list);
    }

    /**
     * 导出设备报修列表
     */
    @RequiresPermissions("system:schoolequipment:export")
    @Log(title = "设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolequipment schoolequipment)
    {
        List<Schoolequipment> list = schoolequipmentService.selectSchoolequipmentList(schoolequipment);
        ExcelUtil<Schoolequipment> util = new ExcelUtil<Schoolequipment>(Schoolequipment.class);
        return util.exportExcel(list, "schoolequipment");
    }

    /**
     * 新增设备报修
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备报修
     */
    @RequiresPermissions("system:schoolequipment:add")
    @Log(title = "设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolequipment schoolequipment)
    {
        return toAjax(schoolequipmentService.insertSchoolequipment(schoolequipment));
    }

    /**
     * 修改设备报修
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolequipment schoolequipment = schoolequipmentService.selectSchoolequipmentById(id);
        mmap.put("schoolequipment", schoolequipment);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备报修
     */
    @RequiresPermissions("system:schoolequipment:edit")
    @Log(title = "设备", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolequipment schoolequipment)
    {
        return toAjax(schoolequipmentService.updateSchoolequipment(schoolequipment));
    }

    /**
     * 删除设备报修
     */
    @RequiresPermissions("system:schoolequipment:remove")
    @Log(title = "设备", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolequipmentService.deleteSchoolequipmentByIds(ids));
    }
}
