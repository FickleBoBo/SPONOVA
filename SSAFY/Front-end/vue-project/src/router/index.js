// 이건 필수로 import인 듯
import { createRouter, createWebHistory } from 'vue-router'

// 만든 ~~View.vue 불러오기
import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import IntroView from '@/views/IntroView.vue'
import GameView from '@/views/GameView.vue'
import LeagueView from '@/views/LeagueView.vue'
import ClubView from '@/views/ClubView.vue'
import CommunityView from '@/views/CommunityView.vue'

import GameDetailView from '@/views/GameDetailView.vue'
import PostList from '@/components/Community/PostList.vue'
import PostCreate from '@/components/Community/PostCreate.vue'
import PostDetailPage from '@/components/Community/PostDetailPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    }, 
    {
      path: '/login',
      name: 'login',
      component: LoginView
    }, 
    {
      path: '/intro',
      name: 'intro',
      component: IntroView
    }, 
    {
      path: '/game',
      name: 'game',
      component: GameView, 
      children: [
        {
          path: ':id',
          name: 'gameDetail',
          component: GameDetailView
        }, 
      ]
    }, 
    {
      path: '/league',
      name: 'league',
      component: LeagueView
    }, 
    {
      path: '/club',
      name: 'club',
      component: ClubView
    }, 
    {
      path: '/community',
      name: 'community',
      component: CommunityView, 
      // children: [
      //   {
      //     path: ':id',
      //     name: 'PostDetailPage',
      //     component: PostDetailPage
      //   }, 
      // ], 
    }, 
    {
      path: '/community/:id',
      name: 'PostDetailPage',
      component: PostDetailPage
    }, 
    {
      path: '/community/create',
      name: 'PostCreate',
      component: PostCreate,
    }, 
    // {
    //   path: '/community/:id',
    //   name: 'PostDetailPage',
    //   component: PostDetailPage
    // }, 
  ]
})

export default router
