<template>
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
    <div v-if="todaysGames.length > 0">
      <ul>
        <li v-for="game in todaysGames" :key="game.gameDay + game.ClubId">
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

const leagueStore = useLeagueStore()
const leagueRankings = ref(leagueStore.leagueRankings)
const todaysGames = ref([])

// onMounted(() => {
//   leagueStore.getLeagueRankingByGameID('티볼') // '티볼' 게임 ID로 랭킹을 로드
// })
// onMounted(() => {
//   leagueStore.getLeagueRankingByGameID('빅발리볼') // '티볼' 게임 ID로 랭킹을 로드
// })
// function selectGameID(gameID) {
//   leagueStore.getLeagueRankingByGameID(gameID)
// }
function selectGameID(gameID) {
  leagueStore.getLeagueRankingByGameID(gameID).then(() => {
    leagueRankings.value = leagueStore.leagueRankings;
  })
}     

// 오늘의 경기 띄우기
// function filterTodaysGames(games) {
//   const today = new Date().toLocaleDateString(); // 로컬 시간대 기반 "MM/DD/YYYY"
//   return games.filter(game => {
//     const gameDate = new Date(game.gameDay).toLocaleDateString(); // 데이터의 날짜도 동일한 형식으로 변환
//     return gameDate === today;
//   });
// }



// onMounted(async () => {
//   await leagueStore.getLeagueRankingByGameID('티볼'); // 데이터 로드
//   const filteredGames = filterTodaysGames(leagueStore.leagueRankings);
//   console.log('Filtered games:', filteredGames); // 필터링된 데이터 로그
//   todaysGames.value = filteredGames;
// })
</script>



<style scoped>

.league-view{
  /* position: relative; */
  margin-top: 2em;
}
button {
  padding: 10px;
  background-color: blue;
  color: white;
  border: none;
  border-radius: 5px;
}
</style>