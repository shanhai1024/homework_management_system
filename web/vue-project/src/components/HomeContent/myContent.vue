<template>
  <!-- 数据概览 -->
  <data-overview></data-overview>

  <!-- 数据分析图 -->
  <div class="legend">
    <div class="mainLegend">
      <div id="main" ref="chartDom"></div>
    </div>
    <div class="sideLegend"></div>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import DataOverview from "@/components/HomeContent/dataOverview.vue";
import * as echarts from 'echarts';

const chartDom = ref(null);

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
        {
          type: 'line',
          smooth: true,
          seriesLayoutBy: 'row',
          emphasis: { focus: 'series' }
        },
        {
          type: 'line',
          smooth: true,
          seriesLayoutBy: 'row',
          emphasis: { focus: 'series' }
        },
        {
          type: 'line',
          smooth: true,
          seriesLayoutBy: 'row',
          emphasis: { focus: 'series' }
        },
        {
          type: 'line',
          smooth: true,
          seriesLayoutBy: 'row',
          emphasis: { focus: 'series' }
        },
        {
          type: 'pie',
          id: 'pie',
          radius: '30%',
          center: ['50%', '25%'],
          emphasis: {
            focus: 'self'
          },
          label: {
            formatter: '{b}: {@2012} ({d}%)'
          },
          encode: {
            itemName: 'product',
            value: '2012',
            tooltip: '2012'
          }
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
            label: {
              formatter: '{b}: {@[' + dimension + ']} ({d}%)'
            },
            encode: {
              value: dimension,
              tooltip: dimension
            }
          }
        });
      }
    });

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
  height: 60vh;
  width: 65%;
  border: 1px salmon solid;
}
#main{
  width: 100%;
  height: 100%;
}
.sideLegend {
  height: 50vh;
  width: 28%;
  border: 1px #72fa92 solid;
}
</style>
