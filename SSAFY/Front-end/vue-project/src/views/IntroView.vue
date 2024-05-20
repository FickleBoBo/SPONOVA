<template>
  <br><br><br><br><br>
  <div>IntroView</div>

  <div class="imageContainer" :style="{ transform: `translateX(${translateX}px)` }">
    <div v-for="(image, index) in currentImages" :key="index">
      <img class="img" :src="image">
    </div>
  </div>
  
</template>

<script setup>
import { ref, onMounted } from 'vue'

const images = ref([
  "https://img.hankyung.com/photo/202403/01.36047379.1.jpg", 
  "https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202404/04/d1c9eb18-7096-42f4-a3fb-c8a7fbc55f09.jpg", 
  "https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202403/09/21e88381-7867-410a-b0c3-5d6c9cd430b1.jpg", 
  "https://flexible.img.hani.co.kr/flexible/normal/911/1223/imgdb/original/2024/0307/20240307501621.jpg", 
  "https://img.hankyung.com/photo/202112/03.28306045.1.jpg"
])

const translateX = ref(0)

const updateImages = () => {
  images.value.push(images.value.shift()) // 배열의 맨 앞 이미지를 맨 뒤로 이동하여 순환되도록 함
}

const currentImages = ref([images.value[0], images.value[1], images.value[2], images.value[3]])

const updateCurrentImages = () => {
  currentImages.value = [images.value[0], images.value[1], images.value[2], images.value[3]]
}

onMounted(() => {
  setInterval(() => {
    translateX.value = 0 // 이미지를 계속해서 왼쪽으로 이동시키는 대신, 0으로 설정하여 유지
    updateImages()
    updateCurrentImages() // currentImages를 업데이트
  }, 500)
})
</script>

<style scoped>
.imageContainer {
  display: flex;
  transition: transform 1s ease;
}

.img {
  width: 400px;
  height: 400px;
}
</style>
