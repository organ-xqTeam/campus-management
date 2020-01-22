package com.ruoyi.project.system.schoolResultDetail.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.ruoyi.project.system.ClasscurriculumDetail.domain.ClasscurriculumDetail;
import com.ruoyi.project.system.ClasscurriculumDetail.service.IClasscurriculumDetailService;
import com.ruoyi.project.system.classcurriculum.domain.Classcurriculum;
import com.ruoyi.project.system.classcurriculum.service.IClasscurriculumService;
import com.ruoyi.project.system.classschedulingmanagement.domain.Classschedulingmanagement;
import com.ruoyi.project.system.classschedulingmanagement.service.IClassschedulingmanagementService;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolResult.domain.SchoolResult;
import com.ruoyi.project.system.schoolResult.service.ISchoolResultService;
import com.ruoyi.project.system.schoolResultDetail.domain.SchoolResultDetail;
import com.ruoyi.project.system.schoolResultDetail.service.ISchoolResultDetailService;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;

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
    private ISchoolResultService  schoolResultService; 
    @Autowired
    private ISchoolgradelistService  schoolgradelistService;
    @Autowired
    private ISchoolstudentslistService  schoolstudentslistService ;
    @Autowired
    private IClasscurriculumDetailService classcurriculumDetailService;
    @Autowired
    private IClasscurriculumService classcurriculumService;
    @Autowired
    private ISchoolClassService schoolClassService;
    @Autowired
    private IClassschedulingmanagementService classschedulingmanagementService;
    @RequiresPermissions("system:schoolResultDetail:view")
    @GetMapping()
    public String schoolResultDetail(String id,ModelMap mmap)
    {
    	
    	System.out.println(id);
    	
    	mmap.put("resultId", id);
    	
    	//通过homeworkid 查找homework对象
    	SchoolResult schoolResult=  schoolResultService.selectSchoolResultById(Long.valueOf(id));
    	//获取课程id  coursemanagementId
    	Long coursemanagementId= schoolResult.getCurriculumId();
    	//
    	ClasscurriculumDetail classcurriculumDetail =new ClasscurriculumDetail();
    	classcurriculumDetail.setCoursemanagementId(coursemanagementId);
    	List<ClasscurriculumDetail> classcurriculumDetailList= classcurriculumDetailService.selectClasscurriculumDetailList(classcurriculumDetail);
    	//所有的课表id
    	List<Long> cuurriculumIdList= new ArrayList<>();
    	for (ClasscurriculumDetail classcurriculumDetail2 : classcurriculumDetailList) {
    		//获取所有的课表id
    		if(classcurriculumDetail2.getCuurriculumId()!=null) {
    			Long cuurriculumId= classcurriculumDetail2.getCuurriculumId();
    			cuurriculumIdList.add(cuurriculumId);
    		}
		}
    	
    	//声明课表id集合
    	List<Classcurriculum> ClasscurriculumList= new ArrayList<>();
    	//通过所有的课表id获取所有的班级id
    	for (Long cuurriculumId : cuurriculumIdList) {
    		Classcurriculum classcurriculum= classcurriculumService.selectClasscurriculumById(cuurriculumId);
    		ClasscurriculumList.add(classcurriculum);
		}
    	
    	//声明排课管理集合
    	//声明班级id的集合
    	List<String> schoolclassIdList= new ArrayList<>();
    	//通过课表集合获得classschedulingmanagement_id 排课管理的id
    	for (Classcurriculum classcurriculum : ClasscurriculumList) {
			if(classcurriculum.getClassschedulingmanagementId()!=null) {
				Classschedulingmanagement classschedulingmanagement=classschedulingmanagementService.selectClassschedulingmanagementById( Long.valueOf(classcurriculum.getClassschedulingmanagementId()));
				if(classschedulingmanagement!=null&&classschedulingmanagement.getClassId()!=null) {
					schoolclassIdList.add(classschedulingmanagement.getClassId());
				}
			}
    	}
    	
    	//通过班级id获取所有学生
    	List<Schoolstudentslist> schoolstudentslistList =new ArrayList<>();
    	
    	for (String schoolclassId : schoolclassIdList) {
    		Schoolstudentslist schoolstudentslist =new Schoolstudentslist();
    		schoolstudentslist.setClassId(Long.valueOf(schoolclassId));
    		schoolstudentslistList.addAll(schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist));
			
		}
    	
    	
    	
    	/*//查找所有学生
    	Schoolstudentslist schoolstudentslist =new Schoolstudentslist();
    	List<Schoolstudentslist> schoolstudentslistList= schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);*/
    	//所有学生的id
    	Set<Long> studentsIdList= new HashSet<>();
    	for (Schoolstudentslist schoolstudentslist2 : schoolstudentslistList) {
    		studentsIdList.add(schoolstudentslist2.getId());
		}
    	//通过resultid 查找 SchoolResultDetail
    	SchoolResultDetail schoolResultDetail =new SchoolResultDetail();
    	schoolResultDetail.setResultId(Long.valueOf(id));
    	
    	List<SchoolResultDetail> schoolResultDetailList= schoolResultDetailService.selectSchoolResultDetailList(schoolResultDetail);
    	for (SchoolResultDetail schoolResultDetail2 : schoolResultDetailList) {
			  Long studentsIds=  schoolResultDetail2.getStudentsId();
			  if(studentsIdList.contains(studentsIds)) {
				  studentsIdList.remove(studentsIds);
			  }
		}
    	//遍历所有学生的id新增
    	for (Long studentsId : studentsIdList) {
    		SchoolResultDetail schoolResultDetailss =new SchoolResultDetail();
    		schoolResultDetailss.setStudentsId(studentsId);
    		schoolResultDetailss.setResultId(Long.valueOf(id));
    		schoolResultDetailService.insertSchoolResultDetail(schoolResultDetailss);
		}
    	
    	//查询所有年级
    	Schoolgradelist schoolgradelist = new Schoolgradelist();
    	List<Schoolgradelist> schoolgradelistList= schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("schoolgradelistList", schoolgradelistList);
    	SchoolClass schoolClass =new SchoolClass();
    	List<SchoolClass> schoolClassList= schoolClassService.selectSchoolClassList(schoolClass);
    	mmap.put("schoolClassList", schoolClassList);
    	//查询所有班级
        return prefix + "/schoolResultDetail";
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
