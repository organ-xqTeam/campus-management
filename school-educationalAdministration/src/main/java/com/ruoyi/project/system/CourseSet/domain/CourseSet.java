package com.ruoyi.project.system.CourseSet.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 课程设置管理对象 course_set
 * 
 * @author ruoyi
 * @date 2020-02-04
 */
public class CourseSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 专业名 */
    @Excel(name = "专业名")
    private String specialtyName;

    /** 专业id */
    @Excel(name = "专业id")
    private Long specialtyId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long coursemanagementId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String coursemanagementName;

    /** 备注说明 */
    @Excel(name = "备注说明")
    private String content;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 是否删除 0未删除 1已删除 */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setCoursemanagementId(Long coursemanagementId) 
    {
        this.coursemanagementId = coursemanagementId;
    }

    public Long getCoursemanagementId() 
    {
        return coursemanagementId;
    }
    public void setCoursemanagementName(String coursemanagementName) 
    {
        this.coursemanagementName = coursemanagementName;
    }

    public String getCoursemanagementName() 
    {
        return coursemanagementName;
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
            .append("specialtyName", getSpecialtyName())
            .append("specialtyId", getSpecialtyId())
            .append("coursemanagementId", getCoursemanagementId())
            .append("coursemanagementName", getCoursemanagementName())
            .append("content", getContent())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
