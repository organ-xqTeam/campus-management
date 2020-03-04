package com.ruoyi.project.system.TeachingInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师管理对象 teaching_info
 * 
 * @author ruoyi
 * @date 2019-11-22
 */
public class TeachingInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 师资编号 */
    @Excel(name = "师资编号")
    private String teacherId;

    /** 性别 */
    @Excel(name = "性别", readConverterExp = "0=女,1=男")
    private String gendername;

    /** 生日 */
    @Excel(name = "生日")
    private String birthday;

    /** 入职时间 */
    @Excel(name = "入职时间")
    private String entryDate;

    /** 授课年数 */
    @Excel(name = "授课年数")
    private String teachYears;

    /** 证书编号 */
    @Excel(name = "证书编号")
    private String certificateId;

    /** 授课类别范围 */
    @Excel(name = "授课类别范围")
    private String classScope;

    @Excel(name = "师资分类", readConverterExp = "1=自有师资,2=内训师资,3=外部专家")
    private String classificationTeachers;

    /** 认证信息 */
    @Excel(name = "认证信息")
    private String authenticationInformation;

    /** 认证时间 */
    @Excel(name = "认证时间")
    private String authenticationDate;

    /** 认证等级 */
    @Excel(name = "认证等级")
    private String certificationGrade;

    /** 认证照片 */
//    @Excel(name = "认证照片")
    private String certificationImage;

    /** 师资备注 */
    @Excel(name = "师资备注")
    private String remarksTeachers;

    /** 专业方向 */
    @Excel(name = "专业方向")
    private String professionalDirection;

    /** 科研成果 */
    @Excel(name = "科研成果")
    private String scientificResearch;

    /** 专题信息 */
    @Excel(name = "专题信息")
    private String thematicInformation;

    /** 教学情况 */
    @Excel(name = "教学情况")
    private String teachingSituation;

    /** 教学反馈意见 */
    @Excel(name = "教学反馈意见")
    private String teachingFeedback;

    /** 反馈意见 */
    @Excel(name = "反馈意见")
    private String feedbackOpinion;

    /** 证书编号name */
    @Excel(name = "证书编号name")
    private String certificateName;

    /** 认证照片名 */
//    @Excel(name = "认证照片名")
    private String certificationName;

    /** 认证状态 */
    @Excel(name = "认证状态")
    private String certificationState;

    /** 创建时间 */
//    @Excel(name = "创建时间")
    private String createtime1;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 是否删除 */
//    @Excel(name = "是否删除")
    private String isdelete;

    /** 分析报告 */
//    @Excel(name = "分析报告")
    private String analysisReport;

    /** null */
//    @Excel(name = "null")
    private String teachPlace;

    /** 教师名称 */
    @Excel(name = "教师名称")
    private String teachingName;

    /** 科目 */
    @Excel(name = "科目")
    private String subjectName;

    /** 是否班主任 */
//    @Excel(name = "是否班主任")
    private String isheadteacher;

    /** 累计课时 */
    @Excel(name = "累计课时")
    private String cumulativeClassHours;

    /** 职称 */
    @Excel(name = "职称")
    private String jobTitle;

    /** 档案所在地 */
    @Excel(name = "档案所在地")
    private String fileLocation;

    /** 教学记录 */
    @Excel(name = "教学记录")
    private String teachingRecord;

    /** 备注 */
    @Excel(name = "身份证号码")
    private String remark1;

    /** 备注 */
    @Excel(name = "部门")
    private String remark2;

    /** 备注 */
    @Excel(name = "岗位")
    private String remark3;

    /** 备注 */
    @Excel(name = "手机号码")
    private String remark4;

    /** 备注 */
    @Excel(name = "办公电话")
    private String remark5;

    /** 备注 */
    @Excel(name = "邮编")
    private String remark6;

    /** 备注 */
    @Excel(name = "通讯地址")
    private String remark7;

    /** 备注 */
    @Excel(name = "住址")
    private String remark8;

    /** 备注 */
    @Excel(name = "紧急联系人姓名")
    private String remark9;

    /** 备注 */
    @Excel(name = "紧急联系人电话")
    private String remark10;

    /** 备注 */
    @Excel(name = "教学计划")
    private String remark11;

    /** 备注 */
    @Excel(name = "证书名称")
    private String remark12;

    /** 备注 */
    @Excel(name = "电子邮件")
    private String remark13;

    /** 备注 */
//    @Excel(name = "备注")
    private String remark14;

    /** 备注 */
//    @Excel(name = "备注")
    private String remark15;

    /** 备注 */
//    @Excel(name = "备注")
    private String remark16;

    /** 备注 */
//    @Excel(name = "备注")
    private String remark17;

    /** 删除标记 0:正常;1:删除 */
    private Long delFlag;

    /** 部门表的别名 */
//    @Excel(name = "部门表的别名")
    private String deptalias;

    /** 用户表的别名 */
//    @Excel(name = "用户表的别名")
    private String useralias;
    
    
    private Long userId;

    private String createDate;
    
    
    public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeacherId(String teacherId) 
    {
        this.teacherId = teacherId;
    }

    public String getTeacherId() 
    {
        return teacherId;
    }
    public void setGendername(String gendername) 
    {
        this.gendername = gendername;
    }

    public String getGendername() 
    {
        return gendername;
    }
    public void setBirthday(String birthday) 
    {
        this.birthday = birthday;
    }

    public String getBirthday() 
    {
        return birthday;
    }
    public void setEntryDate(String entryDate) 
    {
        this.entryDate = entryDate;
    }

    public String getEntryDate() 
    {
        return entryDate;
    }
    public void setTeachYears(String teachYears) 
    {
        this.teachYears = teachYears;
    }

    public String getTeachYears() 
    {
        return teachYears;
    }
    public void setCertificateId(String certificateId) 
    {
        this.certificateId = certificateId;
    }

    public String getCertificateId() 
    {
        return certificateId;
    }
    public void setClassScope(String classScope) 
    {
        this.classScope = classScope;
    }

    public String getClassScope() 
    {
        return classScope;
    }
    public void setClassificationTeachers(String classificationTeachers) 
    {
        this.classificationTeachers = classificationTeachers;
    }

    public String getClassificationTeachers() 
    {
        return classificationTeachers;
    }
    public void setAuthenticationInformation(String authenticationInformation) 
    {
        this.authenticationInformation = authenticationInformation;
    }

    public String getAuthenticationInformation() 
    {
        return authenticationInformation;
    }
    public void setAuthenticationDate(String authenticationDate) 
    {
        this.authenticationDate = authenticationDate;
    }

    public String getAuthenticationDate() 
    {
        return authenticationDate;
    }
    public void setCertificationGrade(String certificationGrade) 
    {
        this.certificationGrade = certificationGrade;
    }

    public String getCertificationGrade() 
    {
        return certificationGrade;
    }
    public void setCertificationImage(String certificationImage) 
    {
        this.certificationImage = certificationImage;
    }

    public String getCertificationImage() 
    {
        return certificationImage;
    }
    public void setRemarksTeachers(String remarksTeachers) 
    {
        this.remarksTeachers = remarksTeachers;
    }

    public String getRemarksTeachers() 
    {
        return remarksTeachers;
    }
    public void setProfessionalDirection(String professionalDirection) 
    {
        this.professionalDirection = professionalDirection;
    }

    public String getProfessionalDirection() 
    {
        return professionalDirection;
    }
    public void setScientificResearch(String scientificResearch) 
    {
        this.scientificResearch = scientificResearch;
    }

    public String getScientificResearch() 
    {
        return scientificResearch;
    }
    public void setThematicInformation(String thematicInformation) 
    {
        this.thematicInformation = thematicInformation;
    }

    public String getThematicInformation() 
    {
        return thematicInformation;
    }
    public void setTeachingSituation(String teachingSituation) 
    {
        this.teachingSituation = teachingSituation;
    }

    public String getTeachingSituation() 
    {
        return teachingSituation;
    }
    public void setTeachingFeedback(String teachingFeedback) 
    {
        this.teachingFeedback = teachingFeedback;
    }

    public String getTeachingFeedback() 
    {
        return teachingFeedback;
    }
    public void setFeedbackOpinion(String feedbackOpinion) 
    {
        this.feedbackOpinion = feedbackOpinion;
    }

    public String getFeedbackOpinion() 
    {
        return feedbackOpinion;
    }
    public void setCertificateName(String certificateName) 
    {
        this.certificateName = certificateName;
    }

    public String getCertificateName() 
    {
        return certificateName;
    }
    public void setCertificationName(String certificationName) 
    {
        this.certificationName = certificationName;
    }

    public String getCertificationName() 
    {
        return certificationName;
    }
    public void setCertificationState(String certificationState) 
    {
        this.certificationState = certificationState;
    }

    public String getCertificationState() 
    {
        return certificationState;
    }
    public void setCreatetime1(String createtime1) 
    {
        this.createtime1 = createtime1;
    }

    public String getCreatetime1() 
    {
        return createtime1;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setIsdelete(String isdelete) 
    {
        this.isdelete = isdelete;
    }

    public String getIsdelete() 
    {
        return isdelete;
    }
    public void setAnalysisReport(String analysisReport) 
    {
        this.analysisReport = analysisReport;
    }

    public String getAnalysisReport() 
    {
        return analysisReport;
    }
    public void setTeachPlace(String teachPlace) 
    {
        this.teachPlace = teachPlace;
    }

    public String getTeachPlace() 
    {
        return teachPlace;
    }
    public void setTeachingName(String teachingName) 
    {
        this.teachingName = teachingName;
    }

    public String getTeachingName() 
    {
        return teachingName;
    }
    public void setSubjectName(String subjectName) 
    {
        this.subjectName = subjectName;
    }

    public String getSubjectName() 
    {
        return subjectName;
    }
    public void setIsheadteacher(String isheadteacher) 
    {
        this.isheadteacher = isheadteacher;
    }

    public String getIsheadteacher() 
    {
        return isheadteacher;
    }
    public void setCumulativeClassHours(String cumulativeClassHours) 
    {
        this.cumulativeClassHours = cumulativeClassHours;
    }

    public String getCumulativeClassHours() 
    {
        return cumulativeClassHours;
    }
    public void setJobTitle(String jobTitle) 
    {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() 
    {
        return jobTitle;
    }
    public void setFileLocation(String fileLocation) 
    {
        this.fileLocation = fileLocation;
    }

    public String getFileLocation() 
    {
        return fileLocation;
    }
    public void setTeachingRecord(String teachingRecord) 
    {
        this.teachingRecord = teachingRecord;
    }

    public String getTeachingRecord() 
    {
        return teachingRecord;
    }
    public void setRemark1(String remark1) 
    {
        this.remark1 = remark1;
    }

    public String getRemark1() 
    {
        return remark1;
    }
    public void setRemark2(String remark2) 
    {
        this.remark2 = remark2;
    }

    public String getRemark2() 
    {
        return remark2;
    }
    public void setRemark3(String remark3) 
    {
        this.remark3 = remark3;
    }

    public String getRemark3() 
    {
        return remark3;
    }
    public void setRemark4(String remark4) 
    {
        this.remark4 = remark4;
    }

    public String getRemark4() 
    {
        return remark4;
    }
    public void setRemark5(String remark5) 
    {
        this.remark5 = remark5;
    }

    public String getRemark5() 
    {
        return remark5;
    }
    public void setRemark6(String remark6) 
    {
        this.remark6 = remark6;
    }

    public String getRemark6() 
    {
        return remark6;
    }
    public void setRemark7(String remark7) 
    {
        this.remark7 = remark7;
    }

    public String getRemark7() 
    {
        return remark7;
    }
    public void setRemark8(String remark8) 
    {
        this.remark8 = remark8;
    }

    public String getRemark8() 
    {
        return remark8;
    }
    public void setRemark9(String remark9) 
    {
        this.remark9 = remark9;
    }

    public String getRemark9() 
    {
        return remark9;
    }
    public void setRemark10(String remark10) 
    {
        this.remark10 = remark10;
    }

    public String getRemark10() 
    {
        return remark10;
    }
    public void setRemark11(String remark11) 
    {
        this.remark11 = remark11;
    }

    public String getRemark11() 
    {
        return remark11;
    }
    public void setRemark12(String remark12) 
    {
        this.remark12 = remark12;
    }

    public String getRemark12() 
    {
        return remark12;
    }
    public void setRemark13(String remark13) 
    {
        this.remark13 = remark13;
    }

    public String getRemark13() 
    {
        return remark13;
    }
    public void setRemark14(String remark14) 
    {
        this.remark14 = remark14;
    }

    public String getRemark14() 
    {
        return remark14;
    }
    public void setRemark15(String remark15) 
    {
        this.remark15 = remark15;
    }

    public String getRemark15() 
    {
        return remark15;
    }
    public void setRemark16(String remark16) 
    {
        this.remark16 = remark16;
    }

    public String getRemark16() 
    {
        return remark16;
    }
    public void setRemark17(String remark17) 
    {
        this.remark17 = remark17;
    }

    public String getRemark17() 
    {
        return remark17;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setDeptalias(String deptalias) 
    {
        this.deptalias = deptalias;
    }

    public String getDeptalias() 
    {
        return deptalias;
    }
    public void setUseralias(String useralias) 
    {
        this.useralias = useralias;
    }

    public String getUseralias() 
    {
        return useralias;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherId", getTeacherId())
            .append("gendername", getGendername())
            .append("birthday", getBirthday())
            .append("entryDate", getEntryDate())
            .append("teachYears", getTeachYears())
            .append("certificateId", getCertificateId())
            .append("classScope", getClassScope())
            .append("classificationTeachers", getClassificationTeachers())
            .append("authenticationInformation", getAuthenticationInformation())
            .append("authenticationDate", getAuthenticationDate())
            .append("certificationGrade", getCertificationGrade())
            .append("certificationImage", getCertificationImage())
            .append("remarksTeachers", getRemarksTeachers())
            .append("professionalDirection", getProfessionalDirection())
            .append("scientificResearch", getScientificResearch())
            .append("thematicInformation", getThematicInformation())
            .append("teachingSituation", getTeachingSituation())
            .append("teachingFeedback", getTeachingFeedback())
            .append("feedbackOpinion", getFeedbackOpinion())
            .append("certificateName", getCertificateName())
            .append("certificationName", getCertificationName())
            .append("certificationState", getCertificationState())
            .append("createtime1", getCreatetime1())
            .append("remarks", getRemarks())
            .append("isdelete", getIsdelete())
            .append("analysisReport", getAnalysisReport())
            .append("teachPlace", getTeachPlace())
            .append("teachingName", getTeachingName())
            .append("subjectName", getSubjectName())
            .append("isheadteacher", getIsheadteacher())
            .append("cumulativeClassHours", getCumulativeClassHours())
            .append("jobTitle", getJobTitle())
            .append("fileLocation", getFileLocation())
            .append("teachingRecord", getTeachingRecord())
            .append("remark", getRemark())
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .append("remark7", getRemark7())
            .append("remark8", getRemark8())
            .append("remark9", getRemark9())
            .append("remark10", getRemark10())
            .append("remark11", getRemark11())
            .append("remark12", getRemark12())
            .append("remark13", getRemark13())
            .append("remark14", getRemark14())
            .append("remark15", getRemark15())
            .append("remark16", getRemark16())
            .append("remark17", getRemark17())
            .append("delFlag", getDelFlag())
            .append("deptalias", getDeptalias())
            .append("useralias", getUseralias())
            .toString();
    }
}
