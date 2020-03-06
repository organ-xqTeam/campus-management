package com.ruoyi.project.system.examAdInformation.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
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
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.Stringutil;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.examAdInformation.domain.ExamAdInformation;
import com.ruoyi.project.system.examAdInformation.service.IExamAdInformationService;
import com.ruoyi.project.system.examEvaluationDimension.domain.ExamEvaluationDimension;
import com.ruoyi.project.system.examEvaluationDimension.service.IExamEvaluationDimensionService;
import com.ruoyi.project.system.examMbtiResult.domain.ExamMbtiResult;
import com.ruoyi.project.system.examMbtiResult.service.IExamMbtiResultService;
import com.ruoyi.project.system.examOrdinaryResult.domain.ExamOrdinaryResult;
import com.ruoyi.project.system.examOrdinaryResult.service.IExamOrdinaryResultService;
import com.ruoyi.project.system.examSubjectResult.domain.ExamSubjectResult;
import com.ruoyi.project.system.examSubjectResult.service.IExamSubjectResultService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;

/**
 * 广告的信息操作处理
 * 
 * @author ruoyi
 * @date 2019-10-23
 */
@Controller
@RequestMapping("/system/examAdInformation")
public class ExamAdInformationController extends BaseController
{
    private String prefix = "system/examAdInformation";
	
    @Autowired
	private IExamSubjectShortAnswerService examSubjectShortAnswerService;
    @Autowired
   	private IExamEvaluationDimensionService examEvaluationDimensionService;
    @Autowired
	private IExamOrdinaryResultService examOrdinaryResultService;
    @Autowired
	private IExamSubjectResultService examSubjectResultService;
    @Autowired
	private IExamMbtiResultService examMbtiResultService;
	@Autowired
	private IExamAdInformationService examAdInformationService;
	
	@RequiresPermissions("system:examAdInformation:view")
	@GetMapping()
	public String examAdInformation( ModelMap mmap)
	{
		
		//简单试题
		List<ExamOrdinaryResult> jdlist = examOrdinaryResultService.selectExamOrdinaryResultList(null);
		List<ExamOrdinaryResult> jdlistnew = new ArrayList<ExamOrdinaryResult>();
		//处理id
		for (int i = 0; i < jdlist.size(); i++) {
			ExamOrdinaryResult examOrdinaryResult = jdlist.get(i);
			String strname =  examOrdinaryResult.getOptionName();
			System.out.println(strname);
			ExamSubjectShortAnswer essas = examSubjectShortAnswerService.selectExamSubjectShortAnswerById(strname);
			examOrdinaryResult.setOptionContent(essas.getSubjectName());
			jdlistnew.add(examOrdinaryResult);
		}
		//科目
		List<ExamSubjectResult> kulist = examSubjectResultService.selectExamSubjectResultList(null);
		List<ExamSubjectResult> kulistnew = new ArrayList<ExamSubjectResult>();
		//处理 关联的 科目
		for (int i = 0; i < kulist.size(); i++) {
			ExamSubjectResult e = kulist.get(i);
			String str =  e.getOptionCode();
			String[] ss =  str.split(",");
			JSONArray array = new JSONArray();
			StringBuffer sb = new StringBuffer();
			for (int i1 = 0; i1 < ss.length; i1++) {
				if (ss[i1].length() > 0) {
					ExamEvaluationDimension dimension = examEvaluationDimensionService.selectExamEvaluationDimensionById(ss[i1]);
					JSONObject object = new JSONObject();
					object.put("optionName", dimension.getOptionName());
					object.put("scid", dimension.getSubjectChoicesId());
					object.put("id", dimension.getId());
					sb.append(dimension.getOptionName());
					sb.append(",");
					array.add(object);
				}
			}
			e.setOptionContent(sb.toString());
			kulistnew.add(e);
		}
		//mbti
		List<ExamMbtiResult> mbtilist = examMbtiResultService.selectExamMbtiResultList(null);
		mmap.put("mbtilist", mbtilist);
		mmap.put("kulist", kulistnew);
		mmap.put("jdlist", jdlistnew);
	    return prefix + "/examAdInformation";
	}
	
	/**
	 * 查询广告的列表
	 */
	@RequiresPermissions("system:examAdInformation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExamAdInformation examAdInformation)
	{
		startPage();
        List<ExamAdInformation> list = examAdInformationService.selectExamAdInformationList(examAdInformation);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出广告的列表
	 */
	@RequiresPermissions("system:examAdInformation:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamAdInformation examAdInformation)
    {
    	List<ExamAdInformation> list = examAdInformationService.selectExamAdInformationList(examAdInformation);
        ExcelUtil<ExamAdInformation> util = new ExcelUtil<ExamAdInformation>(ExamAdInformation.class);
        return util.exportExcel(list, "examAdInformation");
    }
	
	/**
	 * 新增广告的
	 */
	@GetMapping("/add")
	public String add( ModelMap mmap)
	{	
		//简单试题
		List<ExamOrdinaryResult> jdlist = examOrdinaryResultService.selectExamOrdinaryResultList(null);
		List<ExamOrdinaryResult> jdlistnew = new ArrayList<ExamOrdinaryResult>();
		//处理id
		for (int i = 0; i < jdlist.size(); i++) {
			ExamOrdinaryResult examOrdinaryResult = jdlist.get(i);
			String strname =  examOrdinaryResult.getOptionName();
			ExamSubjectShortAnswer essas = examSubjectShortAnswerService.selectExamSubjectShortAnswerById(strname);
			examOrdinaryResult.setOptionContent(essas.getSubjectName());
			jdlistnew.add(examOrdinaryResult);
		}
		//科目
		List<ExamSubjectResult> kulist = examSubjectResultService.selectExamSubjectResultList(null);
		List<ExamSubjectResult> kulistnew = new ArrayList<ExamSubjectResult>();
		//处理 关联的 科目
		for (int i = 0; i < kulist.size(); i++) {
			ExamSubjectResult e = kulist.get(i);
			String str =  e.getOptionCode();
			String[] ss =  str.split(",");
			JSONArray array = new JSONArray();
			StringBuffer sb = new StringBuffer();
			for (int i1 = 0; i1 < ss.length; i1++) {
				if (ss[i1].length() > 0) {
					ExamEvaluationDimension dimension = examEvaluationDimensionService.selectExamEvaluationDimensionById(ss[i1]);
					JSONObject object = new JSONObject();
					object.put("optionName", dimension.getOptionName());
					object.put("scid", dimension.getSubjectChoicesId());
					object.put("id", dimension.getId());
					sb.append(dimension.getOptionName());
					sb.append(",");
					array.add(object);
				}
			}
			e.setOptionContent(sb.toString());
			kulistnew.add(e);
		}
		//mbti
		List<ExamMbtiResult> mbtilist = examMbtiResultService.selectExamMbtiResultList(null);
		mmap.put("mbtilist", mbtilist);
		mmap.put("kulist", kulistnew);
		mmap.put("jdlist", jdlistnew);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存广告的
	 */
	@RequiresPermissions("system:examAdInformation:add")
	@Log(title = "广告的", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ExamAdInformation examAdInformation)
	{		
//		String json =  examAdInformation.getImageBase();
//		JSONObject jsonObject = JSONObject.parseObject(json);
//		System.out.println(jsonObject.toJSONString());
//		String str = jsonObject.getString("imageBase");
//		examAdInformation.setImageBase(str);
		examAdInformation.setId(Stringutil.getLongUID());
		return toAjax(examAdInformationService.insertExamAdInformation(examAdInformation));
	}
	/**
	 * 修改广告的
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		//简单试题
		List<ExamOrdinaryResult> jdlist = examOrdinaryResultService.selectExamOrdinaryResultList(null);
		List<ExamOrdinaryResult> jdlistnew = new ArrayList<ExamOrdinaryResult>();
		//处理id
		for (int i = 0; i < jdlist.size(); i++) {
			ExamOrdinaryResult examOrdinaryResult = jdlist.get(i);
			String strname =  examOrdinaryResult.getOptionName();
			ExamSubjectShortAnswer essas = examSubjectShortAnswerService.selectExamSubjectShortAnswerById(strname);
			examOrdinaryResult.setOptionContent(essas.getSubjectName());
			jdlistnew.add(examOrdinaryResult);
		}
		//科目
		List<ExamSubjectResult> kulist = examSubjectResultService.selectExamSubjectResultList(null);
		List<ExamSubjectResult> kulistnew = new ArrayList<ExamSubjectResult>();
		//处理 关联的 科目
		for (int i = 0; i < kulist.size(); i++) {
			ExamSubjectResult e = kulist.get(i);
			String str =  e.getOptionCode();
			String[] ss =  str.split(",");
			JSONArray array = new JSONArray();
			StringBuffer sb = new StringBuffer();
			for (int i1 = 0; i1 < ss.length; i1++) {
				if (ss[i1].length() > 0) {
					ExamEvaluationDimension dimension = examEvaluationDimensionService.selectExamEvaluationDimensionById(ss[i1]);
					JSONObject object = new JSONObject();
					object.put("optionName", dimension.getOptionName());
					object.put("scid", dimension.getSubjectChoicesId());
					object.put("id", dimension.getId());
					sb.append(dimension.getOptionName());
					sb.append(",");
					array.add(object);
				}
			}
			e.setOptionContent(sb.toString());
			kulistnew.add(e);
		}
		//mbti
		List<ExamMbtiResult> mbtilist = examMbtiResultService.selectExamMbtiResultList(null);
		mmap.put("mbtilist", mbtilist);
		mmap.put("kulist", kulistnew);
		mmap.put("jdlist", jdlistnew);
		
		
		
		ExamAdInformation examAdInformation = examAdInformationService.selectExamAdInformationById(id);
		
		
		if ("M".equals(examAdInformation.getIsBusy())) {
			for (int i = 0; i < mbtilist.size(); i++) {
				if(examAdInformation.getClassificationid().equals(mbtilist.get(i).getId())) {
					examAdInformation.setIsRepair(mbtilist.get(i).getOptionCode()+" "+mbtilist.get(i).getOptionName());
					break;
				}
			}
		}else if("K".equals(examAdInformation.getIsBusy())) {
			for (int i = 0; i < kulistnew.size(); i++) {
				if(examAdInformation.getClassificationid().equals(kulistnew.get(i).getId())) {
					examAdInformation.setIsRepair(kulistnew.get(i).getOptionContent());
					break;
				}
			}
		}else if("J".equals(examAdInformation.getIsBusy())) {
			for (int i = 0; i < jdlistnew.size(); i++) {
				if(examAdInformation.getClassificationid().equals(jdlistnew.get(i).getId())) {
					examAdInformation.setIsRepair(jdlistnew.get(i).getOptionContent());
					break;
				}
			}
		}
		mmap.put("examAdInformation", examAdInformation);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存广告的
	 */
	@RequiresPermissions("system:examAdInformation:edit")
	@Log(title = "广告的", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ExamAdInformation examAdInformation)
	{		
		return toAjax(examAdInformationService.updateExamAdInformation(examAdInformation));
	}
	
	/**
	 * 删除广告的
	 */
	@RequiresPermissions("system:examAdInformation:remove")
	@Log(title = "广告的", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(examAdInformationService.deleteExamAdInformationByIds(ids));
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
	
	public static String imageToBase64(String path){
		   InputStream is = null;
		   byte[] data = null;
		   String result = null;
		   try{
		      is = new FileInputStream(path);
		      //创建一个字符流大小的数组。
		      data = new byte[is.available()];
		      //写入数组
		      is.read(data);
		      //用默认的编码格式进行编码
		      result =Base64.encodeBase64String(data);
		 
		   }catch (IOException e){
		      e.printStackTrace();
		   }finally {
		      if(null !=is){
		         try {
		            is.close();
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		      }
		 
		   }
		   return result;
		}
	
	
}
