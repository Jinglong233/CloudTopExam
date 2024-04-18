<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.record']" />
    <a-card
      class="general-card"
      :title="$t('menu.exam.record')"
      style="height: 680px"
    >
      <!--查询栏-->
      <a-space align="center" style="margin-bottom: 10px">
        <!--是否通过-->
        <a-select
          v-model="examRecordSearch.passed"
          placeholder="是否通过"
          style="width: 250px"
          allow-clear
        >
          <a-option value="0">未通过</a-option>
          <a-option value="1">通过</a-option>
        </a-select>

        <!--异常状态-->
        <a-select
          v-model="examRecordSearch.exState"
          placeholder="选择异常状态"
          style="width: 250px"
          allow-clear
        >
          <a-option value="0">正常</a-option>
          <a-option value="1">异常</a-option>
        </a-select>

        <!--作答状态-->
        <a-select
          v-model="examRecordSearch.state"
          placeholder="选择作答状态"
          style="width: 250px"
          allow-clear
        >
          <a-option value="0">未作答</a-option>
          <a-option value="1">未完成</a-option>
          <a-option value="2">已交卷</a-option>
        </a-select>
      </a-space>
      <a-divider style="margin-top: 0" />
      <a-table
        row-key="id"
        :loading="loading"
        :columns="columns"
        :data="ExamRecordList"
        :bordered="false"
        :scrollbar="true"
        :pagination="{
          showTotal: true,
          showPageSize: true,
          total: pageInfo.total,
          pageSize: pageInfo.pageSize,
          current: pageInfo.pageNo,
        }"
        :scroll="{ x: 100, y: 400 }"
        @page-change="pageChange"
        @page-size-change="pageSizeChange"
      >
        <template #passed="{ record }">
          <a-tag v-if="record.passed === 0" color="red">未通过</a-tag>
          <a-tag v-if="record.passed === 1" color="green">通过</a-tag>
        </template>
        <template #exState="{ record }">
          <a-tag v-if="record.exState === 0" color="blue">正常</a-tag>
          <a-tag v-if="record.exState === 1" color="red">异常</a-tag>
        </template>

        <template #answerTime="{ record }">
          {{ record.answerTime ? record.answerTime : 0 }}分钟
        </template>

        <template #state="{ record }">
          <a-tag v-if="record.state === 0" color="red">未作答</a-tag>
          <a-tag v-if="record.state === 1" color="blue">未完成</a-tag>
          <a-tag v-if="record.state === 2" color="green">已交卷</a-tag>
        </template>

        <template #option="{ record }">
          <a-button type="primary" @click="getRecordDetail(record)">
            {{ $t('examManager.columns.options.detail') }}
          </a-button>
        </template>
      </a-table>
    </a-card>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRoute, useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { getExamRecord } from '@/api/exam';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { SimplePage } from '@/types/model/po/SimplePage';
  import { ExamRecordQuery } from '@/types/model/query/ExamRecordQuery';
  import { ExamRecordVO } from '@/types/model/vo/ExamRecordVO';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  const currentExam = ref<ExamVO>({});

  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  const router = useRouter();
  const route = useRoute();

  const examId = ref();

  // 考试记录列表
  const ExamRecordList = ref<ExamRecordVO[]>();

  // 查询表单
  const examRecordSearch = ref<ExamRecordQuery>({});

  // 获取考试列表
  const reloadExamList = async (examRecordQuery: ExamRecordQuery) => {
    setLoading(true);
    await getExamRecord(examRecordQuery).then((res: any) => {
      ExamRecordList.value = res.data.list;
      pageInfo.value.total = res.data.totalCount;
      pageInfo.value.pageSize = res.data.pageSize;
      pageInfo.value.pageNo = res.data.pageNo;
      pageInfo.value.pageTotal = res.data.pageTotal;
    });
    setLoading(false);
  };
  onMounted(async () => {
    examId.value = route.params.examId;
    if (examId.value) {
      await reloadExamList({ examId: examId.value, ...pageInfo.value });
    } else {
      router.back();
    }
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('examManager.columns.userName'),
      dataIndex: 'userName',
      slotName: 'userName',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.passed'),
      dataIndex: 'passed',
      slotName: 'passed',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('examManager.columns.totalScore'),
      dataIndex: 'totalScore',
      slotName: 'totalScore',
      width: 200,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.exState'),
      dataIndex: 'exState',
      slotName: 'exState',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.exMsg'),
      dataIndex: 'exMsg',
      slotName: 'exMsg',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.state'),
      dataIndex: 'state',
      slotName: 'state',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.answerTime'),
      dataIndex: 'answerTime',
      slotName: 'answerTime',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.options'),
      dataIndex: 'option',
      slotName: 'option',
      width: 200,
      ellipsis: true,
    },
  ]);

  // 获取答卷详情
  const getRecordDetail = (record: any) => {
    console.log('recordId', record);
    router.push({
      name: 'ExamRecordDetail',
      params: {
        examRecordId: record.id,
      },
    });
  };

  // 监视查询数据及其页码变化
  watch(
    [pageInfo.value, examRecordSearch.value],
    async (
      [newPageInfo, oldPageInfo],
      [newExamRecordSearch, oldExamRecordSearch]
    ) => {
      await reloadExamList({ ...pageInfo.value, ...examRecordSearch.value });
    },
    { deep: true }
  );
</script>

<style scoped lang="less">
  .arco-modal-simple .arco-modal-header {
    margin-bottom: 0;
  }
  .container {
    padding: 0 20px 20px 20px;
  }

  :deep(.arco-table-th) {
    &:last-child {
      .arco-table-th-item-title {
        margin-left: 16px;
      }
    }
  }

  .action-icon {
    margin-left: 12px;
    cursor: pointer;
  }

  .active {
    color: #0960bd;
    background-color: #e3f4fc;
  }

  .setting {
    display: flex;
    align-items: center;
    width: 200px;

    .title {
      margin-left: 12px;
      cursor: pointer;
    }
  }

  .icon-hover {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 24px;
    height: 24px;
    border-radius: 50%;
    transition: all 0.1s;
  }

  .icon-hover:hover {
    background-color: rgb(var(--gray-2));
  }

  .arco-image-img {
    margin-top: 85px;
  }
</style>
