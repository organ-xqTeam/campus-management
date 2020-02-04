package com.ruoyi.project.system.schoolstay.controller;

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
import com.ruoyi.project.system.schoolDormStudents.domain.SchoolDormStudents;
import com.ruoyi.project.system.schoolDormStudents.service.ISchoolDormStudentsService;
import com.ruoyi.project.system.schooldorm.domain.Schooldorm;
import com.ruoyi.project.system.schoolstay.service.ISchoolstayService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;

@Controller
@RequestMapping("/system/schoolstay")
public class SchoolstayController extends BaseController {
	private String prefix = "system/schoolstay";
	@Autowired
	private ISchoolstayService schoolstayService;
	

	@Autowired
	private ISchoolstudentslistService schoolstudentslistService;
	  @Autowired
	  private ISchoolDormStudentsService schoolDormStudentsService;


	/* @RequiresPermissions("system:schooldorm:view") */
	@GetMapping()
	public String schooldorm() {
		System.out.println("进入");
		return prefix + "/schoolstay";
	}

	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Schooldorm schooldorm) {
		startPage();
		List<Schooldorm> list = schoolstayService.selectSchooldormList(schooldorm);
		return getDataTable(list);
	}
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") Long id, ModelMap mmap) {
		SchoolDormStudents schoolDormStudents =new SchoolDormStudents();
		schoolDormStudents.setDormId(id);
		mmap.put("schoolDormStudents", schoolDormStudents);
		Schoolstudentslist schoolstudentslist =new Schoolstudentslist();
		//查找未在寝室入住的学生
		//List<Schoolstudentslist>  schoolstudentslistList= schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
		List<Schoolstudentslist>  schoolstudentslistList= schoolstudentslistService.selectSchoolstudentslistListUnMove(schoolstudentslist);
		mmap.put("schoolstudentslistList", schoolstudentslistList);
		return prefix + "/add";
	}
	
    /**
     	* 新增保存宿舍学生
     */
  /*  @RequiresPermissions("system:schoolDormStudents:add")*/
    @Log(title = "宿舍中增加学生", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolDormStudents schoolDormStudents)
    {
    	schoolDormStudents.setUpdatedate(new Date());
    	System.out.println(schoolDormStudents);
        return toAjax(schoolDormStudentsService.insertSchoolDormStudents(schoolDormStudents));
    }
    @Log(title = "重置宿舍中的学生", businessType = BusinessType.UPDATE)
    @PostMapping("/resetStayStudents")
    @ResponseBody
    public AjaxResult resetStayStudents(Schooldorm schooldorm)
    {
    	Long dormId= schooldorm.getId();
    	SchoolDormStudents schoolDormStudents =new SchoolDormStudents();
    	schoolDormStudents.setDormId(dormId);
    	schoolDormStudents.setIsdisuse("1");
    	schoolDormStudents.setUpdatedate(new Date());
    	//更新为弃用
    	return  toAjax(schoolDormStudentsService.updateSchoolDormStudentsIsdisuseByDormId(schoolDormStudents));
    	/*schoolDormStudents.setUpdatedate(new Date());
    	System.out.println(schoolDormStudents);
    	return toAjax(schoolDormStudentsService.insertSchoolDormStudents(schoolDormStudents));*/
    }
    
    
    
}
