<template>
  <el-container>
    <el-header id="elHeader">
      <el-row>
        <el-col :span="18">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item>
              <a href="/home">promotion management</a>
            </el-breadcrumb-item>
            <el-breadcrumb-item>promotion list</el-breadcrumb-item>
            <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
          </el-breadcrumb>
        </el-col>
        <el-col :span="4" class="page-right">
          <el-avatar src="http://shanhai10241.test.upcdn.net/null/defoutAvatar.jpeg"></el-avatar>
          <el-badge class="item">
            <el-icon>
              <BellFilled/>
            </el-icon>
          </el-badge>
          <el-badge class="item" id="loginOut" @click="logout">
            <el-icon>
              <SwitchButton/>
            </el-icon>
          </el-badge>
        </el-col>
      </el-row>
    </el-header>
  </el-container>
</template>

<script>
import { BellFilled, SwitchButton } from '@element-plus/icons-vue';
import { ElMessage } from 'element-plus';
import {removeToken} from "@/stores/auth.js";

export default {
  name: 'Navbar',
  components: {SwitchButton, BellFilled},
  methods: {
    logout() {
      this.$router.push('/login');
      removeToken();
      ElMessage.success('用户退出成功');
    }
  }
};
</script>

<style scoped>
#elHeader {
  width: 100%;
  height: 40px;
  background-image: radial-gradient(transparent 1px, rgba(255, 255, 255, 0.16) 1px);
  background-size: 4px 4px;
  backdrop-filter: saturate(50%) blur(4px);
}

.page-right {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  margin-left: 90px;
}

.item {
  margin-left: 20px;
}
</style>
