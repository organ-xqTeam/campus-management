package com.ruoyi.project.system.coursemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.coursemanagement.domain.Coursemanagement;
import com.ruoyi.project.system.coursemanagement.mapper.CoursemanagementMapper;
import com.ruoyi.project.system.coursemanagement.service.ICoursemanagementService;

/**
 * 课程管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Service
public class CoursemanagementServiceImpl implements ICoursemanagementService 
{
    @Autowired
    private CoursemanagementMapper coursemanagementMapper;

    /**
     * 查询课程管理
     * 
     * @param id 课程管理ID
     * @return 课程管理
     */
    @Override
    public Coursemanagement selectCoursemanagementById(Long id)
    {
        return coursemanagementMapper.selectCoursemanagementById(id);
    }

    /**
     * 查询课程管理列表
     * 
     * @param coursemanagement 课程管理
     * @return 课程管理
     */
    @Override
    public List<Coursemanagement> selectCoursemanagementList(Coursemanagement coursemanagement)
    {
        return coursemanagementMapper.selectCoursemanagementList(coursemanagement);
    }

    /**
     * 新增课程管理
     * 
     * @param coursemanagement 课程管理
     * @return 结果
     */
    @Override
    public int insertCoursemanagement(Coursemanagement coursemanagement)
    {
    	coursemanagement.setCreateDate(DateUtils.getTime());
        return coursemanagementMapper.insertCoursemanagement(coursemanagement);
    }

    /**
     * 修改课程管理
     * 
     * @param coursemanagement 课程管理
     * @return 结果
     */
    @Override
    public int updateCoursemanagement(Coursemanagement coursemanagement)
    {
        return coursemanagementMapper.updateCoursemanagement(coursemanagement);
    }

    /**
     * 删除课程管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCoursemanagementByIds(String ids)
    {
        return coursemanagementMapper.deleteCoursemanagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程管理信息
     * 
     * @param id 课程管理ID
     * @return 结果
     */
    @Override
    public int deleteCoursemanagementById(Long id)
    {
        return coursemanagementMapper.deleteCoursemanagementById(id);
    }
}
