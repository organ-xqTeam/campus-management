package com.ruoyi.project.system.schooldorm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schooldorm.domain.Schooldorm;
import com.ruoyi.project.system.schooldorm.mapper.SchooldormMapper;
import com.ruoyi.project.system.schooldorm.service.ISchooldormService;

/**
 * 宿舍Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-14
 */
@Service
public class SchooldormServiceImpl implements ISchooldormService 
{
    @Autowired
    private SchooldormMapper schooldormMapper;

    /**
     * 查询宿舍
     * 
     * @param id 宿舍ID
     * @return 宿舍
     */
    @Override
    public Schooldorm selectSchooldormById(Long id)
    {
        return schooldormMapper.selectSchooldormById(id);
    }

    /**
     * 查询宿舍列表
     * 
     * @param schooldorm 宿舍
     * @return 宿舍
     */
    @Override
    public List<Schooldorm> selectSchooldormList(Schooldorm schooldorm)
    {
        return schooldormMapper.selectSchooldormList(schooldorm);
    }

    /**
     * 新增宿舍
     * 
     * @param schooldorm 宿舍
     * @return 结果
     */
    @Override
    public int insertSchooldorm(Schooldorm schooldorm)
    {
        return schooldormMapper.insertSchooldorm(schooldorm);
    }

    /**
     * 修改宿舍
     * 
     * @param schooldorm 宿舍
     * @return 结果
     */
    @Override
    public int updateSchooldorm(Schooldorm schooldorm)
    {
        return schooldormMapper.updateSchooldorm(schooldorm);
    }

    /**
     * 删除宿舍对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchooldormByIds(String ids)
    {
        return schooldormMapper.deleteSchooldormByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除宿舍信息
     * 
     * @param id 宿舍ID
     * @return 结果
     */
    @Override
    public int deleteSchooldormById(Long id)
    {
        return schooldormMapper.deleteSchooldormById(id);
    }
}
