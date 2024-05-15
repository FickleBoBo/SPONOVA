package com.gens.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gens.dao.comment.CommentDao;
import com.gens.dto.comment.Comment;

@Service
public class CommentServiceImpl implements CommentService{

	private final CommentDao commentDao;
	
	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	
	@Override
	public List<Comment> getCommentList(int postID) {
		return commentDao.selectById(postID);
	}

	@Override
	public void addComment(Comment comment) {
		commentDao.insertComment(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}

	@Override
	public void removeComment(int commentID) {
		commentDao.deleteComment(commentID);
	}

}
