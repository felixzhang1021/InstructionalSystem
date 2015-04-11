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
import com.dlnu.model.Student;
import com.dlnu.service.StudentService;
import com.dlnu.util.DateUtil;
import com.dlnu.util.ResponseUtil;
import com.dlnu.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Namespace("/")
@Action(value="student")
public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private StudentService studentService;
	private Student student;
	private String stuId;
	private String stuNo;
	private String stuName;
	private String stuSex;
	private String bStuBirthday;
	private String eStuBirthday;
	private String page;
	private String rows;
	private String delIds;

	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}


	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getbStuBirthday() {
		return bStuBirthday;
	}
	public void setbStuBirthday(String bStuBirthday) {
		this.bStuBirthday = bStuBirthday;
	}
	public String geteStuBirthday() {
		return eStuBirthday;
	}
	public void seteStuBirthday(String eStuBirthday) {
		this.eStuBirthday = eStuBirthday;
	}
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
	@Override
	public String execute() throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		student = new Student();
		if(stuNo!=null){
			student.setStuNo(stuNo);
			student.setStuName(stuName);
			student.setStuSex(stuSex);
			
		}
		try{
		JSONObject result = new JSONObject();
		List<Student> studentList=studentService.studentList(pageBean, student, bStuBirthday, eStuBirthday);
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<studentList.size(); i++){
			Student student = (Student)studentList.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("stuId", student.getStuId());
			jsonObject.put("stuNo", student.getStuNo());
			jsonObject.put("stuName", student.getStuName());
			jsonObject.put("stuSex", student.getStuSex());
			jsonObject.put("birthday", DateUtil.formatDate(student.getStuBirthday(), "yyyy-MM-dd"));
			jsonObject.put("email", student.getStuEmail());
			jsonArray.add(jsonObject);
		}
		int total=studentService.studentCount(student,bStuBirthday,eStuBirthday);
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
			JSONObject result=new JSONObject();
			int delNums=studentService.studentDelete(delIds);
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
		if(StringUtil.isNotEmpty(stuId)){
			student.setStuId(Integer.parseInt(stuId));
			
		}
		try{
			int saveNums=0;
			JSONObject result=new JSONObject();
			saveNums=studentService.studentSave(student);
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

