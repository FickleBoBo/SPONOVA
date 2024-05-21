<template>
    <div class="post-form-container">
        <div class="post-form">
            <h3>게시글 수정</h3>
            <fieldset>
                <legend>수정</legend>
                <div class="form-group">
                    <label for="title">제목 : </label>
                    <input type="text" id="title" v-model="post.postTitle" class="form-control">
                </div>
                <div class="form-group">
                    <label for="writer">글쓴이 : </label>
                    <input type="text" id="writer" readonly v-model="communityStore.post.post.userNickname" class="form-control">
                </div>
                <div class="form-group">
                    <label for="content">내용 : </label>
                    <textarea id="content" cols="30" rows="10" v-model="post.postContent" class="form-control"></textarea>
                </div>
                <div class="form-group button-group">
                    <button @click="updatePost(post.postTitle, post.postContent)" class="btn btn-primary">수정</button>
                </div>
            </fieldset>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useCommunityStore } from '@/stores/community'

const communityStore = useCommunityStore()

const post = ref({
    userID: communityStore.post.post.userID,
    postID: communityStore.post.post.postID,
    postTitle: communityStore.post.post.postTitle,
    postContent: communityStore.post.post.postContent,
    postFilePath: null
})

const updatePost = function (title, content) {
    if (title && content) {
        communityStore.updatePost(post.value)
    } else if (!title) {
        alert("제목을 입력하세요.")
    } else if (!content) {
        alert("내용을 입력하세요.")
    }
}
</script>

<style scoped>
.post-form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* 화면 전체 높이를 차지하도록 설정 */
}

.post-form {
    width: 80%; /* 폼의 가로 너비를 조정합니다. */
}

fieldset {
    border: 1px solid #ccc;
    border-radius: 10px;
    padding: 20px;
}

legend {
    font-size: 1.5rem;
    font-weight: bold;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

.button-group {
  text-align: right;
}

label {
    display: block;
    font-size: 1.1rem;
    margin-bottom: 5px;
}

input[type="text"],
textarea {
    width: 100%;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

button {
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    background-color: #000000;
    color: white;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #000000;
}
</style>
