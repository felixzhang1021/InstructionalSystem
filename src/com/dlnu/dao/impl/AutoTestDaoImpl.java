package com.dlnu.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.AutoTestDao;
import com.dlnu.model.PaperDetail;
import com.dlnu.model.Question;
import com.dlnu.model.TestPaper;
@Repository
public class AutoTestDaoImpl implements AutoTestDao{
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("null")
	public List<Question> autoTestPaper() throws Exception {
		Session session=this.getSession();
		int numSize=50;
		HashSet<Integer> set = new HashSet<Integer>(); 
		addNumber(1,45,20,set);
		List<Question> autoPaper= new ArrayList<Question>();
		System.out.println("--set.size--->>"+set.size());
		 for (int j : set) {
			 j=j+1;
			 Query query=session.createQuery("from Question q where q.questionId=?");
			 query.setInteger(0, j);
			 List<Question> questionList=(List<Question>)query.list();
			 Question q = new Question();
			 q.setQuestionId(questionList.get(0).getQuestionId());
			 q.setQuestions(questionList.get(0).getQuestions());
			 q.setOptionA(questionList.get(0).getOptionA());
			 q.setOptionB(questionList.get(0).getOptionB());
			 q.setOptionC(questionList.get(0).getOptionC());
			 q.setOptionD(questionList.get(0).getOptionD());
			 q.setAnswer(questionList.get(0).getAnswer());
			 q.setScore(questionList.get(0).getScore());
		     autoPaper.add(q);
		     System.out.println("--autoList->>");
		 }
		return autoPaper;
	}
	
	public static void addNumber(int min,int max,int numSize,HashSet<Integer> set){
		Random random = new Random();

		for(int i=0;i<numSize;i++){
			int ranInt = random.nextInt(max-min+1);
			System.out.print(ranInt+" ");
			set.add(ranInt);
		}
		System.out.println(" ");
		while(set.size()<numSize){
			numSize = numSize-set.size();
			//¼ÌÐøÑ­»·
			addNumber(min,max,numSize,set);
			}
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
