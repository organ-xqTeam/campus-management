package com.ruoyi.project.system.schoolpractice.mapper;

import com.ruoyi.project.system.schoolpractice.domain.Schoolpractice;
import java.util.List;

/**
 * 综合实践Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
public interface SchoolpracticeMapper 
{
    /**
     * 查询综合实践
     * 
     * @param id 综合实践ID
     * @return 综合实践
     */
    public Schoolpractice selectSchoolpracticeById(Long id);

    /**
     * 查询综合实践列表
     * 
     * @param schoolpractice 综合实践
     * @return 综合实践集合
     */
    public List<Schoolpractice> selectSchoolpracticeList(Schoolpractice schoolpractice);

    /**
     * 新增综合实践
     * 
     * @param schoolpractice 综合实践
     * @return 结果
     */
    public int insertSchoolpractice(Schoolpractice schoolpractice);

    /**
     * 修改综合实践
     * 
     * @param schoolpractice 综合实践
     * @return 结果
     */
    public int updateSchoolpractice(Schoolpractice schoolpractice);

    /**
     * 删除综合实践
     * 
     * @param id 综合实践ID
     * @return 结果
     */
    public int deleteSchoolpracticeById(Long id);

    /**
     * 批量删除综合实践
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolpracticeByIds(String[] ids);
}
