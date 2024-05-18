<template>
    <div>
        <div v-if="isDataLoaded">
            <h4>{{ communityStore.post.post.postTitle }}</h4>
            <hr>
                <div>작성자 : {{ communityStore.post.post.userNickname }}</div>
                <div>내용 : {{ communityStore.post.post.postContent }}</div>
                <div>조회수 : {{ communityStore.post.post.postViewCnt + 1 }}</div>
                <div>추천수 : {{ communityStore.post.post.postLikeCnt }}</div>
                <div>등록일 : {{ communityStore.post.post.postRegDate.slice(0, 10) }} {{ communityStore.post.post.postRegDate.slice(11, 19) }}</div>
            <hr>
            
            <div v-if="isAuthenticated">
                <button @click="updatePost">수정</button>
                <button @click="deletePost">삭제</button>
            </div>

            <div v-for="comment, index in communityStore.post.comments">{{index+1}}번 {{ comment.commentContent }}</div>
        </div>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user'
import{ useCommunityStore } from '@/stores/community'
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()
const userStore = useUserStore()
const communityStore = useCommunityStore()

// 작성자와 로그인한 유저가 동일인이면 true, 아니면 false
const isAuthenticated = ref(false)

// 데이터가 로딩되면 게시글 상세페이지를 보여주도록 설정 (이전에 렌더링 된 값이 잠깐 보이는 문제 해결)
const isDataLoaded = ref(false)

const updatePost = function(){
    router.push({ name: 'PostUpdatePage' })
}

const deletePost = function(){
    communityStore.deletePost(route.params.id)
}

onMounted(async () => {
    await communityStore.getPost(route.params.id)

    if(userStore.getLoginStatus){
        if(userStore.getLoginInfo.userID === communityStore.post.post.userID){
            isAuthenticated.value = true
        }
    }

    isDataLoaded.value = true
})

</script>



<style scoped>

</style>
