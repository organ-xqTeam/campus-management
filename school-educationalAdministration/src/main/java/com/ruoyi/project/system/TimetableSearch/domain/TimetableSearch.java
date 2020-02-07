package com.ruoyi.project.system.TimetableSearch.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 个人人事安排查询对象 timetable_search
 * 
 * @author ruoyi
 * @date 2020-02-06
 */
public class TimetableSearch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师名称 */
    @Excel(name = "教师名称")
    private String teacherName;

    /** 教师id */
    @Excel(name = "教师id")
    private Long teacherId;

    /** 年月 */
    @Excel(name = "年月")
    private String yearmonth;

    /** 第几周 */
    @Excel(name = "第几周")
    private String week;

    /** 具体位置 */
    @Excel(name = "具体位置")
    private String detailPosition;

    /** 周几 */
    @Excel(name = "周几")
    private String weekName;

    /** 每天的时间 */
    @Excel(name = "每天的时间")
    private String timeName;

    /** 是否弃用 */
    @Excel(name = "是否弃用")
    private String isdisuse;

    /** 班级id */
    @Excel(name = "班级id")
    private Long classId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 年级名称 */
    @Excel(name = "年级名称")
    private String classGrade;

    /** 年级id */
    @Excel(name = "年级id")
    private Long gradeId;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setDetailPosition(String detailPosition) 
    {
        this.detailPosition = detailPosition;
    }

    public String getDetailPosition() 
    {
        return detailPosition;
    }
    public void setWeekName(String weekName) 
    {
        this.weekName = weekName;
    }

    public String getWeekName() 
    {
        return weekName;
    }
    public void setTimeName(String timeName) 
    {
        this.timeName = timeName;
    }

    public String getTimeName() 
    {
        return timeName;
    }
    public void setIsdisuse(String isdisuse) 
    {
        this.isdisuse = isdisuse;
    }

    public String getIsdisuse() 
    {
        return isdisuse;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }
    public void setClassGrade(String classGrade) 
    {
        this.classGrade = classGrade;
    }

    public String getClassGrade() 
    {
        return classGrade;
    }
    public void setGradeId(Long gradeId) 
    {
        this.gradeId = gradeId;
    }

    public Long getGradeId() 
    {
        return gradeId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherName", getTeacherName())
            .append("teacherId", getTeacherId())
            .append("yearmonth", getYearmonth())
            .append("week", getWeek())
            .append("detailPosition", getDetailPosition())
            .append("weekName", getWeekName())
            .append("timeName", getTimeName())
            .append("isdisuse", getIsdisuse())
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("classGrade", getClassGrade())
            .append("gradeId", getGradeId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
