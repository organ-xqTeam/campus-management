package com.ruoyi.project.system.examStudentListDetail.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.examStudentListDetail.domain.ExamStudentListDetail;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
public interface ExamStudentListDetailMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ExamStudentListDetail selectExamStudentListDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param examStudentListDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ExamStudentListDetail> selectExamStudentListDetailList(ExamStudentListDetail examStudentListDetail);
    public List<Map<String, Object>> selectExamStudentListDetail(Map<String, Object> param);
    /**
     * 新增【请填写功能名称】
     * 
     * @param examStudentListDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertExamStudentListDetail(ExamStudentListDetail examStudentListDetail);

    /**
     * 修改【请填写功能名称】
     * 
     * @param examStudentListDetail 【请填写功能名称】
     * @return 结果
     */
    public int updateExamStudentListDetail(ExamStudentListDetail examStudentListDetail);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteExamStudentListDetailById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExamStudentListDetailByIds(String[] ids);
}
