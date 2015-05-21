package com.dlnu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="comment")
public class Comment {
	private int comId;
	private int messageId;
	private String comcontent;
	private String comperson;
	private Date comDate;
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="comid")
	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}
	@Column(name="messageId")
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	@Column(name="comcontent")
	public String getComcontent() {
		return comcontent;
	}
	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}
	@Column(name="comperson")
	public String getComperson() {
		return comperson;
	}
	public void setComperson(String comperson) {
		this.comperson = comperson;
	}
	@Column(name="comdate")
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	public Comment(int messageId, String comcontent, String comperson,
			Date comDate) {
		super();
		this.messageId = messageId;
		this.comcontent = comcontent;
		this.comperson = comperson;
		this.comDate = comDate;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
}
