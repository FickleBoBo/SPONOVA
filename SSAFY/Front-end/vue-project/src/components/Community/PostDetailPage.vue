<template>
    <div>
        <h4>게시글 상세</h4>
        <hr>
        <div>이거?? {{ communityStore.post }}</div>
        <!-- <div>두번쨰 {{ communityStore.post.post }}</div> -->
        <!-- <div>세번쨰 {{ communityStore.postInfo }}</div> -->
        
        <div v-if="communityStore.post.post">
            <div>{{ communityStore.post.post.userID }}</div>
            <div>{{ communityStore.post.post.postTitle }}</div>
            <div>{{ communityStore.post.post.postContent }}</div>
            <div>{{ communityStore.post.post.postViewCnt }}</div>
            <div>{{ communityStore.post.post.postLikeCnt }}</div>
            <div>{{ communityStore.post.post.postRegDate }}</div>
        </div>

        <div v-for="comment, index in communityStore.post.comments">{{index+1}}번 {{ comment.commentContent }}</div>
        <!-- <div v-if="communityStore.post"> -->


        
        <!-- 아래의 delete/update Board는 메서드명
            (board.js의 메서드가 아닌 현재 컴포넌트의 메서드이다) -->
            <button @click="updatePost">수정</button>
            <button @click="deletePost">삭제</button>
        </div>
</template>

<script setup>
import{useCommunityStore} from '@/stores/community'
import { onMounted } from 'vue'
import {useRoute} from 'vue-router'
import {useRouter} from 'vue-router'
import axios from 'axios'

const communityStore = useCommunityStore()
const route = useRoute() // 얘도 import가 필요 // 얘는 상세 페이지 이동 용
const router  = useRouter() // 얘는 삭제 후 페이지 이동용

onMounted(() => {
    communityStore.getPost(route.params.id)
})



const deletePost = function(){
    axios.delete(`http://localhost:8080/newsports/community/posts/${route.params.id}`)
    .then(() => {
        router.push({name: 'home'})
    })
}

const updatePost = function(){
    router.push({ name: 'postUpdate' })
}


</script>

<style scoped></style>