package com.ruoyi.project.system.examSubjectJudgement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import com.ruoyi.project.system.examSubjectJudgement.mapper.ExamSubjectJudgementMapper;

/**
 * 简答题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Service
public class ExamSubjectJudgementServiceImpl implements IExamSubjectJudgementService 
{
	@Autowired
	private ExamSubjectJudgementMapper examSubjectJudgementMapper;

	/**
     * 查询简答题信息
     * 
     * @param id 简答题ID
     * @return 简答题信息
     */
    @Override
	public ExamSubjectJudgement selectExamSubjectJudgementById(String id)
	{
	    return examSubjectJudgementMapper.selectExamSubjectJudgementById(id);
	}
	
	/**
     * 查询简答题列表
     * 
     * @param examSubjectJudgement 简答题信息
     * @return 简答题集合
     */
	@Override
	public List<ExamSubjectJudgement> selectExamSubjectJudgementList(ExamSubjectJudgement examSubjectJudgement)
	{
	    return examSubjectJudgementMapper.selectExamSubjectJudgementList(examSubjectJudgement);
	}
	
    /**
     * 新增简答题
     * 
     * @param examSubjectJudgement 简答题信息
     * @return 结果
     */
	@Override
	public int insertExamSubjectJudgement(ExamSubjectJudgement examSubjectJudgement)
	{
		examSubjectJudgement.setCreateDate(DateUtils.getNowDate());
	    return examSubjectJudgementMapper.insertExamSubjectJudgement(examSubjectJudgement);
	}
	
	/**
     * 修改简答题
     * 
     * @param examSubjectJudgement 简答题信息
     * @return 结果
     */
	@Override
	public int updateExamSubjectJudgement(ExamSubjectJudgement examSubjectJudgement)
	{
	    return examSubjectJudgementMapper.updateExamSubjectJudgement(examSubjectJudgement);
	}

	/**
     * 删除简答题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamSubjectJudgementByIds(String ids)
	{
		return examSubjectJudgementMapper.deleteExamSubjectJudgementByIds(Convert.toStrArray(ids));
	}
	
}
