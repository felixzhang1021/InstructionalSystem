package com.dlnu.service;

import java.util.List;

import com.dlnu.model.PageBean;
import com.dlnu.model.PaperDetail;

public interface PaperDetailService {
	public List<PaperDetail> paperDetailList(PageBean pageBean,PaperDetail paperDetail)throws Exception;
	
	public int paperDetailCount(PaperDetail paperDetail)throws Exception;
	
	public int paperDetailSave(PaperDetail paperDetail)throws Exception;
}
