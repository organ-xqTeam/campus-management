package com.ruoyi.project.system.ReduceTask.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.ReduceTask.mapper.ReduceTaskMapper;
import com.ruoyi.project.system.ReduceTask.domain.ReduceTask;
import com.ruoyi.project.system.ReduceTask.service.IReduceTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 实践任务管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
@Service
public class ReduceTaskServiceImpl implements IReduceTaskService 
{
    @Autowired
    private ReduceTaskMapper reduceTaskMapper;

    /**
     * 查询实践任务管理
     * 
     * @param id 实践任务管理ID
     * @return 实践任务管理
     */
    @Override
    public ReduceTask selectReduceTaskById(Long id)
    {
        return reduceTaskMapper.selectReduceTaskById(id);
    }

    /**
     * 查询实践任务管理列表
     * 
     * @param reduceTask 实践任务管理
     * @return 实践任务管理
     */
    @Override
    public List<ReduceTask> selectReduceTaskList(ReduceTask reduceTask)
    {
        return reduceTaskMapper.selectReduceTaskList(reduceTask);
    }

    /**
     * 新增实践任务管理
     * 
     * @param reduceTask 实践任务管理
     * @return 结果
     */
    @Override
    public int insertReduceTask(ReduceTask reduceTask)
    {
        return reduceTaskMapper.insertReduceTask(reduceTask);
    }

    /**
     * 修改实践任务管理
     * 
     * @param reduceTask 实践任务管理
     * @return 结果
     */
    @Override
    public int updateReduceTask(ReduceTask reduceTask)
    {
        return reduceTaskMapper.updateReduceTask(reduceTask);
    }

    /**
     * 删除实践任务管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteReduceTaskByIds(String ids)
    {
        return reduceTaskMapper.deleteReduceTaskByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除实践任务管理信息
     * 
     * @param id 实践任务管理ID
     * @return 结果
     */
    @Override
    public int deleteReduceTaskById(Long id)
    {
        return reduceTaskMapper.deleteReduceTaskById(id);
    }
}
