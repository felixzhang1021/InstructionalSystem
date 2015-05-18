package com.dlnu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.AutoCheckDao;
import com.dlnu.model.Question;
@Repository
public class AutoCheckDaoImpl implements AutoCheckDao{
	private SessionFactory sessionFactory;
	
	public int autoCheck(List<Question> questionList) throws Exception {
		// TODO Auto-generated method stub
		int score=0;
		Session session=this.getSession();
		for(int i=0; i<questionList.size(); i++){
			 Query query=session.createQuery("from Question q where q.questionId=?");
			 query.setInteger(0, questionList.get(i).getQuestionId());
			 List<Question> bankQuestionList=(List<Question>)query.list();
			 if(bankQuestionList.get(0).getScore()==questionList.get(i).getScore()){
				 score = score+bankQuestionList.get(0).getScore();
			 }
		}
		return score;
	}
	
	@Resource
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
