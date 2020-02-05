package com.ruoyi.project.system.schoolteachingplanfilelist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教案文件对象 schoolteachingplanfilelist
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
public class Schoolteachingplanfilelist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 教案id */
    @Excel(name = "教案id")
    private Long teachingplanid;

    /** 教案编号 */
    @Excel(name = "教案编号")
    private String num;

    /** 教案名称 */
    @Excel(name = "教案名称")
    private String name;

    /** 文件id */
    @Excel(name = "文件id")
    private String file;

    /** 文件名 */
    @Excel(name = "文件名")
    private String filename;

    /** 删除标记 0:正常;1:删除 */
    private Long delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeachingplanid(Long teachingplanid) 
    {
        this.teachingplanid = teachingplanid;
    }

    public Long getTeachingplanid() 
    {
        return teachingplanid;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teachingplanid", getTeachingplanid())
            .append("num", getNum())
            .append("name", getName())
            .append("file", getFile())
            .append("filename", getFilename())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
