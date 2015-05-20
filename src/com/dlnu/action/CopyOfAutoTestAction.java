package com.dlnu.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.dlnu.model.Question;
import com.dlnu.model.TestPaper;
import com.dlnu.service.AutoTestService;
import com.dlnu.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="autotest123",results={@Result(name="success",type="redirect",location="/autoTest.jsp")})
public class CopyOfAutoTestAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	private int questionId;
	private String questions;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Question question;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public AutoTestService getAutoTestService() {
		return autoTestService;
	}
	public void setAutoTestService(AutoTestService autoTestService) {
		this.autoTestService = autoTestService;
	}
	@Resource
	private AutoTestService autoTestService;
	
	HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		List<Question> autoTestPaper = autoTestService.autoTestPaper();
		JSONArray jsonArray = new JSONArray();
		JSONObject result = new JSONObject();
		for(int i=0;i<autoTestPaper.size();i++){
			Question questionList =(Question)autoTestPaper.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("questionNumber", i+1);
			jsonObject.put("questions", questionList.getQuestions());
			jsonObject.put("questionId", questionList.getQuestionId());
			jsonObject.put("optionA", questionList.getOptionA());
			jsonObject.put("optionB", questionList.getOptionB());
			jsonObject.put("optionC", questionList.getOptionC());
     		jsonObject.put("optionD", questionList.getOptionD());
			jsonArray.add(jsonObject);
			}
		//Dispatcher.forward("autoTest.jsp");
		//String json =jsonArray.toString();
		session.setAttribute("json", jsonArray);
		//ResponseUtil.write(ServletActionContext.getResponse(), jsonArray);
		//return ajaxText(jsonArray);
		return SUCCESS;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}
	
}
