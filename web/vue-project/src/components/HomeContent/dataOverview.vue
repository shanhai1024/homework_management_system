<template>
  <div>
    <h2 style="color:#606266;">实时人数统计</h2>
    <div class="boxes">
      <div class="box1 dataDisplay">
        <div class="data">
          <h2>总人数</h2>
          <h1>{{ overviewData.total }}</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="((overviewData.total / overviewData.total) * 100).toFixed(2)" class="white-progress" />
          </div>
        </div>
      </div>
      <div class="box2 dataDisplay">
        <div class="data">
          <h2>学生人数</h2>
          <h1>{{ overviewData.students }}</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="((overviewData.students / overviewData.total) * 100).toFixed(2)" class="white-progress" />
          </div>
        </div>
      </div>
      <div class="box3 dataDisplay">
        <div class="data">
          <h2>老师人数</h2>
          <h1>{{ overviewData.teachers }}</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="((overviewData.teachers / overviewData.total) * 100).toFixed(2)" class="white-progress" />
          </div>
        </div>
      </div>
      <div class="box4 dataDisplay">
        <div class="data">
          <h2>其他服务人员</h2>
          <h1>{{ overviewData.others +overviewData.operator}}</h1>
          <span size="small">人</span>
          <div class="progress-container">
            <el-progress :percentage="((overviewData.others /(overviewData.others +overviewData.operator)) * 100).toFixed()" class="white-progress" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    overviewData: {
      type: Object,
      required: true
    }
  }
};
</script>

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
