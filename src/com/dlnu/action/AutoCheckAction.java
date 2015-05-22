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

import com.dlnu.model.Comment;
import com.dlnu.model.Question;
import com.dlnu.service.AutoCheckService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="autocheck",results={@Result(name="success",type="redirect",location="/showScore.jsp")})
public class AutoCheckAction extends ActionSupport implements ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int scoreCount;
	private Question question;
	private String questionIdList;
	private String questionAnswerList;
	@Resource
	private AutoCheckService autoCheckService;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
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

	private int score;
	
	HttpServletRequest request;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		JSONArray jsonArray = new JSONArray();
		List<Question> errorList = null;
		System.out.println("----->>"+questionIdList);
		System.out.println("----->>"+questionAnswerList);
		String questionIdListTemp[] = questionIdList.split(","); 
		String questionAnswerListTemp[] = questionAnswerList.split(","); 
		scoreCount = autoCheckService.autoCheckService(questionIdListTemp, questionAnswerListTemp);
		errorList = autoCheckService.autoCheckErrorService(questionIdListTemp, questionAnswerListTemp);
		//	ResponseUtil.write(ServletActionContext.getResponse(), scoreCount);
		for(int i=0;i<errorList.size();i++){
			Question errorQuestionList =(Question)errorList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("questionId", i+1);
			jsonObject.put("questions", errorQuestionList.getQuestions());
			jsonObject.put("optionA", errorQuestionList.getOptionA());
			jsonObject.put("optionB", errorQuestionList.getOptionB());
			jsonObject.put("optionC", errorQuestionList.getOptionC());
			jsonObject.put("optionD", errorQuestionList.getOptionD());
			jsonObject.put("answer", errorQuestionList.getAnswer());
			jsonArray.add(jsonObject);
			}
		session.setAttribute("json", scoreCount);
		session.setAttribute("jsonErrorList", jsonArray);
		
		System.out.println("--countScore-->>"+scoreCount);
		return SUCCESS;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}

}
