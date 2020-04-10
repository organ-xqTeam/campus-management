package com.ruoyi.project.system.userpraise.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class Userpraise extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String userid;
    private String praiseid;
    private String type;
    private String usertype;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPraiseid() {
		return praiseid;
	}
	public void setPraiseid(String praiseid) {
		this.praiseid = praiseid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
    
}
