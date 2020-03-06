package com.ruoyi.project.system.examOrdinaryResult.controller;

import java.util.ArrayList;
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
import com.ruoyi.project.system.examOrdinaryResult.domain.ExamOrdinaryResult;
import com.ruoyi.project.system.examOrdinaryResult.service.IExamOrdinaryResultService;
import com.ruoyi.project.system.examSubjectCategory.domain.ExamSubjectCategory;
import com.ruoyi.project.system.examSubjectCategory.service.IExamSubjectCategoryService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;

/**
 * 普通试题类型结果信息操作处理
 * 
 * @author ruoyi
 * @date 2019-10-25
 */
@Controller
@RequestMapping("/system/examOrdinaryResult")
public class ExamOrdinaryResultController extends BaseController
{
    private String prefix = "system/examOrdinaryResult";
	
	@Autowired
	private IExamOrdinaryResultService examOrdinaryResultService;
	@Autowired
	private IExamSubjectShortAnswerService examSubjectShortAnswerService;
	@Autowired
	private IExamSubjectCategoryService examSubjectCategoryService;
	
	@RequiresPermissions("system:examOrdinaryResult:view")
	@GetMapping()
	public String examOrdinaryResult(ModelMap mmap)
	{	
		//查询简单分类 的所有根目录id
		ExamSubjectCategory examSubjectCategory = new ExamSubjectCategory();
		examSubjectCategory.setType(2);
		List<ExamSubjectCategory> categories = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
		//所有 试题
		List<ExamSubjectShortAnswer> examSubjectShortAnswers = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(null);
		
		//匹配 出所有 简单分类试题
		List<ExamSubjectShortAnswer> list = new ArrayList<ExamSubjectShortAnswer>();
		for (int i = 0; i < examSubjectShortAnswers.size(); i++) {
			ExamSubjectShortAnswer answer = examSubjectShortAnswers.get(i);
			for (int j = 0; j < categories.size(); j++) {
				if (answer.getAnalysis().equals(categories.get(j).getId())) {
					list.add(answer);
					break;
				}
			}
		}
		mmap.put("SubjectShortAnswer", list);
	    return prefix + "/examOrdinaryResult";
	}
	
	/**
	 * 查询普通试题类型结果列表
	 */
	@RequiresPermissions("system:examOrdinaryResult:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamOrdinaryResult examOrdinaryResult)
	{
		startPage();
        List<ExamOrdinaryResult> list = examOrdinaryResultService.selectExamOrdinaryResultList(examOrdinaryResult);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出普通试题类型结果列表
	 */
	@RequiresPermissions("system:examOrdinaryResult:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamOrdinaryResult examOrdinaryResult)
    {
    	List<ExamOrdinaryResult> list = examOrdinaryResultService.selectExamOrdinaryResultList(examOrdinaryResult);
        ExcelUtil<ExamOrdinaryResult> util = new ExcelUtil<ExamOrdinaryResult>(ExamOrdinaryResult.class);
        return util.exportExcel(list, "examOrdinaryResult");
    }
	
	/**
	 * 新增普通试题类型结果
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{	
		//查询简单分类 的所有根目录id
		ExamSubjectCategory examSubjectCategory = new ExamSubjectCategory();
		examSubjectCategory.setType(2);
		List<ExamSubjectCategory> categories = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
		//所有 试题
		List<ExamSubjectShortAnswer> examSubjectShortAnswers = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(null);
		
		//匹配 出所有 简单分类试题
		List<ExamSubjectShortAnswer> list = new ArrayList<ExamSubjectShortAnswer>();
		for (int i = 0; i < examSubjectShortAnswers.size(); i++) {
			ExamSubjectShortAnswer answer = examSubjectShortAnswers.get(i);
			for (int j = 0; j < categories.size(); j++) {
				if (answer.getAnalysis().equals(categories.get(j).getId())) {
					list.add(answer);
					break;
				}
			}
		}
		mmap.put("SubjectShortAnswer", list);
	    return prefix + "/add";
	}
	
	/**
	 * 富文本框
	 */
	
	@GetMapping("/summernote")
	public String summernote() {
		return prefix + "/summernote";
	}
	
	/**
	 * 新增保存普通试题类型结果
	 */
	@RequiresPermissions("system:examOrdinaryResult:add")
	@Log(title = "普通试题类型结果", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamOrdinaryResult examOrdinaryResult)
	{		
		ExamOrdinaryResult eo = new ExamOrdinaryResult();
		eo.setOptionName(examOrdinaryResult.getOptionName());
		List<ExamOrdinaryResult> list = examOrdinaryResultService.selectExamOrdinaryResultList(eo);
		
		if (list.size() > 0) {
			return error("存在相同类型");
		}
		 
		examOrdinaryResult.setId(Stringutil.getUUID());
		return toAjax(examOrdinaryResultService.insertExamOrdinaryResult(examOrdinaryResult));
	}

	/**
	 * 修改普通试题类型结果
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		
		//查询简单分类 的所有根目录id
		ExamSubjectCategory examSubjectCategory = new ExamSubjectCategory();
		examSubjectCategory.setType(2);
		List<ExamSubjectCategory> categories = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
		//所有 试题
		List<ExamSubjectShortAnswer> examSubjectShortAnswers = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(null);
		
		//匹配 出所有 简单分类试题
		List<ExamSubjectShortAnswer> list = new ArrayList<ExamSubjectShortAnswer>();
		for (int i = 0; i < examSubjectShortAnswers.size(); i++) {
			ExamSubjectShortAnswer answer = examSubjectShortAnswers.get(i);
			for (int j = 0; j < categories.size(); j++) {
				if (answer.getAnalysis().equals(categories.get(j).getId())) {
					list.add(answer);
					break;
				}
			}
		}
		mmap.put("SubjectShortAnswer", list);
		ExamOrdinaryResult examOrdinaryResult = examOrdinaryResultService.selectExamOrdinaryResultById(id);
		mmap.put("examOrdinaryResult", examOrdinaryResult);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存普通试题类型结果
	 */
	@RequiresPermissions("system:examOrdinaryResult:edit")
	@Log(title = "普通试题类型结果", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamOrdinaryResult examOrdinaryResult)
	{		
		return toAjax(examOrdinaryResultService.updateExamOrdinaryResult(examOrdinaryResult));
	}
	
	/**
	 * 删除普通试题类型结果
	 */
	@RequiresPermissions("system:examOrdinaryResult:remove")
	@Log(title = "普通试题类型结果", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examOrdinaryResultService.deleteExamOrdinaryResultByIds(ids));
	}
	
}
