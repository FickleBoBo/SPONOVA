<template>
  <div class="post-detail-container">
    <div v-if="isDataLoaded" class="post-detail">
      <div class="post-detail-top">
        <h2>{{ communityStore.post.post.postTitle }}</h2>
        <div v-if="isAuthenticated" class="post-actions">
          <button @click="updatePost" class="btn-post-update">수정</button>
          <button @click="deletePost" class="btn-post-delete">삭제</button>
        </div>
      </div>
      <hr>
      <div class="post-meta">
        <div><strong>작성자 | </strong> {{ communityStore.post.post.userNickname }}</div>
        <div><strong>조회수 | </strong> {{ communityStore.post.post.postViewCnt + 1 }}</div>
        <div><strong>작성일 | </strong> {{ formatDate(communityStore.post.post.postRegDate) }}</div>
      </div>
      <hr>

      <div class="post-detail-content">{{ communityStore.post.post.postContent }}</div>

      <hr>
      
      <!-- 댓글 폼 -->
      <form @submit.prevent="createComment(comment.commentContent)" class="comment-form">
        <div><strong>댓글 </strong> ({{ communityStore.post.comments.length }})</div>
        <div class="comment-write">
          <!-- <div class="form-group"> -->
            <!-- <label for="comment">댓글</label> -->
            <input type="text" id="comment" v-model="comment.commentContent" class="form-control">
          <!-- </div> -->
          <div class="form-group">
            <button class="btn-comment-submit">등록</button>
          </div>
        </div>
      </form>

      <!-- 댓글 목록 -->
      <div v-for="comment in communityStore.post.comments" :key="comment.commentID" class="comment">
        <div class="comment-content">
          <span><strong>{{ comment.userNickname }}</strong> | {{ comment.commentContent }}</span>
          <span v-if="userStore.loginInfo.userID === comment.userID"><button @click="deleteComment(comment.commentID)" class="btn-comment-delete">X</button></span>
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
import Swal from 'sweetalert2'

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
    Swal.fire({
      icon: "warning",
      title: "내용을 입력하세요!",
      showConfirmButton: false,
      timer: 1000
    })
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
/* 전체 영역 */
.post-detail-container {
  display: flex;
  padding: 3em 0;
  margin: 10em auto;
  height: 100%;
  justify-content: center;
  border: 1px solid black;
  border-radius: 10%;
  width: 50%;
  
}

/** 제목 */
h2{
  font-weight: 700;
}

/**얘도 전체 */
.post-detail {
  width: 80%;
  max-width: 1000px;
  margin-top: 20px;
}

/*첫번째 밑줄 위 */
.post-detail-top{
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

/* 작성자, 조회수, 작성일 */
.post-meta {
  margin-bottom: 20px;
}

/* 글 내용 영역 */
.post-detail-content{
  min-height: 8em;
}

.post-actions {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  margin-bottom: 20px;
}


.comment-form {
  display: flex;
  flex-direction: column;
  /* align-items: center; */
  /* text-align: center; */
  margin-bottom: 20px;
  width: 100%;
}

.comment {
  margin-bottom: 10px;
}

.comment-content {
  display: flex;
  justify-content: space-between;
}

.comment-write{
  display: flex;
  width: 100%;
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

.btn-post-update, .btn-post-delete{
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  background-color: black;
  color: white;
  border-radius: 10%;
  margin: 0.2em;
}
/* 댓글 등록 버튼 */
.btn-comment-submit{
  background-color: black;
  color: white;
  border-radius: 10%;
  margin: 0.2em;
  padding: 0.4em;
}
.btn:hover {
  background-color: #000000;
}

.form-control {
  width: 100%;
  padding: 8px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
.btn-comment-delete{
  background-color: black;
  color: white;
  width: 2em;
  border-radius: 10%;

}
</style>
