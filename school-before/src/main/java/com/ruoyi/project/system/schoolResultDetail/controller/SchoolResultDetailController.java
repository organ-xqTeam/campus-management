package com.ruoyi.project.system.schoolResultDetail.controller;

import java.util.List;
import java.util.Map;

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

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolResultDetail.domain.SchoolResultDetail;
import com.ruoyi.project.system.schoolResultDetail.service.ISchoolResultDetailService;

/**
 * 学校成绩详情表Controller
 * 
 * @author ruoyiasd
 * @date 2019-12-03
 */
@Controller
@RequestMapping("/system/schoolResultDetail")
public class SchoolResultDetailController extends BaseController
{
    private String prefix = "system/schoolResultDetail";

    @Autowired
    private ISchoolResultDetailService schoolResultDetailService;
    @Autowired
    private ISchoolClassService schoolClassService;
    
    @RequiresPermissions("system:schoolResultDetail:view")
    @GetMapping()
    public String schoolResultDetail(String id,ModelMap mmap)
    {
    	mmap.put("resultId", id);
    	SchoolClass schoolClass =new SchoolClass();
    	List<SchoolClass> schoolClassList= schoolClassService.selectSchoolClassList(schoolClass);
    	mmap.put("schoolClassList", schoolClassList);
        return prefix + "/schoolResultDetail";
    }
    
    @GetMapping("/luru")
    public String luru(@RequestParam("id") String id, ModelMap mmap)
    {
    	mmap.put("id", id);
    	SchoolClass schoolClass =new SchoolClass();
    	List<SchoolClass> schoolClassList= schoolClassService.selectSchoolClassList(schoolClass);
    	mmap.put("schoolClassList", schoolClassList);
        return prefix + "/luru";
    }
    
//    @RequiresPermissions("system:schoolResultDetail:list")
    @PostMapping("/lurulist")
    @ResponseBody
    public TableDataInfo lurulist(@RequestParam Map<String, Object> parmMap)
    {
    	startPage();
        List<Map<String, Object>> list=schoolResultDetailService.selectlurulist(parmMap);
        return getDataTable(list);
    }
    
    @GetMapping("/result")
    @RequiresPermissions("system:schoolResultDetail:view")
    public String result(String id,ModelMap mmap)
    {
    	mmap.put("studentid", id);
        return "system/schoolClass/schoolresult";
    }
    
    @RequiresPermissions("system:schoolResultDetail:list")
    @PostMapping("/resultlist")
    @ResponseBody
    public TableDataInfo resultlist(@RequestParam Map<String, Object> parmMap)
    {
        startPage();
        List<Map<String, Object>> list=schoolResultDetailService.selectstudentresultlist(parmMap);
        return getDataTable(list);
    }
    

    /**
     * 新增学校成绩详情表
     */
    @GetMapping("/luruadd")
    public String luruadd(String id, ModelMap mmap)
    {
    	mmap.put("id", id);
        return prefix + "/luruadd";
    }

    /**
     * 查询学校成绩详情表列表
     */
    @RequiresPermissions("system:schoolResultDetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam  Map<String, Object> parmMap)
    {
    	System.out.println(parmMap);
        startPage();
        //通过 resultId 查找SchoolResultDetail和Students关联得信息;
        
        List<Map<String, Object>> list=schoolResultDetailService.selectSchoolResultDetailStudentsListByResultId(parmMap);
        return getDataTable(list);
        /*List<SchoolResultDetail> list = schoolResultDetailService.selectSchoolResultDetailList(schoolResultDetail);
        return getDataTable(list);*/
        
       // return null;
    }

    /**
     * 导出学校成绩详情表列表
     */
    @RequiresPermissions("system:schoolResultDetail:export")
    @Log(title = "学校成绩详情表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolResultDetail schoolResultDetail)
    {
        List<SchoolResultDetail> list = schoolResultDetailService.selectSchoolResultDetailList(schoolResultDetail);
        ExcelUtil<SchoolResultDetail> util = new ExcelUtil<SchoolResultDetail>(SchoolResultDetail.class);
        return util.exportExcel(list, "schoolResultDetail");
    }

    /**
     * 新增学校成绩详情表
     */
    @GetMapping("/add")
    public String add(String studentsId,String resultId,String detailId,ModelMap mmap)
    {
    	if(detailId!=null&&!"undefined".equals(detailId)) {
    		SchoolResultDetail schoolResultDetail= schoolResultDetailService.selectSchoolResultDetailById(Long.valueOf(detailId));
    		if(schoolResultDetail!=null) {
    			mmap.put("schoolResultDetail", schoolResultDetail);
    		}
    	}
    	if(studentsId!=null&&!"undefined".equals(studentsId)) {
    		mmap.put("studentsId", studentsId);
    	}else {
    		mmap.put("studentsId", "");
    	}
    	if(resultId!=null&&!"undefined".equals(resultId)) {
    		mmap.put("resultId", resultId);
    	}else {
    		mmap.put("resultId", "");
    	}
    	if(detailId!=null&&!"undefined".equals(detailId)) {
    		mmap.put("detailId", detailId);
    	}else {
    		mmap.put("detailId", "");
    	}
    	
        return prefix + "/add";
    }

    /**
     * 新增保存学校成绩详情表
     */
    @RequiresPermissions("system:schoolResultDetail:add")
    @Log(title = "学校成绩详情表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolResultDetail schoolResultDetail)
    {
    	Long detailId= schoolResultDetail.getId();
    	int count=0;
    	if(detailId==null||detailId==0) {
    		//增加
    		count=schoolResultDetailService.insertSchoolResultDetail(schoolResultDetail);
    	}else {
    		//修改
    		count=schoolResultDetailService.updateSchoolResultDetail(schoolResultDetail);
    	}
        return toAjax(count);
    }

    /**
     * 修改学校成绩详情表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolResultDetail schoolResultDetail = schoolResultDetailService.selectSchoolResultDetailById(id);
        mmap.put("schoolResultDetail", schoolResultDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存学校成绩详情表
     */
    @RequiresPermissions("system:schoolResultDetail:edit")
    @Log(title = "学校成绩详情表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolResultDetail schoolResultDetail)
    {
        return toAjax(schoolResultDetailService.updateSchoolResultDetail(schoolResultDetail));
    }

    /**
     * 删除学校成绩详情表
     */
    @RequiresPermissions("system:schoolResultDetail:remove")
    @Log(title = "学校成绩详情表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolResultDetailService.deleteSchoolResultDetailByIds(ids));
    }
}
