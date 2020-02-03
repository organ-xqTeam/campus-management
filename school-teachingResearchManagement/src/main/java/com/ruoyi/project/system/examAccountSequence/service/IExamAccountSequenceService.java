package com.ruoyi.project.system.examAccountSequence.service;

import com.ruoyi.project.system.examAccountSequence.domain.ExamAccountSequence;
import java.util.List;

/**
 * 科目测评维度顺序显示 服务层
 * 
 * @author ruoyi
 * @date 2019-10-24
 */
public interface IExamAccountSequenceService 
{
	/**
     * 查询科目测评维度顺序显示信息
     * 
     * @param id 科目测评维度顺序显示ID
     * @return 科目测评维度顺序显示信息
     */
	public ExamAccountSequence selectExamAccountSequenceById(String id);
	
	/**
     * 查询科目测评维度顺序显示列表
     * 
     * @param examAccountSequence 科目测评维度顺序显示信息
     * @return 科目测评维度顺序显示集合
     */
	public List<ExamAccountSequence> selectExamAccountSequenceList(ExamAccountSequence examAccountSequence);
	
	/**
     * 新增科目测评维度顺序显示
     * 
     * @param examAccountSequence 科目测评维度顺序显示信息
     * @return 结果
     */
	public int insertExamAccountSequence(ExamAccountSequence examAccountSequence);
	
	/**
     * 修改科目测评维度顺序显示
     * 
     * @param examAccountSequence 科目测评维度顺序显示信息
     * @return 结果
     */
	public int updateExamAccountSequence(ExamAccountSequence examAccountSequence);
		
	/**
     * 删除科目测评维度顺序显示信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamAccountSequenceByIds(String ids);
	
}
