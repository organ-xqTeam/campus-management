package com.ruoyi.project.system.schoolenrollmentmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolenrollmentmanagement.domain.Schoolenrollmentmanagement;
import com.ruoyi.project.system.schoolenrollmentmanagement.mapper.SchoolenrollmentmanagementMapper;
import com.ruoyi.project.system.schoolenrollmentmanagement.service.ISchoolenrollmentmanagementService;

/**
 * 招生管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class SchoolenrollmentmanagementServiceImpl implements ISchoolenrollmentmanagementService 
{
    @Autowired
    private SchoolenrollmentmanagementMapper schoolenrollmentmanagementMapper;

    /**
     * 查询招生管理
     * 
     * @param id 招生管理ID
     * @return 招生管理
     */
    @Override
    public Schoolenrollmentmanagement selectSchoolenrollmentmanagementById(Long id)
    {
        return schoolenrollmentmanagementMapper.selectSchoolenrollmentmanagementById(id);
    }

    /**
     * 查询招生管理列表
     * 
     * @param schoolenrollmentmanagement 招生管理
     * @return 招生管理
     */
    @Override
    public List<Schoolenrollmentmanagement> selectSchoolenrollmentmanagementList(Schoolenrollmentmanagement schoolenrollmentmanagement)
    {
        return schoolenrollmentmanagementMapper.selectSchoolenrollmentmanagementList(schoolenrollmentmanagement);
    }

    /**
     * 新增招生管理
     * 
     * @param schoolenrollmentmanagement 招生管理
     * @return 结果
     */
    @Override
    public int insertSchoolenrollmentmanagement(Schoolenrollmentmanagement schoolenrollmentmanagement)
    {
        return schoolenrollmentmanagementMapper.insertSchoolenrollmentmanagement(schoolenrollmentmanagement);
    }

    /**
     * 修改招生管理
     * 
     * @param schoolenrollmentmanagement 招生管理
     * @return 结果
     */
    @Override
    public int updateSchoolenrollmentmanagement(Schoolenrollmentmanagement schoolenrollmentmanagement)
    {
        return schoolenrollmentmanagementMapper.updateSchoolenrollmentmanagement(schoolenrollmentmanagement);
    }

    /**
     * 删除招生管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolenrollmentmanagementByIds(String ids)
    {
        return schoolenrollmentmanagementMapper.deleteSchoolenrollmentmanagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除招生管理信息
     * 
     * @param id 招生管理ID
     * @return 结果
     */
    @Override
    public int deleteSchoolenrollmentmanagementById(Long id)
    {
        return schoolenrollmentmanagementMapper.deleteSchoolenrollmentmanagementById(id);
    }
}
