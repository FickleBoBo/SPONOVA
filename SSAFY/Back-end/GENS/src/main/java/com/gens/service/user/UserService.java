package com.gens.service.user;

import java.util.List;

import com.gens.dto.user.User;

public interface UserService {
	
	// 전체 회원 조회
	List<User> getUserList();
	
	// 회원 가입 하기
	void signup(User user);
	
	// 로그인 하기
	User login(String userID, String userPW);

}
