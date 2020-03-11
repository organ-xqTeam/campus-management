package com.ruoyi.project.system.schoolcoursewareinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课件列对象 schoolcoursewareinfo
 * 
 * @author ruoyi
 * @date 2020-03-10
 */
public class Schoolcoursewareinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 序号 */
    @Excel(name = "序号")
    private String num;

    /** 课件名称 */
    @Excel(name = "课件名称")
    private String name;

    /** 课间时间 */
    @Excel(name = "课间时间")
    private String ctime;

    /** 课件介绍 */
    @Excel(name = "课件介绍")
    private String jieshao;

    /** 课件价格 */
    @Excel(name = "课件价格")
    private String price;

    /** 任课老师 */
    @Excel(name = "任课老师")
    private String teacherid;

    /** 课件视频 */
    @Excel(name = "课件视频")
    private String file;

    /** null */
    @Excel(name = "null")
    private String filename;

    /** 播放统计 */
    @Excel(name = "播放统计")
    private String showcontent;

    /** 评价信息 */
    @Excel(name = "评价信息")
    private String pingjia;
    private String teachername;
    
    

    public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCtime(String ctime) 
    {
        this.ctime = ctime;
    }

    public String getCtime() 
    {
        return ctime;
    }
    public void setJieshao(String jieshao) 
    {
        this.jieshao = jieshao;
    }

    public String getJieshao() 
    {
        return jieshao;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }
    public void setTeacherid(String teacherid) 
    {
        this.teacherid = teacherid;
    }

    public String getTeacherid() 
    {
        return teacherid;
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
    public void setShowcontent(String showcontent) 
    {
        this.showcontent = showcontent;
    }

    public String getShowcontent() 
    {
        return showcontent;
    }
    public void setPingjia(String pingjia) 
    {
        this.pingjia = pingjia;
    }

    public String getPingjia() 
    {
        return pingjia;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("num", getNum())
            .append("name", getName())
            .append("ctime", getCtime())
            .append("jieshao", getJieshao())
            .append("price", getPrice())
            .append("teacherid", getTeacherid())
            .append("file", getFile())
            .append("filename", getFilename())
            .append("showcontent", getShowcontent())
            .append("pingjia", getPingjia())
            .toString();
    }
}
