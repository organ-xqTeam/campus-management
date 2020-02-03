package com.ruoyi.project.system.examSubjectOptionOption.controller;

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
import com.ruoyi.project.system.examSubjectOptionOption.domain.ExamSubjectOptionOption;
import com.ruoyi.project.system.examSubjectOptionOption.service.IExamSubjectOptionOptionService;

/**
 * 选择题选项信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-13
 */
@Controller
@RequestMapping("/system/examSubjectOptionOption")
public class ExamSubjectOptionOptionController extends BaseController
{
    private String prefix = "system/examSubjectOptionOption";
	
	@Autowired
	private IExamSubjectOptionOptionService examSubjectOptionOptionService;
	
	@RequiresPermissions("system:examSubjectOptionOption:view")
	@GetMapping()
	public String examSubjectOptionOption()
	{
	    return prefix + "/examSubjectOptionOption";
	}
	
	/**
	 * 查询选择题选项列表
	 */
	@RequiresPermissions("system:examSubjectOptionOption:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamSubjectOptionOption examSubjectOptionOption)
	{
		startPage();
        List<ExamSubjectOptionOption> list = examSubjectOptionOptionService.selectExamSubjectOptionOptionList(examSubjectOptionOption);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出选择题选项列表
	 */
	@RequiresPermissions("system:examSubjectOptionOption:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamSubjectOptionOption examSubjectOptionOption)
    {
    	List<ExamSubjectOptionOption> list = examSubjectOptionOptionService.selectExamSubjectOptionOptionList(examSubjectOptionOption);
        ExcelUtil<ExamSubjectOptionOption> util = new ExcelUtil<ExamSubjectOptionOption>(ExamSubjectOptionOption.class);
        return util.exportExcel(list, "examSubjectOptionOption");
    }
	
	/**
	 * 新增选择题选项
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存选择题选项
	 */
	@RequiresPermissions("system:examSubjectOptionOption:add")
	@Log(title = "选择题选项", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamSubjectOptionOption examSubjectOptionOption)
	{		
		return toAjax(examSubjectOptionOptionService.insertExamSubjectOptionOption(examSubjectOptionOption));
	}

	/**
	 * 修改选择题选项
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamSubjectOptionOption examSubjectOptionOption = examSubjectOptionOptionService.selectExamSubjectOptionOptionById(id);
		mmap.put("examSubjectOptionOption", examSubjectOptionOption);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存选择题选项
	 */
	@RequiresPermissions("system:examSubjectOptionOption:edit")
	@Log(title = "选择题选项", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamSubjectOptionOption examSubjectOptionOption)
	{		
		return toAjax(examSubjectOptionOptionService.updateExamSubjectOptionOption(examSubjectOptionOption));
	}
	
	/**
	 * 删除选择题选项
	 */
	@RequiresPermissions("system:examSubjectOptionOption:remove")
	@Log(title = "选择题选项", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examSubjectOptionOptionService.deleteExamSubjectOptionOptionByIds(ids));
	}
	
}
