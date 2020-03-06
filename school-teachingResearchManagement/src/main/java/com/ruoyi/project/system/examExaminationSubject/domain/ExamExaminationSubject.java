package com.ruoyi.project.system.examExaminationSubject.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考试题目表 exam_examination_subject
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
public class ExamExaminationSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 考试ID */
	private String examinationId;
	/** 题目ID */
	private String subjectId;
	/** 类型 0-选择题，1-简答题 */
	private Integer type;
	/** 系统编号 */
	private String applicationCode;
	/**  */
	private String tenantCode;
	/**  */
	private Integer serialNumber;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setExaminationId(String examinationId) 
	{
		this.examinationId = examinationId;
	}

	public String getExaminationId() 
	{
		return examinationId;
	}
	public void setSubjectId(String subjectId) 
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
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
	public void setSerialNumber(Integer serialNumber) 
	{
		this.serialNumber = serialNumber;
	}

	public Integer getSerialNumber() 
	{
		return serialNumber;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examinationId", getExaminationId())
            .append("subjectId", getSubjectId())
            .append("type", getType())
            .append("applicationCode", getApplicationCode())
            .append("tenantCode", getTenantCode())
            .append("serialNumber", getSerialNumber())
            .toString();
    }
}
