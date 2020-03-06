package com.ruoyi.project.system.examAdInformation.mapper;

import com.ruoyi.project.system.examAdInformation.domain.ExamAdInformation;
import java.util.List;	

/**
 * 广告的 数据层
 * 
 * @author ruoyi
 * @date 2019-10-23
 */
public interface ExamAdInformationMapper 
{
	/**
     * 查询广告的信息
     * 
     * @param id 广告的ID
     * @return 广告的信息
     */
	public ExamAdInformation selectExamAdInformationById(Long id);
	
	/**
     * 查询广告的列表
     * 
     * @param examAdInformation 广告的信息
     * @return 广告的集合
     */
	public List<ExamAdInformation> selectExamAdInformationList(ExamAdInformation examAdInformation);
	
	/**
     * 新增广告的
     * 
     * @param examAdInformation 广告的信息
     * @return 结果
     */
	public int insertExamAdInformation(ExamAdInformation examAdInformation);
	
	/**
     * 修改广告的
     * 
     * @param examAdInformation 广告的信息
     * @return 结果
     */
	public int updateExamAdInformation(ExamAdInformation examAdInformation);
	
	/**
     * 删除广告的
     * 
     * @param id 广告的ID
     * @return 结果
     */
	public int deleteExamAdInformationById(Long id);
	
	/**
     * 批量删除广告的
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExamAdInformationByIds(String[] ids);
	
}