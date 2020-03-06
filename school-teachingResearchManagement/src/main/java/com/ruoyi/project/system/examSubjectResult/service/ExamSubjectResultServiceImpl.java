package com.ruoyi.project.system.examSubjectResult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examSubjectResult.domain.ExamSubjectResult;
import com.ruoyi.project.system.examSubjectResult.mapper.ExamSubjectResultMapper;

/**
 * 科目类型结果 服务层实现
 * 
 * @author ruoyi
 * @date 2019-10-25
 */
@Service
public class ExamSubjectResultServiceImpl implements IExamSubjectResultService 
{
	@Autowired
	private ExamSubjectResultMapper examSubjectResultMapper;

	/**
     * 查询科目类型结果信息
     * 
     * @param id 科目类型结果ID
     * @return 科目类型结果信息
     */
    @Override
	public ExamSubjectResult selectExamSubjectResultById(String id)
	{
	    return examSubjectResultMapper.selectExamSubjectResultById(id);
	}
	
	/**
     * 查询科目类型结果列表
     * 
     * @param examSubjectResult 科目类型结果信息
     * @return 科目类型结果集合
     */
	@Override
	public List<ExamSubjectResult> selectExamSubjectResultList(ExamSubjectResult examSubjectResult)
	{
	    return examSubjectResultMapper.selectExamSubjectResultList(examSubjectResult);
	}
	
    /**
     * 新增科目类型结果
     * 
     * @param examSubjectResult 科目类型结果信息
     * @return 结果
     */
	@Override
	public int insertExamSubjectResult(ExamSubjectResult examSubjectResult)
	{
	    return examSubjectResultMapper.insertExamSubjectResult(examSubjectResult);
	}
	
	/**
     * 修改科目类型结果
     * 
     * @param examSubjectResult 科目类型结果信息
     * @return 结果
     */
	@Override
	public int updateExamSubjectResult(ExamSubjectResult examSubjectResult)
	{
	    return examSubjectResultMapper.updateExamSubjectResult(examSubjectResult);
	}

	/**
     * 删除科目类型结果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamSubjectResultByIds(String ids)
	{
		return examSubjectResultMapper.deleteExamSubjectResultByIds(Convert.toStrArray(ids));
	}
	
}
