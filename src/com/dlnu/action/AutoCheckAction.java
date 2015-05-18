package com.dlnu.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.dlnu.model.Question;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="autocheck")
public class AutoCheckAction extends ActionSupport implements ServletRequestAware{
	
	private int scoreCount;
	private Question question;
	private int questionId;
	private String questions;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private int score;
	HttpServletRequest request;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Ö´ÐÐ³É¹¦");
		return null;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}

}
