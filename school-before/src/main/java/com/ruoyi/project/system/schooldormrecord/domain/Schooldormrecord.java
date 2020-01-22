package com.ruoyi.project.system.schooldormrecord.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 住宿记录对象 schooldormrecord
 * 
 * @author ruoyi
 * @date 2019-11-18
 */
public class Schooldormrecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 楼宇名 */
    @Excel(name = "楼宇名")
    private String name;

    /** 房间号 */
    @Excel(name = "房间号")
    private String num;

    /** 入住人数 */
    @Excel(name = "入住人数")
    private String studentnum;

    /** 金额 */
    @Excel(name = "金额")
    private String money;

    /** 支付状态 0未支付 1已支付 */
    @Excel(name = "支付状态 0未支付 1已支付")
    private String paystate;

    /** 入住时长 */
    @Excel(name = "入住时长")
    private String livetime;

    /** 入住时间 */
    @Excel(name = "入住时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date livedate;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedate;

    /** 0未删除 1已删除 */
    @Excel(name = "0未删除 1已删除")
    private String isdelete;

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
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setStudentnum(String studentnum) 
    {
        this.studentnum = studentnum;
    }

    public String getStudentnum() 
    {
        return studentnum;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setPaystate(String paystate) 
    {
        this.paystate = paystate;
    }

    public String getPaystate() 
    {
        return paystate;
    }
    public void setLivetime(String livetime) 
    {
        this.livetime = livetime;
    }

    public String getLivetime() 
    {
        return livetime;
    }
    public void setLivedate(Date livedate) 
    {
        this.livedate = livedate;
    }

    public Date getLivedate() 
    {
        return livedate;
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
    public void setIsdelete(String isdelete) 
    {
        this.isdelete = isdelete;
    }

    public String getIsdelete() 
    {
        return isdelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("num", getNum())
            .append("studentnum", getStudentnum())
            .append("money", getMoney())
            .append("paystate", getPaystate())
            .append("livetime", getLivetime())
            .append("livedate", getLivedate())
            .append("createdate", getCreatedate())
            .append("updatedate", getUpdatedate())
            .append("isdelete", getIsdelete())
            .toString();
    }
}
