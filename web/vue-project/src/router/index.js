import { createRouter, createWebHashHistory } from 'vue-router';
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
        // 设置默认子路由为 index
        redirect: '/home/index'
      },
      {
        path: '/home/index',
        name: 'index',
        components: {
          // 使用 components 为 homepageContent 设置默认组件
          default: homepageContent,
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
  history: createWebHashHistory("http://1.94.3.242:8080"),
  routes
});

export default router;
