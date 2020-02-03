package com.ruoyi.project.system.TeachingMaterialManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.TeachingMaterialManagement.domain.TeachingMaterialManagement;
import com.ruoyi.project.system.TeachingMaterialManagement.mapper.TeachingMaterialManagementMapper;
import com.ruoyi.project.system.TeachingMaterialManagement.service.ITeachingMaterialManagementService;

/**
 * 教材管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-21
 */
@Service
public class TeachingMaterialManagementServiceImpl implements ITeachingMaterialManagementService 
{
    @Autowired
    private TeachingMaterialManagementMapper teachingMaterialManagementMapper;

    /**
     * 查询教材管理
     * 
     * @param id 教材管理ID
     * @return 教材管理
     */
    @Override
    public TeachingMaterialManagement selectTeachingMaterialManagementById(Long id)
    {
        return teachingMaterialManagementMapper.selectTeachingMaterialManagementById(id);
    }

    /**
     * 查询教材管理列表
     * 
     * @param teachingMaterialManagement 教材管理
     * @return 教材管理
     */
    @Override
    public List<TeachingMaterialManagement> selectTeachingMaterialManagementList(TeachingMaterialManagement teachingMaterialManagement)
    {
        return teachingMaterialManagementMapper.selectTeachingMaterialManagementList(teachingMaterialManagement);
    }

    /**
     * 新增教材管理
     * 
     * @param teachingMaterialManagement 教材管理
     * @return 结果
     */
    @Override
    public int insertTeachingMaterialManagement(TeachingMaterialManagement teachingMaterialManagement)
    {
        return teachingMaterialManagementMapper.insertTeachingMaterialManagement(teachingMaterialManagement);
    }

    /**
     * 修改教材管理
     * 
     * @param teachingMaterialManagement 教材管理
     * @return 结果
     */
    @Override
    public int updateTeachingMaterialManagement(TeachingMaterialManagement teachingMaterialManagement)
    {
        return teachingMaterialManagementMapper.updateTeachingMaterialManagement(teachingMaterialManagement);
    }

    /**
     * 删除教材管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTeachingMaterialManagementByIds(String ids)
    {
        return teachingMaterialManagementMapper.deleteTeachingMaterialManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教材管理信息
     * 
     * @param id 教材管理ID
     * @return 结果
     */
    @Override
    public int deleteTeachingMaterialManagementById(Long id)
    {
        return teachingMaterialManagementMapper.deleteTeachingMaterialManagementById(id);
    }
}
