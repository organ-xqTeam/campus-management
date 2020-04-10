package com.ruoyi.project.system.schoolHomeworkDetail.mapper;

import com.ruoyi.project.system.schoolHomeworkDetail.domain.SchoolHomeworkDetail;
import java.util.List;
import java.util.Map;

/**
 * 学校作业表Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface SchoolHomeworkDetailMapper 
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
     * app端 - 学生端 - 作业列表
     * */
    public List<Map<String, Object>> selectStudentHomework(Map<String, Object> params);
    /**
     * app端 - 学生端 - 我参与的小组详情 - 打卡记录
     * */
    public List<Map<String, Object>> selectStudentHomeworkHistory(Map<String, Object> params);
    /**
     * app端 - 学生端 - 我参与的小组详情 - 当日打卡情况
     * */
    public List<Map<String, Object>> selectStudentHomeworkToday(Map<String, Object> params);
    /**
     * app端 - 学生端 - 同学打卡列表
     * */
    public List<Map<String, Object>> selectClassStudentHomework(Map<String, Object> params);
    /**
     * app端 - 老师端 - 作业列表
     * */
    public List<Map<String, Object>> selectTeacherHomework(Map<String, Object> params);
    /**
     * app端 - 老师端 - 同学打卡列表
     * */
    public List<Map<String, Object>> selectTeacherClassHomework(Map<String, Object> params);
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
     * 删除学校作业表
     * 
     * @param id 学校作业表ID
     * @return 结果
     */
    public int deleteSchoolHomeworkDetailById(Long id);

    /**
     * 批量删除学校作业表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolHomeworkDetailByIds(String[] ids);
    /**通过HomeworkId 查找HomeworkDetail关联得学生信息*/
	public List<Map<String, Object>> selectSchoolHomeworkDetailStudentsListByHomeworkId(Map<String, Object> parmMap);
}
