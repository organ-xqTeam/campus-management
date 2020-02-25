package com.ruoyi.project.system.TeachingInfo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;

/**
 * 教师管理Controller
 * 
 * @author ruoyi
 * @date 2019-11-22
 */
@Controller
@RequestMapping("/system/TeachingInfo")
public class TeachingInfoController extends BaseController
{
    private String prefix = "system/TeachingInfo";
    @Autowired
    private ITeachingInfoService teachingInfoService;
    @Autowired
    private ISysUserService userService ;
    
    @GetMapping("/bindingTeacher")
    public String bindingTeacher()
    {
        return  "system/bindingTeacher/TeachingInfo";
    }
    @GetMapping("/editBing/{id}")
    public String editBing(@PathVariable("id") Long id, ModelMap mmap)
    {
        TeachingInfo teachingInfo = teachingInfoService.selectTeachingInfoById(id);
        mmap.put("teachingInfo", teachingInfo);
        SysUser user =new SysUser();
        List<SysUser> userList=  userService.selectUserList(user);
        mmap.put("userList", userList);
        return  "system/bindingTeacher/edit";
    }
    @PostMapping("/editBing")
    @ResponseBody
    public AjaxResult editBingSave(TeachingInfo teachingInfo)
    {
        return toAjax(teachingInfoService.updateTeachingInfo(teachingInfo));
    }



    @RequiresPermissions("system:TeachingInfo:view")
    @GetMapping()
    public String TeachingInfo()
    {
        return prefix + "/TeachingInfo";
    }
    
    @RequiresPermissions("system:TeachingInfo:view")
    @GetMapping("/page2")
    public String TeachingInfo2()
    {
        return "system/TeachingInfo2/TeachingInfo";
    }

    @GetMapping("/showview/{id}/{type}")
    public String showview(@PathVariable("id") Long id,@PathVariable("type") Long type, ModelMap mmap)
    {
    	TeachingInfo teacher = teachingInfoService.selectTeachingInfoById(id);
    	mmap.put("teacher", teacher);
    	return prefix + "/viewedit" + type;
    }
    
    /**
     * 查询教师管理列表
     */
    @RequiresPermissions("system:TeachingInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TeachingInfo teachingInfo)
    {
        startPage();
        List<TeachingInfo> list = teachingInfoService.selectTeachingInfoList(teachingInfo);
        return getDataTable(list);
    }

    /**
     * 导出教师管理列表
     */
    @RequiresPermissions("system:TeachingInfo:export")
    @Log(title = "教师管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachingInfo teachingInfo)
    {
        List<TeachingInfo> list = teachingInfoService.selectTeachingInfoList(teachingInfo);
        ExcelUtil<TeachingInfo> util = new ExcelUtil<TeachingInfo>(TeachingInfo.class);
        return util.exportExcel(list, "TeachingInfo");
    }

    /**
     * 新增教师管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教师管理
     */
    @RequiresPermissions("system:TeachingInfo:add")
    @Log(title = "教师管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TeachingInfo teachingInfo)
    {
    	
    	Date da = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		
		String randomNum = System.currentTimeMillis()+"";  
    	String teacherId="T"+dateFormat.format(da)+randomNum.substring(randomNum.length()-4, randomNum.length());
    	teachingInfo.setTeacherId(teacherId);;
    	SysUser user= new SysUser();
    	user.setDeptId((long) 103);
		user.setRoleId((long) 4);
    	//岗位 教师
    	Long roleIds[] = {(long)4};
    	user.setRoleIds(roleIds);
    	user.setLoginName(teacherId);
    	user.setUserName(teachingInfo.getTeachingName());
    
    	user.setPassword("123456");
    	userService.insertUser(user);
    	
    	user=  userService.selectUserList(user).get(0);
    	teachingInfo.setUserId(user.getUserId());
        return toAjax(teachingInfoService.insertTeachingInfo(teachingInfo));
    }

    /**
     * 修改教师管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TeachingInfo teachingInfo = teachingInfoService.selectTeachingInfoById(id);
        mmap.put("teachingInfo", teachingInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存教师管理
     */
    @RequiresPermissions("system:TeachingInfo:edit")
    @Log(title = "教师管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TeachingInfo teachingInfo)
    {
        return toAjax(teachingInfoService.updateTeachingInfo(teachingInfo));
    }

    /**
     * 删除教师管理
     */
    @RequiresPermissions("system:TeachingInfo:remove")
    @Log(title = "教师管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(teachingInfoService.deleteTeachingInfoByIds(ids));
    }
}
