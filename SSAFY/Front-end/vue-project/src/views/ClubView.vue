<template>
  <div class="club-view">
    <div>
      <h1>Club List</h1>
    </div>

    <!-- <div class="screen-edge-text">Moving Text Here . 이 문구가 움직였으면 좋겠어요 제발 ~~ 검은색 배경에 흰색글씨로 할거야</div> -->
    <div>
      <div class="club-view-search">
        <ClubSearchInput/>
      </div>
      
      <div class="club-view-body">
        <div class="club-view-all">
            <div  class="club-view-individual" v-for="club in clubStore.clubList" :key="club.clubID">
              <div class="club-view-img"><img :src="club.clubLogoPath" alt="LOGO"/></div>
              <div class="club-view-clubid">{{ club.clubID }}</div>
              <div class="club-view-game">{{ club.gameID}}</div>
              <!-- <div>{{ club.clubContent }}</div> -->
              <div class="club-view-modal-button"><button @click="showModal(club)">➖</button></div>
            </div>
          </div>
        </div>
    
        <div class="background-text">
          <div class="background-text-contents">
            <div class="text-line" v-for="(line, index) in 
              ['Explore a variety of clubs!', 
              'Search for the sport you love!', 
              'Compete for victory in our weekly leagues!', 
              'Join a club and enjoy exciting experiences!', 
              'We are the new sports clubs!', 
              'Bored on weekends?', 
              'New sports are easier and more fun than traditional sports!', 
              'From toddlers to seniors, everyone can participate!', 
              'Experience a fresh perspective on physical education!', 
              // 'Improve your health and social skills through team sports!',
              ]" :key="index">
              {{ line }} Join Our Club!
            </div>
          </div>
        </div>
      </div>
  
        
      <RouterView />

      <!--모달 구현 부분-->
      <div v-if="isModalVisible" class="modal" @click.self="closeModal">
        <div class="modal-content">
          <span class="modal-close" @click="closeModal">&times;</span>
          <p>{{ selectedClubContent }}</p>
        </div>
      </div>

  </div>
</template>
  
 

<script setup>

import ClubSearchInput from '@/components/Club/ClubSearchInput.vue';
import { useClubStore } from '@/stores/club'
import{onMounted} from 'vue'
import {ref} from 'vue'

const clubStore = useClubStore()

//모달 부분 아래 2줄
const isModalVisible = ref(false)
const selectedClubContent = ref("")

onMounted(() => {
  clubStore.getClubList()
})

// 여기서부터 모달
function showModal(club) {
  selectedClubContent.value = club.clubContent
  isModalVisible.value = true
}

function closeModal() {
  isModalVisible.value = false
}

</script>


  
<style scoped>

.club-view{
  margin: 0 auto;
  width: 100%;
  height: auto;
  min-height: 3500px;
  justify-content: center;
  text-align: center;
  background-color: rgb(0, 0, 0);
  position: relative; /*z-index를 위해서*/
  padding-bottom: 5em;
}

.club-view-body {
  width: 80%;
  margin: 0 auto;
  display: flex;
  flex-direction: column; 
  justify-content: center;
  text-align: center;
  position: relative;
  z-index: 5;
  overflow: hidden;  /*영역을 넘어가는 내용은 숨김 처리 */
}

/*애니메이션 테스트*/
/* 텍스트 움직임 구현 */
.background-text {
  color: white;
  font-family: "LA28 Display";
  font-size: 8em;

  position: absolute; /* 배경 텍스트를 절대 위치에 두어 항상 보이게 함 */
  width: 100%;
  /* top: 60%; /**얘 조정이 까다로움 
  transform: translateY(-50%);
  z-index: 1; */
  top: 1em; /* `top` 값을 조정 */
  left: 0; /* 왼쪽 정렬을 위해 추가 */
  transform: translateY(0); /* 기본적인 위치 조정을 제거 */
  z-index: 1;
}

/* MW 추가 코드 */
.background-text-contents {
  overflow: hidden;
  width: 100%;
}

/**0523 수정 */
.background-text-contents .text-line {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;  /*최대 라인 수를 2로 설정*/
  overflow: hidden;
  /* text-overflow: ellipsis;  */
  font-size: 125px; /**맨 처음의 글자 크기 */
}

@media (max-width: 1800px) {
  .background-text-contents .text-line {
    /* overflow: hidden; */
    font-size: 110px;
  }
}
@media (max-width: 1500px) {
  .background-text-contents .text-line {
    /* overflow: hidden; */
    font-size: 100px;
  }
}
@media (max-width: 1200px) {
  .background-text-contents .text-line {
    /* overflow: hidden; */
    font-size: 80px;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
  }
}
@media (max-width: 800px) {
  .background-text-contents .text-line {
    /* overflow: hidden; */
    font-size: 80px;
  }
}@media (max-width: 500px) {
  .background-text-contents .text-line {
    /* overflow: hidden; */
    font-size: 80px;
  }
}


/**여기까지 수정 */

/* 홀 짝 라인 구분 */
.background-text-contents .text-line:nth-child(odd) {
  animation: moveRight 15s linear infinite;
  /* white-space: nowrap; */
}

.background-text-contents .text-line:nth-child(even) {
  animation: moveLeft 15s linear infinite;
  /* white-space: nowrap; */
}

@keyframes moveRight {
  from { transform: translateX(-100%); }
  to { transform: translateX(100%); }
}

@keyframes moveLeft {
  from { transform: translateX(100%); }
  to { transform: translateX(-100%); }
}


/* CLUB LIST */
h1{
  color: white;
  margin-top: 2em;
  font-size: xx-large;
  font-family: "LA28 Display";
  text-align: center;
  position: relative;
  z-index: 5;

  /* 색상 변환 애니메이션 걸어주기 */
  animation: colorCycle 2s linear infinite;
}

/* 색상 변환 2컬러 2초 주기 */
@keyframes colorCycle {
  0%, 100% {
    color: white;
  }
  50% {
    color: rgb(255, 34, 189);
  }
}

/* 검색 영역 */
.club-view-search{
  /* width: 100%; */
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: 600;
  position: relative;
  z-index: 5;
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
  position: relative;
  z-index: 5;
}

/* 개별 카드 섹션 */
.club-view-individual{
  position: relative;
  background-color: white;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  overflow: hidden;
  border: 2px solid rgb(0, 0, 0);
  padding: 1em;
  margin: 1em;
  height: 15em;
  width: 15em;

  transition: transform 1s ease-in-out, background-color 0.5s ease-in-out, color 0.5s ease-in-out;
}
/* 호버링 시 반응형 */
.club-view-individual:hover {
  /* transform: scale(1.1); 
  transform: rotateZ(360); */
  transform: scale(1.1) rotateY(360deg);
  color: white;
  background-color: black;
  border: 2px solid rgb(255, 34, 189);
  
}

/* 모달 창을 여는 버튼 스타일 == 개별 카드 스타일과 일치
  해당 코드를 적용시키기 전에는 버튼 영역의 background 컬러가 개별 카드와 따로 노는 듯한 느낌 */
.club-view-individual button {
  background-color: white; 
  border: none;
  padding: 0;
  cursor: pointer;
  transition: background-color 0.5s ease-in-out, color 0.5s ease-in-out;
}

.club-view-individual:hover button{
  background-color: black;
  border: none;
}

/* 움직임 test */
/* .screen-edge-text {
  color: aliceblue;
  position: fixed;
  white-space: nowrap;
  width: max-content; 
  animation: move-around-screen 10s linear infinite;
}
@keyframes move-around-screen {
  0% { top: 0; left: 0; transform: translate(0, 0); }
  25% { top: 0; left: 100%; transform: translate(-100%, 0); } /* 상단 가로 이동 */
 /* 50% { top: 100%; left: 100%; transform: translate(-100%, -100%); } 오른쪽 세로 이동
  75% { top: 100%; left: 0; transform: translate(0, -100%); } /* 하단 가로 이동 */
 /* 100% { top: 0; left: 0; transform: translate(0, 0); } /* 왼쪽 세로 이동 */
 /*} */

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
  width: 10em; /*em은 부모 기준. rem은 root 기준 (html에서 root는 <html>) */
  height: auto;
  max-height: 12em;
  /* height: 12em;
  width: auto; */
}




/**모달 코드입니다(bootstrap) */
.modal {
  position: fixed;
  /* left: 0;
  top: 0; */
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 10;
}

/* .club-view-modal-button button{
  background-color: none;
  border: none;
} */

.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
  max-width: 500px;
}

.modal-close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

/* 모달 닫을 때 */
.modal-close:hover,
.modal-close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
</style>