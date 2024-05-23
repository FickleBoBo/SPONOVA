<template>
  <br><br><br><br><br>

  <div class="carousel">
    <div class="carousel-image" v-for="i in visibleImages" :key="i">
      <img :src="images[i].imagePath" />
      <div class="carousel-content">
        <div class="carousel-content-text">
          <div>수제 모루모루 {{ i+1 }} 호</div>
          <div>\110,000</div>
        </div>
        <div>
          <i @click="images[i].isFavorite = !images[i].isFavorite" :class="{'fa-solid': images[i].isFavorite, 'fa-regular': !images[i].isFavorite, 'fa-heart': true, 'fa-xl': true}" style="color: red"></i>
        </div>
      </div>
    </div>
  </div>
  
  <br><br><br><br><br>
</template>

<script>
export default {
  data() {
    return {
      currentIndex: 0,
      images: [
        {
          imagePath: '/morumoru1.png', 
          isFavorite: false
        }, 
        {
          imagePath: '/morumoru2.png', 
          isFavorite: false
        }, 
        {
          imagePath: '/morumoru3.png', 
          isFavorite: false
        }, 
        {
          imagePath: '/morumoru4.png', 
          isFavorite: false
        }, 
        {
          imagePath: '/morumoru5.png', 
          isFavorite: false
        }, 
      ]
    }
  },
  computed: {
    visibleImages() {
      return [
        this.currentIndex % 5,
        (this.currentIndex + 1) % 5,
        (this.currentIndex + 2) % 5
      ];
    }
  },
  mounted() {
    setInterval(() => {
      this.advanceCarousel();
    }, 1000);
  },
  methods: {
    advanceCarousel() {
      this.currentIndex++;
      if (this.currentIndex >= 5) this.currentIndex = 0;
    }
  }
}
</script>



<style scoped>

.carousel {
  display: flex;
  justify-content: center;
  overflow: hidden;
  width: 100%;
}

img {
  width: 400px;
  height: 400px;
}

.carousel-image {
  display: flex;
  flex-direction: column;
  margin: 50px;
  text-align: center;
  transition: transform 0.5s ease;
  border: 5px solid black;
}

.carousel-content {
  display: flex;
  justify-content: space-around;
  align-items: center;
  transition: transform 0.5s ease;
}

.carousel-content > * {
  margin: 20px;
}

</style>
