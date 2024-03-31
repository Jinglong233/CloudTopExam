<template>
  <a-card :title="$t('menu.exam.myExam')">
    <a-table :columns="columns" :data="data" @row-click="confirmGoExam">
      <template #examTime="{ record }">
        {{ record.startTime }} ~ {{ record.endTime }}
      </template>
      <template #statue="{ record }">
        <a-tag v-if="record.statue === '0'">未开始</a-tag>
        <a-tag v-if="record.statue === '1'" color="green">进行中</a-tag>
        <a-tag v-if="record.statue === '2'" color="red">已结束</a-tag>
      </template>
    </a-table>
  </a-card>
</template>

<script lang="ts" setup>
  import { onMounted, reactive } from 'vue';
  import { useI18n } from 'vue-i18n';
  import { useRouter } from 'vue-router';
  import { getRepoList } from '@/api/repo';

  const { t } = useI18n();

  const router = useRouter();

  onMounted(async () => {
    await getRepoList({ isTrain: 1 }).then((res: any) => {
      console.log('123', res.data);
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

  // 前往选择模式界面
  const confirmGoExam = (record: any) => {
    router.push({
      path: '/train/repo-detail',
      query: record.id,
    });
  };
</script>

<style scoped></style>
