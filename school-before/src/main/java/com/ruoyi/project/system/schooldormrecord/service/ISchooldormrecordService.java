package com.ruoyi.project.system.schooldormrecord.service;

import com.ruoyi.project.system.schooldormrecord.domain.Schooldormrecord;
import java.util.List;

/**
 * 住宿记录Service接口
 * 
 * @author ruoyi
 * @date 2019-11-18
 */
public interface ISchooldormrecordService 
{
    /**
     * 查询住宿记录
     * 
     * @param id 住宿记录ID
     * @return 住宿记录
     */
    public Schooldormrecord selectSchooldormrecordById(Long id);

    /**
     * 查询住宿记录列表
     * 
     * @param schooldormrecord 住宿记录
     * @return 住宿记录集合
     */
    public List<Schooldormrecord> selectSchooldormrecordList(Schooldormrecord schooldormrecord);

    /**
     * 新增住宿记录
     * 
     * @param schooldormrecord 住宿记录
     * @return 结果
     */
    public int insertSchooldormrecord(Schooldormrecord schooldormrecord);

    /**
     * 修改住宿记录
     * 
     * @param schooldormrecord 住宿记录
     * @return 结果
     */
    public int updateSchooldormrecord(Schooldormrecord schooldormrecord);

    /**
     * 批量删除住宿记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchooldormrecordByIds(String ids);

    /**
     * 删除住宿记录信息
     * 
     * @param id 住宿记录ID
     * @return 结果
     */
    public int deleteSchooldormrecordById(Long id);
}
