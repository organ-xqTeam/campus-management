package com.ruoyi.project.system.coursemanagement.mapper;

import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import java.util.List;

/**
 * 课程管理Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
public interface CoursemanagementMapper 
{
    /**
     * 查询课程管理
     * 
     * @param id 课程管理ID
     * @return 课程管理
     */
    public Coursemanagement selectCoursemanagementById(Long id);

    /**
     * 查询课程管理列表
     * 
     * @param coursemanagement 课程管理
     * @return 课程管理集合
     */
    public List<Coursemanagement> selectCoursemanagementList(Coursemanagement coursemanagement);

    /**
     * 新增课程管理
     * 
     * @param coursemanagement 课程管理
     * @return 结果
     */
    public int insertCoursemanagement(Coursemanagement coursemanagement);

    /**
     * 修改课程管理
     * 
     * @param coursemanagement 课程管理
     * @return 结果
     */
    public int updateCoursemanagement(Coursemanagement coursemanagement);

    /**
     * 删除课程管理
     * 
     * @param id 课程管理ID
     * @return 结果
     */
    public int deleteCoursemanagementById(Long id);

    /**
     * 批量删除课程管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCoursemanagementByIds(String[] ids);
}
