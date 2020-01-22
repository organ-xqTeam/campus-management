package com.ruoyi.project.system.schoolHomeworkDetail.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolHomeworkDetail.domain.SchoolHomeworkDetail;
import com.ruoyi.project.system.schoolHomeworkDetail.mapper.SchoolHomeworkDetailMapper;
import com.ruoyi.project.system.schoolHomeworkDetail.service.ISchoolHomeworkDetailService;

/**
 * 学校作业表Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
@Service
public class SchoolHomeworkDetailServiceImpl implements ISchoolHomeworkDetailService 
{
    @Autowired
    private SchoolHomeworkDetailMapper schoolHomeworkDetailMapper;

    /**
     * 查询学校作业表
     * 
     * @param id 学校作业表ID
     * @return 学校作业表
     */
    @Override
    public SchoolHomeworkDetail selectSchoolHomeworkDetailById(Long id)
    {
        return schoolHomeworkDetailMapper.selectSchoolHomeworkDetailById(id);
    }

    /**
     * 查询学校作业表列表
     * 
     * @param schoolHomeworkDetail 学校作业表
     * @return 学校作业表
     */
    @Override
    public List<SchoolHomeworkDetail> selectSchoolHomeworkDetailList(SchoolHomeworkDetail schoolHomeworkDetail)
    {
        return schoolHomeworkDetailMapper.selectSchoolHomeworkDetailList(schoolHomeworkDetail);
    }

    /**
     * 新增学校作业表
     * 
     * @param schoolHomeworkDetail 学校作业表
     * @return 结果
     */
    @Override
    public int insertSchoolHomeworkDetail(SchoolHomeworkDetail schoolHomeworkDetail)
    {
        return schoolHomeworkDetailMapper.insertSchoolHomeworkDetail(schoolHomeworkDetail);
    }

    /**
     * 修改学校作业表
     * 
     * @param schoolHomeworkDetail 学校作业表
     * @return 结果
     */
    @Override
    public int updateSchoolHomeworkDetail(SchoolHomeworkDetail schoolHomeworkDetail)
    {
        return schoolHomeworkDetailMapper.updateSchoolHomeworkDetail(schoolHomeworkDetail);
    }

    /**
     * 删除学校作业表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolHomeworkDetailByIds(String ids)
    {
        return schoolHomeworkDetailMapper.deleteSchoolHomeworkDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学校作业表信息
     * 
     * @param id 学校作业表ID
     * @return 结果
     */
    @Override
    public int deleteSchoolHomeworkDetailById(Long id)
    {
        return schoolHomeworkDetailMapper.deleteSchoolHomeworkDetailById(id);
    }
    /**通过HomeworkId 查找HomeworkDetail关联得学生信息*/
	@Override
	public List<Map<String, Object>> selectSchoolHomeworkDetailStudentsListByHomeworkId(Map<String, Object> parmMap) {
		// TODO Auto-generated method stub
		 /**通过HomeworkId 查找HomeworkDetail关联得学生信息*/
		return schoolHomeworkDetailMapper.selectSchoolHomeworkDetailStudentsListByHomeworkId(parmMap);
	}
}
