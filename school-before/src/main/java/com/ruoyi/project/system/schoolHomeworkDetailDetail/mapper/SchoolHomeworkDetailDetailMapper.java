package com.ruoyi.project.system.schoolHomeworkDetailDetail.mapper;

import com.ruoyi.project.system.schoolHomeworkDetailDetail.domain.SchoolHomeworkDetailDetail;

public interface SchoolHomeworkDetailDetailMapper {

	//修改作业情况
	int updateHomework(SchoolHomeworkDetailDetail detail);
	
	//提交作业
	int insertSchoolHomeworkDetail(SchoolHomeworkDetailDetail detail);
	
}
