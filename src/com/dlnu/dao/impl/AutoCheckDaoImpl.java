package com.dlnu.dao.impl;

import java.util.ArrayList;
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
	
	public int autoCheck(String[] questionIdList, String[] answerList) throws Exception {
		// TODO Auto-generated method stub
		int score=0;
		Session session=this.getSession();
		for(int i=0; i<questionIdList.length; i++){
			 Query query=session.createQuery("from Question q where q.questionId=?");
			 query.setString(0, questionIdList[i]);
			 List<Question> bankQuestionList=(List<Question>)query.list();
			 System.out.println(bankQuestionList.get(0).getAnswer()+"   "+answerList[i]);
			 if(bankQuestionList.get(0).getAnswer().equals(answerList[i])){
				 score = score + bankQuestionList.get(0).getScore();
				 System.out.print(score+"  ");
			 }
		}
		System.out.println("--scoreDaoImpl"+score);
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

	@SuppressWarnings("null")
	public List<Question> autoCheckError(String[] questionIdList,
			String[] answerList) throws Exception {
		Session session=this.getSession();
		List<Question> errorList= new ArrayList<Question>();
		for(int i=0; i<questionIdList.length; i++){
			 Query query=session.createQuery("from Question q where q.questionId=?");
			 query.setString(0, questionIdList[i]);
			 List<Question> bankQuestionList=(List<Question>)query.list();
			 System.out.println(bankQuestionList.get(0).getAnswer()+"   "+answerList[i]);
			 if(!(bankQuestionList.get(0).getAnswer().equals(answerList[i]))){
				 System.out.println("---testError-->>"+(Question)bankQuestionList.get(0));
				 Question q = new Question();
				 q.setQuestionId(bankQuestionList.get(0).getQuestionId());
				 q.setQuestions(bankQuestionList.get(0).getQuestions());
				 q.setOptionA(bankQuestionList.get(0).getOptionA());
				 q.setOptionB(bankQuestionList.get(0).getOptionB());
				 q.setOptionC(bankQuestionList.get(0).getOptionC());
				 q.setOptionD(bankQuestionList.get(0).getOptionD());
				 q.setAnswer(bankQuestionList.get(0).getAnswer());
				 q.setScore(bankQuestionList.get(0).getScore());
				 errorList.add(q);
			 }
		}
		
		return errorList;
	}
}
