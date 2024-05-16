package com.gens.dao.club;

import java.util.List;

import com.gens.dto.SearchCondition;
import com.gens.dto.club.Club;

public interface ClubDao {
	
	// 전체 조회
	List<Club> selectAll();
	
	// 종목 검색
	List<Club> searchClub(SearchCondition searchCondition);

}
