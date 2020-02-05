package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 证书管理对象 certificateManagement
 * 
 * @author ruoyi
 * @date 2020-02-05
 */
public class CertificateManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private String studentsId;

    /** 证书照片 */
    @Excel(name = "证书照片")
    private String certificatenum;

    /** 删除标记 0:正常;1:删除 */
    private Long delFlag;

    /** 部门表的别名 */
    @Excel(name = "部门表的别名")
    private String deptalias;

    /** 用户表的别名 */
    @Excel(name = "用户表的别名")
    private String useralias;

    /** 年级id */
    @Excel(name = "年级id")
    private Long gradeId;

    /** 班级id */
    @Excel(name = "班级id")
    private Long classId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentsId(String studentsId) 
    {
        this.studentsId = studentsId;
    }

    public String getStudentsId() 
    {
        return studentsId;
    }
    public void setCertificatenum(String certificatenum) 
    {
        this.certificatenum = certificatenum;
    }

    public String getCertificatenum() 
    {
        return certificatenum;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setDeptalias(String deptalias) 
    {
        this.deptalias = deptalias;
    }

    public String getDeptalias() 
    {
        return deptalias;
    }
    public void setUseralias(String useralias) 
    {
        this.useralias = useralias;
    }

    public String getUseralias() 
    {
        return useralias;
    }
    public void setGradeId(Long gradeId) 
    {
        this.gradeId = gradeId;
    }

    public Long getGradeId() 
    {
        return gradeId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentsId", getStudentsId())
            .append("certificatenum", getCertificatenum())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("deptalias", getDeptalias())
            .append("useralias", getUseralias())
            .append("gradeId", getGradeId())
            .append("classId", getClassId())
            .toString();
    }
}
