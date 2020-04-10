package com.ruoyi.project.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.schoolHomeworkDetail.service.ISchoolHomeworkDetailService;
import com.ruoyi.project.system.schoolHomeworkDetailDetail.domain.SchoolHomeworkDetailDetail;
import com.ruoyi.project.system.userpraise.domain.Userpraise;
import com.ruoyi.project.system.userpraise.service.IUserpraiseService;

@CrossOrigin
@Controller
@RequestMapping("/app/homework")
public class AppHomeWorkNewController extends BaseController {

	@Autowired
    private IUserpraiseService userpraiseService; 
	@Autowired
    private ISchoolHomeworkDetailService schoolHomeworkDetailService;
	
	/**
	 * 学生端-作业列表
	 * */
	@ResponseBody
    @RequestMapping(value="/studentHomework/list")
    public TableDataInfo studentHomeworkList(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Map<String, Object>> list = schoolHomeworkDetailService.selectStudentHomework(param);
    	return getDataTable(list);
	}
	
	/**
	 * 学生端-我参与的小组详情-当日打卡情况
	 * */
	@ResponseBody
    @RequestMapping(value="/studentHomeworkToday/list")
    public TableDataInfo studentHomeworkTodayList(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Map<String, Object>> list = schoolHomeworkDetailService.selectStudentHomeworkToday(param);
    	return getDataTable(list);
	}
	
	/**
	 * 学生端-我参与的小组详情-打卡记录
	 * */
	@ResponseBody
    @RequestMapping(value="/studentHomeworkHistory/list")
    public TableDataInfo studentHomeworkHistoryList(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Map<String, Object>> list = schoolHomeworkDetailService.selectStudentHomeworkHistory(param);
    	return getDataTable(list);
	}
	
	/**
	 * 学生端-我参与的小组详情-打卡
	 * */
	@ResponseBody
    @RequestMapping(value="/studentHomework/submit")
	public AjaxResult studentHomeworkSubmit(@RequestBody SchoolHomeworkDetailDetail detail) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("detailid", detail.getDetailid());
		param.put("studentid", detail.getStudentid());
    	List<Map<String, Object>> list = schoolHomeworkDetailService.selectStudentHomeworkToday(param);
    	if (list.size() == 0) {
    		detail.setOntest("1");
    		detail.setSubmittime(DateUtils.getTime());
    		schoolHomeworkDetailService.studentHomeworkSubmit(detail);
    		return AjaxResult.success(true);
    	}
    	else {
    		return AjaxResult.error("当日已打卡");
    	}
	}
	
	/**
     * 学生端 - 同学打卡列表
     * */
	@ResponseBody
    @RequestMapping(value="/classStudentHomework/list")
    public TableDataInfo classStudentHomeworkList(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Map<String, Object>> list = schoolHomeworkDetailService.selectClassStudentHomework(param);
    	return getDataTable(list);
	}
	
	/**
     * 老师端 - 作业列表
     * */
	@ResponseBody
    @RequestMapping(value="/teacherHomework/list")
    public TableDataInfo teacherHomeworkList(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Map<String, Object>> list = schoolHomeworkDetailService.selectTeacherHomework(param);
    	return getDataTable(list);
	}
	
	/**
     * 老师端 - 同学打卡列表
     * */
	@ResponseBody
    @RequestMapping(value="/teacherClassHomework/list")
    public TableDataInfo teacherClassHomeworkList(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Map<String, Object>> list = schoolHomeworkDetailService.selectTeacherClassHomework(param);
    	return getDataTable(list);
	}
	
	/**
	 * 老师端 - 同学打卡列表 - 批改作业
	 * */
	@ResponseBody
    @RequestMapping(value="/teacherHomework/change")
	public AjaxResult teacherHomeworkChange(@RequestBody SchoolHomeworkDetailDetail detail) {
		schoolHomeworkDetailService.updateSchoolHomeworkDetail(detail);
		return AjaxResult.success(true);
	}
	
	/**
	 * 点赞
	 * */
	@ResponseBody
    @RequestMapping(value="/praise/save")
    public AjaxResult praisesave(@RequestBody Userpraise praise) {
		userpraiseService.insertUserPraise(praise);
		return AjaxResult.success(true);
	}
	
	/**
	 * 取消点赞
	 * */
	@ResponseBody
    @RequestMapping(value="/praise/cancel")
    public AjaxResult praisecancel(@RequestBody Userpraise praise) {
		userpraiseService.cancelUserPraise(praise);
		return AjaxResult.success(true);
	}
	
}
