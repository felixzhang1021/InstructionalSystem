package com.dlnu.service;

import java.util.List;

import com.dlnu.model.PageBean;
import com.dlnu.model.Question;

public interface QuestionService {

	public List<Question> questionList(PageBean pageBean,Question question)throws Exception;
	
	public int questionCount(Question question)throws Exception;
	
	public int questionDelete(String delIds)throws Exception;
	
	public int questionSave(Question question)throws Exception;
}
