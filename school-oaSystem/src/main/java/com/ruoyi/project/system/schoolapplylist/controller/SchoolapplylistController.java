package com.ruoyi.project.system.schoolapplylist.controller;

import java.util.List;

import org.apache.commons.lang3.SystemUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
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
import com.ruoyi.project.system.schoolapplylist.domain.Schoolapplylist;
import com.ruoyi.project.system.schoolapplylist.service.ISchoolapplylistService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;

/**
 * 审批Controller
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
@Controller
@RequestMapping("/system/schoolapplylist")
public class SchoolapplylistController extends BaseController
{
	// 测试能否提交
    private String prefix = "system/schoolapplylist";

    @Autowired
    private ISchoolapplylistService schoolapplylistService;
    
    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system:schoolapplylist:view")
    @GetMapping()
    public String schoolapplylist(ModelMap map)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	map.put("me", me);
        return prefix + "/schoolapplylist";
    }
    
    @RequiresPermissions("system:schoolapplylist:view2")
    @GetMapping("/list2")
    public String schoolapplylist2(ModelMap map)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	map.put("me", me);
        return prefix + "/schoolapplylist2";
    }
    
    @RequiresPermissions("system:schoolapplylist:view2")
    @GetMapping("/list3")
    public String schoolapplylist3(ModelMap map)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	map.put("me", me);
        return prefix + "/schoolapplylist3";
    }
    
    @RequiresPermissions("system:schoolapplylist:approval")
    @GetMapping("/approval")
    public String approval(Schoolapplylist schoolapplylist, ModelMap map)
    {
    	map.put("schoolapplylist", schoolapplylist);
        return prefix + "/approval";
    }

    /**
     * 查询审批列表
     */
    @RequiresPermissions("system:schoolapplylist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolapplylist schoolapplylist)
    {
        startPage();
        List<Schoolapplylist> list = schoolapplylistService.selectSchoolapplylistList(schoolapplylist);
        return getDataTable(list);
    }

    /**
     * 导出审批列表
     */
    @RequiresPermissions("system:schoolapplylist:export")
    @Log(title = "审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolapplylist schoolapplylist)
    {
        List<Schoolapplylist> list = schoolapplylistService.selectSchoolapplylistList(schoolapplylist);
        ExcelUtil<Schoolapplylist> util = new ExcelUtil<Schoolapplylist>(Schoolapplylist.class);
        return util.exportExcel(list, "schoolapplylist");
    }

    /**
     * 新增审批
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
    	SysUser user = new SysUser();
    	List<SysUser> list = userService.selectUserList(user);
    	map.put("userlist", list);
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	map.put("me", me);
        return prefix + "/add";
    }

    /**
     * 新增保存审批
     */
    @RequiresPermissions("system:schoolapplylist:add")
    @Log(title = "审批", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolapplylist schoolapplylist)
    {
    	schoolapplylist.setCreatedate(DateUtils.getTime());
    	schoolapplylist.setApplystatus("1");
        return toAjax(schoolapplylistService.insertSchoolapplylist(schoolapplylist));
    }

    /**
     * 修改审批
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	SysUser user = new SysUser();
    	List<SysUser> list = userService.selectUserList(user);
    	mmap.put("userlist", list);
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	mmap.put("me", me);
        Schoolapplylist schoolapplylist = schoolapplylistService.selectSchoolapplylistById(id);
        mmap.put("schoolapplylist", schoolapplylist);
        return prefix + "/edit";
    }

    /**
     * 修改保存审批
     */
    @RequiresPermissions("system:schoolapplylist:edit")
    @Log(title = "审批", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolapplylist schoolapplylist)
    {
    	Schoolapplylist updateflag = schoolapplylistService.selectSchoolapplylistById(schoolapplylist.getId());
    	if (!updateflag.getApplystatus().equals("1")) {
    		return error("已审批的不能进行修改");
    	}
        return toAjax(schoolapplylistService.updateSchoolapplylist(schoolapplylist));
    }

    /**
     * 删除审批
     */
    @RequiresPermissions("system:schoolapplylist:remove")
    @Log(title = "审批", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolapplylistService.deleteSchoolapplylistByIds(ids));
    }
}
