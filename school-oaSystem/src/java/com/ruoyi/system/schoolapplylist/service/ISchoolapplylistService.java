package com.ruoyi.project.system.schoolapplylist.service;

import com.ruoyi.project.system.schoolapplylist.domain.Schoolapplylist;
import java.util.List;

/**
 * 审批Service接口
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
public interface ISchoolapplylistService 
{
    /**
     * 查询审批
     * 
     * @param id 审批ID
     * @return 审批
     */
    public Schoolapplylist selectSchoolapplylistById(Long id);

    /**
     * 查询审批列表
     * 
     * @param schoolapplylist 审批
     * @return 审批集合
     */
    public List<Schoolapplylist> selectSchoolapplylistList(Schoolapplylist schoolapplylist);

    /**
     * 新增审批
     * 
     * @param schoolapplylist 审批
     * @return 结果
     */
    public int insertSchoolapplylist(Schoolapplylist schoolapplylist);

    /**
     * 修改审批
     * 
     * @param schoolapplylist 审批
     * @return 结果
     */
    public int updateSchoolapplylist(Schoolapplylist schoolapplylist);

    /**
     * 批量删除审批
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolapplylistByIds(String ids);

    /**
     * 删除审批信息
     * 
     * @param id 审批ID
     * @return 结果
     */
    public int deleteSchoolapplylistById(Long id);
}
