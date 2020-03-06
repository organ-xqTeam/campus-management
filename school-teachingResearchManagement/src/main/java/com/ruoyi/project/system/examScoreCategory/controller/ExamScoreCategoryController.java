package com.ruoyi.project.system.examScoreCategory.controller;

import java.util.List;

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
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.examScoreCategory.domain.ExamScoreCategory;
import com.ruoyi.project.system.examScoreCategory.service.IExamScoreCategoryService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;

/**
 * 测评分类信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
@Controller
@RequestMapping("/system/examScoreCategory")
public class ExamScoreCategoryController extends BaseController
{
    private String prefix = "system/examScoreCategory";
	
	@Autowired
	private IExamScoreCategoryService examScoreCategoryService;
	@Autowired
	private IExamSubjectShortAnswerService examSubjectShortAnswerService;
	@RequiresPermissions("system:examScoreCategory:view")
	@GetMapping()
	public String examScoreCategory()
	{
	    return prefix + "/examScoreCategory";
	}
	
	/**
	 * 查询测评分类列表
	 */
	@RequiresPermissions("system:examScoreCategory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamScoreCategory examScoreCategory)
	{
		startPage();
        List<ExamScoreCategory> list = examScoreCategoryService.selectExamScoreCategoryList(examScoreCategory);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出测评分类列表
	 */
	@RequiresPermissions("system:examScoreCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamScoreCategory examScoreCategory)
    {
    	List<ExamScoreCategory> list = examScoreCategoryService.selectExamScoreCategoryList(examScoreCategory);
        ExcelUtil<ExamScoreCategory> util = new ExcelUtil<ExamScoreCategory>(ExamScoreCategory.class);
        return util.exportExcel(list, "examScoreCategory");
    }
	
	/**
	 * 新增测评分类
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存测评分类
	 */
	@RequiresPermissions("system:examScoreCategory:add")
	@Log(title = "测评分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamScoreCategory examScoreCategory)
	{		
		String str = Stringutil.getLongUID()+"";
		examScoreCategory.setId(str);
		return toAjax(examScoreCategoryService.insertExamScoreCategory(examScoreCategory));
	}

	/**
	 * 修改测评分类
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamScoreCategory examScoreCategory = examScoreCategoryService.selectExamScoreCategoryById(id);
		mmap.put("examScoreCategory", examScoreCategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存测评分类
	 */
	@RequiresPermissions("system:examScoreCategory:edit")
	@Log(title = "测评分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamScoreCategory examScoreCategory)
	{		
		return toAjax(examScoreCategoryService.updateExamScoreCategory(examScoreCategory));
	}
	
	/**
	 * 删除测评分类
	 */
	@RequiresPermissions("system:examScoreCategory:remove")
	@Log(title = "测评分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		
		ExamSubjectShortAnswer examSubjectShortAnswer = new ExamSubjectShortAnswer();
		examSubjectShortAnswer.setAnalysis(ids);
		List<ExamSubjectShortAnswer> list = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(examSubjectShortAnswer );
		for (ExamSubjectShortAnswer examSubjectShortAnswer2 : list) {
			examSubjectShortAnswerService.deleteExamSubjectShortAnswerByIds(examSubjectShortAnswer2.getId());
		}
		
		return toAjax(examScoreCategoryService.deleteExamScoreCategoryByIds(ids));
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
	
}
