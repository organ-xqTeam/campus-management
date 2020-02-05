package com.ruoyi.project.system.schoolteachingplanfilelist.controller;

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
import com.ruoyi.project.system.schoolteachingplanfilelist.domain.Schoolteachingplanfilelist;
import com.ruoyi.project.system.schoolteachingplanfilelist.service.ISchoolteachingplanfilelistService;

/**
 * 教案文件Controller
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/system/schoolteachingplanfilelist")
public class SchoolteachingplanfilelistController extends BaseController
{
    private String prefix = "system/schoolteachingplanfilelist";

    @Autowired
    private ISchoolteachingplanfilelistService schoolteachingplanfilelistService;

    @RequiresPermissions("system:schoolteachingplanfilelist:view")
    @GetMapping()
    public String schoolteachingplanfilelist(Schoolteachingplanfilelist schoolteachingplanfilelist, ModelMap mmap)
    {
    	mmap.put("schoolteachingplanfilelist", schoolteachingplanfilelist);
        return prefix + "/schoolteachingplanfilelist";
    }

    /**
     * 查询教案文件列表
     */
    @RequiresPermissions("system:schoolteachingplanfilelist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolteachingplanfilelist schoolteachingplanfilelist)
    {
        startPage();
        List<Schoolteachingplanfilelist> list = schoolteachingplanfilelistService.selectSchoolteachingplanfilelistList(schoolteachingplanfilelist);
        return getDataTable(list);
    }

    /**
     * 导出教案文件列表
     */
    @RequiresPermissions("system:schoolteachingplanfilelist:export")
    @Log(title = "教案文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolteachingplanfilelist schoolteachingplanfilelist)
    {
        List<Schoolteachingplanfilelist> list = schoolteachingplanfilelistService.selectSchoolteachingplanfilelistList(schoolteachingplanfilelist);
        ExcelUtil<Schoolteachingplanfilelist> util = new ExcelUtil<Schoolteachingplanfilelist>(Schoolteachingplanfilelist.class);
        return util.exportExcel(list, "schoolteachingplanfilelist");
    }

    /**
     * 新增教案文件
     */
    @GetMapping("/add")
    public String add(Schoolteachingplanfilelist schoolteachingplanfilelist, ModelMap mmap)
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教案文件
     */
    @RequiresPermissions("system:schoolteachingplanfilelist:add")
    @Log(title = "教案文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolteachingplanfilelist schoolteachingplanfilelist)
    {
        return toAjax(schoolteachingplanfilelistService.insertSchoolteachingplanfilelist(schoolteachingplanfilelist));
    }

    /**
     * 修改教案文件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolteachingplanfilelist schoolteachingplanfilelist = schoolteachingplanfilelistService.selectSchoolteachingplanfilelistById(id);
        mmap.put("schoolteachingplanfilelist", schoolteachingplanfilelist);
        return prefix + "/edit";
    }

    /**
     * 修改保存教案文件
     */
    @RequiresPermissions("system:schoolteachingplanfilelist:edit")
    @Log(title = "教案文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolteachingplanfilelist schoolteachingplanfilelist)
    {
        return toAjax(schoolteachingplanfilelistService.updateSchoolteachingplanfilelist(schoolteachingplanfilelist));
    }

    /**
     * 删除教案文件
     */
    @RequiresPermissions("system:schoolteachingplanfilelist:remove")
    @Log(title = "教案文件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolteachingplanfilelistService.deleteSchoolteachingplanfilelistByIds(ids));
    }
}
