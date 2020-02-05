package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CertificateManagementMapper;
import com.ruoyi.system.domain.CertificateManagement;
import com.ruoyi.system.service.ICertificateManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 证书管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-05
 */
@Service
public class CertificateManagementServiceImpl implements ICertificateManagementService 
{
    @Autowired
    private CertificateManagementMapper certificateManagementMapper;

    /**
     * 查询证书管理
     * 
     * @param id 证书管理ID
     * @return 证书管理
     */
    @Override
    public CertificateManagement selectCertificateManagementById(Long id)
    {
        return certificateManagementMapper.selectCertificateManagementById(id);
    }

    /**
     * 查询证书管理列表
     * 
     * @param certificateManagement 证书管理
     * @return 证书管理
     */
    @Override
    public List<CertificateManagement> selectCertificateManagementList(CertificateManagement certificateManagement)
    {
        return certificateManagementMapper.selectCertificateManagementList(certificateManagement);
    }

    /**
     * 新增证书管理
     * 
     * @param certificateManagement 证书管理
     * @return 结果
     */
    @Override
    public int insertCertificateManagement(CertificateManagement certificateManagement)
    {
        return certificateManagementMapper.insertCertificateManagement(certificateManagement);
    }

    /**
     * 修改证书管理
     * 
     * @param certificateManagement 证书管理
     * @return 结果
     */
    @Override
    public int updateCertificateManagement(CertificateManagement certificateManagement)
    {
        return certificateManagementMapper.updateCertificateManagement(certificateManagement);
    }

    /**
     * 删除证书管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCertificateManagementByIds(String ids)
    {
        return certificateManagementMapper.deleteCertificateManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除证书管理信息
     * 
     * @param id 证书管理ID
     * @return 结果
     */
    @Override
    public int deleteCertificateManagementById(Long id)
    {
        return certificateManagementMapper.deleteCertificateManagementById(id);
    }
}
