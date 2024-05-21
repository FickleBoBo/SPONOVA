<template>
  <div class="club-view">
    <div>
      <h1>Club List</h1>
    </div>

    <div class="screen-edge-text">Moving Text Here . 이 문구가 움직였으면 좋겠어요 제발 ~~ 검은색 배경에 흰색글씨로 할거야</div>
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

.club-view{
  margin: 0 auto;
  justify-content: center;
  text-align: center;
}


/* CLUB LIST */
h1{
  margin-top: 1em;
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
  width: 80%;
  margin: 0 auto;
  display: flex;
  flex-wrap: wrap;
  overflow: hidden;
  justify-content: center;
  text-align: center;
}

/* 개별 카드 섹션 */
.club-view-individual{
  position: relative;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  overflow: hidden;
  border: 2px solid black;
  padding: 1em;
  margin: 1em;
  height: 15em;
  width: 15em;

  transition: transform 0.5s ease-in-out;
}
/* 호버링 시 반응형 */
.club-view-individual:hover {
  transform: scale(1.1); 
  color: white;
  background-color: black;
  
}

/* 움직임 test */
.screen-edge-text {
  position: fixed;
  white-space: nowrap;
  width: max-content; /* 글씨의 실제 너비만큼 너비를 설정 */
  animation: move-around-screen 10s linear infinite;
}
@keyframes move-around-screen {
  0% { top: 0; left: 0; transform: translate(0, 0); }
  25% { top: 0; left: 100%; transform: translate(-100%, 0); } /* 상단 가로 이동 */
  50% { top: 100%; left: 100%; transform: translate(-100%, -100%); } /* 오른쪽 세로 이동 */
  75% { top: 100%; left: 0; transform: translate(0, -100%); } /* 하단 가로 이동 */
  100% { top: 0; left: 0; transform: translate(0, 0); } /* 왼쪽 세로 이동 */
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

/* 각 로고 이미지 */
img {
  background-color: none;
  width: 10em; /* em은 부모 기준. rem은 root 기준 (html에서 root는 <html>) */
  height: auto;
}
</style>