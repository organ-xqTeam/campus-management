package com.ruoyi.project.system.examStudentList.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.examStudentList.domain.ExamStudentList;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
public interface ExamStudentListMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ExamStudentList selectExamStudentListById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param examStudentList 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ExamStudentList> selectExamStudentListList(ExamStudentList examStudentList);
    
    public List<Map<String, Object>> selectExamStudentList(Map<String, Object> param);

    /**
     * 新增【请填写功能名称】
     * 
     * @param examStudentList 【请填写功能名称】
     * @return 结果
     */
    public int insertExamStudentList(ExamStudentList examStudentList);

    /**
     * 修改【请填写功能名称】
     * 
     * @param examStudentList 【请填写功能名称】
     * @return 结果
     */
    public int updateExamStudentList(ExamStudentList examStudentList);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteExamStudentListById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExamStudentListByIds(String[] ids);
}
