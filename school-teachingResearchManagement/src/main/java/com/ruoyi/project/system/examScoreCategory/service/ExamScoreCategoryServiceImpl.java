package com.ruoyi.project.system.examScoreCategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examScoreCategory.domain.ExamScoreCategory;
import com.ruoyi.project.system.examScoreCategory.mapper.ExamScoreCategoryMapper;

/**
 * 测评分类 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
@Service
public class ExamScoreCategoryServiceImpl implements IExamScoreCategoryService 
{
	@Autowired
	private ExamScoreCategoryMapper examScoreCategoryMapper;

	/**
     * 查询测评分类信息
     * 
     * @param id 测评分类ID
     * @return 测评分类信息
     */
    @Override
	public ExamScoreCategory selectExamScoreCategoryById(String id)
	{
	    return examScoreCategoryMapper.selectExamScoreCategoryById(id);
	}
	
	/**
     * 查询测评分类列表
     * 
     * @param examScoreCategory 测评分类信息
     * @return 测评分类集合
     */
	@Override
	public List<ExamScoreCategory> selectExamScoreCategoryList(ExamScoreCategory examScoreCategory)
	{
	    return examScoreCategoryMapper.selectExamScoreCategoryList(examScoreCategory);
	}
	
    /**
     * 新增测评分类
     * 
     * @param examScoreCategory 测评分类信息
     * @return 结果
     */
	@Override
	public int insertExamScoreCategory(ExamScoreCategory examScoreCategory)
	{
	    return examScoreCategoryMapper.insertExamScoreCategory(examScoreCategory);
	}
	
	/**
     * 修改测评分类
     * 
     * @param examScoreCategory 测评分类信息
     * @return 结果
     */
	@Override
	public int updateExamScoreCategory(ExamScoreCategory examScoreCategory)
	{
	    return examScoreCategoryMapper.updateExamScoreCategory(examScoreCategory);
	}

	/**
     * 删除测评分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamScoreCategoryByIds(String ids)
	{
		return examScoreCategoryMapper.deleteExamScoreCategoryByIds(Convert.toStrArray(ids));
	}
	
}
