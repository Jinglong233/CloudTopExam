<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.correctUserExam']" />
    <a-card
      style="height: 650px"
      class="general-card"
      :title="$t('menu.exam.correctList')"
    >
      <!--查询栏-->
      <a-space align="center" style="margin-bottom: 10px">
        <!--作答状态-->
        <a-select
          v-model="correctSearch.state"
          placeholder="请选择作答状态"
          style="width: 250px"
          allow-clear
        >
          <a-option value="0">未作答</a-option>
          <a-option value="1">未完成</a-option>
          <a-option value="2">已交卷</a-option>
        </a-select>

        <!--阅卷状态-->
        <a-select
          v-model="correctSearch.handState"
          placeholder="请选择阅卷状态"
          style="width: 250px"
          allow-clear
        >
          <a-option value="0">未处理</a-option>
          <a-option value="1">已处理</a-option>
        </a-select>

        <!--异常状态-->
        <a-select
          v-model="correctSearch.exState"
          placeholder="请选择异常状态"
          style="width: 250px"
          allow-clear
        >
          <a-option value="0">正常</a-option>
          <a-option value="1">异常</a-option>
        </a-select>

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
      </a-space>
      <a-divider style="margin-top: 0" />
      <a-table
        row-key="id"
        :loading="loading"
        :columns="columns"
        :data="ExamList"
        :bordered="false"
        :scrollbar="true"
        :pagination="{
          showTotal: true,
          showPageSize: true,
          total: pagination.total,
          pageSize: pagination.pageSize,
          current: pagination.pageNo,
        }"
        :scroll="{ x: 100, y: 400 }"
        @page-change="pageChange"
        @page-size-change="pageSizeChange"
      >
        <template #openType="{ record }">
          <template v-if="record.exam.openType === 0">完全公开</template>
          <template v-if="record.exam.openType === 1">指定学生</template>
        </template>

        <template #examTime="{ record }">
          {{ record.examRecord.startTime }} ~ {{ record.examRecord.endTime }}
        </template>

        <template #answerState="{ record }">
          <a-tag v-if="record.examRecord.state === 0" color="red">未作答</a-tag>
          <a-tag v-if="record.examRecord.state === 1" color="orange"
            >正在作答</a-tag
          >
          <a-tag v-if="record.examRecord.state === 2" color="green"
            >已提交</a-tag
          >
        </template>

        <template #handState="{ record }">
          <a-tag v-if="record.examRecord.handState === 0" color="#168cff"
            >未处理</a-tag
          >
          <a-tag v-if="record.examRecord.handState === 1" color="#00b42a"
            >已处理</a-tag
          >
        </template>

        <template #exState="{ record }">
          <a-tag
            v-if="
              record.examRecord.exState === 0 ||
              record.examRecord.exState === null
            "
            color="green"
            >正常</a-tag
          >
          <a-tag
            v-if="record.examRecord.exState === 1"
            color="#f53f3f
"
            >异常</a-tag
          >
        </template>

        <template #option="{ record }">
          <a-space>
            <a-button type="primary" @click="goCorrect(record.examRecord)">
              {{ $t('correctManager.columns.options.goCorrect') }}
            </a-button>
          </a-space>
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
  import { getExamRecordByExamId } from '@/api/exam';
  import { useUserStore } from '@/store';
  import { CorrectUserExamUserVO } from '@/types/model/vo/CorrectUserExamUserVO';
  import { Message } from '@arco-design/web-vue';
  import ExamRecordQuery from '@/types/model/query/ExamRecordQuery';
  import usePagination from '@/hooks/pagination';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  const router = useRouter();
  const route = useRoute();
  const userStore = useUserStore();
  const examId = ref();

  // 考试列表
  const ExamList = ref<CorrectUserExamUserVO[]>();

  // 查询表单
  const correctSearch = ref<ExamRecordQuery>({} as ExamRecordQuery);

  const reloadCorrectList = async (examRecordQuery: ExamRecordQuery) => {
    // 获取该考试对应的考试人员记录
    await getExamRecordByExamId({
      examId: examId.value,
      ...examRecordQuery,
    }).then((res: any) => {
      setLoading(true);
      ExamList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
      setLoading(false);
    });
  };

  onMounted(async () => {
    examId.value = route.params.examId;
    await reloadCorrectList(correctSearch.value);
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    correctSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    correctSearch.value.pageSize = pageSize;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('correctManager.columns.userName'),
      dataIndex: 'userName',
      slotName: 'userName',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('correctManager.columns.startTime'),
      dataIndex: 'examRecord.startTime',
      slotName: 'startTime',
      width: 200,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('correctManager.columns.endTime'),
      dataIndex: 'examRecord.endTime',
      slotName: 'endTime',
      width: 200,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('correctManager.columns.answerState'),
      dataIndex: 'examRecord.state',
      slotName: 'answerState',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('correctManager.columns.totalCount'),
      dataIndex: 'paper.totalCount',
      slotName: 'totalCount',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('correctManager.columns.statue'),
      dataIndex: 'examRecord.handState',
      slotName: 'handState',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('correctManager.columns.exState'),
      dataIndex: 'examRecord.exState',
      slotName: 'exState',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('correctManager.columns.options'),
      dataIndex: 'option',
      slotName: 'option',
      width: 200,
      ellipsis: true,
    },
  ]);

  // 前往该用户作答的详情页
  const goCorrect = (examRecord: any) => {
    // 判断是否作答（未作答的记录，不允许批阅，防止报缺失userAnswerId错误）
    if (examRecord.state === 0) {
      Message.info({
        content: '考生未作答不允许批阅',
        duration: 2000,
      });
      return;
    }

    if (examRecord.state === 2 || examRecord.handState === 1) {
      router.push({
        name: 'CorrectUserPaper',
        params: {
          examRecordId: examRecord.id,
        },
      });
    } else if (examRecord.state === 1) {
      Message.warning({
        content: '该考生未作答完',
        duration: 2000,
      });
    }
  };

  // 搜索
  const search = async () => {
    await reloadCorrectList(correctSearch.value);
  };

  // 重置
  const reset = async () => {
    correctSearch.value = new ExamRecordQuery();
    correctSearch.value.examId = examId.value as string;
    pagination.value = new SimplePage();
    await reloadCorrectList(correctSearch.value);
  };

  // 监视页码变化
  watch(
    () => [correctSearch.value.pageNo, correctSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadCorrectList(correctSearch.value);
    }
  );
</script>

<style scoped lang="less">
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
</style>
