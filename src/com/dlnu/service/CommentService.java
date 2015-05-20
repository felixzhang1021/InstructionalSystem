package com.dlnu.service;

import java.util.List;

import com.dlnu.model.Comment;

public interface CommentService {
	public List<Comment> showCommentList(int messageId) throws Exception;
	public int save(Comment comment) throws Exception;
}
