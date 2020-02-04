package com.ruoyi.project.system.examSubjectJudgement.mapper;

import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;
import java.util.List;	

/**
 * 简答题 数据层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface ExamSubjectJudgementMapper 
{
	/**
     * 查询简答题信息
     * 
     * @param id 简答题ID
     * @return 简答题信息
     */
	public ExamSubjectJudgement selectExamSubjectJudgementById(String id);
	
	/**
     * 查询简答题列表
     * 
     * @param examSubjectJudgement 简答题信息
     * @return 简答题集合
     */
	public List<ExamSubjectJudgement> selectExamSubjectJudgementList(ExamSubjectJudgement examSubjectJudgement);
	
	/**
     * 新增简答题
     * 
     * @param examSubjectJudgement 简答题信息
     * @return 结果
     */
	public int insertExamSubjectJudgement(ExamSubjectJudgement examSubjectJudgement);
	
	/**
     * 修改简答题
     * 
     * @param examSubjectJudgement 简答题信息
     * @return 结果
     */
	public int updateExamSubjectJudgement(ExamSubjectJudgement examSubjectJudgement);
	
	/**
     * 删除简答题
     * 
     * @param id 简答题ID
     * @return 结果
     */
	public int deleteExamSubjectJudgementById(String id);
	
	/**
     * 批量删除简答题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamSubjectJudgementByIds(String[] ids);
	
}