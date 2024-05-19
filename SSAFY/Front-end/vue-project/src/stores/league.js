
// export const useLeagueStore = defineStore('leagueInfo', () => {
  
//   // const leagueList = ref([])
//   // const leagueRankings = ref([])


//   // const getLeagueList = function(){
  //   //   axios.get(GENS_API)
  //   //   .then((response) =>{
    //   //     leagueList.value = response.data
    //   //   })
    //   //   .catch(error => {
      //   //     console.error('Error fetching leagues:', error);
//   //   })
//   // }

//     // 특정 게임 ID에 따른 리그 랭킹 가져오기
//     // async-> 비동기
//     // await -> async 내부에서만 사용, then을 대신 함

//     // const getLeagueRankingByGameID = (gameID) => {
  //     //   axios.get(`${GENS_API}/${encodeURIComponent(gameID)}`)
  //     //     .then(response => {
    //     //       console.log(response.data)
    //     //       leagueRankings.value = response.data; // 응답 데이터를 leagueRankings에 할당
    //     //     })
    //     //     .catch(error => {
      //     //       console.error('Error:', error); // 에러 처리
      //     //     });
      //     // }
      
      
      
      //   return { 
        //     leagueList, 
        //     leagueRankings,
        //     // getLeagueList, 
        //     getLeagueRankingByGameID,
        //   }
        
        // })
        
import axios from 'axios'
import { defineStore } from 'pinia'
// import router from '@/router'
// import { ref } from 'vue'

const GENS_API = `http://localhost:8080/newsports/league/rankings`

export const useLeagueStore = defineStore('leagueInfo', {
  state: () => ({
    leagueRankings: [],  // 리그 랭킹을 저장할 상태
  }),

  actions: {
    // 특정 게임 ID에 따른 리그 랭킹을 가져오는 메서드
    getLeagueRankingByGameID(gameID) {
      return axios.get(`${GENS_API}/${encodeURIComponent(gameID)}`)
      .then(response => {
        this.leagueRankings = response.data; // 응답 데이터를 상태에 저장
        console.log(response.data);
        })
        .catch(error => {
          console.error('Error fetching rankings:', error);
        });
    }
  }
})
