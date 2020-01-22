package com.ruoyi.project.system.schoolDormStudents.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍学生对象 school_dorm_students
 * 
 * @author ruoyi
 * @date 2019-11-15
 */
public class SchoolDormStudents extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentsId;

    /** 0未弃用,1弃用 */
    @Excel(name = "0未弃用,1弃用")
    private String isdisuse;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedate;

    /** 住宿id */
    @Excel(name = "住宿id")
    private Long dormId;

    /** 住宿日期 */
    @Excel(name = "住宿日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date moveDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentsId(Long studentsId) 
    {
        this.studentsId = studentsId;
    }

    public Long getStudentsId() 
    {
        return studentsId;
    }
    public void setIsdisuse(String isdisuse) 
    {
        this.isdisuse = isdisuse;
    }

    public String getIsdisuse() 
    {
        return isdisuse;
    }
    public void setCreatedate(Date createdate) 
    {
        this.createdate = createdate;
    }

    public Date getCreatedate() 
    {
        return createdate;
    }
    public void setUpdatedate(Date updatedate) 
    {
        this.updatedate = updatedate;
    }

    public Date getUpdatedate() 
    {
        return updatedate;
    }
    public void setDormId(Long dormId) 
    {
        this.dormId = dormId;
    }

    public Long getDormId() 
    {
        return dormId;
    }
    public void setMoveDate(Date moveDate) 
    {
        this.moveDate = moveDate;
    }

    public Date getMoveDate() 
    {
        return moveDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentsId", getStudentsId())
            .append("isdisuse", getIsdisuse())
            .append("createdate", getCreatedate())
            .append("updatedate", getUpdatedate())
            .append("dormId", getDormId())
            .append("moveDate", getMoveDate())
            .toString();
    }
}
