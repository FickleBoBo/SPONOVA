<template>
    <div>
        <div class="header">
            <div>
                <h1>New Sports</h1>
            </div>
            <div>
                뉴스포츠는 국제적으로 통일된 기존의 스포츠와는 달리, 규칙의 유연성과 게임의 간편성, 게임의 재미 등을 특징으로 하는 참가자 지향의 스포츠를 총칭하는 새로운 형태의 스포츠입니다.
            </div>
            <div>
                뉴스포츠는 유아, 노인, 장애인 등 모든 사람들이 쉽게 즐길 수 있어 생활체육으로 활용되고 있습니다.
            </div>
            <div>
                뉴스포츠는 크게 육상형, 해양형, 산악형, 항공형 등으로 분류되며, 이 중 티볼, 츄크볼, 킨볼등이 가장 대중적인 종목으로 알려져 있습니다.
            </div>
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
                            <div class="game-info2">{{ game.info2 }}</div>
                            <div class="game-info3">{{ game.info3 }}</div>
                            <div class="option">
                                <!-- <div class="game-rules-url">
                                    <button @click="showRules(game.rulesUrl)" :disabled="!game.rulesUrl">경기 규칙</button>
                                </div>
                                <div class="game-video-url">
                                    <button @click="showVideo(game.videoUrl)" :disabled="!game.videoUrl">경기 영상</button>
                                </div> -->
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
                            <div class="game-info2">{{ game.info2 }}</div>
                            <div class="game-info3">{{ game.info3 }}</div>
                            <div class="option">
                                <!-- <div class="game-rules-url">
                                    <button @click="showRules(game.rulesUrl)" :disabled="!game.rulesUrl">경기 규칙</button>
                                </div>
                                <div class="game-video-url">
                                    <button @click="showVideo(game.videoUrl)" :disabled="!game.videoUrl">경기 영상</button>
                                </div> -->
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
    threshold: 0.6
  })

  refs.value.forEach(ref => observer.observe(ref))

  onUnmounted(() => {
    refs.value.forEach(ref => observer.unobserve(ref))
  })
})

</script>



<style scoped>

.header {
    text-align: center;
    margin: 10rem;
}

.header > * {
    margin-top: 5rem;
}

.header h1 {
    opacity: 0;
    animation: fadeIn 2s forwards;
}

.header div {
    opacity: 0;
    animation: fadeIn 3s forwards;
}

@keyframes fadeIn {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}

.header h1 {
    animation-delay: 0.5s;
}

.header div:nth-child(2) {
    animation-delay: 1.0s;
}

.header div:nth-child(3) {
    animation-delay: 1.5s;
}

.header div:nth-child(4) {
    animation-delay: 2.0s;
}

.game-item-container {
    width: 1400px;
    margin: 0 auto;
    margin-top: 15rem;
    margin-bottom: 15rem;
    border: 3px solid black;
    text-align: center;
}

.game-item {
    position: relative;
    display: flex;
    align-items: center;
    padding: 2rem;
}

.game-photo, .game-content {
    flex: 1;
}

.game-photo {
    position: relative;
}


.game-photo img {
    height: 500px;
    width: 600px;
}

.game-photo::after {
    content: '';
    position: absolute;
    bottom: 0;
    left: 0;
    width: 0;
    height: 0;
    border-bottom: 150px solid white;
    border-right: 150px solid transparent;
}

.game-content {
    height: 500px;
    width: 600px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.game-content > * {
    margin: 1rem;
}

.option {
    display: flex;
}

.option > * {
    margin-left: 1rem;
    margin-right: 1rem;
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
