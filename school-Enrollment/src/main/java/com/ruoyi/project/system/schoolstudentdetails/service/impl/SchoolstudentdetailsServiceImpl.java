package com.ruoyi.project.system.schoolstudentdetails.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolstudentdetails.domain.Schoolstudentdetails;
import com.ruoyi.project.system.schoolstudentdetails.mapper.SchoolstudentdetailsMapper;
import com.ruoyi.project.system.schoolstudentdetails.service.ISchoolstudentdetailsService;

/**
 * 学生明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class SchoolstudentdetailsServiceImpl implements ISchoolstudentdetailsService 
{
    @Autowired
    private SchoolstudentdetailsMapper schoolstudentdetailsMapper;

    /**
     * 查询学生明细
     * 
     * @param id 学生明细ID
     * @return 学生明细
     */
    @Override
    public Schoolstudentdetails selectSchoolstudentdetailsById(Long id)
    {
        return schoolstudentdetailsMapper.selectSchoolstudentdetailsById(id);
    }

    /**
     * 查询学生明细列表
     * 
     * @param schoolstudentdetails 学生明细
     * @return 学生明细
     */
    @Override
    public List<Schoolstudentdetails> selectSchoolstudentdetailsList(Schoolstudentdetails schoolstudentdetails)
    {
        return schoolstudentdetailsMapper.selectSchoolstudentdetailsList(schoolstudentdetails);
    }
    @Override
    public List<Map<String, Object>> selectSchoolstudentdetailsList(Map<String, Object> param)
    {
        return schoolstudentdetailsMapper.selectSchoolstudentdetailsList2(param);
    }
    /**
     * 新增学生明细
     * 
     * @param schoolstudentdetails 学生明细
     * @return 结果
     */
    @Override
    public int insertSchoolstudentdetails(Schoolstudentdetails schoolstudentdetails)
    {
        return schoolstudentdetailsMapper.insertSchoolstudentdetails(schoolstudentdetails);
    }

    /**
     * 修改学生明细
     * 
     * @param schoolstudentdetails 学生明细
     * @return 结果
     */
    @Override
    public int updateSchoolstudentdetails(Schoolstudentdetails schoolstudentdetails)
    {
        return schoolstudentdetailsMapper.updateSchoolstudentdetails(schoolstudentdetails);
    }

    /**
     * 删除学生明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudentdetailsByIds(String ids)
    {
        return schoolstudentdetailsMapper.deleteSchoolstudentdetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生明细信息
     * 
     * @param id 学生明细ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudentdetailsById(Long id)
    {
        return schoolstudentdetailsMapper.deleteSchoolstudentdetailsById(id);
    }
}
