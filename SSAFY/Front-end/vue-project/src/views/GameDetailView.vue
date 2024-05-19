<template>
    <div>
    <div>
      <h3>{{ gameStore.gameInfo[$route.params.id-1].koName }}</h3>
    </div>

    <div class="koName">{{ gameStore.gameInfo[$route.params.id-1].koName }}</div>
    <div class="enName">{{ gameStore.gameInfo[$route.params.id-1].enName }}</div>
       
    <div class="info">{{ gameStore.gameInfo[$route.params.id-1].info }}</div>

    <button @click="showRules(gameStore.gameInfo[$route.params.id-1].rulesUrl)" :disabled="!gameStore.gameInfo[$route.params.id-1].rulesUrl">경기 규칙</button>
    <button @click="showVideo(gameStore.gameInfo[$route.params.id-1].videoUrl)" :disabled="!gameStore.gameInfo[$route.params.id-1].videoUrl">경기 영상</button>
    </div>
  </template>
  
  
<script setup>

import { useGameStore } from '@/stores/game'

const gameStore = useGameStore()

const showRules = ((url) => {
  window.location.href = url
})

const showVideo = ((url) => {
  window.location.href = url
})

</script>



<style scoped>

</style>