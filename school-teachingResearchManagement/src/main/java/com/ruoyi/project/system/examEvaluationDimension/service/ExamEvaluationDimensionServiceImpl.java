package com.ruoyi.project.system.examEvaluationDimension.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examEvaluationDimension.domain.ExamEvaluationDimension;
import com.ruoyi.project.system.examEvaluationDimension.mapper.ExamEvaluationDimensionMapper;

/**
 * 选择题选项 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-16
 */
@Service
public class ExamEvaluationDimensionServiceImpl implements IExamEvaluationDimensionService 
{
	@Autowired
	private ExamEvaluationDimensionMapper examEvaluationDimensionMapper;

	/**
     * 查询选择题选项信息
     * 
     * @param id 选择题选项ID
     * @return 选择题选项信息
     */
    @Override
	public ExamEvaluationDimension selectExamEvaluationDimensionById(String id)
	{
	    return examEvaluationDimensionMapper.selectExamEvaluationDimensionById(id);
	}
	
	/**
     * 查询选择题选项列表
     * 
     * @param examEvaluationDimension 选择题选项信息
     * @return 选择题选项集合
     */
	@Override
	public List<ExamEvaluationDimension> selectExamEvaluationDimensionList(ExamEvaluationDimension examEvaluationDimension)
	{
	    return examEvaluationDimensionMapper.selectExamEvaluationDimensionList(examEvaluationDimension);
	}
	
    /**
     * 新增选择题选项
     * 
     * @param examEvaluationDimension 选择题选项信息
     * @return 结果
     */
	@Override
	public int insertExamEvaluationDimension(ExamEvaluationDimension examEvaluationDimension)
	{
	    return examEvaluationDimensionMapper.insertExamEvaluationDimension(examEvaluationDimension);
	}
	
	/**
     * 修改选择题选项
     * 
     * @param examEvaluationDimension 选择题选项信息
     * @return 结果
     */
	@Override
	public int updateExamEvaluationDimension(ExamEvaluationDimension examEvaluationDimension)
	{
	    return examEvaluationDimensionMapper.updateExamEvaluationDimension(examEvaluationDimension);
	}

	/**
     * 删除选择题选项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamEvaluationDimensionByIds(String ids)
	{
		return examEvaluationDimensionMapper.deleteExamEvaluationDimensionByIds(Convert.toStrArray(ids));
	}
	
}
