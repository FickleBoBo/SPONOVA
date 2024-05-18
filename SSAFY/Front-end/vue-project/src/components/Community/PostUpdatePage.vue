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
                <input type="text" id="writer" readonly v-model="communityStore.post.post.userNickname">
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
import { ref } from 'vue'
import{ useCommunityStore } from '@/stores/community'

const communityStore = useCommunityStore()

const post = ref({
  userID: communityStore.post.post.userID, 
  postID: communityStore.post.post.postID, 
  postTitle: communityStore.post.post.postTitle,
  postContent: communityStore.post.post.postContent,
  postFilePath : null
})

const updatePost = function () {
    communityStore.updatePost(post.value)
}

</script>



<style scoped>

</style>
