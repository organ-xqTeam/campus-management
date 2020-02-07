package com.ruoyi.project.system.TrainManage.controller;

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
import com.ruoyi.project.system.TrainManage.domain.TrainManage;
import com.ruoyi.project.system.TrainManage.service.ITrainManageService;

/**
 * 专业培训管理方案Controller
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
@Controller
@RequestMapping("/system/TrainManage")
public class TrainManageController extends BaseController
{
    private String prefix = "system/TrainManage";

    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;
    @Autowired
    private ITrainManageService trainManageService;

    @RequiresPermissions("system:TrainManage:view")
    @GetMapping()
    public String TrainManage()
    {
        return prefix + "/TrainManage";
    }

    /**
     * 查询专业培训管理方案列表
     */
    @RequiresPermissions("system:TrainManage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TrainManage trainManage)
    {
        startPage();
        List<TrainManage> list = trainManageService.selectTrainManageList(trainManage);
        return getDataTable(list);
    }

    /**
     * 导出专业培训管理方案列表
     */
    @RequiresPermissions("system:TrainManage:export")
    @Log(title = "专业培训管理方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TrainManage trainManage)
    {
        List<TrainManage> list = trainManageService.selectTrainManageList(trainManage);
        ExcelUtil<TrainManage> util = new ExcelUtil<TrainManage>(TrainManage.class);
        return util.exportExcel(list, "TrainManage");
    }

    /**
     * 新增专业培训管理方案
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
     * 新增保存专业培训管理方案
     */
    @RequiresPermissions("system:TrainManage:add")
    @Log(title = "专业培训管理方案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TrainManage trainManage)
    {
    	Long specialtyId=  trainManage.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	trainManage.setSpecialtyName(schoolSpecialty.getName());
        return toAjax(trainManageService.insertTrainManage(trainManage));
    }

    /**
     * 修改专业培训管理方案
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	SchoolSpecialty schoolSpecialty =new SchoolSpecialty();
    	List<SchoolSpecialty> schoolSpecialtyList= schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
    	mmap.put("schoolSpecialtyList", schoolSpecialtyList);
        TrainManage trainManage = trainManageService.selectTrainManageById(id);
        mmap.put("trainManage", trainManage);
        return prefix + "/edit";
    }

    /**
     * 修改保存专业培训管理方案
     */
    @RequiresPermissions("system:TrainManage:edit")
    @Log(title = "专业培训管理方案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TrainManage trainManage)
    {
    	Long specialtyId=  trainManage.getSpecialtyId();
    	SchoolSpecialty  schoolSpecialty= schoolSpecialtyService.selectSchoolSpecialtyById(specialtyId);
    	trainManage.setSpecialtyName(schoolSpecialty.getName());
        return toAjax(trainManageService.updateTrainManage(trainManage));
    }

    /**
     * 删除专业培训管理方案
     */
    @RequiresPermissions("system:TrainManage:remove")
    @Log(title = "专业培训管理方案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(trainManageService.deleteTrainManageByIds(ids));
    }
}
