package com.gens.dto.league;

import java.time.LocalDate;

// 오늘의 경기
public class LeagueToday {
	
	// 변수명은 기본 table의 변수명과 같음
	private String matchId;
    private String gameID;
    private LocalDate gameDay;
    private String location;
    private String clubID;
    private String oppClubID;
	
    public LeagueToday() {
	}

	public LeagueToday(String matchId, String gameID, LocalDate gameDay, String location, String clubID,
			String oppClubID) {
		super();
		this.matchId = matchId;
		this.gameID = gameID;
		this.gameDay = gameDay;
		this.location = location;
		this.clubID = clubID;
		this.oppClubID = oppClubID;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public LocalDate getGameDay() {
		return gameDay;
	}

	public void setGameDay(LocalDate gameDay) {
		this.gameDay = gameDay;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getClubID() {
		return clubID;
	}

	public void setClubID(String clubID) {
		this.clubID = clubID;
	}

	public String getOppClubID() {
		return oppClubID;
	}

	public void setOppClubID(String oppClubID) {
		this.oppClubID = oppClubID;
	}


	@Override
	public String toString() {
		return "LeagueToday [matchId=" + matchId + ", gameID=" + gameID + ", gameDay=" + gameDay + ", location="
				+ location + ", clubID=" + clubID + ", oppClubID=" + oppClubID + "]";
	}
    
        
}
