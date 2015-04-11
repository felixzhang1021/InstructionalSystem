package com.dlnu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.TeacherDao;
import com.dlnu.model.Teacher;
@Repository
public class TeacherDaoImpl implements TeacherDao{
	
	private SessionFactory sessionFactory;
	
	public Teacher login(Teacher teacher) throws Exception {
		Teacher resultTea = null;
		Session session = this.getSession();
		Query query=session.createQuery("from Teacher t where t.teacherId=? and t.password=?");
		query.setString(0, teacher.getTeacherId());
		query.setString(1, teacher.getPassword());
		@SuppressWarnings("unchecked")
		List<Teacher> teacherList=(List<Teacher>)query.list();
		if(teacherList.size()>0){
			resultTea=teacherList.get(0);
		}
		return resultTea;
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
