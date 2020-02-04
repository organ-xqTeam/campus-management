package com.ruoyi.project.system.schoolclassroom.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教室管理对象 schoolclassroom
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class Schoolclassroom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 教学楼 */
    @Excel(name = "教学楼")
    private String floor;

    /** 楼层位置 */
    @Excel(name = "楼层位置")
    private String floornum;

    /** 教室编号 */
    @Excel(name = "教室编号")
    private String num;

    /** 状态1占用2空闲 */
    @Excel(name = "状态1占用2空闲")
    private String state;

    /** 容纳人数 */
    @Excel(name = "容纳人数")
    private String contain;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createdate;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String deleteFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFloor(String floor) 
    {
        this.floor = floor;
    }

    public String getFloor() 
    {
        return floor;
    }
    public void setFloornum(String floornum) 
    {
        this.floornum = floornum;
    }

    public String getFloornum() 
    {
        return floornum;
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
    public void setContain(String contain) 
    {
        this.contain = contain;
    }

    public String getContain() 
    {
        return contain;
    }
    public void setCreatedate(String createdate) 
    {
        this.createdate = createdate;
    }

    public String getCreatedate() 
    {
        return createdate;
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
            .append("floor", getFloor())
            .append("floornum", getFloornum())
            .append("num", getNum())
            .append("state", getState())
            .append("contain", getContain())
            .append("createdate", getCreatedate())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
