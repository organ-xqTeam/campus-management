package com.ruoyi.project.system.examAdInformation.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 广告的表 exam_ad_information
 * 
 * @author ruoyi
 * @date 2019-10-23
 */
public class ExamAdInformation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Long id;
	/** 广告分类 */
	private String adclassification;
	/** 答题结果分类id */
	private String classificationid;
	/** 广告位类型 */
	private String spotType;
	/** 广告位大小 */
	private String spotSize;
	/** 图像img */
	private String imageBase;
	/** 图像跳转地址 */
	private String imageUrl;
	/** 创建时间 */
	private Date createAt;
	/** 更新时间 */
	private Date updateAt;
	/** 删除标记 0:正常;1:删除 */
	private Integer delFlag;
	/** 是否维修中 */
	private String isRepair;
	/** 是否空闲 */
	private String isBusy;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setAdclassification(String adclassification) 
	{
		this.adclassification = adclassification;
	}

	public String getAdclassification() 
	{
		return adclassification;
	}
	public void setClassificationid(String classificationid) 
	{
		this.classificationid = classificationid;
	}

	public String getClassificationid() 
	{
		return classificationid;
	}
	public void setSpotType(String spotType) 
	{
		this.spotType = spotType;
	}

	public String getSpotType() 
	{
		return spotType;
	}
	public void setSpotSize(String spotSize) 
	{
		this.spotSize = spotSize;
	}

	public String getSpotSize() 
	{
		return spotSize;
	}
	public void setImageBase(String imageBase) 
	{
		this.imageBase = imageBase;
	}

	public String getImageBase() 
	{
		return imageBase;
	}
	public void setImageUrl(String imageUrl) 
	{
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() 
	{
		return imageUrl;
	}
	public void setCreateAt(Date createAt) 
	{
		this.createAt = createAt;
	}

	public Date getCreateAt() 
	{
		return createAt;
	}
	public void setUpdateAt(Date updateAt) 
	{
		this.updateAt = updateAt;
	}

	public Date getUpdateAt() 
	{
		return updateAt;
	}
	public void setDelFlag(Integer delFlag) 
	{
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() 
	{
		return delFlag;
	}
	public void setIsRepair(String isRepair) 
	{
		this.isRepair = isRepair;
	}

	public String getIsRepair() 
	{
		return isRepair;
	}
	public void setIsBusy(String isBusy) 
	{
		this.isBusy = isBusy;
	}

	public String getIsBusy() 
	{
		return isBusy;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("adclassification", getAdclassification())
            .append("classificationid", getClassificationid())
            .append("spotType", getSpotType())
            .append("spotSize", getSpotSize())
            .append("imageBase", getImageBase())
            .append("imageUrl", getImageUrl())
            .append("createAt", getCreateAt())
            .append("createBy", getCreateBy())
            .append("updateAt", getUpdateAt())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("isRepair", getIsRepair())
            .append("isBusy", getIsBusy())
            .toString();
    }
}
