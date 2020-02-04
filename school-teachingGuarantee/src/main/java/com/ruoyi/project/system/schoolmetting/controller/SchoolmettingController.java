package com.ruoyi.project.system.schoolmetting.controller;

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
import com.ruoyi.project.system.schoolclassroom.domain.Schoolclassroom;
import com.ruoyi.project.system.schoolclassroom.service.ISchoolclassroomService;
import com.ruoyi.project.system.schoolmetting.domain.Schoolmetting;
import com.ruoyi.project.system.schoolmetting.service.ISchoolmettingService;

/**
 * 会议管理Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Controller
@RequestMapping("/system/schoolmetting")
public class SchoolmettingController extends BaseController
{
    private String prefix = "system/schoolmetting";

    @Autowired
    private ISchoolmettingService schoolmettingService;

    @Autowired
    private ISchoolclassroomService schoolclassroomService;
        
    @RequiresPermissions("system:schoolmetting:view")
    @GetMapping()
    public String schoolmetting()
    {
        return prefix + "/schoolmetting";
    }

    /**
     * 查询会议管理列表
     */
    @RequiresPermissions("system:schoolmetting:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolmetting schoolmetting)
    {
        startPage();
        List<Schoolmetting> list = schoolmettingService.selectSchoolmettingList(schoolmetting);
        return getDataTable(list);
    }

    /**
     * 导出会议管理列表
     */
    @RequiresPermissions("system:schoolmetting:export")
    @Log(title = "会议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolmetting schoolmetting)
    {
        List<Schoolmetting> list = schoolmettingService.selectSchoolmettingList(schoolmetting);
        ExcelUtil<Schoolmetting> util = new ExcelUtil<Schoolmetting>(Schoolmetting.class);
        return util.exportExcel(list, "schoolmetting");
    }

    /**
     * 新增会议管理
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
    	Schoolclassroom schoolclassroom = new Schoolclassroom();
    	schoolclassroom.setDeleteFlag(0+"");
    	List<Schoolclassroom> list = schoolclassroomService.selectSchoolclassroomList(schoolclassroom);
    	map.put("placelist", list);
        return prefix + "/add";
    }

    /**
     * 新增保存会议管理
     */
    @RequiresPermissions("system:schoolmetting:add")
    @Log(title = "会议", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolmetting schoolmetting)
    {
        return toAjax(schoolmettingService.insertSchoolmetting(schoolmetting));
    }

    /**
     * 修改会议管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolclassroom schoolclassroom = new Schoolclassroom();
    	schoolclassroom.setDeleteFlag(0+"");
    	List<Schoolclassroom> list = schoolclassroomService.selectSchoolclassroomList(schoolclassroom);
    	mmap.put("placelist", list);
        Schoolmetting schoolmetting = schoolmettingService.selectSchoolmettingById(id);
        mmap.put("schoolmetting", schoolmetting);
        return prefix + "/edit";
    }

    /**
     * 修改保存会议管理
     */
    @RequiresPermissions("system:schoolmetting:edit")
    @Log(title = "会议", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolmetting schoolmetting)
    {
        return toAjax(schoolmettingService.updateSchoolmetting(schoolmetting));
    }

    /**
     * 删除会议管理
     */
    @RequiresPermissions("system:schoolmetting:remove")
    @Log(title = "会议", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolmettingService.deleteSchoolmettingByIds(ids));
    }
}
