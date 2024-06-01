<template>
  <a-spin :loading="loading">
    <a-card
      :class="
        !data.chartData || data.chartData.length <= 0
          ? 'height150'
          : 'height400'
      "
      :bordered="false"
      :style="cardStyle"
    >
      <a-empty
        v-if="!data.chartData || data.chartData.length <= 0"
        description="无知识点分析数据"
      />
      <template v-else>
        <Chart
          v-if="!loading"
          style="width: 400px; height: 400px"
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
  import { getWrongDeptWrongKn } from '@/api/dataAnalysis';
  import { ToolboxComponent } from 'echarts/components';

  // @ts-ignore
  echarts.use([ToolboxComponent]);

  const props = defineProps({
    deptCode: {
      type: String,
      default: 'A01',
    },
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
  const barChartOptionsFactory = () => {
    const data = ref<any>([]);
    const { chartOption } = useChartOption(() => {
      return {
        title: {
          show: true,
          text: props.title,
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>知识点 : {b}<br/>错题数量 : {c}<br/>占比 : {d}%',
        },
        legend: {
          top: 'bottom',
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            saveAsImage: { show: true },
          },
        },
        series: [
          {
            name: '错题占比',
            type: 'pie',
            radius: [25, 125],
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 8,
            },
            data,
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
  const { chartOption: pieChartOption, data: pieData } =
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
      await getWrongDeptWrongKn(props.deptCode).then((res: any) => {
        data.value = res.data;
      });
      renderData.value = data.value;
      const { chartData } = data.value;
      // 环形图
      chartData.forEach((el: any) => {
        pieData.value.push(el);
      });
      chartOption.value = pieChartOption.value;
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
  watch(
    () => props.deptCode,
    async (newValue, oldValue) => {
      // 清除原来的数据
      pieData.value = [];
      chartOption.value = {};
      fetchData();
    }
  );
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
