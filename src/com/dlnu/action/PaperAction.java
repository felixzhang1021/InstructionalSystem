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
import com.dlnu.model.PaperDetail;
import com.dlnu.model.TestPaper;
import com.dlnu.service.PaperDetailService;
import com.dlnu.service.PaperService;
import com.dlnu.util.ResponseUtil;
import com.dlnu.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Namespace("/")
@Action(value="testpaper")
public class PaperAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private PaperService paperService;
	private PaperDetailService paperDetailService;
	private TestPaper paper;
	private PaperDetail paperDetail;
	private String paperId;
	private String paperName;
	private String startTime;
	public PaperDetailService getPaperDetailService() {
		return paperDetailService;
	}
	public void setPaperDetailService(PaperDetailService paperDetailService) {
		this.paperDetailService = paperDetailService;
	}
	private String durationTime;
	private String questionCount;
	public String getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(String questionCount) {
		this.questionCount = questionCount;
	}
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
	public PaperService getPaperService() {
		return paperService;
	}
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
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
	private String paperStatus;
	@Override
	public String execute() throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		paper = new TestPaper();
		if(paperName!=null){
			paper.setPaperName(paperName);
		}
		try{
		JSONObject result = new JSONObject();
		List<TestPaper> paperList=paperService.paperList(pageBean, paper);
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<paperList.size();i++){
			TestPaper paper =(TestPaper)paperList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("paperId", paper.getPaperId());
			jsonObject.put("paperName", paper.getPaperName());
			jsonObject.put("startTime", paper.getStartTime());
			jsonObject.put("durationTime", paper.getDurationTime());
			jsonObject.put("questionCount", paper.getQuestionCount());
			jsonObject.put("paperStatus", paper.getPaperStatus());
			jsonArray.add(jsonObject);
			}
			int total=paperService.paperCount(paper);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public String delete() throws Exception{
		try{
		JSONObject result = new JSONObject();
		int delNums=paperService.paperDelete(delIds);
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
		if(StringUtil.isNotEmpty(paperId)){
			paper.setPaperId(Integer.parseInt(paperId));
		}
		try{
			int saveNums=0;
			JSONObject result= new JSONObject();
			saveNums = paperService.paperSave(paper);
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
	public String show() throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		paperDetail = new PaperDetail();
		if(paperId!=null){
			System.out.println("$#$#$#$#$#$#$#$#$#$#$#$");
			paperDetail.setPaperId(Integer.parseInt(paperId));
		}
		System.out.println("$#$#$#$#$#$#$#$#$#$#$#$"+paperDetail.getPaperId());
		try{
		JSONObject result = new JSONObject();
		List<PaperDetail> paperDetailList=paperDetailService.paperDetailList(pageBean, paperDetail);
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<paperDetailList.size();i++){
			PaperDetail paperDetail =(PaperDetail)paperDetailList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("paperId", paperDetail.getPaperId());
			jsonObject.put("paperName", paperDetail.getPaperName());
			jsonObject.put("questions", paperDetail.getQuestions());
			jsonObject.put("OptionA", paperDetail.getOptionA());
			jsonObject.put("OptionB", paperDetail.getOptionB());
			jsonObject.put("OptionC", paperDetail.getOptionC());
			jsonObject.put("OptionD", paperDetail.getOptionD());
			jsonObject.put("answer", paperDetail.getAnswer());
			jsonObject.put("score", paperDetail.getScore());
			jsonArray.add(jsonObject);
			}
			int total=paperDetailService.paperDetailCount(paperDetail);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}
