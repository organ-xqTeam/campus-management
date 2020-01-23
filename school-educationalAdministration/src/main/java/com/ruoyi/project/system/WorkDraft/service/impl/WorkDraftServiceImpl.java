package com.ruoyi.project.system.WorkDraft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.WorkDraft.domain.WorkDraft;
import com.ruoyi.project.system.WorkDraft.mapper.WorkDraftMapper;
import com.ruoyi.project.system.WorkDraft.service.IWorkDraftService;

/**
 * 工作制定Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
@Service
public class WorkDraftServiceImpl implements IWorkDraftService 
{
    @Autowired
    private WorkDraftMapper workDraftMapper;

    /**
     * 查询工作制定
     * 
     * @param id 工作制定ID
     * @return 工作制定
     */
    @Override
    public WorkDraft selectWorkDraftById(Long id)
    {
        return workDraftMapper.selectWorkDraftById(id);
    }

    /**
     * 查询工作制定列表
     * 
     * @param workDraft 工作制定
     * @return 工作制定
     */
    @Override
    public List<WorkDraft> selectWorkDraftList(WorkDraft workDraft)
    {
        return workDraftMapper.selectWorkDraftList(workDraft);
    }

    /**
     * 新增工作制定
     * 
     * @param workDraft 工作制定
     * @return 结果
     */
    @Override
    public int insertWorkDraft(WorkDraft workDraft)
    {
        return workDraftMapper.insertWorkDraft(workDraft);
    }

    /**
     * 修改工作制定
     * 
     * @param workDraft 工作制定
     * @return 结果
     */
    @Override
    public int updateWorkDraft(WorkDraft workDraft)
    {
        return workDraftMapper.updateWorkDraft(workDraft);
    }

    /**
     * 删除工作制定对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkDraftByIds(String ids)
    {
        return workDraftMapper.deleteWorkDraftByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工作制定信息
     * 
     * @param id 工作制定ID
     * @return 结果
     */
    @Override
    public int deleteWorkDraftById(Long id)
    {
        return workDraftMapper.deleteWorkDraftById(id);
    }
}
