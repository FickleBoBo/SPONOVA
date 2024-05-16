<template>
    <div>
    <div>
      <h3>Club List</h3>
    </div>
  
    <div class="club-card" v-for="club in store.clubList" :key="club.clubID">
        <div>팀명: {{ club.clubID }}</div>
        <div>종목: {{ club.gameID}}</div>
        <div>소개: {{ club.clubContent }}</div>
        <div>일단이미지경로: {{ club.clubLogoPath }}</div>
    </div>
        
  
        <!-- 나중에 구현할 검색 기능 -->
        <!-- <BoardSearchInput/> -->
  
        
      <RouterView />
    </div>
  </template>
  
  
  <script setup>
  
  import { useClubStore } from '@/stores/clubInfo'
  import{onMounted} from 'vue'
  
  const store = useClubStore()
  
  onMounted(() => {
    store.getClubList()
  })
  
  
  </script>
  
  <style scoped>
  .club-card {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    
    width: 30%;
    height: 50%;
    border: #bbddfc 0.2px solid;
    padding: 0.5rem;
    margin: 0.2rem;
    
  }

  img {
    width: 10em; /* em은 부모 기준. rem은 root 기준 (html에서 root는 <html>) */
    height: 5em;
  }
  </style>