package com.ruoyi.project.system.SchoolSpecialty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import com.ruoyi.project.system.SchoolSpecialty.mapper.SchoolSpecialtyMapper;
import com.ruoyi.project.system.SchoolSpecialty.service.ISchoolSpecialtyService;

/**
 * 学校专业Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
@Service
public class SchoolSpecialtyServiceImpl implements ISchoolSpecialtyService 
{
    @Autowired
    private SchoolSpecialtyMapper schoolSpecialtyMapper;

    /**
     * 查询学校专业
     * 
     * @param id 学校专业ID
     * @return 学校专业
     */
    @Override
    public SchoolSpecialty selectSchoolSpecialtyById(Long id)
    {
        return schoolSpecialtyMapper.selectSchoolSpecialtyById(id);
    }

    /**
     * 查询学校专业列表
     * 
     * @param schoolSpecialty 学校专业
     * @return 学校专业
     */
    @Override
    public List<SchoolSpecialty> selectSchoolSpecialtyList(SchoolSpecialty schoolSpecialty)
    {
        return schoolSpecialtyMapper.selectSchoolSpecialtyList(schoolSpecialty);
    }

    /**
     * 新增学校专业
     * 
     * @param schoolSpecialty 学校专业
     * @return 结果
     */
    @Override
    public int insertSchoolSpecialty(SchoolSpecialty schoolSpecialty)
    {
        return schoolSpecialtyMapper.insertSchoolSpecialty(schoolSpecialty);
    }

    /**
     * 修改学校专业
     * 
     * @param schoolSpecialty 学校专业
     * @return 结果
     */
    @Override
    public int updateSchoolSpecialty(SchoolSpecialty schoolSpecialty)
    {
        return schoolSpecialtyMapper.updateSchoolSpecialty(schoolSpecialty);
    }

    /**
     * 删除学校专业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolSpecialtyByIds(String ids)
    {
        return schoolSpecialtyMapper.deleteSchoolSpecialtyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学校专业信息
     * 
     * @param id 学校专业ID
     * @return 结果
     */
    @Override
    public int deleteSchoolSpecialtyById(Long id)
    {
        return schoolSpecialtyMapper.deleteSchoolSpecialtyById(id);
    }
}
