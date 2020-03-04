package com.ruoyi.project.system.schoolresearchlearning.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 研究学习对象 schoolresearchlearning
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
public class Schoolresearchlearning extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String project;

    /** 组织部门 */
    @Excel(name = "组织部门")
    private String department;

    /** 负责人 */
    @Excel(name = "负责人")
    private String charge;

    /** 举办时间 */
    @Excel(name = "举办时间")
    private String starttime;

    /** 费用统计 */
    @Excel(name = "费用统计")
    private String feecount;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createdate;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String deleteFlag;
    
	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProject(String project) 
    {
        this.project = project;
    }

    public String getProject() 
    {
        return project;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setCharge(String charge) 
    {
        this.charge = charge;
    }

    public String getCharge() 
    {
        return charge;
    }
    public void setStarttime(String starttime) 
    {
        this.starttime = starttime;
    }

    public String getStarttime() 
    {
        return starttime;
    }
    public void setFeecount(String feecount) 
    {
        this.feecount = feecount;
    }

    public String getFeecount() 
    {
        return feecount;
    }
    public void setCreatedate(String createdate) 
    {
        this.createdate = createdate;
    }

    public String getCreatedate() 
    {
        return createdate;
    }
    public void setDeleteFlag(String deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() 
    {
        return deleteFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("project", getProject())
            .append("department", getDepartment())
            .append("charge", getCharge())
            .append("starttime", getStarttime())
            .append("feecount", getFeecount())
            .append("createdate", getCreatedate())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
