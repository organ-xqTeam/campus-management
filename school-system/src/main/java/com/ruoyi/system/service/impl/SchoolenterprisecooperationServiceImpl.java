package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Schoolenterprisecooperation;
import com.ruoyi.system.mapper.SchoolenterprisecooperationMapper;
import com.ruoyi.system.service.ISchoolenterprisecooperationService;

/**
 * 校企合作Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class SchoolenterprisecooperationServiceImpl implements ISchoolenterprisecooperationService 
{
    @Autowired
    private SchoolenterprisecooperationMapper schoolenterprisecooperationMapper;

    /**
     * 查询校企合作
     * 
     * @param id 校企合作ID
     * @return 校企合作
     */
    @Override
    public Schoolenterprisecooperation selectSchoolenterprisecooperationById(Long id)
    {
        return schoolenterprisecooperationMapper.selectSchoolenterprisecooperationById(id);
    }

    /**
     * 查询校企合作列表
     * 
     * @param schoolenterprisecooperation 校企合作
     * @return 校企合作
     */
    @Override
    public List<Schoolenterprisecooperation> selectSchoolenterprisecooperationList(Schoolenterprisecooperation schoolenterprisecooperation)
    {
        return schoolenterprisecooperationMapper.selectSchoolenterprisecooperationList(schoolenterprisecooperation);
    }

    /**
     * 新增校企合作
     * 
     * @param schoolenterprisecooperation 校企合作
     * @return 结果
     */
    @Override
    public int insertSchoolenterprisecooperation(Schoolenterprisecooperation schoolenterprisecooperation)
    {
    	schoolenterprisecooperation.setCreateDate(DateUtils.getTime());
        return schoolenterprisecooperationMapper.insertSchoolenterprisecooperation(schoolenterprisecooperation);
    }

    /**
     * 修改校企合作
     * 
     * @param schoolenterprisecooperation 校企合作
     * @return 结果
     */
    @Override
    public int updateSchoolenterprisecooperation(Schoolenterprisecooperation schoolenterprisecooperation)
    {
        return schoolenterprisecooperationMapper.updateSchoolenterprisecooperation(schoolenterprisecooperation);
    }

    /**
     * 删除校企合作对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolenterprisecooperationByIds(String ids)
    {
        return schoolenterprisecooperationMapper.deleteSchoolenterprisecooperationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除校企合作信息
     * 
     * @param id 校企合作ID
     * @return 结果
     */
    @Override
    public int deleteSchoolenterprisecooperationById(Long id)
    {
        return schoolenterprisecooperationMapper.deleteSchoolenterprisecooperationById(id);
    }
}
