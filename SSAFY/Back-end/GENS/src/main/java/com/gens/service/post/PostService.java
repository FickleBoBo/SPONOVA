package com.gens.service.post;

import java.util.List;

import com.gens.dto.SearchCondition;
import com.gens.dto.post.Post;

public interface PostService {
	
	// 전체 조회
	List<Post> getPostList();
	
	// 상세 조회
	Post readPost(int postID);
	
	// 등록
	void addPost(Post post);
	
	// 수정
	void modifyPost(Post post);
	
	// 삭제
	void removePost(int postID);
	
	// 검색
	List<Post> retrievePost(SearchCondition searchCondition);
	
	// 조회수 증가
	void increaseViewCnt(int postID);
	
	// 이미지 파일 처리
	

}
