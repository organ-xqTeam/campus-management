package com.ruoyi.project.app;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.CodeMsg;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MapObjectUtil;
import com.ruoyi.common.utils.RegUtil;
import com.ruoyi.common.utils.Result;
import com.ruoyi.project.system.ClasscurriculumDetail.domain.ClasscurriculumDetail;
import com.ruoyi.project.system.ClasscurriculumDetail.service.IClasscurriculumDetailService;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.schoolHomework.domain.SchoolHomework;
import com.ruoyi.project.system.schoolHomework.service.ISchoolHomeworkService;
import com.ruoyi.project.system.schoolHomeworkDetail.domain.SchoolHomeworkDetail;
import com.ruoyi.project.system.schoolHomeworkDetail.service.ISchoolHomeworkDetailService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysUserService;


//用户端信息
@CrossOrigin
@Controller
@RequestMapping("/uajax/app/appHomeWork")
public class AppHomeWorkController extends BaseController {
    @Autowired
    private ISysUserService userService ;
	@Autowired
	private ISchoolHomeworkDetailService homeworkDetailService;
	@Autowired
	private ISchoolHomeworkService homeworkService;
	@Autowired
	private ISchoolstudentslistService schoolstudentslistService;
	@Autowired
	private ICoursemanagementService  coursemanagementService; 
	@Autowired
	private IClasscurriculumDetailService classcurriculumDetailService;
	@Autowired
	private ISchoolSpecialtyService schoolSpecialtyService;
	@Autowired
	private ISysDictDataService sysDictDataService; 
	
	//学生作业打卡接口
	@ResponseBody
	@RequestMapping(value = "/daka")
	public Object  daka( @RequestBody Map<String, Object> requestParams) {
		try {
			String token =requestParams.get("token").toString();
			//学生的id
			String userid =requestParams.get("userid").toString();
			//作业详情的id
			String detailId =requestParams.get("detailId").toString();
			//文件的路径或者id
			String fileid =requestParams.get("fileid").toString();
			//文件名称
			String filename =requestParams.get("filename").toString();
			
			SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
			schoolHomeworkDetail.setId(Long.valueOf(detailId));
			schoolHomeworkDetail.setStudentsId(Long.valueOf(userid));
			schoolHomeworkDetail.setFileId(fileid);
			schoolHomeworkDetail.setFileName(filename);
			schoolHomeworkDetail.setDelFlag("0");
//			 homeworkDetailService.updateSchoolHomeworkDetail(schoolHomeworkDetail);
			 return Result.success(CodeMsg.SUCCESS);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return Result.success(CodeMsg.PARAMETER_ISNULL);
		}
	}
	//获取此作业下没完成学生作业打卡的接口
	@ResponseBody
	@RequestMapping(value = "/unDakaStudentOnlyHomeWork")
	public Object unDakaStudentOnlyHomeWork(@RequestBody Map<String, Object> requestParams) throws IllegalAccessException {
		String token =requestParams.get("token").toString();
		//老师的id
		String userid =requestParams.get("userid").toString();
		//作业id
		String homeworkId =requestParams.get("homeworkId").toString();
		Map<String, Object> returnMap = new HashMap<String,Object>();
		SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
		schoolHomeworkDetail.setHomeworkId(Long.valueOf(homeworkId));
		schoolHomeworkDetail.setSubmitFlag("0");
		schoolHomeworkDetail.setDelFlag("0");
		List<Map<String, Object>> unStudentInfoList= new ArrayList<>();
		List<SchoolHomeworkDetail> schoolHomeworkDetailList= homeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
		for (SchoolHomeworkDetail schoolHomeworkDetail2 : schoolHomeworkDetailList) {
			Long studentsId= schoolHomeworkDetail2.getStudentsId();
			Schoolstudentslist schoolstudentslist= schoolstudentslistService.selectSchoolstudentslistById(studentsId);
			Map<String, Object> unStudentInfo= MapObjectUtil.objToMap(schoolstudentslist);
			unStudentInfo.put("studentsId", studentsId);
			unStudentInfo.put("submitFlag", schoolHomeworkDetail2.getSubmitFlag());
			unStudentInfoList.add(unStudentInfo);
		}
		returnMap.put("unStudentInfoList", unStudentInfoList);
		return unStudentInfoList;
	}
	@ResponseBody
	@RequestMapping(value = "/updateSchoolHomeworkDetail")
	public Object updateSchoolHomeworkDetail(@RequestBody Map<String, Object> requestParams) {
		try {
			Map<String, Object> returnMap = new HashMap<String,Object>();
			String token =requestParams.get("token").toString();
			//作业详情的id
			String detailId =requestParams.get("detailId").toString();
			//是否通过
			String passFlag= requestParams.get("passFlag").toString();
			
			SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
			schoolHomeworkDetail.setPassFlag(passFlag);
			schoolHomeworkDetail.setId(Long.valueOf(detailId));
//			homeworkDetailService.updateSchoolHomeworkDetail(schoolHomeworkDetail);
			return Result.success(CodeMsg.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.error(CodeMsg.PARAMETER_ISNULL);
		}
		
		
	}
	
	
	
	
	
	//通过id查看作业详情和学生的完成情况
	//通过作业id获得此作业的信息
		@ResponseBody
		@RequestMapping(value = "/getHomeWorkInfoStuByid")
		public Object getHomeWorkInfoStuByid(HttpServletRequest request, @RequestBody Map<String, Object> requestParams) throws IllegalAccessException, InvocationTargetException {
			try {
				String token =requestParams.get("token").toString();
				String id =requestParams.get("id").toString();
				Map<String, Object> returnMap = new HashMap<String,Object>();
				Map<String, Object> homeWorkInfoonly =new HashMap<String, Object>();
				Map<String, Object> homeWorkInfo =new HashMap<String, Object>();
				SchoolHomework schoolHomework=  homeworkService.selectSchoolHomeworkById(Long.valueOf(id));
				homeWorkInfoonly=MapObjectUtil.objToMap(schoolHomework);
				homeWorkInfo.putAll(homeWorkInfoonly);
				SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
				schoolHomeworkDetail.setHomeworkId(Long.valueOf(id));
				List<SchoolHomeworkDetail> schoolHomeworkDetailList= homeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
				//Set<Schoolstudentslist> SchoolstudentslistSet =new HashSet<>();
				List<Map<String, Object>>  schoolHomeworkDetailInfoList= new ArrayList<>();
				for (SchoolHomeworkDetail schoolHomeworkDetail2 : schoolHomeworkDetailList) {
					homeWorkInfoonly=MapObjectUtil.objToMap(schoolHomeworkDetail2);
					Long studentsId= schoolHomeworkDetail2.getStudentsId();
					Schoolstudentslist schoolstudentslist= schoolstudentslistService.selectSchoolstudentslistById(studentsId);
					//SchoolstudentslistSet.add(schoolstudentslist);
					//homeWorkInfo.putAll(homeWorkInfoonly);
					homeWorkInfoonly.put("schoolstudentslist", schoolstudentslist);
					schoolHomeworkDetailInfoList.add(homeWorkInfoonly);
				}
				
				returnMap.put("homeWorkInfo", homeWorkInfo);
				returnMap.put("schoolHomeworkDetailInfoList", schoolHomeworkDetailInfoList);
				
				return Result.success(returnMap);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Result.error(CodeMsg.PARAMETER_ISNULL);
			}
		}
	//通过教师id得到教师管理下的作业信息
	@ResponseBody
	@RequestMapping(value = "/getAllHomeWorkInfoByTeacherUser")
	public Object getAllHomeWorkInfoByTeacherUser(HttpServletRequest request, @RequestBody Map<String, Object> requestParams) throws IllegalAccessException, InvocationTargetException {
		try {
			String token =requestParams.get("token").toString();
			String userid =requestParams.get("userid").toString();
			Map<String, Object> returnMap = new HashMap<String,Object>();
			List<Map<String, Object>> homeWorkInfoAllList= new ArrayList<>();
			Map<String, Object> homeWorkInfoonly= new HashMap<String,Object>();
			
			//通过老师的id得到所有排课的详情
			ClasscurriculumDetail classcurriculumDetail =new ClasscurriculumDetail();
			classcurriculumDetail.setTeacherId(Long.valueOf(userid));
			List<ClasscurriculumDetail> classcurriculumDetailList= classcurriculumDetailService.selectClasscurriculumDetailList(classcurriculumDetail);
			//得到科目id的set集合
			Set<Long> coursemanagementIdList =new HashSet<>();
			for (ClasscurriculumDetail classcurriculumDetail2 : classcurriculumDetailList) {
				if(classcurriculumDetail2.getCoursemanagementId()!=null) {
					coursemanagementIdList.add(classcurriculumDetail2.getCoursemanagementId());
				}
			}
			List<SchoolHomework> schoolHomeworkList=new ArrayList<>();
			for (Long coursemanagementId : coursemanagementIdList) {
				SchoolHomework schoolHomework =new SchoolHomework();
				//coursemanagementId
				schoolHomework.setCurriculumId(coursemanagementId);
				schoolHomeworkList.addAll(homeworkService.selectSchoolHomeworkList(schoolHomework));
			}
			//遍历作业表
			for (SchoolHomework schoolHomework : schoolHomeworkList) {
				
				Set<Schoolstudentslist> schoolstudentslistSet= new HashSet<>();
				SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
				schoolHomeworkDetail.setHomeworkId(schoolHomework.getId());
				//通过作业表的id 遍历 作业表详情
				List<SchoolHomeworkDetail> SchoolHomeworkDetailList= homeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
				//作业详情表下的学生信息
				for (SchoolHomeworkDetail schoolHomeworkDetail2 : SchoolHomeworkDetailList) {
					if(schoolHomeworkDetail2.getStudentsId()!=null) {
						Schoolstudentslist schoolstudentslist= schoolstudentslistService.selectSchoolstudentslistById(schoolHomeworkDetail2.getStudentsId());
						schoolstudentslistSet.add(schoolstudentslist);
					}
				}
				homeWorkInfoonly=MapObjectUtil.objToMap(schoolHomework);
				homeWorkInfoonly.put("schoolstudentslistcount", schoolstudentslistSet.size());
				homeWorkInfoAllList.add(homeWorkInfoonly);
			}
			returnMap.put("homeWorkInfoAllList", homeWorkInfoAllList);
			
			return Result.success(returnMap);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.error(CodeMsg.PARAMETER_ISNULL);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//得到此学生用户下所有作业信息
	@ResponseBody
	@RequestMapping(value = "/getAllHomeWorkInfoByUser")
	public Object getAllHomeWorkInfoByUser(HttpServletRequest request, @RequestBody Map<String, Object> requestParams) throws IllegalAccessException, InvocationTargetException {
		try {
			String token =requestParams.get("token").toString();
			String userid =requestParams.get("userid").toString();
			Map<String, Object> returnMap = new HashMap<String,Object>();
			List<Map<String, Object>> homeWorkInfoAllList= new ArrayList<>();
			//通过userid得到所有的作业详情
			SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
			schoolHomeworkDetail.setStudentsId(Long.valueOf(userid));
			List<SchoolHomeworkDetail> schoolHomeworkDetailList= homeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
			for (SchoolHomeworkDetail schoolHomeworkDetail2 : schoolHomeworkDetailList) {
				Map<String, Object> homeWorkInfoAll =new HashMap<String, Object>();
				Map<String, Object> homeWorkInfoonly =new HashMap<String, Object>();
				
				Long homeWorkId=schoolHomeworkDetail2.getHomeworkId();
				SchoolHomework schoolHomework=  homeworkService.selectSchoolHomeworkById(homeWorkId);
				//课程id
				Long coursemanagementId= schoolHomework.getCurriculumId();
				Coursemanagement coursemanagement=
				coursemanagementService.selectCoursemanagementById(coursemanagementId);
				//课程便map
				homeWorkInfoonly=MapObjectUtil.objToMap(coursemanagement);
				homeWorkInfoAll.putAll(homeWorkInfoonly);
				//作业详情bianmap
				homeWorkInfoonly=MapObjectUtil.objToMap(schoolHomeworkDetail2);
				homeWorkInfoAll.putAll(homeWorkInfoonly);
				homeWorkInfoonly=MapObjectUtil.objToMap(schoolHomework);
				//作业变map
				homeWorkInfoAll.putAll(homeWorkInfoonly);
				homeWorkInfoAllList.add(homeWorkInfoAll);
				
			}
			returnMap.put("homeWorkInfoAllList", homeWorkInfoAllList);
			
			return Result.success(returnMap);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.error(CodeMsg.PARAMETER_ISNULL);
		}
	}
	
	//通过作业id获得此作业的信息
	@ResponseBody
	@RequestMapping(value = "/getHomeWorkInfoByid")
	public Object getHomeWorkInfoByid(HttpServletRequest request, @RequestBody Map<String, Object> requestParams) throws IllegalAccessException, InvocationTargetException {
		try {
			String token =requestParams.get("token").toString();
			String id =requestParams.get("id").toString();
			Map<String, Object> returnMap = new HashMap<String,Object>();
			Map<String, Object> homeWorkInfoonly =new HashMap<String, Object>();
			Map<String, Object> homeWorkInfo =new HashMap<String, Object>();
			SchoolHomework schoolHomework=  homeworkService.selectSchoolHomeworkById(Long.valueOf(id));
			homeWorkInfoonly=MapObjectUtil.objToMap(schoolHomework);
			homeWorkInfo.putAll(homeWorkInfoonly);
			SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
			schoolHomeworkDetail.setHomeworkId(Long.valueOf(id));
			List<SchoolHomeworkDetail> schoolHomeworkDetailList= homeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
			if(schoolHomeworkDetailList.size()>0) {
				homeWorkInfoonly=MapObjectUtil.objToMap(schoolHomeworkDetailList.get(0));
				homeWorkInfo.putAll(homeWorkInfoonly);
			}
			returnMap.put("homeWorkInfo", homeWorkInfo);
			return Result.success(returnMap);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.error(CodeMsg.PARAMETER_ISNULL);
		}
	}
	/**
	 * 
	 * 学生端 在线报名	
	 * @param schoolstudentslist
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/baoming")
	public Object baoming(@RequestBody Schoolstudentslist schoolstudentslist) {
		
		
		Date da = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		
		String randomNum = System.currentTimeMillis()+"";  
		
//		String studentsId=UUID.randomUUID().toString().replace("-", "").substring(0,6);
		String studentsId="S"+dateFormat.format(da)+randomNum.substring(randomNum.length()-4, randomNum.length());
    	schoolstudentslist.setStudentsId(studentsId);
    	schoolstudentslist.setAdmissionTime(DateUtils.getYear() + "-09-01");
    	schoolstudentslist.setApprovalstate("1");
    	schoolstudentslist.setState("2");
    	schoolstudentslist.setRemark23(DateUtils.getDate());
    	String val = "";
    	Random random = new Random();
    	for (int i = 0; i < 10; i++) {
    		val += String.valueOf(random.nextInt(10));
    	}
    	schoolstudentslist.setBmnum(val);
    	String idnum = schoolstudentslist.getIdnum();
    	String nation = schoolstudentslist.getNation();
    	String code = schoolstudentslist.getCode();
//    	if (!code.equals("1234")) {
//    		return Result.error(CodeMsg.NOT_CODE);
//    	}
    	if (!idnum.matches(RegUtil.reg_idnum)){
    		return Result.error(CodeMsg.NOT_IDNUM);
    	}
    	Schoolstudentslist stuCheckRepeat = new Schoolstudentslist();
    	stuCheckRepeat.setIdnum(schoolstudentslist.getIdnum());
    	List<Schoolstudentslist> stuCheckRepeatList = schoolstudentslistService.selectSchoolstudentslistList(stuCheckRepeat);    	
		if (stuCheckRepeatList.size() != 0) {
    		return Result.error(CodeMsg.REPEAT_IDNUMBER);
		}
    	stuCheckRepeat = new Schoolstudentslist();
    	stuCheckRepeat.setRemark44(schoolstudentslist.getRemark44());
    	stuCheckRepeatList = schoolstudentslistService.selectSchoolstudentslistList(stuCheckRepeat);
    	if (stuCheckRepeatList.size() != 0) {
    		return Result.error(CodeMsg.REPEAT_PHONE);
		}
    	if (nation != null) {
    		boolean flag = true;
    		for(String n : RegUtil.nation) {
    			if (n.equals(nation)) {
    				flag = false;
    			}
    		}
    		if (flag) {
        		return Result.error(CodeMsg.NOT_NATION);
    		}
    	}
    	Schoolstudentslist param = new Schoolstudentslist();
    	param.setIdnum(idnum);
    	List<Schoolstudentslist> stuList = schoolstudentslistService.selectSchoolstudentslistList(param);
    	if (stuList.size() != 0) {
    		return Result.error(CodeMsg.REPEAT_IDNUM);
    	}    			
    	SysUser user= new SysUser();
    	user.setDeptId((long) 103);
		user.setRoleId((long) 5);
    	//岗位 教师
    	Long roleIds[] = {(long)5};
    	user.setRoleIds(roleIds);
    	user.setLoginName(studentsId);
    	user.setUserName(schoolstudentslist.getStudentsName());
    	
    	user.setPassword("123456");
    	user.setCreateBy("admin");
//    	userService.insertUser(user);
    	
        return Result.success(schoolstudentslistService.insertSchoolstudentslist(schoolstudentslist));
	}
	
	@ResponseBody
	@RequestMapping(value = "/editbaoming")
	public Object editbaoming(@RequestBody Schoolstudentslist schoolstudentslist) {
        return Result.success(schoolstudentslistService.updateSchoolstudentslist(schoolstudentslist));
	}
	
	/**
	 * 
	 * 学生端查询在线报名
	 * @param schoolstudentslist
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/yanzheng")
	public Object yanzheng(@RequestBody Schoolstudentslist schoolstudentslist) {
		List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
		if (list.size() != 0) {
			return Result.success(list.get(0));
		}
		else {
			return Result.success("未查到该学员");
		}
	}
	
	@ResponseBody
	@PostMapping(value = "/baomingsl")
	public TableDataInfo baomingsl(@RequestBody JSONObject param) {		
    	int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());		
		SchoolSpecialty ss = new SchoolSpecialty();
    	PageHelper.startPage(pageNum, pageSize, null);		
    	List<SchoolSpecialty> sslist = schoolSpecialtyService.selectSchoolSpecialtyList(ss);    	
    	return getDataTable(sslist);		
	}
	
	@ResponseBody
	@PostMapping(value = "/envir")
	public TableDataInfo envir(@RequestBody JSONObject param) {		
    	int pageNum = Integer.valueOf(param.get("pageNum").toString());
    	int pageSize = Integer.valueOf(param.get("pageSize").toString());
    	PageHelper.startPage(pageNum, pageSize, null);		
    	List<SysDictData> diclist = sysDictDataService.selectDictDataByType("sys_business_variable");    	
    	return getDataTable(diclist);		
	}

}
