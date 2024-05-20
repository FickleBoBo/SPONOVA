<template>
  <div class="club-view">
    <div>
      <h1>Club List</h1>
    </div>

    <div>
      <div class="club-view-search">
        <ClubSearchInput/>
      </div>
      
      <div class="club-view-all">
        <div  class="club-view-individual" v-for="club in clubStore.clubList" :key="club.clubID">
          <div class="club-view-img"><img :src="club.clubLogoPath" alt="LOGO"/></div>
          <div class="club-view-clubid">{{ club.clubID }}</div>
          <div class="club-view-game">{{ club.gameID}}</div>
        </div>
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

/* 클럽 페이지 전체 영역 */
.club-view{
  margin-top: 3em;
}

/* CLUB LIST */
h1{
  font-size: xx-large;
  font-family: "LA28 Display";
  text-align: center;
}

/* 검색 영역 */
.club-view-search{
  /* width: 100%; */
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: 600;
}

/* 전체 카드 섹션 */
.club-view-all{
  width: 90%;
  margin: 0 auto;
  display: flex;
  flex-wrap: wrap;
  overflow: hidden;
}

/* 개별 카드 섹션 */
.club-view-individual{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  overflow: hidden;
  border: 2px solid black;
  padding: 1em;
  margin: 1em;
  height: 13em;
  width: 13em;

  transition: transform 0.5s ease-in-out;
}
/* 호버링 시 반응형 */
.club-view-individual:hover {
  transform: scale(1.1); 
  color: white;
  background-color: black;
  
}

/* 로고 이미지 */
.club-view-img{
  margin: auto 0;
}

/* 클럽명 */
.club-view-clubid{
  font-weight: 700;
  align-items: center;
  text-align: center;
}

/* 종목명 */
.club-view-game{
  font-size: small;
}

img {
  width: 10em; /* em은 부모 기준. rem은 root 기준 (html에서 root는 <html>) */
  height: auto;
}
</style>