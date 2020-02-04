package com.ruoyi.project.system.examSubjectOptionOption.mapper;

import com.ruoyi.project.system.examSubjectOptionOption.domain.ExamSubjectOptionOption;
import java.util.List;	

/**
 * 选择题选项 数据层
 * 
 * @author ruoyi
 * @date 2019-08-13
 */
public interface ExamSubjectOptionOptionMapper 
{
	/**
     * 查询选择题选项信息
     * 
     * @param id 选择题选项ID
     * @return 选择题选项信息
     */
	public ExamSubjectOptionOption selectExamSubjectOptionOptionById(String id);
	
	/**
     * 查询选择题选项列表
     * 
     * @param examSubjectOptionOption 选择题选项信息
     * @return 选择题选项集合
     */
	public List<ExamSubjectOptionOption> selectExamSubjectOptionOptionList(ExamSubjectOptionOption examSubjectOptionOption);
	
	/**
     * 新增选择题选项
     * 
     * @param examSubjectOptionOption 选择题选项信息
     * @return 结果
     */
	public int insertExamSubjectOptionOption(ExamSubjectOptionOption examSubjectOptionOption);
	
	/**
     * 修改选择题选项
     * 
     * @param examSubjectOptionOption 选择题选项信息
     * @return 结果
     */
	public int updateExamSubjectOptionOption(ExamSubjectOptionOption examSubjectOptionOption);
	
	/**
     * 删除选择题选项
     * 
     * @param id 选择题选项ID
     * @return 结果
     */
	public int deleteExamSubjectOptionOptionById(String id);
	
	/**
     * 批量删除选择题选项
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamSubjectOptionOptionByIds(String[] ids);
	
}