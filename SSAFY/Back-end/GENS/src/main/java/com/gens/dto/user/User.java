package com.gens.dto.user;

public class User {
	
	 private String userID;
	 private String userPW;
	 private String username;
	 private String userRRN;
	 private String userPhonenumber;
	 private String userNickname;
	 private String userProfilePath;
	 private String clubID1;
	 private String clubID2;
	 private String clubID3;
 
	 public User() {
	 }
	
	 

	public User(String userID, String userPW, String username, String userRRN, String userPhonenumber,
			String userNickname, String userProfilePath, String clubID1, String clubID2, String clubID3) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.username = username;
		this.userRRN = userRRN;
		this.userPhonenumber = userPhonenumber;
		this.userNickname = userNickname;
		this.userProfilePath = userProfilePath;
		this.clubID1 = clubID1;
		this.clubID2 = clubID2;
		this.clubID3 = clubID3;
	}



	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserPW() {
		return userPW;
	}
	
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserRRN() {
		return userRRN;
	}
	
	public void setUserRRN(String userRRN) {
		this.userRRN = userRRN;
	}
	
	public String getUserPhonenumber() {
		return userPhonenumber;
	}
	
	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}
	
	public String getUserNickname() {
		return userNickname;
	}
	
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
	public String getUserProfilePath() {
		return userProfilePath;
	}
	
	public void setUserProfilePath(String userProfilePath) {
		this.userProfilePath = userProfilePath;
	}

	public String getClubID1() {
		return clubID1;
	}

	public void setClubID1(String clubID1) {
		this.clubID1 = clubID1;
	}

	public String getClubID2() {
		return clubID2;
	}

	public void setClubID2(String clubID2) {
		this.clubID2 = clubID2;
	}

	public String getClubID3() {
		return clubID3;
	}

	public void setClubID3(String clubID3) {
		this.clubID3 = clubID3;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userPW=" + userPW + ", username=" + username + ", userRRN=" + userRRN
				+ ", userPhonenumber=" + userPhonenumber + ", userNickname=" + userNickname + ", userProfilePath="
				+ userProfilePath + ", clubID1=" + clubID1 + ", clubID2=" + clubID2 + ", clubID3=" + clubID3 + "]";
	}


}
