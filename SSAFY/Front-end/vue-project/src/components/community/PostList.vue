<template>
  <div>
      <h4>커뮤니티 메인 페이지</h4>
      <hr>
      <table>
          <tr>
              <th>번호</th>
              <th>제목</th>
              <th>user</th>
              <th>조회수</th>
              <th>등록일</th>
          </tr>
          <tr v-for="post in store.postList" :key="post.postID">
              <td>{{ post.postID }}</td>
              <td>{{ post.postTitle }}</td>
              <td>{{ post.userID }}</td>
              <td>{{ post.postViewCnt }}</td>
              <td>{{ post.postRegDate }}</td>
          </tr>
      </table>

      <BoardSearchInput/>
  </div>
</template>





<script setup>

import { useCommunityStore } from '@/stores/community'
import{onMounted} from 'vue'

const store = useCommunityStore()

onMounted(() => {
  store.getPostList()
})

</script>





<style scoped>
</style>