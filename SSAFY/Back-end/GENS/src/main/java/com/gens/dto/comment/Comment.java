package com.gens.dto.comment;

import java.time.LocalDateTime;

public class Comment {
	
	private int commentID;
	private String userID;
	private int postID;
	private String commentContent;
	private LocalDateTime commentRegDate;
	
	public Comment() {
	}

	public Comment(int commentID, String userID, int postID, String commentContent, LocalDateTime commentRegDate) {
		super();
		this.commentID = commentID;
		this.userID = userID;
		this.postID = postID;
		this.commentContent = commentContent;
		this.commentRegDate = commentRegDate;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public LocalDateTime getCommentRegDate() {
		return commentRegDate;
	}

	public void setCommentRegDate(LocalDateTime commentRegDate) {
		this.commentRegDate = commentRegDate;
	}

	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", userID=" + userID + ", postID=" + postID + ", commentContent="
				+ commentContent + ", commentRegDate=" + commentRegDate + "]";
	}

	
}
