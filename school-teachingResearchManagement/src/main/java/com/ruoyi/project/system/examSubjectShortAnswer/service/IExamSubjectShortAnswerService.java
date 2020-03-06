package com.ruoyi.project.system.examSubjectShortAnswer.service;

import com.ruoyi.project.system.examSubjectShortAnswer.domain.ExamSubjectShortAnswer;
import java.util.List;

/**
 * 简答题 服务层
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
public interface IExamSubjectShortAnswerService 
{
	/**
     * 查询简答题信息
     * 
     * @param id 简答题ID
     * @return 简答题信息
     */
	public ExamSubjectShortAnswer selectExamSubjectShortAnswerById(String id);
	
	/**
     * 查询简答题列表
     * 
     * @param examSubjectShortAnswer 简答题信息
     * @return 简答题集合
     */
	public List<ExamSubjectShortAnswer> selectExamSubjectShortAnswerList(ExamSubjectShortAnswer examSubjectShortAnswer);
	
	/**
     * 新增简答题
     * 
     * @param examSubjectShortAnswer 简答题信息
     * @return 结果
     */
	public int insertExamSubjectShortAnswer(ExamSubjectShortAnswer examSubjectShortAnswer);
	
	/**
     * 修改简答题
     * 
     * @param examSubjectShortAnswer 简答题信息
     * @return 结果
     */
	public int updateExamSubjectShortAnswer(ExamSubjectShortAnswer examSubjectShortAnswer);
		
	/**
     * 删除简答题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamSubjectShortAnswerByIds(String ids);

	public int changeStatus(ExamSubjectShortAnswer examSubjectShortAnswer);
	
}
