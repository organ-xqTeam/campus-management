package com.ruoyi.project.system.schoolcoursewareinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolcoursewareinfo.domain.Schoolcoursewareinfo;
import com.ruoyi.project.system.schoolcoursewareinfo.mapper.SchoolcoursewareinfoMapper;
import com.ruoyi.project.system.schoolcoursewareinfo.service.ISchoolcoursewareinfoService;

/**
 * 课件列Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-10
 */
@Service
public class SchoolcoursewareinfoServiceImpl implements ISchoolcoursewareinfoService 
{
    @Autowired
    private SchoolcoursewareinfoMapper schoolcoursewareinfoMapper;

    /**
     * 查询课件列
     * 
     * @param id 课件列ID
     * @return 课件列
     */
    @Override
    public Schoolcoursewareinfo selectSchoolcoursewareinfoById(Long id)
    {
        return schoolcoursewareinfoMapper.selectSchoolcoursewareinfoById(id);
    }

    /**
     * 查询课件列列表
     * 
     * @param schoolcoursewareinfo 课件列
     * @return 课件列
     */
    @Override
    public List<Schoolcoursewareinfo> selectSchoolcoursewareinfoList(Schoolcoursewareinfo schoolcoursewareinfo)
    {
        return schoolcoursewareinfoMapper.selectSchoolcoursewareinfoList(schoolcoursewareinfo);
    }

    /**
     * 新增课件列
     * 
     * @param schoolcoursewareinfo 课件列
     * @return 结果
     */
    @Override
    public int insertSchoolcoursewareinfo(Schoolcoursewareinfo schoolcoursewareinfo)
    {
        return schoolcoursewareinfoMapper.insertSchoolcoursewareinfo(schoolcoursewareinfo);
    }

    /**
     * 修改课件列
     * 
     * @param schoolcoursewareinfo 课件列
     * @return 结果
     */
    @Override
    public int updateSchoolcoursewareinfo(Schoolcoursewareinfo schoolcoursewareinfo)
    {
        return schoolcoursewareinfoMapper.updateSchoolcoursewareinfo(schoolcoursewareinfo);
    }

    /**
     * 删除课件列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolcoursewareinfoByIds(String ids)
    {
        return schoolcoursewareinfoMapper.deleteSchoolcoursewareinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课件列信息
     * 
     * @param id 课件列ID
     * @return 结果
     */
    @Override
    public int deleteSchoolcoursewareinfoById(Long id)
    {
        return schoolcoursewareinfoMapper.deleteSchoolcoursewareinfoById(id);
    }
}
