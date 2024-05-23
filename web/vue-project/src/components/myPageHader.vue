<template>
  <el-container >
    <el-header>

      <el-row>
        <el-col  :span="12">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
            <el-breadcrumb-item>
              <a href="/">promotion management</a>
            </el-breadcrumb-item>
            <el-breadcrumb-item>promotion list</el-breadcrumb-item>
            <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
          </el-breadcrumb>
        </el-col>
        <el-col :span="12" class="align-right">
          <el-avatar src="path/to/avatar.jpg"></el-avatar>
          <el-badge :value="5" class="item">
            <el-icon><BellFilled /></el-icon>
          </el-badge>
        </el-col>
      </el-row>
    </el-header>
  </el-container>
</template>

<script>
import { BellFilled} from '@element-plus/icons-vue';
export default {
  name: 'Navbar',
};
</script>

<style scoped>
.align-right {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}
.item {
  margin-left: 10px;
}
</style>
