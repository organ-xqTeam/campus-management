package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.SysNoticeUser;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysNoticeService;
import com.ruoyi.system.service.ISysUserService;

/**
 * 公告 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/notice")
public class SysNoticeController extends BaseController
{
    private String prefix = "system/notice";

    @Autowired
    private ISysUserService userservice;
    
    @Autowired
    private ISysNoticeService noticeService;
    

    @RequiresPermissions("system:notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }
    

    /**
     * 公告发布-发布列表页
     */
    @GetMapping("/noticeview")
    public String noticelist(SysNotice notice, ModelMap model)
    {
    	model.put("notice", notice);
        return  "system/notice/notice_fabu";
    }
    /**
     * 公告发布-发布列表页查询用户
     */
    @PostMapping("/noticelist")
    @ResponseBody
    public TableDataInfo noticelist(SysUser user)
    {
        startPage();
        List<SysUser> sulist = userservice.selectUserList(user);
        return getDataTable(sulist);
    }
    /**
     * 公告发布-导入列表页
     */
    @GetMapping("/daoruview/{noticeid}")
    public String daoruview(@PathVariable("noticeid") Long noticeid, ModelMap model)
    {
    	SysNotice notice = noticeService.selectNoticeById(noticeid);
    	model.put("notice", notice);
        return  "system/notice/notice_daoru";
    }
    /**
     * 增加用户与公告的关联
     */
    @PostMapping("/addsnu")
    @ResponseBody
    public AjaxResult addsnu(SysNoticeUser snu)
    {
        return toAjax(noticeService.insertNoticeUser(snu));
    }
    /**
     * 解除用户与公告的关联
     */
    @RequestMapping("/removesnu")
    @ResponseBody
    public AjaxResult removesnu(@RequestBody List<SysNoticeUser> snulist)
    {
        return toAjax(noticeService.deleteNoticeUser(snulist));
    }

    /**
     * 查询公告列表
     */
    @RequiresPermissions("system:notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysNotice notice)
    {
        startPage();
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 新增公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公告
     */
    @RequiresPermissions("system:notice:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysNotice notice)
    {
        notice.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * 修改公告
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("notice", noticeService.selectNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("system:notice:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysNotice notice)
    {
        notice.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("system:notice:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(noticeService.deleteNoticeByIds(ids));
    }
}
