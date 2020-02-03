package com.ruoyi.project.system.TeachingAvtivity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.TeachingAvtivity.domain.TeachingAvtivity;
import com.ruoyi.project.system.TeachingAvtivity.mapper.TeachingAvtivityMapper;
import com.ruoyi.project.system.TeachingAvtivity.service.ITeachingAvtivityService;

/**
 * 教学活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-03
 */
@Service
public class TeachingAvtivityServiceImpl implements ITeachingAvtivityService 
{
    @Autowired
    private TeachingAvtivityMapper teachingAvtivityMapper;

    /**
     * 查询教学活动
     * 
     * @param id 教学活动ID
     * @return 教学活动
     */
    @Override
    public TeachingAvtivity selectTeachingAvtivityById(Long id)
    {
        return teachingAvtivityMapper.selectTeachingAvtivityById(id);
    }

    /**
     * 查询教学活动列表
     * 
     * @param teachingAvtivity 教学活动
     * @return 教学活动
     */
    @Override
    public List<TeachingAvtivity> selectTeachingAvtivityList(TeachingAvtivity teachingAvtivity)
    {
        return teachingAvtivityMapper.selectTeachingAvtivityList(teachingAvtivity);
    }

    /**
     * 新增教学活动
     * 
     * @param teachingAvtivity 教学活动
     * @return 结果
     */
    @Override
    public int insertTeachingAvtivity(TeachingAvtivity teachingAvtivity)
    {
        return teachingAvtivityMapper.insertTeachingAvtivity(teachingAvtivity);
    }

    /**
     * 修改教学活动
     * 
     * @param teachingAvtivity 教学活动
     * @return 结果
     */
    @Override
    public int updateTeachingAvtivity(TeachingAvtivity teachingAvtivity)
    {
        return teachingAvtivityMapper.updateTeachingAvtivity(teachingAvtivity);
    }

    /**
     * 删除教学活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTeachingAvtivityByIds(String ids)
    {
        return teachingAvtivityMapper.deleteTeachingAvtivityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教学活动信息
     * 
     * @param id 教学活动ID
     * @return 结果
     */
    @Override
    public int deleteTeachingAvtivityById(Long id)
    {
        return teachingAvtivityMapper.deleteTeachingAvtivityById(id);
    }
}
