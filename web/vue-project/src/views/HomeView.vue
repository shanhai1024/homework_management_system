<script setup>
import MyMenu from "@/components/myMenu.vue";
import MyPageHeader from "@/components/myPageHader.vue";
</script>

<template>
  <div id="MyIndexHome">
    <!--  菜单-->
    <div id="myMenu">
      <MyMenu></MyMenu>
    </div>

    <!--  主页-->
    <div id="HomePage">
      <!--    页头-->
      <MyPageHeader></MyPageHeader>

      <!--    主页面内容-->
      <router-view name="content"></router-view> <!-- 使用了名为 content 的 router-view -->
    </div>
  </div>
</template>

<style scoped>
#MyIndexHome {
  display: flex;
}
#myMenu {
  height: 100vh;
}
#HomePage {
  width: 100%;
  height: 100vh;
  margin-left: 20px;
}
</style>
