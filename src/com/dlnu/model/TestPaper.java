package com.dlnu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="testpaper")
public class TestPaper {
	private int paperId=-1;
	private String paperName;
	private Date startTime;
	private int durationTime;
	private int questionCount;

	private String paperStatus;

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="paperId")
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	@Column(name="paperName")
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	@Column(name="startTime")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@Column(name="durationTime")
	public int getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}
	@Column(name="paperStatus")
	public String getPaperStatus() {
		return paperStatus;
	}
	public void setPaperStatus(String paperStatus) {
		this.paperStatus = paperStatus;
	}
	@Column(name="questionCount")
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public TestPaper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestPaper(String paperName, Date startTime, int durationTime,
			int questionCount, String paperStatus) {
		super();
		this.paperName = paperName;
		this.startTime = startTime;
		this.durationTime = durationTime;
		this.questionCount = questionCount;
		this.paperStatus = paperStatus;
	}


	
}
