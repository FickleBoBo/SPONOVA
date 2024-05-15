package com.gens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gens.dto.comment.Comment;
import com.gens.service.comment.CommentService;

@RestController
@RequestMapping("/newsports/community/posts/{postID}")
public class CommentController {
	
	private final CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
//	// 댓글 조회
//	@GetMapping
//	public ResponseEntity<List<Comment>> getAllCommentsForPost(@PathVariable int postID){
//		List<Comment> comments = commentService.getCommentList(postID);
//		return new ResponseEntity<>(comments, HttpStatus.OK);
//	}
	
	// 댓글 작성
    @PostMapping
    public ResponseEntity<Comment> createComment(@PathVariable int postID, @RequestBody Comment comment) {
        comment.setPostID(postID);
        commentService.addComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    
    // 댓글 삭제
    @DeleteMapping("/{commentID}")
    public ResponseEntity<Void> deleteComment(@PathVariable int postID, @PathVariable int commentID) {
        commentService.removeComment(commentID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // 댓글 수정
    @PutMapping("/{commentID}")
    public ResponseEntity<Void> updateComment(@PathVariable("postID") int postID, @PathVariable("commentID") int commentID, @RequestBody Comment comment) {
    	comment.setCommentID(commentID);
        commentService.updateComment(comment);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	

}
