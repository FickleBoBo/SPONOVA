<template>
    <div>
        <h4>게시글 상세</h4>
        <hr>
        <!-- {{ 인스턴스.객체.속성 }} -->
        <!-- <div>외않되</div>
        <div>{{ $route.params.id }}</div>
       
        <div>{{ post }}</div>
        <div>{{ store.post.userID }}</div>
        <div>{{ store.post.postTitle }}</div>
        <div>{{ store.post.postContent }}</div>
        <div>{{ store.post.postViewCnt }}</div>
        <div>{{ store.post.postLikeCnt }}</div>
        <div>{{ store.post.postRegDate }}</div> -->


    </div>

    <div>
    <h4>게시글 상세</h4>
    <hr>
    <div v-if="store.post.post">
      <div>{{ store.post.post.userID }}</div>
      <div>{{ store.post.post.postTitle }}</div>
      <div>{{ store.post.post.postContent }}</div>
      <div>{{ store.post.post.postViewCnt }}</div>
      <div>{{ store.post.post.postLikeCnt }}</div>
      <div>{{ store.post.post.postRegDate }}</div>
    </div>
    <div v-else>
      Loading...
    </div>
  </div>

        <!-- 아래의 delete/update Board는 메서드명
            (board.js의 메서드가 아닌 현재 컴포넌트의 메서드이다) -->
    <button @click="updatePost">수정</button>
    <button @click="deletePost">삭제</button>
</template>

<script setup>
import{useCommunityStore} from '@/stores/community'
import { onMounted, watch, ref } from 'vue'
import {useRoute} from 'vue-router'
import {useRouter} from 'vue-router'
import axios from 'axios'

const store = useCommunityStore()

const route = useRoute() // 얘도 import가 필요 // 얘는 상세 페이지 이동 용
const router  = useRouter() // 얘는 삭제 후 페이지 이동용

onMounted(() => {
    store.getPost(route.params.id)
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