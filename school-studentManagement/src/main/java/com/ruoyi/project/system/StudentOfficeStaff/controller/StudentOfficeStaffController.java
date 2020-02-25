package com.ruoyi.project.system.StudentOfficeStaff.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.FontText;
import com.ruoyi.common.utils.drawImg;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.project.system.SchoolBelong.domain.SchoolBelong;
import com.ruoyi.project.system.SchoolBelong.service.ISchoolBelongService;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.CertificateManagement;
import com.ruoyi.system.domain.Studentstatuslist;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ICertificateManagementService;
import com.ruoyi.system.service.IStudentstatuslistService;
import com.ruoyi.system.service.ISysUserService;

/**
 * 学生列Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/StudentOfficeStaff")
public class StudentOfficeStaffController extends BaseController
{
	
    private String prefix = "system/StudentOfficeStaff";
    
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;
    @Autowired
    private IStudentstatuslistService studentstatuslistService;
    
    @Autowired
    private ISchoolClassService schoolClassService;
    @Autowired
    private ISchoolgradelistService schoolgradelistService;
    @Autowired
    private ICertificateManagementService certificateManagementService;
    @Autowired
    private ISchoolBelongService schoolBelongService;
    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;
    @Autowired
    private ISysUserService userservice;
    @Autowired
    private SysPasswordService passwordService;
    /**
     	* 迎新管理
     * @return
     */
    
    @RequiresPermissions("system:studentofficestaff:view")
    @GetMapping("/welcome")
    public String welcome()
    {
        return prefix + "/studentofficestafflistWelcome";
    }
    
    /**
     * 就业管理
     * */
    @RequiresPermissions("system:studentofficestaff:jiuye")
    @GetMapping("/jiuye")
    public String jiuye()
    {
        return prefix + "/jiuye";
    }
    

    /**
     * 就业信息填报页
     * */
    @GetMapping("/jiuye/{id}")
    public String jiuye(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
        return prefix + "/jiuye_";
    }
    
    /**
     * 毕业生跟踪
     * */
    @GetMapping("/genzong/{id}")
    public String genzong(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
        return prefix + "/genzong";
    }
    
    /**
     * 就业信息审核列表页
     * */
    @RequiresPermissions("system:studentofficestaff:jiuyeshenhe")
    @GetMapping("/jiuyeshenhe")
    public String jiuyeshenhe()
    {
        return prefix + "/jiuyeshenhe";
    }
    
    /**
     * 就业信息审核页
     * */
    @GetMapping("/jiuyeshenhe/{id}")
    public String jiuyeshenhe(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
        return prefix + "/jiuyeshenhe_";
    }
    
    /**
     * 就业信息查询列表页
     * */
    @RequiresPermissions("system:studentofficestaff:jiuyechaxun")
    @GetMapping("/jiuyechaxun")
    public String jiuyechaxun(ModelMap mmap)
    {
    	SchoolClass sclass = new SchoolClass();
    	List<SchoolClass> classlist = schoolClassService.selectSchoolClassList(sclass);
    	mmap.put("classlist", classlist);
        return prefix + "/jiuyechaxun";
    }
    
    /**
     * 查看历史信息列表页
     * */
    @RequiresPermissions("system:studentofficestaff:history")
    @GetMapping("/history")
    public String history(ModelMap mmap)
    {
    	SchoolClass sclass = new SchoolClass();
    	List<SchoolClass> classlist = schoolClassService.selectSchoolClassList(sclass);
    	mmap.put("classlist", classlist);
        return prefix + "/history";
    }
    
    /**
     * 毕业去向查询
     * */
    @RequiresPermissions("system:studentofficestaff:quxiang")
    @GetMapping("/quxiang")
    public String quxiang(ModelMap mmap)
    {
    	SchoolClass sclass = new SchoolClass();
    	List<SchoolClass> classlist = schoolClassService.selectSchoolClassList(sclass);
    	mmap.put("classlist", classlist);
        return prefix + "/quxiang";
    }
   
    @RequiresPermissions("system:schoolstudentslist:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
    	ExcelUtil<Schoolstudentslist> util = new ExcelUtil<Schoolstudentslist>(Schoolstudentslist.class);
    	List<Schoolstudentslist> userList = util.importExcel(file.getInputStream());
    	if (userList.size() > 6000) {
    		return AjaxResult.error("一次性最多可导入6000条");
    	}
    	String message = schoolstudentslistService.importStudent(userList);
    	return AjaxResult.success(message);
    }
    
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:studentofficestaff:list")
    @PostMapping("/listWelcome")
    @ResponseBody
    public TableDataInfo listWelcome(Schoolstudentslist schoolstudentslist)
    {
    	
//    	schoolstudentslist.setApprovalstate("1");
//    	schoolstudentslist.setState("2");
//    	schoolstudentslist.setRemark14("1");
    	schoolstudentslist.setApprovalstate("2");
    	schoolstudentslist.setState("2");
//    	DateUtils.getYear()
    	schoolstudentslist.setAdmissionTime("2019-" + "10");
        startPage();
        List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
        return getDataTable(list);
    }
    
    /**
     * 批量导入
     * @return
     */
    @PostMapping("/daoru")
    @ResponseBody
    public AjaxResult daoru()
    {
    	Schoolstudentslist schoolstudentslist = new Schoolstudentslist();
    	schoolstudentslist.setApprovalstate("2");
    	schoolstudentslist.setState("2");
    	schoolstudentslist.setAdmissionTime("2019-" + "10");
        List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
    	
        List<SysUser> sulist = new ArrayList<SysUser>();
        
        
    	for(int i=0; i<list.size(); i++) {
    		Schoolstudentslist stu = list.get(i);
    		SysUser su = new SysUser();
        	su.setDeptId(103L);
        	su.setLoginName(stu.getCardnum());
        	su.setUserName(stu.getStudentsName());
        	
        	su.setSalt(ShiroUtils.randomSalt());
        	su.setPassword(passwordService.encryptPassword(su.getLoginName(), "123456", su.getSalt()));
        	
        	sulist.add(su);
        	
    	}
    	

    	int result = userservice.insertUserList(sulist);
        return toAjax(true);
    }
    
    /**
     * 在校管理
     * @return
     */
    
    @RequiresPermissions("system:studentofficestaffSchoolmanagement:view")
    @GetMapping("/Schoolmanagement")
    public String Schoolmanagement()
    {
    	return prefix + "/Schoolmanagement";
    }
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:studentofficestaffSchoolmanagement:list")
    @PostMapping("/listSchoolmanagement")
    @ResponseBody
    public TableDataInfo Schoolmanagement(Schoolstudentslist schoolstudentslist)
    {
    	schoolstudentslist.setApprovalstate("2");
    	schoolstudentslist.setState("0");
    	startPage();
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
    	return getDataTable(list);
    }
    /**
     * 异动管理
     * @return
     */
    
    @RequiresPermissions("system:studentofficestaffTransaction:view")
    @GetMapping("/Transaction")
    public String Transaction()
    {
    	return prefix + "/Transaction";
    }
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:studentofficestaffTransaction:list")
    @PostMapping("/listTransaction")
    @ResponseBody
    public TableDataInfo Transaction(Schoolstudentslist schoolstudentslist)
    {
    	
    	schoolstudentslist.setApprovalstate("2");
    	schoolstudentslist.setState("3");
    	startPage();
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
    	return getDataTable(list);
    }
    /**
     * 离校管理
     * @return
     */
    @RequiresPermissions("system:studentofficestaffLeavingschool:view")
    @GetMapping("/Leavingschool")
    public String Leavingschool(ModelMap mmap)
    {
    	Schoolgradelist g = new Schoolgradelist();
    	SchoolClass c = new SchoolClass();
    	List<Schoolgradelist> glist = schoolgradelistService.selectSchoolgradelistList(g);
    	List<SchoolClass> clist = schoolClassService.selectSchoolClassList(c);
    	mmap.put("classlist", clist);
    	mmap.put("gradelist", glist);
    	return prefix + "/Leavingschool";
    }
    /**
     * 离校办理
     * */
    @GetMapping("/lixiaobanli/{id}")
    public String lixiaobanli(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
        return prefix + "/lixiaobanli_";
    }
     /**
     * 离线办理
     * */
    @GetMapping("/lixianbanli/{id}")
    public String lixianbanli(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
        return prefix + "/lixianbanli_";
    }
    /**
    * 离校办理进度统计
    * */
   @GetMapping("/jindu")
   public String jindu(ModelMap mmap)
   {

   	Schoolgradelist g = new Schoolgradelist();
   	SchoolClass c = new SchoolClass();
   	List<Schoolgradelist> glist = schoolgradelistService.selectSchoolgradelistList(g);
   	List<SchoolClass> clist = schoolClassService.selectSchoolClassList(c);
   	mmap.put("classlist", clist);
   	mmap.put("gradelist", glist);
       return prefix + "/jindu";
   }
   /**
   * 离校进度统计
   * */
  @GetMapping("/lixiaojindu")
  public String lixiaojindu(ModelMap mmap)
  {
      return prefix + "/lixiaojindu";
  }
  @ResponseBody
  @RequestMapping(value="/group", method = RequestMethod.GET)
  public JSONObject group(@RequestParam("gradeId") String gradeId)
  {
	  System.out.println(gradeId);
	  JSONObject o = new JSONObject();
	  o.put("adf", schoolstudentslistService.group(gradeId));
      return o;
  }
  @ResponseBody
  @RequestMapping(value="/group2", method = RequestMethod.GET)
  public JSONObject group2(@RequestParam("type") String type)
  {
	  System.out.println(type);
	  JSONObject o = new JSONObject();
	  o.put("adf", schoolstudentslistService.group2());
	  o.put("adf1", schoolstudentslistService.group3());
      return o;
  }
  
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:studentofficestaffLeavingschool:list")
    @PostMapping("/listLeavingschool")
    @ResponseBody
    public TableDataInfo Leavingschool(Schoolstudentslist schoolstudentslist)
    {
    	schoolstudentslist.setApprovalstate("2");
    	schoolstudentslist.setState("4");
    	startPage();
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
    	return getDataTable(list);
    }
    /**
     * 结业管理
     * @return
     */
    
    @RequiresPermissions("system:studentofficestaffGraduation:view")
    @GetMapping("/Graduation")
    public String Graduation(ModelMap mmap)
    {
    	
    	
    	List<Studentstatuslist> sl = studentstatuslistService.selectStudentstatuslistList(null);
    	
    	List<CertificateManagement> list = certificateManagementService.selectCertificateManagementList(null);
		mmap.put("certificateManagement", list);
		mmap.put("studentstatuslists", sl);
    	
    	return prefix + "/Graduation";
    }
    @RequiresPermissions("system:studentofficestaffsetstudentstatus:view")
    @GetMapping("/setstudentstatus/{id}")
    public String setstudentstatus(@PathVariable("id") Long id,ModelMap mmap)
    {
    	mmap.put("id", id);
    	
    	
    	
    	return prefix + "/setstudentstatus";
    }
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:studentofficestaffGraduation:list")
    @PostMapping("/listGraduation")
    @ResponseBody
    public TableDataInfo Graduation(Schoolstudentslist schoolstudentslist)
    {
    	schoolstudentslist.setApprovalstate("2");
    	schoolstudentslist.setState("5");
    	startPage();
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
    	return getDataTable(list);
    }
    @RequiresPermissions("system:uploadCer:view")
    @GetMapping("/uploadCer/{id}")
    public String uploadCer(@PathVariable("id") Long id, ModelMap mmap)
    {
    	mmap.put("studentId", id);
		CertificateManagement certificateManagement = new CertificateManagement();
		certificateManagement.setStudentsId(id+"");
		List<CertificateManagement> list = certificateManagementService.selectCertificateManagementList(certificateManagement );
		if (list.size() > 0) {
			mmap.put("certificateManagement", list.get(0));
			return "system/certificateManagement/edit";
		}
		return "system/certificateManagement/add";
    }
    
    @GetMapping("/listGraduation/download/{userid}")
    public void resourceDownload(@PathVariable("userid")String userid, HttpServletRequest request, HttpServletResponse response)
    		throws Exception
    {
    	
    	String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
    	response.setCharacterEncoding("utf-8");
    	 String fileName = "certificate.jpg";
         fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
         response.setCharacterEncoding("utf-8");
         response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    	
    	
    	Schoolstudentslist sinformaction = schoolstudentslistService.selectSchoolstudentslistById(Long.parseLong(userid));
		FontText text = new FontText(sinformaction.getStudentsName(), 1, "#CC2BAC", 25, "黑体");
		String filePath = path + "static/img/inimg03.jpg";
		BufferedImage imgsg = drawImg.drawInImgs(filePath, text);
		ServletOutputStream out = response.getOutputStream();
		ByteArrayOutputStream byteArrayOutputStream = new  ByteArrayOutputStream();
		ImageIO.write(imgsg, "jpg", byteArrayOutputStream);
		byteArrayOutputStream.flush();
		byte[] byteArray = byteArrayOutputStream.toByteArray();	
		out.write(byteArray);
		out.flush();
		out.close();
    }
    
    /**
     * 校友管理
     * @return
     */
    
    @RequiresPermissions("system:studentofficestaffAlumnus:view")
    @GetMapping("/Alumnus")
    public String Alumnus()
    {
    	return prefix + "/Alumnus";
    }
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:studentofficestaffAlumnus:list")
    @PostMapping("/listAlumnus")
    @ResponseBody
    public TableDataInfo Alumnus(Schoolstudentslist schoolstudentslist)
    {
    	
    	schoolstudentslist.setState("2");
    	startPage();
    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistListnotid(schoolstudentslist);
    	return getDataTable(list);
    }
    /**
     * 入学办理
     * */
    @GetMapping("/ruxue/{id}")
    public String ruxue(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	SchoolBelong sb = new SchoolBelong();
    	List<SchoolBelong> sblist = schoolBelongService.selectSchoolBelongList(sb);
    	mmap.put("sblist", sblist);
    	return prefix + "/ruxue";
    }
    

    /**
     * 搜索学院下的专业
     * */
    @GetMapping("/zhuanye/{id}")
    @ResponseBody
    
    public List<SchoolSpecialty> zhuanye(@PathVariable("id") Long id)
    {
    	SchoolSpecialty schoolSpecialty = new SchoolSpecialty();
    	schoolSpecialty.setBelongId(id);
        List<SchoolSpecialty> list = schoolSpecialtyService.selectSchoolSpecialtyList(schoolSpecialty);
        return list;
    }

}
