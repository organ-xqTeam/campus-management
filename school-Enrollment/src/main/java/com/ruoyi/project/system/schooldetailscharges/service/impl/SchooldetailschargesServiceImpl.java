package com.ruoyi.project.system.schooldetailscharges.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schooldetailscharges.domain.Schooldetailscharges;
import com.ruoyi.project.system.schooldetailscharges.mapper.SchooldetailschargesMapper;
import com.ruoyi.project.system.schooldetailscharges.service.ISchooldetailschargesService;

/**
 * 收费明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class SchooldetailschargesServiceImpl implements ISchooldetailschargesService 
{
    @Autowired
    private SchooldetailschargesMapper schooldetailschargesMapper;

    /**
     * 查询收费明细
     * 
     * @param id 收费明细ID
     * @return 收费明细
     */
    @Override
    public Schooldetailscharges selectSchooldetailschargesById(Long id)
    {
        return schooldetailschargesMapper.selectSchooldetailschargesById(id);
    }

    /**
     * 查询收费明细列表
     * 
     * @param schooldetailscharges 收费明细
     * @return 收费明细
     */
    @Override
    public List<Schooldetailscharges> selectSchooldetailschargesList(Schooldetailscharges schooldetailscharges)
    {
        return schooldetailschargesMapper.selectSchooldetailschargesList(schooldetailscharges);
    }

    /**
     * 新增收费明细
     * 
     * @param schooldetailscharges 收费明细
     * @return 结果
     */
    @Override
    public int insertSchooldetailscharges(Schooldetailscharges schooldetailscharges)
    {
        return schooldetailschargesMapper.insertSchooldetailscharges(schooldetailscharges);
    }

    /**
     * 修改收费明细
     * 
     * @param schooldetailscharges 收费明细
     * @return 结果
     */
    @Override
    public int updateSchooldetailscharges(Schooldetailscharges schooldetailscharges)
    {
        return schooldetailschargesMapper.updateSchooldetailscharges(schooldetailscharges);
    }

    /**
     * 删除收费明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchooldetailschargesByIds(String ids)
    {
        return schooldetailschargesMapper.deleteSchooldetailschargesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收费明细信息
     * 
     * @param id 收费明细ID
     * @return 结果
     */
    @Override
    public int deleteSchooldetailschargesById(Long id)
    {
        return schooldetailschargesMapper.deleteSchooldetailschargesById(id);
    }

	@Override
	public int changeStatus(Schooldetailscharges schooldetailscharges) {
		 return schooldetailschargesMapper.updateSchooldetailscharges(schooldetailscharges);
	}
}
