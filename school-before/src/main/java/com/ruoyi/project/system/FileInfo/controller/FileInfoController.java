package com.ruoyi.project.system.FileInfo.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.FileInfo.domain.FileInfo;

@Controller
@RequestMapping("/system/fileinfo")
public class FileInfoController extends BaseController {

//	@Autowired
//	private IFileInfoService fileInfoService;
	
	@PostMapping("/add")
	@ResponseBody
	public JSONObject addSave(@RequestParam("file") MultipartFile file, FileInfo fileInfo) throws IOException
	{
		JSONObject result = new JSONObject();
//		 上传文件路径
		String filePath_ = RuoYiConfig.getUploadPath();
//		 上传并返回新文件名称
		String filePath = FileUploadUtils.upload(filePath_, file);
		fileInfo.setFilePath(filePath);
		fileInfo.setFileName(file.getOriginalFilename());
		result.put("file", fileInfo);
		return result;
	}

}
