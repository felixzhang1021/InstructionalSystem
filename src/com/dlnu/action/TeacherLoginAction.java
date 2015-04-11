package com.dlnu.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.dlnu.model.Student;
import com.dlnu.model.Teacher;
import com.dlnu.service.TeacherService;
import com.dlnu.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="teacherlogin",results={@Result(name="success",type="redirect",location="/main.jsp"),@Result(name="error",location="/index.jsp")})
public class TeacherLoginAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private TeacherService teacherService;
	private Teacher teacher;
	private String error;
	
	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


	
	HttpServletRequest request;
	
	public String execute() throws Exception{
		HttpSession session = request.getSession();
		if(StringUtil.isEmpty(teacher.getTeacherId())||StringUtil.isEmpty(teacher.getPassword())){
			error="用户名或密码为空！";
			return ERROR;
		}
		Teacher currentTea = teacherService.login(teacher);
		if(currentTea==null){
			error="用户名或密码错误！";
			return ERROR;
		}else{
			session.setAttribute("currentTea", currentTea);
			return SUCCESS;
		}
		
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}

	
}
