package com.ruoyi.project.system.examExaminationSubject.mapper;

import com.ruoyi.project.system.examExaminationSubject.domain.ExamExaminationSubject;
import java.util.List;	

/**
 * 考试题目 数据层
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
public interface ExamExaminationSubjectMapper 
{
	/**
     * 查询考试题目信息
     * 
     * @param id 考试题目ID
     * @return 考试题目信息
     */
	public ExamExaminationSubject selectExamExaminationSubjectById(String id);
	
	/**
     * 查询考试题目列表
     * 
     * @param examExaminationSubject 考试题目信息
     * @return 考试题目集合
     */
	public List<ExamExaminationSubject> selectExamExaminationSubjectList(ExamExaminationSubject examExaminationSubject);
	
	/**
     * 新增考试题目
     * 
     * @param examExaminationSubject 考试题目信息
     * @return 结果
     */
	public int insertExamExaminationSubject(ExamExaminationSubject examExaminationSubject);
	
	/**
     * 修改考试题目
     * 
     * @param examExaminationSubject 考试题目信息
     * @return 结果
     */
	public int updateExamExaminationSubject(ExamExaminationSubject examExaminationSubject);
	
	/**
     * 删除考试题目
     * 
     * @param id 考试题目ID
     * @return 结果
     */
	public int deleteExamExaminationSubjectById(String id);
	
	/**
     * 批量删除考试题目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamExaminationSubjectByIds(String[] ids);
	
}