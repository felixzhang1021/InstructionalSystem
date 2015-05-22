package com.dlnu.service;

import java.util.List;

import com.dlnu.model.PaperDetail;
import com.dlnu.model.Question;
import com.dlnu.model.TestPaper;

public interface StudentTestService {
	public List<TestPaper> testPaperList() throws Exception;
	public List<PaperDetail> TestPaper(int paperId) throws Exception;
	public int testCheck(String[] questionIdList, String[] answerList, int stuId, String stuName, int paperId, String paperName) throws Exception; 

}
