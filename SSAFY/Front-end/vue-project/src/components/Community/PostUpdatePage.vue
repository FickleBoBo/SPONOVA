<template>
    <div>
        <h4>게시글 수정</h4>
        <fieldset>
            <legend>수정</legend>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="communityStore.post.post.postTitle">
            </div>
            <div>
                <label for="writer">쓰니 : </label>
                <input type="text" id="writer" readonly v-model="communityStore.post.post.userID">
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="communityStore.post.post.postContent"></textarea>
            </div>
            <div>
                <button @click="updatePost">수정</button>
            </div>
        </fieldset>
    </div>
</template>



<script setup>
import { onMounted } from 'vue'
import{ useCommunityStore } from '@/stores/community'
const communityStore = useCommunityStore()

onMounted(() => {
    communityStore.getPostInfo.post
})


const updatePost = function () {
    communityStore.updatePost()
}

</script>



<style scoped>

</style>