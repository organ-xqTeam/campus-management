package com.ruoyi.project.system.classschedulingmanagement.mapper;

import com.ruoyi.project.system.classschedulingmanagement.domain.Classschedulingmanagement;
import java.util.List;

/**
 * 排课管理Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
public interface ClassschedulingmanagementMapper 
{
    /**
     * 查询排课管理
     * 
     * @param id 排课管理ID
     * @return 排课管理
     */
    public Classschedulingmanagement selectClassschedulingmanagementById(Long id);

    /**
     * 查询排课管理列表
     * 
     * @param classschedulingmanagement 排课管理
     * @return 排课管理集合
     */
    public List<Classschedulingmanagement> selectClassschedulingmanagementList(Classschedulingmanagement classschedulingmanagement);

    /**
     * 新增排课管理
     * 
     * @param classschedulingmanagement 排课管理
     * @return 结果
     */
    public int insertClassschedulingmanagement(Classschedulingmanagement classschedulingmanagement);

    /**
     * 修改排课管理
     * 
     * @param classschedulingmanagement 排课管理
     * @return 结果
     */
    public int updateClassschedulingmanagement(Classschedulingmanagement classschedulingmanagement);

    /**
     * 删除排课管理
     * 
     * @param id 排课管理ID
     * @return 结果
     */
    public int deleteClassschedulingmanagementById(Long id);

    /**
     * 批量删除排课管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClassschedulingmanagementByIds(String[] ids);
}
