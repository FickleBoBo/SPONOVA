<template>
    <RouterLink :to="{name: 'home'}">Home</RouterLink> <br>
    <RouterLink :to="{name: 'intro'}">Intro</RouterLink> <br>
    <RouterLink :to="{name: 'game'}">Game</RouterLink> <br>
    <RouterLink :to="{name: 'league'}">League</RouterLink> <br>
    <RouterLink :to="{name: 'club'}">Club</RouterLink> <br>
    <RouterLink :to="{name: 'community'}">Community</RouterLink> <br>
    <RouterLink :to="{name: 'login'}">Login</RouterLink> <br>

    <div style="position: relative; width: 893px; height: 502px;">
    <iframe 
        width="893" 
        height="502" 
        src="https://www.youtube.com/embed/phuiiNCxRMg?autoplay=1&mute=1&controls=0&loop=1&playlist=phuiiNCxRMg" 
        title="aespa 에스파 &#39;Supernova&#39; MV" 
        frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
        referrerpolicy="strict-origin-when-cross-origin" 
        allowfullscreen></iframe>
    <div style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: transparent;"></div>
    </div>
    <RouterView />
</template>



<script setup>

// router 기능 사용
import { RouterLink, RouterView } from 'vue-router'

</script>



<style scoped>

</style>
