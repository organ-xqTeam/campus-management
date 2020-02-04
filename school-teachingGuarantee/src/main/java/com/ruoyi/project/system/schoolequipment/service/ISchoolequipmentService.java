package com.ruoyi.project.system.schoolequipment.service;

import com.ruoyi.project.system.schoolequipment.domain.Schoolequipment;
import java.util.List;

/**
 * 设备报修Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISchoolequipmentService 
{
    /**
     * 查询设备报修
     * 
     * @param id 设备报修ID
     * @return 设备报修
     */
    public Schoolequipment selectSchoolequipmentById(Long id);

    /**
     * 查询设备报修列表
     * 
     * @param schoolequipment 设备报修
     * @return 设备报修集合
     */
    public List<Schoolequipment> selectSchoolequipmentList(Schoolequipment schoolequipment);

    /**
     * 新增设备报修
     * 
     * @param schoolequipment 设备报修
     * @return 结果
     */
    public int insertSchoolequipment(Schoolequipment schoolequipment);

    /**
     * 修改设备报修
     * 
     * @param schoolequipment 设备报修
     * @return 结果
     */
    public int updateSchoolequipment(Schoolequipment schoolequipment);

    /**
     * 批量删除设备报修
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolequipmentByIds(String ids);

    /**
     * 删除设备报修信息
     * 
     * @param id 设备报修ID
     * @return 结果
     */
    public int deleteSchoolequipmentById(Long id);
}
