package com.gens.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gens.dao.user.UserDao;
import com.gens.dto.user.User;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public User login(String userID, String userPW) {
		Map<String, String> info = new HashMap<>();
		info.put("userID", userID);
		info.put("userPW", userPW);
		return userDao.selectOne(info);
	}
	
	

}
