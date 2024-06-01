<template>
  <a-spin :loading="loading" style="width: 100%">
    <a-card class="general-card" :header-style="{ paddingBottom: '14px' }">
      <template #title>
        {{ $t('dataAnalysis.quTypeKnAnalysis') }}
      </template>
      <Chart style="width: 100%; height: 347px" :option="chartOption" />
    </a-card>
  </a-spin>
</template>

<script lang="ts" setup>
  import * as echarts from 'echarts';
  import { ScatterChart } from 'echarts/charts';
  import { ref } from 'vue';
  import useLoading from '@/hooks/loading';
  import { getKnowledgeList, getWrongCountSummary } from '@/api/dataAnalysis';
  import useChartOption from '@/hooks/chart-option';

  // 注册散点图组件
  // @ts-ignore
  echarts.use([ScatterChart]);

  const barX = ref([]);
  const quType = ['单选题', '多选题', '判断题', '填空题', '简答题'];
  const colorPalette = ['#93f576', '#8df8ff', '#00b2ff', '#307af3', '#246eff'];

  const thermalChartOptionsFactory = () => {
    const data = ref<any>([]);
    const { chartOption } = useChartOption(() => {
      return {
        grid: {
          top: 10,
          left: 70,
          right: 10,
          bottom: 50,
        },
        tooltip: {
          formatter: (params: any) => {
            return `知识点：${params.value[2]}<br/>题型：${params.value[1]}<br/>错题数量：${params.value[0]}`;
          },
        },
        xAxis: {
          type: 'value',
          name: '错题数量',
          axisLine: {
            show: true, // 显示 x 轴线
            lineStyle: {
              color: '#ccc', // 可以自定义颜色
            },
          },
          axisTick: {
            show: false, // 显示 x 轴刻度线
            alignWithLabel: false, // 刻度线与标签对齐
          },
        },
        yAxis: {
          type: 'category',
          data: quType,
          name: '题型',
          axisLine: {
            show: false, // 隐藏 y 轴线
          },
          axisTick: {
            show: false, // 隐藏 y 轴刻度线
          },
        },
        series: [
          {
            type: 'scatter',
            symbolSize: (d: any) => {
              return Math.sqrt(d[0]) * 5; // 根据错题数量设置散点大小
            },
            data,
            label: {
              emphasis: {
                show: true,
                formatter: (params: any) => {
                  return params.data.value[2];
                },
                position: 'top',
              },
            },
          },
        ],
      };
    });
    return {
      data,
      chartOption,
    };
  };

  const { loading, setLoading } = useLoading(true);
  const { chartOption: thermalChartOption, data: thermalData } =
    thermalChartOptionsFactory();
  const renderData = ref();

  const chartOption = ref({});

  // 获取数据
  const fetchData = async () => {
    try {
      const { data: xdata } = await getKnowledgeList();
      const { data } = await getWrongCountSummary();
      const temp = data.map((obj: any) => Object.values(obj));
      renderData.value = temp;
      renderData.value.forEach((item: any) => {
        const categoryIndex = Number(item[0]) - 1; // 将题型数字减去1，以与数组索引对应
        const knowledgePoint = item[1];
        const wrongQuestions = item[2];
        thermalData.value.push({
          value: [wrongQuestions, quType[categoryIndex], knowledgePoint],
          itemStyle: {
            color: colorPalette[categoryIndex % colorPalette.length], // 根据 x 轴的索引确定颜色
          } as any,
        });
      });
      chartOption.value = thermalChartOption.value;
      barX.value = xdata;
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  };
  fetchData();
</script>

<style scoped lang="less"></style>
