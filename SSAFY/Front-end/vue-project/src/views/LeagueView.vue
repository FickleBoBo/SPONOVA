<template>
    <div>
        <h1>LeagueView</h1>
    </div>

    <div v-for="league in leagueStore.leagueList" :key="league.leagueID">
      <div>{{ league }}</div>  
      <div>리그: {{ league.leagueID }}</div>
        <div>홈팀: {{ league.ClubId }}</div>
        <div>원정팀: {{ league.clubID }}</div>
        <div>경기장소: {{ league.clubID }}</div>
        <div>승팀: {{ league.clubID }}</div>
    </div>
</template>



<script setup>

import { useLeagueStore } from '@/stores/league'
import{onMounted} from 'vue'
  
const leagueStore = useLeagueStore()
  
onMounted(() => {
  leagueStore.getLeagueList()
})

</script>



<style scoped>

</style>