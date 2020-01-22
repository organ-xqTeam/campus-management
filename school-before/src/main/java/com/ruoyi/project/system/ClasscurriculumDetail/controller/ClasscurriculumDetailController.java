package com.ruoyi.project.system.ClasscurriculumDetail.controller;

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
import com.ruoyi.project.system.ClasscurriculumDetail.domain.ClasscurriculumDetail;
import com.ruoyi.project.system.ClasscurriculumDetail.service.IClasscurriculumDetailService;

/**
 * 排课详情表Controller
 * 
 * @author ruoyi
 * @date 2019-11-22
 */
@Controller
@RequestMapping("/system/ClasscurriculumDetail")
public class ClasscurriculumDetailController extends BaseController
{
    private String prefix = "system/ClasscurriculumDetail";

    @Autowired
    private IClasscurriculumDetailService classcurriculumDetailService;

    @RequiresPermissions("system:ClasscurriculumDetail:view")
    @GetMapping()
    public String ClasscurriculumDetail()
    {
        return prefix + "/ClasscurriculumDetail";
    }

    /**
     * 查询排课详情表列表
     */
    @RequiresPermissions("system:ClasscurriculumDetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClasscurriculumDetail classcurriculumDetail)
    {
        startPage();
        List<ClasscurriculumDetail> list = classcurriculumDetailService.selectClasscurriculumDetailList(classcurriculumDetail);
        return getDataTable(list);
    }

    /**
     * 导出排课详情表列表
     */
    @RequiresPermissions("system:ClasscurriculumDetail:export")
    @Log(title = "排课详情表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClasscurriculumDetail classcurriculumDetail)
    {
        List<ClasscurriculumDetail> list = classcurriculumDetailService.selectClasscurriculumDetailList(classcurriculumDetail);
        ExcelUtil<ClasscurriculumDetail> util = new ExcelUtil<ClasscurriculumDetail>(ClasscurriculumDetail.class);
        return util.exportExcel(list, "ClasscurriculumDetail");
    }

    /**
     * 新增排课详情表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存排课详情表
     */
    @RequiresPermissions("system:ClasscurriculumDetail:add")
    @Log(title = "排课详情表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClasscurriculumDetail classcurriculumDetail)
    {
        return toAjax(classcurriculumDetailService.insertClasscurriculumDetail(classcurriculumDetail));
    }

    /**
     * 修改排课详情表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ClasscurriculumDetail classcurriculumDetail = classcurriculumDetailService.selectClasscurriculumDetailById(id);
        mmap.put("classcurriculumDetail", classcurriculumDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存排课详情表
     */
    @RequiresPermissions("system:ClasscurriculumDetail:edit")
    @Log(title = "排课详情表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClasscurriculumDetail classcurriculumDetail)
    {
        return toAjax(classcurriculumDetailService.updateClasscurriculumDetail(classcurriculumDetail));
    }

    /**
     * 删除排课详情表
     */
    @RequiresPermissions("system:ClasscurriculumDetail:remove")
    @Log(title = "排课详情表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(classcurriculumDetailService.deleteClasscurriculumDetailByIds(ids));
    }
}
