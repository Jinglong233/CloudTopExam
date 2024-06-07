<template>
  <a-spin :loading="loading">
    <a-card
      :class="
        !data.chartData || data.chartData.length <= 0
          ? 'height150'
          : 'height400'
      "
      :bordered="false"
      style="padding: 0 !important"
      :style="cardStyle"
    >
      <a-empty
        v-if="!data.chartData || data.chartData.length <= 0"
        description="无学科分析数据"
      />
      <template v-else>
        <Chart
          v-if="!loading"
          style="width: 1050px; height: 400px"
          :option="chartOption"
        />
      </template>
    </a-card>
  </a-spin>
</template>

<script lang="ts" setup>
  import * as echarts from 'echarts';
  import { CSSProperties, onMounted, PropType, ref, watch } from 'vue';
  import useLoading from '@/hooks/loading';
  import useChartOption from '@/hooks/chart-option';
  import { getErrorKnowledge } from '@/api/studentAnswer';
  import { TitleComponent } from 'echarts/components';

  // @ts-ignore
  echarts.use([TitleComponent]);
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
  const barX = ref([]);
  const barChartOptionsFactory = () => {
    const data = ref<any>([]);
    const { chartOption } = useChartOption(() => {
      return {
        grid: {
          top: 20,
          bottom: 50,
          left: 20,
          right: 0,
        },
        title: {
          show: true,
          text: props.title,
        },
        xAxis: {
          type: 'category',
          show: true,
          data: barX,
        },
        yAxis: {
          show: true,
        },
        tooltip: {
          show: true,
          trigger: 'axis',
        },
        series: {
          name: '错题数量',
          data,
          type: 'bar',
        },
      };
    });
    return {
      data,
      chartOption,
    };
  };

  const { loading, setLoading } = useLoading(true);
  const { chartOption: barChartOption, data: barData } =
    barChartOptionsFactory();
  const renderData = ref({
    count: 0,
    date: 0,
    chartData: [],
  });
  const chartOption = ref({});
  const data = ref<any>({});
  // 获取数据
  const fetchData = async () => {
    setLoading(true);
    try {
      await getErrorKnowledge().then((res: any) => {
        data.value = res.data;
      });
      renderData.value = data.value;
      const { chartData } = data.value;
      // 柱状图
      chartData.forEach((v: any, index: number) => {
        barData.value.push({
          value: v.value,
          itemStyle: {
            color: index % 2 ? '#2f7dfc' : '#81e2ff',
          },
        });
      });
      chartOption.value = barChartOption.value;
      barX.value = chartData.map((item: any) => item.name);
      setLoading(false);
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  };
  onMounted(() => {
    fetchData();
  });
</script>

<style scoped lang="less">
  .height150 {
    width: 400px;
    height: 150px;
  }

  .height400 {
    width: 450px;
    height: 450px;
  }
</style>
