package com.ruoyi.project.system.examScoreCategory.service;

import com.ruoyi.project.system.examScoreCategory.domain.ExamScoreCategory;
import java.util.List;

/**
 * 测评分类 服务层
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
public interface IExamScoreCategoryService 
{
	/**
     * 查询测评分类信息
     * 
     * @param id 测评分类ID
     * @return 测评分类信息
     */
	public ExamScoreCategory selectExamScoreCategoryById(String id);
	
	/**
     * 查询测评分类列表
     * 
     * @param examScoreCategory 测评分类信息
     * @return 测评分类集合
     */
	public List<ExamScoreCategory> selectExamScoreCategoryList(ExamScoreCategory examScoreCategory);
	
	/**
     * 新增测评分类
     * 
     * @param examScoreCategory 测评分类信息
     * @return 结果
     */
	public int insertExamScoreCategory(ExamScoreCategory examScoreCategory);
	
	/**
     * 修改测评分类
     * 
     * @param examScoreCategory 测评分类信息
     * @return 结果
     */
	public int updateExamScoreCategory(ExamScoreCategory examScoreCategory);
		
	/**
     * 删除测评分类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamScoreCategoryByIds(String ids);
	
}
