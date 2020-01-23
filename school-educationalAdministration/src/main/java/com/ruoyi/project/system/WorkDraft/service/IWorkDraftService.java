package com.ruoyi.project.system.WorkDraft.service;

import com.ruoyi.project.system.WorkDraft.domain.WorkDraft;
import java.util.List;

/**
 * 工作制定Service接口
 * 
 * @author ruoyi
 * @date 2020-01-14
 */
public interface IWorkDraftService 
{
    /**
     * 查询工作制定
     * 
     * @param id 工作制定ID
     * @return 工作制定
     */
    public WorkDraft selectWorkDraftById(Long id);

    /**
     * 查询工作制定列表
     * 
     * @param workDraft 工作制定
     * @return 工作制定集合
     */
    public List<WorkDraft> selectWorkDraftList(WorkDraft workDraft);

    /**
     * 新增工作制定
     * 
     * @param workDraft 工作制定
     * @return 结果
     */
    public int insertWorkDraft(WorkDraft workDraft);

    /**
     * 修改工作制定
     * 
     * @param workDraft 工作制定
     * @return 结果
     */
    public int updateWorkDraft(WorkDraft workDraft);

    /**
     * 批量删除工作制定
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkDraftByIds(String ids);

    /**
     * 删除工作制定信息
     * 
     * @param id 工作制定ID
     * @return 结果
     */
    public int deleteWorkDraftById(Long id);
}
