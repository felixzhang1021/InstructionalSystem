package com.dlnu.service;

import java.util.List;

import com.dlnu.model.PageBean;
import com.dlnu.model.TestPaper;

public interface PaperService {
	public List<TestPaper> paperList(PageBean pageBean,TestPaper paper)throws Exception;
	
	public int paperCount(TestPaper paper)throws Exception;
	
	public int paperDelete(String delIds)throws Exception;
	
	public int paperSave(TestPaper paper)throws Exception;
	
	public int paperReleaseSave(TestPaper paper)throws Exception;
	
	public List<TestPaper> showHistoryPaper()throws Exception;
}
