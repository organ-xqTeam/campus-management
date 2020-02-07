package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentstatuslistMapper;
import com.ruoyi.system.domain.Studentstatuslist;
import com.ruoyi.system.service.IStudentstatuslistService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学籍管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-04
 */
@Service
public class StudentstatuslistServiceImpl implements IStudentstatuslistService 
{
    @Autowired
    private StudentstatuslistMapper studentstatuslistMapper;

    /**
     * 查询学籍管理
     * 
     * @param id 学籍管理ID
     * @return 学籍管理
     */
    @Override
    public Studentstatuslist selectStudentstatuslistById(Long id)
    {
        return studentstatuslistMapper.selectStudentstatuslistById(id);
    }

    /**
     * 查询学籍管理列表
     * 
     * @param studentstatuslist 学籍管理
     * @return 学籍管理
     */
    @Override
    public List<Studentstatuslist> selectStudentstatuslistList(Studentstatuslist studentstatuslist)
    {
        return studentstatuslistMapper.selectStudentstatuslistList(studentstatuslist);
    }

    /**
     * 新增学籍管理
     * 
     * @param studentstatuslist 学籍管理
     * @return 结果
     */
    @Override
    public int insertStudentstatuslist(Studentstatuslist studentstatuslist)
    {
        return studentstatuslistMapper.insertStudentstatuslist(studentstatuslist);
    }

    /**
     * 修改学籍管理
     * 
     * @param studentstatuslist 学籍管理
     * @return 结果
     */
    @Override
    public int updateStudentstatuslist(Studentstatuslist studentstatuslist)
    {
        return studentstatuslistMapper.updateStudentstatuslist(studentstatuslist);
    }

    /**
     * 删除学籍管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStudentstatuslistByIds(String ids)
    {
        return studentstatuslistMapper.deleteStudentstatuslistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学籍管理信息
     * 
     * @param id 学籍管理ID
     * @return 结果
     */
    @Override
    public int deleteStudentstatuslistById(Long id)
    {
        return studentstatuslistMapper.deleteStudentstatuslistById(id);
    }

	@Override
	public String importUser(List<Studentstatuslist> userList, boolean updateSupport) {
		int num = 0;
		for (int i = 0; i < userList.size(); i++) {
			num +=  studentstatuslistMapper.insertStudentstatuslist(userList.get(i));
		}
		if (num ==  userList.size()) {
			
			return "成功";
		}
		return "失败";
	}
}
