package com.dlnu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlnu.dao.MessageDao;
import com.dlnu.model.Message;
@Repository
public class MessageDaoImpl implements MessageDao{
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Message> showMessageList() throws Exception {
		// TODO Auto-generated method stub
			List<Message> messageList=null;
			StringBuffer sb = new StringBuffer("from Message m");
			Session session = this.getSession();
			Query query = session.createQuery(sb.toString().replaceFirst("and", "where"));
			messageList=(List<Message>)query.list();
			return messageList;
	}
	
	public List<Message> showMessageById(int messageId) throws Exception {
		// TODO Auto-generated method stub
		List<Message> messageList=null;
		Session session = this.getSession();
		Query query=session.createQuery("from Message m where m.messageId=?");
		query.setInteger(0, messageId);
		messageList=(List<Message>)query.list();
		return messageList;
	}
	
	public int save(Message message) throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(message);
		session.flush();
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
