<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.correctExam']" />
    <a-card
      style="height: 650px"
      class="general-card"
      :title="$t('menu.exam.correctExam')"
    >
      <!--查询栏-->
      <a-space align="center">
        <!--考试标题-->
        <a-input
          v-model="examSearch.titleFuzzy"
          :placeholder="$t('examManager.placeholder.title')"
          style="width: 320px"
          @input="handleChange"
        />

        <!--开放类型-->
        <a-select
          v-model="examSearch.openType"
          :placeholder="$t('examManager.placeholder.openType')"
          style="width: 250px"
          allow-clear
          @change="handleChange"
        >
          <a-option value="0">完全公开</a-option>
          <a-option value="1">指定学生</a-option>
          <a-option value="2">指定部门</a-option>
        </a-select>

        <!--考试时间-->
        <a-space>
          <a-date-picker
            v-model="examSearch.startTimeStart"
            style="width: 220px; margin: 0 24px 24px 0"
            show-time
            :time-picker-props="{ defaultValue: '09:09:06' }"
            :placeholder="t('examManager.placeholder.startTime')"
            format="YYYY-MM-DD HH:mm:ss"
            @cancel="handleChange"
            @ok="handleChange"
          />
          <a-date-picker
            v-model="examSearch.endTimeEnd"
            style="width: 220px; margin: 0 24px 24px 0"
            show-time
            :placeholder="t('examManager.placeholder.endTime')"
            format="YYYY-MM-DD hh:mm"
            @cancel="handleChange"
            @ok="handleChange"
          />
        </a-space>
      </a-space>
      <a-divider style="margin-top: 0" />
      <a-table
        row-key="id"
        :loading="loading"
        :columns="columns"
        :data="ExamList"
        :bordered="false"
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
  import { onMounted, ref } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import {
    getCorrectExam,
    getCorrectExamByParam,
    getExamList,
  } from '@/api/exam';
  import { ExamQuery } from '@/types/model/query/ExamQuery';
  import { useUserStore } from '@/store';
  import { CorrectExamVO } from '@/types/model/vo/CorrectExamVO';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  const router = useRouter();
  const userStore = useUserStore();

  // 添加考试模态框开关
  const addExamVisible = ref<boolean>(false);

  // 考试列表
  const ExamList = ref<CorrectExamVO[]>();

  // 查询表单
  const examSearch = ref<ExamQuery>({});

  // 获取考试列表
  const reloadExamList = async (examQuery: ExamQuery) => {
    setLoading(true);
    await getExamList(examQuery).then((res: any) => {
      ExamList.value = res.data;
    });
    setLoading(false);
  };
  onMounted(async () => {
    // if (userStore.role === 'admin') {
    //   // 1. 如果是管理员可以查看所有阅卷
    //   await reloadExamList({});
    // } else if (userStore.role === 'teacher') {
    //   // 2. 教师只能获取自己创建的考试
    //   await reloadExamList({ createBy: userStore.id });
    // }

    await getCorrectExam(userStore.id as string).then((res: any) => {
      setLoading(true);
      ExamList.value = res.data;
      setLoading(false);
    });
  });

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

  // 查询考试
  const handleChange = async () => {
    examSearch.value.endTimeStart = '';
    examSearch.value.startTimeEnd = '';
    await getCorrectExamByParam(examSearch.value).then((res: any) => {
      ExamList.value = res.data;
    });
  };

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
