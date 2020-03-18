package com.ruoyi.project.system.schoolResult.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校成绩对象 school_result
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
public class SchoolResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String curriculumName;

    /** 课程id(暂时用不上) */
    @Excel(name = "课程id(暂时用不上)")
    private Long curriculumId;

    /** 考试名称 */
    @Excel(name = "考试名称")
    private String examName;

    /** 考试id(暂时用不上) */
    @Excel(name = "考试id(暂时用不上)")
    private Long examId;

    /** 考试时间 */
    @Excel(name = "考试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date examDate;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 是否删除 0未删除 1删除 */
    private String delFlag;
    private String studentid;
    
    

    public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
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
    public void setExamName(String examName) 
    {
        this.examName = examName;
    }

    public String getExamName() 
    {
        return examName;
    }
    public void setExamId(Long examId) 
    {
        this.examId = examId;
    }

    public Long getExamId() 
    {
        return examId;
    }
    public void setExamDate(Date examDate) 
    {
        this.examDate = examDate;
    }

    public Date getExamDate() 
    {
        return examDate;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("curriculumName", getCurriculumName())
            .append("curriculumId", getCurriculumId())
            .append("examName", getExamName())
            .append("examId", getExamId())
            .append("examDate", getExamDate())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
