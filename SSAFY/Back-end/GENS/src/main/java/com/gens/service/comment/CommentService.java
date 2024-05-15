package com.gens.service.comment;

import java.util.List;

import com.gens.dto.comment.Comment;

public interface CommentService {
	
	// 특정 게시글에 대한 모든 댓글 조회
	public List<Comment> getCommentList(int postID);
		
	// 댓글 등록
	void addComment(Comment comment);

    // 댓글 수정
	void updateComment(Comment comment);

    // 댓글 삭제
	void removeComment(int commentID);

}
