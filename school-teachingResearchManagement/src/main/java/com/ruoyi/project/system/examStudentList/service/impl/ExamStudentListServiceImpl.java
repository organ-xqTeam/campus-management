package com.ruoyi.project.system.examStudentList.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examStudentList.domain.ExamStudentList;
import com.ruoyi.project.system.examStudentList.mapper.ExamStudentListMapper;
import com.ruoyi.project.system.examStudentList.service.IExamStudentListService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
@Service
public class ExamStudentListServiceImpl implements IExamStudentListService 
{
    @Autowired
    private ExamStudentListMapper examStudentListMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ExamStudentList selectExamStudentListById(Long id)
    {
        return examStudentListMapper.selectExamStudentListById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param examStudentList 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ExamStudentList> selectExamStudentListList(ExamStudentList esl) {
      return examStudentListMapper.selectExamStudentListList(esl);
    }
    
    @Override
    public List<Map<String, Object>> selectExamStudentListList(Map<String, Object> param)
    {
        return examStudentListMapper.selectExamStudentList(param);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param examStudentList 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertExamStudentList(ExamStudentList examStudentList)
    {
        return examStudentListMapper.insertExamStudentList(examStudentList);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param examStudentList 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateExamStudentList(ExamStudentList examStudentList)
    {
        return examStudentListMapper.updateExamStudentList(examStudentList);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteExamStudentListByIds(String ids)
    {
        return examStudentListMapper.deleteExamStudentListByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteExamStudentListById(Long id)
    {
        return examStudentListMapper.deleteExamStudentListById(id);
    }
}
