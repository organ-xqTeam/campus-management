package com.ruoyi.project.system.TrainManage.mapper;

import com.ruoyi.project.system.TrainManage.domain.TrainManage;
import java.util.List;

/**
 * 专业培训管理方案Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
public interface TrainManageMapper 
{
    /**
     * 查询专业培训管理方案
     * 
     * @param id 专业培训管理方案ID
     * @return 专业培训管理方案
     */
    public TrainManage selectTrainManageById(Long id);

    /**
     * 查询专业培训管理方案列表
     * 
     * @param trainManage 专业培训管理方案
     * @return 专业培训管理方案集合
     */
    public List<TrainManage> selectTrainManageList(TrainManage trainManage);

    /**
     * 新增专业培训管理方案
     * 
     * @param trainManage 专业培训管理方案
     * @return 结果
     */
    public int insertTrainManage(TrainManage trainManage);

    /**
     * 修改专业培训管理方案
     * 
     * @param trainManage 专业培训管理方案
     * @return 结果
     */
    public int updateTrainManage(TrainManage trainManage);

    /**
     * 删除专业培训管理方案
     * 
     * @param id 专业培训管理方案ID
     * @return 结果
     */
    public int deleteTrainManageById(Long id);

    /**
     * 批量删除专业培训管理方案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTrainManageByIds(String[] ids);
}
