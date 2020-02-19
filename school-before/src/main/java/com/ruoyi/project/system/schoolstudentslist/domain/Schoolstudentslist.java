package com.ruoyi.project.system.schoolstudentslist.domain;

import java.util.Date;

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
    private String gender;
    
    /** 出生年月 */
    private String birth;
    
    /** 民族 */
    private String nation;
    
    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnum;
    
    /** 是否有拒签历史 */
    private String isrefuse;
    
    /** 审批状态 */
    private String approvalstate;

    /** 学级 */
    //@Excel(name = "学级")
    private String academicLevel;

    /** 父亲名称 */
    //@Excel(name = "父亲名称")
    private String fatherName;

    /** 父亲电话号 */
    //@Excel(name = "父亲电话号")
    private String fatherPhone;

    /** 母亲名称 */
    //@Excel(name = "母亲名称")
    private String motherName;

    /** 母亲电话号 */
    //@Excel(name = "母亲电话号")
    private String motherPhone;

    /** 家庭住址 */
    //@Excel(name = "家庭住址")
    private String homeAddress;

    /** 备注 */
    //@Excel(name = "备注")
    private String Remarks;

    /** 年龄 */
    //@Excel(name = "年龄")
    private String ages;

    /** 入学时间 */
    //@Excel(name = "入学时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date admissionTime;

    /** 状态 */
    //@Excel(name = "状态")
    private String State;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark1;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark2;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark3;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark4;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark5;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark6;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark7;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark8;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark9;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark10;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark11;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark12;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark13;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark14;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark15;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark16;

    /** 备注 */
    //@Excel(name = "备注")
    private String remark17;
    private String remark18;
    private String remark19;
    private String remark20;
    
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

	//    @Excel(name = "报道状态：1已报道；2未报道")
    private String reportstate;
//    @Excel(name = "未报到原因")
    private String notreportresult;
//    @Excel(name = "缴费状态")
    private String paystate;
//    @Excel(name = "是否注册：1是；0否")
    private String isregister;
//    @Excel(name = "是否领取钥匙：1是；0否")
    private String isreceivekey;
//    @Excel(name = "是否领取军训设备：1是；0否")
    private String isreceivejunxun;
//  @Excel(name = "就业单位")
    private String company;
//  @Excel(name = "就业情况审批状态")
    private String comapproval;
//    @Excel(name = "工作岗位")
    private String post;
//    @Excel(name = "工作情况")
    private String situation;

//    @Excel(name = "图书馆办理信息")
    private String lixian1;
//    @Excel(name = "财务处办理信息")
    private String lixian2;
//    @Excel(name = "一卡通办理信息")
    private String lixian3;
//    @Excel(name = "退宿办理信息")
    private String lixian4;
//    @Excel(name = "组织关系转出")
    private String lixian5;
//    @Excel(name = "户口转出信息")
    private String lixian6;
//    @Excel(name = "毕业证发放信息")
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
    
    private String leavetime;
    private Long userId;
    
    private String sbid;
    private String ssid;
    
    
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
    public void setAdmissionTime(Date admissionTime) 
    {
        this.admissionTime = admissionTime;
    }

    public Date getAdmissionTime() 
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
