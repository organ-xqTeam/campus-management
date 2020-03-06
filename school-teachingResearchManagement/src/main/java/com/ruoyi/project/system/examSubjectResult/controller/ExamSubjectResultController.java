package com.ruoyi.project.system.examSubjectResult.controller;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.examEvaluationDimension.domain.ExamEvaluationDimension;
import com.ruoyi.project.system.examEvaluationDimension.service.IExamEvaluationDimensionService;
import com.ruoyi.project.system.examSubjectCategory.domain.ExamSubjectCategory;
import com.ruoyi.project.system.examSubjectCategory.service.IExamSubjectCategoryService;
import com.ruoyi.project.system.examSubjectResult.domain.ExamSubjectResult;
import com.ruoyi.project.system.examSubjectResult.service.IExamSubjectResultService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;

/**
 * 科目类型结果信息操作处理
 * 
 * @author ruoyi
 * @date 2019-10-25
 */
@Controller
@RequestMapping("/system/examSubjectResult")
public class ExamSubjectResultController extends BaseController
{
    private String prefix = "system/examSubjectResult";
    
    
    
    @Autowired
	private IExamEvaluationDimensionService examEvaluationDimensionService;
    
    @Autowired
	private IExamSubjectShortAnswerService examSubjectShortAnswerService;
	@Autowired
	private IExamSubjectResultService examSubjectResultService;
	@Autowired
	private IExamSubjectCategoryService examSubjectCategoryService;
	@RequiresPermissions("system:examSubjectResult:view")
	@GetMapping()
	public String examSubjectResult(ModelMap mmap)
	{	
		
		
		//查询简单分类 的所有根目录id
		ExamSubjectCategory examSubjectCategory = new ExamSubjectCategory();
		examSubjectCategory.setType(1);
		examSubjectCategory.setModifier("1");
		List<ExamSubjectCategory> categories = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
		//所有 试题
		List<ExamSubjectShortAnswer> examSubjectShortAnswers = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(null);
		
		//匹配 出所有 简单分类试题
		List<ExamSubjectCategory> list = new ArrayList<ExamSubjectCategory>();
		for (int j = 0; j < categories.size(); j++) {
			ExamSubjectCategory cg = categories.get(j);
			for (int i = 0; i < examSubjectShortAnswers.size(); i++) {
				ExamSubjectShortAnswer answer = examSubjectShortAnswers.get(i);
				if (answer.getAnalysis().equals(categories.get(j).getId())) {
					list.add(cg);
					break;
				}
			}
		}
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			ExamSubjectCategory lt = list.get(i);
			ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
			examEvaluationDimension.setSubjectChoicesId(lt.getId());
			List<ExamEvaluationDimension> la = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension );
			
			JSONArray arr1 = new JSONArray();
			for (int j = 0; j < la.size(); j++) {
				JSONObject object = new JSONObject();
				object.put("optionName", la.get(j).getOptionName());
				object.put("scid", la.get(j).getSubjectChoicesId());
				object.put("id", la.get(j).getId());
				arr1.add(object);
			}
			
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", lt.getId());
			jsonObject.put("analysis", lt.getId());
			jsonObject.put("list", arr1);
			array.add(jsonObject);
		}
		mmap.put("SubjectCategory", list);
		mmap.put("dimension", array);
	    return prefix + "/examSubjectResult";
	}
	
	/**
	 * 查询科目类型结果列表
	 */
	@RequiresPermissions("system:examSubjectResult:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamSubjectResult examSubjectResult)
	{
		startPage();
        List<ExamSubjectResult> list = examSubjectResultService.selectExamSubjectResultList(examSubjectResult);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出科目类型结果列表
	 */
	@RequiresPermissions("system:examSubjectResult:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamSubjectResult examSubjectResult)
    {
    	List<ExamSubjectResult> list = examSubjectResultService.selectExamSubjectResultList(examSubjectResult);
        ExcelUtil<ExamSubjectResult> util = new ExcelUtil<ExamSubjectResult>(ExamSubjectResult.class);
        return util.exportExcel(list, "examSubjectResult");
    }
	
	/**
	 * 新增科目类型结果
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{	
		
		
		//查询简单分类 的所有根目录id
		ExamSubjectCategory examSubjectCategory = new ExamSubjectCategory();
		examSubjectCategory.setType(1);
		examSubjectCategory.setModifier("1");
		List<ExamSubjectCategory> categories = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
		//所有 试题
		List<ExamSubjectShortAnswer> examSubjectShortAnswers = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(null);
		
		//匹配 出所有 简单分类试题
		List<ExamSubjectCategory> list = new ArrayList<ExamSubjectCategory>();
		for (int j = 0; j < categories.size(); j++) {
			ExamSubjectCategory cg = categories.get(j);
			for (int i = 0; i < examSubjectShortAnswers.size(); i++) {
				ExamSubjectShortAnswer answer = examSubjectShortAnswers.get(i);
				if (answer.getAnalysis().equals(categories.get(j).getId())) {
					list.add(cg);
					break;
				}
			}
		}
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			ExamSubjectCategory lt = list.get(i);
			ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
			examEvaluationDimension.setSubjectChoicesId(lt.getId());
			List<ExamEvaluationDimension> la = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension );
			
			JSONArray arr1 = new JSONArray();
			for (int j = 0; j < la.size(); j++) {
				JSONObject object = new JSONObject();
				object.put("optionName", la.get(j).getOptionName());
				object.put("scid", la.get(j).getSubjectChoicesId());
				object.put("id", la.get(j).getId());
				arr1.add(object);
			}
			
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", lt.getId());
			jsonObject.put("analysis", lt.getId());
			jsonObject.put("list", arr1);
			array.add(jsonObject);
		}
		mmap.put("SubjectCategory", list);
		mmap.put("dimension", array);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存科目类型结果
	 */
	@RequiresPermissions("system:examSubjectResult:add")
	@Log(title = "科目类型结果", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamSubjectResult examSubjectResult)
	{		
		examSubjectResult.setId(Stringutil.getUUID());
		
		
		String ids =  examSubjectResult.getOptionCode();
		
		String[] opopid = ids.split(",");
		List<String> ls = new ArrayList<String>();
		for (int i = 0; i < opopid.length; i++) {
			
			if (opopid[i].length() > 0) {
				ls.add(opopid[i]);
			}
		}
		boolean key = false;
		List<ExamSubjectResult> list = examSubjectResultService.selectExamSubjectResultList(null);
		for (int i = 0; i < list.size(); i++) {
			ExamSubjectResult examSubjectResult2 = list.get(i);
			String str =  examSubjectResult2.getOptionCode();
			String[] strids = str.split(",");
			List<String> li = new ArrayList<String>();
			for (int j = 0; j < strids.length; j++) {
				
				if (strids[j].length() > 0) {
					li.add(strids[j]);
				}
			}
			if (ls.containsAll(li) && li.containsAll(ls)) {
				key = true;
				break;
			}
		}
		if (key) {
			return error("新增测评结果类型冲突");
		}
		return toAjax(examSubjectResultService.insertExamSubjectResult(examSubjectResult));
	}

	/**
	 * 修改科目类型结果
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		
		ExamSubjectResult examSubjectResult = examSubjectResultService.selectExamSubjectResultById(id);
		

		//查询简单分类 的所有根目录id
		ExamSubjectCategory examSubjectCategory = new ExamSubjectCategory();
//		examSubjectCategory.setType(1);
//		examSubjectCategory.setModifier("1");
		examSubjectCategory.setId(examSubjectResult.getOptionName());
		List<ExamSubjectCategory> categories = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
		//所有 试题
//		List<ExamSubjectShortAnswer> examSubjectShortAnswers = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(null);
		
		//匹配 出所有 简单分类试题
//		List<ExamSubjectCategory> list = new ArrayList<ExamSubjectCategory>();
//		for (int j = 0; j < categories.size(); j++) {
//			ExamSubjectCategory cg = categories.get(j);
//			for (int i = 0; i < examSubjectShortAnswers.size(); i++) {
//				ExamSubjectShortAnswer answer = examSubjectShortAnswers.get(i);
//				if (answer.getAnalysis().equals(categories.get(j).getId())) {
//					list.add(cg);
//					break;
//				}
//			}
//		}
		
		
		String str =  examSubjectResult.getOptionCode();
		
		String[] ss =  str.split(",");
		JSONArray array = new JSONArray();
		
		for (int i = 0; i < ss.length; i++) {
			if (ss[i].length() > 0) {
				ExamEvaluationDimension dimension = examEvaluationDimensionService.selectExamEvaluationDimensionById(ss[i]);
				JSONObject object = new JSONObject();
				object.put("optionName", dimension.getOptionName());
				object.put("scid", dimension.getSubjectChoicesId());
				object.put("id", dimension.getId());
				array.add(object);
			}
		}
		
		mmap.put("SubjectCategory", categories);
		mmap.put("dimension", array);
		
		
		mmap.put("examSubjectResult", examSubjectResult);
	    return prefix + "/edit";
	}
	
	
	/**
	 * 富文本框
	 */
	
	@GetMapping("/summernote")
	public String summernote() {
		return prefix + "/summernote";
	}
	
	
	/**
	 * 修改保存科目类型结果
	 */
	@RequiresPermissions("system:examSubjectResult:edit")
	@Log(title = "科目类型结果", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamSubjectResult examSubjectResult)
	{		
		return toAjax(examSubjectResultService.updateExamSubjectResult(examSubjectResult));
	}
	
	/**
	 * 删除科目类型结果
	 */
	@RequiresPermissions("system:examSubjectResult:remove")
	@Log(title = "科目类型结果", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examSubjectResultService.deleteExamSubjectResultByIds(ids));
	}
	
}
