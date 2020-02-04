package com.ruoyi.project.system.schoolmetting.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会议管理对象 schoolmetting
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class Schoolmetting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 会议名称 */
    @Excel(name = "会议名称")
    private String name;

    /** 分类 */
    @Excel(name = "分类")
    private String type;

    /** 时间 */
    @Excel(name = "时间")
    private String time;

    /** 参加人数 */
    @Excel(name = "参加人数")
    private String enternum;

    /** 地点 */
    @Excel(name = "地点")
    private String place;
    
    private String place2;

    /** 主题 */
    @Excel(name = "主题")
    private String theme;

    /** 主办部门 */
    @Excel(name = "主办部门")
    private String department;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String deleteFlag;

    public String getPlace2() {
		return place2;
	}

	public void setPlace2(String place2) {
		this.place2 = place2;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setTime(String time) 
    {
        this.time = time;
    }

    public String getTime() 
    {
        return time;
    }
    public void setEnternum(String enternum) 
    {
        this.enternum = enternum;
    }

    public String getEnternum() 
    {
        return enternum;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setTheme(String theme) 
    {
        this.theme = theme;
    }

    public String getTheme() 
    {
        return theme;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
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
            .append("name", getName())
            .append("type", getType())
            .append("time", getTime())
            .append("enternum", getEnternum())
            .append("place", getPlace())
            .append("theme", getTheme())
            .append("department", getDepartment())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
