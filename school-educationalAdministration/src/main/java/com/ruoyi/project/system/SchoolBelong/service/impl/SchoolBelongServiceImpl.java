package com.ruoyi.project.system.SchoolBelong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.SchoolBelong.domain.SchoolBelong;
import com.ruoyi.project.system.SchoolBelong.mapper.SchoolBelongMapper;
import com.ruoyi.project.system.SchoolBelong.service.ISchoolBelongService;

/**
 * 学院分属Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
@Service
public class SchoolBelongServiceImpl implements ISchoolBelongService 
{
    @Autowired
    private SchoolBelongMapper schoolBelongMapper;

    /**
     * 查询学院分属
     * 
     * @param id 学院分属ID
     * @return 学院分属
     */
    @Override
    public SchoolBelong selectSchoolBelongById(Long id)
    {
        return schoolBelongMapper.selectSchoolBelongById(id);
    }

    /**
     * 查询学院分属列表
     * 
     * @param schoolBelong 学院分属
     * @return 学院分属
     */
    @Override
    public List<SchoolBelong> selectSchoolBelongList(SchoolBelong schoolBelong)
    {
        return schoolBelongMapper.selectSchoolBelongList(schoolBelong);
    }

    /**
     * 新增学院分属
     * 
     * @param schoolBelong 学院分属
     * @return 结果
     */
    @Override
    public int insertSchoolBelong(SchoolBelong schoolBelong)
    {
        return schoolBelongMapper.insertSchoolBelong(schoolBelong);
    }

    /**
     * 修改学院分属
     * 
     * @param schoolBelong 学院分属
     * @return 结果
     */
    @Override
    public int updateSchoolBelong(SchoolBelong schoolBelong)
    {
        return schoolBelongMapper.updateSchoolBelong(schoolBelong);
    }

    /**
     * 删除学院分属对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolBelongByIds(String ids)
    {
        return schoolBelongMapper.deleteSchoolBelongByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学院分属信息
     * 
     * @param id 学院分属ID
     * @return 结果
     */
    @Override
    public int deleteSchoolBelongById(Long id)
    {
        return schoolBelongMapper.deleteSchoolBelongById(id);
    }
}
