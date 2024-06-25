import { createRouter, createWebHashHistory } from 'vue-router';
import Login from '@/views/Login.vue';
import Home from '@/views/HomeView.vue';
import PersonnelInformation from "@/views/nestedPages/personnelInformation.vue";
import HomepageContent from "@/views/nestedPages/homepageContent.vue";
import CareerManagement from "@/views/nestedPages/careerManagement.vue";
import StudentInformationManagement from "@/views/studentManagementPage/studentInformationManagement.vue";
import StudentClassManagement from "@/views/studentManagementPage/studentClassManagement.vue";
import TeacherInformation from "@/views/teacherManagementPage/teacherInformation.vue";
import { isLoggedIn } from "@/stores/auth.js";
import { ElMessage } from "element-plus";
import NotFound from "@/views/notFound.vue";

const routes = [
  {
    path: '/',
    redirect: '/login' // 访问根路径时，重定向到登录页
  },
  {
    path: '/login',
    name: 'login',
    component: Login // 登录页组件
  },
  {
    path: '/home',
    component: Home, // 主页组件
    children: [
      {
        path: '',
        name: 'home-default',
        redirect: 'index' // 设置默认子路由为 index
      },
      {
        path: 'index',
        name: 'home-index',
        component: HomepageContent
      },
      {
        path: 'personnel-information',
        name: 'personnel-information',
        component: PersonnelInformation
      },
      {
        path: 'career-management',
        name: 'career-management',
        component: CareerManagement
      }
    ]
  },
  // 学生管理
  {
    path: '/home/student',
    component: Home, // 默认视图
    children: [
      {
        path: '',
        name: 'student-default',
        redirect: 'information'
      },
      {
        path: 'information',
        name: 'student-information',
        component: StudentInformationManagement
      },
      {
        path: 'class',
        name: 'student-class',
        component: StudentClassManagement
      }
    ]
  },
  // 教师管理
  {
    path: '/home/teacher',
    component: Home, // 默认视图
    children: [
      {
        path: '',
        name: 'teacher-default',
        redirect: 'information'
      },
      {
        path: 'information',
        name: 'teacher-information',
        component: TeacherInformation
      },
      {
        path: 'class',
        name: 'teacher-class',
        component: StudentClassManagement // 确认这是你想要的组件
      }
    ]
  },
  // 捕获所有未定义路径的 404 路由
  {
    path: '/:pathMatch(.*)*', // 捕获所有未定义路径
    name: 'not-found',
    component: NotFound
  }

];

const router = createRouter({
  history: createWebHashHistory(), // 使用哈希模式
  routes
});

router.beforeEach((to, from, next) => {
  if (!isLoggedIn() && to.name !== 'login') {
    ElMessage.error('用户未登陆请登录后再访问');
    next({ name: 'login' });
  } else if (isLoggedIn() && to.name === 'login') {
    next({ name: 'home-index' });
  } else {
    next(); // 继续导航
  }
});


export default router;
