<template>
    <div>
        <h1>IntroView</h1>

        <div class="scroll-container">
            <div v-for="game in gameStore.gameInfo" :key="game.id" class="game-item-container animated-text" ref="refs">
                <div class="game-item">
                    <div class="game-photo">
                        <img :src="game.photo" alt="game.enName">
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>



<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import { useGameStore } from '@/stores/game'
const gameStore = useGameStore()

const showRules = ((url) => {
  window.location.href = url
})

const showVideo = ((url) => {
  window.location.href = url
})

const refs = ref([])
onMounted(() => {
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('enter')
      }
    })
  }, {
    threshold: 1
  })

  refs.value.forEach(ref => observer.observe(ref))

  onUnmounted(() => {
    refs.value.forEach(ref => observer.unobserve(ref))
  })
})

</script>



<style scoped>

</style>