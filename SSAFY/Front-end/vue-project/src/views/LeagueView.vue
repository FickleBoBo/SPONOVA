<!-- 지난 흔적.. <template>
  <div class="league-view">
    <h1>League Rankings</h1>
    <button @click="selectGameID('티볼')">티볼</button>
    <button @click="selectGameID('빅발리볼')">빅발리볼</button>
    <button @click="selectGameID('인디아카')">인디아카</button>
    <button @click="selectGameID('츄크볼')">츄크볼</button>
    <button @click="selectGameID('플로어볼')">플로어볼</button>
    <button @click="selectGameID('스포츠스태킹')">스포츠스태킹</button>

    <div v-if="leagueRankings.length > 0">
        <div v-for="ranking in leagueRankings" :key="ranking.clubID">
          {{ranking.ranking}}: {{ ranking.clubID }}: {{ ranking.totalPoints }} (승점)
        </div> 
    </div>
    <div v-else>
      종목을 선택해주세요. (사진?)
    </div>
  </div>


  <div class="today-match">
    <h1>Today's Matches</h1>
    <div>오늘의 날짜: {{ showToday }}</div>
    <div v-if="todaysGames.length > 0">
      <ul>
        <li v-for="game in todaysGames" :key="game.gameDay + game.ClubId" v-if="game.gameDay === showToday">
          {{ game.ClubId }} vs {{ game.OppClubId }} at {{ game.Location }}
        </li>
      </ul>
    </div>
    <div v-else>
      오늘 예정된 경기가 없습니다.
    </div>
  </div>
</template>



<script setup>
import { onMounted } from 'vue'
import { ref } from 'vue'
import { useLeagueStore } from '@/stores/league'
import dayjs from "dayjs"

const leagueStore = useLeagueStore()
// const leagueRankings = ref(leagueStore.leagueRankings)
const leagueRankings = ref([])
const todaysGames = ref([])

// 아래로 오늘의 날짜가 출력됨
const showToday = dayjs().format('YYYY-MM-DD')

// 종목 1개만 있을 때
// onMounted(() => {
//   leagueStore.getLeagueRankingByGameID('티볼') // '티볼' 게임 ID로 랭킹을 로드
// })
// onMounted(() => {
//   leagueStore.getLeagueRankingByGameID('빅발리볼') // '티볼' 게임 ID로 랭킹을 로드
// })
// function selectGameID(gameID) {
//   leagueStore.getLeagueRankingByGameID(gameID)
// }

// // 리그 랭킹만 띄울 때
// function filterTodaysGames(games){
//   // games가 정의되지 않은 경우
//   if (!games || !Array.isArray(games)) {
//     console.error("게임 정보가 없음.");
//     return [];
//   }
//   return games.filter(game => game.gameDay === showToday)
// }

// // 버튼 기능
// function selectGameID(gameID) {
//   leagueStore.getLeagueRankingByGameID(gameID).then(() => {
//     leagueRankings.value = leagueStore.leagueRankings
//     // 조건 처리
//     if (leagueStore.games) {
//       todaysGames.value = filterTodaysGames(leagueStore.games);
//     } else {
//       console.error("게임 데이터 없음");
//     }
//   }).catch(error => console.error("error message:", error));
// }  

// // Fetching rankings and today's games when a gameID is selected
// function selectGameID(gameID) {
//     leagueStore.getLeagueRankingByGameID(gameID).then(rankings => {
//         leagueRankings.value = rankings;
//         filterTodaysGames(gameID); // Filter today's games based on the selected gameID
//     }).catch(error => {
//         console.error("Error fetching rankings:", error);
//         leagueRankings.value = [];
//     });
// }

// // Filter today's games from the store, assuming store has a method to fetch games by date and gameID
// function filterTodaysGames(gameID) {
//     leagueStore.getTodaysGamesByGameID(showToday, gameID).then(games => {
//         todaysGames.value = games;
//     }).catch(error => {
//         console.error("Error fetching today's games:", error);
//         todaysGames.value = [];
//     });
// }
function selectGameID(gameID) {
  leagueStore.getLeagueRankingByGameID(gameID).then(() => {
    leagueRankings.value = leagueStore.leagueRankings.length ? leagueStore.leagueRankings : [];
    return leagueStore.getTodaysGamesByGameID(gameID);
  }).then(() => {
    todaysGames.value = leagueStore.todaysGames.length ? leagueStore.todaysGames : [];
  }).catch(error => {
    console.error("Error fetching data:", error);
    leagueRankings.value = [];
    todaysGames.value = [];
  });
}
</script>

<style scoped>
.league-view{
  /* position: relative; */
  margin-top: 2em;
}
h1{
    font-size: xx-large;
    font-family: "LA28 Display";
    text-align: center;
}
button {
  padding: 10px;
  margin: 1em;
  background-color: rgb(0, 0, 0);
  color: white;
  border: none;
  border-radius: 5%;
}
</style> -->



<!--여기가 진짜-->
<template>
  <div class="league-view">
    <h1>League Rankings</h1>
    <div class="league-view-buttons">
      <button @click="selectGameID('티볼')">Teeball</button>
      <button @click="selectGameID('빅발리볼')">Vic-volleyball</button>
      <button @click="selectGameID('인디아카')">Indiaca</button>
      <button @click="selectGameID('츄크볼')">Tchouball</button>
      <button @click="selectGameID('플로어볼')">Floorball</button>
      <button @click="selectGameID('스포츠스태킹')">Sport Stacking</button>
    </div>

    <!-- <div v-if="data.rankings.length">
      <div class="league-view-rank">
        <div v-for="ranking in data.rankings" :key="ranking.clubID">
          <div class="rank-individual">
            {{ ranking.ranking }}: {{ ranking.clubID }} - {{ ranking.totalPoints }} points
          </div>
        </div>
      </div>
    </div>
    <div class="league-view-rank" v-else>
      <p>종목을 선택해주세요.</p>
    </div> -->

    <div v-if="data.rankings.length">
      <table class="league-view-rank">
            <tr>
                <th>Rank</th>
                <th>Club</th>
                <th>Points</th>
            </tr>
            <tr class="rank-individual" v-for="ranking in data.rankings" :key="ranking.clubID">
                <td>{{ ranking.ranking }}</td>
                <td>{{ ranking.clubID }}</td>
                <td>{{ ranking.totalPoints }}</td>
            </tr>
        </table>
    </div>
    <div class="league-view-rank" v-else>
      <p>종목을 선택해주세요.</p>
    </div>

    
    <div class="today-match">
      <h1>Today's Matches</h1>
      <div class="today-match-day">{{showToday}}</div>
      <div v-if="data.todayGames.length">
        <div class="league-view-match">
          <div v-for="game in data.todayGames" :key="game.matchId">
            <div class="match-individual">
              {{ game.clubID }} vs {{ game.oppClubID }} at {{ game.location }}
            </div>
          </div>
        </div>
      </div>
      <div v-else>
        <p>오늘 예정된 경기가 없습니다.</p>
      </div>
    </div>
    
    <div class="league-view-sponsers">
      <div class="sponser-title"> Out Partners </div>
      <div class="sponser-individual">
        <img src="https://images.samsung.com/kdp/aboutsamsung/brand_identity/logo/256_144_3.png?$512_288_PNG$"/>
        <img src="https://avatars.githubusercontent.com/u/144643944?s=280&v=4"/>
        <img src="https://upload.wikimedia.org/wikipedia/en/thumb/c/cc/Chelsea_FC.svg/1200px-Chelsea_FC.svg.png"/>
        <img src="https://i.namu.wiki/i/MTTnomx6sFT5B65wu0au0LOozk78rvq_5VFyPEspyndNBMvSWfWZlSSokOnIyGoFeLduV-WR-quvrwd412wQzg.webp"/>
        <img src="https://upload.wikimedia.org/wikipedia/commons/f/f8/Aespa_logo.jpg"/>
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Samsung_Logo.svg/1024px-Samsung_Logo.svg.png"/>
        <img src=""/>
        <img src=""/>
        <img src=""/>
        <img src=""/>
      </div>
    </div>


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
  margin-top: 2em;
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

/* 종목 선택 개별 버튼 */
button {
  padding: 10px;
  margin: 1em;
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
  padding: 3em 1em;
  /* min-height: 500px; */
  width: 100%;

  /* margin-bottom: 1px; */
}
/* OUR PARTNERS */
.sponser-title{
  color: white;
  font-family: "LA28 Display";
  font-size: x-large;
  width: 100%;
  margin-bottom: 2em;
  text-align: center; /** 제목 중앙 정렬 */
}
/* 개별 로고 */
.sponser-individual{
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  align-items: center;
  gap: 3em;
  height: 5em;
  width: auto;
}
.sponser-individual img {
  height: 100%; /* 이미지 높이를 컨테이너 높이에 맞춤 */
 
}
</style>
