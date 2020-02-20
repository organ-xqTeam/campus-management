package com.ruoyi.project.system.schoolstudentsleavelist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolstudentsleavelist.domain.Schoolstudentsleavelist;
import com.ruoyi.project.system.schoolstudentsleavelist.mapper.SchoolstudentsleavelistMapper;
import com.ruoyi.project.system.schoolstudentsleavelist.service.ISchoolstudentsleavelistService;

/**
 * 学生请假Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
@Service
public class SchoolstudentsleavelistServiceImpl implements ISchoolstudentsleavelistService 
{
    @Autowired
    private SchoolstudentsleavelistMapper schoolstudentsleavelistMapper;

    /**
     * 查询学生请假
     * 
     * @param id 学生请假ID
     * @return 学生请假
     */
    @Override
    public Schoolstudentsleavelist selectSchoolstudentsleavelistById(Long id)
    {
        return schoolstudentsleavelistMapper.selectSchoolstudentsleavelistById(id);
    }

    /**
     * 查询学生请假列表
     * 
     * @param schoolstudentsleavelist 学生请假
     * @return 学生请假
     */
    @Override
    public List<Schoolstudentsleavelist> selectSchoolstudentsleavelistList(Schoolstudentsleavelist schoolstudentsleavelist)
    {
        return schoolstudentsleavelistMapper.selectSchoolstudentsleavelistList(schoolstudentsleavelist);
    }

    /**
     * 新增学生请假
     * 
     * @param schoolstudentsleavelist 学生请假
     * @return 结果
     */
    @Override
    public int insertSchoolstudentsleavelist(Schoolstudentsleavelist schoolstudentsleavelist)
    {
        return schoolstudentsleavelistMapper.insertSchoolstudentsleavelist(schoolstudentsleavelist);
    }

    /**
     * 修改学生请假
     * 
     * @param schoolstudentsleavelist 学生请假
     * @return 结果
     */
    @Override
    public int updateSchoolstudentsleavelist(Schoolstudentsleavelist schoolstudentsleavelist)
    {
        return schoolstudentsleavelistMapper.updateSchoolstudentsleavelist(schoolstudentsleavelist);
    }

    /**
     * 删除学生请假对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudentsleavelistByIds(String ids)
    {
        return schoolstudentsleavelistMapper.deleteSchoolstudentsleavelistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生请假信息
     * 
     * @param id 学生请假ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudentsleavelistById(Long id)
    {
        return schoolstudentsleavelistMapper.deleteSchoolstudentsleavelistById(id);
    }
}
