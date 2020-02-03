package com.ruoyi.project.system.examAccountSequence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examAccountSequence.domain.ExamAccountSequence;
import com.ruoyi.project.system.examAccountSequence.mapper.ExamAccountSequenceMapper;

/**
 * 科目测评维度顺序显示 服务层实现
 * 
 * @author ruoyi
 * @date 2019-10-24
 */
@Service
public class ExamAccountSequenceServiceImpl implements IExamAccountSequenceService 
{
	@Autowired
	private ExamAccountSequenceMapper examAccountSequenceMapper;

	/**
     * 查询科目测评维度顺序显示信息
     * 
     * @param id 科目测评维度顺序显示ID
     * @return 科目测评维度顺序显示信息
     */
    @Override
	public ExamAccountSequence selectExamAccountSequenceById(String id)
	{
	    return examAccountSequenceMapper.selectExamAccountSequenceById(id);
	}
	
	/**
     * 查询科目测评维度顺序显示列表
     * 
     * @param examAccountSequence 科目测评维度顺序显示信息
     * @return 科目测评维度顺序显示集合
     */
	@Override
	public List<ExamAccountSequence> selectExamAccountSequenceList(ExamAccountSequence examAccountSequence)
	{
	    return examAccountSequenceMapper.selectExamAccountSequenceList(examAccountSequence);
	}
	
    /**
     * 新增科目测评维度顺序显示
     * 
     * @param examAccountSequence 科目测评维度顺序显示信息
     * @return 结果
     */
	@Override
	public int insertExamAccountSequence(ExamAccountSequence examAccountSequence)
	{
	    return examAccountSequenceMapper.insertExamAccountSequence(examAccountSequence);
	}
	
	/**
     * 修改科目测评维度顺序显示
     * 
     * @param examAccountSequence 科目测评维度顺序显示信息
     * @return 结果
     */
	@Override
	public int updateExamAccountSequence(ExamAccountSequence examAccountSequence)
	{
	    return examAccountSequenceMapper.updateExamAccountSequence(examAccountSequence);
	}

	/**
     * 删除科目测评维度顺序显示对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamAccountSequenceByIds(String ids)
	{
		return examAccountSequenceMapper.deleteExamAccountSequenceByIds(Convert.toStrArray(ids));
	}
	
}
