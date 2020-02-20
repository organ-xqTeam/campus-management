package com.ruoyi.project.system.schooloutofclass.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课外读物对象 schooloutofclass
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public class Schooloutofclass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 班级id */
    @Excel(name = "班级id")
    private Long classid;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String name;
    
    private String type;

    /** 简介 */
    @Excel(name = "简介")
    private String brief;

    /** 上传时间 */
    @Excel(name = "上传时间")
    private String uploadtime;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String file;

    /** 文件名 */
    @Excel(name = "文件名")
    private String filename;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String deleteFlag;

    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setClassid(Long classid) 
    {
        this.classid = classid;
    }

    public Long getClassid() 
    {
        return classid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setBrief(String brief) 
    {
        this.brief = brief;
    }

    public String getBrief() 
    {
        return brief;
    }
    public void setUploadtime(String uploadtime) 
    {
        this.uploadtime = uploadtime;
    }

    public String getUploadtime() 
    {
        return uploadtime;
    }
    public void setFile(String file) 
    {
        this.file = file;
    }

    public String getFile() 
    {
        return file;
    }
    public void setFilename(String filename) 
    {
        this.filename = filename;
    }

    public String getFilename() 
    {
        return filename;
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
            .append("classid", getClassid())
            .append("name", getName())
            .append("brief", getBrief())
            .append("uploadtime", getUploadtime())
            .append("file", getFile())
            .append("filename", getFilename())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
