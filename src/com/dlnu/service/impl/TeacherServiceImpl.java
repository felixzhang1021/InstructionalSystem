package com.dlnu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.TeacherDao;
import com.dlnu.model.Teacher;
import com.dlnu.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Resource
	private TeacherDao teacherDao;
	
	public Teacher login(Teacher teacher) throws Exception{
		return teacherDao.login(teacher);
	}

}
