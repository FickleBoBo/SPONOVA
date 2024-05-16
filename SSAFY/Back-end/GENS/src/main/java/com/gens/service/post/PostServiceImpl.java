package com.gens.service.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gens.dao.post.PostDao;
import com.gens.dto.SearchCondition;
import com.gens.dto.post.Post;

@Service
public class PostServiceImpl implements PostService{

	private final PostDao postDao;
	
	@Autowired
	public PostServiceImpl(PostDao postDao) {
		this.postDao  = postDao;
	}
	
	// 전체 조회
	@Override
	public List<Post> getPostList() {
		return postDao.selectAll();
	}

	// 상세 조회
	@Override
	public Post readPost(int postID) {
		return postDao.selectOne(postID);
	}


	// 게시물 등록
	@Override
	public void addPost(Post post) {
		postDao.insertPost(post);
	}


	// 게시물 수정
	@Override
	public void modifyPost(Post post) {
		postDao.updatePost(post);
	}


	// 게시물 삭제
	@Override
	public void removePost(int postID) {
		postDao.deletePost(postID);
	}


	// 게시물 검색
	@Override
	public List<Post> retrievePost(SearchCondition searchCondition) {
		return postDao.searchPost(searchCondition);
	}
	

	// 조회수 증가
	@Override
	public void increaseViewCnt(int postID) {
		postDao.updateViewCnt(postID);
	}

}
