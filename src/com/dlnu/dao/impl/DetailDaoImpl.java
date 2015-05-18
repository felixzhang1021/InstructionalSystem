package com.dlnu.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.DetailDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.PaperDetail;
import com.dlnu.model.TestPaper;
import com.dlnu.util.StringUtil;
@Repository
public class DetailDaoImpl implements DetailDao{
	private SessionFactory sessionFactory;
	public List<PaperDetail> paperDetailList(
			PaperDetail paperDetail) throws Exception {
		List<PaperDetail> paperDetailList=null;
		Session session = this.getSession();
		Query query = session.createQuery("from PaperDetail p where paperId=?");
		query.setInteger(0, paperDetail.getPaperId());
		paperDetailList=(List<PaperDetail>)query.list();
		return paperDetailList;
	}

	public int paperDetailCount(PaperDetail paperDetail) throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from paperdetail p where 1=1 ");
		if(paperDetail.getPaperId()!=-1){
			sb.append("and p.paperId = '"+paperDetail.getPaperId()+"'");
		}
		Session session = this.getSession();
		Query query = session.createSQLQuery(sb.toString());
		System.out.println("*&*&*    "+((BigInteger)query.uniqueResult()).intValue());
		return ((BigInteger)query.uniqueResult()).intValue();
	}

	public int paperDetailSave(PaperDetail paperDetail) throws Exception {
		Session session=this.getSession();
		System.out.println("DetailSave");
		PaperDetail p = (PaperDetail)session.merge(paperDetail);
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
