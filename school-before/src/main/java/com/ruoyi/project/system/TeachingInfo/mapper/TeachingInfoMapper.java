package com.ruoyi.project.system.TeachingInfo.mapper;

import com.ruoyi.project.system.TeachingInfo.domain.TeachingInfo;
import java.util.List;

/**
 * 教师管理Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-22
 */
public interface TeachingInfoMapper 
{
    /**
     * 查询教师管理
     * 
     * @param id 教师管理ID
     * @return 教师管理
     */
    public TeachingInfo selectTeachingInfoById(Long id);

    /**
     * 查询教师管理列表
     * 
     * @param teachingInfo 教师管理
     * @return 教师管理集合
     */
    public List<TeachingInfo> selectTeachingInfoList(TeachingInfo teachingInfo);

    /**
     * 新增教师管理
     * 
     * @param teachingInfo 教师管理
     * @return 结果
     */
    public int insertTeachingInfo(TeachingInfo teachingInfo);

    /**
     * 修改教师管理
     * 
     * @param teachingInfo 教师管理
     * @return 结果
     */
    public int updateTeachingInfo(TeachingInfo teachingInfo);

    /**
     * 删除教师管理
     * 
     * @param id 教师管理ID
     * @return 结果
     */
    public int deleteTeachingInfoById(Long id);

    /**
     * 批量删除教师管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTeachingInfoByIds(String[] ids);
}
