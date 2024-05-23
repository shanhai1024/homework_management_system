import { createRouter, createWebHistory } from 'vue-router';
import Login from '@/views/Login.vue';
import Home from '@/views/HomeView.vue';
import personnelInformation from '@/views/nestedPages/personnelInformation.vue';
import homepageContent from '@/views/nestedPages/homepageContent.vue';
import careerManagement from "@/views/nestedPages/careerManagement.vue";

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/home',
    name: 'home',
    component: Home,
    children: [
      {
        path: '',
        name: 'home-default',
        redirect: '/home/index'  // 设置默认子路由为 index
      },
      {
        path: '/home/index',
        name: 'index',
        components: {
          default: homepageContent, // 使用 components 为 homepageContent 设置默认组件
          content: homepageContent
        }
      },
      {
        path: 'personnelInformation',
        name: 'personnelInformation',
        components: {
          default: personnelInformation,
          content: personnelInformation
        }
      },
      {
        path: 'careerManagement',
        name: 'careerManagement',
        components: {
          default: careerManagement,
          content: careerManagement
        }
      }
    ]
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;
