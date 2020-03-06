package com.ruoyi.project.system.examMbtiResult.controller;

import java.util.List;
import java.util.Map;

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

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.examAdInformation.domain.ExamAdInformation;
import com.ruoyi.project.system.examAdInformation.service.IExamAdInformationService;
import com.ruoyi.project.system.examMbtiResult.domain.ExamMbtiResult;
import com.ruoyi.project.system.examMbtiResult.service.IExamMbtiResultService;

/**
 * MBTI类型结果信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-26
 */
@Controller
@RequestMapping("/system/examMbtiResult")
public class ExamMbtiResultController extends BaseController
{
    private String prefix = "system/examMbtiResult";
	
    
    @Autowired
	private IExamAdInformationService examAdInformationService;
	@Autowired
	private IExamMbtiResultService examMbtiResultService;
	
	@RequiresPermissions("system:examMbtiResult:view")
	@GetMapping()
	public String examMbtiResult()
	{
	    return prefix + "/examMbtiResult";
	}
	
	/**
	 * 查询MBTI类型结果列表
	 */
	@RequiresPermissions("system:examMbtiResult:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamMbtiResult examMbtiResult)
	{
		startPage();
        List<ExamMbtiResult> list = examMbtiResultService.selectExamMbtiResultList(examMbtiResult);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出MBTI类型结果列表
	 */
	@RequiresPermissions("system:examMbtiResult:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamMbtiResult examMbtiResult)
    {
    	List<ExamMbtiResult> list = examMbtiResultService.selectExamMbtiResultList(examMbtiResult);
        ExcelUtil<ExamMbtiResult> util = new ExcelUtil<ExamMbtiResult>(ExamMbtiResult.class);
        return util.exportExcel(list, "examMbtiResult");
    }
	/**
	 * 富文本框
	 */
	
	@GetMapping("/summernote")
	public String summernote() {
		return prefix + "/summernote";
	}
	/**
	 * 新增MBTI类型结果
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存MBTI类型结果
	 */
	@RequiresPermissions("system:examMbtiResult:add")
	@Log(title = "MBTI类型结果", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam Map<String, Object> maps)
	{		
		System.out.println(maps);
		ExamMbtiResult examMbtiResult = new ExamMbtiResult();
		examMbtiResult.setId(Stringutil.getLongUID()+"");
		examMbtiResult.setOptionName((String) maps.get("optionName"));
		examMbtiResult.setOptionCode((String) maps.get("optionCode"));
		examMbtiResult.setOptionContent((String) maps.get("optionContent"));
		
		
		return toAjax(examMbtiResultService.insertExamMbtiResult(examMbtiResult));
	}

	/**
	 * 修改MBTI类型结果
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamMbtiResult examMbtiResult = examMbtiResultService.selectExamMbtiResultById(id);
		mmap.put("examMbtiResult", examMbtiResult);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存MBTI类型结果
	 */
	@RequiresPermissions("system:examMbtiResult:edit")
	@Log(title = "MBTI类型结果", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestParam Map<String, Object> maps)
	{		
		
		System.out.println(maps);
		ExamMbtiResult examMbtiResult = new ExamMbtiResult();
		examMbtiResult.setId((String) maps.get("id"));
		examMbtiResult.setOptionName((String) maps.get("optionName"));
		examMbtiResult.setOptionCode((String) maps.get("optionCode"));
		examMbtiResult.setOptionContent((String) maps.get("optionContent"));
		return toAjax(examMbtiResultService.updateExamMbtiResult(examMbtiResult ));
//		return toAjax(0);
	}
	
	/**
	 * 删除MBTI类型结果
	 */
	@RequiresPermissions("system:examMbtiResult:remove")
	@Log(title = "MBTI类型结果", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		if (!ids.contains(",")) {
			ExamAdInformation examAdInformation = new ExamAdInformation();
			examAdInformation.setClassificationid(ids);
			List<ExamAdInformation> list = examAdInformationService.selectExamAdInformationList(examAdInformation);
			for (int i = 0; i < list.size(); i++) {
				examAdInformationService.deleteExamAdInformationByIds(ids);
			}
		}
		return toAjax(examMbtiResultService.deleteExamMbtiResultByIds(ids));
	}
	
}
