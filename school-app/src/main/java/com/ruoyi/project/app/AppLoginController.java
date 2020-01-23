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
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;

//用户端登陆
@CrossOrigin
@Controller
@RequestMapping("/ajax/schoolController")
public class AppLoginController{

	@Autowired
	private ISysUserService userService;
	@Autowired
	private SysPasswordService passwordService;
	
	@Autowired
	private ISysUserOnlineService userOnlineService;
	@Autowired
	private ITeachingInfoService teachingInfoService;
	@Autowired
	private ISchoolstudentslistService schoolstudentslistService; 
	
	@PostMapping("/login")
	@ResponseBody
	public AjaxResult ajaxLogin(@RequestBody JSONObject requestParams) {
		
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
			if(users.getRoleId()!=null) {
				Long roleId=  users.getRoleId();
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
					if(schoolstudentslistList.size()>0) {
						map.put("schoolstudentslist", schoolstudentslistList.get(0));
					}
				}
				if (roleId != 5) {
					return AjaxResult.success("您无权限登陆客户端！");
				}
				
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
	
	@PostMapping("/applogin")
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
			if(users.getRoleId()!=null) {
				Long roleId=  users.getRoleId();
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
	
	@PostMapping("/logout")
	@ResponseBody
	public AjaxResult ajaxlogout(String token) {
		userOnlineService.deleteOnlineById(token);
		return AjaxResult.success();
	}
	
	
	

//	@Log(title = "重置密码", businessType = BusinessType.UPDATE)
//	@PostMapping("/resetPwd")
//	@ResponseBody
	public AjaxResult resetPwd(Long userId,String oldPassword, String newPassword) {
		SysUser user =userService.selectUserById(userId);
		if (StringUtils.isNotEmpty(newPassword) && passwordService.matches(user, oldPassword)) {
			user.setPassword(newPassword);
			if (!userService.checkPasswordUnique(newPassword)) {
				return AjaxResult.error("密码必须是包含大写字母、小写字母、数字、特殊符号的8位以上组合");
			}
			if (userService.resetUserPwd(user) > 0) {
				return AjaxResult.success();
			}
			return AjaxResult.error();
		} else {
			return AjaxResult.error("修改密码失败，旧密码错误");
		}
	}
	
//	@Log(title = "用户管理", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
    public AjaxResult addSave(@Validated SysUser user)
    {
		
		//部门 研发部门
		user.setDeptId((long) 103);
		user.setRoleId((long) 5);
		//岗位 普通员工
		Long roleIds[] = {(long)5};
		user.setRoleIds(roleIds);
		//角色 学生
		Long postIds[] = {(long)4};
		user.setPostIds(postIds);
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(user.getLoginName())))
        {
            return AjaxResult.error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        }
        else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
        }
        else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user)))
        {
            return AjaxResult.error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }else if (!userService.checkPasswordUnique(user.getPassword())) {
			return AjaxResult.error("密码必须是包含大写字母、小写字母、数字、特殊符号的8位以上组合");
		}
        return AjaxResult.success(userService.insertUser(user));
    }
	
}
