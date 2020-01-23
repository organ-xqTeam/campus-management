package com.ruoyi.project.system.schoolmobilearticle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 通知公告对象 schoolmobilearticle
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
public class Schoolmobilearticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章类型 */
    @Excel(name = "文章类型")
    private String type;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String file;

    /** 图片名 */
    @Excel(name = "图片名")
    private String filename;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
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
            .append("title", getTitle())
            .append("type", getType())
            .append("content", getContent())
            .append("file", getFile())
            .append("filename", getFilename())
            .append("createdate", getCreatedate())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
