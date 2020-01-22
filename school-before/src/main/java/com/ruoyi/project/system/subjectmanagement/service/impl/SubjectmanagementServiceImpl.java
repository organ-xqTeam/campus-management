package com.ruoyi.project.system.subjectmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.subjectmanagement.domain.Subjectmanagement;
import com.ruoyi.project.system.subjectmanagement.mapper.SubjectmanagementMapper;
import com.ruoyi.project.system.subjectmanagement.service.ISubjectmanagementService;

/**
 * 科目管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Service
public class SubjectmanagementServiceImpl implements ISubjectmanagementService 
{
    @Autowired
    private SubjectmanagementMapper subjectmanagementMapper;

    /**
     * 查询科目管理
     * 
     * @param id 科目管理ID
     * @return 科目管理
     */
    @Override
    public Subjectmanagement selectSubjectmanagementById(Long id)
    {
        return subjectmanagementMapper.selectSubjectmanagementById(id);
    }

    /**
     * 查询科目管理列表
     * 
     * @param subjectmanagement 科目管理
     * @return 科目管理
     */
    @Override
    public List<Subjectmanagement> selectSubjectmanagementList(Subjectmanagement subjectmanagement)
    {
        return subjectmanagementMapper.selectSubjectmanagementList(subjectmanagement);
    }

    /**
     * 新增科目管理
     * 
     * @param subjectmanagement 科目管理
     * @return 结果
     */
    @Override
    public int insertSubjectmanagement(Subjectmanagement subjectmanagement)
    {
        return subjectmanagementMapper.insertSubjectmanagement(subjectmanagement);
    }

    /**
     * 修改科目管理
     * 
     * @param subjectmanagement 科目管理
     * @return 结果
     */
    @Override
    public int updateSubjectmanagement(Subjectmanagement subjectmanagement)
    {
        return subjectmanagementMapper.updateSubjectmanagement(subjectmanagement);
    }

    /**
     * 删除科目管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSubjectmanagementByIds(String ids)
    {
        return subjectmanagementMapper.deleteSubjectmanagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除科目管理信息
     * 
     * @param id 科目管理ID
     * @return 结果
     */
    @Override
    public int deleteSubjectmanagementById(Long id)
    {
        return subjectmanagementMapper.deleteSubjectmanagementById(id);
    }
}
