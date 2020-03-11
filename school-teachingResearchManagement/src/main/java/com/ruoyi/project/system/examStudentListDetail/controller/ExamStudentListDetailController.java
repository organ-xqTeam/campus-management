package com.ruoyi.project.system.examStudentListDetail.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.examStudentListDetail.domain.ExamStudentListDetail;
import com.ruoyi.project.system.examStudentListDetail.service.IExamStudentListDetailService;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import com.ruoyi.project.system.examSubjectJudgement.service.IExamSubjectJudgementService;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
@Controller
@RequestMapping("/system/examstudentlistdetail")
public class ExamStudentListDetailController extends BaseController
{
    private String prefix = "system/examstudentlistdetail";

    @Autowired
    private IExamSubjectJudgementService examSubjectJudgementService;
    @Autowired
    private IExamStudentListDetailService examStudentListDetailService;

    @RequiresPermissions("system:detail:view")
    @GetMapping()
    public String detail(@RequestParam("did") String did, ModelMap map)
    {
    	map.put("detailid", did);
        return prefix + "/examstudentlistdetail";
    }
    
    @RequiresPermissions("system:detail:view")
    @GetMapping("/see")
    public String see(@RequestParam("qid") String qid, ModelMap map)
    {
    	ExamSubjectJudgement question = examSubjectJudgementService.selectExamSubjectJudgementById(qid);
    	map.put("question", question);
        return prefix + "/see";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam Map<String, Object> param)
    {
        startPage();
        List<Map<String, Object>> list = examStudentListDetailService.selectExamStudentListDetail(param);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:detail:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExamStudentListDetail examStudentListDetail)
    {
        List<ExamStudentListDetail> list = examStudentListDetailService.selectExamStudentListDetailList(examStudentListDetail);
        ExcelUtil<ExamStudentListDetail> util = new ExcelUtil<ExamStudentListDetail>(ExamStudentListDetail.class);
        return util.exportExcel(list, "detail");
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
    @RequiresPermissions("system:detail:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ExamStudentListDetail examStudentListDetail)
    {
        return toAjax(examStudentListDetailService.insertExamStudentListDetail(examStudentListDetail));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ExamStudentListDetail examStudentListDetail = examStudentListDetailService.selectExamStudentListDetailById(id);
        mmap.put("examStudentListDetail", examStudentListDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:detail:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ExamStudentListDetail examStudentListDetail)
    {
        return toAjax(examStudentListDetailService.updateExamStudentListDetail(examStudentListDetail));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:detail:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(examStudentListDetailService.deleteExamStudentListDetailByIds(ids));
    }
}
