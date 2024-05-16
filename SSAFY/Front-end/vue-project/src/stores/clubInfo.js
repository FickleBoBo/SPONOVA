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


  return { clubList, getClubList, club }



})