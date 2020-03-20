package com.ruoyi.project.system.schoolResult.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolResult.domain.SchoolResult;
import com.ruoyi.project.system.schoolResult.mapper.SchoolResultMapper;
import com.ruoyi.project.system.schoolResult.service.ISchoolResultService;

/**
 * 学校成绩Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
@Service
public class SchoolResultServiceImpl implements ISchoolResultService 
{
    @Autowired
    private SchoolResultMapper schoolResultMapper;

    /**
     * 查询学校成绩
     * 
     * @param id 学校成绩ID
     * @return 学校成绩
     */
    @Override
    public SchoolResult selectSchoolResultById(Long id)
    {
        return schoolResultMapper.selectSchoolResultById(id);
    }

    /**
     * 查询学校成绩列表
     * 
     * @param schoolResult 学校成绩
     * @return 学校成绩
     */
    @Override
    public List<SchoolResult> selectSchoolResultList(SchoolResult schoolResult)
    {
        return schoolResultMapper.selectSchoolResultList(schoolResult);
    }

    /**
     * 学生自己考试的成绩页面列表
     * */
    @Override
    public List<Map<String, Object>> selectSchoolResultList2(SchoolResult schoolResult) {
    	return schoolResultMapper.selectSchoolResultList2(schoolResult);
    }

    /**
     * 成绩管理新增学生页列表
     * */
    @Override
    public List<Map<String, Object>> stulist(Map<String, Object> params) {
    	return schoolResultMapper.stulist(params);
    }

    /**
     * 新增学校成绩
     * 
     * @param schoolResult 学校成绩
     * @return 结果
     */
    @Override
    public int insertSchoolResult(SchoolResult schoolResult)
    {
        return schoolResultMapper.insertSchoolResult(schoolResult);
    }

    /**
     * 修改学校成绩
     * 
     * @param schoolResult 学校成绩
     * @return 结果
     */
    @Override
    public int updateSchoolResult(SchoolResult schoolResult)
    {
        return schoolResultMapper.updateSchoolResult(schoolResult);
    }

    /**
     * 删除学校成绩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolResultByIds(String ids)
    {
        return schoolResultMapper.deleteSchoolResultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学校成绩信息
     * 
     * @param id 学校成绩ID
     * @return 结果
     */
    @Override
    public int deleteSchoolResultById(Long id)
    {
        return schoolResultMapper.deleteSchoolResultById(id);
    }
}
