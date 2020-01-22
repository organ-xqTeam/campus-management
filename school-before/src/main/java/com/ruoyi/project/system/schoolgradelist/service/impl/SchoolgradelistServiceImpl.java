package com.ruoyi.project.system.schoolgradelist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import com.ruoyi.project.system.schoolgradelist.mapper.SchoolgradelistMapper;
import com.ruoyi.project.system.schoolgradelist.service.ISchoolgradelistService;

/**
 * 年级管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
@Service
public class SchoolgradelistServiceImpl implements ISchoolgradelistService 
{
    @Autowired
    private SchoolgradelistMapper schoolgradelistMapper;

    /**
     * 查询年级管理
     * 
     * @param id 年级管理ID
     * @return 年级管理
     */
    @Override
    public Schoolgradelist selectSchoolgradelistById(String id)
    {
        return schoolgradelistMapper.selectSchoolgradelistById(id);
    }

    /**
     * 查询年级管理列表
     * 
     * @param schoolgradelist 年级管理
     * @return 年级管理
     */
    @Override
    public List<Schoolgradelist> selectSchoolgradelistList(Schoolgradelist schoolgradelist)
    {
        return schoolgradelistMapper.selectSchoolgradelistList(schoolgradelist);
    }

    /**
     * 新增年级管理
     * 
     * @param schoolgradelist 年级管理
     * @return 结果
     */
    @Override
    public int insertSchoolgradelist(Schoolgradelist schoolgradelist)
    {
        return schoolgradelistMapper.insertSchoolgradelist(schoolgradelist);
    }

    /**
     * 修改年级管理
     * 
     * @param schoolgradelist 年级管理
     * @return 结果
     */
    @Override
    public int updateSchoolgradelist(Schoolgradelist schoolgradelist)
    {
        return schoolgradelistMapper.updateSchoolgradelist(schoolgradelist);
    }

    /**
     * 删除年级管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolgradelistByIds(String ids)
    {
        return schoolgradelistMapper.deleteSchoolgradelistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除年级管理信息
     * 
     * @param id 年级管理ID
     * @return 结果
     */
    @Override
    public int deleteSchoolgradelistById(String id)
    {
        return schoolgradelistMapper.deleteSchoolgradelistById(id);
    }
}
