<template>
    <div class="top-container">
        <!-- 네비게이션 바 고정 영역 -->
        <header>
            <!-- <div class="nav-logo">
                <img src="./assets/logo3.png">
            </div> -->
            <nav>
                <!-- HOME 탭 -->
                <RouterLink class="nav-tap" :to="{name: 'home'}">HOME</RouterLink>

                <!-- INTRO 탭 -->
                <!-- <RouterLink class="nav-tap" :to="{name: 'intro'}">INTRO</RouterLink> -->

                <!-- GAME 탭 -->
                <div class="game-container">
                    <RouterLink class="nav-tap" :to="{name: 'gameList'}">GAME</RouterLink>
                    <div class="game-item">
                        <div v-for="item in gameStore.gameInfo" :key="item.id">
                            <RouterLink :to="{name: 'gameDetail', params: { id: item.id} }">{{ item.enName }}</RouterLink>
                        </div>
                    </div>
                </div>

                <!-- COMMUNITY 탭 -->
                <RouterLink class="nav-tap" :to="{name: 'community'}">COMMUNITY</RouterLink>

                <!-- CLUB 탭 -->
                <RouterLink class="nav-tap" :to="{name: 'club'}">CLUB</RouterLink>

                <!-- LEAGUE 탭 -->
                <!-- <RouterLink class="nav-tap" :to="{name: 'league'}">LEAGUE</RouterLink> -->
                <div class="league-container">
                    <RouterLink class="nav-tap" :to="{name: 'league'}">LEAGUE</RouterLink>
                    <div class="league-item">
                        <div v-for="item in gameStore.gameInfo" :key="item.id">
                            <RouterLink :to="{name: 'leagueDetail' , params: { id: item.id} }" @click.native="leagueStore.getLeagueDetailsByGameID(item.koName)">{{ item.enName }}</RouterLink>
                        </div>
                    </div>
                </div>

                <!-- 네비게이션 바 동적 영역 -->
                <div class="login-area">
                    <!-- 로그인 안했으면 "로그인" / "회원가입" -->
                    <!-- 로그인 했으면 "로그아웃" / "닉네임"-->
                    <RouterLink v-if="!userStore.loginStatus" :to="{name: 'login'}">Login</RouterLink>
                    <span v-if="!userStore.loginStatus">|</span>
                    <RouterLink v-if="!userStore.loginStatus" :to="{name: 'signup'}">Sign up</RouterLink>
                    <RouterLink v-if="userStore.loginStatus" :to="{name: 'home'}">{{ userStore.loginInfo.userNickname }}</RouterLink>
                    <span v-if="userStore.loginStatus">|</span>
                    <RouterLink v-if="userStore.loginStatus" :to="{name: 'logout'}">Logout </RouterLink>
                </div>
            </nav>
        </header>

        <!-- MW가 주석으로 바꿈 -->
        <!-- <div class="nav-bottom"></div> nav바와 다른 컴포넌트가 겹치는 것을 방지하기 위해 만든 영역, 해당 영역에 padding이나 margin 값을 일관적으로 적용 -->
        
        <RouterView />
    
        <!-- footer 영역 -->
        <footer>
            <div class="footer-minus-copy">
                <div class="footer-logo">
                    <!-- 웹사이드 로고로 대체 -->
                    <img src="./assets/logo3.png">
                </div>
                <div class="footer-info">
                    <div class="footer-info-1">
                        <div class="footer-info-title">오시는 길</div>
                        <div class="footer-info-disc">서울 강남구 테헤란로 212</div>
                    </div>
                    <div class="footer-info-2">
                        <div class="footer-info-title">문의 contact us</div>
                        <div class="footer-info-disc"> 이메일 문의: ssafy@ssafy.com</div>
                        <div class="footer-info-disc"> 대표전화: 02-3429-5100</div>
                        <div class="footer-info-disc"> Tel. 010-8422-8393</div>
                        <div class="footer-info-disc"> Tel. 010-4471-6266</div>
                    </div>
                </div>
            </div>
            <div class="footer-info-copy">&copy; 2024. PJT-J All Rights Reserved</div>
        </footer>
    </div>
</template>



<script setup>
import { RouterLink, RouterView } from 'vue-router'

import { useUserStore } from '@/stores/user'
const userStore = useUserStore()

import { useGameStore } from '@/stores/game'
const gameStore = useGameStore()

import { useLeagueStore } from '@/stores/league'
const leagueStore = useLeagueStore()

</script>



<style scoped>
/*  footer를 페이지 길이 상관없이 최하단 고정 template에는 직접 적용안됨 -> div 태그 생성 */
.top-container {
    display: flex;
    flex-direction: column;
    justify-content: space-between; /* 위쪽 내용과 하단 푸터 사이의 공간을 균등하게 배분 */
    min-height: 100vh; /* 뷰포트의 전체 높이 */
}

/* MW가 추가 */
header {
    margin-bottom: 0em;  /* 컨텐츠들이랑 붙는거 방지 */
    display: flex;
    flex-direction: row;
}

/* .nav-logo img{
    display: flex;
    align-items: center;
    margin-left: 1em;
    position: relative;
    z-index: 2000;
    width: 4em;
    height: auto;
} */

nav {
    /* position: relative; */
    font-family: 'LA28 Text', sans-serif;
    font-size: large;
    display: flex;
    justify-content: right;
    align-items: center;

    position: fixed; /**fixed로 하면 여백 없음 */
    width: 100%;
    height: 3em;
    padding-right: 1em;  /* MW가 추가 */
    /* top: 0; */  /* MW가 주석으로 바꿈 */
    /* left: 0; */  /* MW가 주석으로 바꿈 */
    /* right: 0; */  /* MW가 주석으로 바꿈 */

    background-color: #010101;
    /* font-weight: 600; */
    
    z-index: 1000;
    /* padding: 10px 0; */  /* MW가 주석으로 바꿈 */
    /* margin-bottom: 1em; */  /* MW가 주석으로 바꿈 */
}

  /* MW가 주석으로 바꿈 */
/* .nav-bottom{
    padding-top: 3em;
} */

.nav-tap {
    color: white;
    /* margin: auto 1rem; */  /* MW가 주석으로 바꿈 */
    display: flex;  /* MW가 추가 */
    align-items: center;  /* MW가 추가 */
    height: 3em;
    padding-left: 2em;  /* MW가 추가 */
    padding-right: 2em;  /* MW가 추가 */
    text-decoration: none;
}

.game-container {
    position: relative;
    /* display: inline-block; */
    display: flex;
    flex-direction: column;
    text-align: center;
}

.league-container {
    position: relative;
    /* display: inline-block; */
    display: flex;
    flex-direction: column;
    text-align: center;
}

.game-item { /* game의 하위 탭 */
    display: none; /* 존재하지 않는 것처럼 안보임 */
    position: absolute;
    /* left: 0;  /* MW가 주석으로 바꿈 */
    top:100%;  /* MW가 주석으로 바꿈 */

    background-color: #4d4d4d;
    /* min-width: 100px; */  /* MW가 주석으로 바꿈 */
    font-size: small;

    /* z-index: 1; */  /* MW가 주석으로 바꿈 */
}

.league-item { /* game의 하위 탭 */
    display: none; /* 존재하지 않는 것처럼 안보임 */
    position: absolute;
    /* left: 0;  /* MW가 주석으로 바꿈 */
    top:100%;  /* MW가 주석으로 바꿈 */

    background-color: #4d4d4d;
    /* min-width: 100px; */  /* MW가 주석으로 바꿈 */
    font-size: small;

    /* z-index: 1; */  /* MW가 주석으로 바꿈 */
}

.game-item a {
    /* margin: 1em auto;  /* MW가 주석으로 바꿈 */
    padding-top: 1.5em;
    padding-bottom: 1.5em;
    padding-left: 2em;
    padding-right: 2em;
    color: white;
    text-decoration: none;
    display: block;
}

.league-item a {
    /* margin: 1em auto;  /* MW가 주석으로 바꿈 */
    padding-top: 1.5em;
    padding-bottom: 1.5em;
    padding-left: 2em;
    padding-right: 2em;
    color: white;
    text-decoration: none;
    display: block;
}

.game-container:hover .game-item {
    display: block; /* 블록 레벨 요소로 만든다 */
}

.league-container:hover .league-item{
    display: block; /* 블록 레벨 요소로 만든다 */
}

/* game 탭의 하위 탭에 대한 호버링 적용 */
.game-item a:hover {
    background-color: #2e2e2e;
}

.league-item a:hover {
    background-color: #2e2e2e;
}


.router-link-active { /* 현재 위치 알림 */
    /* font-size: 700; */  /* MW가 주석으로 바꿈 */
    color: rgb(167, 215, 255);

    /* 선택한 네비게이션 꾸미기 옵션들 */
    font-weight: bold;  /* 굵은 글씨로 바꿔주기 */
     background-color: #333;   /* 배경 색상 추가 */
}



.login-area {
    font-size: x-small;
    margin-left: 1em;
}

/* RouterLink컴포넌트가 내부적으로 <a> 태그로 렌더링, 이미 text-deco가 설정되어 있어서 직접 적용해야 함 */
.login-area a {
    margin-left: 1em;
    margin-right: 1em;
    background-color: black;
    color: white;
    text-decoration: none;
}

.login-area span {
    color: white;
    margin: 1em;
}

/* MW가 주석으로 바꿈 */
/* login 과 signup 사이 간격 */
/* .login-margin{
    margin-right: 0.5em;
} */



/* footer 디자인 */
footer {
    display: flex;
    flex-direction: column;
    align-items: center;
    position: relative;
    width: 100%;
    /* margin-top: 3em; */
    background-color: black;
    color: gray;
    padding-bottom: 0.5em;
}
.footer-minus-copy{
    /* background-color: aqua; */
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    padding: 1em;
}

/* footer 로고를 감싼 태그의 크기를 지정(이미지는 이것만으로 크기 조절이 안됐음) */
.footer-logo {
    padding: 2em 1em;
    width: 30em;
    height: auto;
    /* margin: 1em; */
}

/* footer 로고의 크기를 부모 태그에 맞춤 */
.footer-logo img {
    width: 100%;
    height: 100%;
    background-color: none;  /* 크기 표시용 */
}

/* footer에 들어갈 웹사이트 관련 정보 스타일 */
.footer-info {/* 
    margin: 1em;*/
    margin-top: 2em;
    background-color: none; 

    display: flex;
    flex-direction: row;
    width: 100%;
    justify-content: space-evenly; /* 균등 분포 */
}
.footer-info-title{
    font-size: medium;
    margin-bottom: 0.5em;
}
.footer-info-disc{
    font-size: small;
}

.footer-info-copy{
    width: 100%;
    font-size: small;
    /* margin-top: 1em; */
    text-align: center;
}
/* 
.footer-info > * {
    margin: 1em;
    background-color: blue;  /* 크기 표시용 
} */

</style>
