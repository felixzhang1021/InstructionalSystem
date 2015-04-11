package com.dlnu.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.QuestionDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.Question;
import com.dlnu.util.StringUtil;
@Repository
public class QuestionDaoImpl implements QuestionDao{
	
	private SessionFactory sessionFactory;
	public List<Question> questionList(PageBean pageBean, Question question)
			throws Exception {
		List<Question> questionList=null;
		StringBuffer sb = new StringBuffer("from Question q");
		Session session = this.getSession();
		Query query = session.createQuery(sb.toString().replaceFirst("and", "where"));
		if(pageBean!=null){
			query.setFirstResult(pageBean.getStart());
			query.setMaxResults(pageBean.getRows());
		}
		questionList=(List<Question>)query.list();
		return questionList;
	}

	public int questionCount(Question question) throws Exception {
		StringBuffer sb=new StringBuffer("select count(*) as total from questionbank q where 1=1");
		if(StringUtil.isNotEmpty(question.getQuestions())){
			sb.append(" and q.question like '%"+question.getQuestions()+"%'");
		}
		Session session = this.getSession();
		Query query = session.createSQLQuery(sb.toString());
		return ((BigInteger)query.uniqueResult()).intValue();
	}

	public int questionDelete(String delIds) throws Exception {
		Session session=this.getSession();
		Query query=session.createSQLQuery("delete from question where questionId in("+delIds+")");
		int count=query.executeUpdate();
		return count;
	}

	public int questionSave(Question question) throws Exception {
		Session session=this.getSession();
		session.merge(question);
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
}
