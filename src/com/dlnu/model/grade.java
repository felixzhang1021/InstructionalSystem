package com.dlnu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="grade")
public class Grade {
	private int stuId;
	private int paperId;
	private int stuScore;
	private int gradeId;
	private String stuName;
	private String paperName;

	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="gradeId")
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	@Column(name="stuId")
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	@Column(name="paperId")
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	@Column(name="stuScore")
	public int getStuScore() {
		return stuScore;
	}
	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(int stuId, int paperId, int stuScore) {
		super();
		this.stuId = stuId;
		this.paperId = paperId;
		this.stuScore = stuScore;
	}

}
