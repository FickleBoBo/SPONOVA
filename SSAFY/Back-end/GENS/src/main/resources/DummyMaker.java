import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DummyMaker {

    static int createPostNum = 1000;
    static int createCommentNum = 3000;

    public static void main(String[] args) {

        // 유저 수 : 31
        List<User> userList = new ArrayList<>();
        userList.add(new User("admin", "admin", "admin", "000000-0", "000-0000-0000", "관리자 계정"));
        userList.add(new User("test", "test", "테스트계정", "123456-7", "010-1234-5678", "테스트 계정"));
        userList.add(new User("j990809@naver.com", "dlwodud1!", "이재영", "990809-1", "010-3355-3519", "zl존재영S2"));
        userList.add(new User("bae990429@naver.com", "bae1234!", "배성진", "990429-1", "010-2885-0849", "느려터진거북이"));
        userList.add(new User("yngbao97@naver.com", "dkssud12!", "육예진", "970418-2", "010-4620-6748", "소문난육공주"));
        userList.add(new User("p1ayer.one.potter@gmail.com", "itzy", "임가현", "000202-4", "010-8422-8393", "레디플레이어원"));
        userList.add(new User("qwera1997@naver.com", "yukganzi1997@", "육민우", "970704-1", "010-4471-6266", "육땃쥐"));
        userList.add(new User("niggaud@naver.com", "asdfghjkl98!", "김재현", "980714-1", "010-9484-8129", "럭포터 원챔"));
        userList.add(new User("haneul01@naver.com", "hanblue001", "신승호", "630512-1", "010-5121-0021", "AzureSky"));
        userList.add(new User("minsu02@naver.com", "msbear002", "김현재", "840307-1", "010-3071-0345", "BearPaw"));
        userList.add(new User("soojin03@naver.com", "sjstar003", "김기창", "761021-1", "010-2103-0721", "TwinkleSta"));
        userList.add(new User("hyeok04@naver.com", "hyfire004", "임세하", "710405-1", "010-5401-0432", "Fireblade"));
        userList.add(new User("haein05@naver.com", "haeocean005", "송창용", "890720-1", "010-2072-0523", "OceanView"));
        userList.add(new User("eunji06@naver.com", "eunmoon006", "한도형", "910510-1", "010-0510-0661", "쿠키아빠"));
        userList.add(new User("junwoo07@naver.com", "jwcloud007", "문선정", "960814-1", "010-1408-0772", "레몬셔벗블렌디드"));
        userList.add(new User("yeonwoo08@naver.com", "ywplanet008", "서희", "990201-1", "010-2001-0883", "서희장군"));
        userList.add(new User("yujin09@naver.com", "yjrocket009", "권용수", "940620-1", "010-0620-0994", "커피내기"));
        userList.add(new User("soyeon10@naver.com", "sywind010", "박건택", "950328-1", "010-0328-1005", "WindSwept"));
        userList.add(new User("hyunwoo11@naver.com", "hwstorm011", "박희연", "980913-1", "010-0913-1116", "StormRider"));
        userList.add(new User("minji12@naver.com", "mjapple012", "민예림", "970207-1", "010-0207-1227", "AppleCrisp"));
        userList.add(new User("daehyun13@naver.com", "dhgreen013", "홍주형", "950709-1", "010-0709-1338", "서울7반차은우"));
        userList.add(new User("jihoon14@naver.com", "jhaura014", "한진형", "940512-1", "010-0512-1449", "바나프레소"));
        userList.add(new User("haneul15@naver.com", "hnspace015", "오지혜", "960325-1", "010-0325-1550", "SpaceNomad"));
        userList.add(new User("seojun16@naver.com", "sjwave016", "손영준", "970415-1", "010-0415-1661", "댄싱머신한도형"));
        userList.add(new User("yeseo17@naver.com", "ysfantasy017", "유서현", "991003-1", "010-1003-1772", "atlantis"));
        userList.add(new User("hyebin18@naver.com", "hbwind018", "황민욱", "950622-1", "010-0622-1883", "쿠키런"));
        userList.add(new User("jiwoo19@naver.com", "jwdream019", "표다영", "970818-1", "010-0818-1994", "싸피11기"));
        userList.add(new User("eunwoo20@naver.com", "ewstar020", "이현우", "980319-1", "010-0319-2005", "sunglass"));
        userList.add(new User("suji03@naver.com", "starshine103", "최장우", "761021-1", "010-1003-0103", "StarShine"));
        userList.add(new User("taehun04@naver.com", "firewalk104", "김주형", "710405-1", "010-1004-0104", "FireWalker"));
        userList.add(new User("joowon07@naver.com", "cloudsurf107", "김윤홍", "960814-1", "010-1007-0107", "김윤홍"));

        // 포스트 더미 데이터 수 : 26
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("티볼 경험 나눔", "처음으로 티볼을 해봤는데 정말 재미있네요! 같이 할 사람들을 찾습니다."));
        postList.add(new Post("인디아카 기본 규칙", "인디아카의 기본적인 규칙과 게임 방법을 공유합니다."));
        postList.add(new Post("스태킹 초보자 가이드", "스태킹을 시작하는 초보자를 위한 기본 가이드입니다."));
        postList.add(new Post("플로어볼 입문", "플로어볼을 시작하고 싶은데 어떻게 해야 할지 모르겠다면 이 글을 참고하세요."));
        postList.add(new Post("츄크볼 게임 후기", "츄크볼 게임을 해보고 느낀 점을 공유합니다. 역동적이고 흥미로운 게임이에요."));
        postList.add(new Post("빅발리볼 후기", "빅발리볼을 처음 해봤는데, 팀 스포츠의 매력이 넘칩니다!"));
        postList.add(new Post("인디아카 게임 후기", "인디아카 게임을 처음 해봤습니다. 신선하고 재미있어요!"));
        postList.add(new Post("스태킹 대회 준비", "스포츠스태킹 대회를 준비하면서 배운 점들을 공유합니다."));
        postList.add(new Post("플로어볼 팀 모집", "서울에서 활동할 플로어볼 팀원을 찾습니다. 함께 운동해요!"));
        postList.add(new Post("빅발리볼 기술 팁", "서브와 스매시를 향상시킬 수 있는 빅발리볼 팁을 공유합니다."));
        postList.add(new Post("츄크볼 대회 소식", "다가오는 츄크볼 대회 소식과 참가 방법을 알려드립니다."));
        postList.add(new Post("티볼 클럽 모집", "서울 마포구에서 활동할 티볼 동아리원을 모집합니다. 초보자도 환영!"));
        postList.add(new Post("플로어볼 경기 후기", "플로어볼 경기에 참가했던 소감과 후기를 나눕니다."));
        postList.add(new Post("인디아카 동호회 소개", "저희 인디아카 동호회에 대해 소개하고 싶어요. 많은 관심 부탁드립니다."));
        postList.add(new Post("스태킹 기술과 노하우", "스포츠스태킹을 더 빠르게 할 수 있는 기술을 소개합니다."));
        postList.add(new Post("플로어볼 장비 추천", "플로어볼을 시작할 때 필요한 장비와 추천 제품을 알려드립니다."));
        postList.add(new Post("츄크볼 기술 소개", "츄크볼에서 유용한 기술과 전략을 소개합니다."));
        postList.add(new Post("빅발리볼 대회 정보 공유", "다가오는 주말에 서울에서 열리는 빅발리볼 대회 정보입니다."));
        postList.add(new Post("티볼 게임 규칙 설명", "티볼 게임의 기본 규칙과 재미있는 플레이 방법을 공유합니다."));
        postList.add(new Post("츄크볼 게임 규칙 소개", "츄크볼 게임을 시작하기 전 알아야 할 기본 규칙을 설명합니다."));
        postList.add(new Post("빅발리볼 경기장 추천", "서울에서 빅발리볼을 즐길 수 있는 최고의 경기장을 추천합니다."));
        postList.add(new Post("티볼 게임 후기 및 팁", "티볼 게임을 하며 얻은 재미있는 경험과 유용한 팁을 공유합니다."));
        postList.add(new Post("스포츠스태킹 동아리 모집", "스포츠스태킹에 관심 있는 분들을 위한 동아리를 모집합니다."));
        postList.add(new Post("서울 티볼 동아리 모집", "서울 지역에서 활동 중인 티볼 동아리원을 모집합니다."));
        postList.add(new Post("인디아카 대회 초대", "오는 주말에 열리는 인디아카 대회에 여러분을 초대합니다."));
        postList.add(new Post("빅발리볼 초보자 모집", "빅발리볼을 시작하는 초보자를 위한 모임을 구성합니다."));

        // 댓글 더미 데이터 수 : 10
        List<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment("잘보고 갑니다!!"));
        commentList.add(new Comment("친구해요~~"));
        commentList.add(new Comment("정말 멋있네요^^"));
        commentList.add(new Comment("캬"));
        commentList.add(new Comment("오늘도 행복하세요"));
        commentList.add(new Comment("좋은 아침~"));
        commentList.add(new Comment("크으"));
        commentList.add(new Comment("안녕하세요"));
        commentList.add(new Comment("반갑습니다"));
        commentList.add(new Comment("오늘도 파이팅~!"));

        // 게시판에 더미 데이터 2000개 삽입 예정
        List<NewPost> newPostList = new ArrayList<>();
        for(int i=0 ; i<createPostNum ; i++){
            // 유저 인덱스 랜덤값
            int a1 = 0;
            int b1 = userList.size();
            int randomNumber1 = ThreadLocalRandom.current().nextInt(a1, b1);

            // 포스트 인덱스 랜덤값
            int a2 = 0;
            int b2 = postList.size();
            int randomNumber2 = ThreadLocalRandom.current().nextInt(a2, b2);

            // 작성일 랜덤값 생성
            long startSeconds = ZonedDateTime.parse("20240101T00:00:00", DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ss").withZone(ZoneOffset.UTC)).toEpochSecond();
            long endSeconds = ZonedDateTime.parse("20240523T23:59:59", DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ss").withZone(ZoneOffset.UTC)).toEpochSecond();
            long randomSeconds = ThreadLocalRandom.current().nextLong(startSeconds, endSeconds + 1);
            ZonedDateTime randomDateTime = Instant.ofEpochSecond(randomSeconds).atZone(ZoneOffset.UTC);

            // 작성일 포맷팅
            String formattedDateTime = DateTimeFormatter.ofPattern("yyyyMMddHH:mm:ss").format(randomDateTime);

            int a3 = 0;
            int b3 = 101;
            int randomNumber3 = ThreadLocalRandom.current().nextInt(a3, b3);

            String postTitle = postList.get(randomNumber2).postTitle;
            String userID = userList.get(randomNumber1).userID;
            String userNickname= userList.get(randomNumber1).userNickname;
            String postContent = postList.get(randomNumber2).postContent;
            int postViewCnt = randomNumber3;
            String postRegDate = formattedDateTime.substring(0, 4) + "-" + formattedDateTime.substring(4, 6) + "-" + formattedDateTime.substring(6, 8) + " " + formattedDateTime.substring(8, 16);

            NewPost newPost = new NewPost(postTitle, userID, userNickname, postContent, postViewCnt , postRegDate);
            newPostList.add(newPost);
        }
        Collections.sort(newPostList, ((o1, o2) -> {
            return o1.postRegDate.compareTo(o2.postRegDate);
        }));



        List<NewComment> newCommentList = new ArrayList<>();
        for(int i=0 ; i<createCommentNum ; i++){
            // 유저 인덱스 랜덤값
            int a1 = 0;
            int b1 = userList.size();
            int randomNumber1 = ThreadLocalRandom.current().nextInt(a1, b1);

            int a2 = 1;
            int b2 = createPostNum + 1;
            int randomNumber2 = ThreadLocalRandom.current().nextInt(a2, b2);

            int a3 = 0;
            int b3 = commentList.size();
            int randomNumber3 = ThreadLocalRandom.current().nextInt(a3, b3);

            String userID = userList.get(randomNumber1).userID;
            String userNickname = userList.get(randomNumber1).userNickname;
            int postID = randomNumber2;
            String commentContent = commentList.get(randomNumber3).commentContent;
            newCommentList.add(new NewComment(userID, userNickname, postID, commentContent));
        }
        Collections.sort(newCommentList, ((o1, o2) -> {
            return o1.postID - o2.postID;
        }));

//        for(User user : userList){
//          System.out.println(user);
//        }
//
//        for(Post post : postList){
//          System.out.println(post);
//        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:/Users/mwzz6/Desktop/dummy_data/post.txt"))){
            for(NewPost newPost : newPostList){
                bw.write(newPost.toString());
            }
        } catch (IOException e){
            e.printStackTrace();
        }



        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:/Users/mwzz6/Desktop/dummy_data/comment.txt"))){
            for(NewComment newComment : newCommentList){
                bw.write(newComment.toString());
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("끝");
    }



    static class User {
        String userID;
        String userPW;
        String username;
        String userRRN;
        String userPhonenumber;
        String userNickname;

        public User(String userID, String userPW, String username, String userRRN, String userPhonenumber, String userNickname) {
            this.userID = userID;
            this.userPW = userPW;
            this.username = username;
            this.userRRN = userRRN;
            this.userPhonenumber = userPhonenumber;
            this.userNickname = userNickname;
        }
    }

    static class Post {
        String postTitle;
        String postContent;

        public Post(String postTitle, String postContent) {
            this.postTitle = postTitle;
            this.postContent = postContent;
        }
    }

    static class NewPost {
        String postTitle;
        String userID;
        String userNickname;
        String postContent;
        int postViewCnt;
        String postRegDate;

        @Override
        public String toString() {
            return "('" + postTitle + "', '" + userID + "', '" + userNickname + "', '" + postContent + "', " + postViewCnt + ", '" + postRegDate + "'),";
        }

        public NewPost(String postTitle, String userID, String userNickname, String postContent, int postViewCnt, String postRegDate) {
            this.postTitle = postTitle;
            this.userID = userID;
            this.userNickname = userNickname;
            this.postContent = postContent;
            this.postViewCnt = postViewCnt;
            this.postRegDate = postRegDate;
        }
    }

    static class Comment {
        String commentContent;

        public Comment(String commentContent) {
            this.commentContent = commentContent;
        }
    }

    static class NewComment {
        String userID;
        String userNickname;
        int postID;
        String commentContent;

        public NewComment(String userID, String userNickname, int postID, String commentContent) {
            this.userID = userID;
            this.userNickname = userNickname;
            this.postID = postID;
            this.commentContent = commentContent;
        }

        @Override
        public String toString() {
            return "('" + userID + "', '" + userNickname + "', " + postID + ", '" + commentContent + "'),";
        }
    }
}