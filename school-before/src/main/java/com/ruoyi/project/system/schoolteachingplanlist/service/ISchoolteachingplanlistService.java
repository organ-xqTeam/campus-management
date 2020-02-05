package com.ruoyi.project.system.schoolteachingplanlist.service;

import com.ruoyi.project.system.schoolteachingplanlist.domain.Schoolteachingplanlist;
import java.util.List;

/**
 * 教案Service接口
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
public interface ISchoolteachingplanlistService 
{
    /**
     * 查询教案
     * 
     * @param id 教案ID
     * @return 教案
     */
    public Schoolteachingplanlist selectSchoolteachingplanlistById(Long id);

    /**
     * 查询教案列表
     * 
     * @param schoolteachingplanlist 教案
     * @return 教案集合
     */
    public List<Schoolteachingplanlist> selectSchoolteachingplanlistList(Schoolteachingplanlist schoolteachingplanlist);

    /**
     * 新增教案
     * 
     * @param schoolteachingplanlist 教案
     * @return 结果
     */
    public int insertSchoolteachingplanlist(Schoolteachingplanlist schoolteachingplanlist);

    /**
     * 修改教案
     * 
     * @param schoolteachingplanlist 教案
     * @return 结果
     */
    public int updateSchoolteachingplanlist(Schoolteachingplanlist schoolteachingplanlist);

    /**
     * 批量删除教案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolteachingplanlistByIds(String ids);

    /**
     * 删除教案信息
     * 
     * @param id 教案ID
     * @return 结果
     */
    public int deleteSchoolteachingplanlistById(Long id);
}
