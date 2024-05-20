package com.gens.service.league;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gens.dao.league.LeagueDao;
import com.gens.dto.league.League;
import com.gens.dto.league.LeagueCombined;
import com.gens.dto.league.LeagueRanking;
import com.gens.dto.league.LeagueToday;

@Service
public class LeagueServiceImpl implements LeagueService{

	private final LeagueDao leagueDao;
	
	@Autowired
	public LeagueServiceImpl(LeagueDao leagueDao) {
		this.leagueDao = leagueDao;
	}
	
	// League 객체를 전체 조회한다.
	@Override
	public List<League> getLeagueList() {
		return leagueDao.selectAll();
	}


	// LeagueRanking 클래스를 통해 리그 랭킹을 전체 출력한다.
	@Override
	public List<LeagueRanking> getLeagueRankings() {
		return leagueDao.selectRankings();
	}

//	// 종목 별 리그
//	@Override
//	public List<LeagueRanking> getLeagueRankingByGameID(String gameID) {
//		return leagueDao.selectRankingByGameID(gameID);
//	}
//
//	// 오늘의 경기
//	@Override
//	public List<LeagueToday> getTodaysGames(String date) {
//		return leagueDao.selectTodaysGames(date);
//	}
	
	// combination
	@Override
    public LeagueCombined getLeagueDetailsByGameID(String gameID) {
        List<LeagueRanking> rankings = leagueDao.selectRankingByGameID(gameID);
        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        List<LeagueToday> todayGames = leagueDao.selectTodaysGamesByGameID(today, gameID);
        return new LeagueCombined(rankings, todayGames);
    }

	
	
}
