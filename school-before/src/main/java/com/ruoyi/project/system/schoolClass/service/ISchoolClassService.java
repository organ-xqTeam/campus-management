package com.ruoyi.project.system.schoolClass.service;

import java.util.List;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;

/**
 * 学校班级表Service接口
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
public interface ISchoolClassService 
{
    /**
     * 查询学校班级表
     * 
     * @param id 学校班级表ID
     * @return 学校班级表
     */
    public SchoolClass selectSchoolClassById(Long id);

    /**
     * 查询学校班级表列表
     * 
     * @param schoolClass 学校班级表
     * @return 学校班级表集合
     */
    public List<SchoolClass> selectSchoolClassList(SchoolClass schoolClass);

    /**
     * 新增学校班级表
     * 
     * @param schoolClass 学校班级表
     * @return 结果
     */
    public int insertSchoolClass(SchoolClass schoolClass);

    /**
     * 修改学校班级表
     * 
     * @param schoolClass 学校班级表
     * @return 结果
     */
    public int updateSchoolClass(SchoolClass schoolClass);

    /**
     * 批量删除学校班级表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolClassByIds(String ids);

    /**
     * 删除学校班级表信息
     * 
     * @param id 学校班级表ID
     * @return 结果
     */
    public int deleteSchoolClassById(Long id);
    
    public void doScheduling(Long gradeid, int num);
    
}
