package com.ruoyi.project.system.schoolteachingplanfilelist.service;

import com.ruoyi.project.system.schoolteachingplanfilelist.domain.Schoolteachingplanfilelist;
import java.util.List;

/**
 * 教案文件Service接口
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
public interface ISchoolteachingplanfilelistService 
{
    /**
     * 查询教案文件
     * 
     * @param id 教案文件ID
     * @return 教案文件
     */
    public Schoolteachingplanfilelist selectSchoolteachingplanfilelistById(Long id);

    /**
     * 查询教案文件列表
     * 
     * @param schoolteachingplanfilelist 教案文件
     * @return 教案文件集合
     */
    public List<Schoolteachingplanfilelist> selectSchoolteachingplanfilelistList(Schoolteachingplanfilelist schoolteachingplanfilelist);

    /**
     * 新增教案文件
     * 
     * @param schoolteachingplanfilelist 教案文件
     * @return 结果
     */
    public int insertSchoolteachingplanfilelist(Schoolteachingplanfilelist schoolteachingplanfilelist);

    /**
     * 修改教案文件
     * 
     * @param schoolteachingplanfilelist 教案文件
     * @return 结果
     */
    public int updateSchoolteachingplanfilelist(Schoolteachingplanfilelist schoolteachingplanfilelist);

    /**
     * 批量删除教案文件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolteachingplanfilelistByIds(String ids);

    /**
     * 删除教案文件信息
     * 
     * @param id 教案文件ID
     * @return 结果
     */
    public int deleteSchoolteachingplanfilelistById(Long id);
}
