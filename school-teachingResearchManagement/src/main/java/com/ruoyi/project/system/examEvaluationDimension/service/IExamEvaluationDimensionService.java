package com.ruoyi.project.system.examEvaluationDimension.service;

import com.ruoyi.project.system.examEvaluationDimension.domain.ExamEvaluationDimension;
import java.util.List;

/**
 * 选择题选项 服务层
 * 
 * @author ruoyi
 * @date 2019-08-16
 */
public interface IExamEvaluationDimensionService 
{
	/**
     * 查询选择题选项信息
     * 
     * @param id 选择题选项ID
     * @return 选择题选项信息
     */
	public ExamEvaluationDimension selectExamEvaluationDimensionById(String id);
	
	/**
     * 查询选择题选项列表
     * 
     * @param examEvaluationDimension 选择题选项信息
     * @return 选择题选项集合
     */
	public List<ExamEvaluationDimension> selectExamEvaluationDimensionList(ExamEvaluationDimension examEvaluationDimension);
	
	/**
     * 新增选择题选项
     * 
     * @param examEvaluationDimension 选择题选项信息
     * @return 结果
     */
	public int insertExamEvaluationDimension(ExamEvaluationDimension examEvaluationDimension);
	
	/**
     * 修改选择题选项
     * 
     * @param examEvaluationDimension 选择题选项信息
     * @return 结果
     */
	public int updateExamEvaluationDimension(ExamEvaluationDimension examEvaluationDimension);
		
	/**
     * 删除选择题选项信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamEvaluationDimensionByIds(String ids);
	
}
