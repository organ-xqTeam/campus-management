package com.ruoyi.project.system.schoolclassroom.mapper;

import com.ruoyi.project.system.schoolclassroom.domain.Schoolclassroom;
import java.util.List;

/**
 * 教室管理Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface SchoolclassroomMapper 
{
    /**
     * 查询教室管理
     * 
     * @param id 教室管理ID
     * @return 教室管理
     */
    public Schoolclassroom selectSchoolclassroomById(Long id);

    /**
     * 查询教室管理列表
     * 
     * @param schoolclassroom 教室管理
     * @return 教室管理集合
     */
    public List<Schoolclassroom> selectSchoolclassroomList(Schoolclassroom schoolclassroom);

    /**
     * 新增教室管理
     * 
     * @param schoolclassroom 教室管理
     * @return 结果
     */
    public int insertSchoolclassroom(Schoolclassroom schoolclassroom);

    /**
     * 修改教室管理
     * 
     * @param schoolclassroom 教室管理
     * @return 结果
     */
    public int updateSchoolclassroom(Schoolclassroom schoolclassroom);

    /**
     * 删除教室管理
     * 
     * @param id 教室管理ID
     * @return 结果
     */
    public int deleteSchoolclassroomById(Long id);

    /**
     * 批量删除教室管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolclassroomByIds(String[] ids);
}
