package com.ruoyi.project.system.ClasscurriculumDetail.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 课表详情对象 classcurriculum_detail
 * 
 * @author ruoyi
 * @date 2019-11-26
 */
public class ClasscurriculumDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 与classcurriculum 课表的id对应 */
    @Excel(name = "与classcurriculum 课表的id对应")
    private Long cuurriculumId;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedate;

    /** 位置详情   x-x    星期几-那节课 */
    @Excel(name = "位置详情   x-x    星期几-那节课")
    private String detailPosition;

    /** 科目名称 */
    @Excel(name = "科目名称")
    private String subject;

    /** 是否使用 0 使用 1弃用 */
    @Excel(name = "是否使用 0 使用 1弃用")
    private String isdisuse;

    /** 是否删除 0未删除 1删除 */
    @Excel(name = "是否删除 0未删除 1删除")
    private String delflag;

    /** 教师名称 */
    @Excel(name = "教师名称")
    private String teacherName;

    /** 教师id */
    @Excel(name = "教师id")
    private Long teacherId;

    /** 年月 yyyyy-mm */
    @Excel(name = "年月 yyyyy-mm")
    private String yearmonth;

    /** 第几周 */
    @Excel(name = "第几周")
    private String week;

    /** 科目id */
    @Excel(name = "科目id")
    private Long coursemanagementId;
    
    private String remark1;
    
    public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCuurriculumId(Long cuurriculumId) 
    {
        this.cuurriculumId = cuurriculumId;
    }

    public Long getCuurriculumId() 
    {
        return cuurriculumId;
    }
    public void setCreatedate(Date createdate) 
    {
        this.createdate = createdate;
    }

    public Date getCreatedate() 
    {
        return createdate;
    }
    public void setUpdatedate(Date updatedate) 
    {
        this.updatedate = updatedate;
    }

    public Date getUpdatedate() 
    {
        return updatedate;
    }
    public void setDetailPosition(String detailPosition) 
    {
        this.detailPosition = detailPosition;
    }

    public String getDetailPosition() 
    {
        return detailPosition;
    }
    public void setSubject(String subject) 
    {
        this.subject = subject;
    }

    public String getSubject() 
    {
        return subject;
    }
    public void setIsdisuse(String isdisuse) 
    {
        this.isdisuse = isdisuse;
    }

    public String getIsdisuse() 
    {
        return isdisuse;
    }
    public void setDelflag(String delflag) 
    {
        this.delflag = delflag;
    }

    public String getDelflag() 
    {
        return delflag;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setYearmonth(String yearmonth) 
    {
        this.yearmonth = yearmonth;
    }

    public String getYearmonth() 
    {
        return yearmonth;
    }
    public void setWeek(String week) 
    {
        this.week = week;
    }

    public String getWeek() 
    {
        return week;
    }
    public void setCoursemanagementId(Long coursemanagementId) 
    {
        this.coursemanagementId = coursemanagementId;
    }

    public Long getCoursemanagementId() 
    {
        return coursemanagementId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cuurriculumId", getCuurriculumId())
            .append("createdate", getCreatedate())
            .append("updatedate", getUpdatedate())
            .append("detailPosition", getDetailPosition())
            .append("subject", getSubject())
            .append("remark", getRemark())
            .append("isdisuse", getIsdisuse())
            .append("delflag", getDelflag())
            .append("teacherName", getTeacherName())
            .append("teacherId", getTeacherId())
            .append("yearmonth", getYearmonth())
            .append("week", getWeek())
            .append("coursemanagementId", getCoursemanagementId())
            .toString();
    }
}
