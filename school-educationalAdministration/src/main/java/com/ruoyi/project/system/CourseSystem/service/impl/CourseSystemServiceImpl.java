package com.ruoyi.project.system.CourseSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.CourseSystem.domain.CourseSystem;
import com.ruoyi.project.system.CourseSystem.mapper.CourseSystemMapper;
import com.ruoyi.project.system.CourseSystem.service.ICourseSystemService;

/**
 * 课程体系Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-03
 */
@Service
public class CourseSystemServiceImpl implements ICourseSystemService 
{
    @Autowired
    private CourseSystemMapper courseSystemMapper;

    /**
     * 查询课程体系
     * 
     * @param id 课程体系ID
     * @return 课程体系
     */
    @Override
    public CourseSystem selectCourseSystemById(Long id)
    {
        return courseSystemMapper.selectCourseSystemById(id);
    }

    /**
     * 查询课程体系列表
     * 
     * @param courseSystem 课程体系
     * @return 课程体系
     */
    @Override
    public List<CourseSystem> selectCourseSystemList(CourseSystem courseSystem)
    {
        return courseSystemMapper.selectCourseSystemList(courseSystem);
    }

    /**
     * 新增课程体系
     * 
     * @param courseSystem 课程体系
     * @return 结果
     */
    @Override
    public int insertCourseSystem(CourseSystem courseSystem)
    {
        return courseSystemMapper.insertCourseSystem(courseSystem);
    }

    /**
     * 修改课程体系
     * 
     * @param courseSystem 课程体系
     * @return 结果
     */
    @Override
    public int updateCourseSystem(CourseSystem courseSystem)
    {
        return courseSystemMapper.updateCourseSystem(courseSystem);
    }

    /**
     * 删除课程体系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCourseSystemByIds(String ids)
    {
        return courseSystemMapper.deleteCourseSystemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程体系信息
     * 
     * @param id 课程体系ID
     * @return 结果
     */
    @Override
    public int deleteCourseSystemById(Long id)
    {
        return courseSystemMapper.deleteCourseSystemById(id);
    }
}
