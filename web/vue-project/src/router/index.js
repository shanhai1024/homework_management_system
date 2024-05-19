import { createRouter, createWebHistory } from 'vue-router'

import {isLoggedIn} from "@/stores/auth.js";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: ()=> import('@/views/HomeView.vue')
    },
    {
      path: '/',
      name: 'login',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/Login.vue')
    }
  ]
})

// 路由守卫

router.beforeEach((to, from, next) => {
  console.log('导航守卫：开始导航到', to.name); // 输出导航信息
  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (!isLoggedIn()) {
      console.log('导航守卫：需要登录，但用户未登录'); // 输出需要登录信息
      next({
        path: '/login',
        query: { redirect: to.fullPath }
      });
    } else {
      console.log('导航守卫：用户已登录，继续导航'); // 输出用户已登录信息
      next();
    }
  } else {
    console.log('导航守卫：无需验证，继续导航'); // 输出无需验证信息
    next();
  }
});

export default router
