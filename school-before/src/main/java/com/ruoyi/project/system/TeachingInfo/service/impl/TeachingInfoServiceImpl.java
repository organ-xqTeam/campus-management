package com.ruoyi.project.system.TeachingInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import com.ruoyi.project.system.TeachingInfo.mapper.TeachingInfoMapper;
import com.ruoyi.project.system.TeachingInfo.service.ITeachingInfoService;

/**
 * 教师管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-22
 */
@Service
public class TeachingInfoServiceImpl implements ITeachingInfoService 
{
    @Autowired
    private TeachingInfoMapper teachingInfoMapper;

    /**
     * 查询教师管理
     * 
     * @param id 教师管理ID
     * @return 教师管理
     */
    @Override
    public TeachingInfo selectTeachingInfoById(Long id)
    {
        return teachingInfoMapper.selectTeachingInfoById(id);
    }

    /**
     * 查询教师管理列表
     * 
     * @param teachingInfo 教师管理
     * @return 教师管理
     */
    @Override
    public List<TeachingInfo> selectTeachingInfoList(TeachingInfo teachingInfo)
    {
        return teachingInfoMapper.selectTeachingInfoList(teachingInfo);
    }

    /**
     * 新增教师管理
     * 
     * @param teachingInfo 教师管理
     * @return 结果
     */
    @Override
    public int insertTeachingInfo(TeachingInfo teachingInfo)
    {
        return teachingInfoMapper.insertTeachingInfo(teachingInfo);
    }

    /**
     * 修改教师管理
     * 
     * @param teachingInfo 教师管理
     * @return 结果
     */
    @Override
    public int updateTeachingInfo(TeachingInfo teachingInfo)
    {
        return teachingInfoMapper.updateTeachingInfo(teachingInfo);
    }

    /**
     * 删除教师管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTeachingInfoByIds(String ids)
    {
        return teachingInfoMapper.deleteTeachingInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教师管理信息
     * 
     * @param id 教师管理ID
     * @return 结果
     */
    @Override
    public int deleteTeachingInfoById(Long id)
    {
        return teachingInfoMapper.deleteTeachingInfoById(id);
    }
}
