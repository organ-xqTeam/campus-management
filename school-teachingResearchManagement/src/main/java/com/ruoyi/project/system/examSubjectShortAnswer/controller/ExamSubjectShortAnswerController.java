package com.ruoyi.project.system.examSubjectShortAnswer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.examAdInformation.domain.ExamAdInformation;
import com.ruoyi.project.system.examAdInformation.service.IExamAdInformationService;
import com.ruoyi.project.system.examExaminationSubject.domain.ExamExaminationSubject;
import com.ruoyi.project.system.examExaminationSubject.service.IExamExaminationSubjectService;
import com.ruoyi.project.system.examOrdinaryResult.domain.ExamOrdinaryResult;
import com.ruoyi.project.system.examOrdinaryResult.service.IExamOrdinaryResultService;
import com.ruoyi.project.system.examScoreCategory.domain.ExamScoreCategory;
import com.ruoyi.project.system.examScoreCategory.service.IExamScoreCategoryService;
import com.ruoyi.project.system.examSubjectCategory.domain.ExamSubjectCategory;
import com.ruoyi.project.system.examSubjectCategory.service.IExamSubjectCategoryService;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import com.ruoyi.project.system.examSubjectJudgement.service.IExamSubjectJudgementService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;
import com.ruoyi.system.domain.SysRole;

/**
 * 简答题信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
@Controller
@RequestMapping("/system/examSubjectShortAnswer")
public class ExamSubjectShortAnswerController extends BaseController
{
    private String prefix = "system/examSubjectShortAnswer";
	
    @Autowired
	private IExamAdInformationService examAdInformationService;
    @Autowired
	private IExamOrdinaryResultService examOrdinaryResultService;
    @Autowired
	private IExamScoreCategoryService examScoreCategoryService;
    @Autowired
	private IExamSubjectCategoryService examSubjectCategoryService;
	@Autowired
	private IExamSubjectShortAnswerService examSubjectShortAnswerService;
	
	@Autowired
	private IExamExaminationSubjectService examExaminationSubjectService;
	
	@Autowired
	private IExamSubjectJudgementService examSubjectJudgementService;
	@Autowired
	private ICoursemanagementService coursemanagementService;
	
	@RequiresPermissions("system:examSubjectShortAnswer:view")
	@GetMapping()
	public String examSubjectShortAnswer(ModelMap mmap)
	{
		
		
		List<ExamSubjectCategory> la = examSubjectCategoryService.selectMenuAll();
		List<ExamSubjectCategory> categories = new ArrayList<ExamSubjectCategory>();
		for (int i = 0; i < la.size(); i++) {
			ExamSubjectCategory ca = la.get(i);
			if ("1".equals(ca.getId())) {
				continue;
			}else if("-1".equals(ca.getParentId())) {
				categories.add(ca);
			}
//			categories
		}
		List<ExamScoreCategory> es = examScoreCategoryService.selectExamScoreCategoryList(null);
		mmap.put("es", es);
		mmap.put("categories", categories);
	    return prefix + "/examSubjectShortAnswer";
	}
	
	/**
	 * 以下接口是为校园系统增加的
	 * ↓
	 * ↓
	 * ↓
	 * ↓
	 * ↓
	 * ↓
	 * ↓
	 * ↓
	 * */	
	@RequiresPermissions("system:examSubjectShortAnswer:view")
	@GetMapping("/schooltestpaper")
	public String schooltestpaper(ModelMap mmap)
	{
		List<ExamSubjectCategory> la = examSubjectCategoryService.selectMenuAll();
		List<ExamSubjectCategory> categories = new ArrayList<ExamSubjectCategory>();
		for (int i = 0; i < la.size(); i++) {
			ExamSubjectCategory ca = la.get(i);
			if ("1".equals(ca.getId())) {
				continue;
			}else if("-1".equals(ca.getParentId())) {
				categories.add(ca);
			}
//			categories
		}
		List<ExamScoreCategory> es = examScoreCategoryService.selectExamScoreCategoryList(null);
		mmap.put("es", es);
		mmap.put("categories", categories);

		Coursemanagement c = new Coursemanagement();
		List<Coursemanagement> clist = coursemanagementService.selectCoursemanagementList(c);
		mmap.put("clist", clist);
	    return "system/schooltestpaper/schooltestpaper";
	}
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String id, ModelMap mmap)
	{
		List<ExamSubjectCategory> la = examSubjectCategoryService.selectMenuAll();
		List<ExamSubjectCategory> categories = new ArrayList<ExamSubjectCategory>();
		for (int i = 0; i < la.size(); i++) {
			ExamSubjectCategory ca = la.get(i);
			if ("1".equals(ca.getId())) {
				continue;
			}else if("-1".equals(ca.getParentId())) {
				categories.add(ca);
			}
//			categories
		}
		List<ExamScoreCategory> es = examScoreCategoryService.selectExamScoreCategoryList(null);
		mmap.put("es", es);
		mmap.put("categories", categories);

		Coursemanagement c = new Coursemanagement();
		List<Coursemanagement> clist = coursemanagementService.selectCoursemanagementList(c);
		mmap.put("clist", clist);
	    return "system/schooltestpaper/add";
	}
	@GetMapping("/selectMenuTree")
	public String tree(ModelMap mmap)
	{
//		mmap.put("menu", examSubjectCategoryService.selectMenuById(menuId));
	    return "system/schooltestpaper/tree";
	}
	/**
	 * ↑
	 * ↑
	 * ↑
	 * ↑
	 * ↑
	 * ↑
	 * ↑
	 * ↑
	 * 以上接口是为校园系统增加的
	 * */
	
	/**
	 * 查询简答题列表
	 */
	@RequiresPermissions("system:examSubjectShortAnswer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamSubjectShortAnswer examSubjectShortAnswer)
	{
		startPage();
        List<ExamSubjectShortAnswer> list = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(examSubjectShortAnswer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出简答题列表
	 */
	@RequiresPermissions("system:examSubjectShortAnswer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamSubjectShortAnswer examSubjectShortAnswer)
    {
    	List<ExamSubjectShortAnswer> list = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(examSubjectShortAnswer);
        ExcelUtil<ExamSubjectShortAnswer> util = new ExcelUtil<ExamSubjectShortAnswer>(ExamSubjectShortAnswer.class);
        return util.exportExcel(list, "examSubjectShortAnswer");
    }
	
	/**
	 * 新增简答题
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		List<ExamSubjectCategory> la = examSubjectCategoryService.selectMenuAll();
		List<ExamSubjectCategory> categories = new ArrayList<ExamSubjectCategory>();
		for (int i = 0; i < la.size(); i++) {
			ExamSubjectCategory ca = la.get(i);
			if ("1".equals(ca.getId())) {
				continue;
			}else if("-1".equals(ca.getParentId())) {
				categories.add(ca);
			}
//			categories
		}
		List<ExamScoreCategory> es = examScoreCategoryService.selectExamScoreCategoryList(null);
		mmap.put("es", es);
		mmap.put("categories", categories);
	    return prefix + "/add";
	}
	
	@GetMapping("/selectMenuTree/{menuId}")
	public String tree(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		
		mmap.put("menu", examSubjectCategoryService.selectMenuById(menuId));
	    return prefix + "/tree";
	}
	@GetMapping("/topnote/{menuId}")
	public String topnote(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		
		mmap.put("menu", examSubjectShortAnswerService.selectExamSubjectShortAnswerById(menuId+""));
		return prefix + "/topnote";
	}
	
	/**
	 * 新增保存简答题
	 */
	@RequiresPermissions("system:examSubjectShortAnswer:add")
	@Log(title = "简答题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamSubjectShortAnswer examSubjectShortAnswer)
	{		
		String json =  examSubjectShortAnswer.getApplicationCode();
		examSubjectShortAnswer.setApplicationCode(null);
		examSubjectShortAnswer.setModifier("0");
		String id = Stringutil.getLongUID()+"";;
		examSubjectShortAnswer.setId(id);
		examSubjectShortAnswer.setDelFlag(1);
		JSONArray array = JSONArray.parseArray(json);
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			ExamExaminationSubject examExaminationSubject = new ExamExaminationSubject();
			examExaminationSubject.setId(Stringutil.getLongUID()+"");
			examExaminationSubject.setExaminationId(id);
			examExaminationSubject.setSubjectId(object.getString("ssa1"));
			if (object.containsKey("tenantCode")) {
				examExaminationSubject.setTenantCode(object.getString("tenantCode"));
			}
			examExaminationSubjectService.insertExamExaminationSubject(examExaminationSubject);
		}
		return toAjax(examSubjectShortAnswerService.insertExamSubjectShortAnswer(examSubjectShortAnswer));
	}

	
	@GetMapping("/menuTreeData/{parentId}")
    @ResponseBody
    public List<Ztree> menuTreeData(@PathVariable("parentId")String parentId ,SysRole role)
    {
        List<Ztree> ztrees = examSubjectCategoryService.menuTreeData1(parentId);
        return ztrees;
    }
	
	/**
	 * 修改简答题
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{	
		List<ExamSubjectCategory> la = examSubjectCategoryService.selectMenuAll();
		List<ExamSubjectCategory> categories = new ArrayList<ExamSubjectCategory>();
		for (int i = 0; i < la.size(); i++) {
			ExamSubjectCategory ca = la.get(i);
			if ("1".equals(ca.getId())) {
				continue;
			}else if("-1".equals(ca.getParentId())) {
				categories.add(ca);
			}
//			categories
		}
		List<ExamScoreCategory> es = examScoreCategoryService.selectExamScoreCategoryList(null);
		mmap.put("es", es);
		mmap.put("categories", categories);
		
		
		ExamExaminationSubject examExaminationSubject = new ExamExaminationSubject();
		examExaminationSubject.setExaminationId(id);
		List<ExamExaminationSubject> la1 = examExaminationSubjectService.selectExamExaminationSubjectList(examExaminationSubject );
		
//		String numdata = "0";
//		System.out.println(numdata);
		//如果是mbti 分分类
		JSONArray array = new JSONArray();
//		if ("0".equals(numdata)) {
			Map<String, List<JSONObject>> map = new HashMap<String, List<JSONObject>>();
			for (int i = 0; i < la1.size(); i++) {
				ExamExaminationSubject e = la1.get(i);
				ExamSubjectJudgement ex = examSubjectJudgementService.selectExamSubjectJudgementById(e.getSubjectId());
				if (ex == null) {
					continue;
				}
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", e.getId());
				jsonObject.put("exid", ex.getId());
				jsonObject.put("exnum", ex.getSerialNumber());
				jsonObject.put("exname", ex.getSubjectName());
				jsonObject.put("tenantCode", e.getTenantCode());
				if (map.containsKey(e.getTenantCode())) {
					List<JSONObject> la11 = map.get(e.getTenantCode());
					la11.add(jsonObject);
				}else {
					List<JSONObject> la11 = new ArrayList<JSONObject>();
					la11.add(jsonObject);
					map.put(e.getTenantCode(), la11);
				}
//				array.add(jsonObject);
			}
//			System.out.println(map.size());
			for(Entry<String, List<JSONObject>> entry : map.entrySet()){
			     array.add(entry.getValue());
			}
//			System.out.println(array.toJSONString());
//		}else {
//			for (int i = 0; i < la1.size(); i++) {
//				ExamExaminationSubject e = la1.get(i);
//				ExamSubjectJudgement ex = examSubjectJudgementService.selectExamSubjectJudgementById(e.getSubjectId());
//				if (ex == null) {
//					continue;
//				}
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("id", e.getId());
//				jsonObject.put("exid", ex.getId());
//				jsonObject.put("exnum", ex.getSerialNumber());
//				jsonObject.put("exname", ex.getSubjectName());
//				array.add(jsonObject);
//			}
//		}
//		System.out.println(array.toJSONString());
		ExamSubjectShortAnswer examSubjectShortAnswer = examSubjectShortAnswerService.selectExamSubjectShortAnswerById(id);
		mmap.put("examSubjectShortAnswer", examSubjectShortAnswer);
		mmap.put("ExamExaminationSubject", array);

		Coursemanagement c = new Coursemanagement();
		List<Coursemanagement> clist = coursemanagementService.selectCoursemanagementList(c);
		mmap.put("clist", clist);
		if (examSubjectShortAnswer.getCategoryId().equals("-1")) {
			return "system/schooltestpaper/edit";
		}
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存简答题
	 */
	@RequiresPermissions("system:examSubjectShortAnswer:edit")
	@Log(title = "简答题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamSubjectShortAnswer examSubjectShortAnswer)
	{		
		String id = examSubjectShortAnswer.getId();
		//删除原有记录
		ExamExaminationSubject exam = new ExamExaminationSubject();
		exam.setExaminationId(id);
		List<ExamExaminationSubject> la = examExaminationSubjectService.selectExamExaminationSubjectList(exam);
		
		for (ExamExaminationSubject examExaminationSubject : la) {
			examExaminationSubjectService.deleteExamExaminationSubjectByIds(examExaminationSubject.getId());
		}
		
		
		
		String json =  examSubjectShortAnswer.getApplicationCode();
		examSubjectShortAnswer.setApplicationCode(null);
		JSONArray array = JSONArray.parseArray(json);
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			ExamExaminationSubject examExaminationSubject = new ExamExaminationSubject();
			examExaminationSubject.setId(Stringutil.getLongUID()+"");
			examExaminationSubject.setExaminationId(id);
			examExaminationSubject.setSubjectId(object.getString("ssa1"));
			if (object.containsKey("tenantCode")) {
				examExaminationSubject.setTenantCode(object.getString("tenantCode"));
			}
			examExaminationSubjectService.insertExamExaminationSubject(examExaminationSubject);
		}
		return toAjax(examSubjectShortAnswerService.updateExamSubjectShortAnswer(examSubjectShortAnswer));
	}
	
	/**
	 * 删除简答题
	 */
	@RequiresPermissions("system:examSubjectShortAnswer:remove")
	@Log(title = "简答题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		if (!ids.contains(",")) {
			ExamOrdinaryResult examOrdinaryResult = new ExamOrdinaryResult();
			examOrdinaryResult.setOptionName(ids);
			List<ExamOrdinaryResult> ls =  examOrdinaryResultService.selectExamOrdinaryResultList(examOrdinaryResult );
			for (int i = 0; i < ls.size(); i++) {
				
				ExamAdInformation examAdInformation = new ExamAdInformation();
				examAdInformation.setClassificationid(ls.get(i).getId());
				List<ExamAdInformation> la = examAdInformationService.selectExamAdInformationList(examAdInformation );
				for (int j = 0; j < la.size(); j++) {
					examAdInformationService.deleteExamAdInformationByIds(la.get(j).getId()+"");
				}
				examOrdinaryResultService.deleteExamOrdinaryResultByIds(ls.get(i).getId());
			}
		}
		return toAjax(examSubjectShortAnswerService.deleteExamSubjectShortAnswerByIds(ids));
	}
	
	
	@Log(title = "试卷状态管理", businessType = BusinessType.OTHER)
    @RequiresPermissions("system:examSubjectShortAnswer:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(ExamSubjectShortAnswer examSubjectShortAnswer)
    {	
        return toAjax(examSubjectShortAnswerService.changeStatus(examSubjectShortAnswer));
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
