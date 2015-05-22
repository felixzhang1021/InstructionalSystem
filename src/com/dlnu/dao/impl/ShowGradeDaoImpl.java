package com.dlnu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.ShowGradeDao;
import com.dlnu.model.Grade;

@Repository
public class ShowGradeDaoImpl implements ShowGradeDao{
	private SessionFactory sessionFactory;
	public List<Grade> studentShowGrade(int stuId) throws Exception {
		Session session=this.getSession();
		List<Grade> studentGradeList= new ArrayList<Grade>();

			 Query query=session.createQuery("from Grade g where g.stuId=?");
			 query.setInteger(0, stuId);
			 @SuppressWarnings("unchecked")
			List<Grade> gradeList=(List<Grade>)query.list();
			 for(int i=0;i<gradeList.size();i++){
				 Grade g = new Grade();
				 g.setGradeId(gradeList.get(i).getGradeId());
				 g.setStuId(gradeList.get(i).getStuId());
				 g.setStuName(gradeList.get(i).getStuName());
				 g.setPaperId(gradeList.get(i).getPaperId());
				 g.setPaperName(gradeList.get(i).getPaperName());
				 g.setStuScore(gradeList.get(i).getStuScore());
				 
				 studentGradeList.add(g);
				 
			 }
			 
		return studentGradeList;
	}
	@Resource
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public List<Grade> teacherShowGrade(int paperId) throws Exception {
		Session session=this.getSession();
		List<Grade> studentGradeList= new ArrayList<Grade>();

			 Query query=session.createQuery("from Grade g where g.paperId=?");
			 query.setInteger(0, paperId);
			 @SuppressWarnings("unchecked")
			List<Grade> gradeList=(List<Grade>)query.list();
			 for(int i=0;i<gradeList.size();i++){
				 Grade g = new Grade();
				 g.setGradeId(gradeList.get(i).getGradeId());
				 g.setStuId(gradeList.get(i).getStuId());
				 g.setStuName(gradeList.get(i).getStuName());
				 g.setPaperId(gradeList.get(i).getPaperId());
				 g.setPaperName(gradeList.get(i).getPaperName());
				 g.setStuScore(gradeList.get(i).getStuScore());
				 
				 studentGradeList.add(g);
				 
			 }
			 
		return studentGradeList;
	}
}
