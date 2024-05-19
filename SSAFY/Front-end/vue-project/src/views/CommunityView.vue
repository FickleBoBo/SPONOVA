<template>
    <div class="commutnity-container">
        <div class="header">
            <div>
                <h1>자유게시판</h1>
            </div>
            <div>
                <PostSearchInput/>
            </div>
        </div>
        <table class="post-table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>댓글수</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="post in communityStore.postList.slice(pageNum * 50, pageNum * 50 + 50)" :key="post.postID">
                    <td>{{ post.postID }}</td>
                    <td><RouterLink :to="{ name: 'PostDetailPage', params: { id: post.postID } }">{{ post.postTitle }}</RouterLink></td>
                    <td>{{ post.userNickname }}</td>
                    <td v-if="todayPosted(post.postRegDate)">{{ post.postRegDate.slice(0, 10) }}</td>
                    <td v-else>{{ post.postRegDate.slice(11, 19) }}</td>
                    <td>{{ post.postViewCnt }}</td>
                    <td>{{ post.commentCnt }}</td>
                </tr>
            </tbody>
        </table>

        <!-- 페이지네이션 -->
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item" :class="{ disabled: pageNum === 0 }">
                    <a class="page-link" href="#" aria-label="Previous" @click.prevent="prevPage">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li v-for="n in pagination" :key="n" class="page-item" :class="{ active: pageNum === n - 1 }">
                    <a class="page-link" href="#" @click="movePage(n)">{{ n }}</a>
                </li>
                <li class="page-item" :class="{ disabled: pageNum === (totalPages - 1) }">
                    <a class="page-link" href="#" aria-label="Next" @click.prevent="nextPage">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>

        <RouterLink class="write-post-button" :to="{ name: 'PostCreatePage' }">글쓰기</RouterLink>
    </div>
</template>



<script setup>

import PostSearchInput from '@/components/Community/PostSearchInput.vue'
import { useCommunityStore } from '@/stores/community'
import{ ref, computed, onBeforeMount } from 'vue'

const communityStore = useCommunityStore()

// 게시물 등록일이 오늘이면 등록 시간을 표시하고, 이전이면 등록일을 표시하는 함수
const todayPosted = ((regDate) => {
    var today = new Date()
    var year = today.getFullYear().toString()
    var month = (today.getMonth() + 1).toString().padStart(2, '0')
    var day = today.getDate().toString().padStart(2, '0')
    var todayString = year + '-' + month + '-' + day
    if(regDate.slice(0, 10) === todayString){
        return false
    }
    else{
        return true
    }
})

// 페이지네이션
const pageNum = ref(0)

const movePage = function(num) {
    pageNum.value = num - 1
}

const prevPage = () => {
  if (pageNum.value > 0) {
    pageNum.value--
  }
}

const nextPage = () => {
  if (pageNum.value < communityStore.pages - 1) {
    pageNum.value++
  }
}


// 페이지네이션에서 페이지가 너무 많으면 이쁘게 정리하기(chatGPT 사용)
const pagination = computed(() => {
  const pages = []
  const total = communityStore.pages

  if (total <= 10) {
    for (let i = 1; i <= total; i++) pages.push(i)
  } else {
    if (pageNum.value < 5) {
      for (let i = 1; i <= 5; i++) pages.push(i)
      pages.push('...')
      pages.push(total)
    } else if (pageNum.value >= total - 5) {
      pages.push(1)
      pages.push('...')
      for (let i = total - 4; i <= total; i++) pages.push(i)
    } else {
      pages.push(1)
      pages.push('...')
      for (let i = pageNum.value; i <= pageNum.value + 2; i++) pages.push(i)
      pages.push('...')
      pages.push(total)
    }
  }

  return pages
})

onBeforeMount(() => {
    communityStore.getPostList()
})

</script>



<style scoped>

.header {
    display: flex;
    flex-direction: column; /* 요소들을 세로로 배열 */
    justify-content: center;
    text-align: center; /* 텍스트도 중앙 정렬 */
    margin-bottom: 20px; /* 아래 여백 추가 */
}


.commutnity-container {
    padding: 20px;
    max-width: 1200px;
    margin: auto;
}

.post-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.post-table th, .post-table td {
    padding: 10px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

.post-table th {
    background-color: #f4f4f4;
}

.post-table tr:hover {
    background-color: #f9f9f9;
}

/* 수정 시작 */
.post-table th:nth-child(1),
.post-table td:nth-child(1),
.post-table th:nth-child(5),
.post-table td:nth-child(5),
.post-table th:nth-child(6),
.post-table td:nth-child(6) {
    width: 10%;
}

.post-table th:nth-child(3),
.post-table td:nth-child(3),
.post-table th:nth-child(4),
.post-table td:nth-child(4) {
    width: 15%;
}

.post-table th:nth-child(2),
.post-table td:nth-child(2) {
    width: 40%;
}

/* 수정 끝 */

.post-table td:nth-child(2) a {
    text-decoration: none; /* 링크의 밑줄 제거 */
}

.pagination {
    display: flex;
    justify-content: center;
    margin: 20px 0;
}

.page-item {
    margin: 0 5px;
}

.page-link {
    padding: 10px 15px;
    border: 1px solid #ddd;
    border-radius: 5px;
    text-decoration: none;
    color: #007bff;
    text-align: left;
}

.page-item.disabled .page-link {
    color: #6c757d;
    pointer-events: none;
    background-color: #fff;
    border-color: #dee2e6;
}

.page-item.active .page-link {
    color: #fff;
    background-color: #007bff;
    border-color: #007bff;
}

.write-post-button {
    display: block;
    width: 100px;
    margin: 20px auto;
    padding: 10px;
    text-align: center;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    text-decoration: none;
}
</style>
