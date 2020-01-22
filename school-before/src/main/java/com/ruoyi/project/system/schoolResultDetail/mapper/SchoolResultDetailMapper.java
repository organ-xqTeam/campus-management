package com.ruoyi.project.system.schoolResultDetail.mapper;

import com.ruoyi.project.system.schoolResultDetail.domain.SchoolResultDetail;
import java.util.List;
import java.util.Map;

/**
 * 学校成绩详情表Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-03
 */
public interface SchoolResultDetailMapper 
{
    /**
     * 查询学校成绩详情表
     * 
     * @param id 学校成绩详情表ID
     * @return 学校成绩详情表
     */
    public SchoolResultDetail selectSchoolResultDetailById(Long id);

    /**
     * 查询学校成绩详情表列表
     * 
     * @param schoolResultDetail 学校成绩详情表
     * @return 学校成绩详情表集合
     */
    public List<SchoolResultDetail> selectSchoolResultDetailList(SchoolResultDetail schoolResultDetail);

    /**
     * 新增学校成绩详情表
     * 
     * @param schoolResultDetail 学校成绩详情表
     * @return 结果
     */
    public int insertSchoolResultDetail(SchoolResultDetail schoolResultDetail);

    /**
     * 修改学校成绩详情表
     * 
     * @param schoolResultDetail 学校成绩详情表
     * @return 结果
     */
    public int updateSchoolResultDetail(SchoolResultDetail schoolResultDetail);

    /**
     * 删除学校成绩详情表
     * 
     * @param id 学校成绩详情表ID
     * @return 结果
     */
    public int deleteSchoolResultDetailById(Long id);

    /**
     * 批量删除学校成绩详情表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolResultDetailByIds(String[] ids);
    /**通过 resultId 查找SchoolResultDetail和Students关联得信息;*/
	public List<Map<String, Object>> selectSchoolResultDetailStudentsListByResultId(
			Map<String, Object> parmMap);
	
	public List<Map<String, Object>> selectstudentresultlist(Map<String, Object> parmMap);
	
}
