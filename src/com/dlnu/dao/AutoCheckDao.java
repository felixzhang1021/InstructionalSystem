package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.Question;

public interface AutoCheckDao {
	public int autoCheck(String[] questionIdList, String[] answerList) throws Exception; 
	public List<Question> autoCheckError(String[] questionIdList, String[] answerList) throws Exception; 
}	
