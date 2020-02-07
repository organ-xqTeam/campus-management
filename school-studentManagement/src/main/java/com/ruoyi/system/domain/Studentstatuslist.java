package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 学籍管理对象 studentstatuslist
 * 
 * @author ruoyi
 * @date 2020-02-04
 */
public class Studentstatuslist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private String studentsId;

    /** 学籍号 */
    @Excel(name = "学籍号" ,  type = Type.IMPORT)
    private String studentstatusId;

    /** 入学照片 */
    @Excel(name = "入学照片")
    private String admissionPhotos;

    /** 毕业照片 */
    @Excel(name = "毕业照片")
    private String graduationPictures;

    /** 入学时间 */
    @Excel(name = "入学时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date admissionTime;

    /** 状态 */
    @Excel(name = "状态")
    private String State;

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
    public void setStudentsId(String studentsId) 
    {
        this.studentsId = studentsId;
    }

    public String getStudentsId() 
    {
        return studentsId;
    }
    public void setStudentstatusId(String studentstatusId) 
    {
        this.studentstatusId = studentstatusId;
    }

    public String getStudentstatusId() 
    {
        return studentstatusId;
    }
    public void setAdmissionPhotos(String admissionPhotos) 
    {
        this.admissionPhotos = admissionPhotos;
    }

    public String getAdmissionPhotos() 
    {
        return admissionPhotos;
    }
    public void setGraduationPictures(String graduationPictures) 
    {
        this.graduationPictures = graduationPictures;
    }

    public String getGraduationPictures() 
    {
        return graduationPictures;
    }
    public void setAdmissionTime(Date admissionTime) 
    {
        this.admissionTime = admissionTime;
    }

    public Date getAdmissionTime() 
    {
        return admissionTime;
    }
    public void setState(String State) 
    {
        this.State = State;
    }

    public String getState() 
    {
        return State;
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
            .append("studentsId", getStudentsId())
            .append("studentstatusId", getStudentstatusId())
            .append("admissionPhotos", getAdmissionPhotos())
            .append("graduationPictures", getGraduationPictures())
            .append("admissionTime", getAdmissionTime())
            .append("State", getState())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("deptalias", getDeptalias())
            .append("useralias", getUseralias())
            .toString();
    }
}
