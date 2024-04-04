<template>
  <a-card :title="$t('menu.exam.myExam')">
    <a-table :columns="columns" :data="data">
      <template #options="{ record }">
        <a-button type="primary" @click="confirmGoExam(record)"
          >选择训练模式</a-button
        >
      </template>
    </a-table>
  </a-card>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { useI18n } from 'vue-i18n';
  import { useRouter } from 'vue-router';
  import { getRepoList } from '@/api/repo';

  const { t } = useI18n();

  const router = useRouter();

  const data = ref<[]>([]);

  onMounted(async () => {
    await getRepoList({ isTrain: 1 }).then((res: any) => {
      data.value = res.data;
    });
  });

  const columns = [
    {
      title: t('train.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
    },
    {
      title: t('train.columns.objCount'),
      dataIndex: 'objCount',
      slotName: 'objCount',
    },
    {
      title: t('train.columns.subCount'),
      dataIndex: 'subCount',
      slotName: 'subCount',
    },
    {
      title: t('train.columns.totalCount'),
      dataIndex: 'totalCount',
      slotName: 'totalCount',
    },
    {
      title: t('train.columns.remark'),
      dataIndex: 'remark',
      slotName: 'remark',
    },
    {
      title: t('train.columns.options'),
      dataIndex: 'options',
      slotName: 'options',
    },
  ];

  // 前往选择模式界面
  const confirmGoExam = (record: any) => {
    router.push({
      name: 'RepoDetail',
      params: {
        repoId: record.id,
      },
    });
  };
</script>

<style scoped></style>
