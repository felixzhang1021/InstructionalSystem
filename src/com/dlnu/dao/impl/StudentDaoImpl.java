package com.dlnu.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.StudentDao;
import com.dlnu.model.PageBean;
import com.dlnu.model.Student;
import com.dlnu.util.StringUtil;
@Repository
public class StudentDaoImpl implements StudentDao{
	
	private SessionFactory sessionFactory;
	
	public Student login(Student student) throws Exception {
		Student resultStu = null;
		Session session = this.getSession();
		System.out.println(student.getPassword()+"studentDao");
		Query query=session.createQuery("from Student s where s.stuId=? and s.password=?");
		query.setString(0, student.getStuNo());
		query.setString(1, student.getPassword());
		@SuppressWarnings("unchecked")
		List<Student> studentList=(List<Student>)query.list();
		if(studentList.size()>0){
			resultStu=studentList.get(0);
		}
		return resultStu;
	}
	
	@Resource
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public List<Student> studentList(PageBean pageBean, Student student,
			String bbirthday, String ebirthday) throws Exception {
		List<Student> studentList=null;
		StringBuffer sb=new StringBuffer("from Student s");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuSex())){
			sb.append(" and s.stuSex ='"+student.getStuSex()+"'");
		}

		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(s.stuBirthday)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(s.stuBirthday)<=TO_DAYS('"+ebirthday+"')");
		}
		Session session=this.getSession();
		
		Query query=session.createQuery(sb.toString().replaceFirst("and", "where"));
		if(pageBean!=null){
			query.setFirstResult(pageBean.getStart());
			query.setMaxResults(pageBean.getRows());
		}
		studentList=(List<Student>)query.list();
		return studentList;
	
	}

	public int studentCount(Student student, String bStuBirthday, String eStuBirthday)
			throws Exception {
		StringBuffer sb=new StringBuffer("select count(*) as total from student s where 1=1 ");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuSex())){
			sb.append(" and s.stuSex ='"+student.getStuSex()+"'");
		}
		if(StringUtil.isNotEmpty(bStuBirthday)){
			sb.append(" and TO_DAYS(s.stuBirthday)>=TO_DAYS('"+bStuBirthday+"')");
		}
		if(StringUtil.isNotEmpty(eStuBirthday)){
			sb.append(" and TO_DAYS(s.stuBirthday)<=TO_DAYS('"+eStuBirthday+"')");
		}
		Session session=this.getSession();
		Query query=session.createSQLQuery(sb.toString());
		return ((BigInteger)query.uniqueResult()).intValue();
	}

	public int studentDelete(String delIds) throws Exception {
		Session session=this.getSession();
		Query query=session.createSQLQuery("delete from student where stuId in("+delIds+")");
		int count=query.executeUpdate();
		return count;
	}

	public int studentSave(Student student) throws Exception {
		Session session=this.getSession();
		student.setPassword("123456");
		System.out.println(student.getStuId()+"update");
		session.merge(student);
		return 1;
	}

/*	public boolean getStudentByGradeId(String gradeId) throws Exception {
		Session session=this.getSession();
		Query query=session.createSQLQuery("select count(*) from student where gradeId=?");
		query.setParameter(0, gradeId);	
		if(((BigInteger)query.uniqueResult()).intValue()>0){
			return true;
		}else{
			return false;
		}
	}*/
}
