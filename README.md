# SPONOVA(스포노바)

### 서비스 소개

> Sports와 Innovation의 합성어로, 스포츠의 새로운 지평을 열고자 하는 스포츠 네트워크입니다. 뉴스포츠 종목들을 소개하고, 클럽 커뮤니티와 리그 시스템을 통해 기존의 스포츠 팬들과 새로운 스포츠에 관심 있는 이들 모두에게 독특하고 즐거운 경험을 제공합니다. 전통적인 스포츠 경계를 넘어서 새로운 형태의 스포츠인 뉴스포츠를 통해 세대를 아우르는 건강하고 활동적인 커뮤니티를 만들어가는 것을 목표로 합니다.

<br>

## 개발 환경

#### 프레임워크

<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=Vue.js&logoColor=white">

#### 데이터베이스

<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">

#### API

<img src="https://img.shields.io/badge/YouTube-FF0000?style=for-the-badge&logo=YouTube&logoColor=white">
<img src="https://img.shields.io/badge/KakaoMap-FFCD00?style=for-the-badge&logo=Kakao&logoColor=white">

#### 협업

<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=Github&logoColor=white">
<img src="https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=Figma&logoColor=white">
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">
<img src="https://img.shields.io/badge/Mattermost-0058CC?style=for-the-badge&logo=Mattermost&logoColor=white">

<!--
  <img src="https://img.shields.io/badge/API-Kakao_Map-red?style=flat">
  <img src="https://img.shields.io/badge/API-YouTube-FF0000?style=flat">
  <img src="https://img.shields.io/badge/Library-vue_Bootstrap-563D7C?style=flat&logo=bootstrap&logoColor=white">
  <img src="https://img.shields.io/badge/Language-Java-007396?style=flat&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Language-JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=white">
  <img src="https://img.shields.io/badge/Database-MySql-F80000?style=flat&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/Framework-Vue-D22128?style=flat&logo=vue.js&logoColor=white">
  <img src="https://img.shields.io/badge/Framework-Spring Boot-6DB33F?style=flat&logo=spring&logoColor=white"> -->

<br>

## 팀원소개

<table>
  <tbody>
    <tr>
      <td align="center"><a href="https://github.com/ghlim00"><img src="https://avatars.githubusercontent.com/u/156143969?v=4" width="100px;" alt=""/><br /><b>임가현</b></a><br /></td>
      <td align="center"><a href="https://github.com/FickleBoBo"><img src="https://avatars.githubusercontent.com/u/95597182?v=4" width="100px;" alt=""/><br /><b>육민우</b></a><br /></td>
    </tr>
  </tbody>
</table>

<br>

## ERD

![다이어그램](./specification/assets/erd.jpg)

## 주요기능

- 회원관리

  - 회원 가입

    - 아이디, 비밀번호, 이름, 닉네임, 주민등록번호, 전화번호 입력
    - 아이디, 닉네임, 전화번호 입력 시 중복 여부 확인
    - 가입 완료 시 로그인 페이지로 이동

  - 로그인

    - 아이디, 비밀번호 입력
    - 로그인 완료 시 로그인 성공 모달 출력

  - 로그아웃
    - 로그아웃 시 메인 페이지로 이동

- 게임 소개 페이지

  - 뉴스포츠 소개 및 개별 종목 소개 카드
    - 카드 내 버튼을 통한 상세 설명 페이지 바로가기 기능
  - 종목 상세 페이지
    - 상세 설명과 경기 영상 바로가기

- 게시판 서비스

  - 게시글

    - 게시글 목록(제목, 작성자, 작성일, 조회수, 댓글 수)를 페이지네이션을 이용하여 출력
    - 게시글 조회
      - 누구나 게시글 조회 가능(비회원 포함)
    - 게시글 작성
      - 로그인 한 사람만 글 작성 가능
    - 게시글 삭제
      - 해당 게시글 작성자만 삭제 가능
    - 게시글 수정
      - 해당 게시글 작성자만 글 수정 가능(제목, 내용)

  - 댓글

    - 로그인 한 사람만 댓글 작성 가능
    - 댓글 삭제는 댓글 작성자만 가능

  - 검색

    - 제목(일부 키워드 포함) 검색 기능

  - 정렬
    - 작성일
      - 최신순, 오래된 순으로 게시글 정렬 가능
    - 조회수
      - 조회수가 높은 순 또는 낮은 순으로 게시글 정렬 가능

- 클럽 관리

  - 카드 형식으로 모든 클럽 조회 가능
  - 카드 내 버튼 클릭 시 클럽 소개 모달 출력
  - 검색을 통한 종목별 클럽 조회 가능

- 리그 관리

  - 리그 순위 조회

    - 종목별 리그 순위 조회 기능
      - 순위, 클럽명, 승점 출력
      - 1/2/3위는 메달 뱃지 부여

  - 오늘의 경기
    - 대결 클럽과 장소를 출력
      - 장소 클릭 시 지도 모달을 통한 경기 장소 확인 기능
