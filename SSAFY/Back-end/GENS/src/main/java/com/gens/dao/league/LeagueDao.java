package com.gens.dao.league;

import java.util.List;

import com.gens.dto.league.League;
import com.gens.dto.league.LeagueRanking;

public interface LeagueDao {
	
	// 전체 조회
	List<League> selectAll();
	
	// 랭킹 조회
	List<LeagueRanking> selectRankings();

	List<LeagueRanking> selectRankingByGameID(String gameID);

}
