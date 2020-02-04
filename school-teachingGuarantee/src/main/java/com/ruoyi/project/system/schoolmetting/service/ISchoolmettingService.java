package com.ruoyi.project.system.schoolmetting.service;

import com.ruoyi.project.system.schoolmetting.domain.Schoolmetting;
import java.util.List;

/**
 * 会议管理Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISchoolmettingService 
{
    /**
     * 查询会议管理
     * 
     * @param id 会议管理ID
     * @return 会议管理
     */
    public Schoolmetting selectSchoolmettingById(Long id);

    /**
     * 查询会议管理列表
     * 
     * @param schoolmetting 会议管理
     * @return 会议管理集合
     */
    public List<Schoolmetting> selectSchoolmettingList(Schoolmetting schoolmetting);

    /**
     * 新增会议管理
     * 
     * @param schoolmetting 会议管理
     * @return 结果
     */
    public int insertSchoolmetting(Schoolmetting schoolmetting);

    /**
     * 修改会议管理
     * 
     * @param schoolmetting 会议管理
     * @return 结果
     */
    public int updateSchoolmetting(Schoolmetting schoolmetting);

    /**
     * 批量删除会议管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolmettingByIds(String ids);

    /**
     * 删除会议管理信息
     * 
     * @param id 会议管理ID
     * @return 结果
     */
    public int deleteSchoolmettingById(Long id);
}
