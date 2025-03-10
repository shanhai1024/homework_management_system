// src/main.js
import { createApp } from 'vue';
import { createPinia } from 'pinia';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

import App from './App.vue';
import router from './router';
import { getToken } from './stores/auth.js';
import axios from 'axios';

const app = createApp(App);
const token = getToken();

// 将Axios实例挂载到Vue全局实例上
app.config.globalProperties.$axios = axios;

// main.js:注册所有图标
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

app.use(createPinia());
app.use(router);
app.use(ElementPlus);
app.mount('#app');
