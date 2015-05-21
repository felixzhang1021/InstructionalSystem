package com.dlnu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.CommentDao;
import com.dlnu.model.Comment;
@Repository
public class CommentDaoImpl implements CommentDao{
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Comment> showCommentList(int messageId) throws Exception{
		// TODO Auto-generated method stub
			Session session = this.getSession();
			Query query=session.createQuery("from Comment c where c.messageId=?");
			query.setInteger(0, messageId);
			List<Comment> commentList=(List<Comment>)query.list();
			return commentList;
	}
	@Resource
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public int save(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSession();      
		
		session.save(comment);//执行  
		session.flush();
		System.out.println("插入数据成功");
		return 1;
	}

}
