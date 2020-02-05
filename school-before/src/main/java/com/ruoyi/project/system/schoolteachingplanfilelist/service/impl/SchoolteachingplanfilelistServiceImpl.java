package com.ruoyi.project.system.schoolteachingplanfilelist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolteachingplanfilelist.domain.Schoolteachingplanfilelist;
import com.ruoyi.project.system.schoolteachingplanfilelist.mapper.SchoolteachingplanfilelistMapper;
import com.ruoyi.project.system.schoolteachingplanfilelist.service.ISchoolteachingplanfilelistService;

/**
 * 教案文件Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class SchoolteachingplanfilelistServiceImpl implements ISchoolteachingplanfilelistService 
{
    @Autowired
    private SchoolteachingplanfilelistMapper schoolteachingplanfilelistMapper;

    /**
     * 查询教案文件
     * 
     * @param id 教案文件ID
     * @return 教案文件
     */
    @Override
    public Schoolteachingplanfilelist selectSchoolteachingplanfilelistById(Long id)
    {
        return schoolteachingplanfilelistMapper.selectSchoolteachingplanfilelistById(id);
    }

    /**
     * 查询教案文件列表
     * 
     * @param schoolteachingplanfilelist 教案文件
     * @return 教案文件
     */
    @Override
    public List<Schoolteachingplanfilelist> selectSchoolteachingplanfilelistList(Schoolteachingplanfilelist schoolteachingplanfilelist)
    {
        return schoolteachingplanfilelistMapper.selectSchoolteachingplanfilelistList(schoolteachingplanfilelist);
    }

    /**
     * 新增教案文件
     * 
     * @param schoolteachingplanfilelist 教案文件
     * @return 结果
     */
    @Override
    public int insertSchoolteachingplanfilelist(Schoolteachingplanfilelist schoolteachingplanfilelist)
    {
        return schoolteachingplanfilelistMapper.insertSchoolteachingplanfilelist(schoolteachingplanfilelist);
    }

    /**
     * 修改教案文件
     * 
     * @param schoolteachingplanfilelist 教案文件
     * @return 结果
     */
    @Override
    public int updateSchoolteachingplanfilelist(Schoolteachingplanfilelist schoolteachingplanfilelist)
    {
        return schoolteachingplanfilelistMapper.updateSchoolteachingplanfilelist(schoolteachingplanfilelist);
    }

    /**
     * 删除教案文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolteachingplanfilelistByIds(String ids)
    {
        return schoolteachingplanfilelistMapper.deleteSchoolteachingplanfilelistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教案文件信息
     * 
     * @param id 教案文件ID
     * @return 结果
     */
    @Override
    public int deleteSchoolteachingplanfilelistById(Long id)
    {
        return schoolteachingplanfilelistMapper.deleteSchoolteachingplanfilelistById(id);
    }
}
