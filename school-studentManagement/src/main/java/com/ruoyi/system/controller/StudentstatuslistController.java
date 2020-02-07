package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.Studentstatuslist;
import com.ruoyi.system.service.IStudentstatuslistService;

/**
 * 学籍管理Controller
 * 
 * @author ruoyi
 * @date 2020-02-04
 */
@Controller
@RequestMapping("/system/studentstatuslist")
public class StudentstatuslistController extends BaseController
{
    private String prefix = "system/studentstatuslist";

    @Autowired
    private IStudentstatuslistService studentstatuslistService;

    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;
    
    @RequiresPermissions("system:studentstatuslist:view")
    @GetMapping()
    public String studentstatuslist(ModelMap mmap)
    {
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(null);
    	mmap.put("studentslist", list);
        return prefix + "/studentstatuslist";
    }
    
    
    //studentlist
    /**
     * 在校管理
     * @return
     */
    
    @RequiresPermissions("system:studentlist:view")
    @GetMapping("/studentlist")
    public String studentlist()
    {
    	return prefix + "/studentlist";
    }
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:studentlist:list")
    @PostMapping("/liststudentlist")
    @ResponseBody
    public TableDataInfo Schoolmanagement(Schoolstudentslist schoolstudentslist)
    {
    	startPage();
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
    	return getDataTable(list);
    }
    
    
    /**
     * 查询学籍管理列表
     */
    @RequiresPermissions("system:studentstatuslist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Studentstatuslist studentstatuslist)
    {
        startPage();
        List<Studentstatuslist> list = studentstatuslistService.selectStudentstatuslistList(studentstatuslist);
        return getDataTable(list);
    }

    /**
     * 导出学籍管理列表
     */
    @RequiresPermissions("system:studentstatuslist:export")
    @Log(title = "学籍管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Studentstatuslist studentstatuslist)
    {
        List<Studentstatuslist> list = studentstatuslistService.selectStudentstatuslistList(studentstatuslist);
        ExcelUtil<Studentstatuslist> util = new ExcelUtil<Studentstatuslist>(Studentstatuslist.class);
        return util.exportExcel(list, "studentstatuslist");
    }

    
    
    
    /**
     * 新增学籍管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {	
    	List<Studentstatuslist> slist = studentstatuslistService.selectStudentstatuslistList(null);
    	Set<String> setlist = new HashSet<String>();
    	for (int i = 0; i < slist.size(); i++) {
    		setlist.add(slist.get(i).getStudentsId().trim());
		}
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(null);
    	List<Schoolstudentslist> li = new ArrayList<Schoolstudentslist>();
    	for (int i = 0; i < list.size(); i++) {
    		//System.out.println(setlist.contains(list.get(i).getId()+""));
			if (!setlist.contains(list.get(i).getId()+"")) {
				li.add(list.get(i));
			}
		}
    	mmap.put("studentslist", li);
    	return prefix + "/add";
    }

    /**
     * 新增保存学籍管理
     */
    @RequiresPermissions("system:studentstatuslist:add")
    @Log(title = "学籍管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Studentstatuslist studentstatuslist)
    {
        return toAjax(studentstatuslistService.insertStudentstatuslist(studentstatuslist));
    }
    /**
     * 设置学籍状态
     * @param studentstatuslist
     * @return
     */
    @PostMapping("/setstudentstatus")
    @ResponseBody
    public AjaxResult setstudentstatus(Studentstatuslist studentstatuslist)
    {
    	Studentstatuslist studen = new Studentstatuslist();
    	studen.setStudentsId(studentstatuslist.getStudentsId());
		List<Studentstatuslist> list = studentstatuslistService.selectStudentstatuslistList(studen );
		if (list.size() == 0) {
			return toAjax(studentstatuslistService.insertStudentstatuslist(studentstatuslist));
		}else {
			Studentstatuslist tus = list.get(0);
			studentstatuslist.setId(tus.getId());
			return toAjax(studentstatuslistService.updateStudentstatuslist(studentstatuslist));
		}
		
    }

    /**
     * 修改学籍管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(null);
    	mmap.put("studentslist", list);
        Studentstatuslist studentstatuslist = studentstatuslistService.selectStudentstatuslistById(id);
        mmap.put("studentstatuslist", studentstatuslist);
        return prefix + "/edit";
    }

    /**
     * 修改保存学籍管理
     */
    @RequiresPermissions("system:studentstatuslist:edit")
    @Log(title = "学籍管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Studentstatuslist studentstatuslist)
    {
        return toAjax(studentstatuslistService.updateStudentstatuslist(studentstatuslist));
    }

    /**
     * 删除学籍管理
     */
    @RequiresPermissions("system:studentstatuslist:remove")
    @Log(title = "学籍管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentstatuslistService.deleteStudentstatuslistByIds(ids));
    }
    
    @Log(title = "上传图片", businessType = BusinessType.UPDATE)
    @PostMapping("/importImg")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("file") MultipartFile file)
    {
        try
        {
        	String avatar = null;
            if (!file.isEmpty())
            {
                avatar = FileUploadUtils.upload(RuoYiConfig.getUploadPath(), file);
            }
			return success(avatar);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
    
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
    	ExcelUtil<Studentstatuslist> util = new ExcelUtil<Studentstatuslist>(Studentstatuslist.class);
    	List<Studentstatuslist> userList = util.importExcel(file.getInputStream());
    	//String operName = ShiroUtils.getSysUser().getLoginName();
    	String message = studentstatuslistService.importUser(userList, updateSupport);
    	return AjaxResult.success(message);
    }
    
    
    @RequiresPermissions("system:seestudent:view")
    @GetMapping("/seestudent/{id}")
    public String seestudent(@PathVariable("id") Long id, ModelMap mmap)
    {
    	
    	
    	Schoolstudentslist se = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", se);
    	return prefix + "/seestudent";
    }
    
    
    
}
