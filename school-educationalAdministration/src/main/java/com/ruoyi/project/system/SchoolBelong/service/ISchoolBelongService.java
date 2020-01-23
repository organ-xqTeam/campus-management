package com.ruoyi.project.system.SchoolBelong.service;

import com.ruoyi.project.system.SchoolBelong.domain.SchoolBelong;
import java.util.List;

/**
 * 学院分属Service接口
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
public interface ISchoolBelongService 
{
    /**
     * 查询学院分属
     * 
     * @param id 学院分属ID
     * @return 学院分属
     */
    public SchoolBelong selectSchoolBelongById(Long id);

    /**
     * 查询学院分属列表
     * 
     * @param schoolBelong 学院分属
     * @return 学院分属集合
     */
    public List<SchoolBelong> selectSchoolBelongList(SchoolBelong schoolBelong);

    /**
     * 新增学院分属
     * 
     * @param schoolBelong 学院分属
     * @return 结果
     */
    public int insertSchoolBelong(SchoolBelong schoolBelong);

    /**
     * 修改学院分属
     * 
     * @param schoolBelong 学院分属
     * @return 结果
     */
    public int updateSchoolBelong(SchoolBelong schoolBelong);

    /**
     * 批量删除学院分属
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolBelongByIds(String ids);

    /**
     * 删除学院分属信息
     * 
     * @param id 学院分属ID
     * @return 结果
     */
    public int deleteSchoolBelongById(Long id);
}
