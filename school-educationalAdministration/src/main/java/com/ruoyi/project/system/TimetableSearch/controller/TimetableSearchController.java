package com.ruoyi.project.system.TimetableSearch.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.system.TimetableSearch.domain.TimetableSearch;
import com.ruoyi.project.system.TimetableSearch.service.ITimetableSearchService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人人事安排查询Controller
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
@Controller
@RequestMapping("/system/TimetableSearch")
public class TimetableSearchController extends BaseController
{
    private String prefix = "system/TimetableSearch";

    @Autowired
    private ITimetableSearchService timetableSearchService;

    @RequiresPermissions("system:TimetableSearch:view")
    @GetMapping()
    public String TimetableSearch()
    {
        return prefix + "/TimetableSearch";
    }

    /**
     * 查询个人人事安排查询列表
     */
    @RequiresPermissions("system:TimetableSearch:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TimetableSearch timetableSearch)
    {
        startPage();
        List<TimetableSearch> list = timetableSearchService.selectTimetableSearchList(timetableSearch);
        for (TimetableSearch timetableSearch2 : list) {
        	String detailPosition= timetableSearch2.getDetailPosition();
        	String[] detailPositionss= detailPosition.split("-");
        	if(detailPositionss.length>=2) {
        		String xingqiNum=detailPosition.split("-")[0];
        		String jiekeNum=detailPosition.split("-")[1];
        		System.out.println(xingqiNum+"--------"+jiekeNum);
        		String weekStr="";
        		String dayStr="";
        		switch (jiekeNum) {
				case "1":
					dayStr="第一节";
					break;
				case "2":
					dayStr="第二节";
					break;
				case "3":
					dayStr="第三节";
					break;
				case "4":
					dayStr="第四节";
					break;
				case "5":
					dayStr="第五节";
					break;
				case "6":
					dayStr="第六节";
					break;
				case "7":
					dayStr="第七节";
					break;
				case "8":
					dayStr="第八节";
					break;
				case "9":
					dayStr="第九节";
					break;
				default:
					break;
				}
        		switch (xingqiNum) {
				case "1":
					weekStr="星期一";
					break;
				case "2":
					weekStr="星期二";
					break;
				case "3":
					weekStr="星期三";
					break;
				case "4":
					weekStr="星期四";
					break;
				case "5":
					weekStr="星期五";
					break;
				case "6":
					weekStr="星期六";
					break;
				case "7":
					weekStr="星期日";
					break;
				default:
					break;
				}
        		timetableSearch2.setWeekName(weekStr);
        		timetableSearch2.setTimeName(dayStr);
        	}
		}
        return getDataTable(list);
    }

    /**
     * 导出个人人事安排查询列表
     */
    @RequiresPermissions("system:TimetableSearch:export")
    @Log(title = "个人人事安排查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TimetableSearch timetableSearch)
    {
        List<TimetableSearch> list = timetableSearchService.selectTimetableSearchList(timetableSearch);
        ExcelUtil<TimetableSearch> util = new ExcelUtil<TimetableSearch>(TimetableSearch.class);
        return util.exportExcel(list, "TimetableSearch");
    }

    /**
     * 新增个人人事安排查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存个人人事安排查询
     */
    @RequiresPermissions("system:TimetableSearch:add")
    @Log(title = "个人人事安排查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TimetableSearch timetableSearch)
    {
        return toAjax(timetableSearchService.insertTimetableSearch(timetableSearch));
    }

    /**
     * 修改个人人事安排查询
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TimetableSearch timetableSearch = timetableSearchService.selectTimetableSearchById(id);
        mmap.put("timetableSearch", timetableSearch);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人人事安排查询
     */
    @RequiresPermissions("system:TimetableSearch:edit")
    @Log(title = "个人人事安排查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TimetableSearch timetableSearch)
    {
        return toAjax(timetableSearchService.updateTimetableSearch(timetableSearch));
    }

    /**
     * 删除个人人事安排查询
     */
    @RequiresPermissions("system:TimetableSearch:remove")
    @Log(title = "个人人事安排查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(timetableSearchService.deleteTimetableSearchByIds(ids));
    }
}
