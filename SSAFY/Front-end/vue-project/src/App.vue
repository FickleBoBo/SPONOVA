<template>
    <div v-if="userStore.loginStatus"><h1>{{ userStore.loginInfo.userNickname }}</h1></div>
    <div v-else><h1>로그인을 해주세요</h1></div>
    <RouterLink :to="{name: 'home'}">Home</RouterLink> <br>
    <RouterLink :to="{name: 'intro'}">Intro</RouterLink> <br>
    <RouterLink :to="{name: 'game'}" class="game-container">
        Game
        <div v-for="item in gameStore.gameInfo" :key="item.id">
            <RouterLink :to="{name: 'gameDetail', params: { id: item.id} }">{{ item.koName }}</RouterLink>
        </div>
    </RouterLink>
    <RouterLink :to="{name: 'league'}">League</RouterLink> <br>
    <RouterLink :to="{name: 'club'}">Club</RouterLink> <br>
    <RouterLink :to="{name: 'community'}">Community</RouterLink> <br>

    <div>
        <RouterLink v-if="!userStore.loginStatus" :to="{name: 'login'}">Login</RouterLink> <br>
        <RouterLink v-if="userStore.loginStatus" :to="{name: 'login'}">Logout</RouterLink> <br>
    </div>





    
    <RouterView />
</template>



<script setup>

// router 기능 사용
import { RouterLink, RouterView } from 'vue-router'

// pinia 불러오기
import { useGameStore } from '@/stores/game'
const gameStore = useGameStore()

import { useUserStore } from '@/stores/user'
const userStore = useUserStore()

</script>



<style scoped>

.game-container {
    display: flex;
}

</style>
