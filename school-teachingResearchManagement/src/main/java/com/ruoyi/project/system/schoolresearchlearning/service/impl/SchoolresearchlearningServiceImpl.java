package com.ruoyi.project.system.schoolresearchlearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolresearchlearning.domain.Schoolresearchlearning;
import com.ruoyi.project.system.schoolresearchlearning.mapper.SchoolresearchlearningMapper;
import com.ruoyi.project.system.schoolresearchlearning.service.ISchoolresearchlearningService;

/**
 * 研究学习Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
@Service
public class SchoolresearchlearningServiceImpl implements ISchoolresearchlearningService 
{
    @Autowired
    private SchoolresearchlearningMapper schoolresearchlearningMapper;

    /**
     * 查询研究学习
     * 
     * @param id 研究学习ID
     * @return 研究学习
     */
    @Override
    public Schoolresearchlearning selectSchoolresearchlearningById(Long id)
    {
        return schoolresearchlearningMapper.selectSchoolresearchlearningById(id);
    }

    /**
     * 查询研究学习列表
     * 
     * @param schoolresearchlearning 研究学习
     * @return 研究学习
     */
    @Override
    public List<Schoolresearchlearning> selectSchoolresearchlearningList(Schoolresearchlearning schoolresearchlearning)
    {
        return schoolresearchlearningMapper.selectSchoolresearchlearningList(schoolresearchlearning);
    }

    /**
     * 新增研究学习
     * 
     * @param schoolresearchlearning 研究学习
     * @return 结果
     */
    @Override
    public int insertSchoolresearchlearning(Schoolresearchlearning schoolresearchlearning)
    {
        return schoolresearchlearningMapper.insertSchoolresearchlearning(schoolresearchlearning);
    }

    /**
     * 修改研究学习
     * 
     * @param schoolresearchlearning 研究学习
     * @return 结果
     */
    @Override
    public int updateSchoolresearchlearning(Schoolresearchlearning schoolresearchlearning)
    {
        return schoolresearchlearningMapper.updateSchoolresearchlearning(schoolresearchlearning);
    }

    /**
     * 删除研究学习对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolresearchlearningByIds(String ids)
    {
        return schoolresearchlearningMapper.deleteSchoolresearchlearningByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除研究学习信息
     * 
     * @param id 研究学习ID
     * @return 结果
     */
    @Override
    public int deleteSchoolresearchlearningById(Long id)
    {
        return schoolresearchlearningMapper.deleteSchoolresearchlearningById(id);
    }
}
