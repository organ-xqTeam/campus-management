package com.ruoyi.project.system.schoolDormStudents.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolDormStudents.domain.SchoolDormStudents;
import com.ruoyi.project.system.schoolDormStudents.mapper.SchoolDormStudentsMapper;
import com.ruoyi.project.system.schoolDormStudents.service.ISchoolDormStudentsService;

/**
 * 宿舍学生Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-15
 */
@Service
public class SchoolDormStudentsServiceImpl implements ISchoolDormStudentsService 
{
    @Autowired
    private SchoolDormStudentsMapper schoolDormStudentsMapper;

    /**
     * 查询宿舍学生
     * 
     * @param id 宿舍学生ID
     * @return 宿舍学生
     */
    @Override
    public SchoolDormStudents selectSchoolDormStudentsById(Long id)
    {
        return schoolDormStudentsMapper.selectSchoolDormStudentsById(id);
    }

    /**
     * 查询宿舍学生列表
     * 
     * @param schoolDormStudents 宿舍学生
     * @return 宿舍学生
     */
    @Override
    public List<SchoolDormStudents> selectSchoolDormStudentsList(SchoolDormStudents schoolDormStudents)
    {
        return schoolDormStudentsMapper.selectSchoolDormStudentsList(schoolDormStudents);
    }

    /**
     * 新增宿舍学生
     * 
     * @param schoolDormStudents 宿舍学生
     * @return 结果
     */
    @Override
    public int insertSchoolDormStudents(SchoolDormStudents schoolDormStudents)
    {
        return schoolDormStudentsMapper.insertSchoolDormStudents(schoolDormStudents);
    }

    /**
     * 修改宿舍学生
     * 
     * @param schoolDormStudents 宿舍学生
     * @return 结果
     */
    @Override
    public int updateSchoolDormStudents(SchoolDormStudents schoolDormStudents)
    {
        return schoolDormStudentsMapper.updateSchoolDormStudents(schoolDormStudents);
    }

    /**
     * 删除宿舍学生对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolDormStudentsByIds(String ids)
    {
        return schoolDormStudentsMapper.deleteSchoolDormStudentsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除宿舍学生信息
     * 
     * @param id 宿舍学生ID
     * @return 结果
     */
    @Override
    public int deleteSchoolDormStudentsById(Long id)
    {
        return schoolDormStudentsMapper.deleteSchoolDormStudentsById(id);
    }
    /**更新为弃用*/
	@Override
	public int updateSchoolDormStudentsIsdisuseByDormId(SchoolDormStudents schoolDormStudents) {
		// TODO Auto-generated method stub
		 return schoolDormStudentsMapper.updateSchoolDormStudentsIsdisuseByDormId(schoolDormStudents);
	}
}
