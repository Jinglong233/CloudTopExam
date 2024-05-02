<template>
  <a-row class="grid-demo" style="backgroundcolor: var(--color-fill-2)">
    <a-col :span="16" :offset="4">
      <a-card>
        <a-descriptions
          :title="$t('menu.exam.examInfo')"
          :column="1"
          size="large"
          bordered
        >
          <a-descriptions-item label="考试名称">{{
            examInfo.title
          }}</a-descriptions-item>
          <a-descriptions-item label="考试总分">{{
            examInfo.totalCount
          }}</a-descriptions-item>
          <a-descriptions-item label="考试及格分数">{{
            examInfo.qualifyScore
          }}</a-descriptions-item>
          <a-descriptions-item label="考试时长">{{
            examInfo.duration
          }}</a-descriptions-item>

          <a-descriptions-item label="考试状态">
            <a-tag v-if="examInfo.statue === 0" color="grey">未开始</a-tag>
            <a-tag v-if="examInfo.statue === 1" color="green">正在进行</a-tag>
            <a-tag v-if="examInfo.statue === 2" color="red">已结束</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="考试类型">
            <a-tag v-if="examInfo.openType === 0" color="blue">完全开放</a-tag>
            <a-tag v-if="examInfo.openType === 1" color="orange"
              >指定学生</a-tag
            >
            <a-tag v-if="examInfo.openType === 2" color="green">指定部门</a-tag>
          </a-descriptions-item>
        </a-descriptions>
        <a-space style="margin-top: 20px">
          <a-button type="outline" @click="router.back()">返回</a-button>
          <template v-if="examInfo.statue === 2">
            <a-button type="primary" disabled>
              <template #icon>
                <icon-send />
              </template>
              已结束
            </a-button>
          </template>

          <template v-if="examInfo.statue === 0">
            <a-button type="primary" disabled>
              <template #icon>
                <icon-send />
              </template>
              未开始
            </a-button>
          </template>

          <template v-if="examInfo.statue === 1">
            <a-button
              v-if="examRecordInfo.state === 0"
              type="primary"
              @click="goStartExam"
            >
              <template #icon>
                <icon-send />
              </template>
              开始考试
            </a-button>
            <a-button
              v-if="examRecordInfo.state === 1"
              type="primary"
              @click="goStartExam"
            >
              <template #icon>
                <icon-send />
              </template>
              继续考试
            </a-button>
            <a-button
              v-if="examRecordInfo.state === 2"
              type="primary"
              @click="getExamResult"
            >
              <template #icon>
                <icon-send />
              </template>
              已提交
            </a-button>
          </template>
        </a-space>
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { onMounted, reactive, ref } from 'vue';
  import { useI18n } from 'vue-i18n';
  import { useRoute, useRouter } from 'vue-router';
  import { getExamById } from '@/api/exam';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { getExamRecord } from '@/api/examRecord';
  import { useUserStore } from '@/store';
  import { ExamRecord } from '@/types/model/po/ExamRecord';
  import dayjs from 'dayjs';
  import { Message } from '@arco-design/web-vue';
  import { ExamRecordQuery } from '@/types/model/query/ExamRecordQuery';

  const { t } = useI18n();

  const router = useRouter();
  const route = useRoute();

  const examInfo = ref<ExamVO>({});
  const examRecordInfo = ref<ExamRecord>({});
  const userStore = useUserStore();

  onMounted(async () => {
    const { examId } = route.params;
    if (!examId) {
      router.back();
    }

    await getExamById(examId as string).then((res: any) => {
      examInfo.value = res.data;
    });

    await getExamRecord({
      userId: userStore.id,
      examId: examInfo.value.id,
    } as ExamRecordQuery).then((res: any) => {
      examRecordInfo.value = res.data.list[0] as ExamRecord;
    });
  });

  const columns = [
    {
      title: t('myExam.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
    },
    {
      title: t('myExam.columns.duration'),
      dataIndex: 'duration',
      slotName: 'duration',
    },
    {
      title: t('myExam.columns.totalCount'),
      dataIndex: 'totalCount',
      slotName: 'totalCount',
    },
    {
      title: t('myExam.columns.qualifyScore'),
      dataIndex: 'qualifyScore',
      slotName: 'qualifyScore',
    },
    {
      title: t('myExam.columns.examTime'),
      dataIndex: 'examTime',
      slotName: 'examTime',
    },
    {
      title: t('myExam.columns.statue'),
      dataIndex: 'statue',
      slotName: 'statue',
    },
  ];

  const data = reactive([
    {
      key: '1',
      title: '测试考试',
      duration: 30,
      totalCount: 20,
      qualifyScore: 30,
      startTime: '2020-12-07 17:18:00',
      endTime: '2020-12-07 17:18:00',
      statue: '0',
    },
    {
      key: '2',
      title: '测试考试',
      duration: 30,
      totalCount: 20,
      qualifyScore: 30,
      startTime: '2020-12-07 17:18:00',
      endTime: '2020-12-07 17:18:00',
      statue: '1',
    },
    {
      key: '3',
      title: '测试考试',
      duration: 30,
      totalCount: 20,
      qualifyScore: 30,
      startTime: '2020-12-07 17:18:00',
      endTime: '2020-12-07 17:18:00',
      statue: '2',
    },
    {
      key: '4',
      title: '测试考试',
      duration: 30,
      totalCount: 20,
      qualifyScore: 30,
      startTime: '2020-12-07 17:18:00',
      endTime: '2020-12-07 17:18:00',
      statue: '1',
    },
    {
      key: '5',
      title: '测试考试',
      duration: 30,
      totalCount: 20,
      qualifyScore: 30,
      startTime: '2020-12-07 17:18:00',
      endTime: '2020-12-07 17:18:00',
      statue: '0',
    },
  ]);

  // 前往考试确认界面
  const goStartExam = async () => {
    // 如果lateMax是0，就代表随时都可以参加考试
    if (examInfo.value.lateMax === 0) {
      router.push({
        name: 'StartExam',
        params: {
          examId: examInfo.value.id,
        },
      });
    } else {
      // 首先得判断是否超过考试进入时间
      const lateTime = dayjs(examInfo.value.startTime);
      if (
        dayjs().isAfter(
          dayjs(lateTime).add(examInfo.value.lateMax as number, 'minute')
        )
      ) {
        // 如果超时，显示不能参加考试
        Message.warning({
          id: 'timeOut',
          content: '超过考试规定入考时间，禁止考试',
          duration: 2000,
        });
      } else {
        router.push({
          name: 'StartExam',
          params: {
            examId: examInfo.value.id,
          },
        });
      }
    }
  };

  // 已提交状态下，前往考试结果页面
  const getExamResult = () => {
    router.push({
      name: 'ExamResult',
      params: { examRecordId: examRecordInfo.value.id },
    });
  };
</script>

<style scoped></style>
