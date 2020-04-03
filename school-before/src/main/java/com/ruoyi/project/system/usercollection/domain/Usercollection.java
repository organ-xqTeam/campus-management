package com.ruoyi.project.system.usercollection.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class Usercollection extends BaseEntity {
	
    private static final long serialVersionUID = 1L;
    
	private Long id;
	private String userid;
	private String collectionid;
	private String collectiontype;
	
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
	public String getCollectionid() {
		return collectionid;
	}
	public void setCollectionid(String collectionid) {
		this.collectionid = collectionid;
	}
	public String getCollectiontype() {
		return collectiontype;
	}
	public void setCollectiontype(String collectiontype) {
		this.collectiontype = collectiontype;
	}
	
}
