package com.dlnu.dao.impl;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.PaperDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.PaperDetail;
import com.dlnu.model.Question;
import com.dlnu.model.Student;
import com.dlnu.model.TestPaper;
import com.dlnu.util.StringUtil;
@Repository
public class PaperDaoImpl implements PaperDao{
	
	private SessionFactory sessionFactory;
	public List<TestPaper> paperList(PageBean pageBean, TestPaper paper)
			throws Exception {
		List<TestPaper> paperList=null;
		StringBuffer sb = new StringBuffer("from TestPaper t");
		Session session = this.getSession();
		Query query = session.createQuery(sb.toString().replaceFirst("and", "where"));
		if(pageBean!=null){
			query.setFirstResult(pageBean.getStart());
			query.setMaxResults(pageBean.getRows());
		}
		paperList=(List<TestPaper>)query.list();
		return paperList;
	}

	public int paperCount(TestPaper paper) throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from testpaper t where 1=1");
		if(StringUtil.isNotEmpty(paper.getPaperName())){
			sb.append("and t.paperName like '%"+paper.getPaperName()+"%'");
		}
		Session session = this.getSession();
		Query query = session.createSQLQuery(sb.toString());
		return ((BigInteger)query.uniqueResult()).intValue();
	}

	public int paperDelete(String delIds) throws Exception {
		Session session=this.getSession();
		Query query=session.createSQLQuery("delete from testpaper where paperId in("+delIds+")");
		int count=query.executeUpdate();
		return count;
	}

	public int paperSave(TestPaper paper) throws Exception {
		Session session=this.getSession();
		TestPaper t = (TestPaper)session.merge(paper);
		System.out.println("-testpaper-->>"+t.getPaperId());
		int numSize=t.getQuestionCount();
		HashSet<Integer> set = new HashSet<Integer>(); 
		addNumber(1,45,20,set);
		 for (int j : set) {  
			 j=j+1;
			 Query query=session.createQuery("from Question q where q.questionId=?");
			 query.setInteger(0, j);
			 List<Question> questionList=(List<Question>)query.list();
			 System.out.println("--questionListSize->>"+ questionList.size());
			 System.out.println("--questionList--->>"+questionList.get(0).getOptionA());
		     PaperDetail p = new PaperDetail();
		     p.setPaperId(t.getPaperId());
		     p.setPaperName(t.getPaperName());
		     p.setQuestionId(questionList.get(0).getQuestionId());
		     p.setQuestions(questionList.get(0).getQuestions());
		     p.setOptionA(questionList.get(0).getOptionA());
		     p.setOptionB(questionList.get(0).getOptionB());
		     p.setOptionC(questionList.get(0).getOptionC());
		     p.setOptionD(questionList.get(0).getOptionD());
		     p.setAnswer(questionList.get(0).getAnswer());
		     p.setScore(questionList.get(0).getScore());
			 session.save(p);
		     session.flush();
		 }

		return 1;
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
			//继续循环
			addNumber(min,max,numSize,set);
			}
	}
	
	public int paperReleaseSave(TestPaper paper) throws Exception {
		Session session = this.getSession();
		Transaction trans=session.beginTransaction();
		String hql="update  TestPaper t set t.paperStatus='进行中' where t.paperId="+paper.getPaperId()+"";
		Query queryupdate=session.createQuery(hql);
		int ret=queryupdate.executeUpdate();
		return 1;
	}
	@Resource
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public List<TestPaper> showHistoryPaper() throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Query query=session.createQuery("from TestPaper t where t.paperStatus='已考'");
		List<TestPaper> testPaperList=(List<TestPaper>)query.list();
		return testPaperList;
	}

}
