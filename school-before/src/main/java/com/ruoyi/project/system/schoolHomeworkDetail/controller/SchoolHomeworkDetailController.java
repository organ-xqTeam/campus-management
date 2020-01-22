package com.ruoyi.project.system.schoolHomeworkDetail.controller;

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
import com.ruoyi.project.system.schoolHomework.domain.SchoolHomework;
import com.ruoyi.project.system.schoolHomework.service.ISchoolHomeworkService;
import com.ruoyi.project.system.schoolHomeworkDetail.domain.SchoolHomeworkDetail;
import com.ruoyi.project.system.schoolHomeworkDetail.service.ISchoolHomeworkDetailService;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;

/**
 * 学校作业表Controller
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
@Controller
@RequestMapping("/system/schoolHomeworkDetail")
public class SchoolHomeworkDetailController extends BaseController
{
    private String prefix = "system/schoolHomeworkDetail";

    @Autowired
    private ISchoolHomeworkDetailService schoolHomeworkDetailService;
    @Autowired
    private  ISchoolHomeworkService  schoolHomeworkService;
    @Autowired
    private ISchoolstudentslistService  schoolstudentslistService ;
    @Autowired
    private ISchoolgradelistService  schoolgradelistService;
    @Autowired
    private ISchoolClassService schoolClassService;
    @Autowired
    private IClasscurriculumDetailService  classcurriculumDetailService;
    @Autowired
    private IClasscurriculumService  classcurriculumService ;
    @Autowired
    private IClassschedulingmanagementService classschedulingmanagementService;
    @RequiresPermissions("system:schoolHomeworkDetail:view")
    @GetMapping()
    public String schoolHomeworkDetail(String id,ModelMap mmap)
    {
    	System.out.println(id);
    	mmap.put("homeworkId", id);
    	//通过homeworkid 查找homework对象
    	SchoolHomework schoolHomework=  schoolHomeworkService.selectSchoolHomeworkById(Long.valueOf(id));
    	//获取课程id  coursemanagementId
    	Long coursemanagementId= schoolHomework.getCurriculumId();
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
    	
    	
    	
    	
    	
    	
    	//查找所有学生
    	/*Schoolstudentslist schoolstudentslist =new Schoolstudentslist();
    	List<Schoolstudentslist> schoolstudentslistList= schoolstudentslistService.selectSchoolstudentslistList(schoolstudentslist);*/
    	//所有学生的id
    	Set<Long> studentsIdList= new HashSet<Long>();
    	for (Schoolstudentslist schoolstudentslist2 : schoolstudentslistList) {
    		studentsIdList.add(schoolstudentslist2.getId());
		}
    	
    	//通过homeworkId 查找 SchoolHomeworkDetail
    	SchoolHomeworkDetail schoolHomeworkDetail =new SchoolHomeworkDetail();
    	schoolHomeworkDetail.setHomeworkId(Long.valueOf(id));
    	List<SchoolHomeworkDetail> schoolHomeworkDetailList = schoolHomeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
    	for (SchoolHomeworkDetail schoolHomeworkDetail2 : schoolHomeworkDetailList) {
    		Long studentsIds=  schoolHomeworkDetail2.getStudentsId();
    		if(studentsIdList.contains(studentsIds)) {
    			studentsIdList.remove(studentsIds);
    		}
		}
    	
    	//遍历所有学生的id新增
    	for (Long studentsId : studentsIdList) {
    		SchoolHomeworkDetail schoolHomeworkDetailss =new SchoolHomeworkDetail();
    		schoolHomeworkDetailss.setStudentsId(studentsId);
    		schoolHomeworkDetailss.setHomeworkId(Long.valueOf(id));
    		schoolHomeworkDetailService.insertSchoolHomeworkDetail(schoolHomeworkDetailss);
		}
    	
    	
    	
    	
    	
    	//查询所有年级
    	Schoolgradelist schoolgradelist = new Schoolgradelist();
    	List<Schoolgradelist> schoolgradelistList= schoolgradelistService.selectSchoolgradelistList(schoolgradelist);
    	mmap.put("schoolgradelistList", schoolgradelistList);
    	SchoolClass schoolClass =new SchoolClass();
    	List<SchoolClass> schoolClassList= schoolClassService.selectSchoolClassList(schoolClass);
    	mmap.put("schoolClassList", schoolClassList);
        return prefix + "/schoolHomeworkDetail";
    }

    /**
     * 查询学校作业表列表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam Map<String, Object> parmMap)
    {
    	System.out.println(parmMap);
        startPage();
        //通过HomeworkId 查找HomeworkDetail关联得学生信息
        List<Map<String, Object>> list = schoolHomeworkDetailService.selectSchoolHomeworkDetailStudentsListByHomeworkId(parmMap);
        return getDataTable(list);
    }

    /**
     * 导出学校作业表列表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:export")
    @Log(title = "学校作业表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolHomeworkDetail schoolHomeworkDetail)
    {
        List<SchoolHomeworkDetail> list = schoolHomeworkDetailService.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
        ExcelUtil<SchoolHomeworkDetail> util = new ExcelUtil<SchoolHomeworkDetail>(SchoolHomeworkDetail.class);
        return util.exportExcel(list, "schoolHomeworkDetail");
    }

    /**
     * 新增学校作业表
     */
    @GetMapping("/add")
    public String add(String studentsId,String homeworkId,String detailId,ModelMap mmap)
    {
    	if(detailId!=null&&!"undefined".equals(detailId)) {
    		SchoolHomeworkDetail schoolHomeworkDetail= schoolHomeworkDetailService.selectSchoolHomeworkDetailById(Long.valueOf(detailId));
    		if(schoolHomeworkDetail!=null) {
    			mmap.put("schoolResultDetail", schoolHomeworkDetail);
    		}
    	}
    	if(studentsId!=null&&!"undefined".equals(studentsId)) {
    		mmap.put("studentsId", studentsId);
    	}else {
    		mmap.put("studentsId", "");
    	}
    	if(homeworkId!=null&&!"undefined".equals(homeworkId)) {
    		mmap.put("homeworkId", homeworkId);
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
     * 新增保存学校作业表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:add")
    @Log(title = "学校作业表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolHomeworkDetail schoolHomeworkDetail)
    {
    	Long detailId= schoolHomeworkDetail.getId();
    	int count=0;
    	if(detailId==null||detailId==0) {
    		//增加
    		count=schoolHomeworkDetailService.insertSchoolHomeworkDetail(schoolHomeworkDetail);
    	}else {
    		//修改
    		count=schoolHomeworkDetailService.updateSchoolHomeworkDetail(schoolHomeworkDetail);
    	}
        return toAjax(count);
    	
    	
    	
        //return toAjax(schoolHomeworkDetailService.insertSchoolHomeworkDetail(schoolHomeworkDetail));
    }

    /**
     * 修改学校作业表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolHomeworkDetail schoolHomeworkDetail = schoolHomeworkDetailService.selectSchoolHomeworkDetailById(id);
        mmap.put("schoolHomeworkDetail", schoolHomeworkDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存学校作业表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:edit")
    @Log(title = "学校作业表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolHomeworkDetail schoolHomeworkDetail)
    {
        return toAjax(schoolHomeworkDetailService.updateSchoolHomeworkDetail(schoolHomeworkDetail));
    }

    /**
     * 删除学校作业表
     */
    @RequiresPermissions("system:schoolHomeworkDetail:remove")
    @Log(title = "学校作业表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolHomeworkDetailService.deleteSchoolHomeworkDetailByIds(ids));
    }
}
