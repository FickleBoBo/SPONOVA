<template>
    <div>
        <div>
            <h1>New Sports</h1>
        </div>
        <div class="scroll-container">
            <div v-for="(game, index) in gameStore.gameInfo" :key="game.id" class="game-item-container animated-text" ref="refs">
                <div v-if="index%2==0">
                    <div class="game-item">
                        <div class="game-photo">
                            <img :src="game.photo">
                        </div>
                        <div class="game-content">
                            <div class="game-name"><h2>{{ game.koName }}({{ game.enName }})</h2></div>
                            <div class="game-info1">{{ game.info1 }}</div>
                            <div class="option">
                                <div class="game-rules-url">
                                    <button @click="showRules(game.rulesUrl)" :disabled="!game.rulesUrl">경기 규칙</button>
                                </div>
                                <div class="game-video-url">
                                    <button @click="showVideo(game.videoUrl)" :disabled="!game.videoUrl">경기 영상</button>
                                </div>
                                <div class="learn-more">
                                    <RouterLink :to="{ name: 'gameDetail', params: { id: game.id } }">Learn more</RouterLink>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div v-else>
                    <div class="game-item">
                        <div class="game-content">
                            <div class="game-name"><h2>{{ game.koName }}({{ game.enName }})</h2></div>
                            <div class="game-info1">{{ game.info1 }}</div>
                            <div class="option">
                                <div class="game-rules-url">
                                    <button @click="showRules(game.rulesUrl)" :disabled="!game.rulesUrl">경기 규칙</button>
                                </div>
                                <div class="game-video-url">
                                    <button @click="showVideo(game.videoUrl)" :disabled="!game.videoUrl">경기 영상</button>
                                </div>
                                <div class="learn-more">
                                    <RouterLink :to="{ name: 'gameDetail', params: { id: game.id } }">Learn more</RouterLink>
                                </div>
                            </div>
                        </div>
                        <div class="game-photo">
                            <img :src="game.photo">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 이거 때문에 URL 바뀌어도 화면에 표시 안됐는데 중첩 라우터 쓰면 해당 중첩 위치에서 <RouterView /> 불러줘야 함 -->
    <RouterView />
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
    threshold: 0.7
  })

  refs.value.forEach(ref => observer.observe(ref))

  onUnmounted(() => {
    refs.value.forEach(ref => observer.unobserve(ref))
  })
})

</script>



<style scoped>

.game-item-container {
    width: 1200px;
    margin: 0 auto;
    margin-top: 15rem;
    margin-bottom: 15rem;
    border: 3px solid black;
    text-align: center;
}

.game-item {
    display: flex;
    align-items: center;
    padding: 2rem;
}

.game-photo, .game-content {
    flex: 1;
}

.game-photo img {
    height: 500px;
    width: 500px;
}

.game-content > * {
    margin-top: 5rem;
}

.option {
    display: flex;
}

.option > * {
    margin: 1rem;
}

.learn-more {
    margin-left: auto;
}

.animated-text {
  opacity: 0;
  transform: translateY(100px);
  transition: transform 0.8s ease-out, opacity 0.8s ease-out;
}

.animated-text.enter {
  opacity: 1;
  transform: translateY(0);
}

</style>
