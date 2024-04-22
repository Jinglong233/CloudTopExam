<template>
  <div>
    <a-card :title="$t('menu.train.trainRecord')">
      <a-table
        :columns="columns"
        :data="trainRecordList"
        :pagination="{
          showTotal: true,
          showPageSize: true,
          total: pageInfo.total,
          pageSize: pageInfo.pageSize,
          current: pageInfo.pageNo,
        }"
        :scroll="{ x: 100, y: 550 }"
        @page-change="pageChange"
        @page-size-change="pageSizeChange"
      >
        <template #percent="{ record }">
          <a-tag color="green">{{ record.percent }}%</a-tag>
        </template>

        <template #state="{ record }">
          <a-tag v-if="record.state === 0" color="red">未完成</a-tag>
          <a-tag v-if="record.state === 1" color="skyblue">已完成</a-tag>
        </template>

        <template #options="{ record }">
          <a-button
            type="primary"
            :disabled="record.state === 1"
            color="red"
            @click="
              router.push({
                name: 'StartTrain',
                params: {
                  trainId: record.id,
                },
              })
            "
            >继续训练</a-button
          >
        </template>
      </a-table>
    </a-card>
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import { useRouter } from 'vue-router';
  import { TrainRecord } from '@/types/model/po/TrainRecord';
  import { getTrain } from '@/api/train';
  import { TrainQuery } from '@/types/model/query/TrainQuery';
  import { SimplePage } from '@/types/model/po/SimplePage';
  import { Message } from '@arco-design/web-vue';
  import { useUserStore } from '@/store';

  const { t } = useI18n();

  const router = useRouter();

  const userStore = useUserStore();

  const trainRecordList = ref<TrainRecord[]>([]);

  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });
  const reloadRecordList = async (trainQuery: TrainQuery) => {
    await getTrain(trainQuery).then((res: any) => {
      if (res) {
        trainRecordList.value = res.data.list;
        pageInfo.value.total = res.data.totalCount;
        pageInfo.value.pageSize = res.data.pageSize;
        pageInfo.value.pageNo = res.data.pageNo;
        pageInfo.value.pageTotal = res.data.pageTotal;
      } else {
        Message.warning({
          content: res.data.info,
          duration: 2000,
        });
      }
    });
  };

  onMounted(async () => {
    await reloadRecordList({ userId: userStore.id, ...pageInfo.value });
  });
  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
  };

  // 监视页码变化
  watch(pageInfo.value, async (newPageInfo, oldPageInfo) => {
    await reloadRecordList({ userId: userStore.id, ...pageInfo.value });
  });
  const columns = [
    {
      title: t('train.columns.trainTime'),
      dataIndex: 'trainTime',
      slotName: 'trainTime',
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
      title: t('train.columns.state'),
      dataIndex: 'state',
      slotName: 'state',
    },
    {
      title: t('train.columns.options'),
      dataIndex: 'options',
      slotName: 'options',
    },
  ];
</script>

<style scoped></style>
