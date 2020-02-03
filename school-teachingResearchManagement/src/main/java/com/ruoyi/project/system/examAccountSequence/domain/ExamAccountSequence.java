package com.ruoyi.project.system.examAccountSequence.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科目测评维度顺序显示表 exam_account_sequence
 * 
 * @author ruoyi
 * @date 2019-10-24
 */
public class ExamAccountSequence extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 分类id */
	private String categoryId;
	/** 顺序 */
	private String sequenceDesc;
	/** 维度ID */
	private String dimensionId;
	/** 删除标记 0:正常;1:删除 */
	private Integer delFlag;
	/** 系统编号 */
	private String applicationCode;
	/** 租户编号 */
	private String tenantCode;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setCategoryId(String categoryId) 
	{
		this.categoryId = categoryId;
	}

	public String getCategoryId() 
	{
		return categoryId;
	}
	public void setSequenceDesc(String sequenceDesc) 
	{
		this.sequenceDesc = sequenceDesc;
	}

	public String getSequenceDesc() 
	{
		return sequenceDesc;
	}
	public void setDimensionId(String dimensionId) 
	{
		this.dimensionId = dimensionId;
	}

	public String getDimensionId() 
	{
		return dimensionId;
	}
	public void setDelFlag(Integer delFlag) 
	{
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() 
	{
		return delFlag;
	}
	public void setApplicationCode(String applicationCode) 
	{
		this.applicationCode = applicationCode;
	}

	public String getApplicationCode() 
	{
		return applicationCode;
	}
	public void setTenantCode(String tenantCode) 
	{
		this.tenantCode = tenantCode;
	}

	public String getTenantCode() 
	{
		return tenantCode;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("sequenceDesc", getSequenceDesc())
            .append("dimensionId", getDimensionId())
            .append("delFlag", getDelFlag())
            .append("applicationCode", getApplicationCode())
            .append("tenantCode", getTenantCode())
            .toString();
    }
}
