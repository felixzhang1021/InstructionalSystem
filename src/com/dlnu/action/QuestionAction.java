package com.dlnu.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;

import com.dlnu.model.PageBean;
import com.dlnu.model.Question;
import com.dlnu.service.QuestionService;
import com.dlnu.util.DateUtil;
import com.dlnu.util.ResponseUtil;
import com.dlnu.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Namespace("/")
@Action(value="question")
public class QuestionAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private QuestionService questionService;
	private Question question;
	private String questionId;
	private String questions;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private String page;
	private String rows;
	private String delIds;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getDelIds() {
		return delIds;
	}
	public void setDelIds(String delIds) {
		this.delIds = delIds;
	}
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	private String score;
	@Override
	public String execute() throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		question = new Question();
		if(questions!=null){
			question.setQuestions(questions);
		}
		try{
			JSONObject result = new JSONObject();
			List<Question> questionList=questionService.questionList(pageBean, question);
			JSONArray jsonArray = new JSONArray();
			for(int i=0;i<questionList.size(); i++){
				Question question = (Question)questionList.get(i);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("questionId", question.getQuestionId());
				jsonObject.put("questions", question.getQuestions());
				jsonObject.put("optionA", question.getOptionA());
				jsonObject.put("optionB", question.getOptionB());
				jsonObject.put("optionC", question.getOptionC());
				jsonObject.put("optionD", question.getOptionD());
				jsonObject.put("answer", question.getAnswer());
				jsonObject.put("score", question.getScore());
				jsonArray.add(jsonObject);
			}
			int total=questionService.questionCount(question);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public String delete()throws Exception{
		try{
		JSONObject result = new JSONObject();
		int delNums=questionService.questionDelete(delIds);
		if(delNums>0){
			result.put("success", "true");
			result.put("delNums", delNums);
		}else{
			result.put("errorMsg", "…æ≥˝ ß∞‹");
		}
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
		}
	public String save()throws Exception{
		if(StringUtil.isNotEmpty(questionId)){
			question.setQuestionId(Integer.parseInt(questionId));
		}
		try{
			int saveNums=0;
			JSONObject result= new JSONObject();
			saveNums = questionService.questionSave(question);
			if(saveNums>0){
				result.put("success", "true");
				
			}else{
				result.put("success", "true");
				result.put("errorMsg", "±£¥Ê ß∞‹");
			}
			ResponseUtil.write(ServletActionContext.getResponse(), result);
	}catch(Exception e){
		e.printStackTrace();
	}
			return null;
	}
	
	
}
