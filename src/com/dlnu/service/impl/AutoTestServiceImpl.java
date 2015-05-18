package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.AutoTestDao;
import com.dlnu.model.Question;
import com.dlnu.service.AutoTestService;
@Service
public class AutoTestServiceImpl implements AutoTestService{
	@Resource
	private AutoTestDao autoTestDao;
	public List<Question> autoTestPaper() throws Exception {
		// TODO Auto-generated method stub
		return autoTestDao.autoTestPaper();
	}
	
}
