import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'
import router from '@/router'



const GENS_API=`http://localhost:8080/newsports/community/posts`

export const useCommunityStore = defineStore('postInfo', () => {

  // 게시글 목록
  const postList = ref([])

  // 게시글
  const post = ref({})



  // 게시글 등록 (CREATE)
  const createPost = function(post){
    axios({
      url: GENS_API,
      method: 'POST',
      data: post
    })
    .then(()=> {
      alert('게시글이 등록 되었습니다.')
      router.push({name: 'community'})
    })
    .catch((err) => {
      alert('게시글 등록에 실패했습니다.')
      console.log(err)
    })
  }

  // 게시글 전체 조회 (READ)
  const getPostList = function(){
    axios.get(GENS_API)
    .then((response) =>{
      postList.value = response.data
    })
    .catch((err) => {
      console.error(err)
    })
  }

//  // 게시글 상세 조회 (READ)
//  const getPost = function(postID){
//    axios.get(`${GENS_API}/${postID}`)
//    .then((response) => {
//      post.value = response.data
//    })
//    .catch((err) => {
//      console.error(err)
//    })
//  }

  // 게시글 상세 조회 (READ)
  const getPost = async function(postID){
    try {
      const response = await axios.get(`${GENS_API}/${postID}`)
      post.value = response.data
    } catch (err) {
      console.error(err)
    }
  }

  // 게시글 수정 (UPDATE)
  const updatePost = function(post){
    axios.put(GENS_API, post)
    .then(() => {
      alert('게시글이 수정 되었습니다.')
      router.push({name: 'community'})
    })
    .catch((err) => {
      alert('게시글 수정에 실패했습니다.')
      console.log(err)
    })
  }

  // 게시글 삭제 (DELETE)
  const deletePost = function(postID){
    axios.delete(`${GENS_API}/${postID}`)
    .then(() => {
      alert('게시글이 삭제 되었습니다.')
      router.push({name: 'community'})
    })
    .catch((err) => {
      alert('게시글 삭제에 실패했습니다.')
      console.log(err)
    })
  }

  // 게시글 검색
  const searchPostList = function(searchCondition) {

    let url=GENS_API
    // 검색어가 있을 때만 검색 기능을 작동시킬 수 있다
    if (searchCondition.key !== 'none' && searchCondition.word) {
      url += `/search`
    }

    axios.get(url, {
      params: searchCondition
    })
    .then((response) => {
      postList.value = response.data
      console.log(postList.value)
    })
     .catch((error) => {
      console.error('Error searching posts:', error)
    })
  }


  return {
    postList, 
    post, 

    createPost, 
    getPostList, 
    getPost, 
    updatePost, 
    deletePost, 
    searchPostList,
  }

})