package com.dlnu.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.PaperDao;
import com.dlnu.model.PageBean;
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
