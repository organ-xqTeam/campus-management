package com.ruoyi.project.system.classcurriculum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.classcurriculum.mapper.ClasscurriculumMapper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.classcurriculum.domain.Classcurriculum;
import com.ruoyi.project.system.classcurriculum.service.IClasscurriculumService;

/**
 * 课Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
@Service
public class ClasscurriculumServiceImpl implements IClasscurriculumService 
{
    @Autowired
    private ClasscurriculumMapper classcurriculumMapper;

    /**
     * 查询课
     * 
     * @param id 课ID
     * @return 课
     */
    @Override
    public Classcurriculum selectClasscurriculumById(Long id)
    {
        return classcurriculumMapper.selectClasscurriculumById(id);
    }

    /**
     * 查询课列表
     * 
     * @param classcurriculum 课
     * @return 课
     */
    @Override
    public List<Classcurriculum> selectClasscurriculumList(Classcurriculum classcurriculum)
    {
        return classcurriculumMapper.selectClasscurriculumList(classcurriculum);
    }

    /**
     * 新增课
     * 
     * @param classcurriculum 课
     * @return 结果
     */
    @Override
    public int insertClasscurriculum(Classcurriculum classcurriculum)
    {
        return classcurriculumMapper.insertClasscurriculum(classcurriculum);
    }

    /**
     * 修改课
     * 
     * @param classcurriculum 课
     * @return 结果
     */
    @Override
    public int updateClasscurriculum(Classcurriculum classcurriculum)
    {
        return classcurriculumMapper.updateClasscurriculum(classcurriculum);
    }

    /**
     * 删除课对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClasscurriculumByIds(String ids)
    {
        return classcurriculumMapper.deleteClasscurriculumByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课信息
     * 
     * @param id 课ID
     * @return 结果
     */
    @Override
    public int deleteClasscurriculumById(Long id)
    {
        return classcurriculumMapper.deleteClasscurriculumById(id);
    }
}
