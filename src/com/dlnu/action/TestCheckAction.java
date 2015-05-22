package com.dlnu.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.dlnu.model.PaperDetail;
import com.dlnu.service.StudentTestService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="testcheck",results={@Result(name="success",type="redirect",location="/testFinish.jsp")})
public class TestCheckAction extends ActionSupport implements ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int scoreCount;
	private PaperDetail paperDetail;
	private String questionIdList;
	private String questionAnswerList;
	private int stuId;
	private String stuName;
	private int paperId;
	private String paperName;
	@Resource
	private StudentTestService studentTestService;

	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getQuestionIdList() {
		return questionIdList;
	}
	public void setQuestionIdList(String questionIdList) {
		this.questionIdList = questionIdList;
	}
	public String getQuestionAnswerList() {
		return questionAnswerList;
	}
	public void setQuestionAnswerList(String questionAnswerList) {
		this.questionAnswerList = questionAnswerList;
	}
	
	public int getScoreCount() {
		return scoreCount;
	}
	public void setScoreCount(int scoreCount) {
		this.scoreCount = scoreCount;
	}

	public PaperDetail getPaperDetail() {
		return paperDetail;
	}
	public void setPaperDetail(PaperDetail paperDetail) {
		this.paperDetail = paperDetail;
	}

	HttpServletRequest request;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		JSONArray jsonArray = new JSONArray();
		List<PaperDetail> errorList = null;
		System.out.println("--questionIdList-->>"+questionIdList);
		System.out.println("--questionAnswerList--->>"+questionAnswerList);
		System.out.println("--stuId--->>"+stuId);
		System.out.println("--stuName--->>"+stuName);
		System.out.println("--paperId--->>"+paperId);
		System.out.println("--paperName--->>"+paperName);
		String questionIdListTemp[] = questionIdList.split(","); 
		String questionAnswerListTemp[] = questionAnswerList.split(","); 
		scoreCount = studentTestService.testCheck(questionIdListTemp, questionAnswerListTemp, stuId, stuName, paperId, paperName);
		session.setAttribute("json", "¿¼ÊÔ½áÊø");	
		System.out.println("--countScore-->>"+scoreCount);
		return SUCCESS;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}

}
