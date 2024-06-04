<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.correctExam']" />
    <a-card
      style="height: 650px"
      class="general-card"
      :title="$t('menu.exam.correctExam')"
    >
      <!--查询栏-->
      <div>
        <a-row :gutter="5" style="margin-bottom: 16px">
          <!--考试标题-->
          <a-col :span="6">
            <a-input
              v-model="examSearch.titleFuzzy"
              :placeholder="$t('examManager.placeholder.title')"
              style="width: 250px"
            />
          </a-col>
          <!--开放类型-->
          <a-col :span="6">
            <a-select
              v-model="examSearch.openType"
              :placeholder="$t('examManager.placeholder.openType')"
              style="width: 250px"
              allow-clear
            >
              <a-option value="0">完全公开</a-option>
              <a-option value="1">指定学生</a-option>
              <a-option value="2">指定部门</a-option>
            </a-select>
          </a-col>
        </a-row>
        <a-row :gutter="5" style="margin-bottom: 16px">
          <!--考试时间-->
          <a-col :span="6">
            <a-date-picker
              v-model="examSearch.startTimeStart"
              style="width: 250px"
              show-time
              :time-picker-props="{ defaultValue: '09:09:06' }"
              :placeholder="t('examManager.placeholder.startTime')"
              format="yyyy-MM-dd HH:mm:ss"
            />
          </a-col>
          <a-col :span="6">
            <a-date-picker
              v-model="examSearch.endTimeEnd"
              style="width: 250px"
              show-time
              :placeholder="t('examManager.placeholder.endTime')"
              format="yyyy-MM-dd HH:mm:ss"
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
      </div>
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
          {{ record.exam.startTime }} ~ {{ record.exam.endTime }}
        </template>

        <template #statue="{ record }">
          <a-tag v-if="record.exam.statue === 0" color="red">未开始</a-tag>
          <a-tag v-if="record.exam.statue === 1" color="blue">已开始</a-tag>
          <a-tag v-if="record.exam.statue === 2" color="green">已结束</a-tag>
        </template>

        <template #option="{ record }">
          <a-space>
            <a-button type="primary" @click="goCorrectList(record.exam.id)">
              {{ $t('examManager.columns.options.goCorrectList') }}
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
  import { useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { getCorrectExam } from '@/api/exam';
  import ExamQuery from '@/types/model/query/ExamQuery';
  import { useUserStore } from '@/store';
  import { CorrectExamVO } from '@/types/model/vo/CorrectExamVO';
  import usePagination from '@/hooks/pagination';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  const router = useRouter();
  const userStore = useUserStore();

  // 考试列表
  const ExamList = ref<CorrectExamVO[]>();

  // 查询表单
  const examSearch = ref<ExamQuery>({} as ExamQuery);

  const reloadCorrectExam = async (examQuery: ExamQuery) => {
    // todo 这里后续添加了批阅关联表之后，应该使用review_user
    if (userStore.role === 'teacher') {
      examQuery.createBy = userStore.id;
    }
    await getCorrectExam({ ...examQuery, createBy: userStore.id }).then(
      (res: any) => {
        setLoading(true);
        ExamList.value = res.data.list;
        setPagination({
          total: res.data.totalCount,
          pageSize: res.data.pageSize,
          pageNo: res.data.pageNo,
          pageTotal: res.data.pageTotal,
        });
        setLoading(false);
      }
    );
  };

  onMounted(async () => {
    await reloadCorrectExam(examSearch.value);
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    examSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    examSearch.value.pageSize = pageSize;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('examManager.columns.title'),
      dataIndex: 'exam.title',
      slotName: 'title',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.openType'),
      dataIndex: 'exam.openType',
      slotName: 'openType',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('examManager.columns.examTime'),
      dataIndex: 'examTime',
      slotName: 'examTime',
      width: 300,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.statue'),
      dataIndex: 'exam.statue',
      slotName: 'statue',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.correctTotal'),
      dataIndex: 'correctTotal',
      slotName: 'correctTotal',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.examTotal'),
      dataIndex: 'examTotal',
      slotName: 'examTotal',
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

  // 前往考试对应的批阅列表
  const goCorrectList = (examId: string) => {
    router.resolve({
      name: 'CorrectUserExam',
      params: {
        examId,
      },
    });
    window.open(`/exam/correct-user-list/${examId}`, '_black');
  };

  // 搜索
  const search = async () => {
    await reloadCorrectExam(examSearch.value);
  };

  // 重置
  const reset = async () => {
    examSearch.value = new ExamQuery();
    pagination.value = new SimplePage();
    await reloadCorrectExam(examSearch.value);
  };

  // 监视页码变化
  watch(
    () => [examSearch.value.pageNo, examSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadCorrectExam(examSearch.value);
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
