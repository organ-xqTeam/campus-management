package com.ruoyi.system.service;

import com.ruoyi.system.domain.CertificateManagement;
import java.util.List;

/**
 * 证书管理Service接口
 * 
 * @author ruoyi
 * @date 2020-02-05
 */
public interface ICertificateManagementService 
{
    /**
     * 查询证书管理
     * 
     * @param id 证书管理ID
     * @return 证书管理
     */
    public CertificateManagement selectCertificateManagementById(Long id);

    /**
     * 查询证书管理列表
     * 
     * @param certificateManagement 证书管理
     * @return 证书管理集合
     */
    public List<CertificateManagement> selectCertificateManagementList(CertificateManagement certificateManagement);

    /**
     * 新增证书管理
     * 
     * @param certificateManagement 证书管理
     * @return 结果
     */
    public int insertCertificateManagement(CertificateManagement certificateManagement);

    /**
     * 修改证书管理
     * 
     * @param certificateManagement 证书管理
     * @return 结果
     */
    public int updateCertificateManagement(CertificateManagement certificateManagement);

    /**
     * 批量删除证书管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCertificateManagementByIds(String ids);

    /**
     * 删除证书管理信息
     * 
     * @param id 证书管理ID
     * @return 结果
     */
    public int deleteCertificateManagementById(Long id);
}
