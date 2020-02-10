package com.ruoyi.project.app;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.FontText;
import com.ruoyi.common.utils.MapTrunPojo;
import com.ruoyi.common.utils.drawImg;
import com.ruoyi.project.system.ClasscurriculumDetail.domain.ClasscurriculumDetail;
import com.ruoyi.project.system.ClasscurriculumDetail.service.IClasscurriculumDetailService;
import com.ruoyi.project.system.classcurriculum.domain.Classcurriculum;
import com.ruoyi.project.system.classcurriculum.service.IClasscurriculumService;
import com.ruoyi.project.system.classschedulingmanagement.domain.Classschedulingmanagement;
import com.ruoyi.project.system.classschedulingmanagement.service.IClassschedulingmanagementService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolResult.domain.SchoolResult;
import com.ruoyi.project.system.schoolResult.service.ISchoolResultService;
import com.ruoyi.project.system.schoolResultDetail.domain.SchoolResultDetail;
import com.ruoyi.project.system.schoolResultDetail.service.ISchoolResultDetailService;
import com.ruoyi.project.system.schoolenrollmentmanagement.domain.Schoolenrollmentmanagement;
import com.ruoyi.project.system.schoolenrollmentmanagement.service.ISchoolenrollmentmanagementService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;

//用户端信息
@CrossOrigin
@Controller
@RequestMapping("/uajax/app/student")
public class AppHomeStudentController {

	@Autowired
	private ISchoolenrollmentmanagementService schoolenrollmentmanagementService;
	@Autowired
	private ISchoolstudentslistService schoolstudentslistService;
	@Autowired
	private ISchoolResultDetailService schoolResultDetailService;
	@Autowired
	private ISchoolResultService schoolResultService;
	@Autowired
	private ISysUserOnlineService userOnlineService;
	@Autowired
	private ISysUserService userService;
	@Autowired
	private ISchoolClassService schoolClassService;

	@Autowired
	private IClassschedulingmanagementService classschedulingmanagementService;
	@Autowired
	private IClasscurriculumService classcurriculumService;
	@Autowired
	private IClasscurriculumDetailService classcurriculumDetailService;
	@Autowired
	private ICoursemanagementService coursemanagementService;
	
	
	/**
	 * 
	 * 查询学员培训项目
	 * 
	 * @param schoolstudentslist
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/studentproject")
	public AjaxResult yanzheng(String token) {

		SysUser user = checkuserLogin(token);
		if (user == null) {
			return AjaxResult.error("用户未登录");
		}

		List<Schoolenrollmentmanagement> schoolen = schoolenrollmentmanagementService
				.selectSchoolenrollmentmanagementList(null);

		/**
		 * 
		 * 查询为开始的 项目
		 * 
		 * 后期需要修改
		 */
		int num = -1;
		for (int i = 0; i < schoolen.size(); i++) {
			Schoolenrollmentmanagement sa = schoolen.get(i);
			Date d1 = sa.getAdmissionTime();

			Date date = new Date();

			if (date.getTime() < d1.getTime()) {
				num = i;
				break;
			}
		}
		if (num != -1) {
			return AjaxResult.success(schoolen.get(num));
		} else {
			return AjaxResult.success("暂无项目！");
		}

	}

	/**
	 * 
	 * 在线缴费支付
	 * 
	 * @param studentid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/billpayment")
	public AjaxResult pay(String token) {
		SysUser user =  checkuserLogin(token);
		if (user == null) {
			return AjaxResult.error("用户未登录");
		}
		return AjaxResult.success("暂未开通测功能");
	}

	/**
	 * 
	 * 查询开始成绩
	 * 
	 * @param studentid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Queryexamresults")
	public AjaxResult queryexamresults(String token) {

		SysUser user = checkuserLogin(token);
		if (user == null) {
			return AjaxResult.error("用户未登录");
		}
		
		Schoolstudentslist schoolstudentslist = new Schoolstudentslist();
		schoolstudentslist.setStudentsId(user.getLoginName());
		List<Schoolstudentslist> stlist = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
		if (stlist.size() <= 0) {
			return AjaxResult.success("无此学生");
		}
		 
		SchoolResultDetail schoolResultDetail = new SchoolResultDetail();
		schoolResultDetail.setStudentsId(stlist.get(0).getId());
		List<SchoolResultDetail> sr = schoolResultDetailService.selectSchoolResultDetailList(schoolResultDetail);
		List<SchoolResult> srs = schoolResultService.selectSchoolResultList(null);

		JSONArray array = new JSONArray();
		for (int i = 0; i < sr.size(); i++) {
			SchoolResultDetail detail = sr.get(i);
			for (int j = 0; j < srs.size(); j++) {
				SchoolResult result = srs.get(j);
				if (result.getId() == detail.getResultId()) {
					Map map = MapTrunPojo.object2Map(detail);
					map.put("SchoolResult", result);
					array.add(map);
				}
			}
		}

		return AjaxResult.success(array);
	}

	/**
	 * 
	 * 查询证书
	 * 
	 * @param studentid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Querycertificate")
	public void querycertificate(HttpServletResponse res, String token) {
		SysUser user = checkuserLogin(token);
		if (user == null) {
			return;
		}
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		System.out.println(path);
		res.setContentType("image/jpeg");
		
		
		Schoolstudentslist schoolstudentslist = new Schoolstudentslist();
		List<Schoolstudentslist> sinformaction = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist );
		
		if (sinformaction.size() <= 0) {
			return;
		}
		
		FontText text = null;
		try {
			text = new FontText(new String(sinformaction.get(0).getStudentsName().getBytes("utf8"),"utf8"), 1, "#CC2BAC", 25, "黑体");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath = path + "static/img/inimg03.jpg";
		BufferedImage imgsg = drawImg.drawInImgs(filePath, text);
		try {
			ImageIO.write(imgsg, "JPEG", res.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 管理个人信息
	 * 
	 * @param studentid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Studentinformation")
	public AjaxResult Studentinformation(String token) {
		SysUser user = checkuserLogin(token);

		if (user == null) {
			return AjaxResult.error("用户未登录");
		}
		Schoolstudentslist schoolstudentslist = new Schoolstudentslist();
		schoolstudentslist.setStudentsId(user.getLoginName()+"");
		List<Schoolstudentslist> sinformaction = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
		if (sinformaction.size() > 0) {
			return AjaxResult.success(sinformaction.get(0));
		}else {
			return AjaxResult.success("无此学生信息");
		}
	}
	/**
	 * 
	 * 管理个人课程
	 * 
	 * @param studentid
	 * @return
	 */
	
	 
	@ResponseBody
	@RequestMapping(value = "/curriculuminformation")
	public AjaxResult curriculuminformation(String token) {
		SysUser user = checkuserLogin(token);
		if (user == null) {
			return AjaxResult.error("用户未登录");
		}
		Schoolstudentslist schoolstudentslist = new Schoolstudentslist();
		schoolstudentslist.setStudentsId(user.getLoginName()+"");
		List<Schoolstudentslist> sinformaction = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
		
		
		
		if (sinformaction.size() > 0) {
			//班级
			SchoolClass sc = schoolClassService.selectSchoolClassById(sinformaction.get(0).getClassId());
			//排课
			Classschedulingmanagement classschedulingmanagement = new Classschedulingmanagement();
			classschedulingmanagement.setClassId(sinformaction.get(0).getClassId()+"");
			List<Classschedulingmanagement> cssc = classschedulingmanagementService.selectClassschedulingmanagementList(classschedulingmanagement);
			
			
			//排课详情
			List<Classcurriculum> ccsall =new ArrayList<Classcurriculum>();
			for (int i = 0; i < cssc.size(); i++) {
				Classschedulingmanagement classschedulingmanagement2 = cssc.get(i);
				Classcurriculum classcurriculum = new Classcurriculum();
				classcurriculum.setClassschedulingmanagementId(classschedulingmanagement2.getId()+"");
				List<Classcurriculum> ccs = classcurriculumService.selectClasscurriculumList(classcurriculum);
				ccsall.addAll(ccs);
			}
			//排课-课程表
			List<ClasscurriculumDetail> ccudall = new ArrayList<ClasscurriculumDetail>();
			for (int i = 0; i < ccsall.size(); i++) {
				ClasscurriculumDetail classcurriculumDetail = new ClasscurriculumDetail();
				classcurriculumDetail.setCuurriculumId(ccsall.get(i).getId());
				List<ClasscurriculumDetail> ccud = classcurriculumDetailService.selectClasscurriculumDetailList(classcurriculumDetail);
				ccudall.addAll(ccud);
			}
			
//			课程表去重 == 科目
			Set<Long> set = new HashSet<Long>();
			for (int i = 0; i < ccudall.size(); i++) {
				if (ccudall.get(i).getCoursemanagementId() != null) {
					set.add(ccudall.get(i).getCoursemanagementId());
				}
			}
			
			//获取科目 
			Iterator<Long> it = set.iterator();
			List<Coursemanagement> coursemanagements = new ArrayList<Coursemanagement>();
			while (it.hasNext()) {
				Long l =  it.next();
				Coursemanagement cm = coursemanagementService.selectCoursemanagementById(l);
				coursemanagements.add(cm);
			}
			return AjaxResult.success(coursemanagements);
		}else {
			return AjaxResult.success("无此学生信息");
		}
	}
	
	public SysUser checkuserLogin(String token) {
		SysUserOnline useron = userOnlineService.selectOnlineById(token);
		if (useron != null) {
			
			System.out.println(useron.getSessionId());
			
			Date d1 = useron.getLastAccessTime();
			Long l3 = useron.getExpireTime();
			Date date = new Date();
			long l2 = d1.getTime();
			long l1 =  date.getTime();
			boolean flag = (l1 - l2) > l3;
			System.out.println("flag="+flag);
			if (flag) {
				return null;
			}
			useron.setLastAccessTime(new Date());
			userOnlineService.saveOnline(useron);
			SysUser user = userService.selectUserByLoginName(useron.getLoginName());
			return user;
		}
		return null;
	}

}
