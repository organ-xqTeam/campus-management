package com.ruoyi.project.system.schooldormrecord.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schooldormrecord.domain.Schooldormrecord;
import com.ruoyi.project.system.schooldormrecord.mapper.SchooldormrecordMapper;
import com.ruoyi.project.system.schooldormrecord.service.ISchooldormrecordService;

/**
 * 住宿记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-18
 */
@Service
public class SchooldormrecordServiceImpl implements ISchooldormrecordService 
{
    @Autowired
    private SchooldormrecordMapper schooldormrecordMapper;

    /**
     * 查询住宿记录
     * 
     * @param id 住宿记录ID
     * @return 住宿记录
     */
    @Override
    public Schooldormrecord selectSchooldormrecordById(Long id)
    {
        return schooldormrecordMapper.selectSchooldormrecordById(id);
    }

    /**
     * 查询住宿记录列表
     * 
     * @param schooldormrecord 住宿记录
     * @return 住宿记录
     */
    @Override
    public List<Schooldormrecord> selectSchooldormrecordList(Schooldormrecord schooldormrecord)
    {
        return schooldormrecordMapper.selectSchooldormrecordList(schooldormrecord);
    }

    /**
     * 新增住宿记录
     * 
     * @param schooldormrecord 住宿记录
     * @return 结果
     */
    @Override
    public int insertSchooldormrecord(Schooldormrecord schooldormrecord)
    {
        return schooldormrecordMapper.insertSchooldormrecord(schooldormrecord);
    }

    /**
     * 修改住宿记录
     * 
     * @param schooldormrecord 住宿记录
     * @return 结果
     */
    @Override
    public int updateSchooldormrecord(Schooldormrecord schooldormrecord)
    {
        return schooldormrecordMapper.updateSchooldormrecord(schooldormrecord);
    }

    /**
     * 删除住宿记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchooldormrecordByIds(String ids)
    {
        return schooldormrecordMapper.deleteSchooldormrecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除住宿记录信息
     * 
     * @param id 住宿记录ID
     * @return 结果
     */
    @Override
    public int deleteSchooldormrecordById(Long id)
    {
        return schooldormrecordMapper.deleteSchooldormrecordById(id);
    }
}
