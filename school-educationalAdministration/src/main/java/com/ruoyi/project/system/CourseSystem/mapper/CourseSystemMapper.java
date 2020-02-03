package com.ruoyi.project.system.CourseSystem.mapper;

import java.util.List;

import com.ruoyi.project.system.CourseSystem.domain.CourseSystem;

/**
 * 课程体系Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-03
 */
public interface CourseSystemMapper 
{
    /**
     * 查询课程体系
     * 
     * @param id 课程体系ID
     * @return 课程体系
     */
    public CourseSystem selectCourseSystemById(Long id);

    /**
     * 查询课程体系列表
     * 
     * @param courseSystem 课程体系
     * @return 课程体系集合
     */
    public List<CourseSystem> selectCourseSystemList(CourseSystem courseSystem);

    /**
     * 新增课程体系
     * 
     * @param courseSystem 课程体系
     * @return 结果
     */
    public int insertCourseSystem(CourseSystem courseSystem);

    /**
     * 修改课程体系
     * 
     * @param courseSystem 课程体系
     * @return 结果
     */
    public int updateCourseSystem(CourseSystem courseSystem);

    /**
     * 删除课程体系
     * 
     * @param id 课程体系ID
     * @return 结果
     */
    public int deleteCourseSystemById(Long id);

    /**
     * 批量删除课程体系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCourseSystemByIds(String[] ids);
}
