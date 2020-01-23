package com.ruoyi.project.system.WorkSummary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.WorkSummary.domain.WorkSummary;
import com.ruoyi.project.system.WorkSummary.mapper.WorkSummaryMapper;
import com.ruoyi.project.system.WorkSummary.service.IWorkSummaryService;

/**
 * 工作总结Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
@Service
public class WorkSummaryServiceImpl implements IWorkSummaryService 
{
    @Autowired
    private WorkSummaryMapper workSummaryMapper;

    /**
     * 查询工作总结
     * 
     * @param id 工作总结ID
     * @return 工作总结
     */
    @Override
    public WorkSummary selectWorkSummaryById(Long id)
    {
        return workSummaryMapper.selectWorkSummaryById(id);
    }

    /**
     * 查询工作总结列表
     * 
     * @param workSummary 工作总结
     * @return 工作总结
     */
    @Override
    public List<WorkSummary> selectWorkSummaryList(WorkSummary workSummary)
    {
        return workSummaryMapper.selectWorkSummaryList(workSummary);
    }

    /**
     * 新增工作总结
     * 
     * @param workSummary 工作总结
     * @return 结果
     */
    @Override
    public int insertWorkSummary(WorkSummary workSummary)
    {
        return workSummaryMapper.insertWorkSummary(workSummary);
    }

    /**
     * 修改工作总结
     * 
     * @param workSummary 工作总结
     * @return 结果
     */
    @Override
    public int updateWorkSummary(WorkSummary workSummary)
    {
        return workSummaryMapper.updateWorkSummary(workSummary);
    }

    /**
     * 删除工作总结对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkSummaryByIds(String ids)
    {
        return workSummaryMapper.deleteWorkSummaryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工作总结信息
     * 
     * @param id 工作总结ID
     * @return 结果
     */
    @Override
    public int deleteWorkSummaryById(Long id)
    {
        return workSummaryMapper.deleteWorkSummaryById(id);
    }
}
