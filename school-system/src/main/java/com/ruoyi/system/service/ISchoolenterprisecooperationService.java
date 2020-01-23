package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Schoolenterprisecooperation;

/**
 * 校企合作Service接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface ISchoolenterprisecooperationService 
{
    /**
     * 查询校企合作
     * 
     * @param id 校企合作ID
     * @return 校企合作
     */
    public Schoolenterprisecooperation selectSchoolenterprisecooperationById(Long id);

    /**
     * 查询校企合作列表
     * 
     * @param schoolenterprisecooperation 校企合作
     * @return 校企合作集合
     */
    public List<Schoolenterprisecooperation> selectSchoolenterprisecooperationList(Schoolenterprisecooperation schoolenterprisecooperation);

    /**
     * 新增校企合作
     * 
     * @param schoolenterprisecooperation 校企合作
     * @return 结果
     */
    public int insertSchoolenterprisecooperation(Schoolenterprisecooperation schoolenterprisecooperation);

    /**
     * 修改校企合作
     * 
     * @param schoolenterprisecooperation 校企合作
     * @return 结果
     */
    public int updateSchoolenterprisecooperation(Schoolenterprisecooperation schoolenterprisecooperation);

    /**
     * 批量删除校企合作
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolenterprisecooperationByIds(String ids);

    /**
     * 删除校企合作信息
     * 
     * @param id 校企合作ID
     * @return 结果
     */
    public int deleteSchoolenterprisecooperationById(Long id);
}
