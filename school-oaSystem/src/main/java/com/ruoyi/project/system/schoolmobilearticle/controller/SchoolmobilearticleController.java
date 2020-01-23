package com.ruoyi.project.system.schoolmobilearticle.controller;

import java.util.List;
import java.util.Map;

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
import com.ruoyi.project.system.schoolmobilearticle.domain.Schoolmobilearticle;
import com.ruoyi.project.system.schoolmobilearticle.service.ISchoolmobilearticleService;

/**
 * 通知公告Controller
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
@Controller
@RequestMapping("/system/schoolmobilearticle")
public class SchoolmobilearticleController extends BaseController
{
    private String prefix = "system/schoolmobilearticle";

    @Autowired
    private ISchoolmobilearticleService schoolmobilearticleService;

    @RequiresPermissions("system:schoolmobilearticle:view")
    @GetMapping()
    public String schoolmobilearticle()
    {
        return prefix + "/schoolmobilearticle";
    }

    /**
     * 查询通知公告列表
     */
    @RequiresPermissions("system:schoolmobilearticle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolmobilearticle schoolmobilearticle)
    {
        startPage();
        List<Schoolmobilearticle> list = schoolmobilearticleService.selectSchoolmobilearticleList(schoolmobilearticle);
        return getDataTable(list);
    }

    /**
     * 导出通知公告列表
     */
    @RequiresPermissions("system:schoolmobilearticle:export")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolmobilearticle schoolmobilearticle)
    {
        List<Schoolmobilearticle> list = schoolmobilearticleService.selectSchoolmobilearticleList(schoolmobilearticle);
        ExcelUtil<Schoolmobilearticle> util = new ExcelUtil<Schoolmobilearticle>(Schoolmobilearticle.class);
        return util.exportExcel(list, "schoolmobilearticle");
    }

    /**
     * 新增通知公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存通知公告
     */
    @RequiresPermissions("system:schoolmobilearticle:add")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam Map<String, Object> params)
    {
    	Schoolmobilearticle schoolmobilearticle = new Schoolmobilearticle();
    	schoolmobilearticle.setCreatedate(DateUtils.getTime());
    	if (params.get("title") != null) {
    		schoolmobilearticle.setTitle(params.get("title").toString());
    	}
    	if (params.get("type") != null) {
    		schoolmobilearticle.setType(params.get("type").toString());
    	}
    	if (params.get("content") != null) {
    		schoolmobilearticle.setContent(params.get("content").toString());
    	}
    	if (params.get("file") != null) {
    		schoolmobilearticle.setFile(params.get("file").toString());
    	}
    	if (params.get("filename") != null) {
    		schoolmobilearticle.setFilename(params.get("filename").toString());
    	}
        return toAjax(schoolmobilearticleService.insertSchoolmobilearticle(schoolmobilearticle));
    }

    /**
     * 修改通知公告
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolmobilearticle schoolmobilearticle = schoolmobilearticleService.selectSchoolmobilearticleById(id);
        mmap.put("schoolmobilearticle", schoolmobilearticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存通知公告
     */
    @RequiresPermissions("system:schoolmobilearticle:edit")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam Map<String, Object> params)
    {
    	Schoolmobilearticle schoolmobilearticle = new Schoolmobilearticle();
    	if (params.get("id") != null) {
    		schoolmobilearticle.setId(Long.valueOf(params.get("id").toString()));
    	}
    	if (params.get("title") != null) {
    		schoolmobilearticle.setTitle(params.get("title").toString());
    	}
    	if (params.get("type") != null) {
    		schoolmobilearticle.setType(params.get("type").toString());
    	}
    	if (params.get("content") != null) {
    		schoolmobilearticle.setContent(params.get("content").toString());
    	}
    	if (params.get("file") != null) {
    		schoolmobilearticle.setFile(params.get("file").toString());
    	}
    	if (params.get("filename") != null) {
    		schoolmobilearticle.setFilename(params.get("filename").toString());
    	}
        return toAjax(schoolmobilearticleService.updateSchoolmobilearticle(schoolmobilearticle));
    }

    /**
     * 删除通知公告
     */
    @RequiresPermissions("system:schoolmobilearticle:remove")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolmobilearticleService.deleteSchoolmobilearticleByIds(ids));
    }
}
