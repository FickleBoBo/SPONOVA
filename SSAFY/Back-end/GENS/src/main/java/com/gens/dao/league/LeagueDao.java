package com.gens.dao.league;

import java.util.List;

import com.gens.dto.league.League;

public interface LeagueDao {
	
	// 전체 조회
	List<League> selectAll();

}
