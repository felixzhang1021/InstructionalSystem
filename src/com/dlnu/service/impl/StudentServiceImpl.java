package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.StudentDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.Student;
import com.dlnu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentDao studentDao;
	
	public Student login(Student student) throws Exception{
		return studentDao.login(student);
	}

	public List<Student> studentList(PageBean pageBean, Student student,
			String bbirthday, String ebirthday) throws Exception {
		return studentDao.studentList(pageBean, student, bbirthday, ebirthday);
	}

	public int studentCount(Student student, String bbirthday, String ebirthday)
			throws Exception {
		return studentDao.studentCount(student, bbirthday, ebirthday);
	}

	public int studentDelete(String delIds) throws Exception {
		return studentDao.studentDelete(delIds);
	}

	public int studentSave(Student student) throws Exception {
		return studentDao.studentSave(student);
	}

/*	public boolean getStudentByGradeId(String gradeId) throws Exception {
		return studentDao.getStudentByGradeId(gradeId);
	}*/
}
