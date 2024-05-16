package com.gens.service.club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gens.dao.club.ClubDao;
import com.gens.dto.SearchCondition;
import com.gens.dto.club.Club;

@Service
public class ClubServiceImpl implements ClubService{

	private final ClubDao clubDao;
	
	@Autowired
	public ClubServiceImpl(ClubDao clubDao) {
		this.clubDao = clubDao;
	}
	
	
	// 전체 조회
	@Override
	public List<Club> getClubList() {
		return clubDao.selectAll();
	}

	// 종목 검색
	@Override
	public List<Club> retrieveClub(SearchCondition searchCondition) {
		return clubDao.searchClub(searchCondition);
	}
	
	

}
