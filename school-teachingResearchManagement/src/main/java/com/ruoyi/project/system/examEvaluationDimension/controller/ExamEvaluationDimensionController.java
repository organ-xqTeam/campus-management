package com.ruoyi.project.system.examEvaluationDimension.controller;

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
import com.ruoyi.project.system.examEvaluationDimension.domain.ExamEvaluationDimension;
import com.ruoyi.project.system.examEvaluationDimension.service.IExamEvaluationDimensionService;

/**
 * 选择题选项信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-16
 */
@Controller
@RequestMapping("/system/examEvaluationDimension")
public class ExamEvaluationDimensionController extends BaseController
{
    private String prefix = "system/examEvaluationDimension";
	
	@Autowired
	private IExamEvaluationDimensionService examEvaluationDimensionService;
	
	@RequiresPermissions("system:examEvaluationDimension:view")
	@GetMapping()
	public String examEvaluationDimension()
	{
	    return prefix + "/examEvaluationDimension";
	}
	
	/**
	 * 查询选择题选项列表
	 */
	@RequiresPermissions("system:examEvaluationDimension:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamEvaluationDimension examEvaluationDimension)
	{
		startPage();
        List<ExamEvaluationDimension> list = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出选择题选项列表
	 */
	@RequiresPermissions("system:examEvaluationDimension:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamEvaluationDimension examEvaluationDimension)
    {
    	List<ExamEvaluationDimension> list = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension);
        ExcelUtil<ExamEvaluationDimension> util = new ExcelUtil<ExamEvaluationDimension>(ExamEvaluationDimension.class);
        return util.exportExcel(list, "examEvaluationDimension");
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
	@RequiresPermissions("system:examEvaluationDimension:add")
	@Log(title = "选择题选项", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamEvaluationDimension examEvaluationDimension)
	{		
		return toAjax(examEvaluationDimensionService.insertExamEvaluationDimension(examEvaluationDimension));
	}

	/**
	 * 修改选择题选项
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamEvaluationDimension examEvaluationDimension = examEvaluationDimensionService.selectExamEvaluationDimensionById(id);
		mmap.put("examEvaluationDimension", examEvaluationDimension);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存选择题选项
	 */
	@RequiresPermissions("system:examEvaluationDimension:edit")
	@Log(title = "选择题选项", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamEvaluationDimension examEvaluationDimension)
	{		
		return toAjax(examEvaluationDimensionService.updateExamEvaluationDimension(examEvaluationDimension));
	}
	
	/**
	 * 删除选择题选项
	 */
	@RequiresPermissions("system:examEvaluationDimension:remove")
	@Log(title = "选择题选项", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examEvaluationDimensionService.deleteExamEvaluationDimensionByIds(ids));
	}
	
}
