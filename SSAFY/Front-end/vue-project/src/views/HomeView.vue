<template>
    <div class="whole-main-page">
        <!-- <h1>HomeView</h1> -->
        <!--동영상 area-->
        <div class="video" ref="videoRef" style="position: relative; width: 100%;  padding-top: 56.25%;"> //56.25는 화면 비율 웹에 맞춘 것
            <iframe 
            style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;" 
            src="https://www.youtube.com/embed/phuiiNCxRMg?autoplay=1&mute=1&controls=0&loop=1&playlist=phuiiNCxRMg" 
            title="aespa 에스파 &#39;Supernova&#39; MV" 
            frameborder="0" 
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
            referrerpolicy="strict-origin-when-cross-origin" 
            allowfullscreen></iframe>
        <div style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: transparent;"></div>
        
        <div class="video-content">
            PLAY<br>
            NEW SPORTS<br>
            LA28
        </div>
        
    </div>

    <!--뉴스포츠 소개-->
    <div class="main-intro">
        LOGO left| Let me introduce our page.<br>
        BLah blah
    </div>

    <!--우리의 비전, 목표-->
    <div class="main-vision">
        운동하는 사진 오른쪽| 
         Let me introduce our page.<br>
        BLah blah
    </div>


    <!--뉴스포츠 종목 아이콘 - 반응형 -->
    <div class="main-game-icon">
        <div>GAMES, 사진 대신 아이콘</div>
        <div class="game-icon-1">
            <div class="game-icon-individual"><img src="../assets/photo1.jpeg"></div>
            <div class="game-icon-individual"><img src="../assets/photo1.jpeg"></div>
            <div class="game-icon-individual"><img src="../assets/photo1.jpeg"></div>
        </div>
        <div class="game-icon-2">
            <div class="game-icon-individual"><img src="../assets/photo1.jpeg"></div>
            <div class="game-icon-individual"><img src="../assets/photo1.jpeg"></div>
            <div class="game-icon-individual"><img src="../assets/photo1.jpeg"></div>
        </div>
    </div>


    <!--SHOP '사이트명'-->
    <div class="main-shop">
        <div>SHOP GENS</div>
        <div>모루모루 사진 한 2개</div>
        <div>상품 이름 + 밑줄</div>
    </div>


    </div>
    

    <footer>
        <div>로고는 왼쪽에</div>
        <div>오시는 길: 멀티캠퍼스 주소</div>
        <div>문의 contact us: 누군가의 이메일 주소</div>
        &copy; 2024. All Rights Reserved
    </footer>
</template>



<script setup>
import { onMounted, ref } from 'vue'

const videoRef = ref(null)

onMounted(() => {
  videoRef.value.classList.add('visible')
})
</script>



<style scoped>

/* .whole-main-page{
    position: relative;
    animation: slideUp 3.0s ease-out forwards;
} */

@keyframes revealVideo{
    from {
        clip-path: inset(100% 0 0 0); /* 처음에는 영상의 전체가 숨겨져 있다. */
    }
    to {
        clip-path: inset(0 0 0 0); /* 애니메이션의 끝에서는 전체 영상이 보인다. */
    }
}

.video{
    position: relative;
    top: 0;
    opacity: 0;

    overflow: hidden;
    animation: revealVideo 5s ease-out forwards;
    /* transform: translateY(100%); 원래 위치보다 아래에서 시작 */
    /* transition: all 50s ease-out;위치와 투명도에 대한 전환 효과  */
  
    z-index: 1;

    padding-bottom: 2em;
  
    /*opacity: 1;
  transform: translateY(0); 원래 위치로 이동*/
}

.video.visible {
    opacity: 1; /* 투명도를 1로 설정 */
    transform: translateY(0); /* 원래 위치로 이동 */
}

.video-content {
    font-family: 'LA28 Text', sans-serif;
    /* font-family: 'LA28 Display', sans-serif; */
    position: absolute;
    top: 60%;
    left:10%;

    color:white;
    font-size: xx-large;
    /* font-weight: 200; */
    z-index: 5;
}

.main-intro{
    position: relative;
    margin-top: 2em;
    font-family: 'LA28 Display', sans-serif; 
    color: black;
    font-size: x-large;
}

.main-game-icon{
    position: relative;
    margin-top: 5em;
    background-color: white;
    color: black;
    font-size: x-large;
    font-family: 'LA28 Text 700', sans-serif;
}

.game-icon-1, .game-icon-2 {
    display: flex;
}

.game-icon-individual {
    width: 25%;
    height: auto;
    margin: 1em;
}

.main-shop{
    position: relative;
    margin-top: 2em;
    background-color: black;
    font-family: 'LA28 Display', sans-serif; 
    color: white;
    font-size: x-large;
    /* margin-top: 5em; */
}

footer {
    position: relative;
    bottom: 0;

    width: 100%;
    background-color: black;
    color: gray;
}

</style>