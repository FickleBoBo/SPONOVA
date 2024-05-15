package com.gens.service.user;

import java.util.List;

import com.gens.dto.user.User;

public interface UserService {
	
	// 전체
	List<User> getUserList();
	
	// 로그인
	User login(String userID, String userPW);

}
