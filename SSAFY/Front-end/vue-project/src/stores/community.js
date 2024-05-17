import router from '@/router'
import axios from 'axios'
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'


const GENS_API=`http://localhost:8080/newsports/community/posts`

export const useCommunityStore = defineStore('postInfo', () => {

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
      console.log()
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
    return axios.get(`${GENS_API}/${postID}`)
    .then((response) => {
      post.value = response.data
      console.log(post.value)
      console.log(`${GENS_API}/${postID}`)
    })
    .catch((error) => {
      console.error(error)
    })
  }

  // 이거 추가
  const getPostInfo = computed(() => post.value)

  // 게시글 수정

  // const createPost = function(post){
  //   axios({
  //     url: GENS_API,
  //     method: 'POST',
  //     data: post
  //   })
  //   .then(()=> {
  //     router.push({name: 'community'})
  //   })
  //   .catch((err) => {
  //     console.log()
  //     console.log(err)
  //   })
  // }

  const updatePost = function(post){
    axios.put(GENS_API, post)
    .then((response) => {
      console.log(response.data)
      alert('수정되었습니다.')
      router.push({name: 'community'})
    })
    .catch((err) => {
      console.log(err)
    })
  }

  const searchPostList = function(searchCondition) {

    let url=GENS_API
    // 검색어가 있을 때만 검색 기능을 작동시킬 수 있다
    if (searchCondition.key !== 'none' && searchCondition.word) {
      url += `/search`; 
    }

    axios.get(url, {
      params: searchCondition
    })
    .then((response) => {
      postList.value = response.data
      console.log(postList.value)
    })
     .catch((error) => {
    console.error('Error searching posts:', error);
  });
  }


  return { 
    createPost, 
    postList, 
    getPostList, 
    post, 
    getPost, 
    getPostInfo, 
    updatePost,
    searchPostList,
  }



})