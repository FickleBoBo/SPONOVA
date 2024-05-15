import router from '@/router'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'


const GENS_API=`http://localhost:8080/newsports/community/posts`

export const useCommunityStore = defineStore('post', () => {

  const createPost = function(post){
    axios({
      url: GENS_API,
      method: 'POST',
      data: post
    })
    .then(()=> {
      router.push({name: 'community'})
    })
    .catch((err) => {
      console.log(err)
    })
  }

  const postList = ref([])
  const getPostList = function(){
    axios.get(GENS_API)
    .then((response) =>{
      postList.value = response.data
    })
  }

  const post = ref({})
  const getPost = function(postID){
    axios.get(`${GENS_API}/${postID}`)
    .then((response) => {
      post.value = response.data
      console.log(post.value)
      console.log(`${GENS_API}/${postID}`)
    })
  }

  const updatePost = function(searchCondition){
    axios.put(GENS_API, post.value)
    .then(() => {
      router.push({name: 'community'})
    })
  }


  return { createPost, postList, getPostList, post, getPost, updatePost}



})