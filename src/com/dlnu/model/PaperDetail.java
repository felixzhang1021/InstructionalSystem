package com.dlnu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="paperdetail")
public class PaperDetail {
	private int detailId;
	private int paperId=-1;
	private int questionId;
	private String paperName;
	private String questions;
	@Column(name="paperName")
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	@Column(name="question")
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	@Column(name="optionA")
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	@Column(name="optionB")
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	@Column(name="optionC")
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	@Column(name="optionD")
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	@Column(name="answer")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Column(name="score")
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private int score;
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="detailId")
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	@Column(name="paperId")
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	@Column(name="questionId")
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public PaperDetail(int paperId, int questionId, String paperName,
			String questions, String optionA, String optionB, String optionC,
			String optionD, String answer, int score) {
		super();
		this.paperId = paperId;
		this.questionId = questionId;
		this.paperName = paperName;
		this.questions = questions;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.score = score;
	}
	public PaperDetail(int paperId, int questionId) {
		super();
		this.paperId = paperId;
		this.questionId = questionId;
	}
	public PaperDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
}
