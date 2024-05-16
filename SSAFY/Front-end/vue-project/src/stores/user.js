import router from '@/router'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'


const GENS_API=`http://localhost:8080/newsports/login`

let is_authenticated = false

export const useUserStore = defineStore('userInfo', () => {

  const loginInfo = ref('')
  const loginStatus = ref(false)

  const sendLoginData = function(userID, userPW){
    axios({
      url: GENS_API,
      method: 'POST',
      data: {userID, userPW}
    })
    .then((response)=> {
      console.log(response.data)
      loginInfo.value = response.data
      console.log(loginInfo.value)
      if(loginInfo.value){
        loginStatus.value = true
      }
      router.push({name: 'home'})
    })
    .catch((err) => {
        router.push({name: 'login'})
    })
  }



  return { 
    loginInfo, 
    loginStatus,
    sendLoginData, 
  }
})