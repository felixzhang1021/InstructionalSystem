package com.dlnu.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.StudentTestDao;
import com.dlnu.model.Grade;
import com.dlnu.model.PaperDetail;
import com.dlnu.model.Question;
import com.dlnu.model.TestPaper;
@Repository
public class StuentTestDaoImpl implements StudentTestDao{
	private SessionFactory sessionFactory;
	public List<TestPaper> testPaperList() throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Query query=session.createQuery("from TestPaper t where t.paperStatus='½øÐÐÖÐ'");
		List<TestPaper> testPaperList=(List<TestPaper>)query.list();
		return testPaperList;
	}
	@Resource
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public List<PaperDetail> startTestPaper(int  paperId) throws Exception {
		Session session=this.getSession();
		List<PaperDetail> testPaper= new ArrayList<PaperDetail>();

			 Query query=session.createQuery("from PaperDetail p where p.paperId=?");
			 query.setInteger(0, paperId);
			 List<PaperDetail> questionList=(List<PaperDetail>)query.list();
			 for(int i=0;i<questionList.size();i++){
				 PaperDetail q = new PaperDetail();
				 q.setDetailId(questionList.get(i).getDetailId());
				 q.setPaperId(questionList.get(i).getPaperId());
				 q.setPaperName(questionList.get(i).getPaperName());
				 q.setQuestionId(questionList.get(i).getQuestionId());
				 q.setQuestions(questionList.get(i).getQuestions());
				 q.setOptionA(questionList.get(i).getOptionA());
				 q.setOptionB(questionList.get(i).getOptionB());
				 q.setOptionC(questionList.get(i).getOptionC());
				 q.setOptionD(questionList.get(i).getOptionD());
				 q.setAnswer(questionList.get(i).getAnswer());
				 q.setScore(questionList.get(i).getScore());
			     testPaper.add(q);
				 
			 }
			 
		return testPaper;
	}
	public int testCheck(String[] questionIdList, String[] answerList,
			int stuId, String stuName, int paperId, String paperName)
			throws Exception {
		// TODO Auto-generated method stub
		int stuScore=0;
		Session session=this.getSession();
		for(int i=0; i<questionIdList.length; i++){
			 Query query=session.createQuery("from PaperDetail p where p.questionId=?");
			 query.setString(0, questionIdList[i]);
			 @SuppressWarnings("unchecked")
			List<PaperDetail> bankQuestionList=(List<PaperDetail>)query.list();
			 System.out.println(bankQuestionList.get(0).getAnswer()+"   "+answerList[i]);
			 if(bankQuestionList.get(0).getAnswer().equals(answerList[i])){
				 stuScore = stuScore + bankQuestionList.get(0).getScore();
				 System.out.print(stuScore+"  ");
			 }
		}
		Grade grade = new Grade();
		grade.setStuId(stuId);
		grade.setStuName(stuName);
		grade.setPaperId(paperId);
		grade.setPaperName(paperName);
		grade.setStuScore(stuScore);
		session.save(grade);
		session.flush();
		return 1;
	}

}
