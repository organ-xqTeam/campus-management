package com.ruoyi.project.app;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.CourseSystem.domain.CourseSystem;
import com.ruoyi.project.system.CourseSystem.service.ICourseSystemService;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.examExaminationSubject.domain.ExamExaminationSubject;
import com.ruoyi.project.system.examExaminationSubject.service.IExamExaminationSubjectService;
import com.ruoyi.project.system.examStudentList.domain.ExamStudentList;
import com.ruoyi.project.system.examStudentList.service.IExamStudentListService;
import com.ruoyi.project.system.examStudentListDetail.domain.ExamStudentListDetail;
import com.ruoyi.project.system.examStudentListDetail.service.IExamStudentListDetailService;
import com.ruoyi.project.system.examStudentListDetail.service.impl.ExamStudentListDetailServiceImpl;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import com.ruoyi.project.system.examSubjectJudgement.service.IExamSubjectJudgementService;
import com.ruoyi.project.system.examSubjectOption.domain.ExamSubjectOption;
import com.ruoyi.project.system.examSubjectOption.service.IExamSubjectOptionService;
import com.ruoyi.project.system.examSubjectOptionOption.domain.ExamSubjectOptionOption;
import com.ruoyi.project.system.examSubjectOptionOption.service.IExamSubjectOptionOptionService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;
import com.ruoyi.project.system.schoolcoursewareinfo.domain.Schoolcoursewareinfo;
import com.ruoyi.project.system.schoolcoursewareinfo.service.ISchoolcoursewareinfoService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.project.system.usercollection.domain.Usercollection;
import com.ruoyi.project.system.usercollection.service.impl.UsercollectionSerciceImpl;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;

@CrossOrigin
@Controller
@RequestMapping("/app")
public class AppMobileController extends BaseController {

	@Autowired
	private ISysUserService userService;
	@Autowired
	private ISysUserOnlineService userOnlineService;
	@Autowired
    private ICourseSystemService courseSystemService;
	@Autowired
	private ITeachingInfoService teachingInfoService;
	@Autowired
	private IExamStudentListService examStudentListService;
	@Autowired
	private ICoursemanagementService coursemanagementService;
	@Autowired
	private ISchoolstudentslistService schoolstudentslistService; 
	@Autowired
    private ISchoolcoursewareinfoService schoolcoursewareinfoService;
	@Autowired
	private IExamSubjectJudgementService examSubjectJudgementService;
	@Autowired
	private IExamStudentListDetailService examStudentListDetailService;
	@Autowired
	private IExamSubjectShortAnswerService examSubjectShortAnswerService;
	@Autowired
	private IExamExaminationSubjectService examExaminationSubjectService;
	@Autowired
	private IExamSubjectOptionService examSubjectOptionService;
	@Autowired
	private IExamSubjectOptionOptionService examSubjectOptionOptionService;
	@Autowired
	private ExamStudentListDetailServiceImpl examStudentListDetailservice;
	@Autowired
	private UsercollectionSerciceImpl usercollectionSercice; 
	/**
	 * 选课-主页-名师专栏
	 * */
	@ResponseBody
    @RequestMapping(value="/teacher/list")
    public TableDataInfo teacherlist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	TeachingInfo teacher = new TeachingInfo();
    	if (param.get("name") != null) {
    		teacher.setTeachingName(param.get("name").toString());
    	}
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<TeachingInfo> teacherlist = teachingInfoService.selectTeachingInfoList(teacher);
    	if (param.get("iscollection") != null) {
    		for (int i=0; i<teacherlist.size(); i++) {
    			TeachingInfo teacheri = new TeachingInfo();
    			teacheri.setId(teacherlist.get(i).getId());
    			teacheri.setCollectionstu(param.get("iscollection").toString());
    			List<TeachingInfo> iscollection = teachingInfoService.selectTeachingInfoList(teacheri);
    			if (iscollection.size() > 0) {
    				teacherlist.get(i).setIscollection("yes");
    			}
    			else {
    				teacherlist.get(i).setIscollection("no");
    			}
    		}
    	}
    	return getDataTable(teacherlist);
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
	 * 
	 * 选课-主页-专题课
	 * 
	 * 选课-专题课
	 * 
	 * 考试-年级下的课程
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
    	if (param.get("grade") != null) {
    		course.setGrade(param.get("grade").toString());
    	}
    	if (param.get("name") != null) {
    		course.setStudentsName(param.get("name").toString());
    	}
    	PageHelper.startPage(pageNum, pageSize, null);
    	List<Coursemanagement> courselist = coursemanagementService.selectCoursemanagementList(course);
    	return getDataTable(courselist);
	}

	/**
	 * 选课-专题课-详情页
	 * */
	@ResponseBody
    @RequestMapping(value="/course/info")
    public AjaxResult courseinfo(@RequestParam("id") Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		//课程详情
		Coursemanagement course = coursemanagementService.selectCoursemanagementById(id);
		//多少人看过
		String seeNum = course.getRemark2();
		if (seeNum == null || seeNum.equals("")) {
			int num = 1;
			course.setRemark2(num+"");
		}
		else {
			int num = Integer.valueOf(course.getRemark2());
			num ++;
			course.setRemark2(num+"");
		}
		coursemanagementService.updateCoursemanagement(course);
		result.put("course", course);
		//授课教师
		if (course.getTeacherId() != null) {
			result.put("teacher", teachingInfoService.selectTeachingInfoById(course.getTeacherId()));
		}
		//课件
		Schoolcoursewareinfo courseware = new Schoolcoursewareinfo();
		courseware.setCourseid(id+"");
		List<Schoolcoursewareinfo> coursewarelist = schoolcoursewareinfoService.selectSchoolcoursewareinfoList(courseware);
		result.put("coursewarelist", coursewarelist);
    	return AjaxResult.success(result);
	}
	
	/**
	 * 
	 * 考试-试卷列表
	 * 
	 * 错题试卷列表
	 * 
	 * */
	@ResponseBody
    @RequestMapping(value="/paper/list")
    public TableDataInfo paperlist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
		ExamSubjectShortAnswer examSubjectShortAnswer = new ExamSubjectShortAnswer();
		if (param.get("type") != null) {
			examSubjectShortAnswer.setType(param.get("type").toString());
		}
		if (param.get("courseid") != null) {
			examSubjectShortAnswer.setCourseid(param.get("courseid").toString());
		}
		if (param.get("studentid") != null) {
			examSubjectShortAnswer.setStudentid(param.get("studentid").toString());
		}
		examSubjectShortAnswer.setIssave("1");
		examSubjectShortAnswer.setCategoryId("-1");
		PageHelper.startPage(pageNum, pageSize, null);
        List<ExamSubjectShortAnswer> list = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(examSubjectShortAnswer);
		return getDataTable(list);
	}
	
	/**
	 * 考试-试题列表
	 * */
	@ResponseBody
    @RequestMapping(value="/question/list")
    public TableDataInfo questionlist(@RequestParam("id") String id) {
		ExamExaminationSubject examExaminationSubject = new ExamExaminationSubject();
		examExaminationSubject.setExaminationId(id);
		List<ExamExaminationSubject> la1 = examExaminationSubjectService.selectExamExaminationSubjectList(examExaminationSubject);
		JSONArray array = new JSONArray();
		for(int i=0; i<la1.size(); i++) {
			ExamExaminationSubject e = la1.get(i);
			ExamSubjectJudgement ex = examSubjectJudgementService.selectExamSubjectJudgementById(e.getSubjectId());			
			ExamSubjectOption oprion = new ExamSubjectOption();
			oprion.setSubjectChoicesId(ex.getId());
			List<ExamSubjectOption> list =  examSubjectOptionService.selectExamSubjectOptionList(oprion);
			JSONArray esolist = new JSONArray();
			for (ExamSubjectOption examSubjectOption : list) {
				JSONObject object = new JSONObject();
				object.put("name", examSubjectOption.getOptionName());
				object.put("content", examSubjectOption.getOptionContent());
				object.put("creator", examSubjectOption.getCreator());
				ExamSubjectOptionOption optiono = new ExamSubjectOptionOption();
				optiono.setSubjectChoicesId(examSubjectOption.getId());
				List<ExamSubjectOptionOption> optionOptions =  examSubjectOptionOptionService.selectExamSubjectOptionOptionList(optiono);
				JSONArray jsonArray = new JSONArray();
				for (int j = 0; j < optionOptions.size(); j++) {
					jsonArray.add(optionOptions.get(j));
				}
				object.put("next", jsonArray);
				esolist.add(object);
			}
			ex.setEsolist(esolist);			
			array.add(ex);
		}		
		return getDataTable(array);
	}
	
	/**
	 * 考试-提交试卷
	 * */
	@ResponseBody
	@SuppressWarnings("unchecked")
    @RequestMapping(value="/paper/submit")
    public AjaxResult papersubmit(@RequestBody JSONObject param) {
		ExamStudentList esl = new ExamStudentList();
		esl.setStudentid(param.get("studentid").toString());
		esl.setPaperid(param.get("paperid").toString());
		List<ExamStudentList> eslRepeatCheckList = examStudentListService.selectExamStudentListList(esl);
		if (eslRepeatCheckList.size() > 0) {
			return AjaxResult.error("该学生已提交试卷");
		}
		esl.setTotal(param.get("total").toString());
		examStudentListService.insertExamStudentList(esl);
		ExamStudentListDetail esld = new ExamStudentListDetail();
		List<Map<String, Object>> questionlist = (List<Map<String, Object>>) param.get("questionlist");
		for(Map<String, Object> question : questionlist) {
			esld.setDetailid(esl.getId()+"");
			esld.setQuestionid(question.get("questionid").toString());
			esld.setChoose(question.get("choose").toString());
			esld.setIswrong(question.get("iswrong").toString());
			examStudentListDetailService.insertExamStudentListDetail(esld);
		}
		return toAjax(true);
	}

	/**
	 * 考试-错题试卷列表
	 * */
	@ResponseBody
    @RequestMapping(value="/wrongpaper/list")
    public TableDataInfo wrongpaperlist(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
		ExamSubjectShortAnswer examSubjectShortAnswer = new ExamSubjectShortAnswer();
		if (param.get("studentid") != null) {
			examSubjectShortAnswer.setStudentid(param.get("studentid").toString());
		}
		examSubjectShortAnswer.setIssave("1");
		examSubjectShortAnswer.setCategoryId("-1");
		PageHelper.startPage(pageNum, pageSize, null);
        List<ExamSubjectShortAnswer> list = examSubjectShortAnswerService.selectExamSubjectShortAnswerList(examSubjectShortAnswer);
		for (int i=0; i<list.size(); i++) {
			ExamStudentListDetail esld = new ExamStudentListDetail();
			esld.setPaperid(list.get(i).getId());
			if (param.get("studentid") != null) {
				esld.setStudentid(param.get("studentid").toString());
			}
			esld.setIswrong("1");
			List<ExamStudentListDetail> esldlist = examStudentListDetailservice.selectExamStudentListDetailList(esld);
			if (esldlist.size() == 0) {
				list.remove(i);
			}
			else {
				list.get(i).setWrongnum(esldlist.size()+"");
			}
		}
        return getDataTable(list);
	}
	
	/**
	 * 考试-错题列表
	 * */
	@ResponseBody
    @RequestMapping(value="/wrongquestion/list")
    public TableDataInfo wrongquestionlist(@RequestBody JSONObject param) {
		//该学生答的该试卷的答题情况
		ExamStudentListDetail esld = new ExamStudentListDetail();
		
		//该学生答的该试卷
		ExamStudentList esl = new ExamStudentList();
		if (param.get("paperid") != null) {
			esl.setPaperid(param.get("paperid").toString());
			esld.setPaperid(param.get("paperid").toString());
		}
		if (param.get("studentid") != null) {
			esl.setStudentid(param.get("studentid").toString());
			esld.setStudentid(param.get("studentid").toString());
		}
		//查到的该试卷
		List<ExamStudentList> esllist = examStudentListService.selectExamStudentListList(esl);
		if (esllist.size() == 1) {
			esl = esllist.get(0);
		}
		//查找错题条件
		esld.setIswrong("1");
		//查到的该试卷的错题
		List<ExamStudentListDetail> esldlist = examStudentListDetailservice.selectExamStudentListDetailList(esld);
		//给每道错题详情追加四个选项
		for(ExamStudentListDetail esld_ : esldlist) {
			ExamSubjectJudgement ex = examSubjectJudgementService.selectExamSubjectJudgementById(esld_.getQuestionid());			
			ExamSubjectOption oprion = new ExamSubjectOption();
			oprion.setSubjectChoicesId(ex.getId());
			List<ExamSubjectOption> list =  examSubjectOptionService.selectExamSubjectOptionList(oprion);
			JSONArray esolist = new JSONArray();
			for (ExamSubjectOption examSubjectOption : list) {
				JSONObject object = new JSONObject();
				object.put("name", examSubjectOption.getOptionName());
				object.put("content", examSubjectOption.getOptionContent());
				object.put("creator", examSubjectOption.getCreator());
				ExamSubjectOptionOption optiono = new ExamSubjectOptionOption();
				optiono.setSubjectChoicesId(examSubjectOption.getId());
				List<ExamSubjectOptionOption> optionOptions =  examSubjectOptionOptionService.selectExamSubjectOptionOptionList(optiono);
				JSONArray jsonArray = new JSONArray();
				for (int j = 0; j < optionOptions.size(); j++) {
					jsonArray.add(optionOptions.get(j));
				}
				object.put("next", jsonArray);
				esolist.add(object);
			}
			ex.setEsolist(esolist);	
			esld_.setEsj(ex);
			esld_.setTotal(esl.getTotal());
		}
		return getDataTable(esldlist);
	}
	
	/**
	 * 个人中心-我的课程
	 * */
	@ResponseBody
    @RequestMapping(value="/mycourse/list")
    public TableDataInfo mycourse(@RequestBody JSONObject param) {
		int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
		Schoolstudentslist student = new Schoolstudentslist();
		if (param.get("id") != null) {
			student.setId(Long.valueOf(param.get("id").toString()));
		}
		List<Schoolstudentslist> stulist = schoolstudentslistService.selectSchoolstudentslistList(student);
		Schoolstudentslist stu = new Schoolstudentslist();
		if (stulist.size() == 1) {
			stu = stulist.get(0);
		}
    	PageHelper.startPage(pageNum, pageSize, null);
		Coursemanagement course = new Coursemanagement();
		course.setSbid(stu.getSbid());
		course.setSsid(stu.getSsid());
		course.setGrade(stu.getNianji());
		List<Coursemanagement> courselist = coursemanagementService.selectCoursemanagementList(course);
		return getDataTable(courselist);
	}
	
	/**
	 * 个人中心-我收藏的教师
	 * */
	@ResponseBody
    @RequestMapping(value="/myteacher/list")
    public TableDataInfo myteacherlist(@RequestBody JSONObject param) {
        int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
		TeachingInfo teachingInfo = new TeachingInfo();
		if (param.get("collectionstu") != null) {
			teachingInfo.setCollectionstu(param.get("collectionstu").toString());
		}
    	PageHelper.startPage(pageNum, pageSize, null);
        List<TeachingInfo> teacherlist = teachingInfoService.selectTeachingInfoList(teachingInfo);
        return getDataTable(teacherlist);
	}
	
	/**
	 * 收藏
	 * */
	@ResponseBody
    @RequestMapping(value="/collection/save")
    public AjaxResult collectionsave(@RequestBody JSONObject param) {
		Usercollection collection = new Usercollection();
		if (param.get("userid") != null) {
			collection.setUserid(param.get("userid").toString());
		}
		if (param.get("collectionid") != null) {
			collection.setCollectionid(param.get("collectionid").toString());
		}
		if (param.get("collectiontype") != null) {
			collection.setCollectiontype(param.get("collectiontype").toString());
		}
		usercollectionSercice.insertUsercollection(collection);
		return AjaxResult.success(true);
	}
	
	/**
	 * 取消收藏
	 * */
	@ResponseBody
    @RequestMapping(value="/collection/cancel")
    public AjaxResult collectioncancel(@RequestBody JSONObject param) {
		Usercollection collection = new Usercollection();
		if (param.get("userid") != null) {
			collection.setUserid(param.get("userid").toString());
		}
		if (param.get("collectionid") != null) {
			collection.setCollectionid(param.get("collectionid").toString());
		}
		if (param.get("collectiontype") != null) {
			collection.setCollectiontype(param.get("collectiontype").toString());
		}
		usercollectionSercice.updateUsercollection(collection);
		return AjaxResult.success(true);
	}
	
	@PostMapping("/schoolController/applogin")
	@ResponseBody
	public AjaxResult ajaxAppLogin(@RequestBody JSONObject requestParams) {
		
		System.out.println(requestParams);
		
		Map<String, Object> map =new HashMap<String, Object>();
		String username = (String) requestParams.get("username");
		String password = (String) requestParams.get("password");
		//true
		String rememberMe = (String) requestParams.get("rememberMe");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			SysUser users = userService.selectUserByLoginName(token.getUsername());
			users.setPassword(null);
			users.setSalt(null);
			String sessionid = subject.getSession().getId().toString();
			users.setToken(sessionid);
//			Md5Hash md5s = new Md5Hash(username + password + sessionid);
//			String onlyid = md5s.toHex();
			users.setPassword(null);
			List<SysRole> roles = users.getRoles();
			if(roles.size() == 1) {
				Long roleId=  roles.get(0).getRoleId();
				if(roleId==4) {
					//教师
					TeachingInfo teachingInfo =new TeachingInfo();
					teachingInfo.setUserId(users.getUserId());
					List<TeachingInfo> teachingInfoList= teachingInfoService.selectTeachingInfoList(teachingInfo);
					if(teachingInfoList.size()>0) {
						map.put("teachingInfo", teachingInfoList.get(0));
					}
				}else if(roleId==5){
					//学生
					Schoolstudentslist schoolstudentslist =new Schoolstudentslist();
					schoolstudentslist.setUserId(users.getUserId());
					List<Schoolstudentslist> schoolstudentslistList=
							schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
						map.put("schoolstudentslist", schoolstudentslistList.get(0));
						if(schoolstudentslistList.size()>0) {
					}
				}
				/*if (roleId != 5) {
					return AjaxResult.success("您无权限登陆客户端！");
				}*/
				
			}
			map.put("users", users);
			
			SysUserOnline userOnline = new SysUserOnline();
			userOnline.setLoginName(users.getLoginName());
			List<SysUserOnline> listuseronline = userOnlineService.selectUserOnlineList(userOnline );
			
			for (int i = 0; i < listuseronline.size(); i++) {
				userOnlineService.deleteOnlineById(listuseronline.get(i).getSessionId());
			}
			
			SysUserOnline online = new SysUserOnline();
			online.setSessionId(sessionid);
			online.setLoginName(users.getLoginName());
			online.setStartTimestamp(new Date());
			online.setLastAccessTime(new Date());
			online.setExpireTime((long) 1800000);
			userOnlineService.saveOnline(online);
			
			return AjaxResult.success(map);
		} catch (AuthenticationException e) {
			String msg = "用户或密码错误";
			if (StringUtils.isNotEmpty(e.getMessage())) {
				msg = e.getMessage();
			}
			return AjaxResult.error(msg);
		}
	}
	
	@PostMapping("/schoolController/logout")
	@ResponseBody
	public AjaxResult ajaxlogout(String token) {
		userOnlineService.deleteOnlineById(token);
		return AjaxResult.success();
	}
	
}
