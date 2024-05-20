package com.gens.dao.league;

import java.util.List;

import com.gens.dto.league.League;
import com.gens.dto.league.LeagueRanking;
import com.gens.dto.league.LeagueToday;

public interface LeagueDao {
	
	// 전체 조회
	List<League> selectAll();
	
	// 랭킹 조회
	List<LeagueRanking> selectRankings();

	// 게임 별 랭킹 조회
	List<LeagueRanking> selectRankingByGameID(String gameID);
	
	// 오늘의 경기 출력 (날짜, 종목)
//	List<LeagueToday> selectTodaysGames(String date);
    List<LeagueToday> selectTodaysGamesByGameID(String date, String gameID); 

}
