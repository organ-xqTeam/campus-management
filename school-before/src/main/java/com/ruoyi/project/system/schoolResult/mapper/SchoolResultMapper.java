package com.ruoyi.project.system.schoolResult.mapper;

import com.ruoyi.project.system.schoolResult.domain.SchoolResult;
import java.util.List;

/**
 * 学校成绩Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
public interface SchoolResultMapper 
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
     * 删除学校成绩
     * 
     * @param id 学校成绩ID
     * @return 结果
     */
    public int deleteSchoolResultById(Long id);

    /**
     * 批量删除学校成绩
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolResultByIds(String[] ids);
}
