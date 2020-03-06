package com.ruoyi.project.system.examMbtiResult.mapper;

import com.ruoyi.project.system.examMbtiResult.domain.ExamMbtiResult;
import java.util.List;	

/**
 * MBTI类型结果 数据层
 * 
 * @author ruoyi
 * @date 2019-09-26
 */
public interface ExamMbtiResultMapper 
{
	/**
     * 查询MBTI类型结果信息
     * 
     * @param id MBTI类型结果ID
     * @return MBTI类型结果信息
     */
	public ExamMbtiResult selectExamMbtiResultById(String id);
	
	/**
     * 查询MBTI类型结果列表
     * 
     * @param examMbtiResult MBTI类型结果信息
     * @return MBTI类型结果集合
     */
	public List<ExamMbtiResult> selectExamMbtiResultList(ExamMbtiResult examMbtiResult);
	
	/**
     * 新增MBTI类型结果
     * 
     * @param examMbtiResult MBTI类型结果信息
     * @return 结果
     */
	public int insertExamMbtiResult(ExamMbtiResult examMbtiResult);
	
	/**
     * 修改MBTI类型结果
     * 
     * @param examMbtiResult MBTI类型结果信息
     * @return 结果
     */
	public int updateExamMbtiResult(ExamMbtiResult examMbtiResult);
	
	/**
     * 删除MBTI类型结果
     * 
     * @param id MBTI类型结果ID
     * @return 结果
     */
	public int deleteExamMbtiResultById(String id);
	
	/**
     * 批量删除MBTI类型结果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamMbtiResultByIds(String[] ids);
	
}