package com.ruoyi.project.system.WorkNote.mapper;

import com.ruoyi.project.system.WorkNote.domain.WorkNote;
import java.util.List;

/**
 * 工作记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
public interface WorkNoteMapper 
{
    /**
     * 查询工作记录
     * 
     * @param id 工作记录ID
     * @return 工作记录
     */
    public WorkNote selectWorkNoteById(Long id);

    /**
     * 查询工作记录列表
     * 
     * @param workNote 工作记录
     * @return 工作记录集合
     */
    public List<WorkNote> selectWorkNoteList(WorkNote workNote);

    /**
     * 新增工作记录
     * 
     * @param workNote 工作记录
     * @return 结果
     */
    public int insertWorkNote(WorkNote workNote);

    /**
     * 修改工作记录
     * 
     * @param workNote 工作记录
     * @return 结果
     */
    public int updateWorkNote(WorkNote workNote);

    /**
     * 删除工作记录
     * 
     * @param id 工作记录ID
     * @return 结果
     */
    public int deleteWorkNoteById(Long id);

    /**
     * 批量删除工作记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkNoteByIds(String[] ids);
}
