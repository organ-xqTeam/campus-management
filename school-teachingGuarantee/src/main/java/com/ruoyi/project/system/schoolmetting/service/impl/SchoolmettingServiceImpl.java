package com.ruoyi.project.system.schoolmetting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolmetting.domain.Schoolmetting;
import com.ruoyi.project.system.schoolmetting.mapper.SchoolmettingMapper;
import com.ruoyi.project.system.schoolmetting.service.ISchoolmettingService;

/**
 * 会议管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SchoolmettingServiceImpl implements ISchoolmettingService 
{
    @Autowired
    private SchoolmettingMapper schoolmettingMapper;

    /**
     * 查询会议管理
     * 
     * @param id 会议管理ID
     * @return 会议管理
     */
    @Override
    public Schoolmetting selectSchoolmettingById(Long id)
    {
        return schoolmettingMapper.selectSchoolmettingById(id);
    }

    /**
     * 查询会议管理列表
     * 
     * @param schoolmetting 会议管理
     * @return 会议管理
     */
    @Override
    public List<Schoolmetting> selectSchoolmettingList(Schoolmetting schoolmetting)
    {
        return schoolmettingMapper.selectSchoolmettingList(schoolmetting);
    }

    /**
     * 新增会议管理
     * 
     * @param schoolmetting 会议管理
     * @return 结果
     */
    @Override
    public int insertSchoolmetting(Schoolmetting schoolmetting)
    {
        return schoolmettingMapper.insertSchoolmetting(schoolmetting);
    }

    /**
     * 修改会议管理
     * 
     * @param schoolmetting 会议管理
     * @return 结果
     */
    @Override
    public int updateSchoolmetting(Schoolmetting schoolmetting)
    {
        return schoolmettingMapper.updateSchoolmetting(schoolmetting);
    }

    /**
     * 删除会议管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolmettingByIds(String ids)
    {
        return schoolmettingMapper.deleteSchoolmettingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会议管理信息
     * 
     * @param id 会议管理ID
     * @return 结果
     */
    @Override
    public int deleteSchoolmettingById(Long id)
    {
        return schoolmettingMapper.deleteSchoolmettingById(id);
    }
}
