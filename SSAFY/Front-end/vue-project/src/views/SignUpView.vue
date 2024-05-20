<template>
    <div class="container">
      <form @submit.prevent="createUser" class="form">
        <div class="form-group">
          <label for="id">ID:</label>
          <input id="id" type="text" name="userID" v-model="userID" maxlength="30" required>
        </div>
        <div class="form-group">
          <label for="pw">Password:</label>
          <input id="pw" type="password" name="userPW" v-model="userPW" maxlength="20" required>
        </div>
        <div class="form-group">
          <label for="name">Name:</label>
          <input id="name" type="text" name="username" v-model="username" maxlength="20" required>
        </div>
        <div class="form-group">
          <label for="nickName">Nickname:</label>
          <input id="nickName" type="text" name="userNickname" v-model="userNickname" maxlength="10" required>
        </div>
        <div class="form-group">
          <label for="RRN1">RRN:</label>
          <div class="rrn-inputs">
            <input id="RRN1" type="text" name="userRRN1" v-model="userRRN1" maxlength="6" required>
            <span>-</span>
            <input id="RRN2" type="text" name="userRRN2" v-model="userRRN2" maxlength="7" required>
          </div>
        </div>
        <div class="form-group">
          <label for="phoneNumber">Phone Number:</label>
          <div class="phone-inputs">
            <input id="phoneNumber1" type="text" name="userPhonenumber1" v-model="userPhonenumber1" maxlength="3" required>
            <span>-</span>
            <input id="phoneNumber2" type="text" name="userPhonenumber2" v-model="userPhonenumber2" maxlength="4" required>
            <span>-</span>
            <input id="phoneNumber3" type="text" name="userPhonenumber3" v-model="userPhonenumber3" maxlength="4" required>
          </div>
        </div>
        <div class="form-group">
          <button>Submit</button>
        </div>
      </form>
    </div>
  </template>



<script setup>
import { ref } from 'vue';
import axios from 'axios'
import router from '@/router'

const userID = ref('')
const userPW = ref('')
const username = ref('')
const userNickname = ref('')
const userRRN1 = ref('')
const userRRN2 = ref('')
const userPhonenumber1 = ref('')
const userPhonenumber2 = ref('')
const userPhonenumber3 = ref('')



const createUser = function(){
    console.log(userRRN1.value + '-' + userRRN2.value.substring(0, 1))
    const data = {
        userID: userID.value,
        userPW: userPW.value,
        username: username.value,
        userNickname: userNickname.value, 
        userRRN: userRRN1.value + '-' + userRRN2.value.substring(0, 1),
        userPhonenumber: userPhonenumber1.value + '-' + userPhonenumber2.value + '-' + userPhonenumber3.value
    }

    if(isNaN(parseInt(userRRN1.value)) || isNaN(parseInt(userRRN2.value)) || userRRN1.value.length!=6 || userRRN2.value.length!=7){
        alert("잘못된 주민등록번호 입니다.")
        window.location.reload()
    }
    else if(isNaN(parseInt(userPhonenumber1.value)) || isNaN(parseInt(userPhonenumber2.value)) || isNaN(parseInt(userPhonenumber3.value)) || 
        (userPhonenumber1.value.length!=3) || (userPhonenumber2.value.length!=4) || (userPhonenumber3.value.length!=4)){
        alert("잘못된 핸드폰번호 입니다.")
        window.location.reload()
    }

    const url = "http://localhost:8080/newsports/signup"
    axios({
        url: url,
        method: 'POST',
        data: data,
    })
    .then((response)=> {
        router.push({name: 'login'})
    })
    .catch((err)=> {
        if(err.response.data === 'DuplicatedID'){
            alert("이미 가입된 아이디입니다.")
        }
        if(err.response.data === 'DuplicatedPhonenumber'){
            alert("이미 등록된 전화번호입니다.")
        }
        if(err.response.data === 'DuplicatedNickname'){
            alert("이미 존재하는 닉네임입니다.")
        }
    })
}

</script>



<style scoped>

/* CSS */
.container {
    max-width: 400px; /* 폼의 최대 너비 설정 */
    margin: 0 auto; /* 가운데 정렬 */
}

.form {
    display: flex;
    flex-direction: column;
    align-items: flex-start; /* 왼쪽 정렬 */
}

.form-group {
    margin-bottom: 15px; /* 각 그룹 아래 간격 */
}

.label {
    font-weight: bold;
    margin-right: 10px; /* 라벨과 인풋 필드 사이 간격 */
}

.input-field {
    flex: 1; /* 나머지 공간을 인풋 필드가 채우도록 설정 */
    padding: 8px; /* 내부 여백 */
    border: 1px solid #ccc; /* 테두리 스타일 */
    border-radius: 4px; /* 테두리 둥글게 */
    box-sizing: border-box; /* 내부 여백을 포함한 전체 너비 설정 */
}

/* RRN, PhoneNumber 입력 폼의 레이아웃 설정 */
.rrn-inputs,
.phone-inputs {
    display: flex;
    align-items: center;
}

.rrn-inputs input,
.phone-inputs input {
    flex: 1; /* 동일한 너비의 입력 필드 */
}

/* Submit 버튼 스타일링 */
button {
    padding: 10px 20px; /* 버튼 내부 여백 */
    background-color: #4CAF50; /* 배경색 */
    color: white; /* 글자색 */
    border: none; /* 테두리 없음 */
    border-radius: 4px; /* 둥글게 */
    cursor: pointer; /* 커서 모양 변경 */
}

button:hover {
    background-color: #45a049; /* 호버 시 배경색 변경 */
}



</style>