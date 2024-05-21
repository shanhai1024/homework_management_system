<template>
  <el-page-header :icon="null" class="page-header">
    <template #content>
      <div class="flex items-center">
        <el-avatar
            :size="32"
            class="mr-3"
            src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
        />
        <span class="text-large font-600 mr-3">Title</span>
        <span class="text-sm mr-2" style="color: var(--el-text-color-regular)">
          Sub title
        </span>
        <el-tag>Default</el-tag>
      </div>
    </template>
    <template #extra>
      <div class="flex items-center">
        <el-button>Print</el-button>
        <el-button type="primary" class="ml-2">Edit</el-button>
      </div>
    </template>
  </el-page-header>
</template>

<style scoped>
.page-header {
  /* 设置毛玻璃效果的背景 */
  background-color: rgba(255, 255, 255, 0.6); /* 半透明白色背景 */
  backdrop-filter: blur(10px); /* 毛玻璃效果 */
  -webkit-backdrop-filter: blur(10px); /* 兼容 Safari */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 轻微阴影 */
  padding: 20px; /* 内边距 */
  border-radius: 8px; /* 圆角 */
}

/* 调整内容的对齐方式和布局 */
.flex {
  display: flex;
  align-items: center;
}

.items-center {
  align-items: center;
}

.mr-3 {
  margin-right: 1rem;
}

.ml-2 {
  margin-left: 0.5rem;
}

.text-large {
  font-size: 1.25rem;
}

.font-600 {
  font-weight: 600;
}

.text-sm {
  font-size: 0.875rem;
}
</style>
