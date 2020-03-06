package com.ruoyi.project.system.examSubjectShortAnswer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import com.ruoyi.project.system.examSubjectShortAnswer.mapper.ExamSubjectShortAnswerMapper;

/**
 * 简答题 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
@Service
public class ExamSubjectShortAnswerServiceImpl implements IExamSubjectShortAnswerService 
{
	@Autowired
	private ExamSubjectShortAnswerMapper examSubjectShortAnswerMapper;

	/**
     * 查询简答题信息
     * 
     * @param id 简答题ID
     * @return 简答题信息
     */
    @Override
	public ExamSubjectShortAnswer selectExamSubjectShortAnswerById(String id)
	{
	    return examSubjectShortAnswerMapper.selectExamSubjectShortAnswerById(id);
	}
	
	/**
     * 查询简答题列表
     * 
     * @param examSubjectShortAnswer 简答题信息
     * @return 简答题集合
     */
	@Override
	public List<ExamSubjectShortAnswer> selectExamSubjectShortAnswerList(ExamSubjectShortAnswer examSubjectShortAnswer)
	{
	    return examSubjectShortAnswerMapper.selectExamSubjectShortAnswerList(examSubjectShortAnswer);
	}
	
    /**
     * 新增简答题
     * 
     * @param examSubjectShortAnswer 简答题信息
     * @return 结果
     */
	@Override
	public int insertExamSubjectShortAnswer(ExamSubjectShortAnswer examSubjectShortAnswer)
	{
		examSubjectShortAnswer.setCreateDate(DateUtils.getNowDate());
	    return examSubjectShortAnswerMapper.insertExamSubjectShortAnswer(examSubjectShortAnswer);
	}
	
	/**
     * 修改简答题
     * 
     * @param examSubjectShortAnswer 简答题信息
     * @return 结果
     */
	@Override
	public int updateExamSubjectShortAnswer(ExamSubjectShortAnswer examSubjectShortAnswer)
	{
	    return examSubjectShortAnswerMapper.updateExamSubjectShortAnswer(examSubjectShortAnswer);
	}

	/**
     * 删除简答题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamSubjectShortAnswerByIds(String ids)
	{
		return examSubjectShortAnswerMapper.deleteExamSubjectShortAnswerByIds(Convert.toStrArray(ids));
	}

	@Override
	public int changeStatus(ExamSubjectShortAnswer examSubjectShortAnswer) {
		return examSubjectShortAnswerMapper.updateExamSubjectShortAnswer(examSubjectShortAnswer);
	}
	
}
