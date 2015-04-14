package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.PageBean;
import com.dlnu.model.TestPaper;

public interface PaperDao {
	public List<TestPaper> paperList(PageBean pageBean,TestPaper paper)throws Exception;
	
	public int paperCount(TestPaper paper)throws Exception;
	
	public int paperDelete(String delIds)throws Exception;
	
	public int paperSave(TestPaper paper)throws Exception;
}
