package com.ruoyi.project.system.schoolResultDetail.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.schoolResultDetail.domain.SchoolResultDetail;
import com.ruoyi.project.system.schoolResultDetail.mapper.SchoolResultDetailMapper;
import com.ruoyi.project.system.schoolResultDetail.service.ISchoolResultDetailService;

/**
 * 学校成绩详情表Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-03
 */
@Service
public class SchoolResultDetailServiceImpl implements ISchoolResultDetailService 
{
    @Autowired
    private SchoolResultDetailMapper schoolResultDetailMapper;

    /**
     * 查询学校成绩详情表
     * 
     * @param id 学校成绩详情表ID
     * @return 学校成绩详情表
     */
    @Override
    public SchoolResultDetail selectSchoolResultDetailById(Long id)
    {
        return schoolResultDetailMapper.selectSchoolResultDetailById(id);
    }

    /**
     * 查询学校成绩详情表列表
     * 
     * @param schoolResultDetail 学校成绩详情表
     * @return 学校成绩详情表
     */
    @Override
    public List<SchoolResultDetail> selectSchoolResultDetailList(SchoolResultDetail schoolResultDetail)
    {
        return schoolResultDetailMapper.selectSchoolResultDetailList(schoolResultDetail);
    }

    /**
     * 新增学校成绩详情表
     * 
     * @param schoolResultDetail 学校成绩详情表
     * @return 结果
     */
    @Override
    public int insertSchoolResultDetail(SchoolResultDetail schoolResultDetail)
    {
        return schoolResultDetailMapper.insertSchoolResultDetail(schoolResultDetail);
    }

    /**
     * 修改学校成绩详情表
     * 
     * @param schoolResultDetail 学校成绩详情表
     * @return 结果
     */
    @Override
    public int updateSchoolResultDetail(SchoolResultDetail schoolResultDetail)
    {
        return schoolResultDetailMapper.updateSchoolResultDetail(schoolResultDetail);
    }

    /**
     * 删除学校成绩详情表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolResultDetailByIds(String ids)
    {
        return schoolResultDetailMapper.deleteSchoolResultDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学校成绩详情表信息
     * 
     * @param id 学校成绩详情表ID
     * @return 结果
     */
    @Override
    public int deleteSchoolResultDetailById(Long id)
    {
        return schoolResultDetailMapper.deleteSchoolResultDetailById(id);
    }

    ////通过 resultId 查找SchoolResultDetail和Students关联得信息;
	@Override
	public List<Map<String, Object>> selectSchoolResultDetailStudentsListByResultId(
			Map<String, Object> parmMap) {
		// TODO Auto-generated method stub
		return schoolResultDetailMapper.selectSchoolResultDetailStudentsListByResultId(parmMap);
	}
	@Override
	public List<Map<String, Object>> selectstudentresultlist(Map<String, Object> parmMap) {
		return schoolResultDetailMapper.selectstudentresultlist(parmMap);
	}
	@Override
	public List<Map<String, Object>> selectlurulist(Map<String, Object> parmMap) {
		return schoolResultDetailMapper.lurulist(parmMap);
	}
	
}
