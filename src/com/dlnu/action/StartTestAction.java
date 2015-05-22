package com.dlnu.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dlnu.model.PaperDetail;
import com.dlnu.model.Question;
import com.dlnu.service.StudentTestService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="starttest",results={@Result(name="success",type="redirect",location="/startTest.jsp")})
public class StartTestAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	private int paperId;


	private int questionId;
	private String questions;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Question question;
	@Resource
	private StudentTestService studentTestService;
	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		System.out.println("-kaoshi de  paperId->>"+paperId);
		List<PaperDetail> testQuestionList = studentTestService.TestPaper(paperId);
		JSONArray jsonArray = new JSONArray();
		JSONObject result = new JSONObject();
		for(int i=0;i<testQuestionList.size();i++){
			PaperDetail testQuestion =(PaperDetail)testQuestionList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("questionNumber", i+1);
			jsonObject.put("paperId", testQuestion.getPaperId());
			jsonObject.put("paperName", testQuestion.getPaperName());
			jsonObject.put("questions", testQuestion.getQuestions());
			jsonObject.put("questionId", testQuestion.getQuestionId());
			jsonObject.put("optionA", testQuestion.getOptionA());
			jsonObject.put("optionB", testQuestion.getOptionB());
			jsonObject.put("optionC", testQuestion.getOptionC());
     		jsonObject.put("optionD", testQuestion.getOptionD());

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
