package com.gens.dao.user;

import java.util.List;
import java.util.Map;

import com.gens.dto.user.User;

public interface UserDao {
	
	// 전체 회원 조회
	List<User> selectAll();
	
	// 회원 가입
	void insertUser(User user);
	
	// 로그인
	User selectOne(Map<String, String> info);

	// 중복 ID 검사
	User findById(String userId);
	
	// 중복 폰번호 검사
	User findByPhonenumber(String userPhonenumber);
	
	// 중복 닉네임 검사
	User findByNickname(String userNickname);
	

}
