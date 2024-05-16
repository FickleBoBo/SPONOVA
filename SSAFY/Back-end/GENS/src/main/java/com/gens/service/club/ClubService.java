package com.gens.service.club;

import java.util.List;

import com.gens.dto.SearchCondition;
import com.gens.dto.club.Club;
import com.gens.dto.post.Post;

public interface ClubService {
	
	// 전체 조회
	List<Club> getClubList();
	
	// 종목 검색
	List<Club> retrieveClub(SearchCondition searchCondition);

}
