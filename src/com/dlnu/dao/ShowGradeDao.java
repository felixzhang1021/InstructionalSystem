package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.Grade;

public interface ShowGradeDao {
	public List<Grade> studentShowGrade(int stuId) throws Exception; 
	public List<Grade> teacherShowGrade(int paperId) throws Exception; 
}
