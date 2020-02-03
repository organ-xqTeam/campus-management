package com.ruoyi.project.system.TeachingMaterialManagement.service;

import com.ruoyi.project.system.TeachingMaterialManagement.domain.TeachingMaterialManagement;
import java.util.List;

/**
 * 教材管理Service接口
 * 
 * @author ruoyi
 * @date 2019-11-21
 */
public interface ITeachingMaterialManagementService 
{
    /**
     * 查询教材管理
     * 
     * @param id 教材管理ID
     * @return 教材管理
     */
    public TeachingMaterialManagement selectTeachingMaterialManagementById(Long id);

    /**
     * 查询教材管理列表
     * 
     * @param teachingMaterialManagement 教材管理
     * @return 教材管理集合
     */
    public List<TeachingMaterialManagement> selectTeachingMaterialManagementList(TeachingMaterialManagement teachingMaterialManagement);

    /**
     * 新增教材管理
     * 
     * @param teachingMaterialManagement 教材管理
     * @return 结果
     */
    public int insertTeachingMaterialManagement(TeachingMaterialManagement teachingMaterialManagement);

    /**
     * 修改教材管理
     * 
     * @param teachingMaterialManagement 教材管理
     * @return 结果
     */
    public int updateTeachingMaterialManagement(TeachingMaterialManagement teachingMaterialManagement);

    /**
     * 批量删除教材管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTeachingMaterialManagementByIds(String ids);

    /**
     * 删除教材管理信息
     * 
     * @param id 教材管理ID
     * @return 结果
     */
    public int deleteTeachingMaterialManagementById(Long id);
}
