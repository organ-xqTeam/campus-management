package com.ruoyi.project.system.schoolapplylist.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.schoolapplylist.mapper.SchoolapplylistMapper;
import com.ruoyi.project.system.schoolapplylist.domain.Schoolapplylist;
import com.ruoyi.project.system.schoolapplylist.service.ISchoolapplylistService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 审批Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
@Service
public class SchoolapplylistServiceImpl implements ISchoolapplylistService 
{
    @Autowired
    private SchoolapplylistMapper schoolapplylistMapper;

    /**
     * 查询审批
     * 
     * @param id 审批ID
     * @return 审批
     */
    @Override
    public Schoolapplylist selectSchoolapplylistById(Long id)
    {
        return schoolapplylistMapper.selectSchoolapplylistById(id);
    }

    /**
     * 查询审批列表
     * 
     * @param schoolapplylist 审批
     * @return 审批
     */
    @Override
    public List<Schoolapplylist> selectSchoolapplylistList(Schoolapplylist schoolapplylist)
    {
        return schoolapplylistMapper.selectSchoolapplylistList(schoolapplylist);
    }

    /**
     * 新增审批
     * 
     * @param schoolapplylist 审批
     * @return 结果
     */
    @Override
    public int insertSchoolapplylist(Schoolapplylist schoolapplylist)
    {
        return schoolapplylistMapper.insertSchoolapplylist(schoolapplylist);
    }

    /**
     * 修改审批
     * 
     * @param schoolapplylist 审批
     * @return 结果
     */
    @Override
    public int updateSchoolapplylist(Schoolapplylist schoolapplylist)
    {
        return schoolapplylistMapper.updateSchoolapplylist(schoolapplylist);
    }

    /**
     * 删除审批对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolapplylistByIds(String ids)
    {
        return schoolapplylistMapper.deleteSchoolapplylistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除审批信息
     * 
     * @param id 审批ID
     * @return 结果
     */
    @Override
    public int deleteSchoolapplylistById(Long id)
    {
        return schoolapplylistMapper.deleteSchoolapplylistById(id);
    }
}
