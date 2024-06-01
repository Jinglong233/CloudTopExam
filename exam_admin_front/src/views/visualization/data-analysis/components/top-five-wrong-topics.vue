<template>
  <a-spin :loading="loading" style="width: 100%">
    <a-card :bordered="false" :style="cardStyle">
      <div class="content-wrap" style="width: 100%">
        <div class="content" style="width: 55%">
          <a-statistic
            :title="title"
            :value="renderData.count"
            :value-from="0"
            animation
            show-group-separator
          />
          <div class="desc">
            <a-typography-text type="secondary" class="label">
              {{ $t('dataAnalysis.card.statisticalTime') }}
            </a-typography-text>
            <a-typography-text type="danger">
              {{ renderData.statisticalTime }}
              <icon-clock-circle />
            </a-typography-text>
          </div>
        </div>
        <div class="chart" style="width: 45%">
          <Chart v-if="!loading" :option="chartOption" />
        </div>
      </div>
    </a-card>
  </a-spin>
</template>

<script lang="ts" setup>
  import { CSSProperties, PropType, ref } from 'vue';
  import useLoading from '@/hooks/loading';
  import useChartOption from '@/hooks/chart-option';
  import { getTopFiveWrongTopics } from '@/api/dataAnalysis';

  const barX = ref([]);
  const barChartOptionsFactory = () => {
    const data = ref<any>([]);
    const { chartOption } = useChartOption(() => {
      return {
        grid: {
          left: 0,
          right: 0,
          top: 10,
          bottom: 0,
        },
        xAxis: {
          type: 'category',
          show: false,
          data: barX,
        },
        yAxis: {
          show: false,
        },
        tooltip: {
          show: true,
          trigger: 'axis',
        },
        series: {
          name: '错题数量',
          data,
          type: 'bar',
          barWidth: 7,
          itemStyle: {
            borderRadius: 2,
          },
        },
      };
    });
    return {
      data,
      chartOption,
    };
  };

  const props = defineProps({
    title: {
      type: String,
      default: '',
    },
    cardStyle: {
      type: Object as PropType<CSSProperties>,
      default: () => {
        return {};
      },
    },
  });

  const { loading, setLoading } = useLoading(true);
  const { chartOption: barChartOption, data: barData } =
    barChartOptionsFactory();
  const renderData = ref({
    count: 0,
    date: 0,
    chartData: [],
  });
  const chartOption = ref({});
  // 获取数据
  const fetchData = async () => {
    try {
      const { data } = await getTopFiveWrongTopics();
      renderData.value = data;
      const { chartData } = data;
      // 柱状图
      chartData.forEach((v: any) => {
        barData.value.push({
          value: v.value,
          itemStyle: {
            color: v.value % 2 ? '#2CAB40' : '#86DF6C',
          },
        });
      });
      chartOption.value = barChartOption.value;
      barX.value = chartData.map((item: any) => item.name);
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  };
  fetchData();
</script>

<style scoped lang="less">
  :deep(.arco-card) {
    border-radius: 4px;
  }
  :deep(.arco-card-body) {
    width: 100%;
    height: 134px;
    padding: 0;
  }
  .content-wrap {
    width: 100%;
    padding: 16px;
    white-space: nowrap;
  }
  :deep(.content) {
    float: left;
    width: 108px;
    height: 102px;
  }
  :deep(.arco-statistic) {
    .arco-statistic-title {
      font-weight: bold;
      font-size: 16px;
      white-space: nowrap;
    }
    .arco-statistic-content {
      margin-top: 10px;
    }
  }

  .chart {
    float: right;
    width: calc(100% - 108px);
    height: 90px;
    vertical-align: bottom;
  }

  .label {
    padding-right: 8px;
    font-size: 12px;
  }
</style>
