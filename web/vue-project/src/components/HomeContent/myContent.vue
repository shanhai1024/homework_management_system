<template>
  <!-- 数据概览 -->
  <data-overview></data-overview>

  <!-- 数据分析图 -->
  <div class="legend">
    <div class="mainLegend">
      <h2 style="color:#606266;">数据概览</h2>
      <div id="main" ref="chartDom"></div>
    </div>
    <!-- 实时人数 -->
    <div class="sideLegend">
      <h2 style="color:#606266;">人数占比</h2>
      <div class="numberOfPeopleRatio">
        <div id="numberOfStudents" class="numberOfPeopleRatioEcharts" ref="chartDom2"></div>
        <div class="proportionData">
          <h3 class="studentProportion">学生占比</h3>
          <span>已登记人数</span>
          <p>1234</p>
        </div>
      </div>
      <div class="numberOfPeopleRatio">
        <div id="numberOfTeachers" class="numberOfPeopleRatioEcharts" ref="chartDom3"></div>
        <div class="proportionData">
          <h3 class="teacherProportion">老师占比</h3>
          <span>已登记人数</span>
          <p>1234</p>
        </div>
      </div>
      <div class="numberOfPeopleRatio">
        <div id="numberOfBusiness" class="numberOfPeopleRatioEcharts" ref="chartDom4"></div>
        <div class="proportionData">
          <h3 class="businessProportion">营业者占比</h3>
          <span>已登记人数</span>
          <p>1234</p>
        </div>
      </div>
      <div class="numberOfPeopleRatio">
        <div id="numberOfOthers" class="numberOfPeopleRatioEcharts" ref="chartDom5"></div>
        <div class="proportionData">
          <h3 class="otherProportion">其他</h3>
          <span>已登记人数</span>
          <p>1234</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref, watch } from 'vue';
import DataOverview from "@/components/HomeContent/dataOverview.vue";
import * as echarts from 'echarts';
import axios from 'axios';
import { ElMessage } from "element-plus";

const props= defineProps(
    {

      chartsData :{
        type: Array,
        required:true
      }
    }

)
// 数据响应引用
const responseData = ref(null);
const chartDom = ref(null);
const chartDom2 = ref(null);
const chartDom3 = ref(null);
const chartDom4 = ref(null);
const chartDom5 = ref(null);

// 异步获取数据
const fetchData = async () => {
  let config = {
    method: 'get',
    maxBodyLength: Infinity,
    url: 'http://127.0.0.1:8080/api/v1/echartsData',
    headers: {
      'token': 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblR5cGUiOiJsb2dpbiIsImxvZ2luSWQiOjEsInJuU3RyIjoiQVFkQ0UxM3lXRjFLZFZrbzdiN0tURm5xUHRHSmlEaEYifQ.LxTpvKbYV4zf5DctnhvLM8GMw97ELml4XAyRN8o2EEM',
    },
    data: ''
  };

  try {
    const response = await axios.request(config);
    console.log("响应数据:", response.data);
    responseData.value = response.data;
  } catch (error) {
    console.log(error);
    ElMessage.error('数据获取失败请检查网络连接或者联系管理员');
  }
};

// 初始化主图表
const initMainChart = () => {
  if (chartDom.value && responseData.value) {
    const myChart = echarts.init(chartDom.value);
    const option = {
      legend: {},
      tooltip: {
        trigger: 'axis',
        showContent: false
      },
      dataset: {
        source: responseData.value
      },
      xAxis: { type: 'category' },
      yAxis: { gridIndex: 0 },
      grid: { top: '55%' },
      series: [
        { type: 'line', smooth: true, seriesLayoutBy: 'row', name: '学生' },
        { type: 'line', smooth: true, seriesLayoutBy: 'row', name: '教师' },
        { type: 'line', smooth: true, seriesLayoutBy: 'row', name: '物业' },
        { type: 'line', smooth: true, seriesLayoutBy: 'row', name: '经营者' },
        { type: 'line', smooth: true, seriesLayoutBy: 'row', name: '其他' },
        {
          type: 'pie',
          id: 'pie',
          radius: '30%',
          center: ['50%', '25%'],
          emphasis: { focus: 'self' },
          label: { formatter: '{b}: {@2012} ({d}%)' },
          encode: { itemName: '年份', value: '2012', tooltip: '2012' }
        }
      ]
    };

    myChart.on('updateAxisPointer', function (event) {
      const xAxisInfo = event.axesInfo[0];
      if (xAxisInfo) {
        const dimension = xAxisInfo.value + 1;
        myChart.setOption({
          series: {
            id: 'pie',
            label: { formatter: '{b}: {@[' + dimension + ']} ({d}%)' },
            encode: { value: dimension, tooltip: dimension }
          }
        });
      }
    });

    myChart.setOption(option);
  }
};

// 初始化副图表
const initSideChart = (chartDom, data, colors) => {
  if (chartDom && data) {
    const myChart = echarts.init(chartDom);
    const option = {
      series: [
        {
          type: 'pie',
          radius: ['70%', '90%'],
          avoidLabelOverlap: false,
          label: {
            show: true,
            position: 'center',
            formatter: data+'%',
            fontSize: 20
          },
          data: [
            {
              value: data,
              itemStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 1, 1, colors)
              }
            },
            { value: 100 - data, itemStyle: { color: '#E0E0E0' } }
          ]
        }
      ]
    };
    myChart.setOption(option);

    // Add mouseover event listener
    myChart.on('mouseover', function (params) {
      if (params.componentType === 'series') {
        const newValue = (params.dataIndex === 0) ? 10 : 90; // Example modification
        myChart.setOption({
          series: [{
            data: [
              { value: newValue, itemStyle: { color: new echarts.graphic.LinearGradient(0, 0, 1, 1, colors) } },
              { value: 100 - newValue, itemStyle: { color: '#E0E0E0' } }
            ]
          }]
        });
      }
    });

    // Add mouseout event listener to reset data
    myChart.on('mouseout', function (params) {
      if (params.componentType === 'series') {
        myChart.setOption({
          series: [{
            data: [
              { value: data, itemStyle: { color: new echarts.graphic.LinearGradient(0, 0, 1, 1, colors) } },
              { value: 100 - data, itemStyle: { color: '#E0E0E0' } }
            ]
          }]
        });
      }
    });
  }
};

onMounted(() => {
  fetchData();
});

watch(responseData, (newVal) => {
  if (newVal) {
    initMainChart();
    // 初始化副图表
    initSideChart(chartDom2.value, 70, [
      { offset: 0, color: '#4facfe' },
      { offset: 1, color: '#00f2fe' }
    ]);  // 学生人数比例
    initSideChart(chartDom3.value, 50, [
      { offset: 0, color: '#f78ca0' },
      { offset: 1, color: '#fe9a8b' }
    ]);  // 教师人数比例
    initSideChart(chartDom4.value, 20, [
      { offset: 0, color: '#84fab0' },
      { offset: 1, color: '#8fd3f4' }
    ]);  // 营业者人数比例
    initSideChart(chartDom5.value, 5, [
      { offset: 0, color: '#fccb90' },
      { offset: 1, color: '#d57eeb' }
    ]);  // 其他人数比例
  }
});
</script>

<style scoped>
.legend {
  margin-top: 20px;
  display: flex;
}
.mainLegend {
  height: 90vh;
  width: 65%;
  box-shadow: 0px 10px 15px -3px rgba(0,0,0,0.1);
  margin-right: 20px;
}
#main{
  width: 100%;
  height: 500px;
}
.sideLegend {
  height: 60vh;
  width: 35%;
  //border: 1px #72fa92 solid;
  box-shadow: 0px 10px 15px -3px rgba(0,0,0,0.1);
}
.sideLegend h2{
  margin-left: 50px;
}

.numberOfPeopleRatio{
  box-shadow: 0px 10px 15px -3px rgba(0,0,0,0.1);
  display: flex;
  height: 10vh;
  margin-bottom: 20px;
}

.numberOfPeopleRatioEcharts{
  height: 100%;
  width: 20vh;
}

.proportionData{
  margin-left: 90px;
  height: 10px;
}
.proportionData h3{
  font-size: 25px;
}
.proportionData span{
  font-size: 12px;
  color: #bcbbbb;
}
.proportionData p{
  font-size: 20px;
  color:#909399 ;
}

.proportionData h3,p {
  margin: 0;
  padding: 0;
}

.studentProportion{
  background-image: linear-gradient(to right, #4facfe 0%, #00f2fe 100%);
  -webkit-background-clip: text;
  color: transparent;
}
.teacherProportion{
  background-image: linear-gradient(to right, #f78ca0 0%, #f9748f 19%, #fd868c 60%, #fe9a8b 100%);
  -webkit-background-clip: text;
  color: transparent;
}

.businessProportion{
  background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
  -webkit-background-clip: text;
  color: transparent;
}
.otherProportion{
  background-image: linear-gradient(120deg, #fccb90 0%, #d57eeb 100%);
  -webkit-background-clip: text;
  color: transparent;
}
</style>
