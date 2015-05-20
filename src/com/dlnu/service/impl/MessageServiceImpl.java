package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dlnu.dao.MessageDao;
import com.dlnu.model.Message;
import com.dlnu.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{
	@Resource
	private MessageDao messageDao;
	public List<Message> showMessageService() throws Exception {
		// TODO Auto-generated method stub
		return messageDao.showMessageList();
	}
	public List<Message> showMessageById(int messageId) throws Exception {
		// TODO Auto-generated method stub
		return messageDao.showMessageById(messageId);
	}
	public int save(Message message) throws Exception {
		// TODO Auto-generated method stub
		return messageDao.save(message);
	}

}
