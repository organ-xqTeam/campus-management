package com.ruoyi.project.system.schoolHomework.service;

import com.ruoyi.project.system.schoolHomework.domain.SchoolHomework;
import java.util.List;
import java.util.Map;

/**
 * 学生作业表Service接口
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public interface ISchoolHomeworkService 
{
    /**
     * 查询学生作业表
     * 
     * @param id 学生作业表ID
     * @return 学生作业表
     */
    public SchoolHomework selectSchoolHomeworkById(Long id);

    /**
     * 查询学生作业表列表
     * 
     * @param schoolHomework 学生作业表
     * @return 学生作业表集合
     */
    public List<SchoolHomework> selectSchoolHomeworkList(SchoolHomework schoolHomework);
    /**
     * 作业管理新增学生页列表
     * */
    public List<Map<String, Object>> stulist(Map<String, Object> params);
    /**
     * 新增学生作业表
     * 
     * @param schoolHomework 学生作业表
     * @return 结果
     */
    public int insertSchoolHomework(SchoolHomework schoolHomework);

    /**
     * 修改学生作业表
     * 
     * @param schoolHomework 学生作业表
     * @return 结果
     */
    public int updateSchoolHomework(SchoolHomework schoolHomework);

    /**
     * 批量删除学生作业表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolHomeworkByIds(String ids);

    /**
     * 删除学生作业表信息
     * 
     * @param id 学生作业表ID
     * @return 结果
     */
    public int deleteSchoolHomeworkById(Long id);
}
