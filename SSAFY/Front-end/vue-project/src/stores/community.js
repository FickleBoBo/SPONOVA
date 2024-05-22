import { defineStore } from 'pinia'
import { computed, ref } from 'vue'
import axios from 'axios'
import router from '@/router'
import Swal from 'sweetalert2'



const GENS_API=`http://localhost:8080/newsports/community/posts`

export const useCommunityStore = defineStore('postInfo', () => {

  // 게시글 목록
  const postList = ref([])

  // 게시글
  const post = ref({})

  // 페이지 수
  const pages = computed(() => Math.ceil(postList.value.length / 50))

  // 게시글 등록 (CREATE)
  const createPost = function(post){
    axios({
      url: GENS_API,
      method: 'POST',
      data: post
    })
    .then(() => {
      Swal.fire({
        icon: "success",
        title: "게시글이 등록 되었습니다",
        showConfirmButton: false,
        timer: 1000
      })
      router.push({name: 'community'})
    })
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "게시글 등록에 실패했습니다",
        showConfirmButton: false,
        timer: 1000
      })
    })
  }

  // 게시글 전체 조회 (READ)
  const getPostList = function(){
    axios.get(GENS_API)
    .then((response) =>{
      postList.value = response.data
    })
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "게시글 조회에 실패했습니다",
        showConfirmButton: false,
        timer: 1000
      })
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
      Swal.fire({
        icon: "error",
        title: "게시글 조회에 실패했습니다",
        showConfirmButton: false,
        timer: 1000
      })
    }
  }

  // // 게시글 수정 (UPDATE)
  // const updatePost = function(post){
  //   axios.put(GENS_API, post)
  //   .then(() => {
  //     alert('게시글이 수정 되었습니다.')
  //     router.push({name: 'community'})
  //   })
  //   .catch((err) => {
  //     alert('게시글 수정에 실패했습니다.')
  //     console.log(err)
  //   })
  // }

  // 게시글 수정 (UPDATE)
  const updatePost = function(post){
    Swal.fire({
      title: "정말 수정하시겠습니까?",
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: "Save",
      denyButtonText: `Don't save`
    }).then((result) => {
      if (result.isConfirmed) {
        
        // 여기서 update 로직 수행
        axios.put(GENS_API, post)
        .then(() => {
          Swal.fire({
            icon: "success",
            title: "게시글이 수정 되었습니다",
            showConfirmButton: false,
            timer: 1000
          })
          router.push({name: 'community'})
        })
        .catch((err) => {
          Swal.fire({
            icon: "error",
            title: "게시글 수정에 실패했습니다",
            showConfirmButton: false,
            timer: 1000
          })
        })

      } else if (result.isDenied) {
        Swal.fire({
          icon: "info",
          title: "취소 되었습니다",
          showConfirmButton: false,
          timer: 1000
        })
        router.push({name: 'community'})
      }
    })
  }

  // // 게시글 삭제 (DELETE)
  // const deletePost = function(postID){
  //   axios.delete(`${GENS_API}/${postID}`)
  //   .then(() => {
  //     alert('게시글이 삭제 되었습니다.')
  //     router.push({name: 'community'})
  //   })
  //   .catch((err) => {
  //     alert('게시글 삭제에 실패했습니다.')
  //     console.log(err)
  //   })
  // }

  // 게시글 삭제 (DELETE)
  const deletePost = function(postID){


    Swal.fire({
      title: "정말 삭제하시겠습니까?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
        axios.delete(`${GENS_API}/${postID}`)
        .then(() => {
          Swal.fire({
            icon: "success",
            title: "게시글이 삭제 되었습니다",
            showConfirmButton: false,
            timer: 1000
          })
          router.push({name: 'community'})
        })
        .catch((err) => {
          Swal.fire({
            icon: "error",
            title: "게시글 삭제에 실패했습니다",
            showConfirmButton: false,
            timer: 1000
          })
        })
      }
    })
  }

  // 게시글 검색
  const searchPostList = function(searchCondition) {

    let url=GENS_API+'/search'
    // 검색어가 있을 때만 검색 기능을 작동시킬 수 있다 --> 기본적으로 작동
    // if (searchCondition.key !== 'none' && searchCondition.word) {
    //   url += `/search`
    // }

    axios.get(url, {
      params: searchCondition
    })
    .then((response) => {
      postList.value = response.data
      // console.log(postList.value)  MW가 주석 처리
    })
     .catch((error) => {
      // console.error('Error searching posts:', error)  MW가 주석 처리
      Swal.fire({
        icon: "error",
        title: "게시글 검색에 실패했습니다",
        showConfirmButton: false,
        timer: 1000
      })
    })
  }

  // 댓글 등록 (CREATE)
  const createComment = function(comment, postID){
    axios({
      url: `${GENS_API}/${postID}`,
      method: 'POST',
      data: comment
    })
    .then(() => {
      // Swal.fire({
      //   icon: "success",
      //   title: "댓글이 등록 되었습니다.",
      //   showConfirmButton: false,
      //   timer: 1000
      // })
      router.push({name: 'PostDetailPage', params: { id: postID.toString() }})
      window.location.reload()
    })
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "댓글 등록에 실패했습니다",
        showConfirmButton: false,
        timer: 1000
      })
    })
  }

  // 댓글 삭제
  const deleteComment = function(postID, commentID){
    axios({
      url: `${GENS_API}/${postID}/${commentID}`,
      method: 'DELETE',
      data: commentID
    })
    .then(() => {
      // Swal.fire({
      //   icon: "success",
      //   title: "댓글이 삭제 되었습니다.",
      //   showConfirmButton: false,
      //   timer: 1000
      // })
      router.push({name: 'PostDetailPage', params: { id: postID.toString() }})
      window.location.reload()
    })
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "댓글 삭제에 실패했습니다",
        showConfirmButton: false,
        timer: 1000
      })
    })
  }



  return {
    postList, 
    post, 
    pages, 

    createPost, 
    getPostList, 
    getPost, 
    updatePost, 
    deletePost, 
    searchPostList,

    createComment, 
    deleteComment, 
  }

})
