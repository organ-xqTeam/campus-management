package com.ruoyi.project.system.schoolenrollmentmanagement.mapper;

import java.util.List;

import com.ruoyi.project.system.schoolenrollmentmanagement.domain.Schoolenrollmentmanagement;

/**
 * 招生管理Mapper接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface SchoolenrollmentmanagementMapper 
{
    /**
     * 查询招生管理
     * 
     * @param id 招生管理ID
     * @return 招生管理
     */
    public Schoolenrollmentmanagement selectSchoolenrollmentmanagementById(Long id);

    /**
     * 查询招生管理列表
     * 
     * @param schoolenrollmentmanagement 招生管理
     * @return 招生管理集合
     */
    public List<Schoolenrollmentmanagement> selectSchoolenrollmentmanagementList(Schoolenrollmentmanagement schoolenrollmentmanagement);

    /**
     * 新增招生管理
     * 
     * @param schoolenrollmentmanagement 招生管理
     * @return 结果
     */
    public int insertSchoolenrollmentmanagement(Schoolenrollmentmanagement schoolenrollmentmanagement);

    /**
     * 修改招生管理
     * 
     * @param schoolenrollmentmanagement 招生管理
     * @return 结果
     */
    public int updateSchoolenrollmentmanagement(Schoolenrollmentmanagement schoolenrollmentmanagement);

    /**
     * 删除招生管理
     * 
     * @param id 招生管理ID
     * @return 结果
     */
    public int deleteSchoolenrollmentmanagementById(Long id);

    /**
     * 批量删除招生管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolenrollmentmanagementByIds(String[] ids);
}
