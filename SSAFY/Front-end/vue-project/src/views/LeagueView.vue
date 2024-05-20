<!-- <template>
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
    <button @click="selectGameID('티볼')">티볼</button>
    <button @click="selectGameID('빅발리볼')">빅발리볼</button>
    <button @click="selectGameID('인디아카')">인디아카</button>
    <button @click="selectGameID('츄크볼')">츄크볼</button>
    <button @click="selectGameID('플로어볼')">플로어볼</button>
    <button @click="selectGameID('스포츠스태킹')">스포츠스태킹</button>

    <div v-if="data.rankings.length">
      <ul>
        <li v-for="ranking in data.rankings" :key="ranking.clubID">
          {{ ranking.ranking }}: {{ ranking.clubID }} - {{ ranking.totalPoints }} points
        </li>
      </ul>
    </div>
    <div v-else>
      <p>Please select a game to view rankings.</p>
    </div>

    <div class="today-match">
      <h1>Today's Matches</h1>
      <div v-if="data.todayGames.length">
        <ul>
          <li v-for="game in data.todayGames" :key="game.matchId">
            {{ game.clubID }} vs {{ game.oppClubID }} at {{ game.location }}
          </li>
        </ul>
      </div>
      <div v-else>
        <p>No games scheduled for today.</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useLeagueStore } from '@/stores/league';
const { data, getLeagueDetailsByGameID } = useLeagueStore();

function selectGameID(gameID) {
  getLeagueDetailsByGameID(gameID);
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
</style>
