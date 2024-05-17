<template>
    
    <!-- 네비게이션 바 고정 영역 -->
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



    <!-- 네비게이션 바 동적 영역 -->
    <!-- 로그인 안했으면 "로그인" / "회원가입" -->
    <!-- 로그인 했으면 "로그아웃" / "닉네임"-->
    <div>
        <RouterLink v-if="!userStore.loginStatus" :to="{name: 'login'}">Login</RouterLink>
        <RouterLink v-if="userStore.loginStatus" :to="{name: 'logout'}">Logout</RouterLink>
        <br>
        <RouterLink v-if="!userStore.loginStatus" :to="{name: 'login'}">회원가입</RouterLink>
        <RouterLink v-if="userStore.loginStatus" :to="{name: 'login'}">{{ userStore.loginInfo.userNickname }}</RouterLink>
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

console.log(userStore.loginStatus)
</script>



<style scoped>

.game-container {
    display: flex;
}

</style>
