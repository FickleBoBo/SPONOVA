import { computed, ref } from 'vue'
import { defineStore } from 'pinia'

// store 
export const gameInfoStore = defineStore('gameInfo', () => { 

    // 뉴 스포츠 정보
    const gameInfo = ref([
        {id: 1, koName: "티볼", enName: "Tee-Ball"}, 
        {id: 2, koName: "커롤링", enName: "Curolling"}, 
        {id: 3, koName: "플라잉디스크", enName: "Flyingdisc"}, 
        {id: 4, koName: "핸들러", enName: "Handler"}, 
        {id: 5, koName: "셔플보드", enName: "Shuffleboard"}, 
        {id: 6, koName: "소프트발리볼", enName: "Soft-Volleyball"}, 
        {id: 7, koName: "프리테니스", enName: "Freetennis"}, 
        {id: 8, koName: "인디아카", enName: "Indiaca"}, 
        {id: 9, koName: "플링고", enName: "Flingo"}, 
        {id: 10, koName: "스포찬", enName: "Spochan"}, 
        {id: 11, koName: "츄크볼", enName: "Tchouball"}, 
        {id: 12, koName: "태극유력구", enName: "Taegeuk"}, 
        {id: 13, koName: "킨볼", enName: "Kinball"}, 
        {id: 14, koName: "플로어볼", enName: "Floorball"}, 
        {id: 15, koName: "스포츠스태킹", enName: "Sport Stacking"}, 
    ])

    return {
        gameInfo, 
    }

})
