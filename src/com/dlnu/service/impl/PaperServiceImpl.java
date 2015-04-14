package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.PaperDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.TestPaper;
import com.dlnu.service.PaperService;
@Service
public class PaperServiceImpl implements PaperService{
	@Resource
	private PaperDao paperDao;
	public List<TestPaper> paperList(PageBean pageBean, TestPaper paper)
			throws Exception {
		return paperDao.paperList(pageBean, paper);
	}

	public int paperCount(TestPaper paper) throws Exception {
		return paperDao.paperCount(paper);
	}

	public int paperDelete(String delIds) throws Exception {
		return paperDao.paperDelete(delIds);
	}

	public int paperSave(TestPaper paper) throws Exception {
		return paperDao.paperSave(paper);
	}

}
