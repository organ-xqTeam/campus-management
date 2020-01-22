package com.ruoyi.project.system.schoolstudenthistorylist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolstudenthistorylist.domain.Schoolstudenthistorylist;
import com.ruoyi.project.system.schoolstudenthistorylist.mapper.SchoolstudenthistorylistMapper;
import com.ruoyi.project.system.schoolstudenthistorylist.service.ISchoolstudenthistorylistService;

/**
 * 调班历史Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
@Service
public class SchoolstudenthistorylistServiceImpl implements ISchoolstudenthistorylistService 
{
    @Autowired
    private SchoolstudenthistorylistMapper schoolstudenthistorylistMapper;

    /**
     * 查询调班历史
     * 
     * @param id 调班历史ID
     * @return 调班历史
     */
    @Override
    public Schoolstudenthistorylist selectSchoolstudenthistorylistById(Long id)
    {
        return schoolstudenthistorylistMapper.selectSchoolstudenthistorylistById(id);
    }

    /**
     * 查询调班历史列表
     * 
     * @param schoolstudenthistorylist 调班历史
     * @return 调班历史
     */
    @Override
    public List<Schoolstudenthistorylist> selectSchoolstudenthistorylistList(Schoolstudenthistorylist schoolstudenthistorylist)
    {
        return schoolstudenthistorylistMapper.selectSchoolstudenthistorylistList(schoolstudenthistorylist);
    }

    /**
     * 新增调班历史
     * 
     * @param schoolstudenthistorylist 调班历史
     * @return 结果
     */
    @Override
    public int insertSchoolstudenthistorylist(Schoolstudenthistorylist schoolstudenthistorylist)
    {
        return schoolstudenthistorylistMapper.insertSchoolstudenthistorylist(schoolstudenthistorylist);
    }

    /**
     * 修改调班历史
     * 
     * @param schoolstudenthistorylist 调班历史
     * @return 结果
     */
    @Override
    public int updateSchoolstudenthistorylist(Schoolstudenthistorylist schoolstudenthistorylist)
    {
        return schoolstudenthistorylistMapper.updateSchoolstudenthistorylist(schoolstudenthistorylist);
    }

    /**
     * 删除调班历史对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudenthistorylistByIds(String ids)
    {
        return schoolstudenthistorylistMapper.deleteSchoolstudenthistorylistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除调班历史信息
     * 
     * @param id 调班历史ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudenthistorylistById(Long id)
    {
        return schoolstudenthistorylistMapper.deleteSchoolstudenthistorylistById(id);
    }
}
