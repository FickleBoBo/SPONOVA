package com.gens.dao.comment;

import java.util.List;

import com.gens.dto.comment.Comment;

public interface CommentDao {
	
	//특정 게시글 댓글 조회
	List<Comment> selectById(int postID);
	
	//댓글 등록
	public void insertComment(Comment comment);
	
	//댓글 삭제
	public void deleteComment(int commentID);
	
	//댓글 수정
	public void updateComment(Comment comment);

}
