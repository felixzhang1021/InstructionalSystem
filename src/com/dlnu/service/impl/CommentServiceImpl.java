package com.dlnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dlnu.dao.CommentDao;
import com.dlnu.model.Comment;
import com.dlnu.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{
	@Resource
	private CommentDao commentDao;
	public List<Comment> showCommentList(int messageId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--commentService-->>"+messageId);
		return commentDao.showCommentList(messageId);
	}
	public int save(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		return commentDao.save(comment);
	}
	
}
