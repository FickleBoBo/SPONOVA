<template>
    <div>
    <div>
      <h3>{{ gameStore.gameInfo[$route.params.id-1].koName }}</h3>
    </div>
  
    <!--확인용 <div>번호 : {{ $route.params.id }}</div> -->
    <!-- <div>한글 이름 : {{ gameStore.gameInfo[$route.params.id-1].koName }}</div>
    <div>영어 이름 : {{ gameStore.gameInfo[$route.params.id-1].enName }}</div> -->
   
    <div class="koName">{{ gameStore.gameInfo[$route.params.id-1].koName }}</div>
    <div class="enName">{{ gameStore.gameInfo[$route.params.id-1].enName }}</div>
   
    
    <div class="info">{{ gameStore.gameInfo[$route.params.id-1].info }}</div>   
  
    </div>
  </template>
  
  
<script setup>

import { useGameStore } from '@/stores/game'

const gameStore = useGameStore()

</script>



<style scoped>

</style>