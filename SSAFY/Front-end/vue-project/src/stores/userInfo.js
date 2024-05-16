import router from '@/router'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'


const GENS_API=`http://localhost:8080/newsports/login`

export const userInfoStore = defineStore('userInfo', () => {

  const loginInfo = ref('')
  const login = ref(false)

  const sendLoginData = function(userID, userPW){
    axios({
      url: GENS_API,
      method: 'POST',
      data: {userID, userPW}
    })
    .then((response)=> {
      console.log(response.data)
      loginInfo.value = response.data
      if(loginInfo.value){
        login.value = true
      }
      router.push({name: 'home'})
    })
    .catch((err) => {
        router.push({name: 'login'})
    })
  }



  return { loginInfo, sendLoginData, login }



})