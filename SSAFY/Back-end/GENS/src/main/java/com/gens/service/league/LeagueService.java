package com.gens.service.league;

import java.util.List;

import com.gens.dto.league.League;
import com.gens.dto.league.LeagueRanking;

public interface LeagueService {
	
	// 전체 조회
	List<League> getLeagueList();
	
	// Ranking
	List<LeagueRanking> getLeagueRankings();

}
