package com.ruoyi.project.system.schoolcoursewareinfo.service;

import java.util.List;
import com.ruoyi.project.system.schoolcoursewareinfo.domain.Schoolcoursewareinfo;

/**
 * 课件列Service接口
 * 
 * @author ruoyi
 * @date 2020-03-10
 */
public interface ISchoolcoursewareinfoService 
{
    /**
     * 查询课件列
     * 
     * @param id 课件列ID
     * @return 课件列
     */
    public Schoolcoursewareinfo selectSchoolcoursewareinfoById(Long id);

    /**
     * 查询课件列列表
     * 
     * @param schoolcoursewareinfo 课件列
     * @return 课件列集合
     */
    public List<Schoolcoursewareinfo> selectSchoolcoursewareinfoList(Schoolcoursewareinfo schoolcoursewareinfo);

    /**
     * 新增课件列
     * 
     * @param schoolcoursewareinfo 课件列
     * @return 结果
     */
    public int insertSchoolcoursewareinfo(Schoolcoursewareinfo schoolcoursewareinfo);

    /**
     * 修改课件列
     * 
     * @param schoolcoursewareinfo 课件列
     * @return 结果
     */
    public int updateSchoolcoursewareinfo(Schoolcoursewareinfo schoolcoursewareinfo);

    /**
     * 批量删除课件列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolcoursewareinfoByIds(String ids);

    /**
     * 删除课件列信息
     * 
     * @param id 课件列ID
     * @return 结果
     */
    public int deleteSchoolcoursewareinfoById(Long id);
}
