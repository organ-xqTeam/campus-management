package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CertificateManagement;
import com.ruoyi.system.service.ICertificateManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 证书管理Controller
 * 
 * @author ruoyi
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/system/certificateManagement")
public class CertificateManagementController extends BaseController
{
    private String prefix = "system/certificateManagement";

    @Autowired
    private ICertificateManagementService certificateManagementService;

    @RequiresPermissions("system:certificateManagement:view")
    @GetMapping()
    public String certificateManagement()
    {
        return prefix + "/certificateManagement";
    }

    /**
     * 查询证书管理列表
     */
    @RequiresPermissions("system:certificateManagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CertificateManagement certificateManagement)
    {
        startPage();
        List<CertificateManagement> list = certificateManagementService.selectCertificateManagementList(certificateManagement);
        return getDataTable(list);
    }

    /**
     * 导出证书管理列表
     */
    @RequiresPermissions("system:certificateManagement:export")
    @Log(title = "证书管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CertificateManagement certificateManagement)
    {
        List<CertificateManagement> list = certificateManagementService.selectCertificateManagementList(certificateManagement);
        ExcelUtil<CertificateManagement> util = new ExcelUtil<CertificateManagement>(CertificateManagement.class);
        return util.exportExcel(list, "certificateManagement");
    }

    /**
     * 新增证书管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存证书管理
     */
    @RequiresPermissions("system:certificateManagement:add")
    @Log(title = "证书管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CertificateManagement certificateManagement)
    {
        return toAjax(certificateManagementService.insertCertificateManagement(certificateManagement));
    }

    /**
     * 修改证书管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CertificateManagement certificateManagement = certificateManagementService.selectCertificateManagementById(id);
        mmap.put("certificateManagement", certificateManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存证书管理
     */
    @RequiresPermissions("system:certificateManagement:edit")
    @Log(title = "证书管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CertificateManagement certificateManagement)
    {
        return toAjax(certificateManagementService.updateCertificateManagement(certificateManagement));
    }

    /**
     * 删除证书管理
     */
    @RequiresPermissions("system:certificateManagement:remove")
    @Log(title = "证书管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(certificateManagementService.deleteCertificateManagementByIds(ids));
    }
    @Log(title = "上传图片", businessType = BusinessType.UPDATE)
    @PostMapping("/importImg")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("file") MultipartFile file)
    {
        try
        {
        	String avatar = null;
            if (!file.isEmpty())
            {
                avatar = FileUploadUtils.upload(RuoYiConfig.getUploadPath(), file);
            }
			return success(avatar);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
