package com.ruoyi.project.system.examStudentList.controller;

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
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;
import com.ruoyi.project.system.examStudentList.domain.ExamStudentList;
import com.ruoyi.project.system.examStudentList.service.IExamStudentListService;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.service.IExamSubjectShortAnswerService;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
@Controller
@RequestMapping("/system/examstudentlist")
public class ExamStudentListController extends BaseController
{
    private String prefix = "system/examstudentlist";

    @Autowired
    private IExamStudentListService examStudentListService;
    @Autowired
    private ICoursemanagementService coursemanagementService;
    @Autowired
    private IExamSubjectShortAnswerService examSubjectShortAnswerService;

    @RequiresPermissions("system:list:view")
    @GetMapping()
    public String list(@RequestParam("id") String id, ModelMap map)
    {
    	map.put("paperid", id);
    	ExamSubjectShortAnswer paper = examSubjectShortAnswerService.selectExamSubjectShortAnswerById(id);
    	if (paper.getCourseid() != null) {
        	Coursemanagement course = coursemanagementService.selectCoursemanagementById(Long.valueOf(paper.getCourseid()));
        	if (course != null) {
        		map.put("sbid", course.getSbid());
        		map.put("ssid", course.getSsid());
        		map.put("nianji", course.getGrade());
        	}
    	}
        return prefix + "/examstudentlist";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:list:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam Map<String, Object> param)
    {
        startPage();
        List<Map<String, Object>> list = examStudentListService.selectExamStudentListList(param);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:list:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamStudentList examStudentList)
    {
//        List<ExamStudentList> list = examStudentListService.selectExamStudentListList(examStudentList);
//        ExcelUtil<ExamStudentList> util = new ExcelUtil<ExamStudentList>(ExamStudentList.class);
//        return util.exportExcel(list, "list");
    	return null;
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:list:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ExamStudentList examStudentList)
    {
        return toAjax(examStudentListService.insertExamStudentList(examStudentList));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ExamStudentList examStudentList = examStudentListService.selectExamStudentListById(id);
        mmap.put("examStudentList", examStudentList);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:list:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ExamStudentList examStudentList)
    {
        return toAjax(examStudentListService.updateExamStudentList(examStudentList));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:list:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(examStudentListService.deleteExamStudentListByIds(ids));
    }
}
