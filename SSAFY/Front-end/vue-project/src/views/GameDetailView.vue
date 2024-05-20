<template>
  <div class="game-container">
    <div class="game-header">
      <h3>{{ gameStore.gameInfo[$route.params.id-1].koName }} ({{ gameStore.gameInfo[$route.params.id-1].enName }})</h3>
    </div>

    <div class="game-info">
      <div class="info-item">{{ gameStore.gameInfo[$route.params.id-1].info1 }}</div>
      <div class="info-item">{{ gameStore.gameInfo[$route.params.id-1].info2 }}</div>
      <div class="info-item">{{ gameStore.gameInfo[$route.params.id-1].info3 }}</div>
    </div>

    <div class="game-photo">
      <img :src="gameStore.gameInfo[$route.params.id-1].photo" alt="Game Photo">
    </div>

    <div class="game-actions">
      <button @click="showRules(gameStore.gameInfo[$route.params.id-1].rulesUrl)" :disabled="!gameStore.gameInfo[$route.params.id-1].rulesUrl" class="action-button">경기 규칙</button>
      <button @click="showVideo(gameStore.gameInfo[$route.params.id-1].videoUrl)" :disabled="!gameStore.gameInfo[$route.params.id-1].videoUrl" class="action-button">경기 영상</button>
    </div>
  </div>
</template>

<script setup>
import { useGameStore } from '@/stores/game'

const gameStore = useGameStore()

const showRules = (url) => {
  window.location.href = url
}

const showVideo = (url) => {
  window.location.href = url
}
</script>

<style scoped>
.game-container {
  font-family: 'Roboto', sans-serif;
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
  background-color: #ffffff;
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.game-header h3 {
  font-size: 2em;
  color: #2c3e50;
  margin-bottom: 20px;
  text-align: center;
}

.game-info {
  display: grid;
  grid-template-columns: 1fr;
  gap: 15px;
  margin-bottom: 20px;
}

.info-item {
  background-color: #f5f5f5;
  padding: 15px;
  border-radius: 5px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.game-photo {
  text-align: center;
  margin-bottom: 20px;
}

.game-photo img {
  max-width: 100%;
  border-radius: 10px;
}

.game-actions {
  display: flex;
  gap: 15px;
  justify-content: center;
}

.action-button {
  padding: 12px 24px;
  font-size: 1em;
  color: #ffffff;
  background-color: #3498db;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.action-button:disabled {
  background-color: #95a5a6;
  cursor: not-allowed;
}

.action-button:not(:disabled):hover {
  background-color: #2980b9;
}
</style>
