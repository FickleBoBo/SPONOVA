<template>
  <div>
      <h4>커뮤니티 메인 페이지</h4>
      <hr>
      <PostSearchInput/>
      <table>
          <tr>
              <th>번호</th>
              <th>제목</th>
              <th>user</th>
              <th>조회수</th>
              <th>등록일</th>
          </tr>
          <tr v-for="post in communityStore.postList" :key="post.postID">
              <td>{{ post.postID }}</td>
              <!-- <td>{{ post.postTitle }}</td> -->
              <td><RouterLink :to="{name: 'PostDetailPage', params: { id: post.postID} }">{{ post.postTitle }}</RouterLink></td>
              <td>{{ post.userID }}</td>
              <td>{{ post.postViewCnt }}</td>
              <td>{{ post.postRegDate }}</td>
          </tr>
      </table>

      <RouterLink :to="{name: 'PostCreate'}">글쓰기</RouterLink>

      <!-- 나중에 구현할 검색 기능 -->
      
    <RouterView />
  </div>
</template>





<script setup>

import { useCommunityStore } from '@/stores/community'
import{onMounted} from 'vue'
import PostSearchInput from './PostSearchInput.vue'

const communityStore = useCommunityStore()

onMounted(() => {
  communityStore.getPostList()
})

import PostCreate from '@/components/Community/PostCreate.vue'
import PostDetailPage from '@/components/Community/PostDetailPage.vue'

</script>





<style scoped>
</style>