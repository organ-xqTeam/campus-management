package com.ruoyi.project.system.examOrdinaryResult.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 普通试题类型结果表 exam_ordinary_result
 * 
 * @author ruoyi
 * @date 2019-10-25
 */
public class ExamOrdinaryResult extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 名称 */
	private String optionName;
	/** 名称编码 */
	private String optionCode;
	/** 内容 */
	private String optionContent;
	/** 创建人 */
	private String creator;
	/** 创建时间 */
	private Date createDate;
	/** 修改人 */
	private String modifier;
	/** 修改时间 */
	private Date modifyDate;
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
	public void setOptionName(String optionName) 
	{
		this.optionName = optionName;
	}

	public String getOptionName() 
	{
		return optionName;
	}
	public void setOptionCode(String optionCode) 
	{
		this.optionCode = optionCode;
	}

	public String getOptionCode() 
	{
		return optionCode;
	}
	public void setOptionContent(String optionContent) 
	{
		this.optionContent = optionContent;
	}

	public String getOptionContent() 
	{
		return optionContent;
	}
	public void setCreator(String creator) 
	{
		this.creator = creator;
	}

	public String getCreator() 
	{
		return creator;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setModifier(String modifier) 
	{
		this.modifier = modifier;
	}

	public String getModifier() 
	{
		return modifier;
	}
	public void setModifyDate(Date modifyDate) 
	{
		this.modifyDate = modifyDate;
	}

	public Date getModifyDate() 
	{
		return modifyDate;
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
            .append("optionName", getOptionName())
            .append("optionCode", getOptionCode())
            .append("optionContent", getOptionContent())
            .append("creator", getCreator())
            .append("createDate", getCreateDate())
            .append("modifier", getModifier())
            .append("modifyDate", getModifyDate())
            .append("delFlag", getDelFlag())
            .append("applicationCode", getApplicationCode())
            .append("tenantCode", getTenantCode())
            .toString();
    }
}
