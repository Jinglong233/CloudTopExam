<template>
  <a-card :title="$t('menu.exam.myExam')">
    <a-table :columns="columns" :data="myExamList" @row-click="confirmGoExam">
      <template #examTime="{ record }">
        {{ record.startTime }} ~ {{ record.endTime }}
      </template>
      <template #statue="{ record }">
        <a-tag v-if="record.statue === 0">未开始</a-tag>
        <a-tag v-if="record.statue === 1" color="green">进行中</a-tag>
        <a-tag v-if="record.statue === 2" color="red">已结束</a-tag>
      </template>
    </a-table>
  </a-card>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { useI18n } from 'vue-i18n';
  import { useRouter } from 'vue-router';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { getExamListByUserId } from '@/api/exam';
  import { useUserStore } from '@/store';

  const { t } = useI18n();

  const router = useRouter();

  const userStore = useUserStore();

  const myExamList = ref<ExamVO[]>([]);

  onMounted(async () => {
    await getExamListByUserId(userStore.id as string).then((res: any) => {
      myExamList.value = res.data;
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

  // 前往考试确认界面
  const confirmGoExam = (record: any) => {
    router.push({
      name: 'ExamInfo',
      params: { examId: record.id },
    });
  };
</script>

<style scoped></style>
