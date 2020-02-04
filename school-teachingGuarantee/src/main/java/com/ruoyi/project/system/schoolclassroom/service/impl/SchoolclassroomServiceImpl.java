package com.ruoyi.project.system.schoolclassroom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.schoolclassroom.domain.Schoolclassroom;
import com.ruoyi.project.system.schoolclassroom.mapper.SchoolclassroomMapper;
import com.ruoyi.project.system.schoolclassroom.service.ISchoolclassroomService;

/**
 * 教室管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SchoolclassroomServiceImpl implements ISchoolclassroomService 
{
    @Autowired
    private SchoolclassroomMapper schoolclassroomMapper;

    /**
     * 查询教室管理
     * 
     * @param id 教室管理ID
     * @return 教室管理
     */
    @Override
    public Schoolclassroom selectSchoolclassroomById(Long id)
    {
        return schoolclassroomMapper.selectSchoolclassroomById(id);
    }

    /**
     * 查询教室管理列表
     * 
     * @param schoolclassroom 教室管理
     * @return 教室管理
     */
    @Override
    public List<Schoolclassroom> selectSchoolclassroomList(Schoolclassroom schoolclassroom)
    {
        return schoolclassroomMapper.selectSchoolclassroomList(schoolclassroom);
    }

    /**
     * 新增教室管理
     * 
     * @param schoolclassroom 教室管理
     * @return 结果
     */
    @Override
    public int insertSchoolclassroom(Schoolclassroom schoolclassroom)
    {
    	schoolclassroom.setCreatedate(DateUtils.getTime());
        return schoolclassroomMapper.insertSchoolclassroom(schoolclassroom);
    }

    /**
     * 修改教室管理
     * 
     * @param schoolclassroom 教室管理
     * @return 结果
     */
    @Override
    public int updateSchoolclassroom(Schoolclassroom schoolclassroom)
    {
        return schoolclassroomMapper.updateSchoolclassroom(schoolclassroom);
    }

    /**
     * 删除教室管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolclassroomByIds(String ids)
    {
        return schoolclassroomMapper.deleteSchoolclassroomByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教室管理信息
     * 
     * @param id 教室管理ID
     * @return 结果
     */
    @Override
    public int deleteSchoolclassroomById(Long id)
    {
        return schoolclassroomMapper.deleteSchoolclassroomById(id);
    }
}
