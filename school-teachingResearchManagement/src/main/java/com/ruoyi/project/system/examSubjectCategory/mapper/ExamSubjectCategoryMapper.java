package com.ruoyi.project.system.examSubjectCategory.mapper;

import java.util.List;

import com.ruoyi.project.system.examSubjectCategory.domain.ExamSubjectCategory;	

/**
 * 题目分类 数据层
 * 
 * @author ruoyi
 * @date 2019-08-08
 */
public interface ExamSubjectCategoryMapper 
{
	/**
     * 查询题目分类信息
     * 
     * @param id 题目分类ID
     * @return 题目分类信息
     */
	public ExamSubjectCategory selectExamSubjectCategoryById(String id);
	
	/**
     * 查询题目分类列表
     * 
     * @param examSubjectCategory 题目分类信息
     * @return 题目分类集合
     */
	public List<ExamSubjectCategory> selectExamSubjectCategoryList(ExamSubjectCategory examSubjectCategory);
	
	/**
     * 新增题目分类
     * 
     * @param examSubjectCategory 题目分类信息
     * @return 结果
     */
	public int insertExamSubjectCategory(ExamSubjectCategory examSubjectCategory);
	
	/**
     * 修改题目分类
     * 
     * @param examSubjectCategory 题目分类信息
     * @return 结果
     */
	public int updateExamSubjectCategory(ExamSubjectCategory examSubjectCategory);
	
	/**
     * 删除题目分类
     * 
     * @param id 题目分类ID
     * @return 结果
     */
	public int deleteExamSubjectCategoryById(String id);
	
	/**
     * 批量删除题目分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamSubjectCategoryByIds(String[] ids);

	public ExamSubjectCategory selectMenuById(String id);

	public List<ExamSubjectCategory> selectMenuAll();
	
}