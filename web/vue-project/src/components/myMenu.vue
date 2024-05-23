<template>
  <div w-260px>

    <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        :collapse="isCollapse"
        @open="handleOpen"
        @close="handleClose"
    >
      <!--    menu缩放开关-->

      <el-menu-item index="0">
        <div class="switch-container">
          <el-switch
              v-model="value1"
              :active-action-icon="Hide"
              :inactive-action-icon="View"
              @change="handleSwitchChange"
          />
        </div>
      </el-menu-item>
      <el-menu-item index="1">
        <el-icon><DataAnalysis /></el-icon>
        <template #title>主页</template>
      </el-menu-item>


      <el-menu-item index="2" >
        <el-icon><List /></el-icon>
        <template #title>人员信息</template>
      </el-menu-item>


      <el-menu-item index="3">
        <el-icon><setting /></el-icon>
        <template #title>职业管理</template>
      </el-menu-item>


      <el-sub-menu index="4">
        <template #title>
          <el-icon><location /></el-icon>
          <span>Navigator One</span>
        </template>
        <el-menu-item-group>
          <template #title><span>Group One</span></template>
          <el-menu-item index="1-1">item one</el-menu-item>
          <el-menu-item index="1-2">item two</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="Group Two">
          <el-menu-item index="1-3">item three</el-menu-item>
        </el-menu-item-group>
        <el-sub-menu index="1-4">
          <template #title><span>item four</span></template>
          <el-menu-item index="1-4-1">item one</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue';
import { Hide, List,View,DataAnalysis } from '@element-plus/icons-vue';

const value1 = ref(false);
const isCollapse = ref(false);

const handleSwitchChange = (newValue: boolean) => {
  console.log('Switch changed:', newValue);
  isCollapse.value = newValue;
};

const handleOpen = (key: string, keyPath: string[]) => {
  console.log('Menu opened:', key, keyPath);
};

const handleClose = (key: string, keyPath: string[]) => {
  console.log('Menu closed:', key, keyPath);
};

</script>

<style scoped>

.el-menu-vertical-demo:not(.el-menu--collapse) {
  min-height: 400px;
}
el-menu{
  height: 100vh;
}

.switch-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}
</style>
