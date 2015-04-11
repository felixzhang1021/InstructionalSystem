package com.dlnu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student")
public class Student {
	private int stuId;
	private String stuNo;
	private String stuName;
	private String password;

	private String stuSex;
	private Date stuBirthday;
	private String stuEmail;
	
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="stuId")
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	@Column(name="stuNo")
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public Student(String stuNo, String stuName, String password,
			String stuSex, Date stuBirthday, String stuEmail) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.password = password;
		this.stuSex = stuSex;
		this.stuBirthday = stuBirthday;
		this.stuEmail = stuEmail;
	}


	@Column(name="stuName")
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="stuSex")
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	@Column(name="stuBirthday")
	public Date getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
	@Column(name="stuEmail")
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public Student(String stuNo, String password) {
		super();
		this.stuNo = stuNo;
		this.password = password;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
