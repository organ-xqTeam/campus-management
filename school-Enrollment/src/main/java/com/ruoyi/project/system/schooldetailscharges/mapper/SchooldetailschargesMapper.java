package com.ruoyi.project.system.schooldetailscharges.mapper;

import com.ruoyi.project.system.schooldetailscharges.domain.Schooldetailscharges;
import java.util.List;

/**
 * 收费明细Mapper接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface SchooldetailschargesMapper 
{
    /**
     * 查询收费明细
     * 
     * @param id 收费明细ID
     * @return 收费明细
     */
    public Schooldetailscharges selectSchooldetailschargesById(Long id);

    /**
     * 查询收费明细列表
     * 
     * @param schooldetailscharges 收费明细
     * @return 收费明细集合
     */
    public List<Schooldetailscharges> selectSchooldetailschargesList(Schooldetailscharges schooldetailscharges);

    /**
     * 新增收费明细
     * 
     * @param schooldetailscharges 收费明细
     * @return 结果
     */
    public int insertSchooldetailscharges(Schooldetailscharges schooldetailscharges);

    /**
     * 修改收费明细
     * 
     * @param schooldetailscharges 收费明细
     * @return 结果
     */
    public int updateSchooldetailscharges(Schooldetailscharges schooldetailscharges);

    /**
     * 删除收费明细
     * 
     * @param id 收费明细ID
     * @return 结果
     */
    public int deleteSchooldetailschargesById(Long id);

    /**
     * 批量删除收费明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchooldetailschargesByIds(String[] ids);
}
