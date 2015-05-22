package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.AutoCheckDao;
import com.dlnu.model.Question;
import com.dlnu.service.AutoCheckService;
@Service
public class AutoCheckServiceImpl implements AutoCheckService{
	@Resource
	private AutoCheckDao autoCheckDao;

	public int autoCheckService(String[] questionIdList, String[] answerList)
			throws Exception {
		// TODO Auto-generated method stub
		return autoCheckDao.autoCheck(questionIdList, answerList);
	}

	public List<Question> autoCheckErrorService(String[] questionIdList,
			String[] answerList) throws Exception {
		// TODO Auto-generated method stub
		return autoCheckDao.autoCheckError(questionIdList, answerList);
	}
	
}
