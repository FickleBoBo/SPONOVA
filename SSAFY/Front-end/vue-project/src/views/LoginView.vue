<template>
    <div>
        <h1>LoginView</h1>

        <!-- 로그인 폼 양식 -->
        <form @submit.prevent>
            <div class="loginForm">
                <div>
                    <input type="text" name="id" placeholder="아이디" v-model="id" required>
                </div>
                <div>
                    <input type="password" name="pw" placeholder="비밀번호" v-model="pw" required>
                </div>
                <button @click="submitToPinia">로그인</button>
            </div>
        </form>
    </div>
</template>



<script setup>

// pinia의 user로 보낼거라 세팅
import { useUserStore }  from '@/stores/user'
const userStore = useUserStore()
import { ref } from 'vue'

// 임시 변수 id, pw를 만들어서 로그인 폼의 input 태그와 동기화
// 로그인 버튼 누르면 id, pw 값을 pinia로 보내주고 id, pw는 초기화
const id = ref("")
const pw = ref("")

const submitToPinia = (() => {
    userStore.sendLoginData(id.value, pw.value)
    id.value = ""
    pw.value = ""
})

</script>



<style scoped>

/* chatGPT로 함 */

.loginForm {
    width: 30rem;
    margin: 0 auto; /* 가운데 정렬 */
    border-radius: 10px;
    background-color: #f8f9fa; /* 배경색 */
    padding: 2rem;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

input {
    width: 100%;
    height: 3rem;
    margin-bottom: 1rem; /* 각 input 사이 간격 */
    padding: 0.5rem;
    border: 1px solid #ced4da; /* 테두리 */
    border-radius: 5px;
    font-size: 1rem;
}

button {
    width: 100%;
    height: 3rem;
    background-color: #007bff; /* 배경색 */
    color: #fff; /* 글자색 */
    border: none;
    border-radius: 5px;
    font-size: 1.2rem;
    cursor: pointer;
    transition: background-color 0.3s; /* hover 효과 */
}

button:hover {
    background-color: #0056b3; /* hover 시 배경색 변경 */
}

</style>
