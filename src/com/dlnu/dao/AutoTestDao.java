package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.Question;

public interface AutoTestDao {
	public List<Question> autoTestPaper() throws Exception;
}
