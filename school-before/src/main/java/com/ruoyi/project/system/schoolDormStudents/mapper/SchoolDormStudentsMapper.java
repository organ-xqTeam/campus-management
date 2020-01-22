package com.ruoyi.project.system.schoolDormStudents.mapper;

import com.ruoyi.project.system.schoolDormStudents.domain.SchoolDormStudents;
import java.util.List;

/**
 * 宿舍学生Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-15
 */
public interface SchoolDormStudentsMapper 
{
    /**
     * 查询宿舍学生
     * 
     * @param id 宿舍学生ID
     * @return 宿舍学生
     */
    public SchoolDormStudents selectSchoolDormStudentsById(Long id);

    /**
     * 查询宿舍学生列表
     * 
     * @param schoolDormStudents 宿舍学生
     * @return 宿舍学生集合
     */
    public List<SchoolDormStudents> selectSchoolDormStudentsList(SchoolDormStudents schoolDormStudents);

    /**
     * 新增宿舍学生
     * 
     * @param schoolDormStudents 宿舍学生
     * @return 结果
     */
    public int insertSchoolDormStudents(SchoolDormStudents schoolDormStudents);

    /**
     * 修改宿舍学生
     * 
     * @param schoolDormStudents 宿舍学生
     * @return 结果
     */
    public int updateSchoolDormStudents(SchoolDormStudents schoolDormStudents);

    /**
     * 删除宿舍学生
     * 
     * @param id 宿舍学生ID
     * @return 结果
     */
    public int deleteSchoolDormStudentsById(Long id);

    /**
     * 批量删除宿舍学生
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolDormStudentsByIds(String[] ids);
    /**更新为弃用*/
	public int updateSchoolDormStudentsIsdisuseByDormId(SchoolDormStudents schoolDormStudents);
}
