<template>
  <a-card
    style="height: 800px; margin: 0 20px"
    class="general-card"
    title="错题统计"
  >
    <a-row :gutter="5">
      <!--题目内容-->
      <a-col :span="6">
        <a-input
          v-model="bookSearch.quContentFuzzy"
          placeholder="请输入题目内容"
          style="width: 250px"
        />
      </a-col>
      <!--学科-->
      <a-col :span="6">
        <a-tree-select
          v-model="bookSearch.subjectId"
          :data="subjectTree"
          :field-names="{
            key: 'id',
            title: 'title',
            children: 'children',
          }"
          style="width: 250px"
          placeholder="请选择学科"
          allow-clear
        />
      </a-col>
      <!--题型-->
      <a-col :span="6">
        <a-select
          v-model="bookSearch.quType"
          placeholder="请选择题型"
          style="width: 250px"
          allow-clear
        >
          <a-option value="1">单选题</a-option>
          <a-option value="2">多选题</a-option>
          <a-option value="3">判断题</a-option>
          <a-option value="4">填空题</a-option>
          <a-option value="5">简答题</a-option>
        </a-select>
      </a-col>
    </a-row>
    <div style="margin: 10px 0" />
    <a-row :gutter="5">
      <!--知识点-->
      <a-col :span="6">
        <a-input
          v-model="bookSearch.knContentFuzzy"
          placeholder="请输入知识点"
          allow-clear
          style="width: 250px"
        />
      </a-col>
      <!--搜索重置按钮-->
      <a-col :span="6">
        <a-button type="primary" style="margin: 0 5px" @click="search">
          <template #icon>
            <icon-search />
          </template>
          搜索
        </a-button>
        <a-button type="primary" style="margin: 0 5px" @click="reset">
          <template #icon>
            <icon-refresh />
          </template>
          重置
        </a-button>
      </a-col>
    </a-row>
    <a-divider />

    <ErrorQuList
      :all-question="errorQuList"
      :loading="loading"
      @reload="resetSort"
      @desc="descSort"
      @asce="asceSort"
    />
    <a-pagination
      style="float: right"
      :show-total="true"
      :show-page-size="true"
      :total="pagination.total"
      :page-size="pagination.pageSize"
      :current="pagination.pageNo"
      @change="pageChange"
      @page-size-change="pageSizeChange"
    />
  </a-card>
</template>

<script setup lang="ts">
  import { onMounted, ref, watch } from 'vue';
  import { ErrorVO } from '@/types/model/vo/ErrorVO';
  import { getErrorCount } from '@/api/exam';
  import { useUserStore } from '@/store';
  import ErrorQuList from '@/views/errorSet/component/errorQuList.vue';
  import usePagination from '@/hooks/pagination';
  import BookQuery from '@/types/model/query/BookQuery';
  import SimplePage from '@/types/model/po/SimplePage';
  import { getSubjectTree } from '@/api/subject';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';

  const userStore = useUserStore();
  const loading = ref(false);

  // 学科树
  const subjectTree = ref<SubjectTreeVO[]>([]);

  const { pagination, setPagination } = usePagination();
  // 错题列表
  const errorQuList = ref<ErrorVO[]>([]);

  // 搜索条件
  const bookSearch = ref<BookQuery>(new BookQuery());

  const reloadErrorList = async (bookQuery: BookQuery) => {
    loading.value = true;
    await getErrorCount(bookQuery).then((res: any) => {
      errorQuList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
      loading.value = false;
    });
  };
  onMounted(async () => {
    await reloadErrorList({
      pageSize: 10,
      pageNo: 1,
    });
    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
    });
  });
  // 页码变化
  const pageChange = (pageNo: number) => {
    bookSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    bookSearch.value.pageSize = pageSize;
  };

  const resetSort = async () => {
    await reloadErrorList(bookSearch.value);
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

  // 搜索
  const search = async () => {
    await reloadErrorList(bookSearch.value);
  };

  // 重置
  const reset = async () => {
    bookSearch.value = new BookQuery();
    pagination.value = new SimplePage();
    await reloadErrorList(bookSearch.value);
  };

  // 监视页码变化
  watch(
    () => [bookSearch.value.pageNo, bookSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadErrorList(bookSearch.value);
    }
  );
</script>

<style scoped></style>
