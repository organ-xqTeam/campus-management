package com.ruoyi.project.system.TimetableSearch.service;

import com.ruoyi.project.system.TimetableSearch.domain.TimetableSearch;
import java.util.List;

/**
 * 个人人事安排查询Service接口
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
public interface ITimetableSearchService 
{
    /**
     * 查询个人人事安排查询
     * 
     * @param id 个人人事安排查询ID
     * @return 个人人事安排查询
     */
    public TimetableSearch selectTimetableSearchById(Long id);

    /**
     * 查询个人人事安排查询列表
     * 
     * @param timetableSearch 个人人事安排查询
     * @return 个人人事安排查询集合
     */
    public List<TimetableSearch> selectTimetableSearchList(TimetableSearch timetableSearch);

    /**
     * 新增个人人事安排查询
     * 
     * @param timetableSearch 个人人事安排查询
     * @return 结果
     */
    public int insertTimetableSearch(TimetableSearch timetableSearch);

    /**
     * 修改个人人事安排查询
     * 
     * @param timetableSearch 个人人事安排查询
     * @return 结果
     */
    public int updateTimetableSearch(TimetableSearch timetableSearch);

    /**
     * 批量删除个人人事安排查询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTimetableSearchByIds(String ids);

    /**
     * 删除个人人事安排查询信息
     * 
     * @param id 个人人事安排查询ID
     * @return 结果
     */
    public int deleteTimetableSearchById(Long id);
}
