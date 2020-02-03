package com.ruoyi.project.system.examSubjectCategory.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.examAccountSequence.domain.ExamAccountSequence;
import com.ruoyi.project.system.examAccountSequence.service.IExamAccountSequenceService;
import com.ruoyi.project.system.examEvaluationDimension.domain.ExamEvaluationDimension;
import com.ruoyi.project.system.examEvaluationDimension.service.IExamEvaluationDimensionService;
import com.ruoyi.project.system.examSubjectCategory.domain.ExamSubjectCategory;
import com.ruoyi.project.system.examSubjectCategory.service.IExamSubjectCategoryService;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import com.ruoyi.project.system.examSubjectJudgement.service.IExamSubjectJudgementService;
import com.ruoyi.project.system.examSubjectOptionOption.domain.ExamSubjectOptionOption;
import com.ruoyi.project.system.examSubjectOptionOption.service.IExamSubjectOptionOptionService;
import com.ruoyi.system.domain.SysRole;

/**
 * 题目分类信息操作处理
 * 
 * @author ruoyi
 * @date 2019-08-08
 */
@Controller
@RequestMapping("/system/examSubjectCategory")
public class ExamSubjectCategoryController extends BaseController
{
    private String prefix = "system/examSubjectCategory";
	
	@Autowired
	private IExamSubjectCategoryService examSubjectCategoryService;
	@Autowired
	private IExamAccountSequenceService examAccountSequenceService;
	@Autowired
	private IExamEvaluationDimensionService examEvaluationDimensionService;
	@Autowired
	private IExamSubjectJudgementService examSubjectJudgementService;
	@Autowired
	private IExamSubjectOptionOptionService examSubjectOptionOptionService;
	
	@RequiresPermissions("system:examSubjectCategory:view")
	@GetMapping()
	public String examSubjectCategory()
	{
	    return prefix + "/examSubjectCategory";
	}
	
	/**
	 * 查询题目分类列表
	 */
	@RequiresPermissions("system:examSubjectCategory:list")
	@PostMapping("/list")
	@ResponseBody
	public List<ExamSubjectCategory> list(ExamSubjectCategory examSubjectCategory)
	{
		startPage();
        List<ExamSubjectCategory> list = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
//		return getDataTable(list);
		return list;
	}
	
	
	/**
	 * 导出题目分类列表
	 */
	@RequiresPermissions("system:examSubjectCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamSubjectCategory examSubjectCategory)
    {
    	List<ExamSubjectCategory> list = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory);
        ExcelUtil<ExamSubjectCategory> util = new ExcelUtil<ExamSubjectCategory>(ExamSubjectCategory.class);
        return util.exportExcel(list, "examSubjectCategory");
    }
	
	/**
	 * 新增题目分类
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
	{
		ExamSubjectCategory menu = null;
        if (0L != parentId)
        {
            menu = examSubjectCategoryService.selectMenuById(parentId);
        }
        else
        {
            menu = new ExamSubjectCategory();
            menu.setId("-1");
            menu.setCategoryName("主目录");
        }
        mmap.put("menu", menu);
        return prefix + "/add";
	}
	
	/**
	 * 新增保存题目分类
	 */
	@RequiresPermissions("system:examSubjectCategory:add")
	@Log(title = "题目分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamSubjectCategory examSubjectCategory)
	{		
		
		//以后新增 中添加用户信息
		String str = Stringutil.getLongUID()+"";
		System.out.println(str);
		String json = examSubjectCategory.getApplicationCode();
		JSONArray array = JSONArray.parseArray(json);
		System.out.println(array);
		List<ExamEvaluationDimension> dimensions = new ArrayList<ExamEvaluationDimension>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			ExamEvaluationDimension dimension = new ExamEvaluationDimension();
			dimension.setId(Stringutil.getLongUID()+"");
			dimension.setSubjectChoicesId(str);
			dimension.setOptionName(object.getString("na"));
			dimensions.add(dimension);
		}
		for (ExamEvaluationDimension examEvaluationDimension2 : dimensions) {
			examEvaluationDimensionService.insertExamEvaluationDimension(examEvaluationDimension2);
		}
		examSubjectCategory.setId(str);
		examSubjectCategory.setApplicationCode(null);
		return toAjax(examSubjectCategoryService.insertExamSubjectCategory(examSubjectCategory));
	}

	
	  /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") Long menuId, ModelMap mmap)
    {
        mmap.put("menu", examSubjectCategoryService.selectMenuById(menuId));
        return prefix + "/tree";
    }
    
    
    @Log(title = "维度显示顺序", businessType = BusinessType.INSERT)
	@PostMapping("/selectJumppage/add")
	@ResponseBody
	public AjaxResult addselectJumppageSave(ExamSubjectCategory examSubjectCategory)
	{		
    	String json = examSubjectCategory.getApplicationCode();
    	List<ExamAccountSequence> list = new ArrayList<ExamAccountSequence>();
    	JSONArray array = JSONArray.parseArray(json);
    	
    	//删除之前的排序
    	ExamAccountSequence examAccountSequence = new ExamAccountSequence();
    	examAccountSequence.setCategoryId(array.getJSONObject(0).getString("mid"));
		List<ExamAccountSequence> sass = examAccountSequenceService.selectExamAccountSequenceList(examAccountSequence );
    	StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sass.size(); i++) {
			sb.append( sass.get(i).getId()+",");
		}
    	examAccountSequenceService.deleteExamAccountSequenceByIds(sb.toString());
    	//删除结束
    	for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			ExamAccountSequence examAccountSequence1 = new ExamAccountSequence();
			
			String mid = (String) object.get("mid");
			String id = (String) object.get("id");
			String value = (String) object.get("value");
			examAccountSequence1.setCategoryId(mid);
			examAccountSequence1.setSequenceDesc(value);
			examAccountSequence1.setDimensionId(id);
			examAccountSequence1.setId(Stringutil.getUUID());
			list.add(examAccountSequence1);
		}
    	int row = 0;
    	for (ExamAccountSequence object : list) {
    		row +=examAccountSequenceService.insertExamAccountSequence(object);
		}
//    	System.out.println(json);
		return toAjax(row);
	}
    
    
    
    
    /**
     * 
     * 编辑维度显示顺序
     * @param menuId
     * @param mmap
     * @return
     */
    @GetMapping("/selectJumppage/{menuId}")
    public String selectJumppage(@PathVariable("menuId") Long menuId, ModelMap mmap)
    {	
    	//已排序维度
    	ExamAccountSequence examAccountSequence = new ExamAccountSequence();
    	examAccountSequence.setCategoryId(menuId+"");
		List<ExamAccountSequence> list = examAccountSequenceService.selectExamAccountSequenceList(examAccountSequence );
		//维度
    	ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
		examEvaluationDimension.setSubjectChoicesId(menuId+"");
		List<ExamEvaluationDimension>  la = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension );
		
		
		List<JSONObject> array = new ArrayList<JSONObject>();
		
		for (int i = 0; i < la.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			String id = la.get(i).getId();
			jsonObject.put("id", id);
			jsonObject.put("sid", la.get(i).getSubjectChoicesId());
			jsonObject.put("name", la.get(i).getOptionName());
			
			for (int j = 0; j < list.size(); j++) {
				if (id.equals(list.get(j).getDimensionId())) {
					jsonObject.put("sequence", list.get(j).getSequenceDesc());
					break;
				}
			}
			if (!jsonObject.containsKey("sequence")) {
				jsonObject.put("sequence", "0");
			}
			array.add(jsonObject);
		}
		
		
		Collections.sort(array, new Comparator<JSONObject>() {
			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				return Integer.parseInt(o1.get("sequence").toString()) < Integer.parseInt(o2.get("sequence").toString()) ? -1
						: (Integer.parseInt(o1.get("sequence").toString()) == Integer.parseInt(o2.get("sequence").toString())
								? 0
								: 1);
			}
		});
		
		
		
		
    	mmap.put("examEvaluationDimension", array);
    	return prefix + "/selectJumppage";
    }
  
    
    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Ztree> menuTreeData(SysRole role)
    {
        List<Ztree> ztrees = examSubjectCategoryService.menuTreeData();
        return ztrees;
    }
	
	/**
	 * 修改题目分类
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ExamSubjectCategory examSubjectCategory = examSubjectCategoryService.selectMenuById(id);
		
		
		ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
		examEvaluationDimension.setSubjectChoicesId(examSubjectCategory.getId());
		List<ExamEvaluationDimension>  la = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension );
		
		List<ExamSubjectOptionOption> examSubjectOptionOptions = examSubjectOptionOptionService.selectExamSubjectOptionOptionList(null);
		
		String prohibits = "no";
		Set<String> s1 = new HashSet<String>();//所有id
		Set<String> s2 = new HashSet<String>();//当前分类id
		for (int i = 0; i < examSubjectOptionOptions.size(); i++) {
			ExamSubjectOptionOption option = examSubjectOptionOptions.get(i);
			String opid =  option.getOptionName();
			s1.add(opid);
		}
		// 判断 如果 维度被只用不能修改
		for (int i = 0; i < la.size(); i++) {
			ExamEvaluationDimension evaluationDimension = la.get(i);
			String edid =  evaluationDimension.getId();
			s2.add(edid);
		}
		
		Iterator<String> it = s2.iterator();
		while (it.hasNext()) {
			String type =  it.next();
			if (s1.contains(type)) {
				
				prohibits = "yes";
				break;
			}
		}
		
		
		
		
		mmap.put("examSubjectCategory", examSubjectCategory);
		mmap.put("examEvaluationDimension", la);
		mmap.put("prohibit", prohibits);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存题目分类
	 */
	@RequiresPermissions("system:examSubjectCategory:edit")
	@Log(title = "题目分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamSubjectCategory examSubjectCategory)
	{		
		ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
		examEvaluationDimension.setSubjectChoicesId(examSubjectCategory.getId());
		
		
		
		String examid = examSubjectCategory.getId();
		String json = examSubjectCategory.getApplicationCode();
		if ("".equals(json) || json == null) {
			
		}else {
			List<ExamEvaluationDimension>  la = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension );
			
			for (ExamEvaluationDimension examEvaluationDimension2 : la) {
				examEvaluationDimensionService.deleteExamEvaluationDimensionByIds(examEvaluationDimension2.getId());
			}
			JSONArray array = JSONArray.parseArray(json);
			System.out.println(array);
			List<ExamEvaluationDimension> dimensions = new ArrayList<ExamEvaluationDimension>();
			
			for (int i = 0; i < array.size(); i++) {
				JSONObject object = array.getJSONObject(i);
				if (object.containsKey("na") && !"".equals(object.getString("na"))) {
					ExamEvaluationDimension dimension = new ExamEvaluationDimension();
					dimension.setId(Stringutil.getLongUID()+"");
					dimension.setSubjectChoicesId(examid);
					dimension.setOptionName(object.getString("na"));
					dimensions.add(dimension);
				}
			}
			for (ExamEvaluationDimension examEvaluationDimension2 : dimensions) {
				examEvaluationDimensionService.insertExamEvaluationDimension(examEvaluationDimension2);
			}
		}
		
		
		examSubjectCategory.setApplicationCode(null);
		
		
		return toAjax(examSubjectCategoryService.updateExamSubjectCategory(examSubjectCategory));
	}
	
	/**
	 * 删除题目分类
	 */
	@RequiresPermissions("system:examSubjectCategory:remove")
	@Log(title = "题目分类", businessType = BusinessType.DELETE)
	@GetMapping( "/remove/{ids}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("ids")String ids)
	{		
		
		
		
		ExamSubjectCategory examSubjectCategory = new ExamSubjectCategory();
		examSubjectCategory.setParentId(ids);
		List<ExamSubjectCategory> lk = examSubjectCategoryService.selectExamSubjectCategoryList(examSubjectCategory );
		if (lk.size() > 0) {
			return error("请先删除子分类");
		}
		
		ExamSubjectJudgement examSubjectJudgement = new ExamSubjectJudgement();
		examSubjectJudgement.setCategoryId(ids);
		StringBuffer buffer = new StringBuffer();
		List<ExamSubjectJudgement> list = examSubjectJudgementService.selectExamSubjectJudgementList(examSubjectJudgement);
		for (ExamSubjectJudgement examSubjectJudgement2 : list) {
			buffer.append(examSubjectJudgement2.getId()+",");
		}
		examSubjectJudgementService.deleteExamSubjectJudgementByIds(buffer.toString());
		
		return toAjax(examSubjectCategoryService.deleteExamSubjectCategoryByIds(ids));
	}
	
}
