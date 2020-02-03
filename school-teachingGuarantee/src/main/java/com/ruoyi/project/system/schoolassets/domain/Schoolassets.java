package com.ruoyi.project.system.schoolassets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产管理对象 schoolassets
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class Schoolassets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String name;

    /** 分类 */
    @Excel(name = "分类")
    private String type;

    /** 购置时间 */
    @Excel(name = "购置时间")
    private String buytime;

    /** 使用数量 */
    @Excel(name = "使用数量")
    private String usenum;

    /** 闲置数量 */
    @Excel(name = "闲置数量")
    private String unusenum;

    /** 报废 */
    @Excel(name = "报废")
    private String brokennum;

    /** 缺少 */
    @Excel(name = "缺少")
    private String lessnum;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setBuytime(String buytime) 
    {
        this.buytime = buytime;
    }

    public String getBuytime() 
    {
        return buytime;
    }
    public void setUsenum(String usenum) 
    {
        this.usenum = usenum;
    }

    public String getUsenum() 
    {
        return usenum;
    }
    public void setUnusenum(String unusenum) 
    {
        this.unusenum = unusenum;
    }

    public String getUnusenum() 
    {
        return unusenum;
    }
    public void setBrokennum(String brokennum) 
    {
        this.brokennum = brokennum;
    }

    public String getBrokennum() 
    {
        return brokennum;
    }
    public void setLessnum(String lessnum) 
    {
        this.lessnum = lessnum;
    }

    public String getLessnum() 
    {
        return lessnum;
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
            .append("name", getName())
            .append("type", getType())
            .append("buytime", getBuytime())
            .append("usenum", getUsenum())
            .append("unusenum", getUnusenum())
            .append("brokennum", getBrokennum())
            .append("lessnum", getLessnum())
            .append("createdate", getCreatedate())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
