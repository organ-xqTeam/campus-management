package com.ruoyi.project.app;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.FontText;
import com.ruoyi.common.utils.drawImg;
import com.ruoyi.project.system.schoolResultDetail.service.ISchoolResultDetailService;
import com.ruoyi.project.system.schoolstudentslist.domain.Schoolstudentslist;
import com.ruoyi.project.system.schoolstudentslist.service.ISchoolstudentslistService;

@CrossOrigin
@Controller
@RequestMapping("/ajax/app/resultDetail")
public class AppResultDetailController extends BaseController {

	@Autowired
	private ISchoolResultDetailService schoolResultDetailService;

	@Autowired
	private ISchoolstudentslistService schoolstudentslistService;

	// 获取成绩列表
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(int pageNum, int pageSize, String studentid) {
		PageHelper.startPage(pageNum, pageSize, null);
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("studentid", studentid);
		List<Map<String, Object>> list = schoolResultDetailService.selectstudentresultlist(parmMap);
		return getDataTable(list);
	}

	// 获取证书
	@PostMapping("/graduation/{userid}")
	@ResponseBody
	public void graduation(@PathVariable("userid") String userid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		response.setCharacterEncoding("utf-8");
		String fileName = "certificate.jpg";
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		Schoolstudentslist sinformaction = schoolstudentslistService
				.selectSchoolstudentslistById(Long.parseLong(userid));
		FontText text = new FontText(sinformaction.getStudentsName(), 1, "#CC2BAC", 25, "黑体");
		String filePath = path + "static/img/inimg03.jpg";
		BufferedImage imgsg = drawImg.drawInImgs(filePath, text);
		ServletOutputStream out = response.getOutputStream();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(imgsg, "jpg", byteArrayOutputStream);
		byteArrayOutputStream.flush();
		byte[] byteArray = byteArrayOutputStream.toByteArray();
		out.write(byteArray);
		out.flush();
		out.close();
	}

}
