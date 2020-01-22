package com.ruoyi.project.system.subjectmanagement.service;

import com.ruoyi.project.system.subjectmanagement.domain.Subjectmanagement;
import java.util.List;

/**
 * 科目管理Service接口
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
public interface ISubjectmanagementService 
{
    /**
     * 查询科目管理
     * 
     * @param id 科目管理ID
     * @return 科目管理
     */
    public Subjectmanagement selectSubjectmanagementById(Long id);

    /**
     * 查询科目管理列表
     * 
     * @param subjectmanagement 科目管理
     * @return 科目管理集合
     */
    public List<Subjectmanagement> selectSubjectmanagementList(Subjectmanagement subjectmanagement);

    /**
     * 新增科目管理
     * 
     * @param subjectmanagement 科目管理
     * @return 结果
     */
    public int insertSubjectmanagement(Subjectmanagement subjectmanagement);

    /**
     * 修改科目管理
     * 
     * @param subjectmanagement 科目管理
     * @return 结果
     */
    public int updateSubjectmanagement(Subjectmanagement subjectmanagement);

    /**
     * 批量删除科目管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSubjectmanagementByIds(String ids);

    /**
     * 删除科目管理信息
     * 
     * @param id 科目管理ID
     * @return 结果
     */
    public int deleteSubjectmanagementById(Long id);
}
