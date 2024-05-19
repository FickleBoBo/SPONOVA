<template>
    <div>
        <h1>IntroView</h1>

        <!-- 연습해봄 -->
        <div class="card">
            <div class="card-content">
                <div class="card-image">
                    <img src="data:image/jpeg;base64,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" alt="Card Image">
                </div>
                <div class="card-details">
                    <h2>뉴 스포츠 더보기</h2>
                    <p>뉴 스포츠는 어쩌구 저쩌구</p>
                    <RouterLink :to="{name: 'game'}">뉴 스포츠 더보기</RouterLink>
                </div>
            </div>
        </div>

        <div>
            <RouterLink :to="{name: 'game'}">뉴 스포츠 더보기</RouterLink>
        </div>
        <div>
            <RouterLink :to="{ name: 'gameDetail', params: { id: '1' } }">티볼 더보기</RouterLink>
        </div>
        <div>
            <RouterLink :to="{ name: 'gameDetail', params: { id: '2' } }">빅발리볼 더보기</RouterLink>
        </div>
        <div>
            <RouterLink :to="{ name: 'gameDetail', params: { id: '3' } }">인디아카 더보기</RouterLink>
        </div>
        <div>
            <RouterLink :to="{ name: 'gameDetail', params: { id: '4' } }">츄크볼 더보기</RouterLink>
        </div>
        <div>
            <RouterLink :to="{ name: 'gameDetail', params: { id: '5' } }">플로어볼 더보기</RouterLink>
        </div>
        <div>
            <RouterLink :to="{ name: 'gameDetail', params: { id: '6' } }">스포츠스태킹 더보기</RouterLink>
        </div>
        <div>
            <RouterLink :to="{name: 'community'}">커뮤니티 더보기</RouterLink>
        </div>
    </div>
</template>



<script setup>

</script>



<style scoped>
.card {
  display: flex;
  border: 1px solid #ccc;
  border-radius: 5px;
  overflow: hidden;
  margin: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.card-content {
  display: flex;
}

.card-image {
  flex: 1;
}

.card-image img {
  width: 100%;
  height: auto;
}

.card-details {
  flex: 1;
  padding: 20px;
}

h2 {
  margin-top: 0;
}

p {
  margin-bottom: 10px;
}

a {
  text-decoration: none;
  color: blue;
}

a:hover {
  text-decoration: underline;
}
</style>