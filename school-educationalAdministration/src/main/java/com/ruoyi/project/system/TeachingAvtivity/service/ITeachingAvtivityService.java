package com.ruoyi.project.system.TeachingAvtivity.service;

import java.util.List;

import com.ruoyi.project.system.TeachingAvtivity.domain.TeachingAvtivity;

/**
 * 教学活动Service接口
 * 
 * @author ruoyi
 * @date 2020-02-03
 */
public interface ITeachingAvtivityService 
{
    /**
     * 查询教学活动
     * 
     * @param id 教学活动ID
     * @return 教学活动
     */
    public TeachingAvtivity selectTeachingAvtivityById(Long id);

    /**
     * 查询教学活动列表
     * 
     * @param teachingAvtivity 教学活动
     * @return 教学活动集合
     */
    public List<TeachingAvtivity> selectTeachingAvtivityList(TeachingAvtivity teachingAvtivity);

    /**
     * 新增教学活动
     * 
     * @param teachingAvtivity 教学活动
     * @return 结果
     */
    public int insertTeachingAvtivity(TeachingAvtivity teachingAvtivity);

    /**
     * 修改教学活动
     * 
     * @param teachingAvtivity 教学活动
     * @return 结果
     */
    public int updateTeachingAvtivity(TeachingAvtivity teachingAvtivity);

    /**
     * 批量删除教学活动
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTeachingAvtivityByIds(String ids);

    /**
     * 删除教学活动信息
     * 
     * @param id 教学活动ID
     * @return 结果
     */
    public int deleteTeachingAvtivityById(Long id);
}
