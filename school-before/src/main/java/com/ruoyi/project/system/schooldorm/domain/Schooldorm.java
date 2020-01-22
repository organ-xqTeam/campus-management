package com.ruoyi.project.system.schooldorm.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍对象 schooldorm
 * 
 * @author ruoyi
 * @date 2019-11-14
 */
public class Schooldorm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 编号(房间号) */
    @Excel(name = "编号(房间号)")
    private String num;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedate;

    /** 楼层 */
    @Excel(name = "楼层")
    private String storey;

    /** 楼宇id */
    @Excel(name = "楼宇id")
    private Long buildId;

    /** 0 ,1删除 */
    @Excel(name = "0 ,1删除")
    private String isdelete;

    /** 位置 */
    @Excel(name = "位置")
    private String position;

    /** 居住人数 */
    @Excel(name = "居住人数")
    private String liveNum;

    /** 价格 */
    @Excel(name = "价格")
    private String money;
    
    /** 学生人数 虚拟主键 */
    @Excel(name = "学生人数")
    private String studentNum;

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
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
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
    public void setStorey(String storey) 
    {
        this.storey = storey;
    }

    public String getStorey() 
    {
        return storey;
    }
    public void setBuildId(Long buildId) 
    {
        this.buildId = buildId;
    }

    public Long getBuildId() 
    {
        return buildId;
    }
    public void setIsdelete(String isdelete) 
    {
        this.isdelete = isdelete;
    }

    public String getIsdelete() 
    {
        return isdelete;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setLiveNum(String liveNum) 
    {
        this.liveNum = liveNum;
    }

    public String getLiveNum() 
    {
        return liveNum;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    

    public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("num", getNum())
            .append("createdate", getCreatedate())
            .append("updatedate", getUpdatedate())
            .append("storey", getStorey())
            .append("buildId", getBuildId())
            .append("isdelete", getIsdelete())
            .append("position", getPosition())
            .append("liveNum", getLiveNum())
            .append("money", getMoney())
            .toString();
    }
}
