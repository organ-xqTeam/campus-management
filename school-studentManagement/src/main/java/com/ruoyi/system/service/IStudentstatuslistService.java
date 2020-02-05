package com.ruoyi.system.service;

import com.ruoyi.system.domain.Studentstatuslist;
import java.util.List;

/**
 * 学籍管理Service接口
 * 
 * @author ruoyi
 * @date 2020-02-04
 */
public interface IStudentstatuslistService 
{
    /**
     * 查询学籍管理
     * 
     * @param id 学籍管理ID
     * @return 学籍管理
     */
    public Studentstatuslist selectStudentstatuslistById(Long id);

    /**
     * 查询学籍管理列表
     * 
     * @param studentstatuslist 学籍管理
     * @return 学籍管理集合
     */
    public List<Studentstatuslist> selectStudentstatuslistList(Studentstatuslist studentstatuslist);

    /**
     * 新增学籍管理
     * 
     * @param studentstatuslist 学籍管理
     * @return 结果
     */
    public int insertStudentstatuslist(Studentstatuslist studentstatuslist);

    /**
     * 修改学籍管理
     * 
     * @param studentstatuslist 学籍管理
     * @return 结果
     */
    public int updateStudentstatuslist(Studentstatuslist studentstatuslist);

    /**
     * 批量删除学籍管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentstatuslistByIds(String ids);

    /**
     * 删除学籍管理信息
     * 
     * @param id 学籍管理ID
     * @return 结果
     */
    public int deleteStudentstatuslistById(Long id);
}
