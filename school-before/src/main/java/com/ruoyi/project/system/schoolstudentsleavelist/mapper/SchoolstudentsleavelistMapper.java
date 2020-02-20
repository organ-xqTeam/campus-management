package com.ruoyi.project.system.schoolstudentsleavelist.mapper;

import com.ruoyi.project.system.schoolstudentsleavelist.domain.Schoolstudentsleavelist;
import java.util.List;

/**
 * 学生请假Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public interface SchoolstudentsleavelistMapper 
{
    /**
     * 查询学生请假
     * 
     * @param id 学生请假ID
     * @return 学生请假
     */
    public Schoolstudentsleavelist selectSchoolstudentsleavelistById(Long id);

    /**
     * 查询学生请假列表
     * 
     * @param schoolstudentsleavelist 学生请假
     * @return 学生请假集合
     */
    public List<Schoolstudentsleavelist> selectSchoolstudentsleavelistList(Schoolstudentsleavelist schoolstudentsleavelist);

    /**
     * 新增学生请假
     * 
     * @param schoolstudentsleavelist 学生请假
     * @return 结果
     */
    public int insertSchoolstudentsleavelist(Schoolstudentsleavelist schoolstudentsleavelist);

    /**
     * 修改学生请假
     * 
     * @param schoolstudentsleavelist 学生请假
     * @return 结果
     */
    public int updateSchoolstudentsleavelist(Schoolstudentsleavelist schoolstudentsleavelist);

    /**
     * 删除学生请假
     * 
     * @param id 学生请假ID
     * @return 结果
     */
    public int deleteSchoolstudentsleavelistById(Long id);

    /**
     * 批量删除学生请假
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolstudentsleavelistByIds(String[] ids);
}
