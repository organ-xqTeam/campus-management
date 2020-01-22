package com.ruoyi.project.system.schoolHomework.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生作业表对象 school_homework
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public class SchoolHomework extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String curriculumName;

    /** 课程id(暂时用不上) */
    @Excel(name = "课程id(暂时用不上)coursemanagementId")
    private Long curriculumId;

    /** 作业名称 */
    @Excel(name = "作业名称")
    private String homeworkName;

    /** 作业id(暂时用不上) */
    @Excel(name = "作业id(暂时用不上)")
    private Long homeworkId;

    /** 提交时间 */
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitDate;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 是否删除 0未删除 1删除 */
    private String delFlag;
    
    private String studentid;
    
    private String submitFlag;
    
    private String did;
    
    //作业内容
    private String content;
    //上传图片的id或者路径使用逗号,分隔
    private String picIds;
    
    public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getSubmitFlag() {
		return submitFlag;
	}

	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCurriculumName(String curriculumName) 
    {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumName() 
    {
        return curriculumName;
    }
    public void setCurriculumId(Long curriculumId) 
    {
        this.curriculumId = curriculumId;
    }

    public Long getCurriculumId() 
    {
        return curriculumId;
    }
    public void setHomeworkName(String homeworkName) 
    {
        this.homeworkName = homeworkName;
    }

    public String getHomeworkName() 
    {
        return homeworkName;
    }
    public void setHomeworkId(Long homeworkId) 
    {
        this.homeworkId = homeworkId;
    }

    public Long getHomeworkId() 
    {
        return homeworkId;
    }
    public void setSubmitDate(Date submitDate) 
    {
        this.submitDate = submitDate;
    }

    public Date getSubmitDate() 
    {
        return submitDate;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicIds() {
		return picIds;
	}

	public void setPicIds(String picIds) {
		this.picIds = picIds;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("curriculumName", getCurriculumName())
            .append("curriculumId", getCurriculumId())
            .append("homeworkName", getHomeworkName())
            .append("homeworkId", getHomeworkId())
            .append("submitDate", getSubmitDate())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
