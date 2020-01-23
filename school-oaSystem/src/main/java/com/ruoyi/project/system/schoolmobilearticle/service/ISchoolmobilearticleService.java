package com.ruoyi.project.system.schoolmobilearticle.service;

import com.ruoyi.project.system.schoolmobilearticle.domain.Schoolmobilearticle;
import java.util.List;

/**
 * 通知公告Service接口
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
public interface ISchoolmobilearticleService 
{
    /**
     * 查询通知公告
     * 
     * @param id 通知公告ID
     * @return 通知公告
     */
    public Schoolmobilearticle selectSchoolmobilearticleById(Long id);

    /**
     * 查询通知公告列表
     * 
     * @param schoolmobilearticle 通知公告
     * @return 通知公告集合
     */
    public List<Schoolmobilearticle> selectSchoolmobilearticleList(Schoolmobilearticle schoolmobilearticle);

    /**
     * 新增通知公告
     * 
     * @param schoolmobilearticle 通知公告
     * @return 结果
     */
    public int insertSchoolmobilearticle(Schoolmobilearticle schoolmobilearticle);

    /**
     * 修改通知公告
     * 
     * @param schoolmobilearticle 通知公告
     * @return 结果
     */
    public int updateSchoolmobilearticle(Schoolmobilearticle schoolmobilearticle);

    /**
     * 批量删除通知公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolmobilearticleByIds(String ids);

    /**
     * 删除通知公告信息
     * 
     * @param id 通知公告ID
     * @return 结果
     */
    public int deleteSchoolmobilearticleById(Long id);
}
