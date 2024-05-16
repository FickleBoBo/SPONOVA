import router from '@/router'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

const GENS_API=`http://localhost:8080/newsports/league`

export const useLeagueStore = defineStore('leagueInfo', () => {

  const leagueList = ref([])
  const getLeagueList = function(){
    axios.get(GENS_API)
    .then((response) =>{
      leagueList.value = response.data
    })
    .catch(error => {
      console.error('Error fetching leagues:', error);
  })
}

  return { 
    leagueList, 
    getLeagueList, 
  }

})