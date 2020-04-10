package com.ruoyi.project.system.userpraise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.userpraise.domain.Userpraise;
import com.ruoyi.project.system.userpraise.mapper.UserpraiseMapper;
import com.ruoyi.project.system.userpraise.service.IUserpraiseService;

@Service
public class UserpraiseService implements IUserpraiseService {

	@Autowired
    private UserpraiseMapper userpraiseMapper;

	@Override
	public int insertUserPraise(Userpraise up) {
		// TODO Auto-generated method stub
		return userpraiseMapper.insertUserPraise(up);
	}

	@Override
	public int cancelUserPraise(Userpraise up) {
		// TODO Auto-generated method stub
		return userpraiseMapper.cancelUserPraise(up);
	}
	
}
