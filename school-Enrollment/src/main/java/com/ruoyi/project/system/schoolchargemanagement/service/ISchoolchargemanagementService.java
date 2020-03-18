package com.ruoyi.project.system.schoolchargemanagement.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.schoolchargemanagement.domain.Schoolchargemanagement;

/**
 * 收费管理Service接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface ISchoolchargemanagementService 
{
    /**
     * 查询收费管理
     * 
     * @param id 收费管理ID
     * @return 收费管理
     */
    public Schoolchargemanagement selectSchoolchargemanagementById(Long id);

    /**
     * 查询收费管理列表
     * 
     * @param schoolchargemanagement 收费管理
     * @return 收费管理集合
     */
    public List<Schoolchargemanagement> selectSchoolchargemanagementList(Schoolchargemanagement schoolchargemanagement);
    public List<Map<String, Object>> selectStudentChargeList(Map<String, Object> param);
    /**
     * 新增收费管理
     * 
     * @param schoolchargemanagement 收费管理
     * @return 结果
     */
    public int insertSchoolchargemanagement(Schoolchargemanagement schoolchargemanagement);

    /**
     * 修改收费管理
     * 
     * @param schoolchargemanagement 收费管理
     * @return 结果
     */
    public int updateSchoolchargemanagement(Schoolchargemanagement schoolchargemanagement);

    /**
     * 批量删除收费管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolchargemanagementByIds(String ids);

    /**
     * 删除收费管理信息
     * 
     * @param id 收费管理ID
     * @return 结果
     */
    public int deleteSchoolchargemanagementById(Long id);

	public int changeStatus(Schoolchargemanagement schoolchargemanagement);
}
