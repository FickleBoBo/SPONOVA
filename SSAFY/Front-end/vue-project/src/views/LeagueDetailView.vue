<template>
    <div>
        <table class="league-view-rank">
            <tr>
                <th>Rank</th>
                <th>Club</th>
                <th>Points</th>
            </tr>
            <tr class="rank-individual" v-for="(ranking, index) in data.rankings" :key="ranking.clubID">
                <td v-if="index >= 3">{{ ranking.ranking }}</td>
                <td v-else-if="ranking.ranking==1">
                    <i class="fa-solid fa-medal fa-lg" style="color: #FFD700;"></i>
                </td>
                <td v-else-if="ranking.ranking==2">
                    <i class="fa-solid fa-medal fa-lg" style="color: #C0C0C0;"></i>
                </td>
                <td v-else-if="ranking.ranking==3">
                    <i class="fa-solid fa-medal fa-lg" style="color: #CD7F32;"></i>
                </td>
                <td>{{ ranking.clubID }}</td>
                <td>{{ ranking.totalPoints }}</td>
            </tr>
        </table>
    </div>
</template>

<script setup>
import dayjs from "dayjs"
import { useLeagueStore } from '@/stores/league';
const { data, getLeagueDetailsByGameID } = useLeagueStore();

const showToday = dayjs().format('YYYY-MM-DD')
function selectGameID(gameID) {
getLeagueDetailsByGameID(gameID);
}
</script>

<style scoped>
/* 순서는 위에서부터 차례대로 */

/* 페이지 전체 */
.league-view{
height: auto;
min-height: 100%;
/* display: flex;
flex-direction: column;
align-items: center; */
}

/* LEAGUE RANKINGS, TODAY'S MATCHES */
h1{
margin-top: 2em;
font-size: xx-large;
font-family: "LA28 Display";
text-align: center;
}

/* 종목 선택 버튼 영역 */
.league-view-buttons{
font-family: "LA28 Text";
margin-left: auto;
display: flex;
flex-direction: row;
justify-content: space-evenly;
margin: 1em;
}
.league-view-buttons-individual{
transition: 0.3s ease;

}
.league-view-buttons-individual:hover{
transform: translateY(-10px);
}

/* 종목 선택 개별 버튼 */
button {
padding: 10px;
margin: 2em 1em;
background-color: rgb(0, 0, 0);
color: white;
border: none;
border-radius: 5%;
}

/* 리그 순위 테이블 전체 */
.league-view-rank{
width: 100%;
text-align: center;
background-color: black;
color: white;
}

/* 종목 미선택 시 */
.league-view-rank-unselected {
width: 100%;
margin-top: 3em;
margin-bottom: 2em;

overflow: visible; /* 내용이 넘칠 경우 숨김 */
white-space: nowrap; /* 텍스트를 한 줄에 표시 */
position: relative;

/* border: 1px solid gray; */
background-color: rgb(255, 255, 255);
color: rgb(0, 0, 0);
font-family: "LA28 Text";

text-align: center;
justify-items: center;
align-content: center;
}

/* 종목 미선택시 나타나는 문구 */
.league-view-rank-unselected p {
position: absolute; /* 절대적 위치 지정으로 애니메이션 적용 */
left: 100%;
right: 100%;
/* width: 100%; */
width: auto;
height: 100%;
margin: 0;

font-size: larger;
line-height: 3em; /* 세로 중앙 정렬을 위해 높이 맞춤 */
animation: marquee 15s linear infinite; /* 애니메이션 추가 */
}

/* 애니메이션 효과 */
@keyframes marquee {
from { left: 0%; } /* 시작 위치 */
to { left: 90%; } /* 끝 위치, 텍스트 전체가 화면 왼쪽 끝을 지나도록 설정할 수도 있음 */
}

table{
font-family: "LA28 Text";
width: 100%;
/* border-top: 1px solid white; */
border-collapse: collapse;
}
th, td{
/* border-bottom: 1px solid white; */
padding: 0.5em;
}

th{
font-size: large;
font-family: "LA28 Text";
padding-top: 0.5em;
padding-bottom: 0.5em;
}

/* MW 추가 - 리그 테이블 열 별로 너비 고정 */
.league-view-rank th:nth-child(1),
.league-view-rank td:nth-child(3) {
    width: 20%;
}

.league-view-rank th:nth-child(2) {
    width: 60%;
}

/* 리그 순위 각 행 */
.rank-individual{
margin: 0 auto;
text-align: center;
align-items: center;
padding: 0.5em;
/* border: 1px solid white; */
}
.rank-individual:hover{
background-color: white;
color: black;
}


/* 오늘의 경기 영역 */
.today-match{
/* margin-top: 1em; */
margin-bottom: 2em;
}
/* 오늘의 날짜 */
.today-match-day{
text-align: center;

font-family: "LA28 Display";
font-weight: 500;
font-size: large;
}
/* 오늘의 경기 개별 박스 */
.match-individual{
border: 3px solid black;
padding: 1em;
margin: 0.5em;

text-align: center;
align-items: center;

font-weight: 700;

transition: font-size 0.3s ease; /* 호버링 시 스르르ㅡㄱ */
}
.game-location{
font-size: small;
font-style: oblique;
margin-left: 1em;
}
/* 호버링 */
.match-individual:hover{
background-color: black;
color: aliceblue;
/* transform: scale(1.1); */

font-weight: 700;
font-size: 120%;

}

/* 스폰서 영역 */
.league-view-sponsers{
display: flex;
flex-direction: column;
align-items: center; /**얘가 가운데 정렬 */
background-color: rgb(0, 0, 0);
margin-top: 5em;
padding: 2em 1em;
width: 100%;

/* margin-bottom: 1px; */
}
/* OUR PARTNERS */
.sponser-title{
color: white;
font-family: "LA28 Display";
font-size: xx-large;
width: 100%;
margin-bottom: 2em;
text-align: center; /** 제목 중앙 정렬 */

}
/* 개별 로고 */
.sponser-logo-section {
display: flex;
flex-direction: row;
justify-content: center;
flex-wrap: wrap;
align-items: center;
gap: 1em;
width: 100%;
}
.sponser-logo-section img {
height: 5em; /* 이미지 높이를 컨테이너 높이에 맞춤 */
/* height: auto; */
margin: 0.5em;
}
</style>
