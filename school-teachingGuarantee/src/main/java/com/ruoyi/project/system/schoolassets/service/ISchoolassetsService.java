package com.ruoyi.project.system.schoolassets.service;

import com.ruoyi.project.system.schoolassets.domain.Schoolassets;
import java.util.List;

/**
 * 资产管理Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISchoolassetsService 
{
    /**
     * 查询资产管理
     * 
     * @param id 资产管理ID
     * @return 资产管理
     */
    public Schoolassets selectSchoolassetsById(Long id);

    /**
     * 查询资产管理列表
     * 
     * @param schoolassets 资产管理
     * @return 资产管理集合
     */
    public List<Schoolassets> selectSchoolassetsList(Schoolassets schoolassets);

    /**
     * 新增资产管理
     * 
     * @param schoolassets 资产管理
     * @return 结果
     */
    public int insertSchoolassets(Schoolassets schoolassets);

    /**
     * 修改资产管理
     * 
     * @param schoolassets 资产管理
     * @return 结果
     */
    public int updateSchoolassets(Schoolassets schoolassets);

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSchoolassetsByIds(String ids);

    /**
     * 删除资产管理信息
     * 
     * @param id 资产管理ID
     * @return 结果
     */
    public int deleteSchoolassetsById(Long id);
}
