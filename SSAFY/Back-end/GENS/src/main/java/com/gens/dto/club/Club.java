package com.gens.dto.club;

public class Club {
	
	private String clubID;
    private String gameID;
    private String location;
    private String clubLogoPath;
    private String clubPhotoPath;
    private String clubContent;
    private int clubPoint;
	
    
    public Club() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Club(String clubID, String gameID, String location, String clubLogoPath, String clubPhotoPath,
			String clubContent, int clubPoint) {
		super();
		this.clubID = clubID;
		this.gameID = gameID;
		this.location = location;
		this.clubLogoPath = clubLogoPath;
		this.clubPhotoPath = clubPhotoPath;
		this.clubContent = clubContent;
		this.clubPoint = clubPoint;
	}


	public String getClubID() {
		return clubID;
	}


	public void setClubID(String clubID) {
		this.clubID = clubID;
	}


	public String getGameID() {
		return gameID;
	}


	public void setGameID(String gameID) {
		this.gameID = gameID;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getClubLogoPath() {
		return clubLogoPath;
	}


	public void setClubLogoPath(String clubLogoPath) {
		this.clubLogoPath = clubLogoPath;
	}


	public String getClubPhotoPath() {
		return clubPhotoPath;
	}


	public void setClubPhotoPath(String clubPhotoPath) {
		this.clubPhotoPath = clubPhotoPath;
	}


	public String getClubContent() {
		return clubContent;
	}


	public void setClubContent(String clubContent) {
		this.clubContent = clubContent;
	}


	public int getClubPoint() {
		return clubPoint;
	}


	public void setClubPoint(int clubPoint) {
		this.clubPoint = clubPoint;
	}


	@Override
	public String toString() {
		return "Club [clubID=" + clubID + ", gameID=" + gameID + ", location=" + location + ", clubLogoPath="
				+ clubLogoPath + ", clubPhotoPath=" + clubPhotoPath + ", clubContent=" + clubContent + ", clubPoint="
				+ clubPoint + "]";
	}
    
    

}
