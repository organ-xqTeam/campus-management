package com.ruoyi.project.system.examExaminationSubject.controller;

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
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.examExaminationSubject.domain.ExamExaminationSubject;
import com.ruoyi.project.system.examExaminationSubject.service.IExamExaminationSubjectService;

/**
 * 考试题目信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
@Controller
@RequestMapping("/system/examExaminationSubject")
public class ExamExaminationSubjectController extends BaseController
{
    private String prefix = "system/examExaminationSubject";
	
	@Autowired
	private IExamExaminationSubjectService examExaminationSubjectService;
	
	@RequiresPermissions("system:examExaminationSubject:view")
	@GetMapping()
	public String examExaminationSubject()
	{
	    return prefix + "/examExaminationSubject";
	}
	
	/**
	 * 查询考试题目列表
	 */
	@RequiresPermissions("system:examExaminationSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamExaminationSubject examExaminationSubject)
	{
		startPage();
        List<ExamExaminationSubject> list = examExaminationSubjectService.selectExamExaminationSubjectList(examExaminationSubject);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考试题目列表
	 */
	@RequiresPermissions("system:examExaminationSubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamExaminationSubject examExaminationSubject)
    {
    	List<ExamExaminationSubject> list = examExaminationSubjectService.selectExamExaminationSubjectList(examExaminationSubject);
        ExcelUtil<ExamExaminationSubject> util = new ExcelUtil<ExamExaminationSubject>(ExamExaminationSubject.class);
        return util.exportExcel(list, "examExaminationSubject");
    }
	
	/**
	 * 新增考试题目
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考试题目
	 */
	@RequiresPermissions("system:examExaminationSubject:add")
	@Log(title = "考试题目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamExaminationSubject examExaminationSubject)
	{		
		examExaminationSubject.setId(Stringutil.getLongUID()+"");
		return toAjax(examExaminationSubjectService.insertExamExaminationSubject(examExaminationSubject));
	}

	/**
	 * 修改考试题目
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamExaminationSubject examExaminationSubject = examExaminationSubjectService.selectExamExaminationSubjectById(id);
		mmap.put("examExaminationSubject", examExaminationSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考试题目
	 */
	@RequiresPermissions("system:examExaminationSubject:edit")
	@Log(title = "考试题目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamExaminationSubject examExaminationSubject)
	{		
		return toAjax(examExaminationSubjectService.updateExamExaminationSubject(examExaminationSubject));
	}
	
	/**
	 * 删除考试题目
	 */
	@RequiresPermissions("system:examExaminationSubject:remove")
	@Log(title = "考试题目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examExaminationSubjectService.deleteExamExaminationSubjectByIds(ids));
	}
	
}
