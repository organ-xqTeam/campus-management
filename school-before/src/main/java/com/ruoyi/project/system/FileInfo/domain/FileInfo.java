package com.ruoyi.project.system.FileInfo.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class FileInfo extends BaseEntity {

	private int fileId;
	
	private String fileName;
	
	private String filePath;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
