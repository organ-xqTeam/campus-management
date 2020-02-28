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

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysNotice;
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
    
}
