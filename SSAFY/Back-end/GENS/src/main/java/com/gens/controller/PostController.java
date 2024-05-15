package com.gens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gens.dto.SearchCondition;
import com.gens.dto.comment.Comment;
import com.gens.dto.post.Post;
import com.gens.service.comment.CommentService;
import com.gens.service.post.PostService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/newsports/community")
@CrossOrigin("*")
public class PostController {

	private PostService postService;
	private CommentService commentService;
	
	@Autowired
	public PostController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}
	
	// 내부 클래스 사용하여 응답 데이터 포맷 정의
    static class PostDetailResponse {
        private Post post;
        private List<Comment> comments;

        public PostDetailResponse(Post post, List<Comment> comments) {
            this.post = post;
            this.comments = comments;
        }

		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}

		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}

    }
	
	// 전체 조회
	@GetMapping("/posts")
	@Operation(summary="전체 조회")
	public ResponseEntity<?> list(){
		List<Post> list = postService.getPostList();
		return new ResponseEntity<List<Post>>(list, HttpStatus.OK);
	}
	
	
	// 상세 조회(게시글 번호)
	@GetMapping("posts/{postID}")
	@Operation(summary="상세 조회")
	public ResponseEntity<PostDetailResponse> getPostDetailWithComments(@PathVariable int postID) {
        Post post = postService.readPost(postID);
        List<Comment> comments = commentService.getCommentList(postID);
        PostDetailResponse response = new PostDetailResponse(post, comments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
	// 게시글 작성
	@PostMapping("/posts")
	@Operation(summary="작성")
	public ResponseEntity<?> createPost(@RequestBody Post post){
		postService.addPost(post);
		return new ResponseEntity<Post>(post, HttpStatus.CREATED);
	}
	
	
	// 게시글 수정
	@PutMapping("/posts/{postID}")
	@Operation(summary="수정")
	public ResponseEntity<Void> updatePost(@PathVariable("postID") int postID ,@RequestBody Post post){
		post.setPostID(postID);
		postService.modifyPost(post);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	// 게시글 삭제
	@DeleteMapping("/posts/{postID}")
	@Operation(summary="삭제")
	public ResponseEntity<Void> deletePost(@PathVariable int postID){
		postService.removePost(postID);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	// 게시글 검색
	// swagger 테스트 시 입력 예시(제목에 barca라는 단어가 포함되는지?): (key: postTitle, word: barca)
	@GetMapping("/posts/search")
	@Operation(summary="검색")
	public ResponseEntity<?> searchPost(@RequestParam String key, @RequestParam String word){
		
		SearchCondition condition = new SearchCondition();
		condition.setKey(key);
		condition.setWord(word);
		
		List<Post> list = postService.retrievePost(condition);
		
		if(list == null || list.size() ==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Post>>(list, HttpStatus.OK);
	}
	
	
	
	
}
