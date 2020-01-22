package com.ruoyi.project.system.schoolClass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.schoolClass.domain.SchoolClass;
import com.ruoyi.project.system.schoolClass.mapper.SchoolClassMapper;
import com.ruoyi.project.system.schoolClass.service.ISchoolClassService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.mapper.SchoolstudentslistMapper;

/**
 * 学校班级表Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
@Service
public class SchoolClassServiceImpl implements ISchoolClassService 
{
    @Autowired
    private SchoolClassMapper schoolClassMapper;
    
    @Autowired
    private SchoolstudentslistMapper schoolstudentslistMapper;

    /**
     * 查询学校班级表
     * 
     * @param id 学校班级表ID
     * @return 学校班级表
     */
    @Override
    public SchoolClass selectSchoolClassById(Long id)
    {
        return schoolClassMapper.selectSchoolClassById(id);
    }

    /**
     * 查询学校班级表列表
     * 
     * @param schoolClass 学校班级表
     * @return 学校班级表
     */
    @Override
    public List<SchoolClass> selectSchoolClassList(SchoolClass schoolClass)
    {
        return schoolClassMapper.selectSchoolClassList(schoolClass);
    }

    /**
     * 新增学校班级表
     * 
     * @param schoolClass 学校班级表
     * @return 结果
     */
    @Override
    public int insertSchoolClass(SchoolClass schoolClass)
    {
        return schoolClassMapper.insertSchoolClass(schoolClass);
    }

    /**
     * 修改学校班级表
     * 
     * @param schoolClass 学校班级表
     * @return 结果
     */
    @Override
    public int updateSchoolClass(SchoolClass schoolClass)
    {
        return schoolClassMapper.updateSchoolClass(schoolClass);
    }

    /**
     * 删除学校班级表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolClassByIds(String ids)
    {
        return schoolClassMapper.deleteSchoolClassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学校班级表信息
     * 
     * @param id 学校班级表ID
     * @return 结果
     */
    @Override
    public int deleteSchoolClassById(Long id)
    {
        return schoolClassMapper.deleteSchoolClassById(id);
    }
    
    @Override
    public void doScheduling(Long gradeid, int num) {
    	Schoolstudentslist schoolstudentslist = new Schoolstudentslist();
    	schoolstudentslist.setGradeId(gradeid);
    	List<Schoolstudentslist> studentlist = schoolstudentslistMapper.selectSchoolstudentslistList(schoolstudentslist);
    	List<SchoolClass> classList = new ArrayList<SchoolClass>();
    	int studentnum = studentlist.size();
    	int classnum = studentnum / num;		//班级数量
    	for(int i=1; i<=classnum; i++) {
    		SchoolClass schoolclass = new SchoolClass();
        	schoolclass.setState("1");
    		schoolclass.setNum(i+"");
    		schoolclass.setNameclass(i+"班");
        	schoolclass.setGradelistId(gradeid);
        	schoolclass.setCreateDate(DateUtils.getTime());
        	schoolClassMapper.insertSchoolClass(schoolclass);
        	classList.add(schoolclass);
    	}
    	int flag = 0;
		for (int i=0; i<studentnum; i++) {
			studentlist.get(i).setClassId(classList.get(flag).getId());
			schoolstudentslistMapper.updateSchoolstudentslist(studentlist.get(i));
			flag ++;
			if (flag >= classnum) {
				flag = 0;
			}
		}
    }
    
}
