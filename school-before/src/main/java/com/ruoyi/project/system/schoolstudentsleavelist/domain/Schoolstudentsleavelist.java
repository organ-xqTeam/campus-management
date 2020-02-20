package com.ruoyi.project.system.schoolstudentsleavelist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生请假对象 schoolstudentsleavelist
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public class Schoolstudentsleavelist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentid;

    /** 请假事由 */
    @Excel(name = "请假事由")
    private String reason;

    /** 请假时长 */
    @Excel(name = "请假时长")
    private String leavetime;

    /** 请假日期 */
    @Excel(name = "请假日期")
    private String leavedate;

    /** 删除标记 0:正常;1:删除 */
    private Long delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentid(Long studentid) 
    {
        this.studentid = studentid;
    }

    public Long getStudentid() 
    {
        return studentid;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setLeavetime(String leavetime) 
    {
        this.leavetime = leavetime;
    }

    public String getLeavetime() 
    {
        return leavetime;
    }
    public void setLeavedate(String leavedate) 
    {
        this.leavedate = leavedate;
    }

    public String getLeavedate() 
    {
        return leavedate;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentid", getStudentid())
            .append("reason", getReason())
            .append("leavetime", getLeavetime())
            .append("leavedate", getLeavedate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
