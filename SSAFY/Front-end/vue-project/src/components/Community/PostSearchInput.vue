<template>
  <div class="search">
      <!-- <div>
          <label>검색 기준 :</label>
          <select v-model="searchInfo.key">
              <option value='none'>없음</option>
              <option value="title">제목</option>
          </select>
      </div> -->
      <div class="search-title">
          <!-- <label>제목을 검색하세요 : </label> -->
          <input type="text" v-model="searchInfo.word" placeholder="제목을 검색하세요" @keydown.enter.prevent="handleEnter"/>
      </div>
      <div class="search-order">
          <div>
              <!-- <label>정렬 기준 :</label> -->
              <select v-model="searchInfo.orderBy">
                  <option value='postID'>작성일</option>
                  <option value="postViewCnt">조회수</option>
              </select>
          </div>
          <div>
              <!-- <label>정렬 방향 :</label> -->
              <select v-model="searchInfo.orderByDir">
                  <option value="asc">오름차순</option>
                  <option value="desc">내림차순</option>
              </select>
          </div>
          <div>
              <button @click="searchPostList">
                <img src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/afd2765d-7a27-4e6b-b1d1-3a0b8034da68/desmh0p-9c96145b-d4c9-47bc-a5ec-ce3d205a4e30.png/v1/fill/w_1280,h_442/logo_png___aespa___savage_logo_png_by_kloorer_desmh0p-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NDQyIiwicGF0aCI6IlwvZlwvYWZkMjc2NWQtN2EyNy00ZTZiLWIxZDEtM2EwYjgwMzRkYTY4XC9kZXNtaDBwLTljOTYxNDViLWQ0YzktNDdiYy1hNWVjLWNlM2QyMDVhNGUzMC5wbmciLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.PQ3H3I8DGs1s0mWbAOI0LAzDU96A3B-7PwYyK5TeIjk"></button>
              <!-- <button @click="searchPostList"><img src="https://littledeep.com/wp-content/uploads/2020/01/littledeep_peach_main.png"></button> -->
            </div>
      </div>
  </div>
</template>

<script setup>

import {useCommunityStore} from '@/stores/community'
import {ref} from 'vue'

const searchInfo = ref({
  key: 'postTitle', // title일까 postTitle일까 -> postTitle이었다
  word: '', // 나의 검색
  orderBy: 'postID',  // 작성번호를 기준으로 최신순 검색 가능
  orderByDir: 'desc' // 기본은 내림차순(작성순)
})

const communityStore = useCommunityStore()
const searchPostList = function(){
  communityStore.searchPostList(searchInfo.value)
  searchInfo.value.orderBy,
  searchInfo.value.orderByDir
}

// 검색어를 입력하고 엔터를 누르면 버튼을 누른 것과 동일한 이벤트 수행
const handleEnter = () => {
    searchPostList()
}

</script>

<style scoped>

.search {
  display: flex;
  flex-direction: column;
  margin-right: 2em;
}

input[type="text"] , select{
  width: 100%; 
  padding: 0.8em;
  margin-bottom: 1em;
}

.search-order{
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    width: 100%;
    /* margin-right: 0; */
}

.search-order > div{
    margin-right: 1em;
}
.search-order >div:last-child{
    margin-right: 0;
}


button, img {
    /* background-color: black;
    color: white;
    border-radius: 5%;
    cursor: pointer;  */
    background-color: black;
}
img{
    height: 2.5em;
    width: auto;
    background-color: black;

}

label, input, option, button, select {
    margin-right: 0.5em;
    text-align: center;
    align-items: center;
}

option{
    margin-right: 1em;
}
</style>
