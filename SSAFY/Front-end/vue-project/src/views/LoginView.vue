<template>
    <div>
        <h1>LoginView</h1>

        <form @submit.prevent>
            <div class="loginForm">
                <div>
                    <input type="text" name="id" placeholder="아이디" v-model="id" required>
                </div>
                <div>
                    <input type="password" name="pw" placeholder="비밀번호" v-model="pw" required>
                </div>
                <button @click="submitToPinia">로그인</button>
                <button @click="resetToPinia">로그아웃</button>
            </div>
        </form>

        <!-- <div>로그인 아이디 : {{ store.userId }}</div>
        <div>로그인 비밀번호 : {{ store.userPw }}</div> -->

    </div>
</template>



<script setup>

import { userInfoStore }  from '@/stores/userInfo'
const store = userInfoStore()
import { ref } from 'vue'

const id = ref("")
const pw = ref("")

const submitToPinia = (() => {
    store.sendLoginData(id.value, pw.value)
    id.value = ""
    pw.value = ""
})

const resetToPinia = (() => {
    store.loginInfo = ""
})

</script>



<style scoped>

.loginForm {
    width: 30rem;
    border: 1px solid lightgray;
    text-align: center;
    align-items: center;
    padding: 1rem;
}

input {
    width: 20rem;
    height: 2rem;
}

button {
    width: 10rem;
    height: 3rem;
}

</style>
