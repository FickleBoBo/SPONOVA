DROP DATABASE ssafit;
CREATE DATABASE ssafit DEFAULT CHARACTER SET utf8mb4;
USE ssafit;

# 모든 사진 파일은 웹에서 주소를 가져오는 형식으로 진행한다.

CREATE TABLE Club (
    ClubID VARCHAR(30) NOT NULL UNIQUE PRIMARY KEY,            # 클럽 팀명
    GameID VARCHAR(20) NOT NULL,                           	   # 종목명
    Location VARCHAR(30) NOT NULL,                             # 클럽 위치
    ClubLogoPath VARCHAR(255),                                 # 클럽 로고(경로)
    ClubPhotoPath VARCHAR(255),                                # 클럽 사진(경로)
    ClubContent TEXT,                                          # 클럽 소개
    ClubPoint INT DEFAULT 0                                    # 현재 승점
);

CREATE TABLE User (
    UserID VARCHAR(30) NOT NULL UNIQUE PRIMARY KEY,       # 유저 아이디
    UserPW VARCHAR(20) NOT NULL,                          # 유저 비밀번호
    Username VARCHAR(20) NOT NULL,                        # 유저 이름
    UserRRN VARCHAR(8) NOT NULL,                          # 유저 주민등록번호
    UserPhonenumber VARCHAR(13) NOT NULL UNIQUE,          # 유저 전화번호
    UserNickname VARCHAR(10) NOT NULL UNIQUE,             # 유저 닉네임
    UserProfilePath VARCHAR(255),                         # 유저 프로필 사진(경로)
    ClubID1 VARCHAR(30),
    ClubID2 VARCHAR(30),
    ClubID3 VARCHAR(30),
    FOREIGN KEY (ClubID1) REFERENCES Club(ClubID),
    FOREIGN KEY (ClubID2) REFERENCES Club(ClubID),
    FOREIGN KEY (ClubID3) REFERENCES Club(ClubID)
);

CREATE TABLE Post (
    PostID INT AUTO_INCREMENT PRIMARY KEY,                 # 게시글 아이디
    UserID VARCHAR(30) NOT NULL,                           # 유저 아이디
    PostTitle VARCHAR(50) NOT NULL,                        # 게시글 제목
    PostContent TEXT NOT NULL,                             # 게시글 내용
    PostViewCnt INT DEFAULT 0,                             # 게시글 조회 수
    PostLikeCnt INT DEFAULT 0,                             # 게시글 추천 수
    PostRegDate DATETIME DEFAULT CURRENT_TIMESTAMP,        # 게시글 등록 시간
    PostFilePath VARCHAR(255),                             # 게시글 내 사진(경로)
    PostFileName VARCHAR(255),                             # 게시글 사진 파일 이름
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

CREATE TABLE Comment (
    UserID VARCHAR(30) NOT NULL,                              # 유저 아이디
    PostID INT NOT NULL,                                      # 게시글 아이디
    CommentID INT AUTO_INCREMENT PRIMARY KEY,                 # 댓글 아이디
    CommentContent TEXT NOT NULL,                             # 댓글 내용
    CommentRegDate DATETIME DEFAULT CURRENT_TIMESTAMP,        # 댓글 등록 시간
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (PostID) REFERENCES Post(PostID)
);

CREATE TABLE League(
    LeagueID VARCHAR(30) PRIMARY KEY,        		# 고유키
    GameID VARCHAR(20) NOT NULL,            		# 경기 종목명
    GameDay DATE NOT NULL,                   		# 경기 날짜
    Location VARCHAR(100),                   		# 경기 장소
    ClubID VARCHAR(20),                      		# 홈팀
    OppClubID VARCHAR(20),                  	    # 원정팀
    GF INT DEFAULT 0,                        		# 득점
    GA INT DEFAULT 0,                        		# 실점
    Points INT DEFAULT 0,                    		# 승점
    Result INT DEFAULT 0,                    		# 경기 결과
    FOREIGN KEY (ClubID) REFERENCES Club(ClubID)
);