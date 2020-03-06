package com.ruoyi.project.system.examAdInformation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examAdInformation.domain.ExamAdInformation;
import com.ruoyi.project.system.examAdInformation.mapper.ExamAdInformationMapper;

/**
 * 广告的 服务层实现
 * 
 * @author ruoyi
 * @date 2019-10-23
 */
@Service
public class ExamAdInformationServiceImpl implements IExamAdInformationService 
{
	@Autowired
	private ExamAdInformationMapper examAdInformationMapper;

	/**
     * 查询广告的信息
     * 
     * @param id 广告的ID
     * @return 广告的信息
     */
    @Override
	public ExamAdInformation selectExamAdInformationById(Long id)
	{
	    return examAdInformationMapper.selectExamAdInformationById(id);
	}
	
	/**
     * 查询广告的列表
     * 
     * @param examAdInformation 广告的信息
     * @return 广告的集合
     */
	@Override
	public List<ExamAdInformation> selectExamAdInformationList(ExamAdInformation examAdInformation)
	{
	    return examAdInformationMapper.selectExamAdInformationList(examAdInformation);
	}
	
    /**
     * 新增广告的
     * 
     * @param examAdInformation 广告的信息
     * @return 结果
     */
	@Override
	public int insertExamAdInformation(ExamAdInformation examAdInformation)
	{
	    return examAdInformationMapper.insertExamAdInformation(examAdInformation);
	}
	
	/**
     * 修改广告的
     * 
     * @param examAdInformation 广告的信息
     * @return 结果
     */
	@Override
	public int updateExamAdInformation(ExamAdInformation examAdInformation)
	{
	    return examAdInformationMapper.updateExamAdInformation(examAdInformation);
	}

	/**
     * 删除广告的对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamAdInformationByIds(String ids)
	{
		return examAdInformationMapper.deleteExamAdInformationByIds(Convert.toStrArray(ids));
	}
	
}
