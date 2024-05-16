import router from '@/router'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

const GENS_API=`http://localhost:8080/newsports/club`

export const useClubStore = defineStore('club', () => {


  const clubList = ref([])

  const getClubList = function(){
    axios.get(GENS_API)
    .then((response) =>{
      clubList.value = response.data
    })
    .catch(error => {
      console.error('Error fetching clubs:', error);
  })
  }

  const club = ref({})
  const getClub = function(clubID){
    axios.get(`${GENS_API}/${clubID}`)
    .then((response) => {
      club.value = response.data
      console.log(club.value)
      console.log(`${GENS_API}/${clubID}`)
    })
  }

  const searchClubList = function(searchCondition) {

    let url=GENS_API
    // 검색어가 있을 때만 검색 기능을 작동시킬 수 있다
    if (searchCondition.key !== 'none' && searchCondition.word) {
      url += `/search`; 
    }

    axios.get(url, {
      params: searchCondition
    })
    .then((response) => {
      clubList.value = response.data
      console.log(clubList.value)
    })
    .catch((error) => {
      console.error('Error searching posts:', error);
    });
  }


  return { 
    clubList, 
    getClubList, 
    club,
    getClub,
    searchClubList
  }



})