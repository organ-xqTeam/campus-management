package com.ruoyi.project.system.schoolequipment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolequipment.domain.Schoolequipment;
import com.ruoyi.project.system.schoolequipment.mapper.SchoolequipmentMapper;
import com.ruoyi.project.system.schoolequipment.service.ISchoolequipmentService;

/**
 * 设备报修Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SchoolequipmentServiceImpl implements ISchoolequipmentService 
{
    @Autowired
    private SchoolequipmentMapper schoolequipmentMapper;

    /**
     * 查询设备报修
     * 
     * @param id 设备报修ID
     * @return 设备报修
     */
    @Override
    public Schoolequipment selectSchoolequipmentById(Long id)
    {
        return schoolequipmentMapper.selectSchoolequipmentById(id);
    }

    /**
     * 查询设备报修列表
     * 
     * @param schoolequipment 设备报修
     * @return 设备报修
     */
    @Override
    public List<Schoolequipment> selectSchoolequipmentList(Schoolequipment schoolequipment)
    {
        return schoolequipmentMapper.selectSchoolequipmentList(schoolequipment);
    }

    /**
     * 新增设备报修
     * 
     * @param schoolequipment 设备报修
     * @return 结果
     */
    @Override
    public int insertSchoolequipment(Schoolequipment schoolequipment)
    {
        return schoolequipmentMapper.insertSchoolequipment(schoolequipment);
    }

    /**
     * 修改设备报修
     * 
     * @param schoolequipment 设备报修
     * @return 结果
     */
    @Override
    public int updateSchoolequipment(Schoolequipment schoolequipment)
    {
        return schoolequipmentMapper.updateSchoolequipment(schoolequipment);
    }

    /**
     * 删除设备报修对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolequipmentByIds(String ids)
    {
        return schoolequipmentMapper.deleteSchoolequipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备报修信息
     * 
     * @param id 设备报修ID
     * @return 结果
     */
    @Override
    public int deleteSchoolequipmentById(Long id)
    {
        return schoolequipmentMapper.deleteSchoolequipmentById(id);
    }
}
