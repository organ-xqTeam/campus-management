package com.ruoyi.project.system.examSubjectResult.mapper;

import com.ruoyi.project.system.examSubjectResult.domain.ExamSubjectResult;
import java.util.List;	

/**
 * 科目类型结果 数据层
 * 
 * @author ruoyi
 * @date 2019-10-25
 */
public interface ExamSubjectResultMapper 
{
	/**
     * 查询科目类型结果信息
     * 
     * @param id 科目类型结果ID
     * @return 科目类型结果信息
     */
	public ExamSubjectResult selectExamSubjectResultById(String id);
	
	/**
     * 查询科目类型结果列表
     * 
     * @param examSubjectResult 科目类型结果信息
     * @return 科目类型结果集合
     */
	public List<ExamSubjectResult> selectExamSubjectResultList(ExamSubjectResult examSubjectResult);
	
	/**
     * 新增科目类型结果
     * 
     * @param examSubjectResult 科目类型结果信息
     * @return 结果
     */
	public int insertExamSubjectResult(ExamSubjectResult examSubjectResult);
	
	/**
     * 修改科目类型结果
     * 
     * @param examSubjectResult 科目类型结果信息
     * @return 结果
     */
	public int updateExamSubjectResult(ExamSubjectResult examSubjectResult);
	
	/**
     * 删除科目类型结果
     * 
     * @param id 科目类型结果ID
     * @return 结果
     */
	public int deleteExamSubjectResultById(String id);
	
	/**
     * 批量删除科目类型结果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamSubjectResultByIds(String[] ids);
	
}