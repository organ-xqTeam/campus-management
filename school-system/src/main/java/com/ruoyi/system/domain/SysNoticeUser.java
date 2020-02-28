package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class SysNoticeUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private String userid;
    private String noticeid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}
}
