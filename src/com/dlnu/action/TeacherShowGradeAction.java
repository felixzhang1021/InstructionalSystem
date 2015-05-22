package com.dlnu.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.dlnu.model.Grade;
import com.dlnu.model.Message;
import com.dlnu.service.ShowGradeService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="showStudentGrade",results={@Result(name="success",type="redirect",location="/teacherShowGrade.jsp")})
public class TeacherShowGradeAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	private int stuId;
	private String stuName;
	private int paperId;
	private String paperName;
	private int stuScore;
	private Grade grade;
	@Resource
	private ShowGradeService showGradeService;
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

	public int getStuScore() {
		return stuScore;
	}

	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}



	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<Grade> studentGradeList=  showGradeService.tacherShowGrade(paperId); 
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<studentGradeList.size();i++){
			Grade gradeList =(Grade)studentGradeList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("gradeNumber", i+1);
			
			jsonObject.put("stuId", gradeList.getStuId());
			jsonObject.put("stuName", gradeList.getStuName());
			jsonObject.put("paperId", gradeList.getPaperId());
			jsonObject.put("paperName", gradeList.getPaperName());
			jsonObject.put("stuScore", gradeList.getStuScore());
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
