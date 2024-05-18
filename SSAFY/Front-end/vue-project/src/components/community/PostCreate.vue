<template>
  <div>
      <fieldset>
          <legend>게시글 등록</legend>
          <div>
              <label for="title">제목 : </label>
              <input type="text" id="title" v-model="post.postTitle">
          </div>
          <div>
              <label for="writer">쓰니 : </label>
              <input type="text" id="writer" readonly v-model="post.userNickname">
          </div>
          <div>
              <label for="content">내용 : </label>
              <textarea id="content" cols="30" rows="10" v-model="post.postContent"></textarea>
          </div>
          <div>
              <!--createBoard는 메서드 명-->
              <button @click="createPost">등록</button>
          </div>
      </fieldset>
    </div>
</template>



<script setup>
import { useUserStore } from '@/stores/user';
import { useCommunityStore } from '@/stores/community'
import {ref} from 'vue'

const userStore = useUserStore()
const communityStore = useCommunityStore()

const post = ref({
  postTitle: '',
  userID: userStore.loginInfo.userID,
  userNickname : userStore.loginInfo.userNickname, 
  postContent: ''
})

const createPost = function () {
  // const postData = {
  //   postTitle: post.postTitle,
  //   postContent: post.postContent
  // }
  communityStore.createPost(post.value)
}

</script>