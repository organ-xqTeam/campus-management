package com.ruoyi.project.system.schoolteachingplanlist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolteachingplanlist.domain.Schoolteachingplanlist;
import com.ruoyi.project.system.schoolteachingplanlist.mapper.SchoolteachingplanlistMapper;
import com.ruoyi.project.system.schoolteachingplanlist.service.ISchoolteachingplanlistService;

/**
 * 教案Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class SchoolteachingplanlistServiceImpl implements ISchoolteachingplanlistService 
{
    @Autowired
    private SchoolteachingplanlistMapper schoolteachingplanlistMapper;

    /**
     * 查询教案
     * 
     * @param id 教案ID
     * @return 教案
     */
    @Override
    public Schoolteachingplanlist selectSchoolteachingplanlistById(Long id)
    {
        return schoolteachingplanlistMapper.selectSchoolteachingplanlistById(id);
    }

    /**
     * 查询教案列表
     * 
     * @param schoolteachingplanlist 教案
     * @return 教案
     */
    @Override
    public List<Schoolteachingplanlist> selectSchoolteachingplanlistList(Schoolteachingplanlist schoolteachingplanlist)
    {
        return schoolteachingplanlistMapper.selectSchoolteachingplanlistList(schoolteachingplanlist);
    }

    /**
     * 新增教案
     * 
     * @param schoolteachingplanlist 教案
     * @return 结果
     */
    @Override
    public int insertSchoolteachingplanlist(Schoolteachingplanlist schoolteachingplanlist)
    {
        return schoolteachingplanlistMapper.insertSchoolteachingplanlist(schoolteachingplanlist);
    }

    /**
     * 修改教案
     * 
     * @param schoolteachingplanlist 教案
     * @return 结果
     */
    @Override
    public int updateSchoolteachingplanlist(Schoolteachingplanlist schoolteachingplanlist)
    {
        return schoolteachingplanlistMapper.updateSchoolteachingplanlist(schoolteachingplanlist);
    }

    /**
     * 删除教案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolteachingplanlistByIds(String ids)
    {
        return schoolteachingplanlistMapper.deleteSchoolteachingplanlistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教案信息
     * 
     * @param id 教案ID
     * @return 结果
     */
    @Override
    public int deleteSchoolteachingplanlistById(Long id)
    {
        return schoolteachingplanlistMapper.deleteSchoolteachingplanlistById(id);
    }
}
