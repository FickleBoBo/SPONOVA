<template>
    <div class="post-detail-container">
      <div v-if="isDataLoaded" class="post-detail">
        <h2>{{ communityStore.post.post.postTitle }}</h2>
        <hr>
        <div class="post-meta">
          <div><strong>작성자:</strong> {{ communityStore.post.post.userNickname }}</div>
          <div><strong>내용:</strong> {{ communityStore.post.post.postContent }}</div>
          <div><strong>조회수:</strong> {{ communityStore.post.post.postViewCnt + 1 }}</div>
          <div><strong>추천수:</strong> {{ communityStore.post.post.postLikeCnt }}</div>
          <div><strong>등록일:</strong> {{ formatDate(communityStore.post.post.postRegDate) }}</div>
        </div>
        <hr>
  
        <div v-if="isAuthenticated" class="post-actions">
          <button @click="updatePost" class="btn">수정</button>
          <button @click="deletePost" class="btn">삭제</button>
        </div>
        <hr>
  
        <!-- 댓글 폼 -->
        <form @submit.prevent="createComment(comment.commentContent)" class="comment-form">
          <div class="form-group">
            <label for="comment">댓글:</label>
            <input type="text" id="comment" v-model="comment.commentContent" class="form-control">
          </div>
          <div class="form-group">
            <button class="btn">등록</button>
          </div>
        </form>
  
        <!-- 댓글 목록 -->
        <div v-for="comment in communityStore.post.comments" :key="comment.commentID" class="comment">
          <div class="comment-content">
            <span><strong>{{ comment.userNickname }}</strong> | {{ comment.commentContent }}</span>
            <span v-if="userStore.loginInfo.userID === comment.userID"><button @click="deleteComment(comment.commentID)" class="btn">삭제</button></span>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useUserStore } from '@/stores/user'
  import { useCommunityStore } from '@/stores/community'
  import { ref, onMounted } from 'vue'
  import { useRoute, useRouter } from 'vue-router'
  
  const route = useRoute()
  const router = useRouter()
  const userStore = useUserStore()
  const communityStore = useCommunityStore()
  
  const isAuthenticated = ref(false)
  const isDataLoaded = ref(false)
  
  const updatePost = function () {
    router.push({ name: 'PostUpdatePage' })
  }
  
  const deletePost = function () {
    communityStore.deletePost(route.params.id)
  }
  
  const comment = ref({
    userID: userStore.loginInfo.userID,
    userNickname: userStore.loginInfo.userNickname,
    postID: parseInt(route.params.id),
    commentContent: ''
  })
  
  const createComment = function (content) {
    if(content){
        communityStore.createComment(comment.value, route.params.id)
    }
    else{
        alert("내용을 입력하세요.")
    }
  }
  
  const deleteComment = function (commentID) {
    communityStore.deleteComment(route.params.id, parseInt(commentID))
  }
  
  const formatDate = (dateString) => {
    const date = new Date(dateString)
    return `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}:${date.getSeconds().toString().padStart(2, '0')}`
  }
  
  onMounted(async () => {
    await communityStore.getPost(route.params.id)
  
    if (userStore.getLoginStatus) {
      if (userStore.getLoginInfo.userID === communityStore.post.post.userID) {
        isAuthenticated.value = true
      }
    }
  
    isDataLoaded.value = true
  })
  </script>
  
  <style scoped>
  .post-detail-container {
    display: flex;
    justify-content: center;
  }
  
  .post-detail {
    width: 80%;
    max-width: 1000px;
    margin-top: 20px;
  }
  
  .post-meta {
    margin-bottom: 20px;
  }
  
  .post-actions {
    margin-bottom: 20px;
  }
  
  .comment-form {
    margin-bottom: 20px;
  }
  
  .comment {
    margin-bottom: 10px;
  }
  
  .comment-content {
    display: flex;
    justify-content: space-between;
  }
  
  .btn {
    padding: 8px 16px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .btn:hover {
    background-color: #0056b3;
  }
  
  .form-control {
    width: 100%;
    padding: 8px;
    border-radius: 5px;
    border: 1px solid #ccc;
  }
  </style>
  