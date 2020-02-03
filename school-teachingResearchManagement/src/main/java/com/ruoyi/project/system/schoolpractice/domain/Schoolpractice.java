package com.ruoyi.project.system.schoolpractice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 综合实践对象 schoolpractice
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
public class Schoolpractice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String project;

    /** 活动人数 */
    @Excel(name = "活动人数")
    private String num;

    /** 费用统计 */
    @Excel(name = "费用统计")
    private String feecount;

    /** 举办时间 */
    @Excel(name = "举办时间")
    private String starttime;

    /** 举办地点 */
    @Excel(name = "举办地点")
    private String startplace;

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
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setFeecount(String feecount) 
    {
        this.feecount = feecount;
    }

    public String getFeecount() 
    {
        return feecount;
    }
    public void setStarttime(String starttime) 
    {
        this.starttime = starttime;
    }

    public String getStarttime() 
    {
        return starttime;
    }
    public void setStartplace(String startplace) 
    {
        this.startplace = startplace;
    }

    public String getStartplace() 
    {
        return startplace;
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
            .append("num", getNum())
            .append("feecount", getFeecount())
            .append("starttime", getStarttime())
            .append("startplace", getStartplace())
            .append("createdate", getCreatedate())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
