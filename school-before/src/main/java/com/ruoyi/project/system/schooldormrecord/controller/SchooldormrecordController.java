package com.ruoyi.project.system.schooldormrecord.controller;

import java.util.Date;
import java.util.List;

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
import com.ruoyi.project.system.schooldormrecord.domain.Schooldormrecord;
import com.ruoyi.project.system.schooldormrecord.service.ISchooldormrecordService;

/**
 * 住宿记录Controller
 * 
 * @author ruoyi
 * @date 2019-11-18
 */
@Controller
@RequestMapping("/system/schooldormrecord")
public class SchooldormrecordController extends BaseController
{
    private String prefix = "system/schooldormrecord";

    @Autowired
    private ISchooldormrecordService schooldormrecordService;

    
    @GetMapping()
    public String schooldormrecord()
    {
        return prefix + "/schooldormrecord";
    }

    /**
     * 查询住宿记录列表
     */
    
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schooldormrecord schooldormrecord)
    {
        startPage();
        List<Schooldormrecord> list = schooldormrecordService.selectSchooldormrecordList(schooldormrecord);
        return getDataTable(list);
    }

    /**
     * 导出住宿记录列表
     */
   
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schooldormrecord schooldormrecord)
    {
        List<Schooldormrecord> list = schooldormrecordService.selectSchooldormrecordList(schooldormrecord);
        ExcelUtil<Schooldormrecord> util = new ExcelUtil<Schooldormrecord>(Schooldormrecord.class);
        return util.exportExcel(list, "schooldormrecord");
    }

    /**
     * 新增住宿记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存住宿记录
     */
    
    @Log(title = "住宿记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schooldormrecord schooldormrecord)
    {
    	
        return toAjax(schooldormrecordService.insertSchooldormrecord(schooldormrecord));
    }

    /**
     * 修改住宿记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schooldormrecord schooldormrecord = schooldormrecordService.selectSchooldormrecordById(id);
        
        mmap.put("schooldormrecord", schooldormrecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存住宿记录
     */
   
    @Log(title = "住宿记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schooldormrecord schooldormrecord)
    {
    	schooldormrecord.setUpdatedate(new Date());
        return toAjax(schooldormrecordService.updateSchooldormrecord(schooldormrecord));
    }

    /**
     * 删除住宿记录
     */
    
    @Log(title = "住宿记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schooldormrecordService.deleteSchooldormrecordByIds(ids));
    }
}
