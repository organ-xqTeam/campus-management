package com.ruoyi.project.system.examStudentListDetail.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.examStudentListDetail.domain.ExamStudentListDetail;
import com.ruoyi.project.system.examStudentListDetail.mapper.ExamStudentListDetailMapper;
import com.ruoyi.project.system.examStudentListDetail.service.IExamStudentListDetailService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
@Service
public class ExamStudentListDetailServiceImpl implements IExamStudentListDetailService 
{
    @Autowired
    private ExamStudentListDetailMapper examStudentListDetailMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ExamStudentListDetail selectExamStudentListDetailById(Long id)
    {
        return examStudentListDetailMapper.selectExamStudentListDetailById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param examStudentListDetail 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ExamStudentListDetail> selectExamStudentListDetailList(ExamStudentListDetail examStudentListDetail)
    {
        return examStudentListDetailMapper.selectExamStudentListDetailList(examStudentListDetail);
    }
    @Override
    public List<Map<String, Object>> selectExamStudentListDetail(Map<String, Object> param) {
    	 return examStudentListDetailMapper.selectExamStudentListDetail(param);
    }
    /**
     * 新增【请填写功能名称】
     * 
     * @param examStudentListDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertExamStudentListDetail(ExamStudentListDetail examStudentListDetail)
    {
        return examStudentListDetailMapper.insertExamStudentListDetail(examStudentListDetail);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param examStudentListDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateExamStudentListDetail(ExamStudentListDetail examStudentListDetail)
    {
        return examStudentListDetailMapper.updateExamStudentListDetail(examStudentListDetail);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteExamStudentListDetailByIds(String ids)
    {
        return examStudentListDetailMapper.deleteExamStudentListDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteExamStudentListDetailById(Long id)
    {
        return examStudentListDetailMapper.deleteExamStudentListDetailById(id);
    }
}
