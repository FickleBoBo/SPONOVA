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

import SignUpView from '@/views/SignUpView.vue'
import GameListView from '@/views/GameListView.vue'
import GameDetailView from '@/views/GameDetailView.vue'
import LeagueDetailView from '@/views/LeagueDetailView.vue'
import PostCreatePage from '@/components/Community/PostCreatePage.vue'
import PostDetailPage from '@/components/Community/PostDetailPage.vue'
import PostUpdatePage from '@/components/Community/PostUpdatePage.vue'

import { useUserStore } from '@/stores/user'

import Swal from 'sweetalert2'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    }, 
    {
      path: '/signup',
      name: 'signup',
      component: SignUpView
    }, 
    {
      path: '/login',
      name: 'login',
      component: LoginView
    }, 
    {
      path: '/',
      name: 'logout',
      component: HomeView, 
      beforeEnter: ((to, from) => {
        const userStore = useUserStore()
        userStore.clearData()

        Swal.fire({
          icon: "success",
          title: "로그아웃 되었습니다",
          showConfirmButton: false,
          timer: 1500
        })
      })
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
          path: '',
          name: 'gameList',
          component: GameListView
        }, 
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
      component: LeagueView, 
      children: [
        {
          path: ':id',
          name: 'leagueDetail',
          component: LeagueDetailView
        }, 
      ]
    }, 
    {
      path: '/club',
      name: 'club',
      component: ClubView
    }, 

    // community 관련 URL
    {
      path: '/community', 
      name: 'community', 
      component: CommunityView, 
    }, 
    {
      path: '/community/create', 
      name: 'PostCreatePage', 
      component: PostCreatePage, 
      beforeEnter: ((to, from) => {
        const userStore = useUserStore()
        if(!userStore.loginStatus) {

          Swal.fire({
            icon: "warning",
            title: "로그인 하세요!",
            showConfirmButton: false,
            timer: 1500
          })

          router.push({name: 'login'})
        }
      })
    }, 
    {
      path: '/community/:id',
      name: 'PostDetailPage',
      component: PostDetailPage
    }, 
    {
      path: '/community/update',
      name: 'PostUpdatePage',
      component: PostUpdatePage,
    }, 
  ]
})

export default router
