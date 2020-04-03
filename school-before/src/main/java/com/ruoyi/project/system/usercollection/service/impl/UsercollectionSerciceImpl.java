package com.ruoyi.project.system.usercollection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.usercollection.domain.Usercollection;
import com.ruoyi.project.system.usercollection.mapper.UsercollectionMapper;
import com.ruoyi.project.system.usercollection.service.IUsercollectionSercice;

@Service
public class UsercollectionSerciceImpl implements IUsercollectionSercice{

	@Autowired
    private UsercollectionMapper usercollectionMapper;
    
	@Override
	public int insertUsercollection(Usercollection uc) {
		// TODO Auto-generated method stub
		return usercollectionMapper.insertUsercollection(uc);
	}

	@Override
	public int updateUsercollection(Usercollection uc) {
		// TODO Auto-generated method stub
		return usercollectionMapper.updateUsercollection(uc);
	}

}
