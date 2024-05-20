// ver1. 1개만 있었을 때
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



//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////



// ver.2 여러 종목
// import { defineStore } from 'pinia'
// import { ref } from 'vue'
// import axios from 'axios'
// import dayjs from 'dayjs'

// const GENS_API = `http://localhost:8080/newsports/league/rankings`

// export const useLeagueStore = defineStore('leagueInfo', () => {
//   const leagueRankings = ref([])

//   // 특정 게임 ID에 따른 리그 랭킹
//   function getLeagueRankingByGameID(gameID) {
//     return axios.get(`${GENS_API}/${encodeURIComponent(gameID)}`) // 게임ID가 한글로 되어있어서 encode--를 붙여줌
//       .then(response => {
//         leagueRankings.value = response.data;
//         console.log(response.data)
//       })
//       .catch(error => {
//         console.error('Error: ', error)
//       })
//   }

//   return { 
//     leagueRankings,
//     getLeagueRankingByGameID,
//   }
// });




//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////



// ver3. 랭킹 + 오늘의 매치
import { defineStore } from 'pinia'
import axios from 'axios'
import { ref } from 'vue'

export const useLeagueStore = defineStore('leagueInfo', () => {
 // 참조형으로 한번에 (ranking + match = data)를 생성
  const data = ref({
    rankings: [],
    todayGames: []
  })

  // axios 연결
  function getLeagueDetailsByGameID(gameID) {
    // 기본 api는 leagueController에서 확인할 수 있듯이 gameID까지: 한글이라 앞에 'encodeURIComponent' 붙여줌
    const API_URL = `http://localhost:8080/newsports/league/rankings/${encodeURIComponent(gameID)}`
    return axios.get(API_URL)
      .then(response => {
        data.value.rankings = response.data.rankings
        data.value.todayGames = response.data.todayGames
      })
      .catch(error => {
        console.error('Failed: error message:', error)
        // 형태 주의
        data.value = { rankings: [], todayGames: [] }
      })
  }

  return {
    data,
    getLeagueDetailsByGameID
  }
})
