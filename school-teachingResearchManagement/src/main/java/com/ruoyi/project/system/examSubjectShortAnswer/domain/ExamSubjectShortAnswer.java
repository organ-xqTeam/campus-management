package com.ruoyi.project.system.examSubjectShortAnswer.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 简答题表 exam_subject_short_answer
 * 
 * @author ruoyi
 * @date 2019-08-27
 */
public class ExamSubjectShortAnswer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 分类ID */
	private String categoryId;
	/** 序号 */
	private Integer serialNumber;
	/** 题目名称 */
	private String subjectName;
	/** 参考答案 */
	private String answer;
	/** 分值 */
	private Integer score;
	/** 解析 */
	private String analysis;
	/** 难度等级 */
	private Integer level;
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
	/** 租户编号 */
	private String hotnum;
	/** 租户编号 */
	private String description;
	/** 租户编号 */
	private String hottitle;
	
	private String courseid;
	private String coursename;
	
	

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

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
	public void setSerialNumber(Integer serialNumber) 
	{
		this.serialNumber = serialNumber;
	}

	public Integer getSerialNumber() 
	{
		return serialNumber;
	}
	public void setSubjectName(String subjectName) 
	{
		this.subjectName = subjectName;
	}

	public String getSubjectName() 
	{
		return subjectName;
	}
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}

	public String getAnswer() 
	{
		return answer;
	}
	public void setScore(Integer score) 
	{
		this.score = score;
	}

	public Integer getScore() 
	{
		return score;
	}
	public void setAnalysis(String analysis) 
	{
		this.analysis = analysis;
	}

	public String getAnalysis() 
	{
		return analysis;
	}
	public void setLevel(Integer level) 
	{
		this.level = level;
	}

	public Integer getLevel() 
	{
		return level;
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

    public String getHotnum() {
		return hotnum;
	}

	public void setHotnum(String hotnum) {
		this.hotnum = hotnum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHottitle() {
		return hottitle;
	}

	public void setHottitle(String hottitle) {
		this.hottitle = hottitle;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("serialNumber", getSerialNumber())
            .append("subjectName", getSubjectName())
            .append("answer", getAnswer())
            .append("score", getScore())
            .append("analysis", getAnalysis())
            .append("level", getLevel())
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
