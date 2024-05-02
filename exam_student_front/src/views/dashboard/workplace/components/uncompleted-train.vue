<template>
  <a-spin :loading="loading" style="width: 100%">
    <a-card
      title="未完成训练"
      class="general-card"
      :header-style="{ paddingBottom: '0' }"
      :body-style="{ padding: '17px 20px 21px 20px' }"
    >
      <a-empty v-if="trainList.length === 0 || trainList == null" />
      <a-table
        v-if="trainList.length !== 0"
        :columns="columns"
        :data="trainList"
        :bordered="false"
        :scrollbar="true"
        :pagination="{
          showTotal: true,
          showPageSize: true,
          total: pageInfo.total,
          pageSize: pageInfo.pageSize,
          current: pageInfo.pageNo,
        }"
        :scroll="{ x: 100, y: 400 }"
        @page-change="pageChange"
        @page-size-change="pageSizeChange"
      >
        <template #operation="{ record }">
          <a-button type="primary" @click="continueTrain(record)">
            继续训练
          </a-button>
        </template>
      </a-table>
      <!-- <a-list v-if="trainList.length !== 0" :scrollbar="true" :max-height="280">
        <template v-for="train in trainList" :key="train.id">
          <a-list-item>
            <template #actions>
              <a-space
                @click="
                  router.push({
                    name: 'StartTrain',
                    params: {
                      trainId: train.id,
                    },
                  })
                "
              >
                <icon-play-circle
                  :stroke-width="2"
                  style="font-size: 25px; cursor: pointer"
                />
                继续训练
              </a-space>
            </template>
            {{ train.mode }}
          </a-list-item>
        </template>
      </a-list>
      <a-pagination
        style="bottom: 0"
        :show-page-size="true"
        :show-total="true"
        :total="pageInfo.total"
        :page-size="pageInfo.pageSize"
        @page-size-change="pageSizeChange"
        @change="pageChange"
      />-->
    </a-card>
  </a-spin>
</template>

<script lang="ts" setup>
  import { onMounted, ref, watch } from 'vue';
  import { Train } from '@/types/model/po/Train';
  import { useUserStore } from '@/store';
  import { getTrain } from '@/api/train';
  import { Message } from '@arco-design/web-vue';
  import { useRouter } from 'vue-router';
  import { SimplePage } from '@/types/model/po/SimplePage';
  import { TrainQuery } from '@/types/model/query/TrainQuery';

  const router = useRouter();
  const userStore = useUserStore();
  const trainList = ref<Train[]>([]);
  const loading = ref(false);
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 5,
    pageTotal: 0,
    total: 0,
  });

  const columns = [
    {
      title: '训练模式',
      dataIndex: 'mode',
    },
    {
      title: '操作',
      dataIndex: 'operation',
      slotName: 'operation',
    },
  ];

  const reloadTrainRecordList = async (trainQuery: TrainQuery) => {
    loading.value = true;
    // 获取未完成的训练记录
    await getTrain(trainQuery).then((res: any) => {
      if (res) {
        trainList.value = res.data.list;
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
    loading.value = false;
  };

  onMounted(async () => {
    await reloadTrainRecordList({
      userId: userStore.id,
      state: 0,
      ...pageInfo.value,
    });
  });

  // 继续训练
  const continueTrain = (record: any) => {
    router.push({
      name: 'StartTrain',
      params: {
        trainId: record.id,
      },
    });
  };

  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
  };

  // 监视查询数据及其页码变化
  watch(
    pageInfo.value,
    async (newPageInfo, oldPageInfo) => {
      await reloadTrainRecordList({
        userId: userStore.id,
        state: 0,
        ...pageInfo.value,
      });
    },
    { deep: true }
  );
</script>

<style scoped lang="less">
  .general-card {
    min-height: 395px;
  }
  :deep(.arco-table-tr) {
    height: 44px;
    .arco-typography {
      margin-bottom: 0;
    }
  }
  .increases-cell {
    display: flex;
    align-items: center;
    span {
      margin-right: 4px;
    }
  }
</style>
