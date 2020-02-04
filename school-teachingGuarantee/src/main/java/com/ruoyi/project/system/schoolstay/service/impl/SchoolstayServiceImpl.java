package com.ruoyi.project.system.schoolstay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.schooldorm.domain.Schooldorm;
import com.ruoyi.project.system.schoolstay.mapper.SchoolstayMapper;
import com.ruoyi.project.system.schoolstay.service.ISchoolstayService;

/**
 * 宿舍Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-14
 */
@Service
public class SchoolstayServiceImpl implements ISchoolstayService 
{
	@Autowired
	private  SchoolstayMapper schoolstayMapper;
 	@Override
	public Schooldorm selectSchooldormById(Long id) {
		// TODO Auto-generated method stub
		return schoolstayMapper.selectSchooldormById(id);
	}

	@Override
	public List<Schooldorm> selectSchooldormList(Schooldorm schooldorm) {
		// TODO Auto-generated method stub
		return schoolstayMapper.selectSchooldormList(schooldorm);
	}

	@Override
	public int insertSchooldorm(Schooldorm schooldorm) {
		// TODO Auto-generated method stub
		return schoolstayMapper.insertSchooldorm(schooldorm);
	}

	@Override
	public int updateSchooldorm(Schooldorm schooldorm) {
		// TODO Auto-generated method stub
		return schoolstayMapper.updateSchooldorm(schooldorm);
	}

	@Override
	public int deleteSchooldormByIds(String ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSchooldormById(Long id) {
		// TODO Auto-generated method stub
		return schoolstayMapper.deleteSchooldormById(id);
	}
    
}
