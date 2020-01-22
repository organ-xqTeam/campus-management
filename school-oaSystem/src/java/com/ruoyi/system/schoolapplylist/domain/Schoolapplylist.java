package com.ruoyi.project.system.schoolapplylist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 审批对象 schoolapplylist
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
public class Schoolapplylist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 申请编号 */
    @Excel(name = "申请编号")
    private String applynum;

    /** 申请时间 */
    @Excel(name = "申请时间")
    private String applytime;

    /** 申请分类 */
    @Excel(name = "申请分类")
    private String applytype;

    /** 申请名称 */
    @Excel(name = "申请名称")
    private String applyname;

    /** 申请内容 */
    @Excel(name = "申请内容")
    private String applycontent;

    /** 申请人 */
    @Excel(name = "申请人")
    private String applyperson;

    /** 审批人 */
    @Excel(name = "审批人")
    private String approvalperson;

    /** 抄送人 */
    @Excel(name = "抄送人")
    private String sendperson;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createdate;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String deleteFlag;

    /** 申请备注 */
    @Excel(name = "申请备注")
    private String remark0;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String applystatus;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String applyopinion;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplynum(String applynum) 
    {
        this.applynum = applynum;
    }

    public String getApplynum() 
    {
        return applynum;
    }
    public void setApplytime(String applytime) 
    {
        this.applytime = applytime;
    }

    public String getApplytime() 
    {
        return applytime;
    }
    public void setApplytype(String applytype) 
    {
        this.applytype = applytype;
    }

    public String getApplytype() 
    {
        return applytype;
    }
    public void setApplyname(String applyname) 
    {
        this.applyname = applyname;
    }

    public String getApplyname() 
    {
        return applyname;
    }
    public void setApplycontent(String applycontent) 
    {
        this.applycontent = applycontent;
    }

    public String getApplycontent() 
    {
        return applycontent;
    }
    public void setApplyperson(String applyperson) 
    {
        this.applyperson = applyperson;
    }

    public String getApplyperson() 
    {
        return applyperson;
    }
    public void setApprovalperson(String approvalperson) 
    {
        this.approvalperson = approvalperson;
    }

    public String getApprovalperson() 
    {
        return approvalperson;
    }
    public void setSendperson(String sendperson) 
    {
        this.sendperson = sendperson;
    }

    public String getSendperson() 
    {
        return sendperson;
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
    public void setRemark0(String remark0) 
    {
        this.remark0 = remark0;
    }

    public String getRemark0() 
    {
        return remark0;
    }
    public void setApplystatus(String applystatus) 
    {
        this.applystatus = applystatus;
    }

    public String getApplystatus() 
    {
        return applystatus;
    }
    public void setApplyopinion(String applyopinion) 
    {
        this.applyopinion = applyopinion;
    }

    public String getApplyopinion() 
    {
        return applyopinion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applynum", getApplynum())
            .append("applytime", getApplytime())
            .append("applytype", getApplytype())
            .append("applyname", getApplyname())
            .append("applycontent", getApplycontent())
            .append("applyperson", getApplyperson())
            .append("approvalperson", getApprovalperson())
            .append("sendperson", getSendperson())
            .append("createdate", getCreatedate())
            .append("deleteFlag", getDeleteFlag())
            .append("remark0", getRemark0())
            .append("applystatus", getApplystatus())
            .append("applyopinion", getApplyopinion())
            .toString();
    }
}
