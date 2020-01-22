package com.ruoyi.project.system.ClasscurriculumDetail.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.ClasscurriculumDetail.mapper.ClasscurriculumDetailMapper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.system.ClasscurriculumDetail.domain.ClasscurriculumDetail;
import com.ruoyi.project.system.ClasscurriculumDetail.service.IClasscurriculumDetailService;

/**
 * 排课详情表Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-22
 */
@Service
public class ClasscurriculumDetailServiceImpl implements IClasscurriculumDetailService 
{
    @Autowired
    private ClasscurriculumDetailMapper classcurriculumDetailMapper;

    /**
     * 查询排课详情表
     * 
     * @param id 排课详情表ID
     * @return 排课详情表
     */
    @Override
    public ClasscurriculumDetail selectClasscurriculumDetailById(Long id)
    {
        return classcurriculumDetailMapper.selectClasscurriculumDetailById(id);
    }

    /**
     * 查询排课详情表列表
     * 
     * @param classcurriculumDetail 排课详情表
     * @return 排课详情表
     */
    @Override
    public List<ClasscurriculumDetail> selectClasscurriculumDetailList(ClasscurriculumDetail classcurriculumDetail)
    {
        return classcurriculumDetailMapper.selectClasscurriculumDetailList(classcurriculumDetail);
    }

    /**
     * 新增排课详情表
     * 
     * @param classcurriculumDetail 排课详情表
     * @return 结果
     */
    @Override
    public int insertClasscurriculumDetail(ClasscurriculumDetail classcurriculumDetail)
    {
        return classcurriculumDetailMapper.insertClasscurriculumDetail(classcurriculumDetail);
    }

    /**
     * 修改排课详情表
     * 
     * @param classcurriculumDetail 排课详情表
     * @return 结果
     */
    @Override
    public int updateClasscurriculumDetail(ClasscurriculumDetail classcurriculumDetail)
    {
        return classcurriculumDetailMapper.updateClasscurriculumDetail(classcurriculumDetail);
    }

    /**
     * 删除排课详情表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClasscurriculumDetailByIds(String ids)
    {
        return classcurriculumDetailMapper.deleteClasscurriculumDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除排课详情表信息
     * 
     * @param id 排课详情表ID
     * @return 结果
     */
    @Override
    public int deleteClasscurriculumDetailById(Long id)
    {
        return classcurriculumDetailMapper.deleteClasscurriculumDetailById(id);
    }
}
