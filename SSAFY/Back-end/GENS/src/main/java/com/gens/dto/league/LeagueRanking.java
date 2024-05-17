package com.gens.dto.league;

// League 클래스는 가공되지 않는 데이터를 처리
// 복잡한 sql문 계산을 위한 별도의 클래스로 랭킹 관리
// 간단하게 말하자면 목적이 달라서 분리 + 확장성
public class LeagueRanking {
	
	private int ranking;
	private String ClubID;
	private int totalPoints;
	
	public LeagueRanking() {
	}

	public LeagueRanking(int ranking, String clubID, int totalPoints) {
		this.ranking = ranking; //랭킹 1~
		ClubID = clubID; // 별도의 ClubID 가 아님
		this.totalPoints = totalPoints; // 승점의 총합
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getClubID() {
		return ClubID;
	}

	public void setClubID(String clubID) {
		ClubID = clubID;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	@Override
	public String toString() {
		return "LeagueRanking [ranking=" + ranking + ", ClubID=" + ClubID + ", totalPoints=" + totalPoints + "]";
	}
	
		

}
