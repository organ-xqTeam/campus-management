package com.ruoyi.project.system.schoolHomeworkDetail.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校作业表对象 school_homework_detail
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public class SchoolHomeworkDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentsId;

    /** 是否提交 */
    @Excel(name = "是否提交")
    private String submitFlag;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 是否删除 */
    private String delFlag;

    /** 学校学生作业表的id school_homework */
    @Excel(name = "学校学生作业表的id school_homework")
    private Long homeworkId;

    /** 文件id */
    @Excel(name = "文件id")
    private String fileId;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;
    
    //是否合格
    private String passFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentsId(Long studentsId) 
    {
        this.studentsId = studentsId;
    }

    public Long getStudentsId() 
    {
        return studentsId;
    }
    public void setSubmitFlag(String submitFlag) 
    {
        this.submitFlag = submitFlag;
    }

    public String getSubmitFlag() 
    {
        return submitFlag;
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
    public void setHomeworkId(Long homeworkId) 
    {
        this.homeworkId = homeworkId;
    }

    public Long getHomeworkId() 
    {
        return homeworkId;
    }
    public void setFileId(String fileId) 
    {
        this.fileId = fileId;
    }

    public String getFileId() 
    {
        return fileId;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    

    public String getPassFlag() {
		return passFlag;
	}

	public void setPassFlag(String passFlag) {
		this.passFlag = passFlag;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentsId", getStudentsId())
            .append("submitFlag", getSubmitFlag())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("delFlag", getDelFlag())
            .append("homeworkId", getHomeworkId())
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .toString();
    }
}
