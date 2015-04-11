package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.QuestionDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.Question;
import com.dlnu.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{
	@Resource
	private QuestionDao questionDao;
	
	public List<Question> questionList(PageBean pageBean, Question question)
			throws Exception {
		return questionDao.questionList(pageBean, question);
	}

	public int questionCount(Question question) throws Exception {
		return questionDao.questionCount(question);
	}

	public int questionDelete(String delIds) throws Exception {
		return questionDao.questionDelete(delIds);
	}

	public int questionSave(Question question) throws Exception {
		return questionDao.questionSave(question);
	}

}
