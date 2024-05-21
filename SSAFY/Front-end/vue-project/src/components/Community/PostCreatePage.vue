<template>
  <div class="post-form-container">
    <div class="post-form">
      <fieldset>
        <legend>게시글 등록</legend>
        <div class="form-group">
          <label for="title">제목</label>
          <input type="text" id="title" v-model="post.postTitle" class="form-control">
        </div>
        <div class="form-group">
          <label for="writer">작성자</label>
          <input type="text" id="writer" readonly v-model="post.userNickname" class="form-control">
        </div>
        <div class="form-group">
          <label for="content">내용</label>
          <textarea id="content" cols="30" rows="10" v-model="post.postContent" class="form-control"></textarea>
        </div>
        <div class="form-group button-group">
          <!-- <button @click="createPost(post.postTitle, post.postContent)" class="btn btn-primary">등록</button> -->
          <button @click="createPost(post.postTitle, post.postContent)">등록</button>
        </div>
      </fieldset>
    </div>
  </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user';
import { useCommunityStore } from '@/stores/community'
import { ref } from 'vue'

const userStore = useUserStore()
const communityStore = useCommunityStore()

const post = ref({
  postTitle: '',
  userID: userStore.loginInfo.userID,
  userNickname : userStore.loginInfo.userNickname, 
  postContent: ''
})

const createPost = function (title, content) {
  if(title && content){
    communityStore.createPost(post.value)
  }
  else if(!title){
    alert("제목을 입력하세요.")
  }
  else if(!content){
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
  background-color: #007bff;
}
</style>
