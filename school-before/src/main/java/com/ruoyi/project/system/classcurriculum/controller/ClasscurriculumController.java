package com.ruoyi.project.system.classcurriculum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.ClasscurriculumDetail.domain.ClasscurriculumDetail;
import com.ruoyi.project.system.ClasscurriculumDetail.service.IClasscurriculumDetailService;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;
import com.ruoyi.project.system.classcurriculum.domain.Classcurriculum;
import com.ruoyi.project.system.classcurriculum.service.IClasscurriculumService;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;

/**
 * 课Controller
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Controller
@RequestMapping("/system/classcurriculum")
public class ClasscurriculumController extends BaseController
{
    private String prefix = "system/classcurriculum";

    @Autowired
    private IClasscurriculumService classcurriculumService;
    @Autowired
    private ITeachingInfoService teachingInfoService;
    
    @Autowired
    private ICoursemanagementService coursemanagementService; 
    
    @Autowired
    private IClasscurriculumDetailService  classcurriculumDetailService;


    @GetMapping()
    public String classcurriculum(String classsId,ModelMap mmap)
    {
    	Classcurriculum classcurriculum= new Classcurriculum();
    	classcurriculum.setClassschedulingmanagementId(classsId);
    	classcurriculum.setDelFlag((long)0);
    	List<Classcurriculum>classcurriculumList = classcurriculumService.selectClasscurriculumList(classcurriculum);
    	//System.out.println(classsId);
    	if(classcurriculumList.size()==0) {
    		classcurriculum= new Classcurriculum();
    		classcurriculum.setCreateTime(new Date());;
    		classcurriculum.setClassschedulingmanagementId(classsId);
    		classcurriculum.setDelFlag((long)0);
    		classcurriculumService.insertClasscurriculum(classcurriculum);
    		classcurriculumList = classcurriculumService.selectClasscurriculumList(classcurriculum);
    	}
    	mmap.put("classcurriculum", classcurriculumList.get(0));
    	
    	 
        return prefix + "/classcurriculum";
    }
    @PostMapping("/getDetail")
    @ResponseBody
    public Map<String, Object> classcurriculum(@RequestBody Map<String, Object> parmMap)
    {
       Map<String, Object> returnMap =new HashMap<>();
       String classcid=	parmMap.get("classcid").toString();
       String yearmonth=	parmMap.get("yearmonth").toString();
       String week=	parmMap.get("week").toString();
       if(yearmonth==null||yearmonth.equals("")) {
    	   SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM");
    	   yearmonth= sdf.format(new Date());
       }
       if(week==null||week.equals("")){
    	   week="1";
       }
       
       ClasscurriculumDetail classcurriculumDetail =new ClasscurriculumDetail();
       classcurriculumDetail.setCuurriculumId(Long.valueOf(classcid));
       classcurriculumDetail.setYearmonth(yearmonth);
       classcurriculumDetail.setWeek(week);
       classcurriculumDetail.setIsdisuse("0");
       classcurriculumDetail.setDelflag("0");
       List<ClasscurriculumDetail> classcurriculumDetailList= classcurriculumDetailService.selectClasscurriculumDetailList(classcurriculumDetail);
       
       returnMap.put("classcurriculumDetailList", classcurriculumDetailList);
       
       //classcurriculumDetailService
    	
    	return returnMap;
    }

    /**
     * 查询课列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Classcurriculum classcurriculum)
    {
        startPage();
        List<Classcurriculum> list = classcurriculumService.selectClasscurriculumList(classcurriculum);
        return getDataTable(list);
    }

    /**
     * 导出课列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Classcurriculum classcurriculum)
    {
        List<Classcurriculum> list = classcurriculumService.selectClasscurriculumList(classcurriculum);
        ExcelUtil<Classcurriculum> util = new ExcelUtil<Classcurriculum>(Classcurriculum.class);
        return util.exportExcel(list, "classcurriculum");
    }

    /**
     * 新增课
     */
    @GetMapping("/add")
    public String add(String detailPosition,String classcid,String yearmonthss  ,String weekss,ModelMap mmap)
    {
    	if(yearmonthss==null||yearmonthss.equals("")) {
    		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM");
    		yearmonthss=sdf.format(new Date());
    		
    	}
    	if(weekss==null||weekss.equals("")) {
    		weekss="1";
    	}
    	
    	System.out.println(yearmonthss);
    	System.out.println(weekss);
    	System.out.println(detailPosition);
    	System.out.println(classcid);
    	//查找所有老师
    	TeachingInfo teachingInfo =new TeachingInfo();
    	teachingInfo.setDelFlag((long)0);
    	List<TeachingInfo> teachingInfoList=  teachingInfoService.selectTeachingInfoList(teachingInfo);
    	//查找所有科目
    	Coursemanagement coursemanagement =new Coursemanagement();
    	coursemanagement.setDelFlag((long)0);
    	List<Coursemanagement> coursemanagementList= coursemanagementService.selectCoursemanagementList(coursemanagement);
    	
    	
    	mmap.put("teachingInfoList", teachingInfoList);
    	mmap.put("coursemanagementList", coursemanagementList);
    	mmap.put("yearmonthss", yearmonthss);
    	mmap.put("weekss", weekss);
    	mmap.put("detailPosition", detailPosition);
    	mmap.put("classcid", classcid);
    	
    	
    	
    	
    	
    	
    	
    	//判断新增还是修改
    	ClasscurriculumDetail  newClasscurriculumDetail=new ClasscurriculumDetail();
    	newClasscurriculumDetail.setDelflag("0");
    	newClasscurriculumDetail.setIsdisuse("0");
    	newClasscurriculumDetail.setWeek(weekss);
    	newClasscurriculumDetail.setYearmonth(yearmonthss);
    	newClasscurriculumDetail.setDetailPosition(detailPosition);
    	newClasscurriculumDetail.setCuurriculumId(Long.valueOf(classcid));
    	List<ClasscurriculumDetail> newClasscurriculumDetailList= classcurriculumDetailService.selectClasscurriculumDetailList(newClasscurriculumDetail);
    	if(newClasscurriculumDetailList.size()>0) {
    		mmap.put("classcurriculumDetail", newClasscurriculumDetailList.get(0));
    	}
    	return prefix + "/add";
    }

    /**
     * 新增保存课
     */

    @Log(title = "增加排课", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClasscurriculumDetail classcurriculumDetail)
    {
    	System.out.println(classcurriculumDetail);
    	ClasscurriculumDetail  newClasscurriculumDetail=new ClasscurriculumDetail();
    	newClasscurriculumDetail.setDelflag("0");
    	newClasscurriculumDetail.setIsdisuse("0");
    	if(classcurriculumDetail.getWeek()!=null) {
    		newClasscurriculumDetail.setWeek(classcurriculumDetail.getWeek());
    	}
    	if(classcurriculumDetail.getYearmonth()!=null) {
    		newClasscurriculumDetail.setYearmonth(classcurriculumDetail.getYearmonth());
    	}
    	if(classcurriculumDetail.getDetailPosition()!=null) {
    		newClasscurriculumDetail.setDetailPosition(classcurriculumDetail.getDetailPosition());
    	}
    	if(classcurriculumDetail.getCuurriculumId()!=null) {
    		newClasscurriculumDetail.setCuurriculumId(classcurriculumDetail.getCuurriculumId());
    	}
    	
    	
    	//查找老师
    	TeachingInfo teachingInfo=  teachingInfoService.selectTeachingInfoById(classcurriculumDetail.getTeacherId());
    	//查找科目
    	Coursemanagement coursemanagement=coursemanagementService.selectCoursemanagementById(classcurriculumDetail.getCoursemanagementId());
    	classcurriculumDetail.setTeacherName(teachingInfo.getTeachingName());
    	classcurriculumDetail.setSubject(coursemanagement.getStudentsName());
    	
    	
    	List<ClasscurriculumDetail> newClasscurriculumDetailList= classcurriculumDetailService.selectClasscurriculumDetailList(newClasscurriculumDetail);
    	
    	int returnCount=0;
    	if(newClasscurriculumDetailList.size()>0) {
    		//进行修改操作
    		classcurriculumDetail.setId(newClasscurriculumDetailList.get(0).getId());
    		returnCount=classcurriculumDetailService.updateClasscurriculumDetail(classcurriculumDetail);
    	}else {
    		//进行增加操作
    		returnCount=classcurriculumDetailService.insertClasscurriculumDetail(classcurriculumDetail);
    	}
    	
        //return toAjax(classcurriculumService.insertClasscurriculum(classcurriculum));
    	return toAjax(returnCount);
    }

    /**
     * 修改课
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Classcurriculum classcurriculum = classcurriculumService.selectClasscurriculumById(id);
        mmap.put("classcurriculum", classcurriculum);
        return prefix + "/edit";
    }

    /**
     * 修改保存课
     */
    @Log(title = "课", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Classcurriculum classcurriculum)
    {
        return toAjax(classcurriculumService.updateClasscurriculum(classcurriculum));
    }

    /**
     * 删除课
     */
    @Log(title = "课", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(classcurriculumService.deleteClasscurriculumByIds(ids));
    }
}
