<template>
  <div>
      <fieldset>
          <legend>게시글 등록</legend>
          <div>
              <label for="title">제목 : </label>
              <input type="text" id="title" v-model="post.title">
          </div>
          <div>
              <label for="writer">쓰니 : </label>
              <input type="text" id="writer" v-model="post.writer">
          </div>
          <div>
              <label for="content">내용 : </label>
              <textarea id="content" cols="30" rows="10" v-model="post.content"></textarea>
          </div>
          <div>
              <!--createBoard는 메서드 명-->
              <button @click="createPost">등록</button>
          </div>
      </fieldset>
    </div>
</template>




<script setup>
import { useCommunityStore } from '@/stores/community'
import {ref} from 'vue'

const store = useCommunityStore()

const post = ref({
  title: '',
  content: ''
})


const createPost = function () {
  store.createPost(post.value)
}

</script>