
package com.ruoyi.project.system.examSubjectOption.controller;

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
import com.ruoyi.project.system.examSubjectOption.domain.ExamSubjectOption;
import com.ruoyi.project.system.examSubjectOption.service.IExamSubjectOptionService;

/**
 * 选择题选项信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Controller
@RequestMapping("/system/examSubjectOption")
public class ExamSubjectOptionController extends BaseController
{
    private String prefix = "system/examSubjectOption";
	
	@Autowired
	private IExamSubjectOptionService examSubjectOptionService;
	
	@RequiresPermissions("system:examSubjectOption:view")
	@GetMapping()
	public String examSubjectOption()
	{
	    return prefix + "/examSubjectOption";
	}
	
	/**
	 * 查询选择题选项列表
	 */
	@RequiresPermissions("system:examSubjectOption:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamSubjectOption examSubjectOption)
	{
		startPage();
        List<ExamSubjectOption> list = examSubjectOptionService.selectExamSubjectOptionList(examSubjectOption);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出选择题选项列表
	 */
	@RequiresPermissions("system:examSubjectOption:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamSubjectOption examSubjectOption)
    {
    	List<ExamSubjectOption> list = examSubjectOptionService.selectExamSubjectOptionList(examSubjectOption);
        ExcelUtil<ExamSubjectOption> util = new ExcelUtil<ExamSubjectOption>(ExamSubjectOption.class);
        return util.exportExcel(list, "examSubjectOption");
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
	@RequiresPermissions("system:examSubjectOption:add")
	@Log(title = "选择题选项", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamSubjectOption examSubjectOption)
	{		
		return toAjax(examSubjectOptionService.insertExamSubjectOption(examSubjectOption));
	}

	/**
	 * 修改选择题选项
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamSubjectOption examSubjectOption = examSubjectOptionService.selectExamSubjectOptionById(id);
		mmap.put("examSubjectOption", examSubjectOption);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存选择题选项
	 */
	@RequiresPermissions("system:examSubjectOption:edit")
	@Log(title = "选择题选项", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamSubjectOption examSubjectOption)
	{		
		return toAjax(examSubjectOptionService.updateExamSubjectOption(examSubjectOption));
	}
	
	/**
	 * 删除选择题选项
	 */
	@RequiresPermissions("system:examSubjectOption:remove")
	@Log(title = "选择题选项", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examSubjectOptionService.deleteExamSubjectOptionByIds(ids));
	}
	
}
