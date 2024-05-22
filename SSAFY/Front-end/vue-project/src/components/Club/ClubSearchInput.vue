<template>
  <div class="club-search">
      <div>
          <!-- <label>종목을 검색하세요: </label> -->
          <input type="text" v-model="searchInfo.word" placeholder="종목을 검색하세요" @keydown.enter.prevent="handleEnter"/>
          <button @click="searchClubList"> 검색 </button>
      </div>
  </div>
</template>

<script setup>

import {useClubStore} from '@/stores/club'
import {ref} from 'vue'

const searchInfo = ref({
  key: 'gameID',
  word: '', 
})

const clubStore = useClubStore()
const searchClubList = function(){
  clubStore.searchClubList(searchInfo.value)
}

// 검색어를 입력하고 엔터를 누르면 버튼을 누른 것과 동일한 이벤트 수행
const handleEnter = () => {
  searchClubList()
}

</script>

<style scoped>
.club-search {
  display: flex;
  flex-direction: row;
  margin: 1.5em;
}

input[type="text"] {
  /* width: 100%;  */
  padding-left: 2em;
  padding-right: 2em;
  padding-top: 1em;
  padding-bottom: 1em;
  margin-bottom: 1em;
  margin-right: 1em;
  text-align: center;
}

button {
  background-color: rgb(255, 255, 255);
  border: none;
  color: rgb(0, 0, 0);
  border-radius: 5%;
  padding: 1em;
  transition: 1s ease;
}
button:hover{
  background-color: rgb(255, 34, 189);
}

label, input, button{
  margin-right: 0.2em;
}
</style>
