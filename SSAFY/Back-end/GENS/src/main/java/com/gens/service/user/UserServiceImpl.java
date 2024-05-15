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
	public void signup(User user) {
		userDao.insertUser(user);
	}
	
	
	@Override
	public User login(String userID, String userPW) {
		Map<String, String> info = new HashMap<>();
		info.put("userID", userID);
		info.put("userPW", userPW);
		return userDao.selectOne(info);
	}

//	// front에서 처리하는게 낫지만 임시방편
//	@Override
//    public void signup(User user) {
//        validateClubID(user.getClubID1());
//        validateClubID(user.getClubID2());
//        validateClubID(user.getClubID3());
//        userDao.insertUser(user);
//    }
//
//    private void validateClubID(String clubID) {
//        if (clubID != null && !clubID.isEmpty()) {
//            if (!clubExists(clubID)) {
//                throw new IllegalArgumentException("Club ID " + clubID + " does not exist.");
//            }
//        }
//    }
//
//    private boolean clubExists(String clubID) {
//        // 데이터베이스 또는 캐시에서 clubID의 존재 여부를 확인하는 로직
//        return true; // 예시를 위한 더미 반환 값
//    }


}
