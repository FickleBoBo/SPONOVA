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
            with US
        </div>
        
    </div>

    <!--뉴스포츠 소개-->
    <div class="main-intro">
        <div class="main-intro-logo"><img src="../assets/indiaca.png"></div>
        <div class="main-intro-disc">
            <div class="main-intro-disc-vis">About GENS</div>
            <div class="main-intro-disc-title">TItle: page name</div>
            <div class="main-intro-disc-ription">
                Let me introduce our page.
                BLah blah
            </div>
        </div>
    </div>

    <!--우리의 비전, 목표-->
    <div class="main-vision">
        <div class="main-vision-disc">
            <div class="main-vision-disc-vis">Our Vision</div>
            <div class="main-vision-disc-title">Explore What's Next Generation's Sport</div>
            <div class="main-vision-disc-ription">
                우리가 이 사이트를 제작하게 된 이유
            </div>
        </div>
        <div class="main-vision-logo"><img src="../assets/teeballboy.jpg"></div>
    </div>


    <!--뉴스포츠 종목 아이콘 - 반응형 -->
    <div class="main-game-icon">
        <div class="main-game-title">GAMES</div>
        <div class="game-icon-1">
            <div class="game-icon-individual teeball"><img src="../assets/teeball.png"></div>
            <div class="game-icon-individual"><img src="../assets/volleyball.png"></div>
            <div class="game-icon-individual"><img src="../assets/indiaca.png"></div>
        </div>
        <div class="game-icon-2">
            <div class="game-icon-individual"><img src="../assets/tchouball.png"></div>
            <div class="game-icon-individual"><img src="../assets/floorball.png"></div>
            <div class="game-icon-individual"><img src="../assets/sportstacking.png"></div>
        </div>
    </div>


    <!--SHOP '사이트명'-->
    <div class="main-shop">
        <div class="main-shop-title">SHOP GENS</div>
        <div class="main-shop-disc">Gens swag for every day of the week.</div>
    </div>
    <Shop />


    </div>
    

    <!-- <footer>
        <div>로고는 왼쪽에</div>
        <div>오시는 길: 멀티캠퍼스 주소</div>
        <div>문의 contact us: 누군가의 이메일 주소</div>
        &copy; 2024. All Rights Reserved
    </footer> -->
</template>



<script setup>
import { onMounted, ref } from 'vue'
import Shop from '../components/Home/Shop.vue'

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

/* 동영상 위의 글씨 */
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


/**소개 영역 1 */
.main-intro{
    position: relative;
    margin-top: 2em;

    display: flex;
    flex-direction: row;
    justify-content: center;
}
.main-intro-logo img{
    width: 20em;
    height: auto;
    margin: 1em;;
}
.main-intro-disc{
    display: flex;
    flex-direction: column;
}
.main-intro-disc-vis{
    font-family: 'LA28 Text';
    font-size: small;
    color: rgb(29, 191, 255);
    display: flex;
    justify-content: flex-start;
}
.main-intro-disc-title{
    font-family: 'LA28 Display';
    font-size: 50px;
    margin: 0.2em 0;
    left: 0;
}
.main-intro-disc-ription{
    font-family: 'LA28 Text';
    font-size: 30px;
    left: 0;
}




/**소개 영역 2 */
.main-vision{
    position: relative;
    margin-top: 2em;
    display: flex;
    flex-direction: row;
    justify-content: center;
}
.main-vision-disc{
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
}
.main-vision-disc-vis{
    font-family: 'LA28 Text';
    font-size: small;
    color: rgb(29, 191, 255);
}
.main-vision-disc-title{
    font-family: 'LA28 Display';
    font-size: 50px;
    margin: 0.1em 0;
    left: 0;
}
.main-vision-disc-ription{
    font-family: 'LA28 Text';
    font-size: 30px;
    left: 0;
}
.main-vision-logo img{
    width: 20em;
    height: auto;
    margin: 1em;;
}





/**games영역 전체 */
.main-game-icon{
    position: relative;
    width: 100%;
    margin-top: 5em;

    background-color: white;
    color: black;
    font-size: xx-large;
    font-weight: 500;
    font-family: 'LA28 Text', sans-serif;

    display: flex;
    flex-direction: column;
    justify-content: center;
}

/** GAMES */
.main-game-title{
    position: relative;
    z-index:100;
    font-size: 60px;
    text-align: center;
    margin-bottom: 1em;
}

/**픽토그램 1열, 2열 */
.game-icon-1, .game-icon-2 {
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin: 0 auto;
    align-items: center;
}

/**개별 이미지 */
.game-icon-individual img {
    width: 70%;
    height: auto;
    margin: 1em;
    transition: 0.5s ease;
}
/*티볼만 사진 사이즈가 다름 */
.game-icon-individual, .teeball{
    width: 50%;
}
.game-icon-individual img:hover{
    transform: scale(1.2) rotateZ(360deg);
}




.main-shop{
    position: relative;
    padding: 2em;
    width: 100%;
    margin: 0 auto;
    margin-top: 3em;

    display: flex;
    flex-direction: column;
    justify-content: center;
    
    background-color: black;
    color: white;
    /* margin-top: 5em; */
}
.main-shop-title{
    font-size: 50px;
    font-family: 'LA28 Display';
}
.main-shop-disc{
    font-size: 20px;
    font-family: 'LA28 Text';
}

</style>