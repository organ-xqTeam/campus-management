package com.ruoyi.project.system.schoolresearchlearning.controller;

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
import com.ruoyi.project.system.schoolresearchlearning.domain.Schoolresearchlearning;
import com.ruoyi.project.system.schoolresearchlearning.service.ISchoolresearchlearningService;

/**
 * 研究学习Controller
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
@Controller
@RequestMapping("/system/schoolresearchlearning")
public class SchoolresearchlearningController extends BaseController
{
    private String prefix = "system/schoolresearchlearning";

    @Autowired
    private ISchoolresearchlearningService schoolresearchlearningService;

    @RequiresPermissions("system:schoolresearchlearning:view")
    @GetMapping()
    public String schoolresearchlearning()
    {
        return prefix + "/schoolresearchlearning";
    }

    /**
     * 查询研究学习列表
     */
    @RequiresPermissions("system:schoolresearchlearning:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolresearchlearning schoolresearchlearning)
    {
        startPage();
        List<Schoolresearchlearning> list = schoolresearchlearningService.selectSchoolresearchlearningList(schoolresearchlearning);
        return getDataTable(list);
    }

    /**
     * 导出研究学习列表
     */
    @RequiresPermissions("system:schoolresearchlearning:export")
    @Log(title = "研究学习", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolresearchlearning schoolresearchlearning)
    {
        List<Schoolresearchlearning> list = schoolresearchlearningService.selectSchoolresearchlearningList(schoolresearchlearning);
        ExcelUtil<Schoolresearchlearning> util = new ExcelUtil<Schoolresearchlearning>(Schoolresearchlearning.class);
        return util.exportExcel(list, "schoolresearchlearning");
    }

    /**
     * 新增研究学习
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存研究学习
     */
    @RequiresPermissions("system:schoolresearchlearning:add")
    @Log(title = "研究学习", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolresearchlearning schoolresearchlearning)
    {
        return toAjax(schoolresearchlearningService.insertSchoolresearchlearning(schoolresearchlearning));
    }

    /**
     * 修改研究学习
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolresearchlearning schoolresearchlearning = schoolresearchlearningService.selectSchoolresearchlearningById(id);
        mmap.put("schoolresearchlearning", schoolresearchlearning);
        return prefix + "/edit";
    }

    /**
     * 修改保存研究学习
     */
    @RequiresPermissions("system:schoolresearchlearning:edit")
    @Log(title = "研究学习", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolresearchlearning schoolresearchlearning)
    {
        return toAjax(schoolresearchlearningService.updateSchoolresearchlearning(schoolresearchlearning));
    }

    /**
     * 删除研究学习
     */
    @RequiresPermissions("system:schoolresearchlearning:remove")
    @Log(title = "研究学习", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolresearchlearningService.deleteSchoolresearchlearningByIds(ids));
    }
}
