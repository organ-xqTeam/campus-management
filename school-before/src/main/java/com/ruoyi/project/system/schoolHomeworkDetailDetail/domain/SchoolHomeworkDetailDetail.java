package com.ruoyi.project.system.schoolHomeworkDetailDetail.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class SchoolHomeworkDetailDetail extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
    private Long id;
    
    //school_homework_detail   id
    private String detailid;
    //学生id
    private String studentid;
    //作业提交时间
    private String submittime;
    //是否合格1是0否
    private String ontest;
    //作业
    private String file;
    
    private String filename;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDetailid() {
		return detailid;
	}
	public void setDetailid(String detailid) {
		this.detailid = detailid;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getSubmittime() {
		return submittime;
	}
	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}
	public String getOntest() {
		return ontest;
	}
	public void setOntest(String ontest) {
		this.ontest = ontest;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
    
}
