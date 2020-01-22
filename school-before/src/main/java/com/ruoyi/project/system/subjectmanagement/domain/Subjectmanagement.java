package com.ruoyi.project.system.subjectmanagement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科目管理对象 subjectmanagement
 * 
 * @author ruoyi
 * @date 2019-11-19
 */
public class Subjectmanagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String rowId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String studentsName;

    /** 分类 */
    @Excel(name = "分类")
    private String academicLevel;

    /** 课程体系 */
    @Excel(name = "课程体系")
    private String curriculuSystem;

    /** 课程介绍 */
    @Excel(name = "课程介绍")
    private String courseIntroduction;

    /** 课程分册 */
    @Excel(name = "课程分册")
    private String courseFascicle;

    /** 备注 */
    @Excel(name = "备注")
    private String remark1;

    /** 备注 */
    @Excel(name = "备注")
    private String remark2;

    /** 备注 */
    @Excel(name = "备注")
    private String remark3;

    /** 备注 */
    @Excel(name = "备注")
    private String remark4;

    /** 备注 */
    @Excel(name = "备注")
    private String remark5;

    /** 备注 */
    @Excel(name = "备注")
    private String remark6;

    /** 备注 */
    @Excel(name = "备注")
    private String remark7;

    /** 备注 */
    @Excel(name = "备注")
    private String remark8;

    /** 备注 */
    @Excel(name = "备注")
    private String remark9;

    /** 备注 */
    @Excel(name = "备注")
    private String remark10;

    /** 备注 */
    @Excel(name = "备注")
    private String remark11;

    /** 备注 */
    @Excel(name = "备注")
    private String remark12;

    /** 备注 */
    @Excel(name = "备注")
    private String remark13;

    /** 备注 */
    @Excel(name = "备注")
    private String remark14;

    /** 备注 */
    @Excel(name = "备注")
    private String remark15;

    /** 备注 */
    @Excel(name = "备注")
    private String remark16;

    /** 备注 */
    @Excel(name = "备注")
    private String remark17;

    /** 删除标记 0:正常;1:删除 */
    private Long delFlag;

    /** 部门表的别名 */
    @Excel(name = "部门表的别名")
    private String deptalias;

    /** 用户表的别名 */
    @Excel(name = "用户表的别名")
    private String useralias;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRowId(String rowId) 
    {
        this.rowId = rowId;
    }

    public String getRowId() 
    {
        return rowId;
    }
    public void setStudentsName(String studentsName) 
    {
        this.studentsName = studentsName;
    }

    public String getStudentsName() 
    {
        return studentsName;
    }
    public void setAcademicLevel(String academicLevel) 
    {
        this.academicLevel = academicLevel;
    }

    public String getAcademicLevel() 
    {
        return academicLevel;
    }
    public void setCurriculuSystem(String curriculuSystem) 
    {
        this.curriculuSystem = curriculuSystem;
    }

    public String getCurriculuSystem() 
    {
        return curriculuSystem;
    }
    public void setCourseIntroduction(String courseIntroduction) 
    {
        this.courseIntroduction = courseIntroduction;
    }

    public String getCourseIntroduction() 
    {
        return courseIntroduction;
    }
    public void setCourseFascicle(String courseFascicle) 
    {
        this.courseFascicle = courseFascicle;
    }

    public String getCourseFascicle() 
    {
        return courseFascicle;
    }
    public void setRemark1(String remark1) 
    {
        this.remark1 = remark1;
    }

    public String getRemark1() 
    {
        return remark1;
    }
    public void setRemark2(String remark2) 
    {
        this.remark2 = remark2;
    }

    public String getRemark2() 
    {
        return remark2;
    }
    public void setRemark3(String remark3) 
    {
        this.remark3 = remark3;
    }

    public String getRemark3() 
    {
        return remark3;
    }
    public void setRemark4(String remark4) 
    {
        this.remark4 = remark4;
    }

    public String getRemark4() 
    {
        return remark4;
    }
    public void setRemark5(String remark5) 
    {
        this.remark5 = remark5;
    }

    public String getRemark5() 
    {
        return remark5;
    }
    public void setRemark6(String remark6) 
    {
        this.remark6 = remark6;
    }

    public String getRemark6() 
    {
        return remark6;
    }
    public void setRemark7(String remark7) 
    {
        this.remark7 = remark7;
    }

    public String getRemark7() 
    {
        return remark7;
    }
    public void setRemark8(String remark8) 
    {
        this.remark8 = remark8;
    }

    public String getRemark8() 
    {
        return remark8;
    }
    public void setRemark9(String remark9) 
    {
        this.remark9 = remark9;
    }

    public String getRemark9() 
    {
        return remark9;
    }
    public void setRemark10(String remark10) 
    {
        this.remark10 = remark10;
    }

    public String getRemark10() 
    {
        return remark10;
    }
    public void setRemark11(String remark11) 
    {
        this.remark11 = remark11;
    }

    public String getRemark11() 
    {
        return remark11;
    }
    public void setRemark12(String remark12) 
    {
        this.remark12 = remark12;
    }

    public String getRemark12() 
    {
        return remark12;
    }
    public void setRemark13(String remark13) 
    {
        this.remark13 = remark13;
    }

    public String getRemark13() 
    {
        return remark13;
    }
    public void setRemark14(String remark14) 
    {
        this.remark14 = remark14;
    }

    public String getRemark14() 
    {
        return remark14;
    }
    public void setRemark15(String remark15) 
    {
        this.remark15 = remark15;
    }

    public String getRemark15() 
    {
        return remark15;
    }
    public void setRemark16(String remark16) 
    {
        this.remark16 = remark16;
    }

    public String getRemark16() 
    {
        return remark16;
    }
    public void setRemark17(String remark17) 
    {
        this.remark17 = remark17;
    }

    public String getRemark17() 
    {
        return remark17;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setDeptalias(String deptalias) 
    {
        this.deptalias = deptalias;
    }

    public String getDeptalias() 
    {
        return deptalias;
    }
    public void setUseralias(String useralias) 
    {
        this.useralias = useralias;
    }

    public String getUseralias() 
    {
        return useralias;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("rowId", getRowId())
            .append("studentsName", getStudentsName())
            .append("academicLevel", getAcademicLevel())
            .append("curriculuSystem", getCurriculuSystem())
            .append("courseIntroduction", getCourseIntroduction())
            .append("courseFascicle", getCourseFascicle())
            .append("remark", getRemark())
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .append("remark7", getRemark7())
            .append("remark8", getRemark8())
            .append("remark9", getRemark9())
            .append("remark10", getRemark10())
            .append("remark11", getRemark11())
            .append("remark12", getRemark12())
            .append("remark13", getRemark13())
            .append("remark14", getRemark14())
            .append("remark15", getRemark15())
            .append("remark16", getRemark16())
            .append("remark17", getRemark17())
            .append("delFlag", getDelFlag())
            .append("deptalias", getDeptalias())
            .append("useralias", getUseralias())
            .toString();
    }
}
