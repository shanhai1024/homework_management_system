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
import { onMounted, ref } from 'vue';
import DataOverview from "@/components/HomeContent/dataOverview.vue";
import * as echarts from 'echarts';

const chartDom = ref(null);
const chartDom2 = ref(null);
const chartDom3 = ref(null);

// 总体数据浏览
onMounted(() => {
  if (chartDom.value) {
    const myChart = echarts.init(chartDom.value);
    const option = {
      legend: {},
      tooltip: {
        trigger: 'axis',
        showContent: false
      },
      dataset: {
        source: [
          ['年份', '2012', '2013', '2014', '2015', '2016', '2017'],
          ['学生', 56.5, 82.1, 88.7, 70.1, 53.4, 300.1],
          ['教师', 51.1, 51.4, 55.1, 53.3, 73.8, 68.7],
          ['物业', 40.1, 62.2, 69.5, 36.4, 45.2, 32.5],
          ['经营者', 25.2, 37.1, 41.2, 18, 33.9, 49.1],
          ['其他', 25.2, 37.1, 41.2, 18, 33.9, 49.1]
        ]
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
});
// 学生人数
onMounted(() => {
  if (chartDom2.value) {
    const myChart = echarts.init(chartDom2.value);
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
              value: 60,
              itemStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [
                  { offset: 0, color: '#8E2DE2' },
                  { offset: 1, color: '#4A00E0' }
                ])
              }
            },
            { value: 40, itemStyle: { color: '#E0E0E0' } }
          ]
        }
      ]
    };
    myChart.setOption(option);
  }
});

// 教师人数
onMounted(() => {
  if (chartDom3.value) {
    const myChart = echarts.init(chartDom3.value);
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
              value: 40,
              itemStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [
                  { offset: 0, color: '#FF6F61' },
                  { offset: 1, color: '#D84315' }
                ])
              }
            },
            { value: 60, itemStyle: { color: '#E0E0E0' } }
          ]
        }
      ]
    };
    myChart.setOption(option);
  }
});

// 其他人数
onMounted(() => {
  if (chartDom4.value) {
    const myChart = echarts.init(chartDom4.value);
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
              value: 70,
              itemStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [
                  { offset: 0, color: '#00C853' },
                  { offset: 1, color: '#B2FF59' }
                ])
              }
            },
            { value: 30, itemStyle: { color: '#E0E0E0' } }
          ]
        }
      ]
    };
    myChart.setOption(option);
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
