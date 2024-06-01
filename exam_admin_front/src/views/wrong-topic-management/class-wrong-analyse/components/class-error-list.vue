<template>
  <a-skeleton :loading="loading" :animation="true">
    <a-space direction="vertical" :style="{ width: '100%' }" size="large">
      <a-skeleton-line :rows="5" />
    </a-space>
  </a-skeleton>
  <a-empty
    v-if="!errorQuList || errorQuList.length <= 0"
    description="无错题数据"
  />
  <ErrorQuList
    :all-question="errorQuList"
    @reload="resetSort"
    @desc="descSort"
    @asce="asceSort"
  />
  <a-pagination
    v-if="errorQuList && errorQuList.length > 0"
    style="float: right"
    :show-total="true"
    :show-page-size="true"
    :total="pagination.total"
    :page-size="pagination.pageSize"
    :current="pagination.pageNo"
    @change="pageChange"
    @page-size-change="pageSizeChange"
  />
</template>

<script setup lang="ts">
  import { onMounted, ref, watch } from 'vue';
  import { errorCount } from '@/api/dataAnalysis';
  import useLoading from '@/hooks/loading';
  import usePagination from '@/hooks/pagination';
  import ErrorCountQuery from '@/types/model/query/ErrorCountQuery';
  import ErrorQuList from '@/views/wrong-topic-management/class-wrong-analyse/components/errorQuList.vue';

  const { loading, setLoading } = useLoading();

  const props = defineProps({
    deptCode: {
      type: String,
      default: () => {
        return 'A01';
      },
    },
  });
  const errorQuList = ref([]);
  const { pagination, setPagination } = usePagination();
  const search = ref<ErrorCountQuery>({
    deptCode: props.deptCode,
  } as ErrorCountQuery);
  const reloadErrorList = async (arg: ErrorCountQuery) => {
    setLoading(true);
    await errorCount(arg).then((res: any) => {
      errorQuList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
    });
    setLoading(false);
  };
  onMounted(async () => {
    await reloadErrorList(search.value);
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    search.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    search.value.pageSize = pageSize;
  };

  // 正确次数升序排列
  const asceSort = () => {
    errorQuList.value.sort((a: any, b: any) => {
      return a.book.wrongCount - b.book.wrongCount;
    });
  };

  // 正确次数降序排列
  const descSort = () => {
    errorQuList.value.sort((a: any, b: any) => {
      return b.book.wrongCount - a.book.wrongCount;
    });
  };

  // 重置
  const resetSort = async () => {
    search.value = new ErrorCountQuery();
    search.value.deptCode = props.deptCode;
    await reloadErrorList(search.value);
  };

  // 监视页码变化
  watch(
    () => [search.value.pageNo, search.value.pageSize],
    async (newValue, oldValue) => {
      await reloadErrorList(search.value);
    }
  );

  // 监视页码变化
  watch(
    () => props.deptCode,
    async (newValue, oldValue) => {
      search.value = new ErrorCountQuery();
      search.value.deptCode = props.deptCode;
      await reloadErrorList(search.value);
    }
  );
</script>

<style scoped></style>
