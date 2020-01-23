package com.ruoyi.project.system.schoolstudentslist.controller;

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
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;

/**
 * 学生列Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/schoolstudentslist")
public class SchoolstudentslistController extends BaseController
{
    private String prefix = "system/schoolstudentslist";
    @Autowired
    private ISysUserService userService ;
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;
    @GetMapping("/editBing/{id}")
    public String editBing(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
        mmap.put("schoolstudentslist", schoolstudentslist);
        SysUser user =new SysUser();
        List<SysUser> userList=  userService.selectUserList(user);
        //List<User> userList =userService.selectunguanlianUserList(user);
        mmap.put("userList", userList);
        return  "system/bindingStudent/edit";
    }
    @RequiresPermissions("system:schoolstudentslist:view")
    @GetMapping()
    public String schoolstudentslist()
    {
        return prefix + "/schoolstudentslist";
    }

    
    
    @GetMapping("/bindingStudent")
    public String bindingStudent()
    {
        return  "system/bindingStudent/schoolstudentslist";
    }
    
    
    

    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:schoolstudentslist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolstudentslist schoolstudentslist)
    {
        startPage();
        schoolstudentslist.setApprovalstate("2");
        List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
        return getDataTable(list);
    }

    /**
     * 导出学生列列表
     */
    @RequiresPermissions("system:schoolstudentslist:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolstudentslist schoolstudentslist)
    {
        List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
        ExcelUtil<Schoolstudentslist> util = new ExcelUtil<Schoolstudentslist>(Schoolstudentslist.class);
        return util.exportExcel(list, "schoolstudentslist");
    }

    /**
     * 新增学生列
     */
    @GetMapping("/add")
    public String add(Schoolstudentslist student, ModelMap map) 
    {
    	map.put("student", student);
        return prefix + "/add";
    }
    @GetMapping("/vieweditor/{id}")
    public String vieweditor(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	return prefix + "/vieweditor";
    }
    
    @GetMapping("/vieweditor2/{id}")
    public String vieweditor2(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	return prefix + "/vieweditor2";
    }

    /**
     * 新增保存学生列
     */
    @RequiresPermissions("system:schoolstudentslist:add")
    @Log(title = "学生列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolstudentslist schoolstudentslist)
    {
    	Date da = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String randomNum = System.currentTimeMillis()+"";  
    	String studentsId="S"+dateFormat.format(da)+randomNum.substring(randomNum.length()-4, randomNum.length());
    	schoolstudentslist.setStudentsId(studentsId);;
    	SysUser user= new SysUser();
    	user.setDeptId((long) 103);
		user.setRoleId((long) 5);
    	//岗位 教师
    	Long roleIds[] = {(long)5};
    	user.setRoleIds(roleIds);
    	user.setLoginName(studentsId);
    	user.setUserName(schoolstudentslist.getStudentsName());
    	
    	user.setPassword("123456");
    	user.setCreateBy("admin");
    	userService.insertUser(user);
    	user=  userService.selectUserList(user).get(0);
    	schoolstudentslist.setUserId(user.getUserId());
    	schoolstudentslist.setApprovalstate("2");
        return toAjax(schoolstudentslistService.insertSchoolstudentslist(schoolstudentslist));
    }

    /**
     * 修改学生列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
        mmap.put("schoolstudentslist", schoolstudentslist);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生列
     */
    @RequiresPermissions("system:schoolstudentslist:edit")
    @Log(title = "学生列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolstudentslist schoolstudentslist)
    {
        return toAjax(schoolstudentslistService.updateSchoolstudentslist(schoolstudentslist));
    }

    /**
     * 删除学生列
     */
    @RequiresPermissions("system:schoolstudentslist:remove")
    @Log(title = "学生列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolstudentslistService.deleteSchoolstudentslistByIds(ids));
    }
}
