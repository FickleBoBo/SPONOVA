package com.gens.dto.league;

import java.time.LocalDate;

public class League {
	
	private String leagueID;
    private String gameID;
    private LocalDate gameDay;
    private String location;
    private String clubID;
    private String oppClubID;
    private int gf;
    private int ga;
    private int points;
    private int result;
	
    
    public League() {
		super();
	}


	public League(String leagueID, String gameID, LocalDate gameDay, String location, String clubID, String oppClubID,
			int gf, int ga, int points, int result) {
		super();
		this.leagueID = leagueID;
		this.gameID = gameID;
		this.gameDay = gameDay;
		this.location = location;
		this.clubID = clubID;
		this.oppClubID = oppClubID;
		this.gf = gf;
		this.ga = ga;
		this.points = points;
		this.result = result;
	}


	public String getLeagueID() {
		return leagueID;
	}


	public void setLeagueID(String leagueID) {
		this.leagueID = leagueID;
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


	public int getGf() {
		return gf;
	}


	public void setGf(int gf) {
		this.gf = gf;
	}


	public int getGa() {
		return ga;
	}


	public void setGa(int ga) {
		this.ga = ga;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "League [leagueID=" + leagueID + ", gameID=" + gameID + ", gameDay=" + gameDay + ", location=" + location
				+ ", clubID=" + clubID + ", oppClubID=" + oppClubID + ", gf=" + gf + ", ga=" + ga + ", points=" + points
				+ ", result=" + result + "]";
	}
    

}
