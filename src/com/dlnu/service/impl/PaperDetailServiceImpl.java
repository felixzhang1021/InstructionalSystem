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
	
	public List<PaperDetail> paperDetailList(PageBean pageBean,
			PaperDetail paperDetail) throws Exception {
		return this.paperDetailList(pageBean, paperDetail);
	}

	public int paperDetailCount(PaperDetail paperDetail) throws Exception {
		return this.paperDetailCount(paperDetail);
	}

	public int paperDetailSave(PaperDetail paperDetail) throws Exception {
		return this.paperDetailSave(paperDetail);
	}

}
