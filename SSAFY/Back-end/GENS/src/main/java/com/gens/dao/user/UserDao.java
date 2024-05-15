package com.gens.dao.user;

import java.util.List;
import java.util.Map;

import com.gens.dto.user.User;

public interface UserDao {
	
	// 전체 회원 조회
	List<User> selectAll();
	
	// 회원 조회, 로그인
	User selectOne(Map<String, String> info);

}
