package com.ruoyi.project.system.examOrdinaryResult.mapper;

import com.ruoyi.project.system.examOrdinaryResult.domain.ExamOrdinaryResult;
import java.util.List;	

/**
 * 普通试题类型结果 数据层
 * 
 * @author ruoyi
 * @date 2019-10-25
 */
public interface ExamOrdinaryResultMapper 
{
	/**
     * 查询普通试题类型结果信息
     * 
     * @param id 普通试题类型结果ID
     * @return 普通试题类型结果信息
     */
	public ExamOrdinaryResult selectExamOrdinaryResultById(String id);
	
	/**
     * 查询普通试题类型结果列表
     * 
     * @param examOrdinaryResult 普通试题类型结果信息
     * @return 普通试题类型结果集合
     */
	public List<ExamOrdinaryResult> selectExamOrdinaryResultList(ExamOrdinaryResult examOrdinaryResult);
	
	/**
     * 新增普通试题类型结果
     * 
     * @param examOrdinaryResult 普通试题类型结果信息
     * @return 结果
     */
	public int insertExamOrdinaryResult(ExamOrdinaryResult examOrdinaryResult);
	
	/**
     * 修改普通试题类型结果
     * 
     * @param examOrdinaryResult 普通试题类型结果信息
     * @return 结果
     */
	public int updateExamOrdinaryResult(ExamOrdinaryResult examOrdinaryResult);
	
	/**
     * 删除普通试题类型结果
     * 
     * @param id 普通试题类型结果ID
     * @return 结果
     */
	public int deleteExamOrdinaryResultById(String id);
	
	/**
     * 批量删除普通试题类型结果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamOrdinaryResultByIds(String[] ids);
	
}