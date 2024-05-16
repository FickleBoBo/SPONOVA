<template>
  <div class="search">
      <!-- <div>
          <label>검색 기준 :</label>
          <select v-model="searchInfo.key">
              <option value='none'>없음</option>
              <option value="title">제목</option>
          </select>
      </div> -->
      <div>
          <label>제목을 검색하세요 : </label>
          <input type="text" v-model="searchInfo.word" />
      </div>
      <div>
          <label>정렬 기준 :</label>
          <select v-model="searchInfo.orderBy">
              <option value='none'>없음</option>
              <option value="postViewCnt">조회수</option>
          </select>
      </div>
      <div>
          <label>정렬 방향 :</label>
          <select v-model="searchInfo.orderByDir">
              <option value="asc">오름차순</option>
              <option value="desc">내림차순</option>
          </select>
      </div>
      <div>
          <button @click="searchPostList"> 검색 </button>
      </div>
  </div>
</template>

<script setup>

import {useCommunityStore} from '@/stores/community'
import {ref} from 'vue'

const searchInfo = ref({
  key: 'postTitle', // title일까 postTitle일까 -> postTitle이었다
  word: '', 
  orderBy: 'postViewCnt',
  orderByDir: 'asc'
})

const communityStore = useCommunityStore()
const searchPostList = function(){
  communityStore.searchPostList(searchInfo.value)
}

</script>

<style scoped>
.search {
  display: flex;
}
</style>
