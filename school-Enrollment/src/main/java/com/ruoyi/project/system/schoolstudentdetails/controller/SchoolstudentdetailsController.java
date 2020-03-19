package com.ruoyi.project.system.schoolstudentdetails.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.schoolchargemanagement.domain.Schoolchargemanagement;
import com.ruoyi.project.system.schoolchargemanagement.service.ISchoolchargemanagementService;
import com.ruoyi.project.system.schooldetailscharges.domain.Schooldetailscharges;
import com.ruoyi.project.system.schooldetailscharges.service.ISchooldetailschargesService;
import com.ruoyi.project.system.schoolstudentdetails.domain.Schoolstudentdetails;
import com.ruoyi.project.system.schoolstudentdetails.service.ISchoolstudentdetailsService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;

/**
 * 学生明细Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/schoolstudentdetails")
public class SchoolstudentdetailsController extends BaseController
{
    private String prefix = "system/schoolstudentdetails";
    
    @Autowired
    private ISchooldetailschargesService schooldetailschargesService;@Autowired
    private ISchoolchargemanagementService schoolchargemanagementService;
    @Autowired
    private ISchoolstudentslistService schoolstudentslistService;
    @Autowired
    private ISchoolstudentdetailsService schoolstudentdetailsService;

    @RequiresPermissions("system:schoolstudentdetails:view")
    @GetMapping("")
    public String schoolstudentdetails(
    		@RequestParam("cid") String cid, ModelMap mmap
//    		@PathVariable("id") Long id, ModelMap mmap
    ){	
    	mmap.put("cid", cid);
    	return prefix + "/schoolstudentdetails";
//    	Schooldetailscharges sss = schooldetailschargesService.selectSchooldetailschargesById(id);
//    	List<Schoolstudentslist> studentslists = schoolstudentslistService.selectSchoolstudentslistList(null);    	
//    	mmap.put("studentdetails", sss);
//    	mmap.put("studentslists", studentslists);
//        return prefix + "/schoolstudentdetails";
    }

    
    /**
     * 查询学生列列表
     */
    @RequiresPermissions("system:schoolstudentslist:list")
    @PostMapping("/studentslistService/list/{id}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("id") Long id , Schoolstudentslist schoolstudentslist)
    {	
    	
    	schoolstudentslist.setRemark17(id+"");
    	//收费明细 id 
    	System.out.println(id);
        startPage();
        List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistListorderbydetails(schoolstudentslist);
        return getDataTable(list);
    }
    
    /**
     * 查询学生明细列表
     */
    @RequiresPermissions("system:schoolstudentdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(
    		@RequestParam("cid") String cid
//    		@PathVariable("id") Long id,Schoolstudentdetails schoolstudentdetails
    ){
    	System.out.println(cid);
    	Map<String, Object> param = new HashMap<String, Object>();
    	Schoolchargemanagement sc = schoolchargemanagementService.selectSchoolchargemanagementById(Long.valueOf(cid));
    	param.put("cid", cid);
    	param.put("remark2", sc.getRemark2());
    	param.put("remark3", sc.getRemark3());
    	param.put("remark4", sc.getRemark4());
    	List<Map<String, Object>> list = schoolstudentdetailsService.selectSchoolstudentdetailsList(param);
    	return getDataTable(list);
//    	schoolstudentdetails.setChargingDetailsId(id+"");
//        startPage();
//        List<Schoolstudentdetails> list = schoolstudentdetailsService.selectSchoolstudentdetailsList(schoolstudentdetails);
//        return getDataTable(list);
    }

    /**
     * 导出学生明细列表
     */
    @RequiresPermissions("system:schoolstudentdetails:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schoolstudentdetails schoolstudentdetails)
    {
        List<Schoolstudentdetails> list = schoolstudentdetailsService.selectSchoolstudentdetailsList(schoolstudentdetails);
        ExcelUtil<Schoolstudentdetails> util = new ExcelUtil<Schoolstudentdetails>(Schoolstudentdetails.class);
        return util.exportExcel(list, "schoolstudentdetails");
    }

    /**
     * 新增学生明细
     */
    @GetMapping("/studentslist")
    public String studentslist()
    {
        return prefix + "/studentslist";
    }
    /**
     * 新增学生明细
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Schooldetailscharges sss = schooldetailschargesService.selectSchooldetailschargesById(id);
    	
//    	List<Schoolstudentslist> list = schoolstudentslistService.selectSchoolstudentslistList(null);
    	
    	mmap.put("studentdetails", sss);
//    	mmap.put("studentlist", list);
    	return prefix + "/add";
    }

    /**
     * 新增保存学生明细
     */
    @RequiresPermissions("system:schoolstudentdetails:add")
    @Log(title = "学生明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schoolstudentdetails schoolstudentdetails)
    {	
    	
    	String paid = schoolstudentdetails.getChargingDetailsId();
    	String json =  schoolstudentdetails.getRemark2();
    	schoolstudentdetails.setRemark2(null);
    	JSONArray array = JSONArray.parseArray(json);
    	
    	System.out.println(paid);
    	System.out.println(array.toJSONString());
    	
    	List<Schoolstudentdetails> list = new ArrayList<Schoolstudentdetails>();
    	for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			Schoolstudentdetails studentdetails = new Schoolstudentdetails();
			
			object.get("name");
			object.get("nameid");
			String state =  (String) object.get("state");
			String id =  (String) object.get("id");
			studentdetails.setChargingDetailsId(paid);
			studentdetails.setRemark("已缴费".equals(state)?"1":"0");
			studentdetails.setStudentId(id);
			list.add(studentdetails);
		}
    	int row=0;
    	for (Schoolstudentdetails schoolstudentdetails2 : list) {
    		row +=schoolstudentdetailsService.insertSchoolstudentdetails(schoolstudentdetails2);
		}
    	
    	
//        return toAjax(schoolstudentdetailsService.insertSchoolstudentdetails(schoolstudentdetails));
    	return toAjax(row);
    }

    /**
     * 修改学生明细
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Schoolstudentdetails schoolstudentdetails = schoolstudentdetailsService.selectSchoolstudentdetailsById(id);
        mmap.put("schoolstudentdetails", schoolstudentdetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生明细
     */
    @RequiresPermissions("system:schoolstudentdetails:edit")
    @Log(title = "学生明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schoolstudentdetails schoolstudentdetails)
    {
        return toAjax(schoolstudentdetailsService.updateSchoolstudentdetails(schoolstudentdetails));
    }
    @RequiresPermissions("system:schoolstudentdetails:edit")
    @Log(title = "修改学生明细缴费状态", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Schoolstudentdetails schoolstudentdetails)
    {
    	List<Schoolstudentdetails> list = schoolstudentdetailsService.selectSchoolstudentdetailsList(schoolstudentdetails);
    	if (list.size() == 0) {
    		schoolstudentdetailsService.insertSchoolstudentdetails(schoolstudentdetails);
    	}
    	else {
    		schoolstudentdetails.setId(list.get(0).getId());
    		schoolstudentdetailsService.updateSchoolstudentdetails(schoolstudentdetails);
    	}
    	return toAjax(true);
    }

    /**
     * 删除学生明细
     */
    @RequiresPermissions("system:schoolstudentdetails:remove")
    @Log(title = "学生明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schoolstudentdetailsService.deleteSchoolstudentdetailsByIds(ids));
    }
}
