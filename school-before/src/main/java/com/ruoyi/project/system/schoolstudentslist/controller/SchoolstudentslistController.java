package com.ruoyi.project.system.schoolstudentslist.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CodeMsg;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.Result;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.project.system.SchoolBelong.domain.SchoolBelong;
import com.ruoyi.project.system.SchoolBelong.service.ISchoolBelongService;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;

/**
 * 学生列Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/schoolstudentslist")
public class SchoolstudentslistController extends BaseController
{
    private String prefix = "system/schoolstudentslist";
    @Autowired
    private ISysUserService userService ;
	@Autowired
	private SysPasswordService passwordService;
    @Autowired
    private ISchoolClassService schoolClassService;
    @Autowired
    private ISchoolBelongService schoolBelongService;
	@Autowired
	private ISchoolSpecialtyService schoolSpecialtyService;
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;
	
    @GetMapping("/editBing/{id}")
    public String editBing(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
        mmap.put("schoolstudentslist", schoolstudentslist);
        SysUser user =new SysUser();
        List<SysUser> userList=  userService.selectUserList(user);
        //List<User> userList =userService.selectunguanlianUserList(user);
        mmap.put("userList", userList);
        return  "system/bindingStudent/edit";
    }
    @RequiresPermissions("system:schoolstudentslist:view")
    @GetMapping()
    public String schoolstudentslist()
    {
        return prefix + "/schoolstudentslist";
    }

    @GetMapping("/daoru/{id}")
    public String daoru(@PathVariable("id") Long id, ModelMap mmap)
    {
    	SchoolClass sc = schoolClassService.selectSchoolClassById(id);
    	mmap.put("class", sc);
    	SchoolBelong sb = new SchoolBelong();
    	List<SchoolBelong> sblist = schoolBelongService.selectSchoolBelongList(sb);
    	mmap.put("sblist", sblist);
        return "system/schoolClass/daoru";
    }
    
    
    @GetMapping("/bindingStudent")
    public String bindingStudent()
    {
        return  "system/bindingStudent/schoolstudentslist";
    }
    
    
    

    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:schoolstudentslist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schoolstudentslist schoolstudentslist)
    {
        startPage();
//        schoolstudentslist.setApprovalstate("2");
        schoolstudentslist.setAdmissionTime(DateUtils.getYear());
        List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
        return getDataTable(list);
    }

    /**
     * 导出学生列列表
     */
    @RequiresPermissions("system:schoolstudentslist:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolstudentslist schoolstudentslist)
    {
        List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);
        ExcelUtil<Schoolstudentslist> util = new ExcelUtil<Schoolstudentslist>(Schoolstudentslist.class);
        return util.exportExcel(list, "招生学生列表");
    }

    /**
     * 新增学生列
     */
    @GetMapping("/add")
    public String add(Schoolstudentslist student, ModelMap map) 
    {
		SchoolSpecialty ss = new SchoolSpecialty();
    	List<SchoolSpecialty> sslist = schoolSpecialtyService.selectSchoolSpecialtyList(ss);   
    	map.put("sslist", sslist);
    	map.put("student", student);
        return prefix + "/add";
    }
    @GetMapping("/vieweditor/{id}")
    public String vieweditor(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	return prefix + "/vieweditor";
    }
    
    @GetMapping("/vieweditor2/{id}")
    public String vieweditor2(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	return prefix + "/vieweditor2";
    }
    
    @GetMapping("/vieweditor3/{id}")
    public String vieweditor3(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	return prefix + "/vieweditor3";
    }
    
    @GetMapping("/vieweditor4/{id}")
    public String vieweditor4(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	return prefix + "/vieweditor4";
    }
    
    @GetMapping("/showview/{id}/{type}")
    public String showview(@PathVariable("id") Long id,@PathVariable("type") Long type, ModelMap mmap)
    {
    	Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
    	mmap.put("schoolstudentslist", schoolstudentslist);
    	return prefix + "/showview" + type;
    }

    /**
     * 新增保存学生列
     */
    @RequiresPermissions("system:schoolstudentslist:add")
    @Log(title = "学生列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolstudentslist schoolstudentslist)
    {
    	Date da = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String randomNum = System.currentTimeMillis()+"";  
    	String studentsId="S"+dateFormat.format(da)+randomNum.substring(randomNum.length()-4, randomNum.length());
    	schoolstudentslist.setStudentsId(studentsId);
    	
//    	SysUser user= new SysUser();
//    	user.setDeptId((long) 103);
//		user.setRoleId((long) 5);
//    	//岗位 教师
//    	Long roleIds[] = {(long)5};
//    	user.setRoleIds(roleIds);
//    	user.setLoginName(studentsId);
//    	user.setUserName(schoolstudentslist.getStudentsName());
//    	
//    	user.setPassword("123456");
//    	user.setCreateBy("admin");
//    	userService.insertUser(user);
//    	user=  userService.selectUserList(user).get(0);
//    	schoolstudentslist.setUserId(user.getUserId());
    	
    	
//    	schoolstudentslist.setApprovalstate("1");
//    	schoolstudentslist.setState("2");
    	
    	schoolstudentslist.setClassId(0L);
    	
    	//身份证与手机的校验
    	Schoolstudentslist stuCheckRepeat = new Schoolstudentslist();
    	stuCheckRepeat.setIdnum(schoolstudentslist.getIdnum());
    	List<Schoolstudentslist> stuCheckRepeatList = schoolstudentslistService.selectSchoolstudentslistList(stuCheckRepeat);    	
		if (stuCheckRepeatList.size() != 0) {
//    		return Result.error(CodeMsg.REPEAT_IDNUMBER);
			return AjaxResult.error(CodeMsg.REPEAT_IDNUMBER.getMsg());
		}
    	stuCheckRepeat = new Schoolstudentslist();
    	stuCheckRepeat.setRemark44(schoolstudentslist.getRemark44());
    	stuCheckRepeatList = schoolstudentslistService.selectSchoolstudentslistList(stuCheckRepeat);
    	if (stuCheckRepeatList.size() != 0) {
//    		return Result.error(CodeMsg.REPEAT_PHONE);
//			return toAjax(false);
			return AjaxResult.error(CodeMsg.REPEAT_PHONE.getMsg());
		}
    	
    	
        return toAjax(schoolstudentslistService.insertSchoolstudentslist(schoolstudentslist));
    }
    
    /**
     * 个人信息
     * */
    @GetMapping("/grxx")
    public String grxx(ModelMap mmap)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	Schoolstudentslist stu = new Schoolstudentslist();
    	stu.setUserId(me.getUserId());
        List<Schoolstudentslist> schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistList(stu);
        if (schoolstudentslist.size() == 1) {
            stu = schoolstudentslist.get(0);
            mmap.put("schoolstudentslist", stu);
            return prefix + "/edit_mine";
        }
        else {
            return prefix + "/error";
        }        
    }
    
    /**
     * 账户密码
     * */
    @GetMapping("/zhmm")
    public String zhmm(ModelMap mmap)
    {
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	Schoolstudentslist stu = new Schoolstudentslist();
    	stu.setUserId(me.getUserId());
        List<Schoolstudentslist> schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistList(stu);
        if (schoolstudentslist.size() == 1) {
            stu = schoolstudentslist.get(0);
            mmap.put("me", me);
            return prefix + "/edit_password";
        }
        else {
            return prefix + "/error";
        }        
    }

    @ResponseBody
    @PostMapping("/editpass")
    public AjaxResult editpass(@RequestBody JSONObject param) {
    	System.out.println(param);
    	String pass = param.get("pass").toString();
    	String newpass = param.get("newpass").toString();
    	String newpass2 = param.get("newpass2").toString();
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
		if (!passwordService.matches(me, pass)) {
			return AjaxResult.error("原密码不正确");
		}
		if (!newpass.equals(newpass2)) {
			return AjaxResult.error("新密码与确认密码不一致");
		}
		userService.checkUserAllowed(me);
		me.setSalt(ShiroUtils.randomSalt());
		me.setPassword(passwordService.encryptPassword(me.getLoginName(), newpass, me.getSalt()));
        if (userService.resetUserPwd(me) > 0)
        {
            if (ShiroUtils.getUserId() == me.getUserId())
            {
                ShiroUtils.setSysUser(userService.selectUserById(me.getUserId()));
            }
        	return toAjax(true);
        }
		return AjaxResult.error("修改失败");		
    }

    /**
     * 修改学生列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
        mmap.put("schoolstudentslist", schoolstudentslist);
		SchoolSpecialty ss = new SchoolSpecialty();
    	List<SchoolSpecialty> sslist = schoolSpecialtyService.selectSchoolSpecialtyList(ss);   
    	mmap.put("sslist", sslist);
        return prefix + "/edit";
    }
    @GetMapping("/usersee/{id}")
    public String usersee(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolstudentslist schoolstudentslist = schoolstudentslistService.selectSchoolstudentslistById(id);
        mmap.put("schoolstudentslist", schoolstudentslist);
        return prefix + "/usersee";
    }

    /**
     * 修改保存学生列
     */
    @RequiresPermissions("system:schoolstudentslist:edit")
    @Log(title = "学生列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolstudentslist schoolstudentslist)
    {
    	if (schoolstudentslist.getRemark24() != null && schoolstudentslist.getApprovalstate() != null) {
    		if (schoolstudentslist.getApprovalstate().equals("2")) {
    			schoolstudentslist.setRemark24(DateUtils.getDate());
    		}
    	}
    	

    	//身份证与手机的校验
    	Schoolstudentslist stuCheckRepeat = new Schoolstudentslist();
    	stuCheckRepeat.setIdnum(schoolstudentslist.getIdnum());
    	stuCheckRepeat.setRepeatid(schoolstudentslist.getId());
    	List<Schoolstudentslist> stuCheckRepeatList = schoolstudentslistService.selectSchoolstudentslistList(stuCheckRepeat);    	
		if (stuCheckRepeatList.size() != 0) {
			return AjaxResult.error(CodeMsg.REPEAT_IDNUMBER.getMsg());
		}
    	stuCheckRepeat = new Schoolstudentslist();
    	stuCheckRepeat.setRepeatid(schoolstudentslist.getId());
    	stuCheckRepeat.setRemark44(schoolstudentslist.getRemark44());
    	stuCheckRepeatList = schoolstudentslistService.selectSchoolstudentslistList(stuCheckRepeat);
    	if (stuCheckRepeatList.size() != 0) {
			return AjaxResult.error(CodeMsg.REPEAT_PHONE.getMsg());
		}
    	
        return toAjax(schoolstudentslistService.updateSchoolstudentslist(schoolstudentslist));
    }
    
    @Log(title = "学生列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit2")
    @ResponseBody
    public AjaxResult editSave2(Schoolstudentslist schoolstudentslist)
    {
    	if (schoolstudentslist.getRemark24() != null && schoolstudentslist.getApprovalstate() != null) {
    		if (schoolstudentslist.getApprovalstate().equals("2")) {
    			schoolstudentslist.setRemark24(DateUtils.getDate());
    		}
    	}
        return toAjax(schoolstudentslistService.updateSchoolstudentslist(schoolstudentslist));
    }

    /**
     * 删除学生列
     */
    @RequiresPermissions("system:schoolstudentslist:remove")
    @Log(title = "学生列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolstudentslistService.deleteSchoolstudentslistByIds(ids));
    }
}
