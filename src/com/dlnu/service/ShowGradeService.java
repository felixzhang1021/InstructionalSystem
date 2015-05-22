package com.dlnu.service;

import java.util.List;

import com.dlnu.model.Grade;

public interface ShowGradeService {
	public List<Grade> studentShowGrade(int stuId) throws Exception; 
	public List<Grade> tacherShowGrade(int paperId) throws Exception; 
}
