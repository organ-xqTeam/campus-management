package com.ruoyi.project.system.schoolmobilearticle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolmobilearticle.domain.Schoolmobilearticle;
import com.ruoyi.project.system.schoolmobilearticle.mapper.SchoolmobilearticleMapper;
import com.ruoyi.project.system.schoolmobilearticle.service.ISchoolmobilearticleService;

/**
 * 通知公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
@Service
public class SchoolmobilearticleServiceImpl implements ISchoolmobilearticleService 
{
    @Autowired
    private SchoolmobilearticleMapper schoolmobilearticleMapper;

    /**
     * 查询通知公告
     * 
     * @param id 通知公告ID
     * @return 通知公告
     */
    @Override
    public Schoolmobilearticle selectSchoolmobilearticleById(Long id)
    {
        return schoolmobilearticleMapper.selectSchoolmobilearticleById(id);
    }

    /**
     * 查询通知公告列表
     * 
     * @param schoolmobilearticle 通知公告
     * @return 通知公告
     */
    @Override
    public List<Schoolmobilearticle> selectSchoolmobilearticleList(Schoolmobilearticle schoolmobilearticle)
    {
        return schoolmobilearticleMapper.selectSchoolmobilearticleList(schoolmobilearticle);
    }

    /**
     * 新增通知公告
     * 
     * @param schoolmobilearticle 通知公告
     * @return 结果
     */
    @Override
    public int insertSchoolmobilearticle(Schoolmobilearticle schoolmobilearticle)
    {
        return schoolmobilearticleMapper.insertSchoolmobilearticle(schoolmobilearticle);
    }

    /**
     * 修改通知公告
     * 
     * @param schoolmobilearticle 通知公告
     * @return 结果
     */
    @Override
    public int updateSchoolmobilearticle(Schoolmobilearticle schoolmobilearticle)
    {
        return schoolmobilearticleMapper.updateSchoolmobilearticle(schoolmobilearticle);
    }

    /**
     * 删除通知公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolmobilearticleByIds(String ids)
    {
        return schoolmobilearticleMapper.deleteSchoolmobilearticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除通知公告信息
     * 
     * @param id 通知公告ID
     * @return 结果
     */
    @Override
    public int deleteSchoolmobilearticleById(Long id)
    {
        return schoolmobilearticleMapper.deleteSchoolmobilearticleById(id);
    }
}
