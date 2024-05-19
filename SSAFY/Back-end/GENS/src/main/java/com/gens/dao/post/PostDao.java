package com.gens.dao.post;

import java.util.List;
import java.util.Map;

import com.gens.dto.SearchCondition;
import com.gens.dto.post.Post;

// Mapper를 통해 데이터베이스와 연결되는 부분
// (요청 시 받아올 형식 / 메서드명 / 내가 요청시 보내는 객체)
public interface PostDao {
	
	// 전제 게시글 조회
	List<Post> selectAll();
	
	// 상세 게시글 조회
	Post selectOne(int postID);
	
	// 게시글 등록
	void insertPost(Post post);
	
	// 게시글 수정
	void updatePost(Post post);
	
	// 게시글 삭제
	void deletePost(int postID);
	
	// 게시글 검색
	List<Post> searchPost(SearchCondition searchCondition);
	
	// 조회수 증가
	void updateViewCnt(int postID);
	
	// 댓글 수 
	List<Post> selectCommentCnt();

	// 정렬(전체 조회 or 검색 시)
	List<Post> selectAll(Map<String, Object> params);
	
	// 이미지 파일 저장

}
