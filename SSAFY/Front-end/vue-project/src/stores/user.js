import { defineStore } from 'pinia'
import { computed, ref } from 'vue'
import axios from 'axios'
import router from '@/router'
import Swal from 'sweetalert2'



const GENS_API=`http://localhost:8080/newsports/login`

export const useUserStore = defineStore('userInfo', () => {

  // loginInfo : user의 정보를 저장하는 변수
  // loginStatus : 로그인 여부를 저장하는 변수
  const loginInfo = ref('')
  const loginStatus = ref(false)

  const getLoginInfo = computed(() => loginInfo.value)
  const getLoginStatus = computed(() => loginStatus.value)

  // 로그인 성공 시 local stoage에 아이디, 패스워드 저장하고 home으로 보내줌
  const sendLoginData = function(userID, userPW){
    axios({
      url: GENS_API,
      method: 'POST',
      data: { userID, userPW }
    })
    .then((response) => {
      loginInfo.value = response.data
      if(loginInfo.value){
        loginStatus.value = true
      }

      Swal.fire({
        icon: "success",
        title: `${loginInfo.value.userNickname} 님 반갑습니다!`,
        showConfirmButton: false,
        timer: 1500
      })
      router.push({name: 'home'})
    })
    .catch((err) => {

      Swal.fire({
        icon: "error",
        title: "로그인에 실패했습니다",
        text: "다시 시도해주세요", 
        showConfirmButton: false,
        timer: 1500
      })
    })
  }

  // 로그아웃하면 데이터 삭제
  const clearData = (() => {
    loginInfo.value = ''
    loginStatus.value = false
  })

  return { 
    loginInfo, 
    loginStatus,
    getLoginInfo, 
    getLoginStatus, 
    sendLoginData, 
    clearData
  }

}, { persist: true }
)