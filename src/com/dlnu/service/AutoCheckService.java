package com.dlnu.service;

import java.util.List;

import com.dlnu.model.Question;



public interface AutoCheckService {
	public int autoCheckService(String[] questionIdList, String[] answerList)throws Exception;
	public List<Question> autoCheckErrorService(String[] questionIdList, String[] answerList)throws Exception;
}
