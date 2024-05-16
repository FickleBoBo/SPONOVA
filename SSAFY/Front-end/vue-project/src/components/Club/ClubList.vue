<template>
  <div>
  <div>
    <h3>Club List</h3>
  </div>

  <div v-for="club in store.clubList" :key="club.clubID">
    {{ club.clubID }}
    {{ club.gameID}}
    {{ club.clubContent }}
    {{ club.clubLogoPath }}
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
</style>