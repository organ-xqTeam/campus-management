package com.ruoyi.project.system.schoolHomework.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolHomework.domain.SchoolHomework;
import com.ruoyi.project.system.schoolHomework.mapper.SchoolHomeworkMapper;
import com.ruoyi.project.system.schoolHomework.service.ISchoolHomeworkService;

/**
 * 学生作业表Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
@Service
public class SchoolHomeworkServiceImpl implements ISchoolHomeworkService 
{
    @Autowired
    private SchoolHomeworkMapper schoolHomeworkMapper;

    /**
     * 查询学生作业表
     * 
     * @param id 学生作业表ID
     * @return 学生作业表
     */
    @Override
    public SchoolHomework selectSchoolHomeworkById(Long id)
    {
        return schoolHomeworkMapper.selectSchoolHomeworkById(id);
    }
    
    /**
     * 作业管理新增学生页列表
     * */
    @Override
    public List<Map<String, Object>> stulist(Map<String, Object> params) {
    	return schoolHomeworkMapper.stulist(params);
    }

    /**
     * 查询学生作业表列表
     * 
     * @param schoolHomework 学生作业表
     * @return 学生作业表
     */
    @Override
    public List<SchoolHomework> selectSchoolHomeworkList(SchoolHomework schoolHomework)
    {
    	if (schoolHomework.getStudentid() != null) {
    		return schoolHomeworkMapper.selectSchoolHomeworkListByStudentid(schoolHomework);
    	}
        return schoolHomeworkMapper.selectSchoolHomeworkList(schoolHomework);
    }

    /**
     * 新增学生作业表
     * 
     * @param schoolHomework 学生作业表
     * @return 结果
     */
    @Override
    public int insertSchoolHomework(SchoolHomework schoolHomework)
    {
        return schoolHomeworkMapper.insertSchoolHomework(schoolHomework);
    }

    /**
     * 修改学生作业表
     * 
     * @param schoolHomework 学生作业表
     * @return 结果
     */
    @Override
    public int updateSchoolHomework(SchoolHomework schoolHomework)
    {
        return schoolHomeworkMapper.updateSchoolHomework(schoolHomework);
    }

    /**
     * 删除学生作业表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolHomeworkByIds(String ids)
    {
        return schoolHomeworkMapper.deleteSchoolHomeworkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生作业表信息
     * 
     * @param id 学生作业表ID
     * @return 结果
     */
    @Override
    public int deleteSchoolHomeworkById(Long id)
    {
        return schoolHomeworkMapper.deleteSchoolHomeworkById(id);
    }
}
