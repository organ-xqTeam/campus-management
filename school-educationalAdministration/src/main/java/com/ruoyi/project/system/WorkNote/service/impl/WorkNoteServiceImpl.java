package com.ruoyi.project.system.WorkNote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.WorkNote.domain.WorkNote;
import com.ruoyi.project.system.WorkNote.mapper.WorkNoteMapper;
import com.ruoyi.project.system.WorkNote.service.IWorkNoteService;

/**
 * 工作记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
@Service
public class WorkNoteServiceImpl implements IWorkNoteService 
{
    @Autowired
    private WorkNoteMapper workNoteMapper;

    /**
     * 查询工作记录
     * 
     * @param id 工作记录ID
     * @return 工作记录
     */
    @Override
    public WorkNote selectWorkNoteById(Long id)
    {
        return workNoteMapper.selectWorkNoteById(id);
    }

    /**
     * 查询工作记录列表
     * 
     * @param workNote 工作记录
     * @return 工作记录
     */
    @Override
    public List<WorkNote> selectWorkNoteList(WorkNote workNote)
    {
        return workNoteMapper.selectWorkNoteList(workNote);
    }

    /**
     * 新增工作记录
     * 
     * @param workNote 工作记录
     * @return 结果
     */
    @Override
    public int insertWorkNote(WorkNote workNote)
    {
        return workNoteMapper.insertWorkNote(workNote);
    }

    /**
     * 修改工作记录
     * 
     * @param workNote 工作记录
     * @return 结果
     */
    @Override
    public int updateWorkNote(WorkNote workNote)
    {
        return workNoteMapper.updateWorkNote(workNote);
    }

    /**
     * 删除工作记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkNoteByIds(String ids)
    {
        return workNoteMapper.deleteWorkNoteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工作记录信息
     * 
     * @param id 工作记录ID
     * @return 结果
     */
    @Override
    public int deleteWorkNoteById(Long id)
    {
        return workNoteMapper.deleteWorkNoteById(id);
    }
}
