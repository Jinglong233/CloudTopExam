<template>
  <a-card :title="$t('menu.exam.myExam')">
    <a-table :columns="columns" :data="data" @row-click="confirmGoExam">
      <template #options>
        <a-button type="text">
          <template #icon> <icon-play-circle /></template>
          继续训练
        </a-button>
      </template>
    </a-table>
  </a-card>
</template>

<script lang="ts" setup>
  import { reactive, toRaw } from 'vue';
  import { useI18n } from 'vue-i18n';
  import { useRouter } from 'vue-router';

  const { t } = useI18n();

  const router = useRouter();

  const columns = [
    {
      title: t('train.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
    },
    {
      title: t('train.columns.mode'),
      dataIndex: 'mode',
      slotName: 'mode',
    },
    {
      title: t('train.columns.recentTime'),
      dataIndex: 'recentTime',
      slotName: 'recentTime',
    },
    {
      title: t('train.columns.rightCount'),
      dataIndex: 'rightCount',
      slotName: 'rightCount',
    },
    {
      title: t('train.columns.percent'),
      dataIndex: 'percent',
      slotName: 'percent',
    },
    {
      title: t('train.columns.accuracy'),
      dataIndex: 'accuracy',
      slotName: 'accuracy',
    },
    {
      title: t('train.columns.options'),
      dataIndex: 'options',
      slotName: 'options',
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
</script>

<style scoped></style>
