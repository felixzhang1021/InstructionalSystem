package com.dlnu.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


import com.dlnu.model.TestPaper;
import com.dlnu.service.StudentTestService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="studenttest",results={@Result(name="success",type="redirect",location="/showTestPaper.jsp")})
public class StudentTestAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TestPaper paper;
	private String paperId;
	private String paperName;
	private String startTime;
	private String durationTime;
	private String paperStatus;
	@Resource
	private StudentTestService studentTestService;
	HttpServletRequest request;
	public TestPaper getPaper() {
		return paper;
	}
	public void setPaper(TestPaper paper) {
		this.paper = paper;
	}
	public String getPaperId() {
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	public String getPaperStatus() {
		return paperStatus;
	}
	public void setPaperStatus(String paperStatus) {
		this.paperStatus = paperStatus;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		JSONArray jsonArray = new JSONArray();
		List<TestPaper> paperList = studentTestService.testPaperList();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<paperList.size();i++){
			TestPaper testPaperList =(TestPaper)paperList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("paperNumber", i+1);
			jsonObject.put("paperId", testPaperList.getPaperId());
			jsonObject.put("paperName", testPaperList.getPaperName());
			jsonObject.put("startTime", formatter.format(testPaperList.getStartTime()));
			jsonObject.put("durationTime", testPaperList.getDurationTime());
			jsonObject.put("paperStatus", testPaperList.getPaperStatus());
			jsonObject.put("questionCount", testPaperList.getQuestionCount());
			jsonArray.add(jsonObject);
			}
		session.setAttribute("json", jsonArray);
		return SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}
	
}
