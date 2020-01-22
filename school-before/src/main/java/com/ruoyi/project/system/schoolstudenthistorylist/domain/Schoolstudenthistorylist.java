package com.ruoyi.project.system.schoolstudenthistorylist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 调班历史对象 schoolstudenthistorylist
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public class Schoolstudenthistorylist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentsId;

    /** $column.columnComment */
    @Excel(name = "学生id")
    private String time;

    /** 删除标记 0:正常;1:删除 */
    private Long delFlag;
    
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
    public void setTime(String time) 
    {
        this.time = time;
    }

    public String getTime() 
    {
        return time;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentsId", getStudentsId())
            .append("remark", getRemark())
            .append("time", getTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
