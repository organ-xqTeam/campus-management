package com.ruoyi.project.system.schoolgradelist.mapper;

import com.ruoyi.project.system.schoolgradelist.domain.Schoolgradelist;
import java.util.List;

/**
 * 年级管理Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
public interface SchoolgradelistMapper 
{
    /**
     * 查询年级管理
     * 
     * @param id 年级管理ID
     * @return 年级管理
     */
    public Schoolgradelist selectSchoolgradelistById(String id);

    /**
     * 查询年级管理列表
     * 
     * @param schoolgradelist 年级管理
     * @return 年级管理集合
     */
    public List<Schoolgradelist> selectSchoolgradelistList(Schoolgradelist schoolgradelist);

    /**
     * 新增年级管理
     * 
     * @param schoolgradelist 年级管理
     * @return 结果
     */
    public int insertSchoolgradelist(Schoolgradelist schoolgradelist);

    /**
     * 修改年级管理
     * 
     * @param schoolgradelist 年级管理
     * @return 结果
     */
    public int updateSchoolgradelist(Schoolgradelist schoolgradelist);

    /**
     * 删除年级管理
     * 
     * @param id 年级管理ID
     * @return 结果
     */
    public int deleteSchoolgradelistById(String id);

    /**
     * 批量删除年级管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolgradelistByIds(String[] ids);
}
