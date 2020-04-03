package com.ruoyi.project.system.usercollection.service;

import com.ruoyi.project.system.usercollection.domain.Usercollection;

public interface IUsercollectionSercice {
	//收藏
	public int insertUsercollection(Usercollection uc);
	//取消收藏
	public int updateUsercollection(Usercollection uc);
}
