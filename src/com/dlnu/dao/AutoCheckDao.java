package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.Question;

public interface AutoCheckDao {
	public int autoCheck(List<Question> questionList) throws Exception; 
}	
