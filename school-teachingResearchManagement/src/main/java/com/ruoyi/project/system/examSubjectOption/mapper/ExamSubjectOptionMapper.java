package com.ruoyi.project.system.examSubjectOption.mapper;

import com.ruoyi.project.system.examSubjectOption.domain.ExamSubjectOption;
import java.util.List;	

/**
 * 选择题选项 数据层
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
public interface ExamSubjectOptionMapper 
{
	/**
     * 查询选择题选项信息
     * 
     * @param id 选择题选项ID
     * @return 选择题选项信息
     */
	public ExamSubjectOption selectExamSubjectOptionById(String id);
	
	/**
     * 查询选择题选项列表
     * 
     * @param examSubjectOption 选择题选项信息
     * @return 选择题选项集合
     */
	public List<ExamSubjectOption> selectExamSubjectOptionList(ExamSubjectOption examSubjectOption);
	
	/**
     * 新增选择题选项
     * 
     * @param examSubjectOption 选择题选项信息
     * @return 结果
     */
	public int insertExamSubjectOption(ExamSubjectOption examSubjectOption);
	
	/**
     * 修改选择题选项
     * 
     * @param examSubjectOption 选择题选项信息
     * @return 结果
     */
	public int updateExamSubjectOption(ExamSubjectOption examSubjectOption);
	
	/**
     * 删除选择题选项
     * 
     * @param id 选择题选项ID
     * @return 结果
     */
	public int deleteExamSubjectOptionById(String id);
	
	/**
     * 批量删除选择题选项
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamSubjectOptionByIds(String[] ids);
	
}