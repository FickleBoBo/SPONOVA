<template>
    <div>
        <h4>게시글 수정</h4>
        <fieldset>
            <legend>수정</legend>
            <div>
                <label for="title">제목 : </label>
                <!-- <input type="text" id="title" v-model="communityStore.post.post.postTitle"> -->
                <input type="text" id="title" v-model="post.postTitle">
            </div>
            <div>
                <label for="writer">쓰니 : </label>
                <input type="text" id="writer" readonly v-model="communityStore.post.post.userID">
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="post.postContent"></textarea>
            </div>
            <div>
                <button @click="updatePost">수정</button>
            </div>
        </fieldset>
    </div>
</template>



<script setup>
import { ref, onMounted } from 'vue'
import{ useCommunityStore } from '@/stores/community'
const communityStore = useCommunityStore()

onMounted(() => {
    communityStore.getPostInfo.post
})


const post = ref({
  userID: communityStore.getPostInfo.post.userID, 
  postID: communityStore.getPostInfo.post.postID, 
  postTitle: communityStore.getPostInfo.post.postTitle,
  postContent: communityStore.getPostInfo.post.postContent,
  postFilePath : null
})

const updatePost = function () {
    communityStore.updatePost(post.value)
}

</script>



<style scoped>

</style>