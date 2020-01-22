package com.ruoyi.project.system.ClasscurriculumDetail.service;

import com.ruoyi.project.system.ClasscurriculumDetail.domain.ClasscurriculumDetail;
import java.util.List;

/**
 * 排课详情表Service接口
 * 
 * @author ruoyi
 * @date 2019-11-22
 */
public interface IClasscurriculumDetailService 
{
    /**
     * 查询排课详情表
     * 
     * @param id 排课详情表ID
     * @return 排课详情表
     */
    public ClasscurriculumDetail selectClasscurriculumDetailById(Long id);

    /**
     * 查询排课详情表列表
     * 
     * @param classcurriculumDetail 排课详情表
     * @return 排课详情表集合
     */
    public List<ClasscurriculumDetail> selectClasscurriculumDetailList(ClasscurriculumDetail classcurriculumDetail);

    /**
     * 新增排课详情表
     * 
     * @param classcurriculumDetail 排课详情表
     * @return 结果
     */
    public int insertClasscurriculumDetail(ClasscurriculumDetail classcurriculumDetail);

    /**
     * 修改排课详情表
     * 
     * @param classcurriculumDetail 排课详情表
     * @return 结果
     */
    public int updateClasscurriculumDetail(ClasscurriculumDetail classcurriculumDetail);

    /**
     * 批量删除排课详情表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClasscurriculumDetailByIds(String ids);

    /**
     * 删除排课详情表信息
     * 
     * @param id 排课详情表ID
     * @return 结果
     */
    public int deleteClasscurriculumDetailById(Long id);
}
