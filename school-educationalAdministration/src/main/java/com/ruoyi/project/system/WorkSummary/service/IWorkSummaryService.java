package com.ruoyi.project.system.WorkSummary.service;

import com.ruoyi.project.system.WorkSummary.domain.WorkSummary;
import java.util.List;

/**
 * 工作总结Service接口
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
public interface IWorkSummaryService 
{
    /**
     * 查询工作总结
     * 
     * @param id 工作总结ID
     * @return 工作总结
     */
    public WorkSummary selectWorkSummaryById(Long id);

    /**
     * 查询工作总结列表
     * 
     * @param workSummary 工作总结
     * @return 工作总结集合
     */
    public List<WorkSummary> selectWorkSummaryList(WorkSummary workSummary);

    /**
     * 新增工作总结
     * 
     * @param workSummary 工作总结
     * @return 结果
     */
    public int insertWorkSummary(WorkSummary workSummary);

    /**
     * 修改工作总结
     * 
     * @param workSummary 工作总结
     * @return 结果
     */
    public int updateWorkSummary(WorkSummary workSummary);

    /**
     * 批量删除工作总结
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkSummaryByIds(String ids);

    /**
     * 删除工作总结信息
     * 
     * @param id 工作总结ID
     * @return 结果
     */
    public int deleteWorkSummaryById(Long id);
}
