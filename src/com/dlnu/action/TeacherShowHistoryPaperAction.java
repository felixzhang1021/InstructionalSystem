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

import com.dlnu.model.TestPaper;
import com.dlnu.service.PaperService;
import com.dlnu.service.ShowGradeService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="teachershowHistoryPaper",results={@Result(name="success",type="redirect",location="/TeacherShowHistoryPaper.jsp")})
public class TeacherShowHistoryPaperAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	private int paperId;
	private String paperName;
	private String startTime;
	private int durationTime;
	private int questionCount;
	private String paperStatus;
	private TestPaper testPaper;
	@Resource
	private PaperService paperService;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public String getPaperStatus() {
		return paperStatus;
	}

	public void setPaperStatus(String paperStatus) {
		this.paperStatus = paperStatus;
	}

	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<TestPaper> paperList=  paperService.showHistoryPaper(); 
		JSONArray jsonArray = new JSONArray();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<paperList.size();i++){
			TestPaper paper =(TestPaper)paperList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("paperNumber", i+1);
			jsonObject.put("paperId", paper.getPaperId());
			jsonObject.put("paperName", paper.getPaperName());
			jsonObject.put("startTime", formatter.format(paper.getStartTime()));
			jsonObject.put("durationTime", paper.getDurationTime());
			jsonObject.put("paperStatus", paper.getPaperStatus());
			jsonObject.put("questionCount", paper.getQuestionCount());
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
