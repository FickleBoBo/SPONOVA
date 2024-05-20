package com.gens.service.league;

import java.util.List;

import com.gens.dto.league.League;
import com.gens.dto.league.LeagueCombined;
import com.gens.dto.league.LeagueRanking;

public interface LeagueService {
	
	// 전체 조회
	List<League> getLeagueList();
	
	// Ranking
	List<LeagueRanking> getLeagueRankings();
	
//	// 리그별 랭킹
//	List<LeagueRanking> getLeagueRankingByGameID(String gameID);
//	
//	// 오늘의 경기
//	List<LeagueToday> getTodaysGames(String date);
	
	// combination
	LeagueCombined getLeagueDetailsByGameID(String gameID);

}
