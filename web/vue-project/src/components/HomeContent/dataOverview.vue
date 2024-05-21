<script>
export default {
  name: "dataOverview"
}
</script>

<template>
  <div>
    <h2>实时人数统计</h2>
    <div class="boxes">
      <div class="box1 dataDisplay">
        <div class="data">
          <h2>总人数</h2>
          <h1>10086</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="50" class="white-progress" />
          </div>
        </div>
      </div>
      <div class="box2 dataDisplay">
        <div class="data">
          <h2>总人数</h2>
          <h1>10086</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="50" class="white-progress" />
          </div>
        </div>
      </div>
      <div class="box3 dataDisplay">
        <div class="data">
          <h2>总人数</h2>
          <h1>10086</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="50" class="white-progress" />
          </div>
        </div>
      </div>
      <div class="box4 dataDisplay">
        <div class="data">
          <h2>总人数</h2>
          <h1>10086</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="50" class="white-progress" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.boxes {
  color: white;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-template-rows: 150px;
  grid-gap: 30px;
}
.dataDisplay {
  box-shadow: 0px 10px 15px -3px rgba(0,0,0,0.1);
  border-radius: 15px;
  padding: 20px;
}
.dataDisplay h1 {
  display: inline-block;
  margin: 5px;
}
.dataDisplay h2 {
  margin: 5px;
}
.white-progress .el-progress-bar__inner {
  background-color: white;
}
.white-progress .el-progress-bar__outer {
  background-color: rgba(255, 255, 255, 0.2);
}
.box1 {
  background-image: linear-gradient(120deg, #96e6a1 0%, #d4fc79 100%);
}
.box2 {
  background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
}
.box3 {
  background-image: linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%);
}
.box4 {
  background-image: linear-gradient(to right, #fa709a 0%, #fee140 100%);
}
</style>
