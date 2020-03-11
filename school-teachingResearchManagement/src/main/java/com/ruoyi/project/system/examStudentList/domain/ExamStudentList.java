package com.ruoyi.project.system.examStudentList.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 exam_student_list
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
public class ExamStudentList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private String studentid;

    /** 试卷id */
    @Excel(name = "试卷id")
    private String paperid;

    /** 总分 */
    @Excel(name = "总分")
    private String total;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentid(String studentid) 
    {
        this.studentid = studentid;
    }

    public String getStudentid() 
    {
        return studentid;
    }
    public void setPaperid(String paperid) 
    {
        this.paperid = paperid;
    }

    public String getPaperid() 
    {
        return paperid;
    }
    public void setTotal(String total) 
    {
        this.total = total;
    }

    public String getTotal() 
    {
        return total;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentid", getStudentid())
            .append("paperid", getPaperid())
            .append("total", getTotal())
            .toString();
    }
}
