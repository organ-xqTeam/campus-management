package com.ruoyi.project.system.classschedulingmanagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.classschedulingmanagement.mapper.ClassschedulingmanagementMapper;
import com.ruoyi.project.system.classschedulingmanagement.domain.Classschedulingmanagement;
import com.ruoyi.project.system.classschedulingmanagement.service.IClassschedulingmanagementService;
import com.ruoyi.common.core.text.Convert;
/**
 * 排课管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Service
public class ClassschedulingmanagementServiceImpl implements IClassschedulingmanagementService 
{
    @Autowired
    private ClassschedulingmanagementMapper classschedulingmanagementMapper;

    /**
     * 查询排课管理
     * 
     * @param id 排课管理ID
     * @return 排课管理
     */
    @Override
    public Classschedulingmanagement selectClassschedulingmanagementById(Long id)
    {
        return classschedulingmanagementMapper.selectClassschedulingmanagementById(id);
    }

    /**
     * 查询排课管理列表
     * 
     * @param classschedulingmanagement 排课管理
     * @return 排课管理
     */
    @Override
    public List<Classschedulingmanagement> selectClassschedulingmanagementList(Classschedulingmanagement classschedulingmanagement)
    {
        return classschedulingmanagementMapper.selectClassschedulingmanagementList(classschedulingmanagement);
    }

    /**
     * 新增排课管理
     * 
     * @param classschedulingmanagement 排课管理
     * @return 结果
     */
    @Override
    public int insertClassschedulingmanagement(Classschedulingmanagement classschedulingmanagement)
    {
        return classschedulingmanagementMapper.insertClassschedulingmanagement(classschedulingmanagement);
    }

    /**
     * 修改排课管理
     * 
     * @param classschedulingmanagement 排课管理
     * @return 结果
     */
    @Override
    public int updateClassschedulingmanagement(Classschedulingmanagement classschedulingmanagement)
    {
        return classschedulingmanagementMapper.updateClassschedulingmanagement(classschedulingmanagement);
    }

    /**
     * 删除排课管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClassschedulingmanagementByIds(String ids)
    {
        return classschedulingmanagementMapper.deleteClassschedulingmanagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除排课管理信息
     * 
     * @param id 排课管理ID
     * @return 结果
     */
    @Override
    public int deleteClassschedulingmanagementById(Long id)
    {
        return classschedulingmanagementMapper.deleteClassschedulingmanagementById(id);
    }
}
