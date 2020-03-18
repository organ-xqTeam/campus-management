package com.ruoyi.project.system.schoolstudentdetails.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.schoolstudentdetails.domain.Schoolstudentdetails;

/**
 * 学生明细Service接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface ISchoolstudentdetailsService 
{
    /**
     * 查询学生明细
     * 
     * @param id 学生明细ID
     * @return 学生明细
     */
    public Schoolstudentdetails selectSchoolstudentdetailsById(Long id);

    /**
     * 查询学生明细列表
     * 
     * @param schoolstudentdetails 学生明细
     * @return 学生明细集合
     */
    public List<Schoolstudentdetails> selectSchoolstudentdetailsList(Schoolstudentdetails schoolstudentdetails);
    public List<Map<String, Object>> selectSchoolstudentdetailsList(Map<String, Object> param);

    /**
     * 新增学生明细
     * 
     * @param schoolstudentdetails 学生明细
     * @return 结果
     */
    public int insertSchoolstudentdetails(Schoolstudentdetails schoolstudentdetails);

    /**
     * 修改学生明细
     * 
     * @param schoolstudentdetails 学生明细
     * @return 结果
     */
    public int updateSchoolstudentdetails(Schoolstudentdetails schoolstudentdetails);

    /**
     * 批量删除学生明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolstudentdetailsByIds(String ids);

    /**
     * 删除学生明细信息
     * 
     * @param id 学生明细ID
     * @return 结果
     */
    public int deleteSchoolstudentdetailsById(Long id);
}
