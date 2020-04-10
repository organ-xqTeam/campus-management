package com.ruoyi.project.system.userpraise.service;

import com.ruoyi.project.system.userpraise.domain.Userpraise;

public interface IUserpraiseService {
	//点赞
	public int insertUserPraise(Userpraise up);
	//取消点赞
	public int cancelUserPraise(Userpraise up);
}
