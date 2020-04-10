package com.ruoyi.project.system.userpraise.mapper;

import com.ruoyi.project.system.userpraise.domain.Userpraise;

public interface UserpraiseMapper {
	
	//点赞
	public int insertUserPraise(Userpraise up);
	//取消点赞
	public int cancelUserPraise(Userpraise up);
		
}
