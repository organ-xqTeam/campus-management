package com.ruoyi.project.system.schoolHomeworkDetail.service;

import com.ruoyi.project.system.schoolHomeworkDetail.domain.SchoolHomeworkDetail;
import java.util.List;
import java.util.Map;

/**
 * 学校作业表Service接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface ISchoolHomeworkDetailService 
{
    /**
     * 查询学校作业表
     * 
     * @param id 学校作业表ID
     * @return 学校作业表
     */
    public SchoolHomeworkDetail selectSchoolHomeworkDetailById(Long id);

    /**
     * 查询学校作业表列表
     * 
     * @param schoolHomeworkDetail 学校作业表
     * @return 学校作业表集合
     */
    public List<SchoolHomeworkDetail> selectSchoolHomeworkDetailList(SchoolHomeworkDetail schoolHomeworkDetail);

    /**
     * 新增学校作业表
     * 
     * @param schoolHomeworkDetail 学校作业表
     * @return 结果
     */
    public int insertSchoolHomeworkDetail(SchoolHomeworkDetail schoolHomeworkDetail);

    /**
     * 修改学校作业表
     * 
     * @param schoolHomeworkDetail 学校作业表
     * @return 结果
     */
    public int updateSchoolHomeworkDetail(SchoolHomeworkDetail schoolHomeworkDetail);

    /**
     * 批量删除学校作业表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolHomeworkDetailByIds(String ids);

    /**
     * 删除学校作业表信息
     * 
     * @param id 学校作业表ID
     * @return 结果
     */
    public int deleteSchoolHomeworkDetailById(Long id);
    /**通过HomeworkId 查找HomeworkDetail关联得学生信息*/
	public List<Map<String, Object>> selectSchoolHomeworkDetailStudentsListByHomeworkId(Map<String, Object> parmMap);
}
