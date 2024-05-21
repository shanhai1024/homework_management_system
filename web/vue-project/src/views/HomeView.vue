<script setup>
import MyMenu from "@/components/myMenu.vue";
import MyPageHeader from "@/components/myPageHader.vue";
import Homepage from "@/views/nestedPages/homepageContent.vue";
</script>

<template>
  <div id="MyIndexHome">
    <!-- 菜单 -->
    <div id="myMenu">
      <MyMenu></MyMenu>
    </div>

    <!-- 主页 -->
    <div id="HomePage">
      <!-- 页头 -->
      <div id="myPageHeader">
        <MyPageHeader></MyPageHeader>
      </div>

      <!-- 页面内容 -->
      <div id="pageContent">
        <Homepage></Homepage>
      </div>
    </div>
  </div>
</template>

<style scoped>
#MyIndexHome {
  display: flex;
}

/* 固定菜单在页面左侧 */
#myMenu {
  position: fixed;
  top: 0;
  left: 0;
  height: 100vh;
  width: 200px; /* 根据需要调整宽度 */
  overflow-y: auto; /* 如果菜单内容超过视口高度，启用滚动 */
}

/* 调整主页内容的位置，使其不被固定菜单覆盖 */
#HomePage {
  margin-left: 200px; /* 调整以匹配菜单的宽度 */
  width: calc(100% - 200px);
}

/* 固定页头在页面顶部 */
#myPageHeader {
  position: fixed;
  top: 0;
  left: 200px; /* 调整以匹配菜单的宽度 */
  width: calc(100% - 200px);
  z-index: 10; /* 确保页头在内容上方 */
  background-color: white; /* 设置背景颜色，避免内容滚动时透出 */
}

/* 页面内容区域设置为可滚动 */
#pageContent {
  margin-top: 60px; /* 调整以匹配页头的高度 */
  padding: 20px;
  overflow-y: auto;
  height: calc(100vh - 60px); /* 调整以匹配页头的高度 */
}
</style>
