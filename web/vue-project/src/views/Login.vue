<template>
  <header></header>
  <main>
    <div class="round"></div>
    <div class="loginPage">
      <div class="switchRegisterPage">
        <div class="switchRegisterPageContent">
          <div class="switchRegisterPageButton">
            <h2>没有账号？</h2>
            <p>点击下方链接注册账号</p>
            <button @click="switchToRegister">注册账号</button>
          </div>
        </div>
        <img class="loginSvg" src="../assets/img/login.svg" alt="">
      </div>
      <div class="myForm">
        <form class="signForm">
          <h2 class="title">登陆</h2>
          <label>
            <input type="text" v-model="loginPhoneNumber" placeholder="电话号码"/>
          </label>
          <label>
            <input type="text" v-model="loginSMSCode" class="getSMSInput" placeholder="验证码"/>
            <button type="button" @click="getSMSCode(true)" class="getSMSButton">获取验证码</button>
          </label>
          <label>
            <input type="password" v-model="loginPassword" placeholder="您的密码"/>
          </label>
          <button type="button" @click="login" class="loginButton">登陆</button>
        </form>
      </div>
    </div>
    <div class="registerPage">
      <div class="myForm">
        <form class="signForm">
          <h2 class="title">注册</h2>
          <label>
            <input type="text" v-model="registerPhoneNumber" placeholder="注册电话号码"/>
          </label>
          <label>
            <input type="text" v-model="registerSMSCode" class="getSMSInput" placeholder="验证码"/>
            <button type="button" @click="getSMSCode(false)" class="getSMSButton">获取验证码</button>
          </label>
          <label>
            <input type="password" v-model="registerPassword" placeholder="您的密码"/>
          </label>
          <button type="button" @click="register" class="loginButton">注册</button>
        </form>
      </div>
      <div class="switchLoginPageContent">
        <div class="switchRegisterPageContent">
          <div class="switchLoginPageButton">
            <h2>注册成功或已有账号</h2>
            <p>点击下方按钮登陆账号</p>
            <button @click="switchToLogin">账号登陆</button>
          </div>
        </div>
        <img src="../assets/img/register.svg" alt="">
      </div>
    </div>
  </main>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { gsap } from 'gsap';
import axios from 'axios';
import { ElMessage } from 'element-plus';
import { setToken } from '@/stores/auth';
import { useRouter } from 'vue-router';

const router = useRouter();

const loginPhoneNumber = ref('');
const loginSMSCode = ref('');
const loginPassword = ref('');
const registerPhoneNumber = ref('');
const registerSMSCode = ref('');
const registerPassword = ref('');

const switchToRegister = () => {
  gsap.to('.round', { duration: 1, x: '200vw', rotation: 360 });
  gsap.to('main', { duration: 1, x: '-100vw' });
};

const switchToLogin = () => {
  gsap.to('.round', { duration: 1, x: '0vw', rotation: 0 });
  gsap.to('main', { duration: 1, x: '0vw' });
};

const login = () => {
  const data = JSON.stringify({
    phoneNumber: loginPhoneNumber.value,
    password: loginPassword.value,
    smsCode: loginSMSCode.value
  });

  axios.post(`${import.meta.env.VITE_BASE_URL}/login`, data, {
    headers: {
      'Content-Type': 'application/json'
    }
  })
      .then(response => {
        if (response.data.code === 200) {
          setToken(response.data.data.tokenValue);
          ElMessage({
            message: '登录成功',
            type: 'success'
          });
          router.push('/home/index');
        } else {
          ElMessage({
            message: response.data.msg,
            type: 'error'
          });
        }
      })
      .catch(() => {
        ElMessage.error('登陆失败，请稍后再试');
      });
};

const register = () => {
  const data = JSON.stringify({
    phoneNumber: registerPhoneNumber.value,
    password: registerPassword.value,
    smsCode: registerSMSCode.value
  });

  axios.post(`${import.meta.env.VITE_BASE_URL}/register`, data, {
    headers: {
      'Content-Type': 'application/json'
    }
  })
      .then(response => {
        if (response.data.code === 200) {
          ElMessage({
            message: '注册成功',
            type: 'success'
          });
          this.$router.push('/home');
        } else {
          ElMessage({
            message: response.data.msg,
            type: 'error'
          });
        }
      })
      .catch(() => {
        ElMessage.error('注册失败，请稍后再试');
      });
};

const getSMSCode = (isLogin) => {
  const phoneNumber = isLogin ? loginPhoneNumber.value : registerPhoneNumber.value;
  const data = JSON.stringify({ phoneNumber });

  axios.post(`${import.meta.env.VITE_BASE_URL}/getSMSCode`, data, {
    headers: {
      'Content-Type': 'application/json'
    }
  })
      .then(response => {
        ElMessage({
          message: response.data.msg,
          type: 'success'
        });
      })
      .catch(() => {
        ElMessage.error('获取验证码失败，请稍后再试');
      });
};

onMounted(() => {
  gsap.timeline({ paused: true });
});
</script>

<style scoped>

* {
  padding: 0;
  margin: 0;

}
:root {
  font-size: 16px;
}

main {
  display: flex;
  width: 500vw;
  height: 100vh;
  overflow: hidden; /* 禁止滚动条 */
}


.round {
  width: 200vh;
  height: 200vh;
  background-color: rgb(71, 134, 234);
  border-radius: 50%;
  position: relative;
  z-index: 1;
  transform: translate(-100vh, -100vh);
}
.loginPage {
  z-index: 2;
  float: left;
  width: 100vw;
  height: 100vw;
  position: absolute; /* 绝对定位 */
  display: flex;
}
.switchRegisterPage {
  width: 50vw;
  color: white;
  height: 50vh;
}
.switchRegisterPageContent {
  padding-left: 30vh;
  height: 50vh;
}
.switchRegisterPageButton {
  display: flex;
  flex-direction: column;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  position: absolute;
  transform: translateY(12vh);
}
.switchRegisterPageButton h2,
.switchRegisterPageButton p,
.switchRegisterPageButton button {
  margin-top: 10px;
  margin-bottom: 10px;
}
.switchRegisterPageButton button {
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 16px;
  color: white;
  background-color: transparent;
  border: 2px solid white;
  border-radius: 25px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
}
.switchRegisterPage img {
  height: 50vh;
}
.myForm {
  width: 50vw;
}
form {
  width: 500px;
  display: grid;
  box-shadow: 2.8px 2.8px 2.2px rgba(0, 0, 0, 0.02),
  6.7px 6.7px 5.3px rgba(0, 0, 0, 0.028),
  12.5px 12.5px 10px rgba(0, 0, 0, 0.035),
  22.3px 22.3px 17.9px rgba(0, 0, 0, 0.042),
  41.8px 41.8px 33.4px rgba(0, 0, 0, 0.05),
  100px 100px 80px rgba(0, 0, 0, 0.07);
  margin: 20% auto;
}
form h2 {
  font-size: 2.2rem;
  margin: 0 auto;
}
form input {
  border: 2px solid white;
  border-radius: 25px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #eeeeee;
  width: 80%;
}
form svg {
  width: 44px;
}
.getSMSInput {
  width: 57%;
  border-radius: 25px 0 0 25px;
}
.getSMSButton {
  width: 23%;
  height: 38px;
  color: white;
  border-radius: 0 25px 25px 0;
  border: 0px solid white;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: rgb(73, 131, 233);
}
.loginButton {
  padding: 10px 20px;
  color: white;
  background-color: rgb(73, 131, 233);
  border: 2px solid white;
  border-radius: 25px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
  width: 15%;
  margin: 0 auto 20px;
}
.registerPage {
  z-index: 2;
  display: flex;
}
.switchLoginPageContent {
  width: 50vw;
}
.switchLoginPageContent button {
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 16px;
  color: white;
  background-color: transparent;
  border: 2px solid white;
  border-radius: 25px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
}
.switchLoginPageContent div,
.switchLoginPageContent img {
  height: 50vh;
}
.switchLoginPageContent h2,
.switchLoginPageContent p,
.switchLoginPageContent button {
  margin-top: 10px;
  margin-bottom: 10px;
}
.switchLoginPageButton {
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  position: absolute;
  transform: translateX(50vh);
}

</style>

