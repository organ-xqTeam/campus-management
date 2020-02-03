package com.ruoyi.project.system.schoolresearchlearning.service;

import com.ruoyi.project.system.schoolresearchlearning.domain.Schoolresearchlearning;
import java.util.List;

/**
 * 研究学习Service接口
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
public interface ISchoolresearchlearningService 
{
    /**
     * 查询研究学习
     * 
     * @param id 研究学习ID
     * @return 研究学习
     */
    public Schoolresearchlearning selectSchoolresearchlearningById(Long id);

    /**
     * 查询研究学习列表
     * 
     * @param schoolresearchlearning 研究学习
     * @return 研究学习集合
     */
    public List<Schoolresearchlearning> selectSchoolresearchlearningList(Schoolresearchlearning schoolresearchlearning);

    /**
     * 新增研究学习
     * 
     * @param schoolresearchlearning 研究学习
     * @return 结果
     */
    public int insertSchoolresearchlearning(Schoolresearchlearning schoolresearchlearning);

    /**
     * 修改研究学习
     * 
     * @param schoolresearchlearning 研究学习
     * @return 结果
     */
    public int updateSchoolresearchlearning(Schoolresearchlearning schoolresearchlearning);

    /**
     * 批量删除研究学习
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolresearchlearningByIds(String ids);

    /**
     * 删除研究学习信息
     * 
     * @param id 研究学习ID
     * @return 结果
     */
    public int deleteSchoolresearchlearningById(Long id);
}
