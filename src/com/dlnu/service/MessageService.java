package com.dlnu.service;

import java.util.List;


import com.dlnu.model.Message;
public interface MessageService {
	public List<Message> showMessageService() throws Exception;
	public List<Message> showMessageById(int messageId) throws Exception;
	public int save(Message message) throws Exception;
}
