package com.ruoyi.project.system.schoolHomeworkDetail.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolHomeworkDetail.domain.SchoolHomeworkDetail;
import com.ruoyi.project.system.schoolHomeworkDetail.mapper.SchoolHomeworkDetailMapper;
import com.ruoyi.project.system.schoolHomeworkDetail.service.ISchoolHomeworkDetailService;
import com.ruoyi.project.system.schoolHomeworkDetailDetail.domain.SchoolHomeworkDetailDetail;
import com.ruoyi.project.system.schoolHomeworkDetailDetail.mapper.SchoolHomeworkDetailDetailMapper;

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
    @Autowired
    private SchoolHomeworkDetailDetailMapper schoolHomeworkDetailDetailMapper;

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
     * app端 - 学生端 - 作业列表
     * */
    @Override
    public List<Map<String, Object>> selectStudentHomework(Map<String, Object> params) {
    	return schoolHomeworkDetailMapper.selectStudentHomework(params);
    }
    /**
     * app端 - 学生端 - 我参与的小组详情 - 打卡记录
     * */
    @Override
    public List<Map<String, Object>> selectStudentHomeworkHistory(Map<String, Object> params) {
    	return schoolHomeworkDetailMapper.selectStudentHomeworkHistory(params);
    }
    /**
     * app端 - 学生端 - 我参与的小组详情 - 当日打卡情况
     * */
    @Override
    public List<Map<String, Object>> selectStudentHomeworkToday(Map<String, Object> params) {
    	return schoolHomeworkDetailMapper.selectStudentHomeworkToday(params);
    }
    /**
     * app端 - 学生端 - 我参与的小组详情 - 打卡
     * */
    @Override
    public int studentHomeworkSubmit(SchoolHomeworkDetailDetail detail) {
    	return schoolHomeworkDetailDetailMapper.insertSchoolHomeworkDetail(detail);
    }
    /**
     * app端 - 学生端 - 同学打卡列表
     * */
    @Override
    public List<Map<String, Object>> selectClassStudentHomework(Map<String, Object> params) {
    	return schoolHomeworkDetailMapper.selectClassStudentHomework(params);
    }
    /**
     * app端 - 老师端 - 作业列表
     * */
    public List<Map<String, Object>> selectTeacherHomework(Map<String, Object> params) {
    	return schoolHomeworkDetailMapper.selectTeacherHomework(params);
    }
    /**
     * app端 - 老师端 - 同学打卡列表
     * */
    public List<Map<String, Object>> selectTeacherClassHomework(Map<String, Object> params) {
    	return schoolHomeworkDetailMapper.selectTeacherClassHomework(params);
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
    public int updateSchoolHomeworkDetail(SchoolHomeworkDetailDetail detail)
    {
//        return schoolHomeworkDetailMapper.updateSchoolHomeworkDetail(schoolHomeworkDetail);
        return schoolHomeworkDetailDetailMapper.updateHomework(detail);
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
