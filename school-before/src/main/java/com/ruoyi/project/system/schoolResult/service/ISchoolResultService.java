package com.ruoyi.project.system.schoolResult.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.schoolResult.domain.SchoolResult;

/**
 * 学校成绩Service接口
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
public interface ISchoolResultService 
{
    /**
     * 查询学校成绩
     * 
     * @param id 学校成绩ID
     * @return 学校成绩
     */
    public SchoolResult selectSchoolResultById(Long id);

    /**
     * 查询学校成绩列表
     * 
     * @param schoolResult 学校成绩
     * @return 学校成绩集合
     */
    public List<SchoolResult> selectSchoolResultList(SchoolResult schoolResult);
    /**
     * 学生自己考试的成绩页面列表
     * */
    public List<Map<String, Object>> selectSchoolResultList2(SchoolResult schoolResult);
    /**
     * 成绩管理新增学生页列表
     * */
    public List<Map<String, Object>> stulist(Map<String, Object> params);
    /**
     * 新增学校成绩
     * 
     * @param schoolResult 学校成绩
     * @return 结果
     */
    public int insertSchoolResult(SchoolResult schoolResult);

    /**
     * 修改学校成绩
     * 
     * @param schoolResult 学校成绩
     * @return 结果
     */
    public int updateSchoolResult(SchoolResult schoolResult);

    /**
     * 批量删除学校成绩
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolResultByIds(String ids);

    /**
     * 删除学校成绩信息
     * 
     * @param id 学校成绩ID
     * @return 结果
     */
    public int deleteSchoolResultById(Long id);
}
