<template>
  <div w-260px>
    <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        :collapse="isCollapse"
        @open="handleOpen"
        @close="handleClose"
    >
      <el-menu-item index="0">
        <div class="switch-container">
          <el-switch
              v-model="value1"
              :active-action-icon="View"
              :inactive-action-icon="Hide"
              @change="handleSwitchChange"
          />
        </div>
      </el-menu-item>
      <el-sub-menu index="1">
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
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <template #title>Navigator Two</template>
      </el-menu-item>
      <el-menu-item index="3" disabled>
        <el-icon><document /></el-icon>
        <template #title>Navigator Three</template>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <template #title>Navigator Four</template>
      </el-menu-item>
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
import { Hide, View } from '@element-plus/icons-vue';

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

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  min-height: 400px;
}

.switch-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}
</style>
