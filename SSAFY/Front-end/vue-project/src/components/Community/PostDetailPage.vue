<template>
    <div>
        <h4>게시글 상세</h4>
        <hr>
        <div v-if="communityStore.post.post">
            <div>글쓴이 : {{ communityStore.post.post.userID }}</div>
            <div>제목 : {{ communityStore.post.post.postTitle }}</div>
            <div>내용 : {{ communityStore.post.post.postContent }}</div>
            <div>조회수 : {{ communityStore.post.post.postViewCnt + 1 }}</div>
            <div>추천수 : {{ communityStore.post.post.postLikeCnt }}</div>
            <div>등록일 : {{ communityStore.post.post.postRegDate }}</div>
        </div>
        <hr>
        
            <!-- 아래의 delete/update Board는 메서드명
        (board.js의 메서드가 아닌 현재 컴포넌트의 메서드이다) -->
        <div v-if="isAuthenticated">
            <button @click="updatePost">수정</button>
            <button @click="deletePost">삭제</button>
        </div>

        <div v-for="comment, index in communityStore.post.comments">{{index+1}}번 {{ comment.commentContent }}</div>
        <!-- <div v-if="communityStore.post"> -->

    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user'
import{ useCommunityStore } from '@/stores/community'
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import  {useRouter } from 'vue-router'
import axios from 'axios'

const userStore = useUserStore()
const communityStore = useCommunityStore()
const route = useRoute() // 얘도 import가 필요 // 얘는 상세 페이지 이동 용
const router  = useRouter() // 얘는 삭제 후 페이지 이동용

const isAuthenticated = ref(false)
onMounted(async () => {
    await communityStore.getPost(route.params.id)
    if(userStore.getLoginStatus){
        if(communityStore.getPostInfo){
            if(userStore.getLoginInfo.userID === communityStore.getPostInfo.post.userID){
                isAuthenticated.value = true
            }
        }
    }  
})



const deletePost = function(){
    axios.delete(`http://localhost:8080/newsports/community/posts/${route.params.id}`)
    .then(() => {
        alert('게시글이 삭제 되었습니다.');
        router.push({name: 'community'})
    })
    .catch((err) => {
        console.log(err)
      alert('게시글 삭제 실패');
    })
}

const updatePost = function(){
    router.push({ name: 'PostUpdatePage' })
}


</script>

<style scoped></style>