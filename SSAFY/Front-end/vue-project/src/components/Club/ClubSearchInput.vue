<template>
  <div class="club-search">
      <div>
          <!-- <label>종목을 검색하세요: </label> -->
          <input type="text" v-model="searchInfo.word" placeholder="종목을 검색하세요"/>
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

</script>

<style scoped>
.club-search {
  display: flex;
  flex-direction: row;
  margin: 1em;
}

input[type="text"] {
  /* width: 100%;  */
  padding-left: 0.8em;
  padding-right: 0.8em;
  margin-bottom: 1em;
  text-align: center;
}

button {
  background-color: black;
  color: white;
  border-radius: 5%;
}

label, input, button{
  margin-right: 0.2em;
}
</style>
