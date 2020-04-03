package com.ruoyi.project.system.examStudentListDetail.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.project.system.examSubjectJudgement.domain.ExamSubjectJudgement;

/**
 * 【请填写功能名称】对象 exam_student_list_detail
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
public class ExamStudentListDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学生答题记录id */
    @Excel(name = "学生答题记录id")
    private String detailid;

    /** 问题id */
    @Excel(name = "问题id")
    private String questionid;

    /** 选择 */
    @Excel(name = "选择")
    private String choose;

    /** 是否错题1是0否 */
    @Excel(name = "是否错题1是0否")
    private String iswrong;
    
    private String studentid;
    
    private String paperid;
    
    private ExamSubjectJudgement esj;
    
    public ExamSubjectJudgement getEsj() {
		return esj;
	}

	public void setEsj(ExamSubjectJudgement esj) {
		this.esj = esj;
	}

	public String getPaperid() {
		return paperid;
	}

	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getIswrong() {
		return iswrong;
	}

	public void setIswrong(String iswrong) {
		this.iswrong = iswrong;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDetailid(String detailid) 
    {
        this.detailid = detailid;
    }

    public String getDetailid() 
    {
        return detailid;
    }
    public void setQuestionid(String questionid) 
    {
        this.questionid = questionid;
    }

    public String getQuestionid() 
    {
        return questionid;
    }
    public void setChoose(String choose) 
    {
        this.choose = choose;
    }

    public String getChoose() 
    {
        return choose;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("detailid", getDetailid())
            .append("questionid", getQuestionid())
            .append("choose", getChoose())
            .toString();
    }
}
