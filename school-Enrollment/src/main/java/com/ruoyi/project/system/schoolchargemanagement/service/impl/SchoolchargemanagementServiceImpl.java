package com.ruoyi.project.system.schoolchargemanagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolchargemanagement.domain.Schoolchargemanagement;
import com.ruoyi.project.system.schoolchargemanagement.mapper.SchoolchargemanagementMapper;
import com.ruoyi.project.system.schoolchargemanagement.service.ISchoolchargemanagementService;

/**
 * 收费管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class SchoolchargemanagementServiceImpl implements ISchoolchargemanagementService 
{
    @Autowired
    private SchoolchargemanagementMapper schoolchargemanagementMapper;

    /**
     * 查询收费管理
     * 
     * @param id 收费管理ID
     * @return 收费管理
     */
    @Override
    public Schoolchargemanagement selectSchoolchargemanagementById(Long id)
    {
        return schoolchargemanagementMapper.selectSchoolchargemanagementById(id);
    }

    /**
     * 查询收费管理列表
     * 
     * @param schoolchargemanagement 收费管理
     * @return 收费管理
     */
    @Override
    public List<Schoolchargemanagement> selectSchoolchargemanagementList(Schoolchargemanagement schoolchargemanagement)
    {
        return schoolchargemanagementMapper.selectSchoolchargemanagementList(schoolchargemanagement);
    }
    @Override
    public List<Map<String, Object>> selectStudentChargeList(Map<String, Object> param) {
    	return schoolchargemanagementMapper.selectStudentChargeList(param);
    }
    /**
     * 新增收费管理
     * 
     * @param schoolchargemanagement 收费管理
     * @return 结果
     */
    @Override
    public int insertSchoolchargemanagement(Schoolchargemanagement schoolchargemanagement)
    {
        return schoolchargemanagementMapper.insertSchoolchargemanagement(schoolchargemanagement);
    }

    /**
     * 修改收费管理
     * 
     * @param schoolchargemanagement 收费管理
     * @return 结果
     */
    @Override
    public int updateSchoolchargemanagement(Schoolchargemanagement schoolchargemanagement)
    {
        return schoolchargemanagementMapper.updateSchoolchargemanagement(schoolchargemanagement);
    }

    /**
     * 删除收费管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolchargemanagementByIds(String ids)
    {
        return schoolchargemanagementMapper.deleteSchoolchargemanagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收费管理信息
     * 
     * @param id 收费管理ID
     * @return 结果
     */
    @Override
    public int deleteSchoolchargemanagementById(Long id)
    {
        return schoolchargemanagementMapper.deleteSchoolchargemanagementById(id);
    }

	@Override
	public int changeStatus(Schoolchargemanagement schoolchargemanagement) {
		
		return schoolchargemanagementMapper.updateSchoolchargemanagement(schoolchargemanagement);
	}
}
