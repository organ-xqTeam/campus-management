package com.ruoyi.project.system.examExaminationSubject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examExaminationSubject.domain.ExamExaminationSubject;
import com.ruoyi.project.system.examExaminationSubject.mapper.ExamExaminationSubjectMapper;

/**
 * 考试题目 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
@Service
public class ExamExaminationSubjectServiceImpl implements IExamExaminationSubjectService 
{
	@Autowired
	private ExamExaminationSubjectMapper examExaminationSubjectMapper;

	/**
     * 查询考试题目信息
     * 
     * @param id 考试题目ID
     * @return 考试题目信息
     */
    @Override
	public ExamExaminationSubject selectExamExaminationSubjectById(String id)
	{
	    return examExaminationSubjectMapper.selectExamExaminationSubjectById(id);
	}
	
	/**
     * 查询考试题目列表
     * 
     * @param examExaminationSubject 考试题目信息
     * @return 考试题目集合
     */
	@Override
	public List<ExamExaminationSubject> selectExamExaminationSubjectList(ExamExaminationSubject examExaminationSubject)
	{
	    return examExaminationSubjectMapper.selectExamExaminationSubjectList(examExaminationSubject);
	}
	
    /**
     * 新增考试题目
     * 
     * @param examExaminationSubject 考试题目信息
     * @return 结果
     */
	@Override
	public int insertExamExaminationSubject(ExamExaminationSubject examExaminationSubject)
	{
	    return examExaminationSubjectMapper.insertExamExaminationSubject(examExaminationSubject);
	}
	
	/**
     * 修改考试题目
     * 
     * @param examExaminationSubject 考试题目信息
     * @return 结果
     */
	@Override
	public int updateExamExaminationSubject(ExamExaminationSubject examExaminationSubject)
	{
	    return examExaminationSubjectMapper.updateExamExaminationSubject(examExaminationSubject);
	}

	/**
     * 删除考试题目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamExaminationSubjectByIds(String ids)
	{
		return examExaminationSubjectMapper.deleteExamExaminationSubjectByIds(Convert.toStrArray(ids));
	}
	
}
