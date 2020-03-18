package com.ruoyi.project.system.schooldetailscharges.controller;

import java.util.ArrayList;
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
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.schoolchargemanagement.domain.Schoolchargemanagement;
import com.ruoyi.project.system.schoolchargemanagement.service.ISchoolchargemanagementService;
import com.ruoyi.project.system.schooldetailscharges.domain.Schooldetailscharges;
import com.ruoyi.project.system.schooldetailscharges.service.ISchooldetailschargesService;

/**
 * 收费明细Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/schooldetailscharges")
public class SchooldetailschargesController extends BaseController
{
    private String prefix = "system/schooldetailscharges";

    @Autowired
    private ISchooldetailschargesService schooldetailschargesService;
    @Autowired
    private ISchoolchargemanagementService schoolchargemanagementService;
    
    @RequiresPermissions("system:schooldetailscharges:view")
    @GetMapping("/{id}")
    public String schooldetailscharges(@PathVariable("id") Long id, ModelMap mmap)
    {	
    	
    	Schoolchargemanagement scs = schoolchargemanagementService.selectSchoolchargemanagementById(id);
    	mmap.put("detailscharges", scs);
        return prefix + "/schooldetailscharges";
    }

    /**
     * 查询收费明细列表
     */
    @RequiresPermissions("system:schooldetailscharges:list")
    @PostMapping("/list/{id}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("id") Long id)
    {
    	Schooldetailscharges schooldetailscharges;
    	List<Schooldetailscharges> list = new ArrayList<Schooldetailscharges>();
    	for (int i=0; i<4; i++) {
    		schooldetailscharges = new Schooldetailscharges();
        	schooldetailscharges.setChargeManagementId(id+"");
        	schooldetailscharges.setGrade((i+1)+"年级");
        	schooldetailscharges.setRemark1((Integer.valueOf(DateUtils.getYear()) - i) + "");
        	list.add(schooldetailscharges);
    	}
        startPage();
        return getDataTable(list);
        
//        schooldetailscharges.setChargeManagementId(id+"");
//        startPage();
//        List<Schooldetailscharges> list = schooldetailschargesService.selectSchooldetailschargesList(schooldetailscharges);
//        return getDataTable(list);
    }

    /**
     * 导出收费明细列表
     */
    @RequiresPermissions("system:schooldetailscharges:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schooldetailscharges schooldetailscharges)
    {
        List<Schooldetailscharges> list = schooldetailschargesService.selectSchooldetailschargesList(schooldetailscharges);
        ExcelUtil<Schooldetailscharges> util = new ExcelUtil<Schooldetailscharges>(Schooldetailscharges.class);
        return util.exportExcel(list, "schooldetailscharges");
    }

    /**
     * 新增收费明细
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolchargemanagement scs = schoolchargemanagementService.selectSchoolchargemanagementById(id);
    	mmap.put("detailscharges", scs);
        return prefix + "/add";
    }

    /**
     * 新增保存收费明细
     */
    @RequiresPermissions("system:schooldetailscharges:add")
    @Log(title = "收费明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schooldetailscharges schooldetailscharges)
    {
        return toAjax(schooldetailschargesService.insertSchooldetailscharges(schooldetailscharges));
    }

    /**
     * 修改收费明细
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schooldetailscharges schooldetailscharges = schooldetailschargesService.selectSchooldetailschargesById(id);
        mmap.put("schooldetailscharges", schooldetailscharges);
        return prefix + "/edit";
    }

    /**
     * 修改保存收费明细
     */
    @RequiresPermissions("system:schooldetailscharges:edit")
    @Log(title = "收费明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schooldetailscharges schooldetailscharges)
    {
        return toAjax(schooldetailschargesService.updateSchooldetailscharges(schooldetailscharges));
    }

    /**
     * 删除收费明细
     */
    @RequiresPermissions("system:schooldetailscharges:remove")
    @Log(title = "收费明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schooldetailschargesService.deleteSchooldetailschargesByIds(ids));
    }
    @Log(title = "收费管理修改状态", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:schoolchargemanagement:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Schooldetailscharges schooldetailscharges)
    {
        return toAjax(schooldetailschargesService.changeStatus(schooldetailscharges));
    }
}
