<template>
  <!-- 数据概览 -->
  <data-overview></data-overview>

  <!-- 数据分析图 -->
  <div class="legend">
    <div class="mainLegend">
      <h2>数据概览</h2>
      <div id="main" ref="chartDom"></div>
    </div>
    <div class="sideLegend">
      <!-- 实时人数 -->
      <h2>人数占比</h2>
      <div id="numberOfStudents" ref="chartDom2"></div>
      <div id="numberOfTeachers" ref="chartDom3"></div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref, watch } from 'vue';
import DataOverview from "@/components/HomeContent/dataOverview.vue";
import * as echarts from 'echarts';
import axios from 'axios';
import { ElMessage } from "element-plus";

// 数据响应引用
const responseData = ref(null);
const chartDom = ref(null);
const chartDom2 = ref(null);
const chartDom3 = ref(null);

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
const initSideChart = (chartDom, data) => {
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
            formatter: '{d}%',
            fontSize: 20
          },
          data: [
            {
              value: data,
              itemStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [
                  { offset: 0, color: '#8E2DE2' },
                  { offset: 1, color: '#4A00E0' }
                ])
              }
            },
            { value: 100 - data, itemStyle: { color: '#E0E0E0' } }
          ]
        }
      ]
    };
    myChart.setOption(option);
  }
};

onMounted(() => {
  fetchData();
});

watch(responseData, (newVal) => {
  if (newVal) {
    initMainChart();
    // 初始化副图表
    initSideChart(chartDom2.value, 60);  // 假设学生人数比例
    initSideChart(chartDom3.value, 40);  // 假设教师人数比例
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
//border: 1px salmon solid;
  box-shadow: 0px 10px 15px -3px rgba(0,0,0,0.1);
  margin-right: 20px;
}
#main{
  width: 100%;
  height: 700px;
}
.sideLegend {
  height: 60vh;
  width: 35%;
  border: 1px #72fa92 solid;
  box-shadow: 0px 10px 15px -3px rgba(0,0,0,0.1);
}
#numberOfStudents, #numberOfTeachers {
  height: 30vh;
  width: 100%;
}
</style>
