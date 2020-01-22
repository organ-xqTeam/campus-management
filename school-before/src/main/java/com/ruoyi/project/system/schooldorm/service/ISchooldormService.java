package com.ruoyi.project.system.schooldorm.service;

import com.ruoyi.project.system.schooldorm.domain.Schooldorm;
import java.util.List;

/**
 * 宿舍Service接口
 * 
 * @author ruoyi
 * @date 2019-11-14
 */
public interface ISchooldormService 
{
    /**
     * 查询宿舍
     * 
     * @param id 宿舍ID
     * @return 宿舍
     */
    public Schooldorm selectSchooldormById(Long id);

    /**
     * 查询宿舍列表
     * 
     * @param schooldorm 宿舍
     * @return 宿舍集合
     */
    public List<Schooldorm> selectSchooldormList(Schooldorm schooldorm);

    /**
     * 新增宿舍
     * 
     * @param schooldorm 宿舍
     * @return 结果
     */
    public int insertSchooldorm(Schooldorm schooldorm);

    /**
     * 修改宿舍
     * 
     * @param schooldorm 宿舍
     * @return 结果
     */
    public int updateSchooldorm(Schooldorm schooldorm);

    /**
     * 批量删除宿舍
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchooldormByIds(String ids);

    /**
     * 删除宿舍信息
     * 
     * @param id 宿舍ID
     * @return 结果
     */
    public int deleteSchooldormById(Long id);
}
