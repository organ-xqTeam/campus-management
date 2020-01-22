package com.ruoyi.project.system.classcurriculum.service;

import com.ruoyi.project.system.classcurriculum.domain.Classcurriculum;
import java.util.List;

/**
 * 课Service接口
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
public interface IClasscurriculumService 
{
    /**
     * 查询课
     * 
     * @param id 课ID
     * @return 课
     */
    public Classcurriculum selectClasscurriculumById(Long id);

    /**
     * 查询课列表
     * 
     * @param classcurriculum 课
     * @return 课集合
     */
    public List<Classcurriculum> selectClasscurriculumList(Classcurriculum classcurriculum);

    /**
     * 新增课
     * 
     * @param classcurriculum 课
     * @return 结果
     */
    public int insertClasscurriculum(Classcurriculum classcurriculum);

    /**
     * 修改课
     * 
     * @param classcurriculum 课
     * @return 结果
     */
    public int updateClasscurriculum(Classcurriculum classcurriculum);

    /**
     * 批量删除课
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClasscurriculumByIds(String ids);

    /**
     * 删除课信息
     * 
     * @param id 课ID
     * @return 结果
     */
    public int deleteClasscurriculumById(Long id);
}
