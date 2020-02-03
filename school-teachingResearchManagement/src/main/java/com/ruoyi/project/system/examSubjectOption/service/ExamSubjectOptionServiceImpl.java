package com.ruoyi.project.system.examSubjectOption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examSubjectOption.domain.ExamSubjectOption;
import com.ruoyi.project.system.examSubjectOption.mapper.ExamSubjectOptionMapper;

/**
 * 选择题选项 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-10
 */
@Service
public class ExamSubjectOptionServiceImpl implements IExamSubjectOptionService 
{
	@Autowired
	private ExamSubjectOptionMapper examSubjectOptionMapper;

	/**
     * 查询选择题选项信息
     * 
     * @param id 选择题选项ID
     * @return 选择题选项信息
     */
    @Override
	public ExamSubjectOption selectExamSubjectOptionById(String id)
	{
	    return examSubjectOptionMapper.selectExamSubjectOptionById(id);
	}
	
	/**
     * 查询选择题选项列表
     * 
     * @param examSubjectOption 选择题选项信息
     * @return 选择题选项集合
     */
	@Override
	public List<ExamSubjectOption> selectExamSubjectOptionList(ExamSubjectOption examSubjectOption)
	{
	    return examSubjectOptionMapper.selectExamSubjectOptionList(examSubjectOption);
	}
	
    /**
     * 新增选择题选项
     * 
     * @param examSubjectOption 选择题选项信息
     * @return 结果
     */
	@Override
	public int insertExamSubjectOption(ExamSubjectOption examSubjectOption)
	{
	    return examSubjectOptionMapper.insertExamSubjectOption(examSubjectOption);
	}
	
	/**
     * 修改选择题选项
     * 
     * @param examSubjectOption 选择题选项信息
     * @return 结果
     */
	@Override
	public int updateExamSubjectOption(ExamSubjectOption examSubjectOption)
	{
	    return examSubjectOptionMapper.updateExamSubjectOption(examSubjectOption);
	}

	/**
     * 删除选择题选项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamSubjectOptionByIds(String ids)
	{
		return examSubjectOptionMapper.deleteExamSubjectOptionByIds(Convert.toStrArray(ids));
	}
	
}
