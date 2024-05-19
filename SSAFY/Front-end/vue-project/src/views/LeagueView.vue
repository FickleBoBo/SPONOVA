<!-- <template>
  <div>
    <h1>League Rankings</h1>
    <ul>
      <li v-for="ranking in leagueStore.leagueRankings" :key="ranking.clubID">
        {{ranking.ranking }}: {{ ranking.clubID }}: {{ ranking.totalPoints }} 점
      </li>
    </ul>
  </div>
</template> -->

<template>
  <div>
    <h1>League Rankings</h1>
    <button @click="selectGameID('티볼')">티볼 리그</button>
    <button @click="selectGameID('빅발리볼')">빅발리볼 리그</button>
    <button @click="selectGameID('인디아카')">인디아카 리그</button>
    <button @click="selectGameID('츄크볼')">츄크볼 리그</button>
    <button @click="selectGameID('플로어볼')">플로어볼 리그</button>
    <button @click="selectGameID('스포츠스태킹')">스포츠스태킹 리그</button>

    <div v-if="leagueRankings.length > 0">
      <ul>
        <li v-for="ranking in leagueRankings" :key="ranking.clubID">
          {{ranking.ranking}}: {{ ranking.clubID }}: {{ ranking.totalPoints }} points
        </li>
      </ul>
    </div>
    <div v-else>
      No rankings available.
    </div>
  </div>


  <div>
    <h1>Today's Matches</h1>
    <div v-if="todaysGames.length > 0">
      <ul>
        <li v-for="game in todaysGames" :key="game.gameDay + game.ClubId">
          {{ game.ClubId }} vs {{ game.OppClubId }} at {{ game.Location }}
        </li>
      </ul>
    </div>
    <div v-else>
      No games today.
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
    leagueRankings.value = leagueStore.leagueRankings;  // 스토어 업데이트 후 로컬 상태를 갱신
  })
}     

// function filterTodaysGames(games) {
//   const today = new Date().toISOString().slice(0, 10); // "YYYY-MM-DD"
//   return games.filter(game => game.gameDay === today);
// }


// onMounted(async () => {
//   await leagueStore.getLeagueRankingByGameID('티볼'); // 데이터 로드
//   const filteredGames = filterTodaysGames(leagueStore.leagueRankings);
//   console.log('Filtered games:', filteredGames); // 필터링된 데이터 로그
//   todaysGames.value = filteredGames;
// })
</script>



<style scoped>
button {
  padding: 10px;
  background-color: blue;
  color: white;
  border: none;
  border-radius: 5px;
}
</style>