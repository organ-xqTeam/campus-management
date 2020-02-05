package com.ruoyi.project.system.FileInfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.FileInfo.domain.FileInfo;
import com.ruoyi.project.system.FileInfo.mapper.FileInfoMapper;
import com.ruoyi.project.system.FileInfo.service.IFileInfoService;

@Service
public class FileInfoServiceImpl implements IFileInfoService { 

	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Override
	public int insertFileInfo(FileInfo fileInfo) {
		return fileInfoMapper.insertFileInfo(fileInfo);
	}
	
}
