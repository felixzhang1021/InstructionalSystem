package com.dlnu.dao;

import java.util.List;

import com.dlnu.model.Comment;

public interface CommentDao {
	public List<Comment> showCommentList(int messageId) throws Exception;
	
	public int save(Comment comment) throws Exception;
}
