package com.ruoyi.project.system.schoolstudentslist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.mapper.SchoolClassMapper;
import com.ruoyi.project.system.schoolstudenthistorylist.domain.Schoolstudenthistorylist;
import com.ruoyi.project.system.schoolstudenthistorylist.mapper.SchoolstudenthistorylistMapper;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.mapper.SchoolstudentslistMapper;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;

/**
 * 学生列Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class SchoolstudentslistServiceImpl implements ISchoolstudentslistService 
{
	
    @Autowired
    private SchoolClassMapper schoolClassMapper;
    
    @Autowired
    private SchoolstudentslistMapper schoolstudentslistMapper;

    @Autowired
    private SchoolstudenthistorylistMapper schoolstudenthistorylistMapper;
    
    /**
     * 查询学生列
     * 
     * @param id 学生列ID
     * @return 学生列
     */
    @Override
    public Schoolstudentslist selectSchoolstudentslistById(Long id)
    {
        return schoolstudentslistMapper.selectSchoolstudentslistById(id);
    }

    /**
     * 查询学生列列表
     * 
     * @param schoolstudentslist 学生列
     * @return 学生列
     */
    @Override
    public List<Schoolstudentslist> selectSchoolstudentslistList(Schoolstudentslist schoolstudentslist)
    {
        return schoolstudentslistMapper.selectSchoolstudentslistList(schoolstudentslist);
    }
    
    @Override
    @DataScope()
    public List<Schoolstudentslist> selectSchoolstudentslistListnotid(Schoolstudentslist schoolstudentslist)
    {
    	
    	return schoolstudentslistMapper.selectSchoolstudentslistListnotState(schoolstudentslist);
    }
    
    @Override
    public List<Schoolstudentslist> selectSchoolstudentslistListorderbydetails(Schoolstudentslist schoolstudentslist)
    {
    	
    	
    	return schoolstudentslistMapper.selectSchoolstudentslistListorderbydetails(schoolstudentslist);
    }

    /**
     * 新增学生列
     * 
     * @param schoolstudentslist 学生列
     * @return 结果
     */
    @Override
    public int insertSchoolstudentslist(Schoolstudentslist schoolstudentslist)
    {
        return schoolstudentslistMapper.insertSchoolstudentslist(schoolstudentslist);
    }

    /**
     * 修改学生列
     * 
     * @param schoolstudentslist 学生列
     * @return 结果
     */
    @Override
    public int updateSchoolstudentslist(Schoolstudentslist schoolstudentslist)
    {
    	if (schoolstudentslist.getClassId() != null) {
    		Schoolstudenthistorylist history = new Schoolstudenthistorylist();
    		Schoolstudentslist student = schoolstudentslistMapper.selectSchoolstudentslistById(schoolstudentslist.getId());
    		if (student != null) {
    			SchoolClass class1 = schoolClassMapper.selectSchoolClassById(student.getClassId());
        		SchoolClass class2 = schoolClassMapper.selectSchoolClassById(schoolstudentslist.getClassId());
        		schoolstudentslist.setGradeId(class2.getGradelistId());
        		if (class1 != null && class2 != null) {
            		history.setStudentsId(schoolstudentslist.getId());
            		history.setRemark(student.getStudentsName() + "于" + DateUtils.getTime() + "由"+class1.getNameclass()+"调到" + class2.getNameclass());
            		schoolstudenthistorylistMapper.insertSchoolstudenthistorylist(history);
        		}
    		}
    	}
        return schoolstudentslistMapper.updateSchoolstudentslist(schoolstudentslist);
    }

    /**
     * 删除学生列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudentslistByIds(String ids)
    {
        return schoolstudentslistMapper.deleteSchoolstudentslistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生列信息
     * 
     * @param id 学生列ID
     * @return 结果
     */
    @Override
    public int deleteSchoolstudentslistById(Long id)
    {
        return schoolstudentslistMapper.deleteSchoolstudentslistById(id);
    }

	@Override
	public List<Schoolstudentslist> selectSchoolstudentslistListUnMove(Schoolstudentslist schoolstudentslist) {
		// TODO Auto-generated method stub
		return schoolstudentslistMapper.selectSchoolstudentslistListUnMove(schoolstudentslist);
	}
}
