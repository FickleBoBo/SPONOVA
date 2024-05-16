<template>
    <div>
    <div>
      <h3>Club List</h3>
    </div>

    <div>
      <ClubSearchInput/>
      
      <div v-for="club in clubStore.clubList" :key="club.clubID" class="club-card">
        <img :src="club.clubLogoPath" alt="LOGO"/>
        <div>팀명: {{ club.clubID }}</div>
        <div>종목: {{ club.gameID}}</div>
        <div>소개: {{ club.clubContent }}</div>
        <!-- <div>이미지경로: {{ club.clubLogoPath }}</div> -->
      </div>
    </div>
  
        
      <RouterView />
    </div>
  </template>
  
  
  <script setup>
  
  import ClubSearchInput from '@/components/Club/ClubSearchInput.vue';
  import { useClubStore } from '@/stores/club'
  import{onMounted} from 'vue'
  import {ref} from 'vue'
  
  const clubStore = useClubStore()


  
  onMounted(() => {
    clubStore.getClubList()
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