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

      <el-affix :offset="1">
        <MyPageHeader id="indexPageHeader"></MyPageHeader>
      </el-affix>
      <!--    主页面内容-->
      <router-view name="content"></router-view>
    </div>
  </div>
</template>

<style scoped>
#MyIndexHome {
  display: flex;
}
#myMenu {
  height: 100vh;
  position: sticky;
  left: 0;
}
el-affix{
  width: 100%;
}
#HomePage {
  overflow: auto;
  width: 100%;
  height: 100vh;

  margin-left: 20px;

}
#MyIndexHome{
  width: 100%;
}
my-page-header{
  width: 100%;
  top:30px;
  right:5px;
}
</style>
