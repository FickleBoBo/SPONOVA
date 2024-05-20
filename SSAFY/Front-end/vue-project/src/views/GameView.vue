<template>
    <div class="game-view-container">
        <div>
            <GameListView />
        </div>
    </div>

    <!-- 이거 때문에 URL 바뀌어도 화면에 표시 안됐는데 중첩 라우터 쓰면 해당 중첩 위치에서 <RouterView /> 불러줘야 함 -->
    <RouterView />
</template>



<script setup>

</script>



<style scoped>

/* 일단은 그냥 보기 좋으라고 넣음 */
.game-view-container {
    margin-top: 2rem;
}

</style>