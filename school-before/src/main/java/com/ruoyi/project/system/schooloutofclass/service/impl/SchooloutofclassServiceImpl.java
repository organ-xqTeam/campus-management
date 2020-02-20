package com.ruoyi.project.system.schooloutofclass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schooloutofclass.domain.Schooloutofclass;
import com.ruoyi.project.system.schooloutofclass.mapper.SchooloutofclassMapper;
import com.ruoyi.project.system.schooloutofclass.service.ISchooloutofclassService;

/**
 * 课外读物Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
@Service
public class SchooloutofclassServiceImpl implements ISchooloutofclassService 
{
    @Autowired
    private SchooloutofclassMapper schooloutofclassMapper;

    /**
     * 查询课外读物
     * 
     * @param id 课外读物ID
     * @return 课外读物
     */
    @Override
    public Schooloutofclass selectSchooloutofclassById(Long id)
    {
        return schooloutofclassMapper.selectSchooloutofclassById(id);
    }

    /**
     * 查询课外读物列表
     * 
     * @param schooloutofclass 课外读物
     * @return 课外读物
     */
    @Override
    public List<Schooloutofclass> selectSchooloutofclassList(Schooloutofclass schooloutofclass)
    {
        return schooloutofclassMapper.selectSchooloutofclassList(schooloutofclass);
    }

    /**
     * 新增课外读物
     * 
     * @param schooloutofclass 课外读物
     * @return 结果
     */
    @Override
    public int insertSchooloutofclass(Schooloutofclass schooloutofclass)
    {
        return schooloutofclassMapper.insertSchooloutofclass(schooloutofclass);
    }

    /**
     * 修改课外读物
     * 
     * @param schooloutofclass 课外读物
     * @return 结果
     */
    @Override
    public int updateSchooloutofclass(Schooloutofclass schooloutofclass)
    {
        return schooloutofclassMapper.updateSchooloutofclass(schooloutofclass);
    }

    /**
     * 删除课外读物对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchooloutofclassByIds(String ids)
    {
        return schooloutofclassMapper.deleteSchooloutofclassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课外读物信息
     * 
     * @param id 课外读物ID
     * @return 结果
     */
    @Override
    public int deleteSchooloutofclassById(Long id)
    {
        return schooloutofclassMapper.deleteSchooloutofclassById(id);
    }
}
