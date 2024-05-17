<template>
    <div>
        <h4>커뮤니티 메인 페이지</h4>
        <hr>
        <PostSearchInput/>
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>조회수</th>
                <th>등록일</th>
            </tr>
            <tr v-for="post in communityStore.postList" :key="post.postID">
                <td>{{ post.postID }}</td>
                <!-- <td>{{ post.postTitle }}</td> -->
                <td><RouterLink :to="{name: 'PostDetailPage', params: { 'id': post.postID} }">{{ post.postTitle }}</RouterLink></td>
                <td>{{ post.userID }}</td>
                <td>{{ post.postViewCnt }}</td>
                <td>{{ post.postRegDate.slice(0, 10) }}</td>
            </tr>
        </table>
  
        <RouterLink :to="{name: 'PostCreate'}">글쓰기</RouterLink>

    </div>
</template>



<script setup>

import PostSearchInput from '@/components/Community/PostSearchInput.vue'
import { useCommunityStore } from '@/stores/community'
import{ onMounted } from 'vue'

const communityStore = useCommunityStore()

onMounted(() => {
    communityStore.getPostList()
})

</script>



<style scoped>

</style>
