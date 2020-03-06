package com.ruoyi.project.system.examMbtiResult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examMbtiResult.domain.ExamMbtiResult;
import com.ruoyi.project.system.examMbtiResult.mapper.ExamMbtiResultMapper;

/**
 * MBTI类型结果 服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-26
 */
@Service
public class ExamMbtiResultServiceImpl implements IExamMbtiResultService 
{
	@Autowired
	private ExamMbtiResultMapper examMbtiResultMapper;

	/**
     * 查询MBTI类型结果信息
     * 
     * @param id MBTI类型结果ID
     * @return MBTI类型结果信息
     */
    @Override
	public ExamMbtiResult selectExamMbtiResultById(String id)
	{
	    return examMbtiResultMapper.selectExamMbtiResultById(id);
	}
	
	/**
     * 查询MBTI类型结果列表
     * 
     * @param examMbtiResult MBTI类型结果信息
     * @return MBTI类型结果集合
     */
	@Override
	public List<ExamMbtiResult> selectExamMbtiResultList(ExamMbtiResult examMbtiResult)
	{
	    return examMbtiResultMapper.selectExamMbtiResultList(examMbtiResult);
	}
	
    /**
     * 新增MBTI类型结果
     * 
     * @param examMbtiResult MBTI类型结果信息
     * @return 结果
     */
	@Override
	public int insertExamMbtiResult(ExamMbtiResult examMbtiResult)
	{
	    return examMbtiResultMapper.insertExamMbtiResult(examMbtiResult);
	}
	
	/**
     * 修改MBTI类型结果
     * 
     * @param examMbtiResult MBTI类型结果信息
     * @return 结果
     */
	@Override
	public int updateExamMbtiResult(ExamMbtiResult examMbtiResult)
	{
	    return examMbtiResultMapper.updateExamMbtiResult(examMbtiResult);
	}

	/**
     * 删除MBTI类型结果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamMbtiResultByIds(String ids)
	{
		return examMbtiResultMapper.deleteExamMbtiResultByIds(Convert.toStrArray(ids));
	}
	
}
