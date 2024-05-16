<template>
    <div v-if="true"><h1>{{ store2.loginInfo.userNickname }}</h1></div>
    <RouterLink :to="{name: 'home'}">Home</RouterLink> <br>
    <RouterLink :to="{name: 'intro'}">Intro</RouterLink> <br>
    <RouterLink :to="{name: 'game'}" class="game-container">
        Game
        <div v-for="item in store.gameInfo" :key="item.id">
            <RouterLink :to="{name: 'gameDetail', params: { id: item.id} }">{{ item.koName }}</RouterLink>
        </div>
    </RouterLink>
    <RouterLink :to="{name: 'league'}">League</RouterLink> <br>
    <RouterLink :to="{name: 'club'}">Club</RouterLink> <br>
    <RouterLink :to="{name: 'community'}">Community</RouterLink> <br>

    <div>
        <RouterLink v-if="!store2.login" :to="{name: 'login'}">Login</RouterLink> <br>
        <RouterLink v-if="store2.login" :to="{name: 'login'}">Logout</RouterLink> <br>
    </div>





    
    <RouterView />
</template>



<script setup>

// router 기능 사용
import { RouterLink, RouterView } from 'vue-router'

// pinia 불러오기
import { gameInfoStore } from '@/stores/gameInfo'
const store = gameInfoStore()

import { userInfoStore } from '@/stores/userInfo'
const store2 = userInfoStore()

</script>



<style scoped>

.game-container {
    display: flex;
}

</style>
