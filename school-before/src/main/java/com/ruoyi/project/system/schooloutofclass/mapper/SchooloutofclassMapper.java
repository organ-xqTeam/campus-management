package com.ruoyi.project.system.schooloutofclass.mapper;

import com.ruoyi.project.system.schooloutofclass.domain.Schooloutofclass;
import java.util.List;

/**
 * 课外读物Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public interface SchooloutofclassMapper 
{
    /**
     * 查询课外读物
     * 
     * @param id 课外读物ID
     * @return 课外读物
     */
    public Schooloutofclass selectSchooloutofclassById(Long id);

    /**
     * 查询课外读物列表
     * 
     * @param schooloutofclass 课外读物
     * @return 课外读物集合
     */
    public List<Schooloutofclass> selectSchooloutofclassList(Schooloutofclass schooloutofclass);

    /**
     * 新增课外读物
     * 
     * @param schooloutofclass 课外读物
     * @return 结果
     */
    public int insertSchooloutofclass(Schooloutofclass schooloutofclass);

    /**
     * 修改课外读物
     * 
     * @param schooloutofclass 课外读物
     * @return 结果
     */
    public int updateSchooloutofclass(Schooloutofclass schooloutofclass);

    /**
     * 删除课外读物
     * 
     * @param id 课外读物ID
     * @return 结果
     */
    public int deleteSchooloutofclassById(Long id);

    /**
     * 批量删除课外读物
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchooloutofclassByIds(String[] ids);
}
