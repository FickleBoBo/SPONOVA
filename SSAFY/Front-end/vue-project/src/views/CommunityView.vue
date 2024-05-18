<template>
    <div>
        <div>
            <h1>자유 게시판</h1>
            <hr>
            <PostSearchInput/>
        </div>
        <table>
            <tr>
                <th>게시물 번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>등록일</th>
            </tr>
            <tr v-for="post in communityStore.postList" :key="post.postID">
                <td>{{ post.postID }}</td>
                <td><RouterLink :to="{name: 'PostDetailPage', params: { 'id': post.postID} }">{{ post.postTitle }}</RouterLink></td>
                <td>{{ post.userNickname }}</td>
                <td>{{ post.postViewCnt }}</td>
                <td v-if="todayPosted(post.postRegDate)">{{ post.postRegDate.slice(0, 10) }}</td>
                <td v-else>{{ post.postRegDate.slice(11, 19) }}</td>
            </tr>
        </table>
  
        <RouterLink :to="{name: 'PostCreatePage'}">글쓰기</RouterLink>

    </div>
</template>



<script setup>

import PostSearchInput from '@/components/Community/PostSearchInput.vue'
import { useCommunityStore } from '@/stores/community'
import{ onBeforeMount } from 'vue'

const communityStore = useCommunityStore()

// 게시물 등록일이 오늘이면 등록 시간을 표시하고, 이전이면 등록일을 표시하는 함수
const todayPosted = ((regDate) => {
    var today = new Date()
    var year = today.getFullYear().toString()
    var month = (today.getMonth() + 1).toString().padStart(2, '0')
    var day = today.getDate().toString().padStart(2, '0')
    var todayString = year + '-' + month + '-' + day
    if(regDate.slice(0, 10) === todayString){
        return false
    }
    else{
        return true
    }
})

onBeforeMount(() => {
    communityStore.getPostList()
})

</script>



<style scoped>

</style>
