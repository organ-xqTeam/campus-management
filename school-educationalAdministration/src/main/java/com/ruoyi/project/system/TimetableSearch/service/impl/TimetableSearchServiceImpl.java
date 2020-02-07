package com.ruoyi.project.system.TimetableSearch.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.TimetableSearch.mapper.TimetableSearchMapper;
import com.ruoyi.project.system.TimetableSearch.domain.TimetableSearch;
import com.ruoyi.project.system.TimetableSearch.service.ITimetableSearchService;
import com.ruoyi.common.core.text.Convert;

/**
 * 个人人事安排查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
@Service
public class TimetableSearchServiceImpl implements ITimetableSearchService 
{
    @Autowired
    private TimetableSearchMapper timetableSearchMapper;

    /**
     * 查询个人人事安排查询
     * 
     * @param id 个人人事安排查询ID
     * @return 个人人事安排查询
     */
    @Override
    public TimetableSearch selectTimetableSearchById(Long id)
    {
        return timetableSearchMapper.selectTimetableSearchById(id);
    }

    /**
     * 查询个人人事安排查询列表
     * 
     * @param timetableSearch 个人人事安排查询
     * @return 个人人事安排查询
     */
    @Override
    public List<TimetableSearch> selectTimetableSearchList(TimetableSearch timetableSearch)
    {
        return timetableSearchMapper.selectTimetableSearchList(timetableSearch);
    }

    /**
     * 新增个人人事安排查询
     * 
     * @param timetableSearch 个人人事安排查询
     * @return 结果
     */
    @Override
    public int insertTimetableSearch(TimetableSearch timetableSearch)
    {
        return timetableSearchMapper.insertTimetableSearch(timetableSearch);
    }

    /**
     * 修改个人人事安排查询
     * 
     * @param timetableSearch 个人人事安排查询
     * @return 结果
     */
    @Override
    public int updateTimetableSearch(TimetableSearch timetableSearch)
    {
        return timetableSearchMapper.updateTimetableSearch(timetableSearch);
    }

    /**
     * 删除个人人事安排查询对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTimetableSearchByIds(String ids)
    {
        return timetableSearchMapper.deleteTimetableSearchByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除个人人事安排查询信息
     * 
     * @param id 个人人事安排查询ID
     * @return 结果
     */
    @Override
    public int deleteTimetableSearchById(Long id)
    {
        return timetableSearchMapper.deleteTimetableSearchById(id);
    }
}
