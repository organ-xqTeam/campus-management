package com.ruoyi.project.system.CourseSet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.CourseSet.mapper.CourseSetMapper;
import com.ruoyi.project.system.CourseSet.domain.CourseSet;
import com.ruoyi.project.system.CourseSet.service.ICourseSetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 课程设置管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-04
 */
@Service
public class CourseSetServiceImpl implements ICourseSetService 
{
    @Autowired
    private CourseSetMapper courseSetMapper;

    /**
     * 查询课程设置管理
     * 
     * @param id 课程设置管理ID
     * @return 课程设置管理
     */
    @Override
    public CourseSet selectCourseSetById(Long id)
    {
        return courseSetMapper.selectCourseSetById(id);
    }

    /**
     * 查询课程设置管理列表
     * 
     * @param courseSet 课程设置管理
     * @return 课程设置管理
     */
    @Override
    public List<CourseSet> selectCourseSetList(CourseSet courseSet)
    {
        return courseSetMapper.selectCourseSetList(courseSet);
    }

    /**
     * 新增课程设置管理
     * 
     * @param courseSet 课程设置管理
     * @return 结果
     */
    @Override
    public int insertCourseSet(CourseSet courseSet)
    {
        return courseSetMapper.insertCourseSet(courseSet);
    }

    /**
     * 修改课程设置管理
     * 
     * @param courseSet 课程设置管理
     * @return 结果
     */
    @Override
    public int updateCourseSet(CourseSet courseSet)
    {
        return courseSetMapper.updateCourseSet(courseSet);
    }

    /**
     * 删除课程设置管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCourseSetByIds(String ids)
    {
        return courseSetMapper.deleteCourseSetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程设置管理信息
     * 
     * @param id 课程设置管理ID
     * @return 结果
     */
    @Override
    public int deleteCourseSetById(Long id)
    {
        return courseSetMapper.deleteCourseSetById(id);
    }
}
