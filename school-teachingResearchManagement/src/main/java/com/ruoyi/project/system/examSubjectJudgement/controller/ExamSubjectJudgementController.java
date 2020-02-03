package com.ruoyi.project.system.examSubjectJudgement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.poi.ExcelUtil2;
import com.ruoyi.project.system.examEvaluationDimension.domain.ExamEvaluationDimension;
import com.ruoyi.project.system.examEvaluationDimension.service.IExamEvaluationDimensionService;
import com.ruoyi.project.system.examSubjectCategory.domain.ExamSubjectCategory;
import com.ruoyi.project.system.examSubjectCategory.service.IExamSubjectCategoryService;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import com.ruoyi.project.system.examSubjectJudgement.domain.inputxlsxresut;
import com.ruoyi.project.system.examSubjectJudgement.service.IExamSubjectJudgementService;
import com.ruoyi.project.system.examSubjectOption.domain.ExamSubjectOption;
import com.ruoyi.project.system.examSubjectOption.service.IExamSubjectOptionService;
import com.ruoyi.project.system.examSubjectOptionOption.domain.ExamSubjectOptionOption;
import com.ruoyi.project.system.examSubjectOptionOption.service.IExamSubjectOptionOptionService;

/**
 *    测评试题
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Controller
@RequestMapping("/system/examSubjectJudgement")
public class ExamSubjectJudgementController extends BaseController
{
    private String prefix = "system/examSubjectJudgement";
	
	@Autowired
	private IExamSubjectJudgementService examSubjectJudgementService;
	@Autowired
	private IExamEvaluationDimensionService examEvaluationDimensionService;
	
	@Autowired
	private IExamSubjectOptionService examSubjectOptionService;
	@Autowired
	private IExamSubjectOptionOptionService examSubjectOptionOptionService;
	
	@Autowired
	private IExamSubjectCategoryService examSubjectCategoryService;
	
	@RequiresPermissions("system:examSubjectJudgement:view")
	@GetMapping()
	public String examSubjectJudgement()
	{
	    return prefix + "/examSubjectJudgement";
	}
	
	/**
	 * 查询简答题列表
	 */
	@RequiresPermissions("system:examSubjectJudgement:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamSubjectJudgement examSubjectJudgement)
	{
		startPage();
        List<ExamSubjectJudgement> list = examSubjectJudgementService.selectExamSubjectJudgementList(examSubjectJudgement);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出简答题列表
	 */
	@RequiresPermissions("system:examSubjectJudgement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamSubjectJudgement examSubjectJudgement)
    {
    	List<ExamSubjectJudgement> list = examSubjectJudgementService.selectExamSubjectJudgementList(examSubjectJudgement);
        ExcelUtil2<ExamSubjectJudgement> util = new ExcelUtil2<ExamSubjectJudgement>(ExamSubjectJudgement.class);
        return util.exportExcel(list, "examSubjectJudgement");
    }
	
	
	
	/**
	 * 富文本框
	 */
	
	@GetMapping("/summernote")
	public String summernote() {
		return prefix + "/summernote";
	}
	/**
	 * 富文本框
	 */
	
	@GetMapping("/importExcel/{id}")
	public String importExcel(@PathVariable("id") String id,ModelMap mmap) {
		mmap.put("excelid", id+"");
		return prefix + "/importExcel";
	}
	
	/**
	 * 新增简答题
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String id,ModelMap mmap)
	{	
		
		ExamSubjectCategory examnew = examSubjectCategoryService.selectExamSubjectCategoryById(id);
		
		ExamSubjectCategory exam = null;
		String str = id;
		do {
			exam = examSubjectCategoryService.selectExamSubjectCategoryById(str);
			str = exam.getParentId();
			
		}while(!"-1".equals(exam.getParentId()));
		examnew.setType(exam.getType());
		//id 为分类id（试卷题目id）	
		
		
		ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
		examEvaluationDimension.setSubjectChoicesId(exam.getId());
		List<ExamEvaluationDimension>  la = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension );
		//根据父类id 查询维度
		mmap.put("dimension", la);
		mmap.put("exam", examnew);
	    return prefix + "/add";
	}
	
	
	
	
	
	/**
	 * 新增保存简答题
	 */
	@RequiresPermissions("system:examSubjectJudgement:add")
	@Log(title = "简答题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamSubjectJudgement examSubjectJudgement)
	{		
		String str = Stringutil.getLongUID()+"";
//		System.out.println(str);
		examSubjectJudgement.setId(str);
		return toAjax(examSubjectJudgementService.insertExamSubjectJudgement(examSubjectJudgement));
	}
	
	
	@RequiresPermissions("system:examSubjectJudgement:add")
	@Log(title = "简答题", businessType = BusinessType.INSERT)
	@PostMapping("/add/{id}")
	@ResponseBody
	public AjaxResult addSave(@PathVariable("id") String id , ExamSubjectJudgement examSubjectJudgement)
	{		
		
//		[{"na":"选项a","ne":"选项","next":[{"name1":"子类a","name2":"子类"}]},{"na":"","ne":"","next":[]}]
//		[{"next":[{"name2":"子类","name1":"子类a"}],"na":"选项a","ne":"选项"},{"next":[],"na":"","ne":""}]
		String json =  examSubjectJudgement.getApplicationCode();
//		System.out.println(json);
		JSONArray jo  = JSONArray.parseArray(json);
//		System.out.println(jo);
		String str = Stringutil.getLongUID()+"";
//		System.out.println(str);
		
		List<ExamSubjectOption> examSubjectOptionList = new ArrayList<>();
		
		List<ExamSubjectOptionOption> subjectOptionOptions = new ArrayList<>();
		
		
		for (int i = 0; i < jo.size(); i++) {
			
			JSONObject jsonObject = jo.getJSONObject(i);
			String ss = jsonObject.getString("na");//选项a
			String nn = jsonObject.getString("ne");//选项对应的信息
			String gg = jsonObject.getString("nr");//选项对应的信息
			String ssid = Stringutil.getLongUID()+"";
			if (!"".equals(ss)&& !"".equals(nn)) {
				ExamSubjectOption subjectOption = new ExamSubjectOption();
				subjectOption.setId(ssid);
				subjectOption.setSubjectChoicesId(str);
				subjectOption.setOptionName(ss);
				subjectOption.setOptionContent(nn);
				subjectOption.setCreator(gg);
				examSubjectOptionList.add(subjectOption);
			}
			JSONArray array = jsonObject.getJSONArray("next");
			for (int j = 0; j < array.size(); j++) {
				JSONObject object = array.getJSONObject(j);
				String dd =  object.getString("name1");//子类a
				String ff = object.getString("name2");//子类 分数
				if (!"".equals(dd)&& !"".equals(ff)) {
					ExamSubjectOptionOption optionOption = new ExamSubjectOptionOption();
					optionOption.setId(Stringutil.getLongUID()+"");
					optionOption.setSubjectChoicesId(ssid);
					optionOption.setOptionName(dd);
					optionOption.setOptionContent(ff);
					subjectOptionOptions.add(optionOption);
				}
			}
		}
		examSubjectJudgement.setApplicationCode(null);
		examSubjectJudgement.setId(str);
		int row = 0;
		for (ExamSubjectOptionOption examSubjectOptionOption : subjectOptionOptions) {
			row +=examSubjectOptionOptionService.insertExamSubjectOptionOption(examSubjectOptionOption);
		}
		for (ExamSubjectOption examSubjectOption2 : examSubjectOptionList) {
			row +=examSubjectOptionService.insertExamSubjectOption(examSubjectOption2);
		}
		row +=examSubjectJudgementService.insertExamSubjectJudgement(examSubjectJudgement);
		return toAjax(row);
	}

	/**
	 * 修改简答题
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ExamSubjectJudgement examSubjectJudgement = examSubjectJudgementService.selectExamSubjectJudgementById(id);
		
		
		ExamSubjectOption oprion = new ExamSubjectOption();
		oprion.setSubjectChoicesId(id);
		List<ExamSubjectOption> list =  examSubjectOptionService.selectExamSubjectOptionList(oprion);
		
		JSONArray array = new JSONArray();
		
		for (ExamSubjectOption examSubjectOption : list) {
			JSONObject object = new JSONObject();
			object.put("name", examSubjectOption.getOptionName());
			object.put("content", examSubjectOption.getOptionContent());
			object.put("creator", examSubjectOption.getCreator());
			
			ExamSubjectOptionOption optiono = new ExamSubjectOptionOption();
			optiono.setSubjectChoicesId(examSubjectOption.getId());
			List<ExamSubjectOptionOption> optionOptions =  examSubjectOptionOptionService.selectExamSubjectOptionOptionList(optiono);
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < optionOptions.size(); i++) {
				jsonArray.add(optionOptions.get(i));
			}
			object.put("next", jsonArray);
			array.add(object);
		}
		mmap.put("array", array);
//		examSubjectJudgement.setApplicationCode(array.toString());
		mmap.put("examSubjectJudgement", examSubjectJudgement);
		
		//获取分类
		ExamSubjectCategory examnew = examSubjectCategoryService.selectExamSubjectCategoryById(examSubjectJudgement.getCategoryId());
		
		ExamSubjectCategory exam = null;
		String str = examSubjectJudgement.getCategoryId();
		do {
			exam = examSubjectCategoryService.selectExamSubjectCategoryById(str);
			str = exam.getParentId();
		}while(!"-1".equals(exam.getParentId()));
		examnew.setType(exam.getType());
		
		//获取分类
		List<ExamSubjectCategory> examall = examSubjectCategoryService.selectMenuAll();
		
		ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
		examEvaluationDimension.setSubjectChoicesId(exam.getId());
		List<ExamEvaluationDimension>  la = examEvaluationDimensionService.selectExamEvaluationDimensionList(examEvaluationDimension );
		
		
		//根据父类id 查询维度
		
		
		mmap.put("dimension", la);
		mmap.put("exam", examnew);
		mmap.put("examall", examall);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存简答题
	 */
	@RequiresPermissions("system:examSubjectJudgement:edit")
	@Log(title = "简答题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamSubjectJudgement examSubjectJudgement)
	{		
		
		//删除原有选项
		ExamSubjectOption oprion = new ExamSubjectOption();
		oprion.setSubjectChoicesId(examSubjectJudgement.getId());
		List<ExamSubjectOption> list =  examSubjectOptionService.selectExamSubjectOptionList(oprion);
		
		StringBuffer sb1 = new StringBuffer();
		for (ExamSubjectOption examSubjectOption : list) {
			sb1.append(examSubjectOption.getId()+",");
			ExamSubjectOptionOption optiono = new ExamSubjectOptionOption();
			optiono.setSubjectChoicesId(examSubjectOption.getId());
			List<ExamSubjectOptionOption> optionOptions =  examSubjectOptionOptionService.selectExamSubjectOptionOptionList(optiono);
			StringBuffer sb = new StringBuffer();
			for (ExamSubjectOptionOption examSubjectOption2 : optionOptions) {
				sb.append(examSubjectOption2.getId()+",");
			}
			examSubjectOptionOptionService.deleteExamSubjectOptionOptionByIds(sb.toString());
		}
		int a =examSubjectOptionService.deleteExamSubjectOptionByIds(sb1.toString());
		
		
		//删除结束
		String json =  examSubjectJudgement.getApplicationCode();
//		System.out.println(json);
		JSONArray jo  = JSONArray.parseArray(json);
//		System.out.println(jo);
		String str = examSubjectJudgement.getId();
		List<ExamSubjectOption> examSubjectOptionList = new ArrayList<>();
		List<ExamSubjectOptionOption> subjectOptionOptions = new ArrayList<>();
		for (int i = 0; i < jo.size(); i++) {
			JSONObject jsonObject = jo.getJSONObject(i);
			String ss = jsonObject.getString("na");//选项a
			String nn = jsonObject.getString("ne");//选项对应的信息
			String gg = jsonObject.getString("nr");//参考
//			System.out.println(ss+"\t"+nn);
			String ssid = Stringutil.getLongUID()+"";
			if (ss != null && !"".equals(ss)) {
				ExamSubjectOption subjectOption = new ExamSubjectOption();
				subjectOption.setId(ssid);
				subjectOption.setSubjectChoicesId(str);
				subjectOption.setOptionName(ss);
				subjectOption.setOptionContent(nn);
				subjectOption.setCreator(gg);
				examSubjectOptionList.add(subjectOption);
			}
			JSONArray array = jsonObject.getJSONArray("next");
			for (int j = 0; j < array.size(); j++) {
				JSONObject object = array.getJSONObject(j);
				String dd =  object.getString("name1");//子类a
				String ff = object.getString("name2");//子类 分数
				if (!"".equals(dd)&& !"".equals(ff)) {
					ExamSubjectOptionOption optionOption = new ExamSubjectOptionOption();
					optionOption.setId(Stringutil.getLongUID()+"");
					optionOption.setSubjectChoicesId(ssid);
					optionOption.setOptionName(dd);
					optionOption.setOptionContent(ff);
					subjectOptionOptions.add(optionOption);
				}
			}
		}
		examSubjectJudgement.setApplicationCode(null);
		examSubjectJudgement.setId(str);
		int row = 0;
		for (ExamSubjectOptionOption examSubjectOptionOption : subjectOptionOptions) {
			row +=examSubjectOptionOptionService.insertExamSubjectOptionOption(examSubjectOptionOption);
		}
		for (ExamSubjectOption examSubjectOption2 : examSubjectOptionList) {
			row +=examSubjectOptionService.insertExamSubjectOption(examSubjectOption2);
		}
		row +=examSubjectJudgementService.updateExamSubjectJudgement(examSubjectJudgement);
		
		return toAjax(row);
	}
	
	/**
	 * 删除简答题
	 */
	@RequiresPermissions("system:examSubjectJudgement:remove")
	@Log(title = "简答题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		if (ids.contains(",")) {
			String[] str = ids.split(",");
			for (String string : str) {
				ExamSubjectOption examSubjectOption = new ExamSubjectOption();
				examSubjectOption.setSubjectChoicesId(string);
				List<ExamSubjectOption> list = examSubjectOptionService.selectExamSubjectOptionList(examSubjectOption );
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					String id = list.get(i).getId();
					buffer.append(id+",");
					ExamSubjectOptionOption examSubjectOptionOption = new ExamSubjectOptionOption();
					examSubjectOptionOption.setSubjectChoicesId(id);
					List<ExamSubjectOptionOption> la = examSubjectOptionOptionService.selectExamSubjectOptionOptionList(examSubjectOptionOption );
					StringBuffer buffer1 = new StringBuffer();
					for (ExamSubjectOptionOption examSubjectOptionOption2 : la) {
						buffer1.append(examSubjectOptionOption2.getId()+",");
					}
					examSubjectOptionOptionService.deleteExamSubjectOptionOptionByIds(buffer1.toString());
				}
				examSubjectOptionService.deleteExamSubjectOptionByIds(buffer.toString());
			}
		}else {
			ExamSubjectOption examSubjectOption = new ExamSubjectOption();
			examSubjectOption.setSubjectChoicesId(ids);
			StringBuffer buffer = new StringBuffer();
			List<ExamSubjectOption> list = examSubjectOptionService.selectExamSubjectOptionList(examSubjectOption );
			for (int i = 0; i < list.size(); i++) {
				String id = list.get(i).getId();
				buffer.append(id+",");
				ExamSubjectOptionOption examSubjectOptionOption = new ExamSubjectOptionOption();
				examSubjectOptionOption.setSubjectChoicesId(id);
				List<ExamSubjectOptionOption> la = examSubjectOptionOptionService.selectExamSubjectOptionOptionList(examSubjectOptionOption );
				StringBuffer buffer1 = new StringBuffer();
				for (ExamSubjectOptionOption examSubjectOptionOption2 : la) {
					buffer1.append(examSubjectOptionOption2.getId()+",");
				}
				examSubjectOptionOptionService.deleteExamSubjectOptionOptionByIds(buffer1.toString());
			}
			examSubjectOptionService.deleteExamSubjectOptionByIds(buffer.toString());
		}
		
		return toAjax(examSubjectJudgementService.deleteExamSubjectJudgementByIds(ids));
	}
	/**
	 * 删除简答题
	 */
	@Log(title = "简答题导入", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:examSubjectJudgement:import")
    @PostMapping("/import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport,String padtid) throws Exception
    {	
		
		System.out.println("分类id："+padtid);
		ExamSubjectCategory exam = null;
		String str = padtid;
		do {
			exam = examSubjectCategoryService.selectExamSubjectCategoryById(str);
			str = exam.getParentId();
		}while(!"-1".equals(exam.getParentId()));
		String subjectChoicesId =  exam.getId();
		
		ExamEvaluationDimension examEvaluationDimension = new ExamEvaluationDimension();
		examEvaluationDimension.setSubjectChoicesId(subjectChoicesId);
		List<ExamEvaluationDimension> lieeds = examEvaluationDimensionService
				.selectExamEvaluationDimensionList(examEvaluationDimension);
		List<String> listtitle = new ArrayList<>();
		String istype = "";
		for (int i = 0; i < lieeds.size(); i++) {
			String sk = lieeds.get(i).getOptionName();
			if ("".equals(sk) || sk == null) {
			}else {
				listtitle.add(sk.toUpperCase());
			}
		}
		
		int titlenum= listtitle.size();
//		System.out.println("titlenum:"+titlenum);
        ExcelUtil2<ExamSubjectJudgement> util = new ExcelUtil2<ExamSubjectJudgement>(ExamSubjectJudgement.class);
        inputxlsxresut inxlsx = util.importExcelnew(file.getInputStream());
        // 测评数据
        Map<String[],List<String[]>> map = inxlsx.getMaps();
        //标题
        List<String> lists =  inxlsx.getList();
        
        Set<String> set = inxlsx.getSet();
//        System.out.println("比较两个 标题 是否属于当前分类得");
//        System.out.println("lists:"+lists);
//        System.out.println("listtitle:"+listtitle);
//        System.out.println("MBTI-set:"+set);
        //比较两个 标题 是否属于当前分类得
        
        boolean flag = false;
        
        listtitle.add("序号");
    	listtitle.add("题目");
    	listtitle.add("选项");
        //判断是否为兴趣学科测评
        if ((lists.containsAll(listtitle) && lists.size() ==listtitle.size())  && titlenum > 0) {
			System.out.println("兴趣学科测评");
			istype = "0";//兴趣 试题导入
			flag = true;
		}
        if (!flag) {
//        	22
//        	listtitle.clear();
//        	listtitle.add("序号");
//        	listtitle.add("题目");
//        	listtitle.add("选项");
//        	listtitle.add("内容");
        	//判断是否为MBTI
        	if (listtitle.containsAll(set)   && titlenum > 0) {
        		istype = "2";//MBTI
        		System.out.println("MBTI");
        		flag = true;
        	}
        }
        if (!flag) {
        	listtitle.clear();
        	listtitle.add("序号");
        	listtitle.add("题目");
        	listtitle.add("选项");
        	listtitle.add("正确答案");
        	listtitle.add("是否为易错题");
        	listtitle.add("评语");
        	//判断是否为试卷测评
        	if ((lists.containsAll(listtitle) && lists.size() ==listtitle.size())  && titlenum == 0) {
        		istype = "1";//试卷
        		System.out.println("试卷测评");
        		flag = true;
        	}
		}
        
        if(!flag) {
			return AjaxResult.error("title 与当前分类一致");
		}
//        System.out.println(lists.toString());
        for(Entry<String[], List<String[]>> entry : map.entrySet()){
            String[] mapKey = entry.getKey();
//            for (String string : mapKey) {
//				System.out.print(string+"\t");
//			}
//            System.out.println();
            List<String[]> mapValue = entry.getValue();
//            for (String[] strings : mapValue) {
//				for (String strings2 : strings) {
//					System.out.print(strings2+"\t");
//				}
//				System.out.println();
//			}
//            System.out.println(mapKey.toString()+":"+mapValue.toString());
            
           AjaxResult resut = addSave(mapKey,mapValue,padtid,lists,istype,lieeds);
           System.out.println(resut.toString());
        }
//        Thread.sleep(5000);
        return AjaxResult.success();
    }
	
	public AjaxResult addSave( String[] mapKey,List<String[]> mapValue,String cateid,List<String> titles,String istype,List<ExamEvaluationDimension> lieeds) {
		
		String optionA[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		List<ExamSubjectOption> examSubjectOptionList = new ArrayList<>();
		List<ExamSubjectOptionOption> subjectOptionOptions = new ArrayList<>();
		String str = Stringutil.getLongUID()+"";
		ExamSubjectJudgement examSubjectJudgement = new ExamSubjectJudgement();
		
		examSubjectJudgement.setId(str);
		examSubjectJudgement.setCategoryId(cateid);
		examSubjectJudgement.setSerialNumber(Integer.parseInt(mapKey[0]));
		examSubjectJudgement.setSubjectName(mapKey[1]);
		
		String answer = "";
		String level = "";
		
		for (int i = 0; i < mapValue.size(); i++) {
			String str11[] = mapValue.get(i);
			for (String string : str11) {
				System.out.print(string+"\t");
			}
			System.out.println();
//			JSONObject jsonObject = jo.getJSONObject(i);
			String ss = optionA[i];//选项a
			String nn;
			String gg = "";
			if ("0".equals(istype) ) {//mbti
				 nn = str11[0];//选项对应的信息
				 gg = str11[1];//选项对应的信息
			}else if("1".equals(istype)){//简单分类
				nn = str11[0];//选项对应的信息
				if ("1".equals(str11[1])) {//参考答案
					answer = ss;
				}
				if ("1".equals(str11[2])) {//参考答案
					level = "1";
				}
				gg = str11[3];//选项对应的信息
			}else {
				 nn = str11[1];
				 if ("-".equals(nn)) {
					continue;
				}
			}
			String ssid = Stringutil.getLongUID()+"";
			
			if (!"".equals(ss)&& !"".equals(nn)) {
				ExamSubjectOption subjectOption = new ExamSubjectOption();
				subjectOption.setId(ssid);
				subjectOption.setSubjectChoicesId(str);
				subjectOption.setOptionName(ss);
				subjectOption.setOptionContent(nn);
				subjectOption.setCreator(gg);
				examSubjectOptionList.add(subjectOption);
			}
			//istype 0 兴趣  1 试卷    2 mbti
			if ("0".equals(istype)) {//兴趣
				for (int j = 3; j < titles.size(); j++) {
					String dd =  titles.get(j);//子类a
//					System.out.println("标题:"+dd+"");
					for (int j1 = 0; j1 < lieeds.size(); j1++) {
						ExamEvaluationDimension optionid = lieeds.get(j1);
						String ssr = optionid.getOptionName().toUpperCase();
						if ((ssr != null && !"".equals(ssr)) && ssr.equals(dd.toUpperCase())  ) {
							dd = optionid.getId();
							break;
						}
					}
//					System.out.println("dd:"+dd);
//					System.out.println("str11:"+str11.length);
					String ff;
					if (str11.length <=  j-2) {
						 ff = "0";
					}else {
						
						ff = str11[j-2] == null  ?"0":str11[j-2];//子类 分数
						ff = "-".equals(ff) ? "0" : ff;
					}
//					System.out.println("ff:"+ff);
//					System.out.println("选项："+nn+"\t标题:"+titles.get(j)+"\t分值："+ff);
					
					if (!"".equals(dd)&& !"".equals(ff)) {
						ExamSubjectOptionOption optionOption = new ExamSubjectOptionOption();
						optionOption.setId(Stringutil.getLongUID()+"");
						optionOption.setSubjectChoicesId(ssid);
						optionOption.setOptionName(dd);
						optionOption.setOptionContent(ff);
						subjectOptionOptions.add(optionOption);
					}
				}
			}else if("2".equals(istype)) {//MBTI
				String dd =  str11[0];//子类a
				for (int j = 0; j < lieeds.size(); j++) {
					ExamEvaluationDimension optionid = lieeds.get(j);
					String ssr = optionid.getOptionName().toUpperCase();
					if ((ssr != null && !"".equals(ssr)) && ssr.equals(dd.toUpperCase())  ) {
						dd = optionid.getId();
						break;
					}
				}
				String ff = "1";//子类 分数
				if (!"".equals(dd)&& !"".equals(ff)) {
					ExamSubjectOptionOption optionOption = new ExamSubjectOptionOption();
					optionOption.setId(Stringutil.getLongUID()+"");
					optionOption.setSubjectChoicesId(ssid);
					optionOption.setOptionName(dd);
					optionOption.setOptionContent(ff);
					subjectOptionOptions.add(optionOption);
				}
			}
		}
		
		if("1".equals(istype)){//简单分类
			if (!"".equals(answer)) {
				examSubjectJudgement.setAnswer(answer);//参考答案
			}
			if (!"".equals(level)) {
				examSubjectJudgement.setLevel(Integer.parseInt(level));//是否为易错题
			}
		}
		
		
		
		int row = 0;
		for (ExamSubjectOptionOption examSubjectOptionOption : subjectOptionOptions) {
			row +=examSubjectOptionOptionService.insertExamSubjectOptionOption(examSubjectOptionOption);
		}
		for (ExamSubjectOption examSubjectOption2 : examSubjectOptionList) {
			row +=examSubjectOptionService.insertExamSubjectOption(examSubjectOption2);
		}
		row +=examSubjectJudgementService.insertExamSubjectJudgement(examSubjectJudgement);
		return toAjax(row);
	}
	
	
	
}
