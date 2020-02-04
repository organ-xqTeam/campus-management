package com.ruoyi.project.system.examSubjectCategory.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 题目分类表 exam_subject_category
 * 
 * @author ruoyi
 * @date 2019-08-08
 */
public class ExamSubjectCategory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 分类名称 */
	private String categoryName;
	/** 分类描述 */
	private String categoryDesc;
	/** 父分类ID */
	private String parentId;
	/** 父分类ID */
	private String parentName;
	/** 排序号 */
	private Integer sort;
	/** 类型: 0-私共,1-公有 */
	private Integer type;
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
	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}

	public String getCategoryName() 
	{
		return categoryName;
	}
	public void setCategoryDesc(String categoryDesc) 
	{
		this.categoryDesc = categoryDesc;
	}

	public String getCategoryDesc() 
	{
		return categoryDesc;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
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

	
	
    public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryName", getCategoryName())
            .append("categoryDesc", getCategoryDesc())
            .append("parentId", getParentId())
            .append("sort", getSort())
            .append("type", getType())
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
