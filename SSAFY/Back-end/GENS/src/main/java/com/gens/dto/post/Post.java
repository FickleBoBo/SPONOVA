 package com.gens.dto.post;

import java.time.LocalDateTime;

public class Post {
	
	private int postID;
	private String userID;
	private String userNickname;
	private String postTitle;
	private String postContent;
	private int postViewCnt;
	private int postLikeCnt;
	private LocalDateTime postRegDate; //LocalDateTime 사용: 날짜와 시간을 함께 다루기 위한 클래스, 하단 상세 설명
	private String postFilePath;
	
	public Post() {
	}

	public Post(int postID, String userID, String userNickname, String postTitle, String postContent, int postViewCnt, int postLikeCnt,
			LocalDateTime postRegDate, String postFilePath) {
		super();
		this.postID = postID;
		this.userID = userID;
		this.userNickname = userNickname;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postViewCnt = postViewCnt;
		this.postLikeCnt = postLikeCnt;
		this.postRegDate = postRegDate;
		this.postFilePath = postFilePath;
	}


	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickName(String userNickname) {
		this.userNickname = userNickname;
	}


	public String getPostTitle() {
		return postTitle;
	}


	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}


	public String getPostContent() {
		return postContent;
	}


	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}


	public int getPostViewCnt() {
		return postViewCnt;
	}


	public void setPostViewCnt(int postViewCnt) {
		this.postViewCnt = postViewCnt;
	}


	public int getPostLikeCnt() {
		return postLikeCnt;
	}


	public void setPostLikeCnt(int postLikeCnt) {
		this.postLikeCnt = postLikeCnt;
	}


	public LocalDateTime getPostRegDate() {
		return postRegDate;
	}


	public void setPostRegDate(LocalDateTime postRegDate) {
		this.postRegDate = postRegDate;
	}


	public String getPostFilePath() {
		return postFilePath;
	}

	public void setPostFilePath(String postFilePath) {
		this.postFilePath = postFilePath;
	}

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", userID=" + userID + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", postViewCnt=" + postViewCnt + ", postLikeCnt=" + postLikeCnt + ", postRegDate="
				+ postRegDate + ", postFilePath=" + postFilePath + "]";
	}
	
	
	
}


/* LocalDateTTime
 * 
 * 현재 날짜와 시간 생성: 
 * LocalDateTime now = LocalDateTime.now();
 * 
 * 특정 날짜와 시간 설정: LocalDateTime.of(year, month, dayOfMonth, hour, minute, second) 
 * LocalDateTime ldt = LocalDateTime.of(2024, 5, 11, 12, 0, 0);
 * 
 * 날짜와 시간의 포맷팅: DateTimeFormatter를 사용하여 LocalDateTime 객체를 문자열로 포맷팅할 수 있습니다.
 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 * String formattedDateTime = now.format(formatter); // 예: "2024-05-11 12:00:00"
 * 
 * 날짜와 시간의 조작: plusDays, minusHours 등의 메서드를 통해 LocalDateTime 객체에서 특정 기간을 더하거나 뺄 수 있습니다.
 * LocalDateTime tomorrow = now.plusDays(1);
 * LocalDateTime twoHoursAgo = now.minusHours(2);
 * 
 * 특정 필드의 값 추출: getYear(), getMonth(), getDayOfMonth(), getHour(), getMinute(), getSecond() 
 * int year = now.getYear();
 * int month = now.getMonthValue();
 * int day = now.getDayOfMonth();
*/
