package com.ruoyi.project.system.schoolstudentslist.service;

import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import java.util.List;

/**
 * 学生列Service接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface ISchoolstudentslistService 
{
    /**
     * 查询学生列
     * 
     * @param id 学生列ID
     * @return 学生列
     */
    public Schoolstudentslist selectSchoolstudentslistById(Long id);

    /**
     * 查询学生列列表
     * 
     * @param schoolstudentslist 学生列
     * @return 学生列集合
     */
    public List<Schoolstudentslist> selectSchoolstudentslistList(Schoolstudentslist schoolstudentslist);

    /**
     * 导入学生
     * */
    public String importStudent(List<Schoolstudentslist> stuList);
    
    /**
     * 新增学生列
     * 
     * @param schoolstudentslist 学生列
     * @return 结果
     */
    public int insertSchoolstudentslist(Schoolstudentslist schoolstudentslist);

    /**
     * 修改学生列
     * 
     * @param schoolstudentslist 学生列
     * @return 结果
     */
    public int updateSchoolstudentslist(Schoolstudentslist schoolstudentslist);

    /**
     * 批量删除学生列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolstudentslistByIds(String ids);

    /**
     * 删除学生列信息
     * 
     * @param id 学生列ID
     * @return 结果
     */
    public int deleteSchoolstudentslistById(Long id);

	public List<Schoolstudentslist> selectSchoolstudentslistListorderbydetails(Schoolstudentslist schoolstudentslist);

	public List<Schoolstudentslist> selectSchoolstudentslistListUnMove(Schoolstudentslist schoolstudentslist);

	public List<Schoolstudentslist> selectSchoolstudentslistListnotid(Schoolstudentslist schoolstudentslist);
}
