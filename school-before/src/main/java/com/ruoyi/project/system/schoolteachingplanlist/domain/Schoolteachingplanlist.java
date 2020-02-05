package com.ruoyi.project.system.schoolteachingplanlist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教案对象 schoolteachingplanlist
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
public class Schoolteachingplanlist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 教案编号 */
    @Excel(name = "教案编号")
    private String num;

    /** 年级id */
    @Excel(name = "年级id")
    private String grade;

    /** 课程id */
    @Excel(name = "课程id")
    private String curriculum;
    
    private String curriculum2;

    /** 任课老师 */
    @Excel(name = "任课老师")
    private String teacher;
    
    private String teacher2;

    /** 删除标记 0:正常;1:删除 */
    private Long delFlag;
    
    private String grade2;    
    private String finishtime;    
    private String enternum;
    
    public String getGrade2() {
		return grade2;
	}

	public void setGrade2(String grade2) {
		this.grade2 = grade2;
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
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setCurriculum(String curriculum) 
    {
        this.curriculum = curriculum;
    }

    public String getCurriculum() 
    {
        return curriculum;
    }
    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }

    public String getTeacher() 
    {
        return teacher;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    
    public String getCurriculum2() {
		return curriculum2;
	}

	public void setCurriculum2(String curriculum2) {
		this.curriculum2 = curriculum2;
	}
	
	public String getTeacher2() {
		return teacher2;
	}

	public void setTeacher2(String teacher2) {
		this.teacher2 = teacher2;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("num", getNum())
            .append("grade", getGrade())
            .append("curriculum", getCurriculum())
            .append("teacher", getTeacher())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
