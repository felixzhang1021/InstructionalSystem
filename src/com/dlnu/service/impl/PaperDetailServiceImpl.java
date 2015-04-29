package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.DetailDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.PaperDetail;
import com.dlnu.service.PaperDetailService;
@Service
public class PaperDetailServiceImpl implements PaperDetailService{
	@Resource
	private DetailDao paperDetailDao;
	
	public List<PaperDetail> paperDetailList(
			PaperDetail paperDetail) throws Exception {
		return paperDetailDao.paperDetailList(paperDetail);
	}

	public int paperDetailCount(PaperDetail paperDetail) throws Exception {
		return paperDetailDao.paperDetailCount(paperDetail);
	}

	public int paperDetailSave(PaperDetail paperDetail) throws Exception {
		return paperDetailDao.paperDetailSave(paperDetail);
	}

}
