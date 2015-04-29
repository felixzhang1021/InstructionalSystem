package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.PageBean;
import com.dlnu.model.PaperDetail;

public interface DetailDao {
	public List<PaperDetail> paperDetailList(PaperDetail paperDetail)throws Exception;
	
	public int paperDetailCount(PaperDetail paperDetail)throws Exception;
	
	public int paperDetailSave(PaperDetail paperDetail)throws Exception;
}
