package com.ruoyi.project.system.schoolstudenthistorylist.service;

import com.ruoyi.project.system.schoolstudenthistorylist.domain.Schoolstudenthistorylist;
import java.util.List;

/**
 * 调班历史Service接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface ISchoolstudenthistorylistService 
{
    /**
     * 查询调班历史
     * 
     * @param id 调班历史ID
     * @return 调班历史
     */
    public Schoolstudenthistorylist selectSchoolstudenthistorylistById(Long id);

    /**
     * 查询调班历史列表
     * 
     * @param schoolstudenthistorylist 调班历史
     * @return 调班历史集合
     */
    public List<Schoolstudenthistorylist> selectSchoolstudenthistorylistList(Schoolstudenthistorylist schoolstudenthistorylist);

    /**
     * 新增调班历史
     * 
     * @param schoolstudenthistorylist 调班历史
     * @return 结果
     */
    public int insertSchoolstudenthistorylist(Schoolstudenthistorylist schoolstudenthistorylist);

    /**
     * 修改调班历史
     * 
     * @param schoolstudenthistorylist 调班历史
     * @return 结果
     */
    public int updateSchoolstudenthistorylist(Schoolstudenthistorylist schoolstudenthistorylist);

    /**
     * 批量删除调班历史
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolstudenthistorylistByIds(String ids);

    /**
     * 删除调班历史信息
     * 
     * @param id 调班历史ID
     * @return 结果
     */
    public int deleteSchoolstudenthistorylistById(Long id);
}
