package com.ruoyi.project.system.TrainManage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.TrainManage.mapper.TrainManageMapper;
import com.ruoyi.project.system.TrainManage.domain.TrainManage;
import com.ruoyi.project.system.TrainManage.service.ITrainManageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专业培训管理方案Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
@Service
public class TrainManageServiceImpl implements ITrainManageService 
{
    @Autowired
    private TrainManageMapper trainManageMapper;

    /**
     * 查询专业培训管理方案
     * 
     * @param id 专业培训管理方案ID
     * @return 专业培训管理方案
     */
    @Override
    public TrainManage selectTrainManageById(Long id)
    {
        return trainManageMapper.selectTrainManageById(id);
    }

    /**
     * 查询专业培训管理方案列表
     * 
     * @param trainManage 专业培训管理方案
     * @return 专业培训管理方案
     */
    @Override
    public List<TrainManage> selectTrainManageList(TrainManage trainManage)
    {
        return trainManageMapper.selectTrainManageList(trainManage);
    }

    /**
     * 新增专业培训管理方案
     * 
     * @param trainManage 专业培训管理方案
     * @return 结果
     */
    @Override
    public int insertTrainManage(TrainManage trainManage)
    {
        return trainManageMapper.insertTrainManage(trainManage);
    }

    /**
     * 修改专业培训管理方案
     * 
     * @param trainManage 专业培训管理方案
     * @return 结果
     */
    @Override
    public int updateTrainManage(TrainManage trainManage)
    {
        return trainManageMapper.updateTrainManage(trainManage);
    }

    /**
     * 删除专业培训管理方案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTrainManageByIds(String ids)
    {
        return trainManageMapper.deleteTrainManageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专业培训管理方案信息
     * 
     * @param id 专业培训管理方案ID
     * @return 结果
     */
    @Override
    public int deleteTrainManageById(Long id)
    {
        return trainManageMapper.deleteTrainManageById(id);
    }
}
