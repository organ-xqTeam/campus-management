package com.ruoyi.project.system.ReduceTask.mapper;

import com.ruoyi.project.system.ReduceTask.domain.ReduceTask;
import java.util.List;

/**
 * 实践任务管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
public interface ReduceTaskMapper 
{
    /**
     * 查询实践任务管理
     * 
     * @param id 实践任务管理ID
     * @return 实践任务管理
     */
    public ReduceTask selectReduceTaskById(Long id);

    /**
     * 查询实践任务管理列表
     * 
     * @param reduceTask 实践任务管理
     * @return 实践任务管理集合
     */
    public List<ReduceTask> selectReduceTaskList(ReduceTask reduceTask);

    /**
     * 新增实践任务管理
     * 
     * @param reduceTask 实践任务管理
     * @return 结果
     */
    public int insertReduceTask(ReduceTask reduceTask);

    /**
     * 修改实践任务管理
     * 
     * @param reduceTask 实践任务管理
     * @return 结果
     */
    public int updateReduceTask(ReduceTask reduceTask);

    /**
     * 删除实践任务管理
     * 
     * @param id 实践任务管理ID
     * @return 结果
     */
    public int deleteReduceTaskById(Long id);

    /**
     * 批量删除实践任务管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteReduceTaskByIds(String[] ids);
}
