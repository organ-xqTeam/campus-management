package com.ruoyi.project.system.schoolClass.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班级管理对象 school_class
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public class SchoolClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String num;

    /** 状态1在读2毕业 */
    @Excel(name = "状态1在读2毕业")
    private String state;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String nameclass;

    /** 与schoolgradelist年级表对应的年级id */
    @Excel(name = "与schoolgradelist年级表对应的年级id")
    private Long gradelistId;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createDate;

    /** 更新时间 */
    @Excel(name = "更新时间")
    private String updateDate;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String deleteFlag;
    
    private String gid;
    
    private String grade;
    
    private String entertime;
    
    private String finishtime;
    
    private String enternum;
    
    private String gradecharge;
        
    private String studentnum;
    private String sbid;
    private String ssid;
    
	public String getSbid() {
		return sbid;
	}

	public void setSbid(String sbid) {
		this.sbid = sbid;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getStudentnum() {
		return studentnum;
	}

	public void setStudentnum(String studentnum) {
		this.studentnum = studentnum;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEntertime() {
		return entertime;
	}

	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}

	public String getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}

	public String getEnternum() {
		return enternum;
	}

	public void setEnternum(String enternum) {
		this.enternum = enternum;
	}

	public String getGradecharge() {
		return gradecharge;
	}

	public void setGradecharge(String gradecharge) {
		this.gradecharge = gradecharge;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setNameclass(String nameclass) 
    {
        this.nameclass = nameclass;
    }

    public String getNameclass() 
    {
        return nameclass;
    }
    public void setGradelistId(Long gradelistId) 
    {
        this.gradelistId = gradelistId;
    }

    public Long getGradelistId() 
    {
        return gradelistId;
    }
    public void setCreateDate(String createDate) 
    {
        this.createDate = createDate;
    }

    public String getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(String updateDate) 
    {
        this.updateDate = updateDate;
    }

    public String getUpdateDate() 
    {
        return updateDate;
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
            .append("num", getNum())
            .append("state", getState())
            .append("nameclass", getNameclass())
            .append("gradelistId", getGradelistId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
