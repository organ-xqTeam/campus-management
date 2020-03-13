package com.ruoyi.project.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.system.CourseSystem.domain.CourseSystem;
import com.ruoyi.project.system.CourseSystem.service.ICourseSystemService;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.examExaminationSubject.domain.ExamExaminationSubject;
import com.ruoyi.project.system.examExaminationSubject.service.IExamExaminationSubjectService;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import com.ruoyi.project.system.examSubjectJudgement.service.IExamSubjectJudgementService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;
import com.ruoyi.project.system.schoolcoursewareinfo.domain.Schoolcoursewareinfo;
import com.ruoyi.project.system.schoolcoursewareinfo.service.ISchoolcoursewareinfoService;

@CrossOrigin
@Controller
@RequestMapping("/app")
public class AppMobileController extends BaseController {
	
	@Autowired
    private ICourseSystemService courseSystemService;
	@Autowired
	private ITeachingInfoService teachingInfoService;
	@Autowired
	private ICoursemanagementService coursemanagementService;
	@Autowired
    private ISchoolcoursewareinfoService schoolcoursewareinfoService;
	@Autowired
	private IExamSubjectJudgementService examSubjectJudgementService;
	@Autowired
	private IExamSubjectShortAnswerService examSubjectShortAnswerService;
	@Autowired
	private IExamExaminationSubjectService examExaminationSubjectService;
	
	/**
	 * 选课-主页-名师专栏
	 * */
	@ResponseBody
    @RequestMapping(value="/teacher/list")
    public TableDataInfo teacherlist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	TeachingInfo teacher = new TeachingInfo();
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<TeachingInfo> teacherlist = teachingInfoService.selectTeachingInfoList(teacher);
    	return getDataTable(teacherlist);
	}
	
	/**
	 * 
	 * 选课-主页-专题课
	 * 
	 * 选课-专题课-课程体系
	 * 
	 * */
	@ResponseBody
    @RequestMapping(value="/course/list")
    public TableDataInfo courselist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	Coursemanagement course = new Coursemanagement();
    	if (param.get("curriculuSystem") != null) {
    		course.setCurriculuSystem(param.get("curriculuSystem").toString());
    	}
    	if (param.get("teacherid") != null) {
    		course.setTeacherId(Long.valueOf(param.get("teacherid").toString()));
    	}
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Coursemanagement> courselist = coursemanagementService.selectCoursemanagementList(course);
    	return getDataTable(courselist);
	}

	/**
	 * 选课-专题课-课程体系
	 * */
	@ResponseBody
    @RequestMapping(value="/courseSystem/list")
    public TableDataInfo courseSystemlist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	CourseSystem courseSystem = new CourseSystem();
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<CourseSystem> courseSystemlist = courseSystemService.selectCourseSystemList(courseSystem);
    	return getDataTable(courseSystemlist);
	}
	
	/**
	 * 选课-专题课-课程体系-授课教师
	 * */
	@ResponseBody
    @RequestMapping(value="/course/teacher")
    public TeachingInfo courseteacher(@RequestParam("id") Long id) {
    	return teachingInfoService.selectTeachingInfoById(id);
	}
	
	/**
	 * 选课-专题课-课程体系-课件
	 * */
	@ResponseBody
    @RequestMapping(value="/courseware/list")
    public TableDataInfo coursewarelist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
		Schoolcoursewareinfo courseware = new Schoolcoursewareinfo();
		if (param.get("courseid") != null) {
			courseware.setCourseid(param.get("courseid").toString());
		}
		PageHelper.startPage(pageNum, pageSize, null);
		List<Schoolcoursewareinfo> coursewarelist = schoolcoursewareinfoService.selectSchoolcoursewareinfoList(courseware);
    	return getDataTable(coursewarelist);
	}
	
	/**
	 * 考试-试卷
	 * */
	@ResponseBody
    @RequestMapping(value="/paper/list")
    public TableDataInfo paperlist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
		ExamSubjectShortAnswer examSubjectShortAnswer = new ExamSubjectShortAnswer();
		examSubjectShortAnswer.setCategoryId("-1");
		PageHelper.startPage(pageNum, pageSize, null);
        List<ExamSubjectShortAnswer> list = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(examSubjectShortAnswer);
		return getDataTable(list);
	}
	
	/**
	 * 考试-试题
	 * */
	@ResponseBody
    @RequestMapping(value="/question/list")
    public JSONArray questionlist(@RequestParam("id") String id) {
		ExamExaminationSubject examExaminationSubject = new ExamExaminationSubject();
		examExaminationSubject.setExaminationId(id);
		List<ExamExaminationSubject> la1 = examExaminationSubjectService.selectExamExaminationSubjectList(examExaminationSubject);
		JSONArray array = new JSONArray();
		for(int i=0; i<la1.size(); i++) {
			ExamExaminationSubject e = la1.get(i);
			ExamSubjectJudgement ex = examSubjectJudgementService.selectExamSubjectJudgementById(e.getSubjectId());
			array.add(ex);
		}		
		return array;
	}
	
}
