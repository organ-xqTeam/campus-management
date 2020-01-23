package com.ruoyi.project.system.SchoolSpecialty.service;

import com.ruoyi.project.system.SchoolSpecialty.domain.SchoolSpecialty;
import java.util.List;

/**
 * 学校专业Service接口
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
public interface ISchoolSpecialtyService 
{
    /**
     * 查询学校专业
     * 
     * @param id 学校专业ID
     * @return 学校专业
     */
    public SchoolSpecialty selectSchoolSpecialtyById(Long id);

    /**
     * 查询学校专业列表
     * 
     * @param schoolSpecialty 学校专业
     * @return 学校专业集合
     */
    public List<SchoolSpecialty> selectSchoolSpecialtyList(SchoolSpecialty schoolSpecialty);

    /**
     * 新增学校专业
     * 
     * @param schoolSpecialty 学校专业
     * @return 结果
     */
    public int insertSchoolSpecialty(SchoolSpecialty schoolSpecialty);

    /**
     * 修改学校专业
     * 
     * @param schoolSpecialty 学校专业
     * @return 结果
     */
    public int updateSchoolSpecialty(SchoolSpecialty schoolSpecialty);

    /**
     * 批量删除学校专业
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolSpecialtyByIds(String ids);

    /**
     * 删除学校专业信息
     * 
     * @param id 学校专业ID
     * @return 结果
     */
    public int deleteSchoolSpecialtyById(Long id);
}
