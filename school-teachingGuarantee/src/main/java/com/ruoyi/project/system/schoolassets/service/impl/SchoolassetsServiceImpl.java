package com.ruoyi.project.system.schoolassets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.schoolassets.domain.Schoolassets;
import com.ruoyi.project.system.schoolassets.mapper.SchoolassetsMapper;
import com.ruoyi.project.system.schoolassets.service.ISchoolassetsService;

/**
 * 资产管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SchoolassetsServiceImpl implements ISchoolassetsService 
{
    @Autowired
    private SchoolassetsMapper schoolassetsMapper;

    /**
     * 查询资产管理
     * 
     * @param id 资产管理ID
     * @return 资产管理
     */
    @Override
    public Schoolassets selectSchoolassetsById(Long id)
    {
        return schoolassetsMapper.selectSchoolassetsById(id);
    }

    /**
     * 查询资产管理列表
     * 
     * @param schoolassets 资产管理
     * @return 资产管理
     */
    @Override
    public List<Schoolassets> selectSchoolassetsList(Schoolassets schoolassets)
    {
        return schoolassetsMapper.selectSchoolassetsList(schoolassets);
    }

    /**
     * 新增资产管理
     * 
     * @param schoolassets 资产管理
     * @return 结果
     */
    @Override
    public int insertSchoolassets(Schoolassets schoolassets)
    {
    	schoolassets.setCreatedate(DateUtils.getTime());
        return schoolassetsMapper.insertSchoolassets(schoolassets);
    }

    /**
     * 修改资产管理
     * 
     * @param schoolassets 资产管理
     * @return 结果
     */
    @Override
    public int updateSchoolassets(Schoolassets schoolassets)
    {
        return schoolassetsMapper.updateSchoolassets(schoolassets);
    }

    /**
     * 删除资产管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolassetsByIds(String ids)
    {
        return schoolassetsMapper.deleteSchoolassetsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资产管理信息
     * 
     * @param id 资产管理ID
     * @return 结果
     */
    @Override
    public int deleteSchoolassetsById(Long id)
    {
        return schoolassetsMapper.deleteSchoolassetsById(id);
    }
}
