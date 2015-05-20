package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.Message;

public interface MessageDao {
	public List<Message> showMessageList()throws Exception;
	public List<Message> showMessageById(int messageId) throws Exception; 
	public int save(Message message) throws Exception;
}
