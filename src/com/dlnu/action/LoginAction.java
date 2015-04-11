package com.dlnu.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.dlnu.model.Student;
import com.dlnu.service.StudentService;
import com.dlnu.util.StringUtil;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="login",results={@Result(name="success",type="redirect",location="/main.jsp"),@Result(name="error",location="/index.jsp")})
public class LoginAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Resource
	private StudentService studentService;
	private Student student;
	private String error;
	
	HttpServletRequest request;
	
	public String execute() throws Exception{
		HttpSession session = request.getSession();
		System.out.println("aaaaaaaaaaaaa");
		if(StringUtil.isEmpty(student.getStuNo())||StringUtil.isEmpty(student.getPassword())){
			error="用户名或密码为空！";
			return ERROR;
		}
		System.out.println(student.getPassword()+"@@@@@@@");
		Student currentStu = studentService.login(student);
		if(currentStu==null){
			error="用户名或密码错误！";
			return ERROR;
		}else{
			session.setAttribute("currentStu", currentStu);
			return SUCCESS;
		}
		
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}

}
