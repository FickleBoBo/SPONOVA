<template>
    <div class="container">
      <h1>Sign Up</h1>
      <form @submit.prevent="createUser" class="signup-form">
        <div class="form-group id-form">
          <label for="id">ID</label><br>
          <input id="id" type="text" name="userID" v-model="userID" maxlength="30" required>
        </div>
        <div class="form-group">
          <label for="pw">Password</label><br>
          <input id="pw" type="password" name="userPW" v-model="userPW" maxlength="20" required>
        </div>
        <div class="form-group">
          <label for="name">Name</label><br>
          <input id="name" type="text" name="username" v-model="username" maxlength="20" required>
        </div>
        <div class="form-group">
          <label for="nickName">Nickname</label><br>
          <input id="nickName" type="text" name="userNickname" v-model="userNickname" maxlength="10" required>
        </div>
        <div class="form-group">
          <label for="RRN1">RRN (주민등록번호 7자리)</label>
          <div class="rrn-inputs">
            <input id="RRN1" type="text" name="userRRN1" v-model="userRRN1" maxlength="6" required>
            <span>-</span>
            <input id="RRN2" type="text" name="userRRN2" maxlength="7" required :value="maskedRRN2" @input="handleRRN2Input">
          </div>
        </div>
        <div class="form-group">
          <label for="phoneNumber">Phone Number</label>
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
import { ref, computed } from 'vue';
import axios from 'axios'
import router from '@/router'
import Swal from 'sweetalert2'

const userID = ref('')
const userPW = ref('')
const username = ref('')
const userNickname = ref('')
const userRRN1 = ref('')
const userRRN2 = ref('')
const userPhonenumber1 = ref('')
const userPhonenumber2 = ref('')
const userPhonenumber3 = ref('')

// 아래 두 메서드는 주민등록번호 뒷자리 * 처리하는 역할
// Method to handle input and update userRRN2
const handleRRN2Input = (event) => {
  const value = event.target.value;
  // Only update userRRN2 if it's not empty
  if (value.length > 0) {
    userRRN2.value = value.charAt(0) + '*'.repeat(value.length - 1);
  } else {
    userRRN2.value = value;
  }
};

// Computed property for masked RRN2
const maskedRRN2 = computed(() => {
  if (userRRN2.value.length === 0) return '';
  return userRRN2.value.charAt(0) + '*'.repeat(userRRN2.value.length - 1);
});



const createUser = function(){
    // console.log(userRRN1.value + '-' + userRRN2.value.substring(0, 1))
    const data = {
        userID: userID.value,
        userPW: userPW.value,
        username: username.value,
        userNickname: userNickname.value, 
        userRRN: userRRN1.value + '-' + userRRN2.value.substring(0, 1),
        userPhonenumber: userPhonenumber1.value + '-' + userPhonenumber2.value + '-' + userPhonenumber3.value
    }

    if(isNaN(parseInt(userRRN1.value)) || isNaN(parseInt(userRRN2.value)) || userRRN1.value.length!=6 || userRRN2.value.length!=7){
        // alert("잘못된 주민등록번호 입니다.")
        Swal.fire({
          icon: "warning",
          title: "잘못된 주민등록번호 입니다.",
          showConfirmButton: false,
          timer: 1500
        })
        router.push({name: 'signup'})
        return
        // window.location.reload()
    }
    else if(isNaN(parseInt(userPhonenumber1.value)) || isNaN(parseInt(userPhonenumber2.value)) || isNaN(parseInt(userPhonenumber3.value)) || 
        (userPhonenumber1.value.length!=3) || (userPhonenumber2.value.length!=4) || (userPhonenumber3.value.length!=4)){
        // alert("잘못된 핸드폰번호 입니다.")
        Swal.fire({
          icon: "warning",
          title: "잘못된 핸드폰번호 입니다.",
          showConfirmButton: false,
          timer: 1500
        })
        router.push({name: 'signup'})
        return
        // window.location.reload()
    }

    const url = "http://localhost:8080/newsports/signup"
    
    axios({
        url: url,
        method: 'POST',
        data: data,
    })
    .then((response)=> {

      Swal.fire({
        icon: "success",
        title: `회원가입이 되었습니다!`,
        showConfirmButton: false,
        timer: 1500
      })
      router.push({name: 'login'})
    })
    .catch((err)=> {
        if(err.response.data === 'DuplicatedID'){
            // alert("이미 가입된 아이디입니다.")
            Swal.fire({
              icon: "warning",
              title: "이미 가입된 아이디입니다.",
              showConfirmButton: false,
              timer: 1500
            })
        }
        if(err.response.data === 'DuplicatedPhonenumber'){
            // alert("이미 등록된 전화번호입니다.")
            Swal.fire({
              icon: "warning",
              title: "이미 등록된 전화번호입니다.",
              showConfirmButton: false,
              timer: 1500
            })
        }
        if(err.response.data === 'DuplicatedNickname'){
            // alert("이미 존재하는 닉네임입니다.")
            Swal.fire({
              icon: "warning",
              title: "이미 존재하는 닉네임입니다.",
              showConfirmButton: false,
              timer: 1500
            })
        }
    })
}

</script>



<style scoped>

.container {
    font-family: "LA28 Text";
    font-size: smaller;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    max-width: 400px; /* 폼의 최대 너비 설정 */
    margin: 5em auto; 
}

h1{
  font-family: "LA28 Text";
  text-align: center;
  margin-bottom: 0.5em;
}

.signup-form {
    justify-content: center;
    width: 34rem;
    /* margin: 0 auto;  */
    border-radius: 10px;
    background-color: #cfe7ffc4; 
    padding: 2rem;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

/* CSS */

.form {
    display: flex;
    flex-direction: column;
    align-items: flex-start; /* 왼쪽 정렬 */
}

.form-group {
    margin-bottom: 15px; 
}

.label {
    font-weight: bold;
    margin-right: 10px; /* 라벨과 인풋 필드 사이 간격 */
}

/* input[type="id"],
input[type="pw"],
input[type="name"] {
  width: 100%;
  padding: 10px;
  margin-top: 8px;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
} */
/* input{
  border-radius: 5px;
  border: 0.5px solid gray;
} */
.form-group input {
    flex: 1; 
    padding: 8px; 
    border: none;
    background-color: #cfe7ff00; 
    border-bottom: 1px solid #000000; 
    border-radius: 0; 
    box-sizing: border-box; 
}

/* RRN, PhoneNumber 입력 폼의 레이아웃 설정 */
.rrn-inputs,
.phone-inputs {
    display: flex;
    align-items: center;
    width: 50%;
}

.rrn-inputs input,
.phone-inputs input {
    margin-right: 0.3em;
    margin-left: 0.3em;
    flex: 1; /* 동일한 너비의 입력 필드 */
}

/* Submit 버튼 스타일링 */
button {
    width: 100%;
    padding: 10px 20px; 
    background-color: #000000;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer; /* 커서 모양 변경 */
}

button:hover {
    background-color: #000000; 
}



</style>