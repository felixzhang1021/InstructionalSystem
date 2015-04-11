package com.dlnu.service;

import java.util.List;

import com.dlnu.model.PageBean;
import com.dlnu.model.Student;

public interface StudentService {
	public Student login(Student student) throws Exception;
	
	public List<Student> studentList(PageBean pageBean,Student student,String bbirthday,String ebirthday)throws Exception;
	
	public int studentCount(Student student,String bbirthday,String ebirthday)throws Exception;
	
	public int studentDelete(String delIds)throws Exception;
	
	public int studentSave(Student student)throws Exception;
	
	//public boolean getStudentByGradeId(String gradeId)throws Exception;


}
