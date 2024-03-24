<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.correctUserExam']" />
    <a-card
      style="height: 650px"
      class="general-card"
      :title="$t('menu.exam.correctList')"
    >
      <!--查询栏-->
      <a-space align="center">
        <!--考试标题-->
        <a-input
          v-model="examSearch.titleFuzzy"
          :placeholder="$t('correctManager.placeholder.title')"
          style="width: 320px"
          @input="handleChange"
        />

        <!--开放类型-->
        <a-select
          v-model="examSearch.openType"
          :placeholder="$t('correctManager.placeholder.openType')"
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
            :placeholder="t('correctManager.placeholder.startTime')"
            format="YYYY-MM-DD HH:mm:ss"
            @ok="handleChange"
          />
          <a-date-picker
            v-model="examSearch.endTimeEnd"
            style="width: 220px; margin: 0 24px 24px 0"
            show-time
            :placeholder="t('correctManager.placeholder.endTime')"
            format="YYYY-MM-DD hh:mm"
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
  import { onMounted, ref } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRoute, useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import {
    getCorrectExamByParam,
    getExamList,
    getExamRecordByExamId,
  } from '@/api/exam';
  import { ExamQuery } from '@/types/model/query/ExamQuery';
  import { useUserStore } from '@/store';
  import { CorrectUserExamUserVO } from '@/types/model/vo/CorrectUserExamUserVO';
  import { Message } from '@arco-design/web-vue';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  const router = useRouter();
  const route = useRoute();
  const userStore = useUserStore();
  const examId = ref();

  // 考试列表
  const ExamList = ref<CorrectUserExamUserVO[]>();

  // 查询表单
  const examSearch = ref<ExamQuery>({});

  onMounted(async () => {
    examId.value = route.params.examId;

    // 获取该考试对应的考试人员记录
    await getExamRecordByExamId(examId.value as string).then((res: any) => {
      setLoading(true);
      ExamList.value = res.data;
      setLoading(false);
    });
  });

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

  // 查询考试
  const handleChange = async () => {
    examSearch.value.endTimeStart = '';
    examSearch.value.startTimeEnd = '';
    await getCorrectExamByParam(examSearch.value).then((res: any) => {
      ExamList.value = res.data;
    });
  };

  // 前往该用户作答的详情页
  const goCorrect = (examRecord: any) => {
    if (examRecord.state === 2 || examRecord.handState === 1) {
      router.push({
        name: 'CorrectUserPaper',
        params: {
          examRecordId: examRecord.id,
        },
      });
    } else if (examRecord.state === 0) {
      Message.warning({
        content: '该考生未开始作答',
        duration: 2000,
      });
    } else if (examRecord.state === 1) {
      Message.warning({
        content: '该考生未作答完',
        duration: 2000,
      });
    }
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
