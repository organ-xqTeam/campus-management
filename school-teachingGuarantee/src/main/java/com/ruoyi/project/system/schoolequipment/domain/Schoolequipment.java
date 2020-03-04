package com.ruoyi.project.system.schoolequipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备报修对象 schoolequipment
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class Schoolequipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String num;

    /** 报修类型 */
    @Excel(name = "报修类型")
    private String type;

    /** 报修部门 */
    @Excel(name = "报修部门")
    private String department;

    /** 报修人 */
    @Excel(name = "报修人")
    private String repairman;

    /** 报修地点 */
    @Excel(name = "报修地点")
    private String repairplace;

    /** 报修时间 */
    @Excel(name = "报修时间")
    private String repairtime;

    /** 故障说明 */
    @Excel(name = "故障说明")
    private String remark0;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String state;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String deleteFlag;
    
    private String createDate;
    
    

    public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setRepairman(String repairman) 
    {
        this.repairman = repairman;
    }

    public String getRepairman() 
    {
        return repairman;
    }
    public void setRepairplace(String repairplace) 
    {
        this.repairplace = repairplace;
    }

    public String getRepairplace() 
    {
        return repairplace;
    }
    public void setRepairtime(String repairtime) 
    {
        this.repairtime = repairtime;
    }

    public String getRepairtime() 
    {
        return repairtime;
    }
    public void setRemark0(String remark0) 
    {
        this.remark0 = remark0;
    }

    public String getRemark0() 
    {
        return remark0;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
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
            .append("num", getNum())
            .append("type", getType())
            .append("department", getDepartment())
            .append("repairman", getRepairman())
            .append("repairplace", getRepairplace())
            .append("repairtime", getRepairtime())
            .append("remark0", getRemark0())
            .append("state", getState())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
