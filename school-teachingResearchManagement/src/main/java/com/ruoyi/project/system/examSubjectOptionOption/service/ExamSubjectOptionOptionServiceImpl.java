package com.ruoyi.project.system.examSubjectOptionOption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examSubjectOptionOption.domain.ExamSubjectOptionOption;
import com.ruoyi.project.system.examSubjectOptionOption.mapper.ExamSubjectOptionOptionMapper;

/**
 * 选择题选项 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-13
 */
@Service
public class ExamSubjectOptionOptionServiceImpl implements IExamSubjectOptionOptionService 
{
	@Autowired
	private ExamSubjectOptionOptionMapper examSubjectOptionOptionMapper;

	/**
     * 查询选择题选项信息
     * 
     * @param id 选择题选项ID
     * @return 选择题选项信息
     */
    @Override
	public ExamSubjectOptionOption selectExamSubjectOptionOptionById(String id)
	{
	    return examSubjectOptionOptionMapper.selectExamSubjectOptionOptionById(id);
	}
	
	/**
     * 查询选择题选项列表
     * 
     * @param examSubjectOptionOption 选择题选项信息
     * @return 选择题选项集合
     */
	@Override
	public List<ExamSubjectOptionOption> selectExamSubjectOptionOptionList(ExamSubjectOptionOption examSubjectOptionOption)
	{
	    return examSubjectOptionOptionMapper.selectExamSubjectOptionOptionList(examSubjectOptionOption);
	}
	
    /**
     * 新增选择题选项
     * 
     * @param examSubjectOptionOption 选择题选项信息
     * @return 结果
     */
	@Override
	public int insertExamSubjectOptionOption(ExamSubjectOptionOption examSubjectOptionOption)
	{
	    return examSubjectOptionOptionMapper.insertExamSubjectOptionOption(examSubjectOptionOption);
	}
	
	/**
     * 修改选择题选项
     * 
     * @param examSubjectOptionOption 选择题选项信息
     * @return 结果
     */
	@Override
	public int updateExamSubjectOptionOption(ExamSubjectOptionOption examSubjectOptionOption)
	{
	    return examSubjectOptionOptionMapper.updateExamSubjectOptionOption(examSubjectOptionOption);
	}

	/**
     * 删除选择题选项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamSubjectOptionOptionByIds(String ids)
	{
		return examSubjectOptionOptionMapper.deleteExamSubjectOptionOptionByIds(Convert.toStrArray(ids));
	}
	
}
