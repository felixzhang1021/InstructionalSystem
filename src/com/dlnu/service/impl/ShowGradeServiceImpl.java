package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.ShowGradeDao;
import com.dlnu.model.Grade;
import com.dlnu.service.ShowGradeService;
@Service
public class ShowGradeServiceImpl implements ShowGradeService{
	@Resource
	private ShowGradeDao showGradeDao;
	public List<Grade> studentShowGrade(int stuId) throws Exception {
		// TODO Auto-generated method stub
		return showGradeDao.studentShowGrade(stuId);
	}
	public List<Grade> tacherShowGrade(int paperId) throws Exception {
		// TODO Auto-generated method stub
		return showGradeDao.teacherShowGrade(paperId);
	}

}
