package com.ruoyi.web.controller.system;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.system.service.ISysNoticeService;
import com.ruoyi.system.service.ISysOperLogService;
import com.ruoyi.system.service.ISysUserOnlineService;

import net.sf.json.JSONArray;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ISysOperLogService operLogService;
    @Autowired
    private ISysUserOnlineService userOnlineService;
    @Autowired
    private ISysNoticeService noticeService;
    @Autowired
    private ISchoolSpecialtyService schoolSpecialtyService;
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        return "index";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap)
    {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return "main";
    }
    /**
     * 
     * 管理员首页 审计统计
     * @param teachingInfo
     * @return
     */
    
    @Log(title = "审计统计", businessType = BusinessType.OTHER)
    @GetMapping("/system/OperLogbusinesstype")
    @ResponseBody
    public AjaxResult OperLogbusinesstype()
    {
    	List<Map> list = operLogService.selectOperLogbusinesstypeGROUPBY();
    	JSONArray array = JSONArray.fromObject(list);
    	return AjaxResult.success(array);
    }
    /**
     * 
     * 在线人数
     * @param teachingInfo
     * @return
     */
    
    @Log(title = "审计统计在线人数", businessType = BusinessType.OTHER)
    @GetMapping("/system/userOnlinenum")
    @ResponseBody
    public AjaxResult userOnlinenum()
    {
    	List<SysUserOnline> list = userOnlineService.selectUserOnlineList(null);
    	return AjaxResult.success(list.size());
    }
    

    /**
     * 主页上显示自己的公告
     */
    @GetMapping("/system/mynoticelist")
    @ResponseBody
    public TableDataInfo mynoticelist()
    {
    	SysNotice notice = new SysNotice();
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	notice.setUserid(me.getUserId()+"");
    	notice.setNoticeType("2");
    	notice.setYearbefore(DateUtils.getYearBefore(1));
        startPage();
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }
    /**
     * 主页上显示自己的角色
     */
    @GetMapping("/system/myrole")
    @ResponseBody
    public JSONObject myrole()
    {
    	JSONObject result = new JSONObject();
    	SysUser me = (SysUser) SecurityUtils.getSubject().getPrincipal();
    	//我的个人权限信息
    	result.put("me", me.getRoles());
    	//通知公告数量
    	SysNotice notice = new SysNotice();
    	List<SysNotice> noticelist = noticeService.selectNoticeList(notice);
    	result.put("noticenum", noticelist.size());
    	//招生项目数量
    	SchoolSpecialty ss = new SchoolSpecialty();
    	List<SchoolSpecialty> sslist = schoolSpecialtyService.selectSchoolSpecialtyList(ss);
    	result.put("ssnum", sslist.size());
    	
    	int count1 = menuService.count1();
    	int count2 = menuService.count2();
    	int count3 = menuService.count3();
    	int count4 = menuService.count4();
    	int count5 = menuService.count5();
    	int count6 = menuService.count6();
    	int count7 = menuService.count7();
    	int count8 = menuService.count8();
    	int count9 = menuService.count9();
    	int count10 = menuService.count10();
    	int count11 = menuService.count11();
    	int count12 = menuService.count12();
    	int count13 = menuService.count13();
    	int count14 = menuService.count14();
    	int count15 = menuService.count15();
    	int count16 = menuService.count16();
    	int count17 = menuService.count17();
    	int count18 = menuService.count18();
    	int count19 = menuService.count19();
    	int count20 = menuService.count20();
    	int count21 = menuService.count21();
    	int count22 = menuService.count22();
    	int count23 = menuService.count23();
    	int count24 = menuService.count24();
    	int count25 = menuService.count25();
    	
    	//本年度正在审核的招生数量
    	result.put("count1", count1);
    	//本年度审核通过的招生数量
    	result.put("count2", count2);
    	//往年招生通过的数量
    	result.put("count3", count3);
    	//招生总数
    	result.put("count4", count4);
    	//空余宿舍数量，点击可进入
    	result.put("count5", count5);
    	//教室总量，可用数量，不可用数量
    	result.put("count6", count6);
    	result.put("count10", count10);
    	result.put("count11", count11);
    	//资产总量
    	result.put("count7", count7);
    	//设备报修单数量，未解决数量
    	result.put("count8", count8);
    	result.put("count12", count12);
    	//累计举行会议数量
    	result.put("count9", count9);
    	
    	//本年度迎新学生总量，已办理入学数量，剩余数量
    	//显示在校学生总数，各个年级的人数，以及各个，学院，专业人数
    	//显示累计异动学生数
    	//显示当年离校学生总数，已办理人数，剩余人数
    	//显示当年结业学生总数，已发证人数，剩余人数
    	//显示当年就业学生总数，剩余人数
    	result.put("count13", count13);
    	result.put("count14", count14);
    	result.put("count15", count15);
    	result.put("count16", count16);
    	result.put("count17", count17);
    	result.put("count18", count18);
    	result.put("count19", count19);
    	result.put("count20", count20);
    	result.put("count21", count21);
    	result.put("count22", count22);
    	result.put("count23", count23);
    	result.put("count24", count24);
    	result.put("count25", count25);


    	
        return result;
    }
    
}
