package com.ruoyi.project.system.CourseSet.mapper;

import com.ruoyi.project.system.CourseSet.domain.CourseSet;
import java.util.List;

/**
 * 课程设置管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-04
 */
public interface CourseSetMapper 
{
    /**
     * 查询课程设置管理
     * 
     * @param id 课程设置管理ID
     * @return 课程设置管理
     */
    public CourseSet selectCourseSetById(Long id);

    /**
     * 查询课程设置管理列表
     * 
     * @param courseSet 课程设置管理
     * @return 课程设置管理集合
     */
    public List<CourseSet> selectCourseSetList(CourseSet courseSet);

    /**
     * 新增课程设置管理
     * 
     * @param courseSet 课程设置管理
     * @return 结果
     */
    public int insertCourseSet(CourseSet courseSet);

    /**
     * 修改课程设置管理
     * 
     * @param courseSet 课程设置管理
     * @return 结果
     */
    public int updateCourseSet(CourseSet courseSet);

    /**
     * 删除课程设置管理
     * 
     * @param id 课程设置管理ID
     * @return 结果
     */
    public int deleteCourseSetById(Long id);

    /**
     * 批量删除课程设置管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCourseSetByIds(String[] ids);
}
