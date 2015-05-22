package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.StudentTestDao;
import com.dlnu.model.PaperDetail;
import com.dlnu.model.Question;
import com.dlnu.model.TestPaper;
import com.dlnu.service.StudentTestService;
@Service
public class StudentTestServiceImpl implements StudentTestService{
	@Resource
	private StudentTestDao studentTestDao;
	public List<TestPaper> testPaperList() throws Exception {
		// TODO Auto-generated method stub
		return studentTestDao.testPaperList();
	}
	public List<PaperDetail> TestPaper(int paperId) throws Exception {
		// TODO Auto-generated method stub
		return studentTestDao.startTestPaper(paperId);
	}
	public int testCheck(String[] questionIdList, String[] answerList,
			int stuId, String stuName, int paperId, String paperName)
			throws Exception {
		// TODO Auto-generated method stub
		return studentTestDao.testCheck(questionIdList, answerList, stuId, stuName, paperId, paperName);
	}
	
}
