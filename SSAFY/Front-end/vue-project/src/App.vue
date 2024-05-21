<template>
    <div class="top-container">
        <!-- 네비게이션 바 고정 영역 -->
        <header>
            <nav>
                <RouterLink class="nav-tap" :to="{name: 'home'}">HOME</RouterLink>
                <!-- <RouterLink class="nav-tap" :to="{name: 'intro'}">INTRO</RouterLink> -->
                <div class="game-container">
                    <RouterLink class="nav-tap" :to="{name: 'gameList'}">GAME</RouterLink>
                    <div class="game-detail">
                        <div v-for="item in gameStore.gameInfo" :key="item.id">
                            <RouterLink :to="{name: 'gameDetail', params: { id: item.id} }">{{ item.koName }}</RouterLink>
                        </div>
                    </div>
                </div>
                <RouterLink class="nav-tap" :to="{name: 'community'}">COMMUNITY</RouterLink>
                <RouterLink class="nav-tap" :to="{name: 'club'}">CLUB</RouterLink>
                <RouterLink class="nav-tap" :to="{name: 'league'}">LEAGUE</RouterLink>
        
        
                <!-- 네비게이션 바 동적 영역 -->
                <div class="loginArea">
                    <!-- 로그인 안했으면 "로그인" / "회원가입" -->
                    <!-- 로그인 했으면 "로그아웃" / "닉네임"-->
                    <RouterLink class="login-margin" v-if="!userStore.loginStatus" :to="{name: 'login'}">Login  |</RouterLink>
                    <RouterLink v-if="!userStore.loginStatus" :to="{name: 'signup'}">Sign up</RouterLink> 
                    <RouterLink class="login-margin" v-if="userStore.loginStatus" :to="{name: 'home'}">{{ userStore.loginInfo.userNickname }}  |</RouterLink>
                    <RouterLink v-if="userStore.loginStatus" :to="{name: 'logout'}">Logout </RouterLink>
                </div>
            </nav>
        </header>
        <div class="nav-bottom"></div> <!--nav바와 다른 컴포넌트가 겹치는 것을 방지하기 위해 만든 영역, 해당 영역에 padding이나 margin 값을 일관적으로 적용-->
        <RouterView />
    
        <!-- footer 영역 -->
        <footer>
            <div class="footer-logo">
                <!-- 웹사이드 로고로 대체 -->
                <img src="../public/morumoru1.png">
            </div>
            <div class="footer-info">
                <div>오시는 길: 서울 강남구 테헤란로 212</div>
                <div>문의 contact us: SSAFY@gmail.com</div>
                <div>&copy; 2024. All Rights Reserved</div>
            </div>
        </footer>
    </div>
</template>


<script setup>

// router 기능 사용
import { RouterLink, RouterView } from 'vue-router'

// pinia 불러오기
import { useGameStore } from '@/stores/game'
const gameStore = useGameStore()

import { useUserStore } from '@/stores/user'
const userStore = useUserStore()

</script>

<style scoped>
/*  footer를 페이지 길이 상관없이 최하단 고정 template에는 직접 적용안됨 -> div 태그 생성 */
.top-container {
    display: flex;
    flex-direction: column;
    justify-content: space-between; /* 위쪽 내용과 하단 푸터 사이의 공간을 균등하게 배분 */
    min-height: 100vh; /* 뷰포트의 전체 높이 */
}

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
    top: 0;
    left: 0;
    right: 0;

    background-color: #010101;
    /* font-weight: 600; */
    
    z-index: 1000;
    padding: 10px 0;
    margin-bottom: 1em;
}
.nav-bottom{
    padding-top: 3em;
}

.nav-tap {
    color: white;
    margin: auto 1rem;
    text-decoration: none;
}

.loginArea {
    font-size: x-small;
}
/* RouterLink컴포넌트가 내부적으로 <a> 태그로 렌더링, 이미 text-deco가 설정되어 있어서 직접 적용해야 함 */
.loginArea a {
    color: white;
    text-decoration: none;
}
/* login 과 signup 사이 간격 */
.login-margin{
    margin-right: 0.5em;
}

.router-link-active { /* 현재 위치 알림 */
    font-size: 700;
    color: rgb(167, 215, 255);
}

.game-container {
    position: relative;
    display: inline-block;
}

.game-detail { /* game의 하위 탭 */
    display: none; /* 존재하지 않는 것처럼 안보임 */
    position: absolute;
    left: 0;
    top:100%; /**nav 바 바로 밑에 나오게 */

    background-color: #4d4d4d;
    min-width: 100px; 
    font-size: small;

    z-index: 1;

    
}

.game-detail a{
    margin: 1em auto;
    color: white;
    text-decoration: none;
    display: block;
}

.game-container:hover .game-detail {
    display: block; /* 블록 레벨 요소로 만든다 */
}


/* footer 디자인 */
footer {
    display: flex;
    position: relative;
    width: 100%;
    background-color: black;
    color: gray;
}

/* footer 로고를 감싼 태그의 크기를 지정(이미지는 이것만으로 크기 조절이 안됐음) */
.footer-logo {
    width: 200px;
    height: 100px;
    margin: 1em;
}

/* footer 로고의 크기를 부모 태그에 맞춤 */
.footer-logo img {
    width: 100%;
    height: 100%;
    background-color: white;  /* 크기 표시용 */
}

/* footer에 들어갈 웹사이트 관련 정보 스타일 */
.footer-info {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    margin: 1em;
    background-color: yellow;  /* 크기 표시용 */
}

</style>
