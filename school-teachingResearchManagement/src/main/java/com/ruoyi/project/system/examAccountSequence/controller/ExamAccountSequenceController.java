package com.ruoyi.project.system.examAccountSequence.controller;

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
import com.ruoyi.project.system.examAccountSequence.domain.ExamAccountSequence;
import com.ruoyi.project.system.examAccountSequence.service.IExamAccountSequenceService;

/**
 * 科目测评维度顺序显示信息操作处理
 * 
 * @author ruoyi
 * @date 2019-10-24
 */
@Controller
@RequestMapping("/system/examAccountSequence")
public class ExamAccountSequenceController extends BaseController
{
    private String prefix = "system/examAccountSequence";
	
	@Autowired
	private IExamAccountSequenceService examAccountSequenceService;
	
	@RequiresPermissions("system:examAccountSequence:view")
	@GetMapping()
	public String examAccountSequence()
	{
	    return prefix + "/examAccountSequence";
	}
	
	/**
	 * 查询科目测评维度顺序显示列表
	 */
	@RequiresPermissions("system:examAccountSequence:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamAccountSequence examAccountSequence)
	{
		startPage();
        List<ExamAccountSequence> list = examAccountSequenceService.selectExamAccountSequenceList(examAccountSequence);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出科目测评维度顺序显示列表
	 */
	@RequiresPermissions("system:examAccountSequence:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamAccountSequence examAccountSequence)
    {
    	List<ExamAccountSequence> list = examAccountSequenceService.selectExamAccountSequenceList(examAccountSequence);
        ExcelUtil<ExamAccountSequence> util = new ExcelUtil<ExamAccountSequence>(ExamAccountSequence.class);
        return util.exportExcel(list, "examAccountSequence");
    }
	
	/**
	 * 新增科目测评维度顺序显示
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存科目测评维度顺序显示
	 */
	@RequiresPermissions("system:examAccountSequence:add")
	@Log(title = "科目测评维度顺序显示", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamAccountSequence examAccountSequence)
	{		
		return toAjax(examAccountSequenceService.insertExamAccountSequence(examAccountSequence));
	}

	/**
	 * 修改科目测评维度顺序显示
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamAccountSequence examAccountSequence = examAccountSequenceService.selectExamAccountSequenceById(id);
		mmap.put("examAccountSequence", examAccountSequence);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存科目测评维度顺序显示
	 */
	@RequiresPermissions("system:examAccountSequence:edit")
	@Log(title = "科目测评维度顺序显示", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamAccountSequence examAccountSequence)
	{		
		return toAjax(examAccountSequenceService.updateExamAccountSequence(examAccountSequence));
	}
	
	/**
	 * 删除科目测评维度顺序显示
	 */
	@RequiresPermissions("system:examAccountSequence:remove")
	@Log(title = "科目测评维度顺序显示", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examAccountSequenceService.deleteExamAccountSequenceByIds(ids));
	}
	
}
