package com.gens.dto.league;

import java.util.List;

// 리그 별 랭킹과 리그 별 오늘의 경기를 합친 클래스 입니다.
public class LeagueCombined {
	
	// 2개의 dto를 불러온다
    private List<LeagueRanking> rankings;
    private List<LeagueToday> todayGames;
	
    public LeagueCombined() {
    	
	}

	public LeagueCombined(List<LeagueRanking> rankings, List<LeagueToday> todayGames) {
		super();
		this.rankings = rankings;
		this.todayGames = todayGames;
	}

	// 기본 getter/setter들
	public List<LeagueRanking> getRankings() {
		return rankings;
	}

	public void setRankings(List<LeagueRanking> rankings) {
		this.rankings = rankings;
	}

	public List<LeagueToday> getTodayGames() {
		return todayGames;
	}

	public void setTodayGames(List<LeagueToday> todayGames) {
		this.todayGames = todayGames;
	}

	@Override
	public String toString() {
		return "LeagueCombined [rankings=" + rankings + ", todayGames=" + todayGames + "]";
	}
    
        

}
