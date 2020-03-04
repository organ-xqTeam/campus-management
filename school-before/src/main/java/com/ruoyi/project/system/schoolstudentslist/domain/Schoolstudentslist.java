package com.ruoyi.project.system.schoolstudentslist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生列对象 schoolstudentslist
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public class Schoolstudentslist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生id */
    //@Excel(name = "学生id")
    private String studentsId;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String studentsName;

    /** 性别 */
    @Excel(name = "用户性别", readConverterExp = "0=女,1=男")
    private String gender;
    
    @Excel(name = "年级")
    private String nianji;
    
    public String getNianji() {
		return nianji;
	}
	public void setNianji(String nianji) {
		this.nianji = nianji;
	}

	/** 出生年月 */
    @Excel(name = "生日")
    private String birth;
    
    /** 民族 */
    @Excel(name = "民族")
    private String nation;
    
    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnum;
    
    /** 是否有拒签历史 */
    @Excel(name = "是否有拒签历史", readConverterExp = "0=否,1=是")
    private String isrefuse;
    
    /** 审批状态 */
    @Excel(name = "审批状态", readConverterExp = "1=未审批,2=通过,3=驳回")
    private String approvalstate;

    /** 学级 */
//    @Excel(name = "学级")
    private String academicLevel;

    /** 父亲名称 */
    @Excel(name = "父亲名称")
    private String fatherName;

    /** 父亲电话号 */
    @Excel(name = "父亲电话号")
    private String fatherPhone;

    /** 母亲名称 */
    @Excel(name = "母亲名称")
    private String motherName;

    /** 母亲电话号 */
    @Excel(name = "母亲电话号")
    private String motherPhone;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String homeAddress;

    /** 备注 */
    @Excel(name = "备注")
    private String Remarks;

    /** 年龄 */
    //@Excel(name = "年龄")
    private String ages;

    /** 入学时间 */
    @Excel(name = "入学时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String admissionTime;

    /** 状态 */
    @Excel(name = "学籍状态", readConverterExp = "1=未注册学籍,2=注册学籍,3=已离校,4=保留学籍")
    private String State;

    /** 备注 */
    @Excel(name = "毕业高中")
    private String remark1;

    /** 备注 */
    @Excel(name = "高考省份")
    private String remark2;

    /** 备注 */
    @Excel(name = "选择成绩类型")
    private String remark3;

    /** 备注 */
    @Excel(name = "总分")
    private String remark4;

    /** 备注 */
    @Excel(name = "英语单科")
    private String remark5;

    /** 备注 */
    @Excel(name = "预选班级")
    private String remark6;

    /** 备注 */
    @Excel(name = "联系方式")
    private String remark7;

    /** 备注 */
    @Excel(name = "联系地址")
    private String remark8;

    /** 备注 */
    @Excel(name = "户口所在地")
    private String remark9;

    /** 备注 */
    @Excel(name = "政治面貌")
    private String remark10;

    /** 备注 */
    @Excel(name = "通讯地址")
    private String remark11;

    /** 备注 */
    @Excel(name = "邮编")
    private String remark12;

    /** 备注 */
    @Excel(name = "是否少数民族", readConverterExp = "1=是,0=否")
    private String remark13;

    /** 备注 */
    @Excel(name = "是否招生", readConverterExp = "1=是,0=否")
    private String remark14;

    /** 备注 */
    @Excel(name = "高考成绩")
    private String remark15;

    /** 备注 */
    @Excel(name = "会考成绩")
    private String remark16;

    /** 备注 */
    @Excel(name = "模考成绩")
    private String remark17;
    @Excel(name = "监护人姓名")
    private String remark18;
    @Excel(name = "监护人与学生关系")
    private String remark19;
    @Excel(name = "监护人联系手机")
    private String remark20;
    @Excel(name = "电子邮件")
    private String remark21;
    @Excel(name = "数学单科成绩")
    private String remark22;
    @Excel(name = "报名时间")
    private String remark23;
    @Excel(name = "录取时间")
    private String remark24;
//    @Excel(name = "用户")
    private String remark25;

    @Excel(name = "紧急联系人姓名")
    private String remark26;
    @Excel(name = "紧急联系人电话")
    private String remark27;
    @Excel(name = "国籍")
    private String remark28;
    @Excel(name = "身高" , readConverterExp = "1=小于190,0=大于190")
    private String remark29;
    @Excel(name = "文化程度")
    private String remark30;
    @Excel(name = "传真号码")
    private String remark31;
    @Excel(name = "毕业高中的省")
    private String remark32;
    @Excel(name = "毕业高中的市")
    private String remark33;
    @Excel(name = "准考证号")
    private String remark34;
    @Excel(name = "报考类别" , readConverterExp = "1=文,2=理")
    private String remark35;
    @Excel(name = "雅思成绩")
    private String remark36;
    @Excel(name = "父亲工作单位")
    private String remark37;
    @Excel(name = "父亲职务")
    private String remark38;
    @Excel(name = "母亲工作单位")
    private String remark39;
    @Excel(name = "母亲职务")
    private String remark40;
    @Excel(name = "报考专业")
    private String remark41;
    @Excel(name = "调整专业")
    private String remark42;
    @Excel(name = "信息来源")
    private String remark43;
    @Excel(name = "联系手机")
    private String remark44;
    private String code;
    

    
    
    
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark44() {
		return remark44;
	}
	public void setRemark44(String remark44) {
		this.remark44 = remark44;
	}
	public String getRemark28() {
		return remark28;
	}
	public void setRemark28(String remark28) {
		this.remark28 = remark28;
	}
	public String getRemark29() {
		return remark29;
	}
	public void setRemark29(String remark29) {
		this.remark29 = remark29;
	}
	public String getRemark30() {
		return remark30;
	}
	public void setRemark30(String remark30) {
		this.remark30 = remark30;
	}
	public String getRemark31() {
		return remark31;
	}
	public void setRemark31(String remark31) {
		this.remark31 = remark31;
	}
	public String getRemark32() {
		return remark32;
	}
	public void setRemark32(String remark32) {
		this.remark32 = remark32;
	}
	public String getRemark33() {
		return remark33;
	}
	public void setRemark33(String remark33) {
		this.remark33 = remark33;
	}
	public String getRemark34() {
		return remark34;
	}
	public void setRemark34(String remark34) {
		this.remark34 = remark34;
	}
	public String getRemark35() {
		return remark35;
	}
	public void setRemark35(String remark35) {
		this.remark35 = remark35;
	}
	public String getRemark36() {
		return remark36;
	}
	public void setRemark36(String remark36) {
		this.remark36 = remark36;
	}
	public String getRemark37() {
		return remark37;
	}
	public void setRemark37(String remark37) {
		this.remark37 = remark37;
	}
	public String getRemark38() {
		return remark38;
	}
	public void setRemark38(String remark38) {
		this.remark38 = remark38;
	}
	public String getRemark39() {
		return remark39;
	}
	public void setRemark39(String remark39) {
		this.remark39 = remark39;
	}
	public String getRemark40() {
		return remark40;
	}
	public void setRemark40(String remark40) {
		this.remark40 = remark40;
	}
	public String getRemark41() {
		return remark41;
	}
	public void setRemark41(String remark41) {
		this.remark41 = remark41;
	}
	public String getRemark42() {
		return remark42;
	}
	public void setRemark42(String remark42) {
		this.remark42 = remark42;
	}
	public String getRemark43() {
		return remark43;
	}
	public void setRemark43(String remark43) {
		this.remark43 = remark43;
	}
	public String getRemark26() {
		return remark26;
	}
	public void setRemark26(String remark26) {
		this.remark26 = remark26;
	}
	public String getRemark27() {
		return remark27;
	}
	public void setRemark27(String remark27) {
		this.remark27 = remark27;
	}
	public String getRemark21() {
		return remark21;
	}
	public void setRemark21(String remark21) {
		this.remark21 = remark21;
	}
	public String getRemark22() {
		return remark22;
	}
	public void setRemark22(String remark22) {
		this.remark22 = remark22;
	}
	public String getRemark23() {
		return remark23;
	}
	public void setRemark23(String remark23) {
		this.remark23 = remark23;
	}
	public String getRemark24() {
		return remark24;
	}
	public void setRemark24(String remark24) {
		this.remark24 = remark24;
	}
	public String getRemark25() {
		return remark25;
	}
	public void setRemark25(String remark25) {
		this.remark25 = remark25;
	}
	public String getRemark18() {
		return remark18;
	}
	public void setRemark18(String remark18) {
		this.remark18 = remark18;
	}
	public String getRemark19() {
		return remark19;
	}
	public void setRemark19(String remark19) {
		this.remark19 = remark19;
	}
	public String getRemark20() {
		return remark20;
	}
	public void setRemark20(String remark20) {
		this.remark20 = remark20;
	}

	@Excel(name = "身份证号")
    private String cardnum;
    
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	@Excel(name = "报道状态", readConverterExp = "1=已报道,2=未报道")
    private String reportstate;
    @Excel(name = "未报到原因")
    private String notreportresult;
    @Excel(name = "缴费状态")
    private String paystate;
    @Excel(name = "是否注册", readConverterExp = "1=是,0=否")
    private String isregister;
    @Excel(name = "是否领取钥匙", readConverterExp = "1=是,0=否")
    private String isreceivekey;
    @Excel(name = "是否领取军训设备", readConverterExp = "1=是,0=否")
    private String isreceivejunxun;
    @Excel(name = "就业单位")
    private String company;
    @Excel(name = "就业情况审批状态")
    private String comapproval;
    @Excel(name = "工作岗位")
    private String post;
    @Excel(name = "工作情况")
    private String situation;

    @Excel(name = "图书馆办理信息", readConverterExp = "2=已办理,1=未办理")
    private String lixian1;
    @Excel(name = "财务处办理信息", readConverterExp = "2=已办理,1=未办理")
    private String lixian2;
    @Excel(name = "一卡通办理信息", readConverterExp = "2=已办理,1=未办理")
    private String lixian3;
    @Excel(name = "退宿办理信息", readConverterExp = "2=已办理,1=未办理")
    private String lixian4;
    @Excel(name = "组织关系转出", readConverterExp = "2=已办理,1=未办理")
    private String lixian5;
    @Excel(name = "户口转出信息", readConverterExp = "2=已办理,1=未办理")
    private String lixian6;
    @Excel(name = "毕业证发放信息", readConverterExp = "2=已办理,1=未办理")
    private String lixian7;
    
    
    
    public String getLixian1() {
		return lixian1;
	}
	public void setLixian1(String lixian1) {
		this.lixian1 = lixian1;
	}
	public String getLixian2() {
		return lixian2;
	}
	public void setLixian2(String lixian2) {
		this.lixian2 = lixian2;
	}
	public String getLixian3() {
		return lixian3;
	}
	public void setLixian3(String lixian3) {
		this.lixian3 = lixian3;
	}
	public String getLixian4() {
		return lixian4;
	}
	public void setLixian4(String lixian4) {
		this.lixian4 = lixian4;
	}
	public String getLixian5() {
		return lixian5;
	}
	public void setLixian5(String lixian5) {
		this.lixian5 = lixian5;
	}
	public String getLixian6() {
		return lixian6;
	}
	public void setLixian6(String lixian6) {
		this.lixian6 = lixian6;
	}
	public String getLixian7() {
		return lixian7;
	}
	public void setLixian7(String lixian7) {
		this.lixian7 = lixian7;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getComapproval() {
		return comapproval;
	}
	public void setComapproval(String comapproval) {
		this.comapproval = comapproval;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getReportstate() {
		return reportstate;
	}

	public void setReportstate(String reportstate) {
		this.reportstate = reportstate;
	}

	public String getNotreportresult() {
		return notreportresult;
	}

	public void setNotreportresult(String notreportresult) {
		this.notreportresult = notreportresult;
	}

	public String getPaystate() {
		return paystate;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	public String getIsregister() {
		return isregister;
	}

	public void setIsregister(String isregister) {
		this.isregister = isregister;
	}

	public String getIsreceivekey() {
		return isreceivekey;
	}

	public void setIsreceivekey(String isreceivekey) {
		this.isreceivekey = isreceivekey;
	}

	public String getIsreceivejunxun() {
		return isreceivejunxun;
	}

	public void setIsreceivejunxun(String isreceivejunxun) {
		this.isreceivejunxun = isreceivejunxun;
	}

	/** 删除标记 0:正常;1:删除 */
    private Long delFlag;

    /** 部门表的别名 */
    //@Excel(name = "部门表的别名")
    private String deptalias;

    /** 用户表的别名 */
    //@Excel(name = "用户表的别名")
    private String useralias;
    //@Excel(name = "年级id")
    private Long gradeId;
    //@Excel(name = "班级id")
    private Long classId;
    private String classId_;
    
    
    public String getClassId_() {
		return classId_;
	}
	public void setClassId_(String classId_) {
		this.classId_ = classId_;
	}

	private String leavetime;
    private Long userId;
    
    private String sbid;
    private String ssid;
    private String ydtime;
    private String ydreason;
    private String sbid_;
    private String ssid_;
    
    private String createDate;
    
    
    
    public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getSbid_() {
		return sbid_;
	}
	public void setSbid_(String sbid_) {
		this.sbid_ = sbid_;
	}
	public String getSsid_() {
		return ssid_;
	}
	public void setSsid_(String ssid_) {
		this.ssid_ = ssid_;
	}
	public String getYdtime() {
		return ydtime;
	}
	public void setYdtime(String ydtime) {
		this.ydtime = ydtime;
	}
	public String getYdreason() {
		return ydreason;
	}
	public void setYdreason(String ydreason) {
		this.ydreason = ydreason;
	}
	public String getSbid() {
		return sbid;
	}
	public void setSbid(String sbid) {
		this.sbid = sbid;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getIsrefuse() {
		return isrefuse;
	}

	public void setIsrefuse(String isrefuse) {
		this.isrefuse = isrefuse;
	}
	
	public String getApprovalstate() {
		return approvalstate;
	}

	public void setApprovalstate(String approvalstate) {
		this.approvalstate = approvalstate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentsId(String studentsId) 
    {
        this.studentsId = studentsId;
    }

    public String getStudentsId() 
    {
        return studentsId;
    }
    public void setStudentsName(String studentsName) 
    {
        this.studentsName = studentsName;
    }

    public String getStudentsName() 
    {
        return studentsName;
    }
    public void setAcademicLevel(String academicLevel) 
    {
        this.academicLevel = academicLevel;
    }

    public String getAcademicLevel() 
    {
        return academicLevel;
    }
    public void setFatherName(String fatherName) 
    {
        this.fatherName = fatherName;
    }

    public String getFatherName() 
    {
        return fatherName;
    }
    public void setFatherPhone(String fatherPhone) 
    {
        this.fatherPhone = fatherPhone;
    }

    public String getFatherPhone() 
    {
        return fatherPhone;
    }
    public void setMotherName(String motherName) 
    {
        this.motherName = motherName;
    }

    public String getMotherName() 
    {
        return motherName;
    }
    public void setMotherPhone(String motherPhone) 
    {
        this.motherPhone = motherPhone;
    }

    public String getMotherPhone() 
    {
        return motherPhone;
    }
    public void setHomeAddress(String homeAddress) 
    {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() 
    {
        return homeAddress;
    }
    public void setRemarks(String Remarks) 
    {
        this.Remarks = Remarks;
    }

    public String getRemarks() 
    {
        return Remarks;
    }
    public void setAges(String ages) 
    {
        this.ages = ages;
    }

    public String getAges() 
    {
        return ages;
    }
    public void setAdmissionTime(String admissionTime) 
    {
        this.admissionTime = admissionTime;
    }

    public String getAdmissionTime() 
    {
        return admissionTime;
    }
    public void setState(String State) 
    {
        this.State = State;
    }

    public String getState() 
    {
        return State;
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

    
    public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentsId", getStudentsId())
            .append("studentsName", getStudentsName())
            .append("academicLevel", getAcademicLevel())
            .append("fatherName", getFatherName())
            .append("fatherPhone", getFatherPhone())
            .append("motherName", getMotherName())
            .append("motherPhone", getMotherPhone())
            .append("homeAddress", getHomeAddress())
            .append("Remarks", getRemarks())
            .append("ages", getAges())
            .append("admissionTime", getAdmissionTime())
            .append("State", getState())
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
