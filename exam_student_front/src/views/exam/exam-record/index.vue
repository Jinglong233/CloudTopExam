<template>
  <a-row class="grid-demo" style="backgroundcolor: var(--color-fill-2)">
    <a-col :span="16" :offset="4">
      <a-card :title="$t('menu.exam.examRecord')">
        <a-table :columns="columns" :data="recordList">
          <template #examTime="{ record }">
            {{ record.startTime }} ~ {{ record.endTime }}
          </template>
          <template #passed="{ record }">
            <a-tag v-if="record.passed === 0" color="red">未通过</a-tag>
            <a-tag v-if="record.passed === 1" color="green">已通过</a-tag>
          </template>
          <template #handState="{ record }">
            <a-tag v-if="record.handState === 0" color="red">未阅</a-tag>
            <a-tag v-if="record.handState === 1" color="green">已阅</a-tag>
          </template>
          <template #state="{ record }">
            <a-tag v-if="record.state === 1" color="red">未完成</a-tag>
            <a-tag v-if="record.state === 2" color="green">已交卷</a-tag>
          </template>
        </a-table>
      </a-card>
    </a-col>
  </a-row>
</template>

<script setup lang="ts">
  import { onMounted, ref } from 'vue';
  import { ExamRecord } from '@/types/model/po/ExamRecord';
  import { getAnsweredRecord } from '@/api/examRecord';
  import { useUserStore } from '@/store';
  import { useI18n } from 'vue-i18n';

  const { t } = useI18n();

  const userStore = useUserStore();
  const recordList = ref<ExamRecord[]>([]);

  const reloadRecordList = async (userId: string) => {
    await getAnsweredRecord(userId as string).then((res: any) => {
      recordList.value = res.data;
    });
  };

  onMounted(async () => {
    await reloadRecordList(userStore.id as string);
  });

  const columns = [
    {
      title: t('myExam.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
    },
    {
      title: t('myExam.columns.passed'),
      dataIndex: 'passed',
      slotName: 'passed',
    },
    {
      title: t('myExam.columns.totalScore'),
      dataIndex: 'totalScore',
      slotName: 'totalScore',
    },
    {
      title: t('myExam.columns.handState'),
      dataIndex: 'handState',
      slotName: 'handState',
    },
    {
      title: t('myExam.columns.statue'),
      dataIndex: 'state',
      slotName: 'state',
    },
  ];
</script>

<style scoped></style>
