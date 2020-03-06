package com.ruoyi.project.system.examOrdinaryResult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examOrdinaryResult.domain.ExamOrdinaryResult;
import com.ruoyi.project.system.examOrdinaryResult.mapper.ExamOrdinaryResultMapper;

/**
 * 普通试题类型结果 服务层实现
 * 
 * @author ruoyi
 * @date 2019-10-25
 */
@Service
public class ExamOrdinaryResultServiceImpl implements IExamOrdinaryResultService 
{
	@Autowired
	private ExamOrdinaryResultMapper examOrdinaryResultMapper;

	/**
     * 查询普通试题类型结果信息
     * 
     * @param id 普通试题类型结果ID
     * @return 普通试题类型结果信息
     */
    @Override
	public ExamOrdinaryResult selectExamOrdinaryResultById(String id)
	{
	    return examOrdinaryResultMapper.selectExamOrdinaryResultById(id);
	}
	
	/**
     * 查询普通试题类型结果列表
     * 
     * @param examOrdinaryResult 普通试题类型结果信息
     * @return 普通试题类型结果集合
     */
	@Override
	public List<ExamOrdinaryResult> selectExamOrdinaryResultList(ExamOrdinaryResult examOrdinaryResult)
	{
	    return examOrdinaryResultMapper.selectExamOrdinaryResultList(examOrdinaryResult);
	}
	
    /**
     * 新增普通试题类型结果
     * 
     * @param examOrdinaryResult 普通试题类型结果信息
     * @return 结果
     */
	@Override
	public int insertExamOrdinaryResult(ExamOrdinaryResult examOrdinaryResult)
	{
	    return examOrdinaryResultMapper.insertExamOrdinaryResult(examOrdinaryResult);
	}
	
	/**
     * 修改普通试题类型结果
     * 
     * @param examOrdinaryResult 普通试题类型结果信息
     * @return 结果
     */
	@Override
	public int updateExamOrdinaryResult(ExamOrdinaryResult examOrdinaryResult)
	{
	    return examOrdinaryResultMapper.updateExamOrdinaryResult(examOrdinaryResult);
	}

	/**
     * 删除普通试题类型结果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamOrdinaryResultByIds(String ids)
	{
		return examOrdinaryResultMapper.deleteExamOrdinaryResultByIds(Convert.toStrArray(ids));
	}
	
}
