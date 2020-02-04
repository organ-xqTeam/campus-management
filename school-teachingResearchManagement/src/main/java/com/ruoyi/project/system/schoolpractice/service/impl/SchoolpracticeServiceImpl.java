package com.ruoyi.project.system.schoolpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolpractice.domain.Schoolpractice;
import com.ruoyi.project.system.schoolpractice.mapper.SchoolpracticeMapper;
import com.ruoyi.project.system.schoolpractice.service.ISchoolpracticeService;

/**
 * 综合实践Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
@Service
public class SchoolpracticeServiceImpl implements ISchoolpracticeService 
{
    @Autowired
    private SchoolpracticeMapper schoolpracticeMapper;

    /**
     * 查询综合实践
     * 
     * @param id 综合实践ID
     * @return 综合实践
     */
    @Override
    public Schoolpractice selectSchoolpracticeById(Long id)
    {
        return schoolpracticeMapper.selectSchoolpracticeById(id);
    }

    /**
     * 查询综合实践列表
     * 
     * @param schoolpractice 综合实践
     * @return 综合实践
     */
    @Override
    public List<Schoolpractice> selectSchoolpracticeList(Schoolpractice schoolpractice)
    {
        return schoolpracticeMapper.selectSchoolpracticeList(schoolpractice);
    }

    /**
     * 新增综合实践
     * 
     * @param schoolpractice 综合实践
     * @return 结果
     */
    @Override
    public int insertSchoolpractice(Schoolpractice schoolpractice)
    {
        return schoolpracticeMapper.insertSchoolpractice(schoolpractice);
    }

    /**
     * 修改综合实践
     * 
     * @param schoolpractice 综合实践
     * @return 结果
     */
    @Override
    public int updateSchoolpractice(Schoolpractice schoolpractice)
    {
        return schoolpracticeMapper.updateSchoolpractice(schoolpractice);
    }

    /**
     * 删除综合实践对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolpracticeByIds(String ids)
    {
        return schoolpracticeMapper.deleteSchoolpracticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除综合实践信息
     * 
     * @param id 综合实践ID
     * @return 结果
     */
    @Override
    public int deleteSchoolpracticeById(Long id)
    {
        return schoolpracticeMapper.deleteSchoolpracticeById(id);
    }
}
