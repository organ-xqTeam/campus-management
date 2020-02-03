package com.ruoyi.project.system.CourseSystem.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程体系对象 course_system
 * 
 * @author ruoyi
 * @date 2020-02-03
 */
public class CourseSystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 体系名称 */
    @Excel(name = "体系名称")
    private String name;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String specialtyName;

    /** 专业id */
    @Excel(name = "专业id")
    private Long specialtyId;

    /** 体系说明 */
    @Excel(name = "体系说明")
    private String content;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 0未删除 1已删除 */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSpecialtyName(String specialtyName) 
    {
        this.specialtyName = specialtyName;
    }

    public String getSpecialtyName() 
    {
        return specialtyName;
    }
    public void setSpecialtyId(Long specialtyId) 
    {
        this.specialtyId = specialtyId;
    }

    public Long getSpecialtyId() 
    {
        return specialtyId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("specialtyName", getSpecialtyName())
            .append("specialtyId", getSpecialtyId())
            .append("content", getContent())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
