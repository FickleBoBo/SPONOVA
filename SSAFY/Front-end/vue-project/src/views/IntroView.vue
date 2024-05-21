<template>
  <br><br><br><br><br>

  <div class="carousel">
    <div class="carousel-image" v-for="i in visibleImages" :key="i">
      <img :src="images[i]" />
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
        'public/morumoru1.png',
        'public/morumoru2.png',
        'public/morumoru3.png',
        'public/morumoru4.png',
        'public/morumoru5.png'
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

.carousel-image {
  transition: transform 0.5s ease;
}

img {
  width: 400px;
  height: 400px;
  margin: 20px;
  border: 1px solid black;
}

</style>